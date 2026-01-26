package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.request.ConversationSummaryRequest;
import xsj.auto.ops.plat.api.response.ConversationSummaryResponse;
import xsj.auto.ops.plat.application.entityCase.ConversationSummaryService;
import xsj.auto.ops.plat.domain.entity.ConversationSummary;
import xsj.auto.ops.plat.domain.repository.ConversationSummaryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConversationSummaryCaseImpl implements ConversationSummaryService {

    private final ConversationSummaryRepository conversationSummaryRepository;

    @Override
    public List<ConversationSummaryResponse> list() {
        return conversationSummaryRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ConversationSummaryResponse getById(Long id) {
        return conversationSummaryRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    @Override
    @Transactional
    public ConversationSummaryResponse create(ConversationSummaryRequest request) {
        ConversationSummary entity = ConversationSummary.create(
                null,
                request.getConversationId(),
                request.getSummaryType(),
                request.getSummaryContent(),
                request.getSummaryVersion(),
                request.getTokenCount()
        );
        conversationSummaryRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public ConversationSummaryResponse update(ConversationSummaryRequest request) {
        ConversationSummary entity = ConversationSummary.create(
                request.getId(),
                request.getConversationId(),
                request.getSummaryType(),
                request.getSummaryContent(),
                request.getSummaryVersion(),
                request.getTokenCount()
        );
        conversationSummaryRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        conversationSummaryRepository.deleteById(id);
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
