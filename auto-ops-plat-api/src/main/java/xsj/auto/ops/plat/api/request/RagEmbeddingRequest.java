package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class RagEmbeddingRequest {

    private Long id;
    private Long chunkId;
    private Long embeddingModelId;
    private String vector;
    private Integer vectorDim;
    private String status;
}
