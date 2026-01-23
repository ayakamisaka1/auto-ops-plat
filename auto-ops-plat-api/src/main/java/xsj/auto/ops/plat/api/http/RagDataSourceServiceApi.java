package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.RagDataSourceRequest;
import xsj.auto.ops.plat.api.response.RagDataSourceResponse;

import java.util.List;

public interface RagDataSourceServiceApi {

    ResultBody<List<RagDataSourceResponse>> list();

    ResultBody<RagDataSourceResponse> getById(Long id);

    ResultBody<RagDataSourceResponse> create(RagDataSourceRequest request);

    ResultBody<RagDataSourceResponse> update(RagDataSourceRequest request);

    ResultBody<Void> delete(Long id);
}
