package xsj.auto.ops.plat.api.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConversationRequest {

    private Long id;
    private String conversationId;
    private String agentId;
    private String userId;
    private String contextType;
    private String status;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
