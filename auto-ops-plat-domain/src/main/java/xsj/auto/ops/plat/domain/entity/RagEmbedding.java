package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class RagEmbedding {

    private Long id;
    private Long chunkId;
    private Long embeddingModelId;
    private String vector;
    private Integer vectorDim;
    private String status;

    private RagEmbedding(Long id, Long chunkId, Long embeddingModelId, String vector, Integer vectorDim, String status) {
        this.id = id;
        this.chunkId = chunkId;
        this.embeddingModelId = embeddingModelId;
        this.vector = vector;
        this.vectorDim = vectorDim;
        this.status = status;
    }

    public static RagEmbedding create(Long id, Long chunkId, Long embeddingModelId, String vector, Integer vectorDim, String status) {
        return new RagEmbedding(id, chunkId, embeddingModelId, vector, vectorDim, status);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
