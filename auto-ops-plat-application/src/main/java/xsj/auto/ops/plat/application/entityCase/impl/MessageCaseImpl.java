package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.MessageServiceApi;
import xsj.auto.ops.plat.api.request.MessageRequest;
import xsj.auto.ops.plat.api.response.MessageResponse;
import xsj.auto.ops.plat.application.entityCase.MessageCase;
import xsj.auto.ops.plat.domain.entity.Message;
import xsj.auto.ops.plat.domain.repository.MessageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageCaseImpl implements MessageServiceApi {

    private final MessageRepository messageRepository;

    @Override
    public ResultBody<List<MessageResponse>> list() {
        return ResultBody.ok(messageRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<MessageResponse> getById(Long id) {
        return messageRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<MessageResponse> create(MessageRequest request) {
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
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<MessageResponse> update(MessageRequest request) {
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
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        messageRepository.deleteById(id);
        return ResultBody.ok();
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
