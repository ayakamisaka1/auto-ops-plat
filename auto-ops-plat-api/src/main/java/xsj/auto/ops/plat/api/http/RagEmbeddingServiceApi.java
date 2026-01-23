package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.RagEmbeddingRequest;
import xsj.auto.ops.plat.api.response.RagEmbeddingResponse;

import java.util.List;

public interface RagEmbeddingServiceApi {

    ResultBody<List<RagEmbeddingResponse>> list();

    ResultBody<RagEmbeddingResponse> getById(Long id);

    ResultBody<RagEmbeddingResponse> create(RagEmbeddingRequest request);

    ResultBody<RagEmbeddingResponse> update(RagEmbeddingRequest request);

    ResultBody<Void> delete(Long id);
}
