package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentMemoryBindingResponse {

    private Long id;
    private String agentId;
    private Integer priority;
    private Boolean active;
}
