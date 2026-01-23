package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class RagChunkRequest {

    private Long id;
    private Long documentId;
    private Integer chunkIndex;
    private String content;
    private Integer tokenSize;
    private String chunkStrategy;
    private String meta;
}
