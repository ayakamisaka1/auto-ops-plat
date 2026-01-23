package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class McpConnectionConfigRequest {

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
}
