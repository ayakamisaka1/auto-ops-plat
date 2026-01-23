package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.ConversationRequest;
import xsj.auto.ops.plat.api.response.ConversationResponse;

import java.util.List;

public interface ConversationServiceApi {

    ResultBody<List<ConversationResponse>> list();

    ResultBody<ConversationResponse> getById(Long id);

    ResultBody<ConversationResponse> create(ConversationRequest request);

    ResultBody<ConversationResponse> update(ConversationRequest request);

    ResultBody<Void> delete(Long id);
}
