package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class ToolRequest {

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
