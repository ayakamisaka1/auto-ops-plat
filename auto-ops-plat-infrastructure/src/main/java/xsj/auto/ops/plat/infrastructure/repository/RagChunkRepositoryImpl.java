package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.RagChunk;
import xsj.auto.ops.plat.domain.repository.RagChunkRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagChunk;
import xsj.auto.ops.plat.infrastructure.mapper.RagChunkMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RagChunkRepositoryImpl implements RagChunkRepository {

    private final RagChunkJpaRepository ragChunkJpaRepository;
    private final RagChunkMapper ragChunkMapper;

    @Override
    public void save(RagChunk chunk) {
        RagChunk po = ragChunkMapper.toJpa(chunk);
        RagChunk saved = ragChunkJpaRepository.save(po);
        chunk.assignId(saved.getId());
    }

    @Override
    public Optional<RagChunk> findById(Long id) {
        return ragChunkJpaRepository.findById(id)
                .map(ragChunkMapper::toDomain);
    }

    @Override
    public List<RagChunk> findAll() {
        return ragChunkJpaRepository.findAll().stream()
                .map(ragChunkMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        ragChunkJpaRepository.deleteById(id);
    }

    @Override
    public List<RagChunk> findByDocumentId(Long documentId) {
        return ragChunkJpaRepository.findByDocumentId(documentId).stream()
                .map(ragChunkMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<RagChunk> findByChunkStrategy(String chunkStrategy) {
        return ragChunkJpaRepository.findByChunkStrategy(chunkStrategy).stream()
                .map(ragChunkMapper::toDomain)
                .collect(Collectors.toList());
    }
}
