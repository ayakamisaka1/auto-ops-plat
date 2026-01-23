package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.PromptCapabilityConstraint;
import xsj.auto.ops.plat.infrastructure.jpaEntity.prompt.PromptCapabilityConstraintPO;

@Component
public class PromptCapabilityConstraintMapper {

    public PromptCapabilityConstraintPO toJpa(PromptCapabilityConstraint constraint) {
        PromptCapabilityConstraintPO po = new PromptCapabilityConstraintPO();
        if (constraint.getId() != null) {
            po.setId(constraint.getId());
        }
        po.setPromptId(constraint.getPromptId());
        po.setCapabilityType(constraint.getCapabilityType());
        po.setConstraintRule(constraint.getConstraintRule());
        return po;
    }

    public PromptCapabilityConstraint toDomain(PromptCapabilityConstraintPO po) {
        return PromptCapabilityConstraint.create(
                po.getId(),
                po.getPromptId(),
                po.getCapabilityType(),
                po.getConstraintRule()
        );
    }
}
