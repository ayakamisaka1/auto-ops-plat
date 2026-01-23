package xsj.auto.ops.plat.infrastructure.repository.llm;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.llm.AiLlmModelPO;

import java.util.List;
import java.util.Optional;

public interface AiLlmModelJpaRepository extends JpaRepository<AiLlmModelPO, Long> {
    List<AiLlmModelPO> findByProviderId(Long providerId);
    List<AiLlmModelPO> findByModelType(String modelType);
    List<AiLlmModelPO> findByStatus(String status);
    Optional<AiLlmModelPO> findByModelCodeAndProviderId(String modelCode, Long providerId);
    List<AiLlmModelPO> findByProviderIdAndStatus(Long providerId, String status);
}
