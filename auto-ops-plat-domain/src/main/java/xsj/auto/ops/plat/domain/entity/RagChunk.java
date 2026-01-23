package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class RagChunk {

    private Long id;
    private Long documentId;
    private Integer chunkIndex;
    private String content;
    private Integer tokenSize;
    private String chunkStrategy;
    private String meta;

    private RagChunk(Long id, Long documentId, Integer chunkIndex, String content,
                    Integer tokenSize, String chunkStrategy, String meta) {
        this.id = id;
        this.documentId = documentId;
        this.chunkIndex = chunkIndex;
        this.content = content;
        this.tokenSize = tokenSize;
        this.chunkStrategy = chunkStrategy;
        this.meta = meta;
    }

    public static RagChunk create(Long id, Long documentId, Integer chunkIndex, String content,
                               Integer tokenSize, String chunkStrategy, String meta) {
        return new RagChunk(id, documentId, chunkIndex, content, tokenSize, chunkStrategy, meta);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
