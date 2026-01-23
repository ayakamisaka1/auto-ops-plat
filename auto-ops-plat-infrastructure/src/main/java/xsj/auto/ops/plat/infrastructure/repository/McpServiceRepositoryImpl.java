package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.McpService;
import xsj.auto.ops.plat.domain.repository.McpServiceRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.McpServicePO;
import xsj.auto.ops.plat.infrastructure.mapper.McpServiceMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class McpServiceRepositoryImpl implements McpServiceRepository {

    private final McpServiceJpaRepository mcpServiceJpaRepository;
    private final McpServiceMapper mcpServiceMapper;

    @Override
    public void save(McpService service) {
        McpServicePO po = mcpServiceMapper.toJpa(service);
        McpServicePO saved = mcpServiceJpaRepository.save(po);
        service.assignId(saved.getId());
    }

    @Override
    public Optional<McpService> findById(Long id) {
        return mcpServiceJpaRepository.findById(id)
                .map(mcpServiceMapper::toDomain);
    }

    @Override
    public List<McpService> findAll() {
        return mcpServiceJpaRepository.findAll().stream()
                .map(mcpServiceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        mcpServiceJpaRepository.deleteById(id);
    }

    @Override
    public Optional<McpService> findByServiceCode(String serviceCode) {
        return mcpServiceJpaRepository.findByServiceCode(serviceCode)
                .map(mcpServiceMapper::toDomain);
    }

    @Override
    public List<McpService> findByServiceType(String serviceType) {
        return mcpServiceJpaRepository.findByServiceType(serviceType).stream()
                .map(mcpServiceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<McpService> findByStatus(Integer status) {
        return mcpServiceJpaRepository.findByStatus(status).stream()
                .map(mcpServiceMapper::toDomain)
                .collect(Collectors.toList());
    }
}
