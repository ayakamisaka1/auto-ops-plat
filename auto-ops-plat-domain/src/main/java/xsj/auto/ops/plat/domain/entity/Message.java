package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class Message {

    private Long id;
    private String conversationId;
    private String role;
    private String content;
    private Integer tokenCount;
    private Integer importanceScore;
    private String toolName;
    private String toolPayload;

    private Message(Long id, String conversationId, String role, String content,
                 Integer tokenCount, Integer importanceScore, String toolName, String toolPayload) {
        this.id = id;
        this.conversationId = conversationId;
        this.role = role;
        this.content = content;
        this.tokenCount = tokenCount;
        this.importanceScore = importanceScore;
        this.toolName = toolName;
        this.toolPayload = toolPayload;
    }

    public static Message create(Long id, String conversationId, String role, String content,
                             Integer tokenCount, Integer importanceScore, String toolName, String toolPayload) {
        return new Message(id, conversationId, role, content, tokenCount, importanceScore, toolName, toolPayload);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
