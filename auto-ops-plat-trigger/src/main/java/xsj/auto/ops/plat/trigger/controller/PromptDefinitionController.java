package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.PromptDefinitionServiceApi;
import xsj.auto.ops.plat.api.request.PromptDefinitionRequest;
import xsj.auto.ops.plat.api.response.PromptDefinitionResponse;

import java.util.List;

@RestController
@RequestMapping("/prompt/definition")
@RequiredArgsConstructor
public class PromptDefinitionController implements PromptDefinitionServiceApi {

    private final PromptDefinitionServiceApi promptDefinitionServiceApi;

    @Override
    @GetMapping("/list")
    public ResultBody<List<PromptDefinitionResponse>> list() {
        return promptDefinitionServiceApi.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<PromptDefinitionResponse> getById(@PathVariable Long id) {
        return promptDefinitionServiceApi.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<PromptDefinitionResponse> create(@RequestBody PromptDefinitionRequest request) {
        return promptDefinitionServiceApi.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<PromptDefinitionResponse> update(@RequestBody PromptDefinitionRequest request) {
        return promptDefinitionServiceApi.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return promptDefinitionServiceApi.delete(id);
    }
}
