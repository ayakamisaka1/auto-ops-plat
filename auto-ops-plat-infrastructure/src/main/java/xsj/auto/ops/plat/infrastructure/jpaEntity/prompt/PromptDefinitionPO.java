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
@Table(name = "prompt_definition")
@Comment("Prompt 定义表：Agent/LLM 可复用的 Prompt 资产")
public class PromptDefinitionPO extends BaseJpaEntity {
    @Column(nullable = false, length = 128)
    @Comment("Prompt 名称")
    private String name;

    @Column(length = 32)
    @Comment("Prompt 类型：SYSTEM / ROLE / POLICY / FORMAT / RAG")
    private String promptType;

    @Column(columnDefinition = "TEXT", nullable = false)
    @Comment("Prompt 内容模板")
    private String content;

    @Column(columnDefinition = "TEXT")
    @Comment("Prompt 描述说明")
    private String description;

    @Comment("是否启用")
    private Boolean enabled = true;
}
