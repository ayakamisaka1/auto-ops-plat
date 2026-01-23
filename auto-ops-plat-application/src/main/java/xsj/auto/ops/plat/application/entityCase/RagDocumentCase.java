package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.RagDocumentRequest;
import xsj.auto.ops.plat.api.response.RagDocumentResponse;

import java.util.List;

public interface RagDocumentCase {

    List<RagDocumentResponse> list();

    RagDocumentResponse getById(Long id);

    RagDocumentResponse create(RagDocumentRequest request);

    RagDocumentResponse update(RagDocumentRequest request);

    void delete(Long id);
}
