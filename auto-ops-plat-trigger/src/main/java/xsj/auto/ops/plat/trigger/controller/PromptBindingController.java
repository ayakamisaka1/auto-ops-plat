package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.PromptBindingServiceApi;
import xsj.auto.ops.plat.api.request.PromptBindingRequest;
import xsj.auto.ops.plat.api.response.PromptBindingResponse;
import xsj.auto.ops.plat.application.entityCase.PromptBindingCase;

import java.util.List;

@RestController
@RequestMapping("/prompt/binding")
@RequiredArgsConstructor
public class PromptBindingController implements PromptBindingServiceApi {

    private final PromptBindingCase promptBindingCase;

    @Override
    @GetMapping("/list")
    public ResultBody<List<PromptBindingResponse>> list() {
        return promptBindingCase.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<PromptBindingResponse> getById(@PathVariable Long id) {
        return promptBindingCase.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<PromptBindingResponse> create(@RequestBody PromptBindingRequest request) {
        return promptBindingCase.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<PromptBindingResponse> update(@RequestBody PromptBindingRequest request) {
        return promptBindingCase.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return promptBindingCase.delete(id);
    }
}
