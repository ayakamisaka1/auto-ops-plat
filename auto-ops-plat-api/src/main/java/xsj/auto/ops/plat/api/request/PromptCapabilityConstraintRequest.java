package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class PromptCapabilityConstraintRequest {

    private Long id;
    private Long promptId;
    private String capabilityType;
    private String constraintRule;
}
