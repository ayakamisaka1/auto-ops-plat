package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.ToolServiceApi;
import xsj.auto.ops.plat.api.request.ToolRequest;
import xsj.auto.ops.plat.api.response.ToolResponse;

import java.util.List;

@RestController
@RequestMapping("/mcp/tool")
@RequiredArgsConstructor
public class ToolController implements ToolServiceApi {

    private final ToolServiceApi toolServiceApi;

    @Override
    @GetMapping("/list")
    public ResultBody<List<ToolResponse>> list() {
        return toolServiceApi.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<ToolResponse> getById(@PathVariable Long id) {
        return toolServiceApi.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<ToolResponse> create(@RequestBody ToolRequest request) {
        return toolServiceApi.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<ToolResponse> update(@RequestBody ToolRequest request) {
        return toolServiceApi.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return toolServiceApi.delete(id);
    }
}
