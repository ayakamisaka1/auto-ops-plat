package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.PromptCapabilityConstraintServiceApi;
import xsj.auto.ops.plat.api.request.PromptCapabilityConstraintRequest;
import xsj.auto.ops.plat.api.response.PromptCapabilityConstraintResponse;
import xsj.auto.ops.plat.application.entityCase.impl.PromptCapabilityConstraintCaseImpl;

import java.util.List;

@RestController
@RequestMapping("/prompt/capability-constraint")
@RequiredArgsConstructor
public class PromptCapabilityConstraintController implements PromptCapabilityConstraintServiceApi {

    private final PromptCapabilityConstraintCaseImpl promptCapabilityConstraintCase;

    @Override
    @GetMapping("/list")
    public ResultBody<List<PromptCapabilityConstraintResponse>> list() {
        return promptCapabilityConstraintCase.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<PromptCapabilityConstraintResponse> getById(@PathVariable Long id) {
        return promptCapabilityConstraintCase.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<PromptCapabilityConstraintResponse> create(@RequestBody PromptCapabilityConstraintRequest request) {
        return promptCapabilityConstraintCase.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<PromptCapabilityConstraintResponse> update(@RequestBody PromptCapabilityConstraintRequest request) {
        return promptCapabilityConstraintCase.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return promptCapabilityConstraintCase.delete(id);
    }
}
