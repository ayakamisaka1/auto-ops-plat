package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.McpConnectionConfigRequest;
import xsj.auto.ops.plat.api.response.McpConnectionConfigResponse;

import java.util.List;

/**
 * MCP连接配置服务接口
 */
public interface McpConnectionConfigService {

    /**
     * 查询所有MCP连接配置
     */
    List<McpConnectionConfigResponse> list();

    /**
     * 根据ID查询MCP连接配置
     */
    McpConnectionConfigResponse getById(Long id);

    /**
     * 创建MCP连接配置
     */
    McpConnectionConfigResponse create(McpConnectionConfigRequest request);

    /**
     * 更新MCP连接配置
     */
    McpConnectionConfigResponse update(McpConnectionConfigRequest request);

    /**
     * 删除MCP连接配置
     */
    void delete(Long id);
}
