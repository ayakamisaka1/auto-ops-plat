package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.RagEmbedding;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagEmbeddingPO;

@Component
public class RagEmbeddingMapper {

    public RagEmbeddingPO toJpa(RagEmbedding ragEmbedding) {
        RagEmbeddingPO po = new RagEmbeddingPO();
        if (ragEmbedding.getId() != null) {
            po.setId(ragEmbedding.getId());
        }
        po.setChunkId(ragEmbedding.getChunkId());
        po.setEmbeddingModelId(ragEmbedding.getEmbeddingModelId());
        po.setVector(ragEmbedding.getVector());
        po.setVectorDim(ragEmbedding.getVectorDim());
        po.setStatus(ragEmbedding.getStatus());
        return po;
    }

    public RagEmbedding toDomain(RagEmbeddingPO po) {
        return RagEmbedding.create(
                po.getId(),
                po.getChunkId(),
                po.getEmbeddingModelId(),
                po.getVector(),
                po.getVectorDim(),
                po.getStatus()
        );
    }
}
