package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.prompt.PromptBindingPO;

import java.util.List;

public interface PromptBindingJpaRepository extends JpaRepository<PromptBindingPO, Long> {
    List<PromptBindingPO> findByBindType(String bindType);
    List<PromptBindingPO> findByBindId(Long bindId);
    List<PromptBindingPO> findByPromptId(Long promptId);
    List<PromptBindingPO> findByBindTypeAndBindId(String bindType, Long bindId);
    List<PromptBindingPO> findByEnabled(Boolean enabled);
}
