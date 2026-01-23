package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.McpConnectionConfigRequest;
import xsj.auto.ops.plat.api.response.McpConnectionConfigResponse;

import java.util.List;

public interface McpConnectionConfigCase {

    List<McpConnectionConfigResponse> list();

    McpConnectionConfigResponse getById(Long id);

    McpConnectionConfigResponse create(McpConnectionConfigRequest request);

    McpConnectionConfigResponse update(McpConnectionConfigRequest request);

    void delete(Long id);
}
