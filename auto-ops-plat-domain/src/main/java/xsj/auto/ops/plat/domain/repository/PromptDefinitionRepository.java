package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.PromptDefinition;

import java.util.List;
import java.util.Optional;

public interface PromptDefinitionRepository {

    void save(PromptDefinition promptDefinition);

    Optional<PromptDefinition> findById(Long id);

    List<PromptDefinition> findAll();

    void deleteById(Long id);

    Optional<PromptDefinition> findByName(String name);

    List<PromptDefinition> findByPromptType(String promptType);

    List<PromptDefinition> findByEnabled(Boolean enabled);
}
