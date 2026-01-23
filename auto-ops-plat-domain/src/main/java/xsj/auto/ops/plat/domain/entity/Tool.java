package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class Tool {

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

    private Tool(Long id, String toolCode, String toolName, Long mcpServiceId,
               String mcpMethod, String inputSchema, String outputSchema,
               String description, Integer riskLevel, Integer status) {
        this.id = id;
        this.toolCode = toolCode;
        this.toolName = toolName;
        this.mcpServiceId = mcpServiceId;
        this.mcpMethod = mcpMethod;
        this.inputSchema = inputSchema;
        this.outputSchema = outputSchema;
        this.description = description;
        this.riskLevel = riskLevel;
        this.status = status;
    }

    public static Tool create(Long id, String toolCode, String toolName, Long mcpServiceId,
                          String mcpMethod, String inputSchema, String outputSchema,
                          String description, Integer riskLevel, Integer status) {
        return new Tool(id, toolCode, toolName, mcpServiceId, mcpMethod, inputSchema,
                outputSchema, description, riskLevel, status);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
