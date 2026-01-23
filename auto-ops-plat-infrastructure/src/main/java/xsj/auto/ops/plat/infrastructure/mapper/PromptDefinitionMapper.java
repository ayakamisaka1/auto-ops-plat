package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.PromptDefinition;
import xsj.auto.ops.plat.infrastructure.jpaEntity.prompt.PromptDefinitionPO;

@Component
public class PromptDefinitionMapper {

    public PromptDefinitionPO toJpa(PromptDefinition promptDefinition) {
        PromptDefinitionPO po = new PromptDefinitionPO();
        if (promptDefinition.getId() != null) {
            po.setId(promptDefinition.getId());
        }
        po.setName(promptDefinition.getName());
        po.setPromptType(promptDefinition.getPromptType());
        po.setContent(promptDefinition.getContent());
        po.setDescription(promptDefinition.getDescription());
        po.setEnabled(promptDefinition.getEnabled());
        return po;
    }

    public PromptDefinition toDomain(PromptDefinitionPO po) {
        return PromptDefinition.create(
                po.getId(),
                po.getName(),
                po.getPromptType(),
                po.getContent(),
                po.getDescription(),
                po.getEnabled()
        );
    }
}
