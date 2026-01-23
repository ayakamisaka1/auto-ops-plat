package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.MemoryPolicyPO;

import java.util.Optional;

public interface MemoryPolicyJpaRepository extends JpaRepository<MemoryPolicyPO, Long> {
    Optional<MemoryPolicyPO> findByPolicyCode(String policyCode);
}
