package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class McpConnectionConfig {

    private Long id;
    private String name;
    private String protocol;
    private String baseUrl;
    private String endpoint;
    private String authType;
    private String apiKey;
    private String headersJson;
    private Integer timeoutSeconds;
    private Boolean enabled;
    private String extensionConfigJson;
    private Long mcpServerId;

    private McpConnectionConfig(Long id, String name, String protocol, String baseUrl,
                             String endpoint, String authType, String apiKey,
                             String headersJson, Integer timeoutSeconds, Boolean enabled,
                             String extensionConfigJson, Long mcpServerId) {
        this.id = id;
        this.name = name;
        this.protocol = protocol;
        this.baseUrl = baseUrl;
        this.endpoint = endpoint;
        this.authType = authType;
        this.apiKey = apiKey;
        this.headersJson = headersJson;
        this.timeoutSeconds = timeoutSeconds;
        this.enabled = enabled;
        this.extensionConfigJson = extensionConfigJson;
        this.mcpServerId = mcpServerId;
    }

    public static McpConnectionConfig create(Long id, String name, String protocol, String baseUrl,
                                        String endpoint, String authType, String apiKey,
                                        String headersJson, Integer timeoutSeconds, Boolean enabled,
                                        String extensionConfigJson, Long mcpServerId) {
        return new McpConnectionConfig(id, name, protocol, baseUrl, endpoint, authType, apiKey,
                headersJson, timeoutSeconds, enabled, extensionConfigJson, mcpServerId);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
