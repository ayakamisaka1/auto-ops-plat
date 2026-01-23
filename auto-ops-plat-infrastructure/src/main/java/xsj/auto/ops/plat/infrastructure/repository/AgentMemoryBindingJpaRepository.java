package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.AgentMemoryBindingPO;

import java.util.List;

public interface AgentMemoryBindingJpaRepository extends JpaRepository<AgentMemoryBindingPO, Long> {
    List<AgentMemoryBindingPO> findByAgentId(String agentId);
    List<AgentMemoryBindingPO> findByMemoryPolicy_Id(Long memoryPolicyId);
    List<AgentMemoryBindingPO> findByActive(Boolean active);
}
