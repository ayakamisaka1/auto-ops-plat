package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.RagDocument;
import xsj.auto.ops.plat.domain.repository.RagDocumentRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagDocumentPO;
import xsj.auto.ops.plat.infrastructure.mapper.RagDocumentMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RagDocumentRepositoryImpl implements RagDocumentRepository {

    private final RagDocumentJpaRepository ragDocumentJpaRepository;
    private final RagDocumentMapper ragDocumentMapper;

    @Override
    public void save(RagDocument document) {
        RagDocumentPO po = ragDocumentMapper.toJpa(document);
        RagDocumentPO saved = ragDocumentJpaRepository.save(po);
        document.assignId(saved.getId());
    }

    @Override
    public Optional<RagDocument> findById(Long id) {
        return ragDocumentJpaRepository.findById(id)
                .map(ragDocumentMapper::toDomain);
    }

    @Override
    public List<RagDocument> findAll() {
        return ragDocumentJpaRepository.findAll().stream()
                .map(ragDocumentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        ragDocumentJpaRepository.deleteById(id);
    }

    @Override
    public List<RagDocument> findBySourceId(Long sourceId) {
        return ragDocumentJpaRepository.findBySourceId(sourceId).stream()
                .map(ragDocumentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<RagDocument> findByDocType(String docType) {
        return ragDocumentJpaRepository.findByDocType(docType).stream()
                .map(ragDocumentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<RagDocument> findByStatus(String status) {
        return ragDocumentJpaRepository.findByStatus(status).stream()
                .map(ragDocumentMapper::toDomain)
                .collect(Collectors.toList());
    }
}
