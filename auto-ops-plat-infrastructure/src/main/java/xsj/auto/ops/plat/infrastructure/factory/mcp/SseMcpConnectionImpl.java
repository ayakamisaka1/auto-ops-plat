package xsj.auto.ops.plat.infrastructure.factory.mcp;

import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.McpClient;
import org.apache.commons.lang3.StringUtils;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.McpConnectionConfigPO;
import org.slf4j.Logger;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;

import org.slf4j.LoggerFactory;

import java.time.Duration;

public class SseMcpConnectionImpl extends McpCapabilityFactory {

    private static final Logger log = LoggerFactory.getLogger(SseMcpConnectionImpl.class);

    @Override
    protected McpSyncClient connectMcp(McpConnectionConfigPO po) {
        // SSE协议连接实现
        String originalBaseUri = po.getBaseUrl();
        String baseUri;
        String sseEndpoint;

        // 解析baseUri和sseEndpoint
        int queryParamStartIndex = originalBaseUri.indexOf("sse");
        if (queryParamStartIndex != -1) {
            baseUri = originalBaseUri.substring(0, queryParamStartIndex - 1);
            sseEndpoint = originalBaseUri.substring(queryParamStartIndex - 1);
        } else {
            baseUri = originalBaseUri;
            sseEndpoint = po.getEndpoint();
        }

        // 设置默认端点
        sseEndpoint = StringUtils.isBlank(sseEndpoint) ? "/sse" : sseEndpoint;

        // 构建SSE客户端传输
        HttpClientSseClientTransport sseClientTransport = HttpClientSseClientTransport
                .builder(baseUri) // 使用截取后的baseUri
                .sseEndpoint(sseEndpoint) // 使用截取或默认的sseEndpoint
                .build();

        // 设置请求超时，默认1分钟
        int requestTimeout = po.getTimeoutSeconds() != null ? po.getTimeoutSeconds() : 60;

        // 构建McpSyncClient
        McpSyncClient mcpSyncClient = McpClient.sync(sseClientTransport)
                .requestTimeout(Duration.ofSeconds(requestTimeout))
                .build();

        // 初始化SSE连接
        var init_sse = mcpSyncClient.initialize();
        log.info("Tool SSE MCP Initialized {}", init_sse);

        return mcpSyncClient;
    }
}
