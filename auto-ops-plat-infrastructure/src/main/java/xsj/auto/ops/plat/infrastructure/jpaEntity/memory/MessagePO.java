package xsj.auto.ops.plat.infrastructure.jpaEntity.memory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

/**
 * 会话中的原始消息
 * 是事实来源，不应被覆盖或删除
 */
@Getter
@Setter
@Entity
@Table(name = "message", indexes = {
        @Index(name = "idx_message_conversation", columnList = "conversation_id")
})
public class MessagePO extends BaseJpaEntity {
    /**
     * 所属会话 ID
     */
    @Column(name = "conversation_id", nullable = false, length = 64)
    private String conversationId;

    /**
     * 消息角色
     * system / user / assistant / tool
     */
    @Column(name = "role", nullable = false, length = 32)
    private String role;

    /**
     * 消息内容
     */
    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    /**
     * 消息 token 数（可选）
     */
    @Column(name = "token_count")
    private Integer tokenCount;

    /**
     * 消息重要度评分
     */
    @Column(name = "importance_score")
    private Integer importanceScore = 0;

    /**
     * 工具名称（仅 role=tool 时）
     */
    @Column(name = "tool_name", length = 64)
    private String toolName;

    /**
     * 工具调用参数（JSON）
     */
    @Column(name = "tool_payload", columnDefinition = "JSON")
    private String toolPayload;


}
