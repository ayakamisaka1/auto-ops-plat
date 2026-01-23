package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.MessageRequest;
import xsj.auto.ops.plat.api.response.MessageResponse;

import java.util.List;

public interface MessageServiceApi {

    ResultBody<List<MessageResponse>> list();

    ResultBody<MessageResponse> getById(Long id);

    ResultBody<MessageResponse> create(MessageRequest request);

    ResultBody<MessageResponse> update(MessageRequest request);

    ResultBody<Void> delete(Long id);
}
