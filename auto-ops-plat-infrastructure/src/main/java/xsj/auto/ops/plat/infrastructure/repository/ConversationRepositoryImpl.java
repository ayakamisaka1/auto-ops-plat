package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.Conversation;
import xsj.auto.ops.plat.domain.repository.ConversationRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.ConversationPO;
import xsj.auto.ops.plat.infrastructure.mapper.ConversationMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ConversationRepositoryImpl implements ConversationRepository {

    private final ConversationJpaRepository conversationJpaRepository;
    private final ConversationMapper conversationMapper;

    @Override
    public void save(Conversation conversation) {
        ConversationPO po = conversationMapper.toJpa(conversation);
        ConversationPO saved = conversationJpaRepository.save(po);
        conversation.assignId(saved.getId());
    }

    @Override
    public Optional<Conversation> findById(Long id) {
        return conversationJpaRepository.findById(id)
                .map(conversationMapper::toDomain);
    }

    @Override
    public List<Conversation> findAll() {
        return conversationJpaRepository.findAll().stream()
                .map(conversationMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        conversationJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Conversation> findByConversationId(String conversationId) {
        return conversationJpaRepository.findByConversationId(conversationId)
                .map(conversationMapper::toDomain);
    }

    @Override
    public List<Conversation> findByAgentId(String agentId) {
        return conversationJpaRepository.findByAgentId(agentId).stream()
                .map(conversationMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Conversation> findByUserId(String userId) {
        return conversationJpaRepository.findByUserId(userId).stream()
                .map(conversationMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Conversation> findByStatus(String status) {
        return conversationJpaRepository.findByStatus(status).stream()
                .map(conversationMapper::toDomain)
                .collect(Collectors.toList());
    }
}
