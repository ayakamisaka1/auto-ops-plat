package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.request.ConversationRequest;
import xsj.auto.ops.plat.api.response.ConversationResponse;
import xsj.auto.ops.plat.application.entityCase.ConversationCase;
import xsj.auto.ops.plat.domain.entity.Conversation;
import xsj.auto.ops.plat.domain.repository.ConversationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConversationCaseImpl implements ConversationCase {

    private final ConversationRepository conversationRepository;

    @Override
    public List<ConversationResponse> list() {
        return conversationRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ConversationResponse getById(Long id) {
        return conversationRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    @Override
    @Transactional
    public ConversationResponse create(ConversationRequest request) {
        Conversation entity = Conversation.create(
                null,
                request.getConversationId(),
                request.getAgentId(),
                request.getUserId(),
                request.getContextType(),
                request.getStatus(),
                request.getStartedAt(),
                request.getEndedAt()
        );
        conversationRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public ConversationResponse update(ConversationRequest request) {
        Conversation entity = Conversation.create(
                request.getId(),
                request.getConversationId(),
                request.getAgentId(),
                request.getUserId(),
                request.getContextType(),
                request.getStatus(),
                request.getStartedAt(),
                request.getEndedAt()
        );
        conversationRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        conversationRepository.deleteById(id);
    }

    private ConversationResponse toResponse(Conversation entity) {
        return new ConversationResponse(
                entity.getId(),
                entity.getConversationId(),
                entity.getAgentId(),
                entity.getUserId(),
                entity.getContextType(),
                entity.getStatus(),
                entity.getStartedAt(),
                entity.getEndedAt()
        );
    }
}
