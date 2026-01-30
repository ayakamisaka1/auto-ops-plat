package xsj.auto.ops.plat.infrastructure.jpaEntity.rag;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

@Entity
@Table(name = "rag_embedding")
@Getter
@Setter
@Comment("RAG 向量表：Chunk 的向量化结果")
public class RagEmbeddingPO extends BaseJpaEntity {
    @Column(nullable = false)
    @Comment("所属 Chunk ID")
    private Long chunkId;

    @Column(nullable = false)
    @Comment("Embedding 模型ID（关联大模型表）")
    private Long embeddingModelId;

    @Column(columnDefinition = "TEXT")
    @Comment("向量数据（JSON / Base64 / 外部向量库ID）")
    private String vector;

    @Comment("向量维度")
    private Integer vectorDim;

    @Column(length = 32)
    @Comment("状态：ACTIVE / DISABLED")
    private String status;
}
