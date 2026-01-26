package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.ConversationServiceApi;
import xsj.auto.ops.plat.api.request.ConversationRequest;
import xsj.auto.ops.plat.api.response.ConversationResponse;
import xsj.auto.ops.plat.application.entityCase.ConversationCase;
import xsj.auto.ops.plat.domain.entity.Conversation;
import xsj.auto.ops.plat.domain.repository.ConversationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConversationCaseImpl implements ConversationServiceApi {

    private final ConversationRepository conversationRepository;

    @Override
    public ResultBody<List<ConversationResponse>> list() {
        return ResultBody.ok(conversationRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<ConversationResponse> getById(Long id) {
        return conversationRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<ConversationResponse> create(ConversationRequest request) {
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
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<ConversationResponse> update(ConversationRequest request) {
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
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        conversationRepository.deleteById(id);
        return ResultBody.ok();
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
