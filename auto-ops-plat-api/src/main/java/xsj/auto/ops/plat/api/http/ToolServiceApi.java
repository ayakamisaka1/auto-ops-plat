package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.ToolRequest;
import xsj.auto.ops.plat.api.response.ToolResponse;

import java.util.List;

public interface ToolServiceApi {

    ResultBody<List<ToolResponse>> list();

    ResultBody<ToolResponse> getById(Long id);

    ResultBody<ToolResponse> create(ToolRequest request);

    ResultBody<ToolResponse> update(ToolRequest request);

    ResultBody<Void> delete(Long id);
}
