package xsj.auto.ops.plat.infrastructure.jpaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "rag_retrieval_strategy")
@Getter
@Setter
@Comment("RAG 检索策略表：定义如何召回 + 组织上下文")
public class RagRetrievalStrategyPO extends BaseJpaEntity{
    @Column(nullable = false, length = 128)
    @Comment("策略名称")
    private String strategyName;

    @Comment("召回条数 TopK")
    private Integer topK;

    @Comment("相似度阈值")
    private Double scoreThreshold;

    @Column(columnDefinition = "TEXT")
    @Comment("过滤条件(JSON)：标签、来源、时间、业务字段")
    private String filterCondition;

    @Comment("重排模型ID（可选）")
    private Long rerankModelId;

    @Column(columnDefinition = "TEXT")
    @Comment("上下文 Prompt 模板")
    private String promptTemplate;
}
