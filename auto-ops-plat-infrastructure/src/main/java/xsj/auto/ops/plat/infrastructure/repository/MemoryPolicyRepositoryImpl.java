package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.MemoryPolicy;
import xsj.auto.ops.plat.domain.repository.MemoryPolicyRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.memory.MemoryPolicyPO;
import xsj.auto.ops.plat.infrastructure.mapper.MemoryPolicyMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MemoryPolicyRepositoryImpl implements MemoryPolicyRepository {

    private final MemoryPolicyJpaRepository memoryPolicyJpaRepository;
    private final MemoryPolicyMapper memoryPolicyMapper;

    @Override
    public void save(MemoryPolicy memoryPolicy) {
        MemoryPolicyPO po = memoryPolicyMapper.toJpa(memoryPolicy);
        MemoryPolicyPO saved = memoryPolicyJpaRepository.save(po);
        memoryPolicy.assignId(saved.getId());
    }

    @Override
    public Optional<MemoryPolicy> findById(Long id) {
        return memoryPolicyJpaRepository.findById(id)
                .map(memoryPolicyMapper::toDomain);
    }

    @Override
    public List<MemoryPolicy> findAll() {
        return memoryPolicyJpaRepository.findAll().stream()
                .map(memoryPolicyMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        memoryPolicyJpaRepository.deleteById(id);
    }

    @Override
    public Optional<MemoryPolicy> findByPolicyCode(String policyCode) {
        return memoryPolicyJpaRepository.findByPolicyCode(policyCode)
                .map(memoryPolicyMapper::toDomain);
    }
}
