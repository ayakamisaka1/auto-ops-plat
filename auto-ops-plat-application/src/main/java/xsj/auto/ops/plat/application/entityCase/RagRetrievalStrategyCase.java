package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.RagRetrievalStrategyRequest;
import xsj.auto.ops.plat.api.response.RagRetrievalStrategyResponse;

import java.util.List;

public interface RagRetrievalStrategyCase {

    List<RagRetrievalStrategyResponse> list();

    RagRetrievalStrategyResponse getById(Long id);

    RagRetrievalStrategyResponse create(RagRetrievalStrategyRequest request);

    RagRetrievalStrategyResponse update(RagRetrievalStrategyRequest request);

    void delete(Long id);
}
