package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.Message;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {

    void save(Message message);

    Optional<Message> findById(Long id);

    List<Message> findAll();

    void deleteById(Long id);

    List<Message> findByConversationId(String conversationId);

    List<Message> findByConversationIdAndRole(String conversationId, String role);
}
