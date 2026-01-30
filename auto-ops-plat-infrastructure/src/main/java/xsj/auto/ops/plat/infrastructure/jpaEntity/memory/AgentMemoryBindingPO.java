package xsj.auto.ops.plat.infrastructure.jpaEntity.memory;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

/**
 * Agent 与记忆策略的绑定关系
 * 支持一个 Agent 绑定多个记忆策略
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "agent_memory_binding")
public class AgentMemoryBindingPO  extends BaseJpaEntity {
    /**
     * Agent 唯一标识
     */
    @Column(name = "agent_id", nullable = false, length = 64)
    private String agentId;

    /**
     * 绑定的记忆策略
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memory_policy_id", nullable = false)
    private MemoryPolicyPO memoryPolicy;

    /**
     * 策略优先级（数字越大越先执行）
     */
    @Column(name = "priority")
    private Integer priority = 0;

    /**
     * 是否启用
     */
    @Column(name = "is_active")
    private Boolean active = true;


}
