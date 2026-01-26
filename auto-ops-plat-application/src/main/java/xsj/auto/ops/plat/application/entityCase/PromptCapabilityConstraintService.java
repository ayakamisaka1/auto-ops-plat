package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.PromptCapabilityConstraintRequest;
import xsj.auto.ops.plat.api.response.PromptCapabilityConstraintResponse;

import java.util.List;

/**
 * 提示词能力约束服务接口
 */
public interface PromptCapabilityConstraintService {

    /**
     * 查询所有提示词能力约束
     */
    List<PromptCapabilityConstraintResponse> list();

    /**
     * 根据ID查询提示词能力约束
     */
    PromptCapabilityConstraintResponse getById(Long id);

    /**
     * 创建提示词能力约束
     */
    PromptCapabilityConstraintResponse create(PromptCapabilityConstraintRequest request);

    /**
     * 更新提示词能力约束
     */
    PromptCapabilityConstraintResponse update(PromptCapabilityConstraintRequest request);

    /**
     * 删除提示词能力约束
     */
    void delete(Long id);
}
