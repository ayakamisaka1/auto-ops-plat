package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.McpServiceRequest;
import xsj.auto.ops.plat.api.response.McpServiceResponse;

import java.util.List;

public interface McpServiceServiceApi {

    ResultBody<List<McpServiceResponse>> list();

    ResultBody<McpServiceResponse> getById(Long id);

    ResultBody<McpServiceResponse> create(McpServiceRequest request);

    ResultBody<McpServiceResponse> update(McpServiceRequest request);

    ResultBody<Void> delete(Long id);
}
