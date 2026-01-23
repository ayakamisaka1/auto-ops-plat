package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.RagDocumentRequest;
import xsj.auto.ops.plat.api.response.RagDocumentResponse;

import java.util.List;

public interface RagDocumentServiceApi {

    ResultBody<List<RagDocumentResponse>> list();

    ResultBody<RagDocumentResponse> getById(Long id);

    ResultBody<RagDocumentResponse> create(RagDocumentRequest request);

    ResultBody<RagDocumentResponse> update(RagDocumentRequest request);

    ResultBody<Void> delete(Long id);
}
