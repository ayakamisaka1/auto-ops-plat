package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.PromptDefinitionRequest;
import xsj.auto.ops.plat.api.response.PromptDefinitionResponse;

import java.util.List;

public interface PromptDefinitionServiceApi {

    ResultBody<List<PromptDefinitionResponse>> list();

    ResultBody<PromptDefinitionResponse> getById(Long id);

    ResultBody<PromptDefinitionResponse> create(PromptDefinitionRequest request);

    ResultBody<PromptDefinitionResponse> update(PromptDefinitionRequest request);

    ResultBody<Void> delete(Long id);
}
