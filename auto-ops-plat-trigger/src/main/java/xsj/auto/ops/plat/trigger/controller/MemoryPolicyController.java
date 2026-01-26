package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.MemoryPolicyServiceApi;
import xsj.auto.ops.plat.api.request.MemoryPolicyRequest;
import xsj.auto.ops.plat.api.response.MemoryPolicyResponse;
import xsj.auto.ops.plat.application.entityCase.MemoryPolicyCase;

import java.util.List;

@RestController
@RequestMapping("/memory/policy")
@RequiredArgsConstructor
public class MemoryPolicyController implements MemoryPolicyServiceApi {

    private final MemoryPolicyCase memoryPolicyCase;

    @Override
    @GetMapping("/list")
    public ResultBody<List<MemoryPolicyResponse>> list() {
        return memoryPolicyCase.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<MemoryPolicyResponse> getById(@PathVariable Long id) {
        return memoryPolicyCase.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<MemoryPolicyResponse> create(@RequestBody MemoryPolicyRequest request) {
        return memoryPolicyCase.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<MemoryPolicyResponse> update(@RequestBody MemoryPolicyRequest request) {
        return memoryPolicyCase.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return memoryPolicyCase.delete(id);
    }
}
