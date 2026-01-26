package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.RagEmbeddingServiceApi;
import xsj.auto.ops.plat.api.request.RagEmbeddingRequest;
import xsj.auto.ops.plat.api.response.RagEmbeddingResponse;
import xsj.auto.ops.plat.application.entityCase.RagEmbeddingCase;

import java.util.List;

@RestController
@RequestMapping("/rag/embedding")
@RequiredArgsConstructor
public class RagEmbeddingController implements RagEmbeddingServiceApi {

    private final RagEmbeddingCase ragEmbeddingCase;

    @Override
    @GetMapping("/list")
    public ResultBody<List<RagEmbeddingResponse>> list() {
        return ragEmbeddingCase.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<RagEmbeddingResponse> getById(@PathVariable Long id) {
        return ragEmbeddingCase.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<RagEmbeddingResponse> create(@RequestBody RagEmbeddingRequest request) {
        return ragEmbeddingCase.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<RagEmbeddingResponse> update(@RequestBody RagEmbeddingRequest request) {
        return ragEmbeddingCase.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return ragEmbeddingCase.delete(id);
    }
}
