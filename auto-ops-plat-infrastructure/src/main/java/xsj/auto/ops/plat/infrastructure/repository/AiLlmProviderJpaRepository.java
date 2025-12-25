package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.AiLlmProviderPO;

public interface AiLlmProviderJpaRepository extends JpaRepository<AiLlmProviderPO, Long> {
    boolean existsByProviderCode(String providerCode);
}
