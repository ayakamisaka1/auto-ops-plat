package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.PromptDefinitionRequest;
import xsj.auto.ops.plat.api.response.PromptDefinitionResponse;

import java.util.List;

/**
 * 提示词定义服务接口
 */
public interface PromptDefinitionService {

    /**
     * 查询所有提示词定义
     */
    List<PromptDefinitionResponse> list();

    /**
     * 根据ID查询提示词定义
     */
    PromptDefinitionResponse getById(Long id);

    /**
     * 创建提示词定义
     */
    PromptDefinitionResponse create(PromptDefinitionRequest request);

    /**
     * 更新提示词定义
     */
    PromptDefinitionResponse update(PromptDefinitionRequest request);

    /**
     * 删除提示词定义
     */
    void delete(Long id);
}
