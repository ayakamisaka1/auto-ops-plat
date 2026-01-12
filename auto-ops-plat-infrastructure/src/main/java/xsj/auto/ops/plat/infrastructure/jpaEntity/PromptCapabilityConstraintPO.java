package xsj.auto.ops.plat.infrastructure.jpaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
@Getter
@Setter
@Entity
@Table(name = "prompt_capability_constraint")
@Comment("Prompt 能力约束表：限制或强化 LLM 行为")
public class PromptCapabilityConstraintPO extends BaseJpaEntity{

    @Column(nullable = false)
    @Comment("Prompt ID")
    private Long promptId;

    @Column(length = 64)
    @Comment("能力类型：TOOL_CALL / RAG_USE / MEMORY_WRITE / FORMAT_OUTPUT")
    private String capabilityType;

    @Column(columnDefinition = "TEXT")
    @Comment("能力约束规则(JSON)")
    private String constraintRule;
}
