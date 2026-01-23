package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.ConversationPO;

import java.util.List;
import java.util.Optional;

public interface ConversationJpaRepository extends JpaRepository<ConversationPO, Long> {
    Optional<ConversationPO> findByConversationId(String conversationId);
    List<ConversationPO> findByAgentId(String agentId);
    List<ConversationPO> findByUserId(String userId);
    List<ConversationPO> findByStatus(String status);
}
