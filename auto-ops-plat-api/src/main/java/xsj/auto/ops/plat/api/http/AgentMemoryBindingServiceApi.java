package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.AgentMemoryBindingRequest;
import xsj.auto.ops.plat.api.response.AgentMemoryBindingResponse;

import java.util.List;

public interface AgentMemoryBindingServiceApi {

    ResultBody<List<AgentMemoryBindingResponse>> list();

    ResultBody<AgentMemoryBindingResponse> getById(Long id);

    ResultBody<AgentMemoryBindingResponse> create(AgentMemoryBindingRequest request);

    ResultBody<AgentMemoryBindingResponse> update(AgentMemoryBindingRequest request);

    ResultBody<Void> delete(Long id);
}
