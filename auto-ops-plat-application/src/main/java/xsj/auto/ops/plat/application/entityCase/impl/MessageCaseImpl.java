package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.request.MessageRequest;
import xsj.auto.ops.plat.api.response.MessageResponse;
import xsj.auto.ops.plat.application.entityCase.MessageCase;
import xsj.auto.ops.plat.domain.entity.Message;
import xsj.auto.ops.plat.domain.repository.MessageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageCaseImpl implements MessageCase {

    private final MessageRepository messageRepository;

    @Override
    public List<MessageResponse> list() {
        return messageRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MessageResponse getById(Long id) {
        return messageRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    @Override
    @Transactional
    public MessageResponse create(MessageRequest request) {
        Message entity = Message.create(
                null,
                request.getConversationId(),
                request.getRole(),
                request.getContent(),
                request.getTokenCount(),
                request.getImportanceScore(),
                request.getToolName(),
                request.getToolPayload()
        );
        messageRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public MessageResponse update(MessageRequest request) {
        Message entity = Message.create(
                request.getId(),
                request.getConversationId(),
                request.getRole(),
                request.getContent(),
                request.getTokenCount(),
                request.getImportanceScore(),
                request.getToolName(),
                request.getToolPayload()
        );
        messageRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        messageRepository.deleteById(id);
    }

    private MessageResponse toResponse(Message entity) {
        return new MessageResponse(
                entity.getId(),
                entity.getConversationId(),
                entity.getRole(),
                entity.getContent(),
                entity.getTokenCount(),
                entity.getImportanceScore(),
                entity.getToolName(),
                entity.getToolPayload()
        );
    }
}
