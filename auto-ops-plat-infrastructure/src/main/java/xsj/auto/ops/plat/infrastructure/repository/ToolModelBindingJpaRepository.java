package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.ToolModelBindingPO;

import java.util.List;

public interface ToolModelBindingJpaRepository extends JpaRepository<ToolModelBindingPO, Long> {
    List<ToolModelBindingPO> findByToolPO_Id(Long toolId);
    List<ToolModelBindingPO> findByLlmModel_Id(Long llmModelId);
}
