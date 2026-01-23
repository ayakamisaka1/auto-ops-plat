package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.Message;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.MessagePO;

@Component
public class MessageMapper {

    public MessagePO toJpa(Message message) {
        MessagePO po = new MessagePO();
        if (message.getId() != null) {
            po.setId(message.getId());
        }
        po.setConversationId(message.getConversationId());
        po.setRole(message.getRole());
        po.setContent(message.getContent());
        po.setTokenCount(message.getTokenCount());
        po.setImportanceScore(message.getImportanceScore());
        po.setToolName(message.getToolName());
        po.setToolPayload(message.getToolPayload());
        return po;
    }

    public Message toDomain(MessagePO po) {
        return Message.create(
                po.getId(),
                po.getConversationId(),
                po.getRole(),
                po.getContent(),
                po.getTokenCount(),
                po.getImportanceScore(),
                po.getToolName(),
                po.getToolPayload()
        );
    }
}
