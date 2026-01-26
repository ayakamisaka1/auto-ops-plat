package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.McpServiceRequest;
import xsj.auto.ops.plat.api.response.McpServiceResponse;

import java.util.List;

/**
 * MCP服务服务接口
 */
public interface McpServiceService {

    /**
     * 查询所有MCP服务
     */
    List<McpServiceResponse> list();

    /**
     * 根据ID查询MCP服务
     */
    McpServiceResponse getById(Long id);

    /**
     * 创建MCP服务
     */
    McpServiceResponse create(McpServiceRequest request);

    /**
     * 更新MCP服务
     */
    McpServiceResponse update(McpServiceRequest request);

    /**
     * 删除MCP服务
     */
    void delete(Long id);
}
