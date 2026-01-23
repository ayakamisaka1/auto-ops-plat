package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.ConversationSummaryPO;

import java.util.List;

public interface ConversationSummaryJpaRepository extends JpaRepository<ConversationSummaryPO, Long> {
    List<ConversationSummaryPO> findByConversationId(String conversationId);
    List<ConversationSummaryPO> findBySummaryType(String summaryType);
}
