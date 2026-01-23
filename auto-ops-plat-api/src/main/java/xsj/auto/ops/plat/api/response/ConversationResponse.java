package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversationResponse {

    private Long id;
    private String conversationId;
    private String agentId;
    private String userId;
    private String contextType;
    private String status;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
