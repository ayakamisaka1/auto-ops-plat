package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class MemoryPolicyRequest {

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
