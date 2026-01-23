package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.Tool;
import xsj.auto.ops.plat.domain.repository.ToolRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.ToolPO;
import xsj.auto.ops.plat.infrastructure.mapper.ToolMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ToolRepositoryImpl implements ToolRepository {

    private final ToolJpaRepository toolJpaRepository;
    private final ToolMapper toolMapper;

    @Override
    public void save(Tool tool) {
        ToolPO po = toolMapper.toJpa(tool);
        ToolPO saved = toolJpaRepository.save(po);
        tool.assignId(saved.getId());
    }

    @Override
    public Optional<Tool> findById(Long id) {
        return toolJpaRepository.findById(id)
                .map(toolMapper::toDomain);
    }

    @Override
    public List<Tool> findAll() {
        return toolJpaRepository.findAll().stream()
                .map(toolMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        toolJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Tool> findByToolCode(String toolCode) {
        return toolJpaRepository.findByToolCode(toolCode)
                .map(toolMapper::toDomain);
    }

    @Override
    public List<Tool> findByMcpServiceId(Long mcpServiceId) {
        return toolJpaRepository.findByMcpServiceId(mcpServiceId).stream()
                .map(toolMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Tool> findByRiskLevel(Integer riskLevel) {
        return toolJpaRepository.findByRiskLevel(riskLevel).stream()
                .map(toolMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Tool> findByStatus(Integer status) {
        return toolJpaRepository.findByStatus(status).stream()
                .map(toolMapper::toDomain)
                .collect(Collectors.toList());
    }
}
