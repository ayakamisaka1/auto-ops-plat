package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.ConversationSummary;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.ConversationSummaryPO;

@Component
public class ConversationSummaryMapper {

    public ConversationSummaryPO toJpa(ConversationSummary summary) {
        ConversationSummaryPO po = new ConversationSummaryPO();
        if (summary.getId() != null) {
            po.setId(summary.getId());
        }
        po.setConversationId(summary.getConversationId());
        po.setSummaryType(summary.getSummaryType());
        po.setSummaryContent(summary.getSummaryContent());
        po.setSummaryVersion(summary.getSummaryVersion());
        po.setTokenCount(summary.getTokenCount());
        return po;
    }

    public ConversationSummary toDomain(ConversationSummaryPO po) {
        return ConversationSummary.create(
                po.getId(),
                po.getConversationId(),
                po.getSummaryType(),
                po.getSummaryContent(),
                po.getSummaryVersion(),
                po.getTokenCount()
        );
    }
}
