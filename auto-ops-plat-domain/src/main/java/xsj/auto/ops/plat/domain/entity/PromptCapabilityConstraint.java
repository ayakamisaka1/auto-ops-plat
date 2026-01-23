package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class PromptCapabilityConstraint {

    private Long id;
    private Long promptId;
    private String capabilityType;
    private String constraintRule;

    private PromptCapabilityConstraint(Long id, Long promptId, String capabilityType, String constraintRule) {
        this.id = id;
        this.promptId = promptId;
        this.capabilityType = capabilityType;
        this.constraintRule = constraintRule;
    }

    public static PromptCapabilityConstraint create(Long id, Long promptId, String capabilityType, String constraintRule) {
        return new PromptCapabilityConstraint(id, promptId, capabilityType, constraintRule);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
