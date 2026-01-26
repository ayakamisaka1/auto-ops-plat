package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.ToolModelBindingRequest;
import xsj.auto.ops.plat.api.response.ToolModelBindingResponse;

import java.util.List;

/**
 * 工具模型绑定服务接口
 */
public interface ToolModelBindingService {

    /**
     * 查询所有工具模型绑定
     */
    List<ToolModelBindingResponse> list();

    /**
     * 根据ID查询工具模型绑定
     */
    ToolModelBindingResponse getById(Long id);

    /**
     * 创建工具模型绑定
     */
    ToolModelBindingResponse create(ToolModelBindingRequest request);

    /**
     * 更新工具模型绑定
     */
    ToolModelBindingResponse update(ToolModelBindingRequest request);

    /**
     * 删除工具模型绑定
     */
    void delete(Long id);
}
