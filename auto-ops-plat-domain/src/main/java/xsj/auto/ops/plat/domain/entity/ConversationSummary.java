package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class ConversationSummary {

    private Long id;
    private String conversationId;
    private String summaryType;
    private String summaryContent;
    private Integer summaryVersion;
    private Integer tokenCount;

    private ConversationSummary(Long id, String conversationId, String summaryType,
                            String summaryContent, Integer summaryVersion, Integer tokenCount) {
        this.id = id;
        this.conversationId = conversationId;
        this.summaryType = summaryType;
        this.summaryContent = summaryContent;
        this.summaryVersion = summaryVersion;
        this.tokenCount = tokenCount;
    }

    public static ConversationSummary create(Long id, String conversationId, String summaryType,
                                       String summaryContent, Integer summaryVersion, Integer tokenCount) {
        return new ConversationSummary(id, conversationId, summaryType, summaryContent, summaryVersion, tokenCount);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
