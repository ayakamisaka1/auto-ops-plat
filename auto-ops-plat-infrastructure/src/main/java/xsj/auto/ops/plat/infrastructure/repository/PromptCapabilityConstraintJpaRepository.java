package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.prompt.PromptCapabilityConstraintPO;

import java.util.List;

public interface PromptCapabilityConstraintJpaRepository extends JpaRepository<PromptCapabilityConstraintPO, Long> {
    List<PromptCapabilityConstraintPO> findByPromptId(Long promptId);
    List<PromptCapabilityConstraintPO> findByCapabilityType(String capabilityType);
}
