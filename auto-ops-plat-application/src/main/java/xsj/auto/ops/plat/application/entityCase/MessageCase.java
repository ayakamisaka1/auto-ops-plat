package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.MessageRequest;
import xsj.auto.ops.plat.api.response.MessageResponse;

import java.util.List;

public interface MessageCase {

    List<MessageResponse> list();

    MessageResponse getById(Long id);

    MessageResponse create(MessageRequest request);

    MessageResponse update(MessageRequest request);

    void delete(Long id);
}
