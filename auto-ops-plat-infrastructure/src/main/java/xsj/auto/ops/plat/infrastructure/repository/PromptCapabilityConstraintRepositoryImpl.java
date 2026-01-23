package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.PromptCapabilityConstraint;
import xsj.auto.ops.plat.domain.repository.PromptCapabilityConstraintRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.prompt.PromptCapabilityConstraintPO;
import xsj.auto.ops.plat.infrastructure.mapper.PromptCapabilityConstraintMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PromptCapabilityConstraintRepositoryImpl implements PromptCapabilityConstraintRepository {

    private final PromptCapabilityConstraintJpaRepository promptCapabilityConstraintJpaRepository;
    private final PromptCapabilityConstraintMapper promptCapabilityConstraintMapper;

    @Override
    public void save(PromptCapabilityConstraint constraint) {
        PromptCapabilityConstraintPO po = promptCapabilityConstraintMapper.toJpa(constraint);
        PromptCapabilityConstraintPO saved = promptCapabilityConstraintJpaRepository.save(po);
        constraint.assignId(saved.getId());
    }

    @Override
    public Optional<PromptCapabilityConstraint> findById(Long id) {
        return promptCapabilityConstraintJpaRepository.findById(id)
                .map(promptCapabilityConstraintMapper::toDomain);
    }

    @Override
    public List<PromptCapabilityConstraint> findAll() {
        return promptCapabilityConstraintJpaRepository.findAll().stream()
                .map(promptCapabilityConstraintMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        promptCapabilityConstraintJpaRepository.deleteById(id);
    }

    @Override
    public List<PromptCapabilityConstraint> findByPromptId(Long promptId) {
        return promptCapabilityConstraintJpaRepository.findByPromptId(promptId).stream()
                .map(promptCapabilityConstraintMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<PromptCapabilityConstraint> findByCapabilityType(String capabilityType) {
        return promptCapabilityConstraintJpaRepository.findByCapabilityType(capabilityType).stream()
                .map(promptCapabilityConstraintMapper::toDomain)
                .collect(Collectors.toList());
    }
}
