package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagEmbeddingPO;

import java.util.List;

public interface RagEmbeddingJpaRepository extends JpaRepository<RagEmbeddingPO, Long> {
    List<RagEmbeddingPO> findByChunkId(Long chunkId);
    List<RagEmbeddingPO> findByEmbeddingModelId(Long embeddingModelId);
    List<RagEmbeddingPO> findByStatus(String status);
}
