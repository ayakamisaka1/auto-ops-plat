package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.RagDataSourceServiceApi;
import xsj.auto.ops.plat.api.request.RagDataSourceRequest;
import xsj.auto.ops.plat.api.response.RagDataSourceResponse;
import xsj.auto.ops.plat.application.entityCase.RagDataSourceService;

import java.util.List;

@RestController
@RequestMapping("/rag/data-source")
@RequiredArgsConstructor
public class RagDataSourceController implements RagDataSourceServiceApi {

    private final RagDataSourceService ragDataSourceService;

    @Override
    @GetMapping("/list")
    public ResultBody<List<RagDataSourceResponse>> list() {
        return ragDataSourceService.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<RagDataSourceResponse> getById(@PathVariable Long id) {
        return ragDataSourceService.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<RagDataSourceResponse> create(@RequestBody RagDataSourceRequest request) {
        return ragDataSourceService.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<RagDataSourceResponse> update(@RequestBody RagDataSourceRequest request) {
        return ragDataSourceService.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return ragDataSourceService.delete(id);
    }
}
