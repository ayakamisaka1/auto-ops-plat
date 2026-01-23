package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class AgentMemoryBindingRequest {

    private Long id;
    private String agentId;
    private Integer priority;
    private Boolean active;
}
