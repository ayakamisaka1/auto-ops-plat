package xsj.auto.ops.plat.infrastructure.factory;

import xsj.auto.ops.plat.domain.entity.LlmfactoryEntity.ChatModelWrapper;
import xsj.auto.ops.plat.domain.entity.LlmfactoryEntity.LLMCapability;

public class OpenaiLLMImpl extends LLMCapabilityFactoryImpl {

    @Override
    protected ChatModelWrapper SDKConnectionLLM(LLMCapability llmCapability) {
        // 先不实现
        throw new UnsupportedOperationException("openai 暂不支持扩展能力 SDK");
    }
}
