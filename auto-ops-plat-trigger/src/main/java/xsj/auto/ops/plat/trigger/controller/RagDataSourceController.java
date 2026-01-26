package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.RagDataSourceServiceApi;
import xsj.auto.ops.plat.api.request.RagDataSourceRequest;
import xsj.auto.ops.plat.api.response.RagDataSourceResponse;
import xsj.auto.ops.plat.application.entityCase.RagDataSourceCase;

import java.util.List;

@RestController
@RequestMapping("/rag/data-source")
@RequiredArgsConstructor
public class RagDataSourceController implements RagDataSourceServiceApi {

    private final RagDataSourceCase ragDataSourceCase;

    @Override
    @GetMapping("/list")
    public ResultBody<List<RagDataSourceResponse>> list() {
        return ragDataSourceCase.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<RagDataSourceResponse> getById(@PathVariable Long id) {
        return ragDataSourceCase.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<RagDataSourceResponse> create(@RequestBody RagDataSourceRequest request) {
        return ragDataSourceCase.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<RagDataSourceResponse> update(@RequestBody RagDataSourceRequest request) {
        return ragDataSourceCase.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return ragDataSourceCase.delete(id);
    }
}
