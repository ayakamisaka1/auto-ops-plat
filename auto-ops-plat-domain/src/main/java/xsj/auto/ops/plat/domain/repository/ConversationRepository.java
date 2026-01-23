package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.Conversation;

import java.util.List;
import java.util.Optional;

public interface ConversationRepository {

    void save(Conversation conversation);

    Optional<Conversation> findById(Long id);

    List<Conversation> findAll();

    void deleteById(Long id);

    Optional<Conversation> findByConversationId(String conversationId);

    List<Conversation> findByAgentId(String agentId);

    List<Conversation> findByUserId(String userId);

    List<Conversation> findByStatus(String status);
}
