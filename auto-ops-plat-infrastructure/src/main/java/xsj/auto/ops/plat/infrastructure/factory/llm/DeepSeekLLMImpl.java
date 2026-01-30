package xsj.auto.ops.plat.infrastructure.factory.llm;

import xsj.auto.ops.plat.domain.entity.LlmFactoryEntity.ChatModelWrapper;
import xsj.auto.ops.plat.domain.entity.LlmFactoryEntity.LLMCapability;

public class DeepSeekLLMImpl extends LLMCapabilityFactoryImpl{

    @Override
    protected ChatModelWrapper SDKConnectionLLM(LLMCapability llmCapability) {
        // 先不实现
        throw new UnsupportedOperationException("DeepSeek 暂不支持扩展能力 SDK");
    }
}
