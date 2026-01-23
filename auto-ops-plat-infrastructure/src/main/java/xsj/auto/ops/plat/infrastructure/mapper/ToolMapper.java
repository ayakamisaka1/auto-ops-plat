package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.Tool;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.ToolPO;

@Component
public class ToolMapper {

    public ToolPO toJpa(Tool tool) {
        ToolPO po = new ToolPO();
        if (tool.getId() != null) {
            po.setId(tool.getId());
        }
        po.setToolCode(tool.getToolCode());
        po.setToolName(tool.getToolName());
        po.setMcpMethod(tool.getMcpMethod());
        po.setInputSchema(tool.getInputSchema());
        po.setOutputSchema(tool.getOutputSchema());
        po.setDescription(tool.getDescription());
        po.setRiskLevel(tool.getRiskLevel());
        po.setStatus(tool.getStatus());
        return po;
    }

    public Tool toDomain(ToolPO po) {
        return Tool.create(
                po.getId(),
                po.getToolCode(),
                po.getToolName(),
                po.getMcpServicePO() != null ? po.getMcpServicePO().getId() : null,
                po.getMcpMethod(),
                po.getInputSchema(),
                po.getOutputSchema(),
                po.getDescription(),
                po.getRiskLevel(),
                po.getStatus()
        );
    }
}
