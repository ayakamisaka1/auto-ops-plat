package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.MemoryPolicyServiceApi;
import xsj.auto.ops.plat.api.request.MemoryPolicyRequest;
import xsj.auto.ops.plat.api.response.MemoryPolicyResponse;
import xsj.auto.ops.plat.application.entityCase.MemoryPolicyService;

import java.util.List;

@RestController
@RequestMapping("/memory/policy")
@RequiredArgsConstructor
public class MemoryPolicyController implements MemoryPolicyServiceApi {

    private final MemoryPolicyService memoryPolicyService;

    @Override
    @GetMapping("/list")
    public ResultBody<List<MemoryPolicyResponse>> list() {
        return ResultBody.ok(memoryPolicyService.list());
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<MemoryPolicyResponse> getById(@PathVariable Long id) {
        return ResultBody.ok(memoryPolicyService.getById(id));
    }

    @Override
    @PostMapping
    public ResultBody<MemoryPolicyResponse> create(@RequestBody MemoryPolicyRequest request) {
        return ResultBody.ok(memoryPolicyService.create(request));
    }

    @Override
    @PutMapping
    public ResultBody<MemoryPolicyResponse> update(@RequestBody MemoryPolicyRequest request) {
        return ResultBody.ok(memoryPolicyService.update(request));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        memoryPolicyService.delete(id);
        return ResultBody.ok();
    }
}
