package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagDocumentPO;

import java.util.List;

public interface RagDocumentJpaRepository extends JpaRepository<RagDocumentPO, Long> {
    List<RagDocumentPO> findBySourceId(Long sourceId);
    List<RagDocumentPO> findByDocType(String docType);
    List<RagDocumentPO> findByStatus(String status);
}
