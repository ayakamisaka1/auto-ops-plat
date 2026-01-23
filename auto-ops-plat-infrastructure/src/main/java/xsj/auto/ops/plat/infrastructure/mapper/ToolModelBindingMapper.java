package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.ToolModelBinding;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.ToolModelBindingPO;

@Component
public class ToolModelBindingMapper {

    public ToolModelBindingPO toJpa(ToolModelBinding binding) {
        ToolModelBindingPO po = new ToolModelBindingPO();
        if (binding.getId() != null) {
            po.setId(binding.getId());
        }
        po.setEnable(binding.getEnable());
        po.setMaxCalls(binding.getMaxCalls());
        po.setRateLimit(binding.getRateLimit());
        return po;
    }

    public ToolModelBinding toDomain(ToolModelBindingPO po) {
        return ToolModelBinding.create(
                po.getId(),
                po.getToolPO() != null ? po.getToolPO().getId() : null,
                po.getLlmModel() != null ? po.getLlmModel().getId() : null,
                po.getEnable(),
                po.getMaxCalls(),
                po.getRateLimit()
        );
    }
}
