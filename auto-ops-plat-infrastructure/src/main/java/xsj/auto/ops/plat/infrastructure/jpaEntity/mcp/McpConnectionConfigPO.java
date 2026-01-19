package xsj.auto.ops.plat.infrastructure.jpaEntity.mcp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

/**
 * MCP 连接配置实体
 *
 * 领域含义：
 * - 描述如何连接一个 MCP 服务
 * - 仅包含“连接所需的信息”
 * - 不关心 Tool、LLM、Agent 的使用关系
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "mcp_connection_config")
public class McpConnectionConfigPO extends BaseJpaEntity {
    /**
     * MCP 服务名称
     * 示例：高德地图 / GitHub MCP
     */
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /**
     * MCP 协议类型
     * HTTP / SSE / WS / STDIO
     */
    @Column(name = "protocol", nullable = false, length = 32)
    private String protocol;

    /**
     * MCP 基础 URL
     * 示例：https://mcp.amap.com
     */
    @Column(name = "base_url", nullable = false, length = 255)
    private String baseUrl;

    /**
     * 协议入口路径
     * 示例：
     * - /sse
     * - /v1/tools
     */
    @Column(name = "endpoint", length = 255)
    private String endpoint;

    /**
     * 鉴权类型
     * NONE / API_KEY / BEARER / OAUTH
     */
    @Column(name = "auth_type", length = 32)
    private String authType;

    /**
     * API Key 或 Token
     *
     * ⚠️ 建议：
     * - 数据库存储加密
     * - 不直接对外返回
     */
    @Column(name = "api_key", length = 512)
    private String apiKey;

    /**
     * 自定义请求头（JSON）
     *
     * 示例：
     * {
     *   "X-App-Id": "xxx",
     *   "X-Env": "prod"
     * }
     */
    @Lob
    @Column(name = "headers_json")
    private String headersJson;

    /**
     * 请求超时时间（秒）
     */
    @Column(name = "timeout_seconds")
    private Integer timeoutSeconds;

    /**
     * 是否启用该 MCP 配置
     */
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    /**
     * 协议扩展配置（JSON）
     *
     * 用途：
     * - SSE 重连策略
     * - WS 心跳参数
     * - MCP 非标准字段
     */
    @Lob
    @Column(name = "extension_config_json")
    private String extensionConfigJson;

    /**
     * 所属 MCP 服务
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "mcp_server_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_mcp_connection_server")
    )
    private McpServicePO mcpServer;
}
