package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.prompt.PromptDefinitionPO;

import java.util.List;
import java.util.Optional;

public interface PromptDefinitionJpaRepository extends JpaRepository<PromptDefinitionPO, Long> {
    Optional<PromptDefinitionPO> findByName(String name);
    List<PromptDefinitionPO> findByPromptType(String promptType);
    List<PromptDefinitionPO> findByEnabled(Boolean enabled);
}
