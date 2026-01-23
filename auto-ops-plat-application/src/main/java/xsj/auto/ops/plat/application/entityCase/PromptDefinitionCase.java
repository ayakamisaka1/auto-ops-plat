package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.PromptDefinitionRequest;
import xsj.auto.ops.plat.api.response.PromptDefinitionResponse;

import java.util.List;

public interface PromptDefinitionCase {

    List<PromptDefinitionResponse> list();

    PromptDefinitionResponse getById(Long id);

    PromptDefinitionResponse create(PromptDefinitionRequest request);

    PromptDefinitionResponse update(PromptDefinitionRequest request);

    void delete(Long id);
}
