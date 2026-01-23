package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.request.RagChunkRequest;
import xsj.auto.ops.plat.api.response.RagChunkResponse;
import xsj.auto.ops.plat.application.entityCase.RagChunkCase;
import xsj.auto.ops.plat.domain.entity.RagChunk;
import xsj.auto.ops.plat.domain.repository.RagChunkRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RagChunkCaseImpl implements RagChunkCase {

    private final RagChunkRepository ragChunkRepository;

    @Override
    public List<RagChunkResponse> list() {
        return ragChunkRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RagChunkResponse getById(Long id) {
        return ragChunkRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    @Override
    @Transactional
    public RagChunkResponse create(RagChunkRequest request) {
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
        return toResponse(entity);
    }

    @Override
    @Transactional
    public RagChunkResponse update(RagChunkRequest request) {
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
        return toResponse(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ragChunkRepository.deleteById(id);
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
