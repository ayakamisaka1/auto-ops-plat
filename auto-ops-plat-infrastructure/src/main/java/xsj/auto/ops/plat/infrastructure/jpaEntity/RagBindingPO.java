package xsj.auto.ops.plat.infrastructure.jpaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "rag_binding")
@Getter
@Setter
@Comment("RAG 绑定表：将 RAG 能力绑定到 Agent / Flow / Node")
public class RagBindingPO extends BaseJpaEntity{
    @Column(nullable = false, length = 32)
    @Comment("绑定类型：AGENT / FLOW / NODE")
    private String bindType;

    @Column(nullable = false)
    @Comment("绑定目标ID（agent_id / flow_id / node_id）")
    private Long bindId;

    @Column(nullable = false)
    @Comment("数据源ID")
    private Long dataSourceId;

    @Column(nullable = false)
    @Comment("检索策略ID")
    private Long retrievalStrategyId;

    @Comment("优先级（数值越小优先级越高）")
    private Integer priority;

    @Comment("是否启用")
    private Boolean enabled = true;
}
