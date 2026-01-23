package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToolResponse {

    private Long id;
    private String toolCode;
    private String toolName;
    private Long mcpServiceId;
    private String mcpMethod;
    private String inputSchema;
    private String outputSchema;
    private String description;
    private Integer riskLevel;
    private Integer status;
}
