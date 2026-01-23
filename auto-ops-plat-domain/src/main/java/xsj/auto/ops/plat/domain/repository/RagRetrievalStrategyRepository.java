package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.RagRetrievalStrategy;

import java.util.List;
import java.util.Optional;

public interface RagRetrievalStrategyRepository {

    void save(RagRetrievalStrategy strategy);

    Optional<RagRetrievalStrategy> findById(Long id);

    List<RagRetrievalStrategy> findAll();

    void deleteById(Long id);

    Optional<RagRetrievalStrategy> findByStrategyName(String strategyName);
}
