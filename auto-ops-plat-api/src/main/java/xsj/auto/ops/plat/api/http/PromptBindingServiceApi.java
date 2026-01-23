package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.PromptBindingRequest;
import xsj.auto.ops.plat.api.response.PromptBindingResponse;

import java.util.List;

public interface PromptBindingServiceApi {

    ResultBody<List<PromptBindingResponse>> list();

    ResultBody<PromptBindingResponse> getById(Long id);

    ResultBody<PromptBindingResponse> create(PromptBindingRequest request);

    ResultBody<PromptBindingResponse> update(PromptBindingRequest request);

    ResultBody<Void> delete(Long id);
}
