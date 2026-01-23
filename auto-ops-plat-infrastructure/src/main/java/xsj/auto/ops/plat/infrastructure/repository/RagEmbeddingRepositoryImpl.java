package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.RagEmbedding;
import xsj.auto.ops.plat.domain.repository.RagEmbeddingRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagEmbeddingPO;
import xsj.auto.ops.plat.infrastructure.mapper.RagEmbeddingMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RagEmbeddingRepositoryImpl implements RagEmbeddingRepository {

    private final RagEmbeddingJpaRepository ragEmbeddingJpaRepository;
    private final RagEmbeddingMapper ragEmbeddingMapper;

    @Override
    public void save(RagEmbedding ragEmbedding) {
        RagEmbeddingPO po = ragEmbeddingMapper.toJpa(ragEmbedding);
        RagEmbeddingPO saved = ragEmbeddingJpaRepository.save(po);
        ragEmbedding.assignId(saved.getId());
    }

    @Override
    public Optional<RagEmbedding> findById(Long id) {
        return ragEmbeddingJpaRepository.findById(id)
                .map(ragEmbeddingMapper::toDomain);
    }

    @Override
    public List<RagEmbedding> findAll() {
        return ragEmbeddingJpaRepository.findAll().stream()
                .map(ragEmbeddingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        ragEmbeddingJpaRepository.deleteById(id);
    }

    @Override
    public List<RagEmbedding> findByChunkId(Long chunkId) {
        return ragEmbeddingJpaRepository.findByChunkId(chunkId).stream()
                .map(ragEmbeddingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<RagEmbedding> findByEmbeddingModelId(Long embeddingModelId) {
        return ragEmbeddingJpaRepository.findByEmbeddingModelId(embeddingModelId).stream()
                .map(ragEmbeddingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<RagEmbedding> findByStatus(String status) {
        return ragEmbeddingJpaRepository.findByStatus(status).stream()
                .map(ragEmbeddingMapper::toDomain)
                .collect(Collectors.toList());
    }
}
