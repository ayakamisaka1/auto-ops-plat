package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.RagDocument;

import java.util.List;
import java.util.Optional;

public interface RagDocumentRepository {

    void save(RagDocument document);

    Optional<RagDocument> findById(Long id);

    List<RagDocument> findAll();

    void deleteById(Long id);

    List<RagDocument> findBySourceId(Long sourceId);

    List<RagDocument> findByDocType(String docType);

    List<RagDocument> findByStatus(String status);
}
