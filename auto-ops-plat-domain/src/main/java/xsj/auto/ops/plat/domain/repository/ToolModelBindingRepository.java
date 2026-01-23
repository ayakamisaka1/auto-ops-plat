package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.ToolModelBinding;

import java.util.List;
import java.util.Optional;

public interface ToolModelBindingRepository {

    void save(ToolModelBinding binding);

    Optional<ToolModelBinding> findById(Long id);

    List<ToolModelBinding> findAll();

    void deleteById(Long id);

    List<ToolModelBinding> findByToolId(Long toolId);

    List<ToolModelBinding> findByLlmModelId(Long llmModelId);
}
