package xsj.auto.ops.plat.domain.factory;

import xsj.auto.ops.plat.domain.entity.LlmfactoryEntity.ChatModelWrapper;
import xsj.auto.ops.plat.domain.entity.LlmfactoryEntity.LLMCapability;

public interface LLMCapabilityFactory {
    /**
     * 根据模型 ID 创建 LlmCapability
     */
    ChatModelWrapper createLLM(LLMCapability llmCapability);
}
