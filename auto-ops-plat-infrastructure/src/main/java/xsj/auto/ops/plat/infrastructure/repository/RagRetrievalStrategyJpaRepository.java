package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagRetrievalStrategyPO;

import java.util.Optional;

public interface RagRetrievalStrategyJpaRepository extends JpaRepository<RagRetrievalStrategyPO, Long> {
    Optional<RagRetrievalStrategyPO> findByStrategyName(String strategyName);
}
