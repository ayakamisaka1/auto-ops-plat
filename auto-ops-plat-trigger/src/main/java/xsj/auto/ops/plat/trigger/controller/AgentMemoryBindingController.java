package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.AgentMemoryBindingServiceApi;
import xsj.auto.ops.plat.api.request.AgentMemoryBindingRequest;
import xsj.auto.ops.plat.api.response.AgentMemoryBindingResponse;
import xsj.auto.ops.plat.application.entityCase.AgentMemoryBindingService;

import java.util.List;

@RestController
@RequestMapping("/memory/agent-memory-binding")
@RequiredArgsConstructor
public class AgentMemoryBindingController implements AgentMemoryBindingServiceApi {

    private final AgentMemoryBindingService agentMemoryBindingCase;

    @Override
    @GetMapping("/list")
    public ResultBody<List<AgentMemoryBindingResponse>> list() {
        return ResultBody.ok(agentMemoryBindingCase.list());
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<AgentMemoryBindingResponse> getById(@PathVariable Long id) {
        return ResultBody.ok(agentMemoryBindingCase.getById(id));
    }

    @Override
    @PostMapping
    public ResultBody<AgentMemoryBindingResponse> create(@RequestBody AgentMemoryBindingRequest request) {
        return ResultBody.ok(agentMemoryBindingCase.create(request));
    }

    @Override
    @PutMapping
    public ResultBody<AgentMemoryBindingResponse> update(@RequestBody AgentMemoryBindingRequest request) {
        return ResultBody.ok(agentMemoryBindingCase.update(request));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        agentMemoryBindingCase.delete(id);
        return ResultBody.ok();
    }
}