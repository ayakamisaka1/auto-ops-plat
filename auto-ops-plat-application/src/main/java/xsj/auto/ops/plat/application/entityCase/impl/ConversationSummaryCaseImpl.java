package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.ConversationSummaryServiceApi;
import xsj.auto.ops.plat.api.request.ConversationSummaryRequest;
import xsj.auto.ops.plat.api.response.ConversationSummaryResponse;
import xsj.auto.ops.plat.application.entityCase.ConversationSummaryCase;
import xsj.auto.ops.plat.domain.entity.ConversationSummary;
import xsj.auto.ops.plat.domain.repository.ConversationSummaryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConversationSummaryCaseImpl implements ConversationSummaryServiceApi {

    private final ConversationSummaryRepository conversationSummaryRepository;

    @Override
    public ResultBody<List<ConversationSummaryResponse>> list() {
        return ResultBody.ok(conversationSummaryRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<ConversationSummaryResponse> getById(Long id) {
        return conversationSummaryRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<ConversationSummaryResponse> create(ConversationSummaryRequest request) {
        ConversationSummary entity = ConversationSummary.create(
                null,
                request.getConversationId(),
                request.getSummaryType(),
                request.getSummaryContent(),
                request.getSummaryVersion(),
                request.getTokenCount()
        );
        conversationSummaryRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<ConversationSummaryResponse> update(ConversationSummaryRequest request) {
        ConversationSummary entity = ConversationSummary.create(
                request.getId(),
                request.getConversationId(),
                request.getSummaryType(),
                request.getSummaryContent(),
                request.getSummaryVersion(),
                request.getTokenCount()
        );
        conversationSummaryRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        conversationSummaryRepository.deleteById(id);
        return ResultBody.ok();
    }

    private ConversationSummaryResponse toResponse(ConversationSummary entity) {
        return new ConversationSummaryResponse(
                entity.getId(),
                entity.getConversationId(),
                entity.getSummaryType(),
                entity.getSummaryContent(),
                entity.getSummaryVersion(),
                entity.getTokenCount()
        );
    }
}
