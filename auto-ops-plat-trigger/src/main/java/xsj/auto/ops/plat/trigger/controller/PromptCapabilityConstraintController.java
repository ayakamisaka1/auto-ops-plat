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
        return promptCapabilityConstraintService.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<PromptCapabilityConstraintResponse> getById(@PathVariable Long id) {
        return promptCapabilityConstraintService.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<PromptCapabilityConstraintResponse> create(@RequestBody PromptCapabilityConstraintRequest request) {
        return promptCapabilityConstraintService.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<PromptCapabilityConstraintResponse> update(@RequestBody PromptCapabilityConstraintRequest request) {
        return promptCapabilityConstraintService.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return promptCapabilityConstraintService.delete(id);
    }
}
