package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.ToolModelBindingRequest;
import xsj.auto.ops.plat.api.response.ToolModelBindingResponse;

import java.util.List;

public interface ToolModelBindingServiceApi {

    ResultBody<List<ToolModelBindingResponse>> list();

    ResultBody<ToolModelBindingResponse> getById(Long id);

    ResultBody<ToolModelBindingResponse> create(ToolModelBindingRequest request);

    ResultBody<ToolModelBindingResponse> update(ToolModelBindingRequest request);

    ResultBody<Void> delete(Long id);
}
