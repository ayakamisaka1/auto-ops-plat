package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class McpConnectionConfigResponse {

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
