package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.RagEmbeddingRequest;
import xsj.auto.ops.plat.api.response.RagEmbeddingResponse;

import java.util.List;

public interface RagEmbeddingCase {

    List<RagEmbeddingResponse> list();

    RagEmbeddingResponse getById(Long id);

    RagEmbeddingResponse create(RagEmbeddingRequest request);

    RagEmbeddingResponse update(RagEmbeddingRequest request);

    void delete(Long id);
}
