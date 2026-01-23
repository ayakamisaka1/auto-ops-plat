package xsj.auto.ops.plat.infrastructure.factory.mcp;

import io.modelcontextprotocol.client.McpSyncClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.ToolCallback;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.McpConnectionConfigPO;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MCP能力工厂抽象类
 * <p>
 * 该工厂负责创建和管理不同协议的MCP连接，为AI中间件平台提供工具能力支持
 * 支持SSE和STDIO两种协议，通过工厂方法模式动态创建对应的连接实现
 * </p>
 */
public abstract class McpCapabilityFactory {

    // 缓存MCP客户端，key格式：protocol:baseUrl:endpoint
    // 使用ConcurrentHashMap保证线程安全
    private static final Map<String, McpSyncClient> mcpClientCache = new ConcurrentHashMap<>();

    /**
     * 根据MCP连接配置获取工具回调列表
     * <p>
     * 1. 生成缓存key
     * 2. 从缓存获取或创建MCP客户端
     * 3. 通过McpToolCallbackProvider获取ToolCallbacks
     * 4. 转换为List并返回
     * </p>
     * 
     * @param po MCP连接配置持久化对象
     * @return 工具回调列表
     */
    public List<ToolCallback> findToolCallbacks(McpConnectionConfigPO po) {
        // 1. 生成缓存key
        String cacheKey = generateCacheKey(po);
        
        // 2. 从缓存获取或创建MCP客户端
        // 使用computeIfAbsent保证原子性，避免并发创建问题
        McpSyncClient mcpSyncClient = mcpClientCache.computeIfAbsent(cacheKey, k -> connectMcp(po));
        
        // 3. 获取ToolCallbacks
        // 使用McpToolCallbackProvider替代已弃用的SyncMcpToolCallbackProvider
        SyncMcpToolCallbackProvider callbackProvider = new SyncMcpToolCallbackProvider(mcpSyncClient);
        ToolCallback[] toolCallbacks = callbackProvider.getToolCallbacks();
        
        // 4. 转换为List并返回
        return List.of(toolCallbacks);
    }

    /**
     * 连接MCP服务的抽象方法
     * <p>
     * 由具体的协议实现类实现，创建并返回对应的McpSyncClient实例
     * </p>
     * 
     * @param po MCP连接配置持久化对象
     * @return McpSyncClient实例
     */
    protected abstract McpSyncClient connectMcp(McpConnectionConfigPO po);
    
    /**
     * 生成缓存key
     * <p>
     * 根据协议类型、基础URL和端点生成唯一的缓存key
     * </p>
     * 
     * @param po MCP连接配置持久化对象
     * @return 唯一的缓存key
     */
    protected String generateCacheKey(McpConnectionConfigPO po) {
        return String.format("%s:%s:%s", po.getProtocol(), po.getBaseUrl(), po.getEndpoint());
    }
    
    /**
     * 工厂方法：根据协议获取对应的McpCapabilityFactory实现
     * <p>
     * 支持SSE和STDIO两种协议
     * </p>
     * 
     * @param protocol 协议类型
     * @return 对应的McpCapabilityFactory实现
     * @throws IllegalArgumentException 不支持的协议类型
     */
    public static McpCapabilityFactory getInstance(String protocol) {
        switch (protocol.toUpperCase()) {
            case "SSE":
                return new SseMcpConnectionImpl();
            case "STDIO":
                return new StdioMcpConnectionImpl();
            default:
                throw new IllegalArgumentException("Unsupported protocol: " + protocol);
        }
    }
}
