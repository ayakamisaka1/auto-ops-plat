package xsj.auto.ops.plat.infrastructure.factory.mcp;

import org.springframework.ai.tool.ToolCallback;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.domain.factory.ToolCapabilityFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class ToolCapabilityFactoryImpl implements ToolCapabilityFactory {

    // MCP客户端缓存，key为mcpConnectionConfigId，value为ToolCallback列表
    private final Map<Long, List<ToolCallback>> toolCallbackCache = new ConcurrentHashMap<>();
    
    // 缓存过期时间（3小时）
    private static final long CACHE_EXPIRY_TIME = 3 * 60 * 60 * 1000;
    
    // 定时清理过期缓存的线程池
    private final ScheduledExecutorService cleanupExecutor = Executors.newSingleThreadScheduledExecutor();
    
    // 缓存项，包含ToolCallback列表和过期时间
    private static class CacheItem {
        List<ToolCallback> toolCallbacks;
        long expiryTime;
        
        CacheItem(List<ToolCallback> toolCallbacks, long expiryTime) {
            this.toolCallbacks = toolCallbacks;
            this.expiryTime = expiryTime;
        }
    }
    
    // 带过期时间的缓存
    private final Map<Long, CacheItem> cacheWithExpiry = new ConcurrentHashMap<>();
    
    public ToolCapabilityFactoryImpl() {
        // 每小时清理一次过期缓存
        cleanupExecutor.scheduleAtFixedRate(this::cleanupExpiredCache, 1, 1, TimeUnit.HOURS);
    }
    
    @Override
    public List<ToolCallback> findAllTools(Long llmId) {
        // 1. 先通过llm id查询使用的tools
        // TODO: 从数据库查询llmId对应的工具
        // List<Long> toolIds = toolRepository.findByLlmId(llmId);
        
        // 2. 分组tool，查询对应的mcp服务
        // TODO: 从数据库查询工具对应的mcp服务连接配置
        // Map<Long, List<Long>> mcpToToolMap = toolService.groupToolsByMcpService(toolIds);
        
        // 3. 查询内存中是否已有mcp服务连接，如果有直接拿对应的ToolCallback
        List<ToolCallback> allToolCallbacks = new ArrayList<>();
        
        // TODO: 遍历mcp服务，获取对应的ToolCallback
        // for (Map.Entry<Long, List<Long>> entry : mcpToToolMap.entrySet()) {
        //     Long mcpConnectionConfigId = entry.getKey();
        //     List<Long> tools = entry.getValue();
        //     
        //     // 尝试从缓存获取ToolCallback
        //     List<ToolCallback> toolCallbacks = getToolCallbacksFromCache(mcpConnectionConfigId);
        //     
        //     if (toolCallbacks == null) {
        //         // 缓存中没有，建立mcp连接
        //         McpConnectionConfigPO mcpConfig = mcpConnectionConfigRepository.findById(mcpConnectionConfigId).orElse(null);
        //         if (mcpConfig != null && mcpConfig.getEnabled()) {
        //             // 使用McpCapabilityFactory获取ToolCallback
        //             McpCapabilityFactory mcpFactory = McpCapabilityFactory.getInstance(mcpConfig.getProtocol());
        //             toolCallbacks = mcpFactory.findToolCallbacks(mcpConfig);
        //             
        //             // 保存到缓存，3小时过期
        //             saveToolCallbacksToCache(mcpConnectionConfigId, toolCallbacks);
        //         }
        //     }
        //     
        //     if (toolCallbacks != null) {
        //         allToolCallbacks.addAll(toolCallbacks);
        //     }
        // }
        
        return allToolCallbacks;
    }
    
    /**
     * 从缓存获取ToolCallback列表
     */
    private List<ToolCallback> getToolCallbacksFromCache(Long mcpConnectionConfigId) {
        CacheItem cacheItem = cacheWithExpiry.get(mcpConnectionConfigId);
        if (cacheItem != null) {
            // 检查是否过期
            if (System.currentTimeMillis() < cacheItem.expiryTime) {
                return cacheItem.toolCallbacks;
            } else {
                // 过期了，从缓存中移除
                cacheWithExpiry.remove(mcpConnectionConfigId);
            }
        }
        return null;
    }
    
    /**
     * 将ToolCallback列表保存到缓存
     */
    private void saveToolCallbacksToCache(Long mcpConnectionConfigId, List<ToolCallback> toolCallbacks) {
        long expiryTime = System.currentTimeMillis() + CACHE_EXPIRY_TIME;
        cacheWithExpiry.put(mcpConnectionConfigId, new CacheItem(toolCallbacks, expiryTime));
    }
    
    /**
     * 清理过期缓存
     */
    private void cleanupExpiredCache() {
        long currentTime = System.currentTimeMillis();
        cacheWithExpiry.entrySet().removeIf(entry -> entry.getValue().expiryTime < currentTime);
    }
}
