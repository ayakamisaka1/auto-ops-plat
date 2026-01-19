package xsj.auto.ops.plat.infrastructure.jpaEntity.mcp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

/**
 * Tool 工具实体
 *
 * Tool 是真正“暴露给 LLM”的最小能力单元
 * 每一个 Tool 对应 MCP 内部的一个方法
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "tool")
public class ToolPO extends BaseJpaEntity {
    /**
     * Tool 唯一编码
     */
    @Column(name = "tool_code", nullable = false, unique = true, length = 64)
    private String toolCode;

    /**
     * Tool 名称（给人看的）
     */
    @Column(name = "tool_name", nullable = false, length = 128)
    private String toolName;

    /**
     * Tool 所属 MCP 服务
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mcp_service_id")
    private McpServicePO mcpServicePO;

    /**
     * MCP 内部方法名
     * 示例：riskCheck、sendMessage
     */
    @Column(name = "mcp_method", nullable = false, length = 128)
    private String mcpMethod;

    /**
     * Tool 输入参数 Schema（JSON Schema）
     * 直接用于构建给 LLM 的 tool 描述
     */
    @Column(name = "input_schema", nullable = false, columnDefinition = "json")
    private String inputSchema;

    /**
     * Tool 输出结构 Schema（JSON Schema）
     */
    @Column(name = "output_schema", columnDefinition = "json")
    private String outputSchema;

    /**
     * Tool 描述（会暴露给 LLM）
     */
    @Column(name = "description")
    private String description;

    /**
     * 风险等级
     * 1 - 低
     * 2 - 中
     * 3 - 高
     */
    @Column(name = "risk_level")
    private Integer riskLevel;

    /**
     * Tool 状态
     * 0 - 禁用
     * 1 - 启用
     */
    @Column(name = "status", nullable = false)
    private Integer status;
}
