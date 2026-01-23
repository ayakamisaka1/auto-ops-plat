package xsj.auto.ops.plat.infrastructure.factory.llm;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.domain.entity.LlmFactoryEntity.ChatModelWrapper;
import xsj.auto.ops.plat.domain.entity.LlmFactoryEntity.LLMCapability;
import xsj.auto.ops.plat.domain.factory.LLMCapabilityFactory;
import xsj.auto.ops.plat.types.factory.CapabilityTypeEnum;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * LLM能力工厂抽象实现类
 * <p>
 * 该类是LLM能力工厂的核心实现，负责根据LLM能力配置创建对应的ChatModel实例
 * 所有大模型统一使用OpenAI协议接入
 * </p>
 */
@Service
public abstract class LLMCapabilityFactoryImpl implements LLMCapabilityFactory {

    /**
     * 创建LLM实例
     * <p>
     * 核心逻辑：
     * 1. 统一使用OpenAI协议接入所有大模型
     * 2. 动态装配endpoint路径
     * 3. 构建并返回ChatModelWrapper
     * </p>
     *
     * @param llmCapability LLM能力配置
     * @return ChatModelWrapper实例，包含创建的ChatModel
     */
    @Override
    public ChatModelWrapper createLLM(LLMCapability llmCapability) {
        // 将endpoint列表转换为Map，便于根据能力类型查找
        Map<CapabilityTypeEnum, LLMCapability.Endpoint> endpointMap = endpointMap(llmCapability.getEndpoints());

        // 构建OpenAiApi实例
        OpenAiApi.Builder apiBuilder = OpenAiApi.builder()
                .baseUrl(llmCapability.getBaseUrl())
                .apiKey(llmCapability.getKey());

        // 按能力动态装配endpoint路径
        if (endpointMap.containsKey(CapabilityTypeEnum.CHAT)) {
            apiBuilder.completionsPath(endpointMap.get(CapabilityTypeEnum.CHAT).getPath());
        }

        if (endpointMap.containsKey(CapabilityTypeEnum.EMBEDDING)) {
            apiBuilder.embeddingsPath(endpointMap.get(CapabilityTypeEnum.EMBEDDING).getPath());
        }

        OpenAiApi openAiApi = apiBuilder.build();

        // 构建ChatModel实例
        ChatModel chatModel = OpenAiChatModel.builder()
                .openAiApi(openAiApi)
                .defaultOptions(OpenAiChatOptions.builder()
                        .model(llmCapability.getModelCode())
                        .build())
                .build();

        // 返回包装后的ChatModel
        return new ChatModelWrapper(chatModel);
    }

    /**
     * 将endpoint列表转换为Map
     * <p>
     * key: CapabilityTypeEnum（能力类型）
     * value: LLMCapability.Endpoint（能力端点）
     * </p>
     * 
     * @param endpoints 能力端点列表
     * @return 能力类型到端点的映射
     */
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
