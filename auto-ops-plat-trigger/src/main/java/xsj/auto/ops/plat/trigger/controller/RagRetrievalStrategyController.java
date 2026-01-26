package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.RagRetrievalStrategyServiceApi;
import xsj.auto.ops.plat.api.request.RagRetrievalStrategyRequest;
import xsj.auto.ops.plat.api.response.RagRetrievalStrategyResponse;
import xsj.auto.ops.plat.application.entityCase.RagRetrievalStrategyService;

import java.util.List;

@RestController
@RequestMapping("/rag/retrieval-strategy")
@RequiredArgsConstructor
public class RagRetrievalStrategyController implements RagRetrievalStrategyServiceApi {

    private final RagRetrievalStrategyService ragRetrievalStrategyService;

    @Override
    @GetMapping("/list")
    public ResultBody<List<RagRetrievalStrategyResponse>> list() {
        return ragRetrievalStrategyService.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<RagRetrievalStrategyResponse> getById(@PathVariable Long id) {
        return ragRetrievalStrategyService.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<RagRetrievalStrategyResponse> create(@RequestBody RagRetrievalStrategyRequest request) {
        return ragRetrievalStrategyService.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<RagRetrievalStrategyResponse> update(@RequestBody RagRetrievalStrategyRequest request) {
        return ragRetrievalStrategyService.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return ragRetrievalStrategyService.delete(id);
    }
}
