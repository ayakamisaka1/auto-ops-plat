package xsj.auto.ops.plat.domain.entity.ToolFactoryEntity;

import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import lombok.Getter;
import xsj.auto.ops.plat.types.enums.ToolRiskLevel;

/*
运行时的tools
*/
@Getter
public class RuntimeToolDescriptorEntity {
    private String toolName;        // 给 LLM 的 name
    private String code;             // 给 LLM 的 name
    private String description;     // Tool 描述
    private JsonSchema inputSchema; // 入参 schema
    private JsonSchema outputSchema;

    private String mcpServiceCode;
    private String mcpMethod;

    private ToolRiskLevel riskLevel;

    // runtime policy
    private int maxCalls;
    private int rateLimit;

}
