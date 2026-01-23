package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.MemoryPolicyRequest;
import xsj.auto.ops.plat.api.response.MemoryPolicyResponse;

import java.util.List;

public interface MemoryPolicyCase {

    List<MemoryPolicyResponse> list();

    MemoryPolicyResponse getById(Long id);

    MemoryPolicyResponse create(MemoryPolicyRequest request);

    MemoryPolicyResponse update(MemoryPolicyRequest request);

    void delete(Long id);
}
