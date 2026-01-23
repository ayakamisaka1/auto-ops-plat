package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.RagChunk;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagChunkPO;

@Component
public class RagChunkMapper {

    public RagChunkPO toJpa(RagChunk chunk) {
        RagChunkPO po = new RagChunkPO();
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

    public RagChunk toDomain(RagChunkPO po) {
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
