package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.ConversationSummary;

import java.util.List;
import java.util.Optional;

public interface ConversationSummaryRepository {

    void save(ConversationSummary summary);

    Optional<ConversationSummary> findById(Long id);

    List<ConversationSummary> findAll();

    void deleteById(Long id);

    List<ConversationSummary> findByConversationId(String conversationId);

    List<ConversationSummary> findBySummaryType(String summaryType);
}
