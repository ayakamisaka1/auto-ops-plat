package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.PromptDefinition;
import xsj.auto.ops.plat.domain.repository.PromptDefinitionRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.prompt.PromptDefinitionPO;
import xsj.auto.ops.plat.infrastructure.mapper.PromptDefinitionMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PromptDefinitionRepositoryImpl implements PromptDefinitionRepository {

    private final PromptDefinitionJpaRepository promptDefinitionJpaRepository;
    private final PromptDefinitionMapper promptDefinitionMapper;

    @Override
    public void save(PromptDefinition promptDefinition) {
        PromptDefinitionPO po = promptDefinitionMapper.toJpa(promptDefinition);
        PromptDefinitionPO saved = promptDefinitionJpaRepository.save(po);
        promptDefinition.assignId(saved.getId());
    }

    @Override
    public Optional<PromptDefinition> findById(Long id) {
        return promptDefinitionJpaRepository.findById(id)
                .map(promptDefinitionMapper::toDomain);
    }

    @Override
    public List<PromptDefinition> findAll() {
        return promptDefinitionJpaRepository.findAll().stream()
                .map(promptDefinitionMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        promptDefinitionJpaRepository.deleteById(id);
    }

    @Override
    public Optional<PromptDefinition> findByName(String name) {
        return promptDefinitionJpaRepository.findByName(name)
                .map(promptDefinitionMapper::toDomain);
    }

    @Override
    public List<PromptDefinition> findByPromptType(String promptType) {
        return promptDefinitionJpaRepository.findByPromptType(promptType).stream()
                .map(promptDefinitionMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<PromptDefinition> findByEnabled(Boolean enabled) {
        return promptDefinitionJpaRepository.findByEnabled(enabled).stream()
                .map(promptDefinitionMapper::toDomain)
                .collect(Collectors.toList());
    }
}
