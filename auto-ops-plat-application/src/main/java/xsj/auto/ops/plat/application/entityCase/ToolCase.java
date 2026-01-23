package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.ToolRequest;
import xsj.auto.ops.plat.api.response.ToolResponse;

import java.util.List;

public interface ToolCase {

    List<ToolResponse> list();

    ToolResponse getById(Long id);

    ToolResponse create(ToolRequest request);

    ToolResponse update(ToolRequest request);

    void delete(Long id);
}
