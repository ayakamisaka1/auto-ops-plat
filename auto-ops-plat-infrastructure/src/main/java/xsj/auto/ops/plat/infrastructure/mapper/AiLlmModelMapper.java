package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.LlmFactoryEntity.AiLlmModel;
import xsj.auto.ops.plat.infrastructure.jpaEntity.llm.AiLlmModelPO;

@Component
public class AiLlmModelMapper {

    public AiLlmModelPO toJpa(AiLlmModel model) {
        AiLlmModelPO po = new AiLlmModelPO();
        if (model.getId() != null) {
            po.setId(model.getId());
        }
        po.setProviderId(model.getProviderId());
        po.setModelCode(model.getModelCode());
        po.setModelName(model.getModelName());
        po.setModelVersion(model.getModelVersion());
        po.setModelType(model.getModelType());
        po.setContextLength(model.getContextLength());
        po.setMaxOutputTokens(model.getMaxOutputTokens());
        po.setSupportsStream(model.getSupportsStream());
        po.setSupportsFunctionCall(model.getSupportsFunctionCall());
        po.setSupportsVision(model.getSupportsVision());
        po.setStatus(model.getStatus());
        po.setDescription(model.getDescription());
        return po;
    }

    public AiLlmModel toDomain(AiLlmModelPO po) {
        return AiLlmModel.restore(
                po.getId(),
                po.getProviderId(),
                po.getModelCode(),
                po.getModelName(),
                po.getModelVersion(),
                po.getModelType(),
                po.getContextLength(),
                po.getMaxOutputTokens(),
                po.getSupportsStream(),
                po.getSupportsFunctionCall(),
                po.getSupportsVision(),
                po.getStatus(),
                po.getDescription()
        );
    }
}