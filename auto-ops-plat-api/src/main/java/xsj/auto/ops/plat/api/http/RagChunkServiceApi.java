package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.RagChunkRequest;
import xsj.auto.ops.plat.api.response.RagChunkResponse;

import java.util.List;

public interface RagChunkServiceApi {

    ResultBody<List<RagChunkResponse>> list();

    ResultBody<RagChunkResponse> getById(Long id);

    ResultBody<RagChunkResponse> create(RagChunkRequest request);

    ResultBody<RagChunkResponse> update(RagChunkRequest request);

    ResultBody<Void> delete(Long id);
}
