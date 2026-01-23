package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.RagChunk;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagChunk;

@Component
public class RagChunkMapper {

    public RagChunk toJpa(RagChunk chunk) {
        RagChunk po = new RagChunk();
        if (chunk.getId() != null) {
            po.setId(chunk.getId());
        }
        po.setDocumentId(chunk.getDocumentId());
        po.setChunkIndex(chunk.getChunkIndex());
        po.setContent(chunk.getContent());
        po.setTokenSize(chunk.getTokenSize());
        po.setChunkStrategy(chunk.getChunkStrategy());
        po.setMeta(chunk.getMeta());
        return po;
    }

    public RagChunk toDomain(RagChunk po) {
        return RagChunk.create(
                po.getId(),
                po.getDocumentId(),
                po.getChunkIndex(),
                po.getContent(),
                po.getTokenSize(),
                po.getChunkStrategy(),
                po.getMeta()
        );
    }
}
