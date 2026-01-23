package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.ToolPO;

import java.util.List;
import java.util.Optional;

public interface ToolJpaRepository extends JpaRepository<ToolPO, Long> {
    Optional<ToolPO> findByToolCode(String toolCode);
    List<ToolPO> findByMcpServiceId(Long mcpServiceId);
    List<ToolPO> findByRiskLevel(Integer riskLevel);
    List<ToolPO> findByStatus(Integer status);
}
