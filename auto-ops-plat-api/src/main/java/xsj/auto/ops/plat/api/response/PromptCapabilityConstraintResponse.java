package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromptCapabilityConstraintResponse {

    private Long id;
    private Long promptId;
    private String capabilityType;
    private String constraintRule;
}
