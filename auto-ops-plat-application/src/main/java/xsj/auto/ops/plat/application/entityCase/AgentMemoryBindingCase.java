package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.AgentMemoryBindingRequest;
import xsj.auto.ops.plat.api.response.AgentMemoryBindingResponse;

import java.util.List;

public interface AgentMemoryBindingCase {

    List<AgentMemoryBindingResponse> list();

    AgentMemoryBindingResponse getById(Long id);

    AgentMemoryBindingResponse create(AgentMemoryBindingRequest request);

    AgentMemoryBindingResponse update(AgentMemoryBindingRequest request);

    void delete(Long id);
}
