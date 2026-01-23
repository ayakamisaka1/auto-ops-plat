package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class MemoryPolicy {

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

    private MemoryPolicy(Long id, String policyCode, String policyName, String description,
                      String triggerType, Integer triggerValue, String includeRole,
                      Integer importanceMin, String summaryPrompt, String summaryModel,
                      Integer ttlDays, Boolean active) {
        this.id = id;
        this.policyCode = policyCode;
        this.policyName = policyName;
        this.description = description;
        this.triggerType = triggerType;
        this.triggerValue = triggerValue;
        this.includeRole = includeRole;
        this.importanceMin = importanceMin;
        this.summaryPrompt = summaryPrompt;
        this.summaryModel = summaryModel;
        this.ttlDays = ttlDays;
        this.active = active;
    }

    public static MemoryPolicy create(Long id, String policyCode, String policyName, String description,
                                  String triggerType, Integer triggerValue, String includeRole,
                                  Integer importanceMin, String summaryPrompt, String summaryModel,
                                  Integer ttlDays, Boolean active) {
        return new MemoryPolicy(id, policyCode, policyName, description, triggerType, triggerValue,
                includeRole, importanceMin, summaryPrompt, summaryModel, ttlDays, active);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
