package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.RagDocument;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagDocumentPO;

@Component
public class RagDocumentMapper {

    public RagDocumentPO toJpa(RagDocument document) {
        RagDocumentPO po = new RagDocumentPO();
        if (document.getId() != null) {
            po.setId(document.getId());
        }
        po.setSourceId(document.getSourceId());
        po.setDocName(document.getDocName());
        po.setDocType(document.getDocType());
        po.setRawContent(document.getRawContent());
        po.setMeta(document.getMeta());
        po.setStatus(document.getStatus());
        po.setVersion(document.getVersion());
        return po;
    }

    public RagDocument toDomain(RagDocumentPO po) {
        return RagDocument.create(
                po.getId(),
                po.getSourceId(),
                po.getDocName(),
                po.getDocType(),
                po.getRawContent(),
                po.getMeta(),
                po.getStatus(),
                po.getVersion()
        );
    }
}
