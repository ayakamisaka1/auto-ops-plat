package xsj.auto.ops.plat.infrastructure.factory.mcp;

import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.json.McpJsonMapper;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.McpConnectionConfigPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class StdioMcpConnectionImpl extends McpCapabilityFactory {

    private static final Logger log = LoggerFactory.getLogger(StdioMcpConnectionImpl.class);

    @Override
    protected McpSyncClient connectMcp(McpConnectionConfigPO po) {
        // STDIO协议连接实现
        // TODO: 从McpConnectionConfigPO中获取STDIO配置
        // 当前McpConnectionConfigPO可能没有直接对应AiClientToolMcpVO的结构
        // 这里需要根据实际数据库设计调整，暂时使用模拟数据
        
        // 模拟transportConfigStdio
        String command = "java -jar mcp-server.jar";
        String[] args = new String[]{};
        Map<String, String> env = new HashMap<>();
        
        // 构建ServerParameters
        ServerParameters stdioParams = ServerParameters.builder(command)
                .args(args)
                .env(env)
                .build();
        McpJsonMapper jsonMapper = McpJsonMapper.getDefault();
        // 设置请求超时，默认1分钟
        int requestTimeout = po.getTimeoutSeconds() != null ? po.getTimeoutSeconds() : 60;

        // 构建McpSyncClient
        McpSyncClient mcpClient = McpClient.sync(new StdioClientTransport(stdioParams,jsonMapper))
                .requestTimeout(Duration.ofSeconds(requestTimeout))
                .build();

        // 初始化STDIO连接
        var init_stdio = mcpClient.initialize();
        log.info("Tool Stdio MCP Initialized {}", init_stdio);

        return mcpClient;
    }
}
