package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {

    private Long id;
    private String conversationId;
    private String role;
    private String content;
    private Integer tokenCount;
    private Integer importanceScore;
    private String toolName;
    private String toolPayload;
}
