package xsj.auto.ops.plat.domain.service.llmService;

import xsj.auto.ops.plat.domain.entity.LlmFactoryEntity.AiLlmProvider;

public interface AiLlmProviderDomainService {
    void checkCreate(AiLlmProvider aiLlmProvider);
}
