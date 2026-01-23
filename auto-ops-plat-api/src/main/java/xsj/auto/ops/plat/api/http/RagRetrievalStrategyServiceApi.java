package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.RagRetrievalStrategyRequest;
import xsj.auto.ops.plat.api.response.RagRetrievalStrategyResponse;

import java.util.List;

public interface RagRetrievalStrategyServiceApi {

    ResultBody<List<RagRetrievalStrategyResponse>> list();

    ResultBody<RagRetrievalStrategyResponse> getById(Long id);

    ResultBody<RagRetrievalStrategyResponse> create(RagRetrievalStrategyRequest request);

    ResultBody<RagRetrievalStrategyResponse> update(RagRetrievalStrategyRequest request);

    ResultBody<Void> delete(Long id);
}
