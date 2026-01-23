package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.McpConnectionConfig;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.McpConnectionConfigPO;

@Component
public class McpConnectionConfigMapper {

    public McpConnectionConfigPO toJpa(McpConnectionConfig config) {
        McpConnectionConfigPO po = new McpConnectionConfigPO();
        if (config.getId() != null) {
            po.setId(config.getId());
        }
        po.setName(config.getName());
        po.setProtocol(config.getProtocol());
        po.setBaseUrl(config.getBaseUrl());
        po.setEndpoint(config.getEndpoint());
        po.setAuthType(config.getAuthType());
        po.setApiKey(config.getApiKey());
        po.setHeadersJson(config.getHeadersJson());
        po.setTimeoutSeconds(config.getTimeoutSeconds());
        po.setEnabled(config.getEnabled());
        po.setExtensionConfigJson(config.getExtensionConfigJson());
        return po;
    }

    public McpConnectionConfig toDomain(McpConnectionConfigPO po) {
        return McpConnectionConfig.create(
                po.getId(),
                po.getName(),
                po.getProtocol(),
                po.getBaseUrl(),
                po.getEndpoint(),
                po.getAuthType(),
                po.getApiKey(),
                po.getHeadersJson(),
                po.getTimeoutSeconds(),
                po.getEnabled(),
                po.getExtensionConfigJson(),
                po.getMcpServer() != null ? po.getMcpServer().getId() : null
        );
    }
}
