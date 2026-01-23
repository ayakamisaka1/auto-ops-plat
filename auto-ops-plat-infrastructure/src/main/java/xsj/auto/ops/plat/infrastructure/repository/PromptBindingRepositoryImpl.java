package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.PromptBinding;
import xsj.auto.ops.plat.domain.repository.PromptBindingRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.prompt.PromptBindingPO;
import xsj.auto.ops.plat.infrastructure.mapper.PromptBindingMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PromptBindingRepositoryImpl implements PromptBindingRepository {

    private final PromptBindingJpaRepository promptBindingJpaRepository;
    private final PromptBindingMapper promptBindingMapper;

    @Override
    public void save(PromptBinding binding) {
        PromptBindingPO po = promptBindingMapper.toJpa(binding);
        PromptBindingPO saved = promptBindingJpaRepository.save(po);
        binding.assignId(saved.getId());
    }

    @Override
    public Optional<PromptBinding> findById(Long id) {
        return promptBindingJpaRepository.findById(id)
                .map(promptBindingMapper::toDomain);
    }

    @Override
    public List<PromptBinding> findAll() {
        return promptBindingJpaRepository.findAll().stream()
                .map(promptBindingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        promptBindingJpaRepository.deleteById(id);
    }

    @Override
    public List<PromptBinding> findByBindType(String bindType) {
        return promptBindingJpaRepository.findByBindType(bindType).stream()
                .map(promptBindingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<PromptBinding> findByBindId(Long bindId) {
        return promptBindingJpaRepository.findByBindId(bindId).stream()
                .map(promptBindingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<PromptBinding> findByPromptId(Long promptId) {
        return promptBindingJpaRepository.findByPromptId(promptId).stream()
                .map(promptBindingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<PromptBinding> findByBindTypeAndBindId(String bindType, Long bindId) {
        return promptBindingJpaRepository.findByBindTypeAndBindId(bindType, bindId).stream()
                .map(promptBindingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<PromptBinding> findByEnabled(Boolean enabled) {
        return promptBindingJpaRepository.findByEnabled(enabled).stream()
                .map(promptBindingMapper::toDomain)
                .collect(Collectors.toList());
    }
}
