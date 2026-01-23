package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.PromptCapabilityConstraintRequest;
import xsj.auto.ops.plat.api.response.PromptCapabilityConstraintResponse;

import java.util.List;

public interface PromptCapabilityConstraintServiceApi {

    ResultBody<List<PromptCapabilityConstraintResponse>> list();

    ResultBody<PromptCapabilityConstraintResponse> getById(Long id);

    ResultBody<PromptCapabilityConstraintResponse> create(PromptCapabilityConstraintRequest request);

    ResultBody<PromptCapabilityConstraintResponse> update(PromptCapabilityConstraintRequest request);

    ResultBody<Void> delete(Long id);
}
