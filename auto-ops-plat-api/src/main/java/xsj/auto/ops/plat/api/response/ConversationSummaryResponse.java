package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversationSummaryResponse {

    private Long id;
    private String conversationId;
    private String summaryType;
    private String summaryContent;
    private Integer summaryVersion;
    private Integer tokenCount;
}
