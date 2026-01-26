package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.AgentMemoryBindingRequest;
import xsj.auto.ops.plat.api.response.AgentMemoryBindingResponse;

import java.util.List;

public interface AgentMemoryBindingService {

    /**
     * 查询所有Agent内存绑定
     */
    List<AgentMemoryBindingResponse> list();

    /**
     * 根据ID查询Agent内存绑定
     */
    AgentMemoryBindingResponse getById(Long id);

    /**
     * 创建Agent内存绑定
     */
    AgentMemoryBindingResponse create(AgentMemoryBindingRequest request);

    /**
     * 更新Agent内存绑定
     */
    AgentMemoryBindingResponse update(AgentMemoryBindingRequest request);

    /**
     * 删除Agent内存绑定
     */
    void delete(Long id);
}
