package xsj.auto.ops.plat.infrastructure.jpaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "rag_chunk")
@Getter
@Setter
@Comment("RAG 文档切分表：最小可检索语义单元")
public class RagChunk extends BaseJpaEntity{
    @Column(nullable = false)
    @Comment("所属文档ID")
    private Long documentId;

    @Comment("Chunk 顺序索引")
    private Integer chunkIndex;

    @Column(columnDefinition = "TEXT", nullable = false)
    @Comment("切分后的文本内容")
    private String content;

    @Comment("Token 数量")
    private Integer tokenSize;

    @Column(length = 32)
    @Comment("切分策略：FIXED / SEMANTIC / QA / CODE")
    private String chunkStrategy;

    @Column(columnDefinition = "TEXT")
    @Comment("Chunk 元数据(JSON)：章节、标题、业务字段等")
    private String meta;
}
