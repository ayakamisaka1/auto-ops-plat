package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.RagChunkServiceApi;
import xsj.auto.ops.plat.api.request.RagChunkRequest;
import xsj.auto.ops.plat.api.response.RagChunkResponse;
import xsj.auto.ops.plat.application.entityCase.RagChunkCase;
import xsj.auto.ops.plat.domain.entity.RagChunk;
import xsj.auto.ops.plat.domain.repository.RagChunkRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RagChunkCaseImpl implements RagChunkServiceApi {

    private final RagChunkRepository ragChunkRepository;

    @Override
    public ResultBody<List<RagChunkResponse>> list() {
        return ResultBody.ok(ragChunkRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<RagChunkResponse> getById(Long id) {
        return ragChunkRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<RagChunkResponse> create(RagChunkRequest request) {
        RagChunk entity = RagChunk.create(
                null,
                request.getDocumentId(),
                request.getChunkIndex(),
                request.getContent(),
                request.getTokenSize(),
                request.getChunkStrategy(),
                request.getMeta()
        );
        ragChunkRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<RagChunkResponse> update(RagChunkRequest request) {
        RagChunk entity = RagChunk.create(
                request.getId(),
                request.getDocumentId(),
                request.getChunkIndex(),
                request.getContent(),
                request.getTokenSize(),
                request.getChunkStrategy(),
                request.getMeta()
        );
        ragChunkRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        ragChunkRepository.deleteById(id);
        return ResultBody.ok();
    }

    private RagChunkResponse toResponse(RagChunk entity) {
        return new RagChunkResponse(
                entity.getId(),
                entity.getDocumentId(),
                entity.getChunkIndex(),
                entity.getContent(),
                entity.getTokenSize(),
                entity.getChunkStrategy(),
                entity.getMeta()
        );
    }
}
