package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.McpServiceServiceApi;
import xsj.auto.ops.plat.api.request.McpServiceRequest;
import xsj.auto.ops.plat.api.response.McpServiceResponse;
import xsj.auto.ops.plat.application.entityCase.impl.McpServiceCaseImpl;

import java.util.List;

@RestController
@RequestMapping("/mcp/service")
@RequiredArgsConstructor
public class McpServiceController implements McpServiceServiceApi {

    private final McpServiceCaseImpl mcpServiceCase;

    @Override
    @GetMapping("/list")
    public ResultBody<List<McpServiceResponse>> list() {
        return mcpServiceCase.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<McpServiceResponse> getById(@PathVariable Long id) {
        return mcpServiceCase.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<McpServiceResponse> create(@RequestBody McpServiceRequest request) {
        return mcpServiceCase.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<McpServiceResponse> update(@RequestBody McpServiceRequest request) {
        return mcpServiceCase.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return mcpServiceCase.delete(id);
    }
}
