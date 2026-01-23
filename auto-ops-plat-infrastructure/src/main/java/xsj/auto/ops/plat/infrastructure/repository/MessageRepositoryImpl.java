package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.Message;
import xsj.auto.ops.plat.domain.repository.MessageRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.MessagePO;
import xsj.auto.ops.plat.infrastructure.mapper.MessageMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MessageRepositoryImpl implements MessageRepository {

    private final MessageJpaRepository messageJpaRepository;
    private final MessageMapper messageMapper;

    @Override
    public void save(Message message) {
        MessagePO po = messageMapper.toJpa(message);
        MessagePO saved = messageJpaRepository.save(po);
        message.assignId(saved.getId());
    }

    @Override
    public Optional<Message> findById(Long id) {
        return messageJpaRepository.findById(id)
                .map(messageMapper::toDomain);
    }

    @Override
    public List<Message> findAll() {
        return messageJpaRepository.findAll().stream()
                .map(messageMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        messageJpaRepository.deleteById(id);
    }

    @Override
    public List<Message> findByConversationId(String conversationId) {
        return messageJpaRepository.findByConversationId(conversationId).stream()
                .map(messageMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Message> findByConversationIdAndRole(String conversationId, String role) {
        return messageJpaRepository.findByConversationIdAndRole(conversationId, role).stream()
                .map(messageMapper::toDomain)
                .collect(Collectors.toList());
    }
}
