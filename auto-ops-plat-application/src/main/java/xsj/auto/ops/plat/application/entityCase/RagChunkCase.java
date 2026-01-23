package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.RagChunkRequest;
import xsj.auto.ops.plat.api.response.RagChunkResponse;

import java.util.List;

public interface RagChunkCase {

    List<RagChunkResponse> list();

    RagChunkResponse getById(Long id);

    RagChunkResponse create(RagChunkRequest request);

    RagChunkResponse update(RagChunkRequest request);

    void delete(Long id);
}
