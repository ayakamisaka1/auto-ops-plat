package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.RagEmbeddingServiceApi;
import xsj.auto.ops.plat.api.request.RagEmbeddingRequest;
import xsj.auto.ops.plat.api.response.RagEmbeddingResponse;
import xsj.auto.ops.plat.application.entityCase.RagEmbeddingCase;
import xsj.auto.ops.plat.domain.entity.RagEmbedding;
import xsj.auto.ops.plat.domain.repository.RagEmbeddingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RagEmbeddingCaseImpl implements RagEmbeddingServiceApi {

    private final RagEmbeddingRepository ragEmbeddingRepository;

    @Override
    public ResultBody<List<RagEmbeddingResponse>> list() {
        return ResultBody.ok(ragEmbeddingRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<RagEmbeddingResponse> getById(Long id) {
        return ragEmbeddingRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<RagEmbeddingResponse> create(RagEmbeddingRequest request) {
        RagEmbedding entity = RagEmbedding.create(
                null,
                request.getChunkId(),
                request.getEmbeddingModelId(),
                request.getVector(),
                request.getVectorDim(),
                request.getStatus()
        );
        ragEmbeddingRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<RagEmbeddingResponse> update(RagEmbeddingRequest request) {
        RagEmbedding entity = RagEmbedding.create(
                request.getId(),
                request.getChunkId(),
                request.getEmbeddingModelId(),
                request.getVector(),
                request.getVectorDim(),
                request.getStatus()
        );
        ragEmbeddingRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        ragEmbeddingRepository.deleteById(id);
        return ResultBody.ok();
    }

    private RagEmbeddingResponse toResponse(RagEmbedding entity) {
        return new RagEmbeddingResponse(
                entity.getId(),
                entity.getChunkId(),
                entity.getEmbeddingModelId(),
                entity.getVector(),
                entity.getVectorDim(),
                entity.getStatus()
        );
    }
}
