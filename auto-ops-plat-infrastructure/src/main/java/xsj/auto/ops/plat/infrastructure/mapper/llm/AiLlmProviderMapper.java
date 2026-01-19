package xsj.auto.ops.plat.infrastructure.mapper.llm;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.LlmFactoryEntity.AiLlmProvider;
import xsj.auto.ops.plat.infrastructure.jpaEntity.llm.AiLlmProviderPO;
import xsj.auto.ops.plat.types.enums.AuthType;
import xsj.auto.ops.plat.types.enums.ProviderStatus;
import xsj.auto.ops.plat.types.enums.ProviderType;

@Component
public class AiLlmProviderMapper {
    public AiLlmProviderPO toJpa(AiLlmProvider aiLlmProvider){
        if (aiLlmProvider == null) {
            return null;
        }

        AiLlmProviderPO po = new AiLlmProviderPO();
        po.setProviderCode(aiLlmProvider.getProviderCode());
        po.setProviderName(aiLlmProvider.getProviderName());
        po.setProviderType(aiLlmProvider.getProviderType().name());
        po.setBaseUrl(aiLlmProvider.getBaseUrl());
        po.setAuthType(aiLlmProvider.getAuthType().name());
        po.setStatus(aiLlmProvider.getStatus().name());
        po.setDescription(aiLlmProvider.getDescription());

        return po;
    }

    public AiLlmProvider toDomain(AiLlmProviderPO aiLlmProviderPO){
        if (aiLlmProviderPO == null) {
            return null;
        }

        return AiLlmProvider.restore(
                aiLlmProviderPO.getProviderCode(),
                aiLlmProviderPO.getProviderName(),
                ProviderType.valueOf(aiLlmProviderPO.getProviderType()),
                aiLlmProviderPO.getBaseUrl(),
                AuthType.valueOf(aiLlmProviderPO.getAuthType()),
                ProviderStatus.valueOf(aiLlmProviderPO.getStatus()),
                aiLlmProviderPO.getDescription()
        );
    }
}
