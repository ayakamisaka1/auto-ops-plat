package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.PromptBinding;
import xsj.auto.ops.plat.infrastructure.jpaEntity.prompt.PromptBindingPO;

@Component
public class PromptBindingMapper {

    public PromptBindingPO toJpa(PromptBinding binding) {
        PromptBindingPO po = new PromptBindingPO();
        if (binding.getId() != null) {
            po.setId(binding.getId());
        }
        po.setBindType(binding.getBindType());
        po.setBindId(binding.getBindId());
        po.setPromptId(binding.getPromptId());
        po.setOrderIndex(binding.getOrderIndex());
        po.setEnabled(binding.getEnabled());
        return po;
    }

    public PromptBinding toDomain(PromptBindingPO po) {
        return PromptBinding.create(
                po.getId(),
                po.getBindType(),
                po.getBindId(),
                po.getPromptId(),
                po.getOrderIndex(),
                po.getEnabled()
        );
    }
}
