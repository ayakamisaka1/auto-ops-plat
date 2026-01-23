package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToolModelBindingResponse {

    private Long id;
    private Long toolId;
    private Long llmModelId;
    private Integer enable;
    private Integer maxCalls;
    private Integer rateLimit;
}
