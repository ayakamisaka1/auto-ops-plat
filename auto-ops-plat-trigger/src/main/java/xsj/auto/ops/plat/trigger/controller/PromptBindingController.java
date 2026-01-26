package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.PromptBindingServiceApi;
import xsj.auto.ops.plat.api.request.PromptBindingRequest;
import xsj.auto.ops.plat.api.response.PromptBindingResponse;
import xsj.auto.ops.plat.application.entityCase.PromptBindingService;

import java.util.List;

@RestController
@RequestMapping("/prompt/binding")
@RequiredArgsConstructor
public class PromptBindingController implements PromptBindingServiceApi {

    private final PromptBindingService promptBindingService;

    @Override
    @GetMapping("/list")
    public ResultBody<List<PromptBindingResponse>> list() {
        return promptBindingService.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<PromptBindingResponse> getById(@PathVariable Long id) {
        return promptBindingService.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<PromptBindingResponse> create(@RequestBody PromptBindingRequest request) {
        return promptBindingService.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<PromptBindingResponse> update(@RequestBody PromptBindingRequest request) {
        return promptBindingService.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return promptBindingService.delete(id);
    }
}
