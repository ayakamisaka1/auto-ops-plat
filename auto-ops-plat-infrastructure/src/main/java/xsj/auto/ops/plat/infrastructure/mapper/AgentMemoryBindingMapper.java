package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.AgentMemoryBinding;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.AgentMemoryBindingPO;

@Component
public class AgentMemoryBindingMapper {

    public AgentMemoryBindingPO toJpa(AgentMemoryBinding binding) {
        AgentMemoryBindingPO po = new AgentMemoryBindingPO();
        if (binding.getId() != null) {
            po.setId(binding.getId());
        }
        po.setAgentId(binding.getAgentId());
        po.setPriority(binding.getPriority());
        po.setActive(binding.getActive());
        return po;
    }

    public AgentMemoryBinding toDomain(AgentMemoryBindingPO po) {
        return AgentMemoryBinding.create(
                po.getId(),
                po.getAgentId(),
                po.getPriority(),
                po.getActive()
        );
    }
}
