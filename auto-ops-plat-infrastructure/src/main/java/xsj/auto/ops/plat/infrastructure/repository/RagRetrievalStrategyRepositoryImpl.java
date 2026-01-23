package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.RagRetrievalStrategy;
import xsj.auto.ops.plat.domain.repository.RagRetrievalStrategyRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagRetrievalStrategyPO;
import xsj.auto.ops.plat.infrastructure.mapper.RagRetrievalStrategyMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RagRetrievalStrategyRepositoryImpl implements RagRetrievalStrategyRepository {

    private final RagRetrievalStrategyJpaRepository ragRetrievalStrategyJpaRepository;
    private final RagRetrievalStrategyMapper ragRetrievalStrategyMapper;

    @Override
    public void save(RagRetrievalStrategy strategy) {
        RagRetrievalStrategyPO po = ragRetrievalStrategyMapper.toJpa(strategy);
        RagRetrievalStrategyPO saved = ragRetrievalStrategyJpaRepository.save(po);
        strategy.assignId(saved.getId());
    }

    @Override
    public Optional<RagRetrievalStrategy> findById(Long id) {
        return ragRetrievalStrategyJpaRepository.findById(id)
                .map(ragRetrievalStrategyMapper::toDomain);
    }

    @Override
    public List<RagRetrievalStrategy> findAll() {
        return ragRetrievalStrategyJpaRepository.findAll().stream()
                .map(ragRetrievalStrategyMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        ragRetrievalStrategyJpaRepository.deleteById(id);
    }

    @Override
    public Optional<RagRetrievalStrategy> findByStrategyName(String strategyName) {
        return ragRetrievalStrategyJpaRepository.findByStrategyName(strategyName)
                .map(ragRetrievalStrategyMapper::toDomain);
    }
}
