package xsj.auto.ops.plat.infrastructure.repository.llm;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.llm.AiLlmEndpointPO;

import java.util.List;

public interface AiLlmEndpointJpaRepository extends JpaRepository<AiLlmEndpointPO, Long> {
    List<AiLlmEndpointPO> findByAiLlmModelPO_Id(Long modelId);
    List<AiLlmEndpointPO> findByCapabilityType(String capabilityType);
    List<AiLlmEndpointPO> findByStatus(String status);
}
