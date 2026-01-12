package xsj.auto.ops.plat.infrastructure.jpaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 记忆策略定义
 * 用于描述 Agent 如何触发、筛选、总结和保存记忆
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "memory_policy")
public class MemoryPolicyPO extends BaseJpaEntity{

    /**
     * 策略唯一编码（程序使用）
     * 例如：SHORT_TERM_CHAT、LONG_TERM_PROFILE
     */
    @Column(name = "policy_code", nullable = false, unique = true, length = 64)
    private String policyCode;

    /**
     * 策略名称（展示用）
     */
    @Column(name = "policy_name", nullable = false, length = 128)
    private String policyName;

    /**
     * 策略说明
     */
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    /**
     * 触发类型
     * message_count / token_limit / time_interval / manual
     */
    @Column(name = "trigger_type", nullable = false, length = 32)
    private String triggerType;

    /**
     * 触发阈值
     * 例如：消息条数、token 数、分钟数
     */
    @Column(name = "trigger_value")
    private Integer triggerValue;

    /**
     * 参与记忆的消息角色
     * 例如：system,user,assistant,tool
     */
    @Column(name = "include_role", length = 128)
    private String includeRole;

    /**
     * 消息重要度最低阈值
     */
    @Column(name = "importance_min")
    private Integer importanceMin = 0;

    /**
     * 生成摘要时使用的 Prompt 模板
     */
    @Column(name = "summary_prompt", columnDefinition = "TEXT")
    private String summaryPrompt;

    /**
     * 执行摘要所使用的模型
     */
    @Column(name = "summary_model", length = 64)
    private String summaryModel;

    /**
     * 记忆有效期（天）
     */
    @Column(name = "ttl_days")
    private Integer ttlDays;

    /**
     * 是否启用
     */
    @Column(name = "is_active")
    private Boolean active = true;

}
