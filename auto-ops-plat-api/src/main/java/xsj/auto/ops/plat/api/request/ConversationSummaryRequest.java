package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class ConversationSummaryRequest {

    private Long id;
    private String conversationId;
    private String summaryType;
    private String summaryContent;
    private Integer summaryVersion;
    private Integer tokenCount;
}
