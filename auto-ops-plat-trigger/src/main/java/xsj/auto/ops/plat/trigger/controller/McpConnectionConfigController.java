package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.McpConnectionConfigServiceApi;
import xsj.auto.ops.plat.api.request.McpConnectionConfigRequest;
import xsj.auto.ops.plat.api.response.McpConnectionConfigResponse;
import xsj.auto.ops.plat.application.entityCase.McpConnectionConfigService;

import java.util.List;

@RestController
@RequestMapping("/mcp/connection-config")
@RequiredArgsConstructor
public class McpConnectionConfigController implements McpConnectionConfigServiceApi {

    private final McpConnectionConfigService mcpConnectionConfigService;

    @Override
    @GetMapping("/list")
    public ResultBody<List<McpConnectionConfigResponse>> list() {
        return mcpConnectionConfigService.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<McpConnectionConfigResponse> getById(@PathVariable Long id) {
        return mcpConnectionConfigService.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<McpConnectionConfigResponse> create(@RequestBody McpConnectionConfigRequest request) {
        return mcpConnectionConfigService.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<McpConnectionConfigResponse> update(@RequestBody McpConnectionConfigRequest request) {
        return mcpConnectionConfigService.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return mcpConnectionConfigService.delete(id);
    }
}
