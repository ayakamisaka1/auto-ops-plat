package xsj.auto.ops.plat.infrastructure.jpaEntity.memory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

import java.time.LocalDateTime;

/**
 * 会话实体
 * 一个会话对应一组消息和若干次摘要
 */
@Getter
@Setter
@Entity
@Table(name = "conversation")
public class ConversationPO extends BaseJpaEntity {
    /**
     * 会话业务唯一 ID
     */
    @Column(name = "conversation_id", nullable = false, unique = true, length = 64)
    private String conversationId;

    /**
     * 处理该会话的 Agent
     */
    @Column(name = "agent_id", nullable = false, length = 64)
    private String agentId;

    /**
     * 用户 ID（可为空，支持系统任务）
     */
    @Column(name = "user_id", length = 64)
    private String userId;

    /**
     * 会话上下文类型
     * chat / task / flow / tool
     */
    @Column(name = "context_type", length = 32)
    private String contextType;

    /**
     * 会话状态
     * active / archived / closed
     */
    @Column(name = "status", length = 32)
    private String status = "active";

    @Column(name = "started_at")
    private LocalDateTime startedAt = LocalDateTime.now();

    @Column(name = "ended_at")
    private LocalDateTime endedAt;
}
