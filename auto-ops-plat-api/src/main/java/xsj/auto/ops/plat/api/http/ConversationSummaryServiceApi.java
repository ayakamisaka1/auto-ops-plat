package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.ConversationSummaryRequest;
import xsj.auto.ops.plat.api.response.ConversationSummaryResponse;

import java.util.List;

public interface ConversationSummaryServiceApi {

    ResultBody<List<ConversationSummaryResponse>> list();

    ResultBody<ConversationSummaryResponse> getById(Long id);

    ResultBody<ConversationSummaryResponse> create(ConversationSummaryRequest request);

    ResultBody<ConversationSummaryResponse> update(ConversationSummaryRequest request);

    ResultBody<Void> delete(Long id);
}
