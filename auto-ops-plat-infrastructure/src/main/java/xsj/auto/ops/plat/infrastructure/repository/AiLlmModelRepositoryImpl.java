package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.LlmFactoryEntity.AiLlmModel;
import xsj.auto.ops.plat.domain.repository.AiLlmModelRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.llm.AiLlmModelPO;
import xsj.auto.ops.plat.infrastructure.mapper.AiLlmModelMapper;
import xsj.auto.ops.plat.infrastructure.repository.llm.AiLlmModelJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AiLlmModelRepositoryImpl implements AiLlmModelRepository {

    private final AiLlmModelJpaRepository aiLlmModelJpaRepository;
    private final AiLlmModelMapper aiLlmModelMapper;

    @Override
    public AiLlmModel save(AiLlmModel aiLlmModel) {
        AiLlmModelPO po = aiLlmModelMapper.toJpa(aiLlmModel);
        AiLlmModelPO saved = aiLlmModelJpaRepository.save(po);
        aiLlmModel.assignId(saved.getId());
        return aiLlmModel;
    }

    @Override
    public Optional<AiLlmModel> findById(Long id) {
        return aiLlmModelJpaRepository.findById(id)
                .map(aiLlmModelMapper::toDomain);
    }

    @Override
    public Optional<AiLlmModel> findByModelCodeAndProviderId(String modelCode, Long providerId) {
        return aiLlmModelJpaRepository.findByModelCodeAndAiLlmProviderPO_Id(modelCode, providerId)
                .map(aiLlmModelMapper::toDomain);
    }

    @Override
    public List<AiLlmModel> findByProviderId(Long providerId) {
        return aiLlmModelJpaRepository.findByAiLlmProviderPO_Id(providerId).stream()
                .map(aiLlmModelMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<AiLlmModel> findByModelType(String modelType) {
        return aiLlmModelJpaRepository.findByModelType(modelType).stream()
                .map(aiLlmModelMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<AiLlmModel> findByStatus(String status) {
        return aiLlmModelJpaRepository.findByStatus(status).stream()
                .map(aiLlmModelMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<AiLlmModel> findByProviderIdAndStatus(Long providerId, String status) {
        return aiLlmModelJpaRepository.findByAiLlmProviderPO_IdAndStatus(providerId, status).stream()
                .map(aiLlmModelMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        aiLlmModelJpaRepository.deleteById(id);
    }

    @Override
    public List<AiLlmModel> findAllAvailable() {
        return aiLlmModelJpaRepository.findByStatus("AVAILABLE").stream()
                .map(aiLlmModelMapper::toDomain)
                .collect(Collectors.toList());
    }
}