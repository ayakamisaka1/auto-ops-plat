package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.PromptCapabilityConstraintRequest;
import xsj.auto.ops.plat.api.response.PromptCapabilityConstraintResponse;

import java.util.List;

public interface PromptCapabilityConstraintCase {

    List<PromptCapabilityConstraintResponse> list();

    PromptCapabilityConstraintResponse getById(Long id);

    PromptCapabilityConstraintResponse create(PromptCapabilityConstraintRequest request);

    PromptCapabilityConstraintResponse update(PromptCapabilityConstraintRequest request);

    void delete(Long id);
}
