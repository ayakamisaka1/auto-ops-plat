package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class ToolModelBindingRequest {

    private Long id;
    private Long toolId;
    private Long llmModelId;
    private Integer enable;
    private Integer maxCalls;
    private Integer rateLimit;
}
