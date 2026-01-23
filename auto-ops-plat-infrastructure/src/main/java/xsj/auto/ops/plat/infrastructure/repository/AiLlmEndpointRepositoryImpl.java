package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.LlmFactoryEntity.AiLlmEndpoint;
import xsj.auto.ops.plat.domain.repository.AiLlmEndpointRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.llm.AiLlmEndpointPO;
import xsj.auto.ops.plat.infrastructure.mapper.AiLlmEndpointMapper;
import xsj.auto.ops.plat.infrastructure.repository.llm.AiLlmEndpointJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AiLlmEndpointRepositoryImpl implements AiLlmEndpointRepository {

    private final AiLlmEndpointJpaRepository aiLlmEndpointJpaRepository;
    private final AiLlmEndpointMapper aiLlmEndpointMapper;

    @Override
    public AiLlmEndpoint save(AiLlmEndpoint aiLlmEndpoint) {
        AiLlmEndpointPO po = aiLlmEndpointMapper.toJpa(aiLlmEndpoint);
        AiLlmEndpointPO saved = aiLlmEndpointJpaRepository.save(po);
        aiLlmEndpoint.assignId(saved.getId());
        return aiLlmEndpoint;
    }

    @Override
    public AiLlmEndpoint findById(Long id) {
        return aiLlmEndpointJpaRepository.findById(id)
                .map(aiLlmEndpointMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<AiLlmEndpoint> findByModelId(Long modelId) {
        return aiLlmEndpointJpaRepository.findByAiLlmModelPO_Id(modelId).stream()
                .map(aiLlmEndpointMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<AiLlmEndpoint> findByCapabilityType(String capabilityType) {
        return aiLlmEndpointJpaRepository.findByCapabilityType(capabilityType).stream()
                .map(aiLlmEndpointMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<AiLlmEndpoint> findByStatus(String status) {
        return aiLlmEndpointJpaRepository.findByStatus(status).stream()
                .map(aiLlmEndpointMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        aiLlmEndpointJpaRepository.deleteById(id);
    }

    @Override
    public List<AiLlmEndpoint> findAllAvailable() {
        return aiLlmEndpointJpaRepository.findByStatus("ACTIVE").stream()
                .map(aiLlmEndpointMapper::toDomain)
                .collect(Collectors.toList());
    }
}