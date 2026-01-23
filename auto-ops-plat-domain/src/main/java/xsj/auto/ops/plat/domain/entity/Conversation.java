package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Conversation {

    private Long id;
    private String conversationId;
    private String agentId;
    private String userId;
    private String contextType;
    private String status;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    private Conversation(Long id, String conversationId, String agentId, String userId,
                      String contextType, String status, LocalDateTime startedAt, LocalDateTime endedAt) {
        this.id = id;
        this.conversationId = conversationId;
        this.agentId = agentId;
        this.userId = userId;
        this.contextType = contextType;
        this.status = status;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
    }

    public static Conversation create(Long id, String conversationId, String agentId, String userId,
                                 String contextType, String status, LocalDateTime startedAt, LocalDateTime endedAt) {
        return new Conversation(id, conversationId, agentId, userId, contextType, status, startedAt, endedAt);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
