package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.AgentMemoryBinding;
import xsj.auto.ops.plat.domain.repository.AgentMemoryBindingRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.AgentMemoryBindingPO;
import xsj.auto.ops.plat.infrastructure.mapper.AgentMemoryBindingMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AgentMemoryBindingRepositoryImpl implements AgentMemoryBindingRepository {

    private final AgentMemoryBindingJpaRepository agentMemoryBindingJpaRepository;
    private final AgentMemoryBindingMapper agentMemoryBindingMapper;

    @Override
    public void save(AgentMemoryBinding binding) {
        AgentMemoryBindingPO po = agentMemoryBindingMapper.toJpa(binding);
        AgentMemoryBindingPO saved = agentMemoryBindingJpaRepository.save(po);
        binding.assignId(saved.getId());
    }

    @Override
    public Optional<AgentMemoryBinding> findById(Long id) {
        return agentMemoryBindingJpaRepository.findById(id)
                .map(agentMemoryBindingMapper::toDomain);
    }

    @Override
    public List<AgentMemoryBinding> findAll() {
        return agentMemoryBindingJpaRepository.findAll().stream()
                .map(agentMemoryBindingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        agentMemoryBindingJpaRepository.deleteById(id);
    }

    @Override
    public List<AgentMemoryBinding> findByAgentId(String agentId) {
        return agentMemoryBindingJpaRepository.findByAgentId(agentId).stream()
                .map(agentMemoryBindingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<AgentMemoryBinding> findByActive(Boolean active) {
        return agentMemoryBindingJpaRepository.findByActive(active).stream()
                .map(agentMemoryBindingMapper::toDomain)
                .collect(Collectors.toList());
    }
}
