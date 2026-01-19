package xsj.auto.ops.plat.infrastructure.jpaEntity.prompt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

@Getter
@Setter
@Entity
@Table(name = "prompt_binding")
@Comment("Prompt 绑定表：绑定到 Agent / Flow / Node / LLM")
public class PromptBindingPO extends BaseJpaEntity {
    @Column(nullable = false, length = 32)
    @Comment("绑定类型：AGENT / FLOW / NODE / LLM")
    private String bindType;

    @Column(nullable = false)
    @Comment("绑定目标ID")
    private Long bindId;

    @Column(nullable = false)
    @Comment("Prompt ID")
    private Long promptId;

    @Comment("Prompt 顺序（决定拼装顺序）")
    private Integer orderIndex;

    @Comment("是否启用")
    private Boolean enabled = true;
}
