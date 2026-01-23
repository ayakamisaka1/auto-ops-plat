package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.PromptCapabilityConstraint;

import java.util.List;
import java.util.Optional;

public interface PromptCapabilityConstraintRepository {

    void save(PromptCapabilityConstraint constraint);

    Optional<PromptCapabilityConstraint> findById(Long id);

    List<PromptCapabilityConstraint> findAll();

    void deleteById(Long id);

    List<PromptCapabilityConstraint> findByPromptId(Long promptId);

    List<PromptCapabilityConstraint> findByCapabilityType(String capabilityType);
}
