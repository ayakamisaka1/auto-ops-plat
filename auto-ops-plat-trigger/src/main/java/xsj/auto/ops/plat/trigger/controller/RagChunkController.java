package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.RagChunkServiceApi;
import xsj.auto.ops.plat.api.request.RagChunkRequest;
import xsj.auto.ops.plat.api.response.RagChunkResponse;
import xsj.auto.ops.plat.application.entityCase.impl.RagChunkCaseImpl;

import java.util.List;

@RestController
@RequestMapping("/rag/chunk")
@RequiredArgsConstructor
public class RagChunkController implements RagChunkServiceApi {

    private final RagChunkCaseImpl ragChunkCase;

    @Override
    @GetMapping("/list")
    public ResultBody<List<RagChunkResponse>> list() {
        return ragChunkCase.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<RagChunkResponse> getById(@PathVariable Long id) {
        return ragChunkCase.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<RagChunkResponse> create(@RequestBody RagChunkRequest request) {
        return ragChunkCase.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<RagChunkResponse> update(@RequestBody RagChunkRequest request) {
        return ragChunkCase.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return ragChunkCase.delete(id);
    }
}
