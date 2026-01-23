package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagChunk;

import java.util.List;

public interface RagChunkJpaRepository extends JpaRepository<RagChunk, Long> {
    List<RagChunk> findByDocumentId(Long documentId);
    List<RagChunk> findByChunkStrategy(String chunkStrategy);
}
