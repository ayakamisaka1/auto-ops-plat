package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.request.RagEmbeddingRequest;
import xsj.auto.ops.plat.api.response.RagEmbeddingResponse;
import xsj.auto.ops.plat.application.entityCase.RagEmbeddingCase;
import xsj.auto.ops.plat.domain.entity.RagEmbedding;
import xsj.auto.ops.plat.domain.repository.RagEmbeddingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RagEmbeddingCaseImpl implements RagEmbeddingCase {

    private final RagEmbeddingRepository ragEmbeddingRepository;

    @Override
    public List<RagEmbeddingResponse> list() {
        return ragEmbeddingRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RagEmbeddingResponse getById(Long id) {
        return ragEmbeddingRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    @Override
    @Transactional
    public RagEmbeddingResponse create(RagEmbeddingRequest request) {
        RagEmbedding entity = RagEmbedding.create(
                null,
                request.getChunkId(),
                request.getEmbeddingModelId(),
                request.getVector(),
                request.getVectorDim(),
                request.getStatus()
        );
        ragEmbeddingRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public RagEmbeddingResponse update(RagEmbeddingRequest request) {
        RagEmbedding entity = RagEmbedding.create(
                request.getId(),
                request.getChunkId(),
                request.getEmbeddingModelId(),
                request.getVector(),
                request.getVectorDim(),
                request.getStatus()
        );
        ragEmbeddingRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ragEmbeddingRepository.deleteById(id);
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
