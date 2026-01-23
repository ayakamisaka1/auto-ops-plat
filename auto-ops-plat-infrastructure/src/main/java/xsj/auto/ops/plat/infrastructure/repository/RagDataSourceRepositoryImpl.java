package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.RagDataSource;
import xsj.auto.ops.plat.domain.repository.RagDataSourceRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagDataSourcePO;
import xsj.auto.ops.plat.infrastructure.mapper.RagDataSourceMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RagDataSourceRepositoryImpl implements RagDataSourceRepository {

    private final RagDataSourceJpaRepository ragDataSourceJpaRepository;
    private final RagDataSourceMapper ragDataSourceMapper;

    @Override
    public void save(RagDataSource dataSource) {
        RagDataSourcePO po = ragDataSourceMapper.toJpa(dataSource);
        RagDataSourcePO saved = ragDataSourceJpaRepository.save(po);
        dataSource.assignId(saved.getId());
    }

    @Override
    public Optional<RagDataSource> findById(Long id) {
        return ragDataSourceJpaRepository.findById(id)
                .map(ragDataSourceMapper::toDomain);
    }

    @Override
    public List<RagDataSource> findAll() {
        return ragDataSourceJpaRepository.findAll().stream()
                .map(ragDataSourceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        ragDataSourceJpaRepository.deleteById(id);
    }

    @Override
    public Optional<RagDataSource> findBySourceName(String sourceName) {
        return ragDataSourceJpaRepository.findBySourceName(sourceName)
                .map(ragDataSourceMapper::toDomain);
    }

    @Override
    public List<RagDataSource> findBySourceType(String sourceType) {
        return ragDataSourceJpaRepository.findBySourceType(sourceType).stream()
                .map(ragDataSourceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<RagDataSource> findByEnabled(Boolean enabled) {
        return ragDataSourceJpaRepository.findByEnabled(enabled).stream()
                .map(ragDataSourceMapper::toDomain)
                .collect(Collectors.toList());
    }
}
