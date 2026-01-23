package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.LlmFactoryEntity.AiLlmEndpoint;
import xsj.auto.ops.plat.infrastructure.jpaEntity.llm.AiLlmEndpointPO;

@Component
public class AiLlmEndpointMapper {

    public AiLlmEndpointPO toJpa(AiLlmEndpoint endpoint) {
        AiLlmEndpointPO po = new AiLlmEndpointPO();
        if (endpoint.getId() != null) {
            po.setId(endpoint.getId());
        }
        //po.setAiLlmModelPO(endpoint.getModelId());
        po.setCapabilityType(endpoint.getCapabilityType());
        po.setHttpMethod(endpoint.getHttpMethod());
        po.setPath(endpoint.getPath());
        po.setStatus(endpoint.getStatus());
        po.setDescription(endpoint.getDescription());
        return po;
    }

    public AiLlmEndpoint toDomain(AiLlmEndpointPO po) {
        return AiLlmEndpoint.restore(
                po.getId(),
                po.getAiLlmModelPO().getId(),
                po.getCapabilityType(),
                po.getHttpMethod(),
                po.getPath(),
                po.getStatus(),
                po.getDescription()
        );
    }
}