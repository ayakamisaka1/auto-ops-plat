package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.McpConnectionConfigServiceApi;
import xsj.auto.ops.plat.api.request.McpConnectionConfigRequest;
import xsj.auto.ops.plat.api.response.McpConnectionConfigResponse;

import java.util.List;

@RestController
@RequestMapping("/mcp/connection-config")
@RequiredArgsConstructor
public class McpConnectionConfigController implements McpConnectionConfigServiceApi {

    private final McpConnectionConfigServiceApi mcpConnectionConfigServiceApi;

    @Override
    @GetMapping("/list")
    public ResultBody<List<McpConnectionConfigResponse>> list() {
        return mcpConnectionConfigServiceApi.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<McpConnectionConfigResponse> getById(@PathVariable Long id) {
        return mcpConnectionConfigServiceApi.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<McpConnectionConfigResponse> create(@RequestBody McpConnectionConfigRequest request) {
        return mcpConnectionConfigServiceApi.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<McpConnectionConfigResponse> update(@RequestBody McpConnectionConfigRequest request) {
        return mcpConnectionConfigServiceApi.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return mcpConnectionConfigServiceApi.delete(id);
    }
}
