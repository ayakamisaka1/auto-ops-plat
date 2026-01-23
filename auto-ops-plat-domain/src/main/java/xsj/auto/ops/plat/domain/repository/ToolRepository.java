package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.Tool;

import java.util.List;
import java.util.Optional;

public interface ToolRepository {

    void save(Tool tool);

    Optional<Tool> findById(Long id);

    List<Tool> findAll();

    void deleteById(Long id);

    Optional<Tool> findByToolCode(String toolCode);

    List<Tool> findByMcpServiceId(Long mcpServiceId);

    List<Tool> findByRiskLevel(Integer riskLevel);

    List<Tool> findByStatus(Integer status);
}
