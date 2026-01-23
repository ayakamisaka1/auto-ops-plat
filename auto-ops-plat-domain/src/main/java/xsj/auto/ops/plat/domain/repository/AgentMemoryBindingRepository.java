package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.AgentMemoryBinding;

import java.util.List;
import java.util.Optional;

public interface AgentMemoryBindingRepository {

    void save(AgentMemoryBinding binding);

    Optional<AgentMemoryBinding> findById(Long id);

    List<AgentMemoryBinding> findAll();

    void deleteById(Long id);

    List<AgentMemoryBinding> findByAgentId(String agentId);

    List<AgentMemoryBinding> findByActive(Boolean active);
}
