package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.RagDocumentServiceApi;
import xsj.auto.ops.plat.api.request.RagDocumentRequest;
import xsj.auto.ops.plat.api.response.RagDocumentResponse;
import xsj.auto.ops.plat.application.entityCase.RagDocumentCase;

import java.util.List;

@RestController
@RequestMapping("/rag/document")
@RequiredArgsConstructor
public class RagDocumentController implements RagDocumentServiceApi {

    private final RagDocumentCase ragDocumentCase;

    @Override
    @GetMapping("/list")
    public ResultBody<List<RagDocumentResponse>> list() {
        return ragDocumentCase.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<RagDocumentResponse> getById(@PathVariable Long id) {
        return ragDocumentCase.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<RagDocumentResponse> create(@RequestBody RagDocumentRequest request) {
        return ragDocumentCase.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<RagDocumentResponse> update(@RequestBody RagDocumentRequest request) {
        return ragDocumentCase.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return ragDocumentCase.delete(id);
    }
}
