package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.McpConnectionConfig;
import xsj.auto.ops.plat.domain.repository.McpConnectionConfigRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.McpConnectionConfigPO;
import xsj.auto.ops.plat.infrastructure.mapper.McpConnectionConfigMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class McpConnectionConfigRepositoryImpl implements McpConnectionConfigRepository {

    private final McpConnectionConfigJpaRepository mcpConnectionConfigJpaRepository;
    private final McpConnectionConfigMapper mcpConnectionConfigMapper;

    @Override
    public void save(McpConnectionConfig config) {
        McpConnectionConfigPO po = mcpConnectionConfigMapper.toJpa(config);
        McpConnectionConfigPO saved = mcpConnectionConfigJpaRepository.save(po);
        config.assignId(saved.getId());
    }

    @Override
    public Optional<McpConnectionConfig> findById(Long id) {
        return mcpConnectionConfigJpaRepository.findById(id)
                .map(mcpConnectionConfigMapper::toDomain);
    }

    @Override
    public List<McpConnectionConfig> findAll() {
        return mcpConnectionConfigJpaRepository.findAll().stream()
                .map(mcpConnectionConfigMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        mcpConnectionConfigJpaRepository.deleteById(id);
    }

    @Override
    public List<McpConnectionConfig> findByProtocol(String protocol) {
        return mcpConnectionConfigJpaRepository.findByProtocol(protocol).stream()
                .map(mcpConnectionConfigMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<McpConnectionConfig> findByEnabled(Boolean enabled) {
        return mcpConnectionConfigJpaRepository.findByEnabled(enabled).stream()
                .map(mcpConnectionConfigMapper::toDomain)
                .collect(Collectors.toList());
    }
}
