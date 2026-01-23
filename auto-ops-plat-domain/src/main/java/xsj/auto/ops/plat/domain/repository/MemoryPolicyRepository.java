package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.MemoryPolicy;

import java.util.List;
import java.util.Optional;

public interface MemoryPolicyRepository {

    void save(MemoryPolicy memoryPolicy);

    Optional<MemoryPolicy> findById(Long id);

    List<MemoryPolicy> findAll();

    void deleteById(Long id);

    Optional<MemoryPolicy> findByPolicyCode(String policyCode);
}
