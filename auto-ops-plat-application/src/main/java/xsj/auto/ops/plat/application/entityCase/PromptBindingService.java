package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.PromptBindingRequest;
import xsj.auto.ops.plat.api.response.PromptBindingResponse;

import java.util.List;

/**
 * 提示词绑定服务接口
 */
public interface PromptBindingService {

    /**
     * 查询所有提示词绑定
     */
    List<PromptBindingResponse> list();

    /**
     * 根据ID查询提示词绑定
     */
    PromptBindingResponse getById(Long id);

    /**
     * 创建提示词绑定
     */
    PromptBindingResponse create(PromptBindingRequest request);

    /**
     * 更新提示词绑定
     */
    PromptBindingResponse update(PromptBindingRequest request);

    /**
     * 删除提示词绑定
     */
    void delete(Long id);
}
