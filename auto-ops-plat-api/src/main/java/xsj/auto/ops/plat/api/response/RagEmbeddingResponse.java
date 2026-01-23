package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RagEmbeddingResponse {

    private Long id;
    private Long chunkId;
    private Long embeddingModelId;
    private String vector;
    private Integer vectorDim;
    private String status;
}
