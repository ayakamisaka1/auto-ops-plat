package xsj.auto.ops.plat.infrastructure.factory;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.domain.entity.LlmfactoryEntity.ChatModelWrapper;
import xsj.auto.ops.plat.domain.entity.LlmfactoryEntity.LLMCapability;
import xsj.auto.ops.plat.domain.factory.LLMCapabilityFactory;
import xsj.auto.ops.plat.types.factory.CapabilityTypeEnum;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public abstract class LLMCapabilityFactoryImpl implements LLMCapabilityFactory {

    /*现在所有的大模型支持走openai来接入  所以直接在抽象类里面用openai来接入了（这是第一版）
     * 经过分析 springboot-ai-openai这个依赖链接大模型时只能使用向量能力和对话能力  有限的能力
     * 所以修改为  按接入能力来区分是否使用大模型对应sdk接入
     * */
    @Override
    public ChatModelWrapper createLLM(LLMCapability llmCapability) {
        // 是否存在扩展能力
        List<LLMCapability.Endpoint> endpoints = llmCapability.getEndpoints();
        boolean hasExtendedCapability = endpoints.stream()
                .anyMatch(e ->
                        !CapabilityTypeEnum.CHAT.name().equals(e.getCapabilityType())
                                && !CapabilityTypeEnum.EMBEDDING.name().equals(e.getCapabilityType())
                );

        // 👉 有扩展能力：必须走 SDK
        if (hasExtendedCapability) {
            return SDKConnectionLLM(llmCapability);
        }
        // 👉 仅 CHAT / EMBEDDING：OpenAI 协议接入
        Map<CapabilityTypeEnum, LLMCapability.Endpoint> endpointMap = endpointMap(endpoints);
        OpenAiApi.Builder apiBuilder = OpenAiApi.builder()
                .baseUrl(llmCapability.getBaseUrl())
                .apiKey(llmCapability.getKey());
        // ⭐ 按能力动态装配 endpoint
        if (endpointMap.containsKey(CapabilityTypeEnum.CHAT)) {
            apiBuilder.completionsPath(endpointMap.get(CapabilityTypeEnum.CHAT).getPath());
        }

        if (endpointMap.containsKey(CapabilityTypeEnum.EMBEDDING)) {
            apiBuilder.embeddingsPath(endpointMap.get(CapabilityTypeEnum.EMBEDDING).getPath());
        }
        OpenAiApi openAiApi = apiBuilder.build();

        ChatModel chatModel = OpenAiChatModel.builder()
                    .openAiApi(openAiApi)
                    .defaultOptions(OpenAiChatOptions.builder()
                            .model(llmCapability.getModelCode())
                            .build())
                    .build();
            return new ChatModelWrapper(chatModel);
    }

    protected abstract ChatModelWrapper SDKConnectionLLM(LLMCapability llmCapability);


    private Map<CapabilityTypeEnum, LLMCapability.Endpoint> endpointMap(
            List<LLMCapability.Endpoint> endpoints) {

        if (endpoints == null || endpoints.isEmpty()) {
            return Map.of();
        }

        return endpoints.stream()
                .filter(e -> e.getCapabilityType() != null)
                .collect(Collectors.toMap(
                        e -> CapabilityTypeEnum.valueOf(e.getCapabilityType()),
                        Function.identity(),
                        // 如果同一种能力配置了多个 endpoint，默认取第一个
                        (existing, replacement) -> existing
                ));
    }
}
