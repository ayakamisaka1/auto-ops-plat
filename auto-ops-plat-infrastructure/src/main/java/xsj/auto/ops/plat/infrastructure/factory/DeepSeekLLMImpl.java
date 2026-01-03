package xsj.auto.ops.plat.infrastructure.factory;

import xsj.auto.ops.plat.domain.entity.LlmfactoryEntity.ChatModelWrapper;
import xsj.auto.ops.plat.domain.entity.LlmfactoryEntity.LLMCapability;

public class DeepSeekLLMImpl extends LLMCapabilityFactoryImpl{

    @Override
    protected ChatModelWrapper SDKConnectionLLM(LLMCapability llmCapability) {
        // 先不实现
        throw new UnsupportedOperationException("DeepSeek 暂不支持扩展能力 SDK");
    }
}
