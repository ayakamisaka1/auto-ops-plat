package xsj.auto.ops.plat.infrastructure.jpaEntity.rag;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

@Entity
@Table(name = "rag_document")
@Getter
@Setter
@Comment("RAG 文档表：原始可检索文档")
public class RagDocumentPO extends BaseJpaEntity {
    @Column(nullable = false)
    @Comment("所属数据源ID")
    private Long sourceId;

    @Column(nullable = false, length = 256)
    @Comment("文档名称")
    private String docName;

    @Column(length = 32)
    @Comment("文档类型：PDF / MD / HTML / TXT / ROW / JSON")
    private String docType;

    @Column(columnDefinition = "TEXT")
    @Comment("原始文档内容（或存储外部地址）")
    private String rawContent;

    @Column(columnDefinition = "TEXT")
    @Comment("文档元数据(JSON)：作者、时间、业务标签等")
    private String meta;

    @Column(length = 32)
    @Comment("处理状态：NEW / PARSED / EMBEDDED")
    private String status;

    @Comment("文档版本号")
    private Integer version;
}
