package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.PromptCapabilityConstraintServiceApi;
import xsj.auto.ops.plat.api.request.PromptCapabilityConstraintRequest;
import xsj.auto.ops.plat.api.response.PromptCapabilityConstraintResponse;

import java.util.List;

@RestController
@RequestMapping("/prompt/capability-constraint")
@RequiredArgsConstructor
public class PromptCapabilityConstraintController implements PromptCapabilityConstraintServiceApi {

    private final PromptCapabilityConstraintServiceApi promptCapabilityConstraintServiceApi;

    @Override
    @GetMapping("/list")
    public ResultBody<List<PromptCapabilityConstraintResponse>> list() {
        return promptCapabilityConstraintServiceApi.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<PromptCapabilityConstraintResponse> getById(@PathVariable Long id) {
        return promptCapabilityConstraintServiceApi.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<PromptCapabilityConstraintResponse> create(@RequestBody PromptCapabilityConstraintRequest request) {
        return promptCapabilityConstraintServiceApi.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<PromptCapabilityConstraintResponse> update(@RequestBody PromptCapabilityConstraintRequest request) {
        return promptCapabilityConstraintServiceApi.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return promptCapabilityConstraintServiceApi.delete(id);
    }
}
