package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.ConversationRequest;
import xsj.auto.ops.plat.api.response.ConversationResponse;

import java.util.List;

public interface ConversationCase {

    List<ConversationResponse> list();

    ConversationResponse getById(Long id);

    ConversationResponse create(ConversationRequest request);

    ConversationResponse update(ConversationRequest request);

    void delete(Long id);
}
