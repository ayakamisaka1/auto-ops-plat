package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.McpConnectionConfigRequest;
import xsj.auto.ops.plat.api.response.McpConnectionConfigResponse;

import java.util.List;

public interface McpConnectionConfigServiceApi {

    ResultBody<List<McpConnectionConfigResponse>> list();

    ResultBody<McpConnectionConfigResponse> getById(Long id);

    ResultBody<McpConnectionConfigResponse> create(McpConnectionConfigRequest request);

    ResultBody<McpConnectionConfigResponse> update(McpConnectionConfigRequest request);

    ResultBody<Void> delete(Long id);
}
