package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.ToolModelBinding;
import xsj.auto.ops.plat.domain.repository.ToolModelBindingRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.ToolModelBindingPO;
import xsj.auto.ops.plat.infrastructure.mapper.ToolModelBindingMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ToolModelBindingRepositoryImpl implements ToolModelBindingRepository {

    private final ToolModelBindingJpaRepository toolModelBindingJpaRepository;
    private final ToolModelBindingMapper toolModelBindingMapper;

    @Override
    public void save(ToolModelBinding binding) {
        ToolModelBindingPO po = toolModelBindingMapper.toJpa(binding);
        ToolModelBindingPO saved = toolModelBindingJpaRepository.save(po);
        binding.assignId(saved.getId());
    }

    @Override
    public Optional<ToolModelBinding> findById(Long id) {
        return toolModelBindingJpaRepository.findById(id)
                .map(toolModelBindingMapper::toDomain);
    }

    @Override
    public List<ToolModelBinding> findAll() {
        return toolModelBindingJpaRepository.findAll().stream()
                .map(toolModelBindingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        toolModelBindingJpaRepository.deleteById(id);
    }

    @Override
    public List<ToolModelBinding> findByToolId(Long toolId) {
        return toolModelBindingJpaRepository.findByToolId(toolId).stream()
                .map(toolModelBindingMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ToolModelBinding> findByLlmModelId(Long llmModelId) {
        return toolModelBindingJpaRepository.findByLlmModelId(llmModelId).stream()
                .map(toolModelBindingMapper::toDomain)
                .collect(Collectors.toList());
    }
}
