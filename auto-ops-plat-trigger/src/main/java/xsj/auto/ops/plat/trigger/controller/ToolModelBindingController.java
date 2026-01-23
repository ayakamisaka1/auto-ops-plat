package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.ToolModelBindingServiceApi;
import xsj.auto.ops.plat.api.request.ToolModelBindingRequest;
import xsj.auto.ops.plat.api.response.ToolModelBindingResponse;

import java.util.List;

@RestController
@RequestMapping("/mcp/tool-model-binding")
@RequiredArgsConstructor
public class ToolModelBindingController implements ToolModelBindingServiceApi {

    private final ToolModelBindingServiceApi toolModelBindingServiceApi;

    @Override
    @GetMapping("/list")
    public ResultBody<List<ToolModelBindingResponse>> list() {
        return toolModelBindingServiceApi.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<ToolModelBindingResponse> getById(@PathVariable Long id) {
        return toolModelBindingServiceApi.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<ToolModelBindingResponse> create(@RequestBody ToolModelBindingRequest request) {
        return toolModelBindingServiceApi.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<ToolModelBindingResponse> update(@RequestBody ToolModelBindingRequest request) {
        return toolModelBindingServiceApi.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return toolModelBindingServiceApi.delete(id);
    }
}
