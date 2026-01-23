package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.Conversation;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.ConversationPO;

@Component
public class ConversationMapper {

    public ConversationPO toJpa(Conversation conversation) {
        ConversationPO po = new ConversationPO();
        if (conversation.getId() != null) {
            po.setId(conversation.getId());
        }
        po.setConversationId(conversation.getConversationId());
        po.setAgentId(conversation.getAgentId());
        po.setUserId(conversation.getUserId());
        po.setContextType(conversation.getContextType());
        po.setStatus(conversation.getStatus());
        po.setStartedAt(conversation.getStartedAt());
        po.setEndedAt(conversation.getEndedAt());
        return po;
    }

    public Conversation toDomain(ConversationPO po) {
        return Conversation.create(
                po.getId(),
                po.getConversationId(),
                po.getAgentId(),
                po.getUserId(),
                po.getContextType(),
                po.getStatus(),
                po.getStartedAt(),
                po.getEndedAt()
        );
    }
}
