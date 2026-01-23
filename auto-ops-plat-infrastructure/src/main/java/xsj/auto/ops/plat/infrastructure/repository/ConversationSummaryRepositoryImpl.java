package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.ConversationSummary;
import xsj.auto.ops.plat.domain.repository.ConversationSummaryRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.ConversationSummaryPO;
import xsj.auto.ops.plat.infrastructure.mapper.ConversationSummaryMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ConversationSummaryRepositoryImpl implements ConversationSummaryRepository {

    private final ConversationSummaryJpaRepository conversationSummaryJpaRepository;
    private final ConversationSummaryMapper conversationSummaryMapper;

    @Override
    public void save(ConversationSummary summary) {
        ConversationSummaryPO po = conversationSummaryMapper.toJpa(summary);
        ConversationSummaryPO saved = conversationSummaryJpaRepository.save(po);
        summary.assignId(saved.getId());
    }

    @Override
    public Optional<ConversationSummary> findById(Long id) {
        return conversationSummaryJpaRepository.findById(id)
                .map(conversationSummaryMapper::toDomain);
    }

    @Override
    public List<ConversationSummary> findAll() {
        return conversationSummaryJpaRepository.findAll().stream()
                .map(conversationSummaryMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        conversationSummaryJpaRepository.deleteById(id);
    }

    @Override
    public List<ConversationSummary> findByConversationId(String conversationId) {
        return conversationSummaryJpaRepository.findByConversationId(conversationId).stream()
                .map(conversationSummaryMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConversationSummary> findBySummaryType(String summaryType) {
        return conversationSummaryJpaRepository.findBySummaryType(summaryType).stream()
                .map(conversationSummaryMapper::toDomain)
                .collect(Collectors.toList());
    }
}
