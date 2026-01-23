package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.MessagePO;

import java.util.List;

public interface MessageJpaRepository extends JpaRepository<MessagePO, Long> {
    List<MessagePO> findByConversationId(String conversationId);
    List<MessagePO> findByConversationIdAndRole(String conversationId, String role);
}
