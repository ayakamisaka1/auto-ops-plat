package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class MessageRequest {

    private Long id;
    private String conversationId;
    private String role;
    private String content;
    private Integer tokenCount;
    private Integer importanceScore;
    private String toolName;
    private String toolPayload;
}
