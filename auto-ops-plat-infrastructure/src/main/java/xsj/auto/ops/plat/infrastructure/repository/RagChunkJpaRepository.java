package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagChunkPO;

import java.util.List;

public interface RagChunkJpaRepository extends JpaRepository<RagChunkPO, Long> {
    List<RagChunkPO> findByDocumentId(Long documentId);
    List<RagChunkPO> findByChunkStrategy(String chunkStrategy);
}
