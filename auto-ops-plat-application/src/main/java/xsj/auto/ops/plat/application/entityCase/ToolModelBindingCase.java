package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.ToolModelBindingRequest;
import xsj.auto.ops.plat.api.response.ToolModelBindingResponse;

import java.util.List;

public interface ToolModelBindingCase {

    List<ToolModelBindingResponse> list();

    ToolModelBindingResponse getById(Long id);

    ToolModelBindingResponse create(ToolModelBindingRequest request);

    ToolModelBindingResponse update(ToolModelBindingRequest request);

    void delete(Long id);
}
