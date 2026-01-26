package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.RagDocumentServiceApi;
import xsj.auto.ops.plat.api.request.RagDocumentRequest;
import xsj.auto.ops.plat.api.response.RagDocumentResponse;
import xsj.auto.ops.plat.application.entityCase.RagDocumentCase;
import xsj.auto.ops.plat.domain.entity.RagDocument;
import xsj.auto.ops.plat.domain.repository.RagDocumentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RagDocumentCaseImpl implements RagDocumentServiceApi {

    private final RagDocumentRepository ragDocumentRepository;

    @Override
    public ResultBody<List<RagDocumentResponse>> list() {
        return ResultBody.ok(ragDocumentRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<RagDocumentResponse> getById(Long id) {
        return ragDocumentRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<RagDocumentResponse> create(RagDocumentRequest request) {
        RagDocument entity = RagDocument.create(
                null,
                request.getSourceId(),
                request.getDocName(),
                request.getDocType(),
                request.getRawContent(),
                request.getMeta(),
                request.getStatus(),
                request.getVersion()
        );
        ragDocumentRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<RagDocumentResponse> update(RagDocumentRequest request) {
        RagDocument entity = RagDocument.create(
                request.getId(),
                request.getSourceId(),
                request.getDocName(),
                request.getDocType(),
                request.getRawContent(),
                request.getMeta(),
                request.getStatus(),
                request.getVersion()
        );
        ragDocumentRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        ragDocumentRepository.deleteById(id);
        return ResultBody.ok();
    }

    private RagDocumentResponse toResponse(RagDocument entity) {
        return new RagDocumentResponse(
                entity.getId(),
                entity.getSourceId(),
                entity.getDocName(),
                entity.getDocType(),
                entity.getRawContent(),
                entity.getMeta(),
                entity.getStatus(),
                entity.getVersion()
        );
    }
}
