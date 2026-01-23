package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.ConversationSummaryRequest;
import xsj.auto.ops.plat.api.response.ConversationSummaryResponse;

import java.util.List;

public interface ConversationSummaryCase {

    List<ConversationSummaryResponse> list();

    ConversationSummaryResponse getById(Long id);

    ConversationSummaryResponse create(ConversationSummaryRequest request);

    ConversationSummaryResponse update(ConversationSummaryRequest request);

    void delete(Long id);
}
