package xsj.auto.ops.plat.infrastructure.jpaEntity.mcp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;
import xsj.auto.ops.plat.infrastructure.jpaEntity.llm.AiLlmModelPO;

/**
 * Tool 与 LLM 模型绑定实体
 *
 * 用于控制：
 * - 哪个模型能用哪些 Tool
 * - 调用次数、限流等策略
 */
@Getter
@Setter
@ToString
@Entity
@Table(
        name = "tool_model_binding",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"tool_id", "llm_model_id"})
        }
)
public class ToolModelBindingPO extends BaseJpaEntity {
    /**
     * 主键 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 绑定的 Tool
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tool_id", nullable = false)
    private ToolPO toolPO;

    /**
     * 绑定的 LLM 模型
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "llm_model_id", nullable = false)
    private AiLlmModelPO llmModel;

    /**
     * 是否启用该绑定关系
     * 0 - 禁用
     * 1 - 启用
     */
    @Column(name = "enable")
    private Integer enable;

    /**
     * 单次会话最大调用次数
     */
    @Column(name = "max_calls")
    private Integer maxCalls;

    /**
     * QPS 限流配置
     */
    @Column(name = "rate_limit")
    private Integer rateLimit;
}
