package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.PromptBindingRequest;
import xsj.auto.ops.plat.api.response.PromptBindingResponse;

import java.util.List;

public interface PromptBindingCase {

    List<PromptBindingResponse> list();

    PromptBindingResponse getById(Long id);

    PromptBindingResponse create(PromptBindingRequest request);

    PromptBindingResponse update(PromptBindingRequest request);

    void delete(Long id);
}
