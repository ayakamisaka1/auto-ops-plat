package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.RagDocumentServiceApi;
import xsj.auto.ops.plat.api.request.RagDocumentRequest;
import xsj.auto.ops.plat.api.response.RagDocumentResponse;

import java.util.List;

@RestController
@RequestMapping("/rag/document")
@RequiredArgsConstructor
public class RagDocumentController implements RagDocumentServiceApi {

    private final RagDocumentServiceApi ragDocumentServiceApi;

    @Override
    @GetMapping("/list")
    public ResultBody<List<RagDocumentResponse>> list() {
        return ragDocumentServiceApi.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<RagDocumentResponse> getById(@PathVariable Long id) {
        return ragDocumentServiceApi.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<RagDocumentResponse> create(@RequestBody RagDocumentRequest request) {
        return ragDocumentServiceApi.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<RagDocumentResponse> update(@RequestBody RagDocumentRequest request) {
        return ragDocumentServiceApi.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return ragDocumentServiceApi.delete(id);
    }
}
