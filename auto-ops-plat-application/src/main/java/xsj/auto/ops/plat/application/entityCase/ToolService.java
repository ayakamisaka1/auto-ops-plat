package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.ToolRequest;
import xsj.auto.ops.plat.api.response.ToolResponse;

import java.util.List;

/**
 * 工具服务接口
 */
public interface ToolService {

    /**
     * 查询所有工具
     */
    List<ToolResponse> list();

    /**
     * 根据ID查询工具
     */
    ToolResponse getById(Long id);

    /**
     * 创建工具
     */
    ToolResponse create(ToolRequest request);

    /**
     * 更新工具
     */
    ToolResponse update(ToolRequest request);

    /**
     * 删除工具
     */
    void delete(Long id);
}
