package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.MemoryPolicy;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.MemoryPolicyPO;

@Component
public class MemoryPolicyMapper {

    public MemoryPolicyPO toJpa(MemoryPolicy memoryPolicy) {
        MemoryPolicyPO po = new MemoryPolicyPO();
        if (memoryPolicy.getId() != null) {
            po.setId(memoryPolicy.getId());
        }
        po.setPolicyCode(memoryPolicy.getPolicyCode());
        po.setPolicyName(memoryPolicy.getPolicyName());
        po.setDescription(memoryPolicy.getDescription());
        po.setTriggerType(memoryPolicy.getTriggerType());
        po.setTriggerValue(memoryPolicy.getTriggerValue());
        po.setIncludeRole(memoryPolicy.getIncludeRole());
        po.setImportanceMin(memoryPolicy.getImportanceMin());
        po.setSummaryPrompt(memoryPolicy.getSummaryPrompt());
        po.setSummaryModel(memoryPolicy.getSummaryModel());
        po.setTtlDays(memoryPolicy.getTtlDays());
        po.setActive(memoryPolicy.getActive());
        return po;
    }

    public MemoryPolicy toDomain(MemoryPolicyPO po) {
        return MemoryPolicy.create(
                po.getId(),
                po.getPolicyCode(),
                po.getPolicyName(),
                po.getDescription(),
                po.getTriggerType(),
                po.getTriggerValue(),
                po.getIncludeRole(),
                po.getImportanceMin(),
                po.getSummaryPrompt(),
                po.getSummaryModel(),
                po.getTtlDays(),
                po.getActive()
        );
    }
}
