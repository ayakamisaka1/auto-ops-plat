package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.RagRetrievalStrategyServiceApi;
import xsj.auto.ops.plat.api.request.RagRetrievalStrategyRequest;
import xsj.auto.ops.plat.api.response.RagRetrievalStrategyResponse;
import xsj.auto.ops.plat.application.entityCase.RagRetrievalStrategyCase;
import xsj.auto.ops.plat.domain.entity.RagRetrievalStrategy;
import xsj.auto.ops.plat.domain.repository.RagRetrievalStrategyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RagRetrievalStrategyCaseImpl implements RagRetrievalStrategyServiceApi {

    private final RagRetrievalStrategyRepository ragRetrievalStrategyRepository;

    @Override
    public ResultBody<List<RagRetrievalStrategyResponse>> list() {
        return ResultBody.ok(ragRetrievalStrategyRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<RagRetrievalStrategyResponse> getById(Long id) {
        return ragRetrievalStrategyRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<RagRetrievalStrategyResponse> create(RagRetrievalStrategyRequest request) {
        RagRetrievalStrategy entity = RagRetrievalStrategy.create(
                null,
                request.getStrategyName(),
                request.getTopK(),
                request.getScoreThreshold(),
                request.getFilterCondition(),
                request.getRerankModelId(),
                request.getPromptTemplate()
        );
        ragRetrievalStrategyRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<RagRetrievalStrategyResponse> update(RagRetrievalStrategyRequest request) {
        RagRetrievalStrategy entity = RagRetrievalStrategy.create(
                request.getId(),
                request.getStrategyName(),
                request.getTopK(),
                request.getScoreThreshold(),
                request.getFilterCondition(),
                request.getRerankModelId(),
                request.getPromptTemplate()
        );
        ragRetrievalStrategyRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        ragRetrievalStrategyRepository.deleteById(id);
        return ResultBody.ok();
    }

    private RagRetrievalStrategyResponse toResponse(RagRetrievalStrategy entity) {
        return new RagRetrievalStrategyResponse(
                entity.getId(),
                entity.getStrategyName(),
                entity.getTopK(),
                entity.getScoreThreshold(),
                entity.getFilterCondition(),
                entity.getRerankModelId(),
                entity.getPromptTemplate()
        );
    }
}
