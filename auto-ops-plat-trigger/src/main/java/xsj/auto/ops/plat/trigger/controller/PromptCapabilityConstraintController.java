package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.PromptCapabilityConstraintServiceApi;
import xsj.auto.ops.plat.api.request.PromptCapabilityConstraintRequest;
import xsj.auto.ops.plat.api.response.PromptCapabilityConstraintResponse;
import xsj.auto.ops.plat.application.entityCase.PromptCapabilityConstraintService;

import java.util.List;

@RestController
@RequestMapping("/prompt/capability-constraint")
@RequiredArgsConstructor
public class PromptCapabilityConstraintController implements PromptCapabilityConstraintServiceApi {

    private final PromptCapabilityConstraintService promptCapabilityConstraintService;

    @Override
    @GetMapping("/list")
    public ResultBody<List<PromptCapabilityConstraintResponse>> list() {
        return ResultBody.ok(promptCapabilityConstraintService.list());
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<PromptCapabilityConstraintResponse> getById(@PathVariable Long id) {
        return ResultBody.ok(promptCapabilityConstraintService.getById(id));
    }

    @Override
    @PostMapping
    public ResultBody<PromptCapabilityConstraintResponse> create(@RequestBody PromptCapabilityConstraintRequest request) {
        return ResultBody.ok(promptCapabilityConstraintService.create(request));
    }

    @Override
    @PutMapping
    public ResultBody<PromptCapabilityConstraintResponse> update(@RequestBody PromptCapabilityConstraintRequest request) {
        return ResultBody.ok(promptCapabilityConstraintService.update(request));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        promptCapabilityConstraintService.delete(id);
        return ResultBody.ok();
    }
}
