package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.MemoryPolicyRequest;
import xsj.auto.ops.plat.api.response.MemoryPolicyResponse;

import java.util.List;

public interface MemoryPolicyServiceApi {

    ResultBody<List<MemoryPolicyResponse>> list();

    ResultBody<MemoryPolicyResponse> getById(Long id);

    ResultBody<MemoryPolicyResponse> create(MemoryPolicyRequest request);

    ResultBody<MemoryPolicyResponse> update(MemoryPolicyRequest request);

    ResultBody<Void> delete(Long id);
}
