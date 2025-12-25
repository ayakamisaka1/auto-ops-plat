package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.domain.entity.AiLlmProvider;
import xsj.auto.ops.plat.domain.repository.AiLlmProviderRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.AiLlmProviderPO;
import xsj.auto.ops.plat.infrastructure.mapper.AiLlmProviderMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AiLlmProviderRepositoryImpl implements AiLlmProviderRepository {

    private final AiLlmProviderJpaRepository aiLlmProviderJpaRepository;
    private final AiLlmProviderMapper aiLlmProviderMapper;
    @Override
    public void save(AiLlmProvider provider) {
        aiLlmProviderJpaRepository.save(aiLlmProviderMapper.toJpa(provider));
    }

    @Override
    public Optional<AiLlmProvider> findById(Long id) {
        Optional<AiLlmProviderPO> byId = aiLlmProviderJpaRepository.findById(id);
        return byId.map(aiLlmProviderMapper::toDomain);
    }

    @Override
    public List<AiLlmProvider> findAll() {
        return aiLlmProviderJpaRepository.findAll().
                stream().map(aiLlmProviderMapper::toDomain).toList();
    }

    @Override
    public boolean delete(Long id) {
        aiLlmProviderJpaRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean update(AiLlmProvider provider) {
        AiLlmProviderPO save = aiLlmProviderJpaRepository.save(aiLlmProviderMapper.toJpa(provider));
        return true;
    }

    @Override
    public boolean deleteAll() {
        aiLlmProviderJpaRepository.deleteAll();
        return true;
    }

    @Override
    public boolean existsByProviderCode(String providerCode) {
        return aiLlmProviderJpaRepository.existsByProviderCode(providerCode);
    }
}
