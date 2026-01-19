package xsj.auto.ops.plat.infrastructure.jpaEntity.memory;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

/**
 * 会话摘要 / 长期记忆
 * 是由记忆策略生成的压缩信息
 */
@Getter
@Setter
@Entity
@Table(name = "conversation_summary")
public class ConversationSummaryPO extends BaseJpaEntity {
    /**
     * 所属会话 ID
     */
    @Column(name = "conversation_id", nullable = false, length = 64)
    private String conversationId;

    /**
     * 使用的记忆策略
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memory_policy_id", nullable = false)
    private MemoryPolicyPO memoryPolicy;

    /**
     * 摘要类型
     * rolling / final / checkpoint
     */
    @Column(name = "summary_type", length = 32)
    private String summaryType;

    /**
     * 摘要内容
     */
    @Column(name = "summary_content", nullable = false, columnDefinition = "TEXT")
    private String summaryContent;

    /**
     * 摘要版本号
     */
    @Column(name = "summary_version")
    private Integer summaryVersion = 1;

    /**
     * 摘要 token 数
     */
    @Column(name = "token_count")
    private Integer tokenCount;

}
