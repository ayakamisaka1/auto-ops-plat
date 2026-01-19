package xsj.auto.ops.plat.infrastructure.jpaEntity.mcp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

/**
 * MCP 服务实体
 *
 * 表示一个 MCP 能力服务的“宿主定义”
 * ⚠️ 注意：MCP 服务本身不会直接暴露给 LLM
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "mcp_service")
public class McpServicePO extends BaseJpaEntity {
    /**
     * MCP 服务唯一编码（如：risk-mcp、message-mcp）
     */
    @Column(name = "service_code", nullable = false, unique = true, length = 64)
    private String serviceCode;

    /**
     * MCP 服务名称
     */
    @Column(name = "service_name", nullable = false, length = 128)
    private String serviceName;

    /**
     * 服务类型
     * 示例：http / grpc / stdio / plugin /sse
     */
    @Column(name = "service_type", nullable = false, length = 32)
    private String serviceType;

    /**
     * 服务描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 服务状态
     * 0 - 禁用
     * 1 - 启用
     */
    @Column(name = "status", nullable = false)
    private Integer status;
}
