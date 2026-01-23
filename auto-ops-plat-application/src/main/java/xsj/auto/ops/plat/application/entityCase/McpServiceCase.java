package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.McpServiceRequest;
import xsj.auto.ops.plat.api.response.McpServiceResponse;

import java.util.List;

public interface McpServiceCase {

    List<McpServiceResponse> list();

    McpServiceResponse getById(Long id);

    McpServiceResponse create(McpServiceRequest request);

    McpServiceResponse update(McpServiceRequest request);

    void delete(Long id);
}
