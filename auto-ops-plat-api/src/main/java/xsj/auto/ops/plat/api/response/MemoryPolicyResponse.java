package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemoryPolicyResponse {

    private Long id;
    private String policyCode;
    private String policyName;
    private String description;
    private String triggerType;
    private Integer triggerValue;
    private String includeRole;
    private Integer importanceMin;
    private String summaryPrompt;
    private String summaryModel;
    private Integer ttlDays;
    private Boolean active;
}
