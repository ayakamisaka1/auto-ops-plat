package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.MemoryPolicyRequest;
import xsj.auto.ops.plat.api.response.MemoryPolicyResponse;

import java.util.List;

/**
 * 内存策略服务接口
 */
public interface MemoryPolicyService {

    /**
     * 查询所有内存策略
     */
    List<MemoryPolicyResponse> list();

    /**
     * 根据ID查询内存策略
     */
    MemoryPolicyResponse getById(Long id);

    /**
     * 创建内存策略
     */
    MemoryPolicyResponse create(MemoryPolicyRequest request);

    /**
     * 更新内存策略
     */
    MemoryPolicyResponse update(MemoryPolicyRequest request);

    /**
     * 删除内存策略
     */
    void delete(Long id);
}
