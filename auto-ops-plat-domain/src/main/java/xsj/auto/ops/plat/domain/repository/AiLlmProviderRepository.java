package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.AiLlmProvider;

import java.util.List;
import java.util.Optional;

public interface AiLlmProviderRepository {

    void save(AiLlmProvider provider);

    Optional<AiLlmProvider> findById(Long id);

    List<AiLlmProvider> findAll();

    boolean delete(Long id);

    boolean update(AiLlmProvider provider);

    boolean deleteAll();

    boolean existsByProviderCode(String providerCode);
}
