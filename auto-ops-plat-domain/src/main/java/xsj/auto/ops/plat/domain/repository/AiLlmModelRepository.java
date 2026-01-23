package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.LlmFactoryEntity.AiLlmModel;

import java.util.List;
import java.util.Optional;

public interface AiLlmModelRepository {
    /**
     * 保存LLM模型
     */
    AiLlmModel save(AiLlmModel aiLlmModel);

    /**
     * 根据ID查找LLM模型
     */
    Optional<AiLlmModel> findById(Long id);

    /**
     * 根据模型代码查找（在同一提供方下唯一）
     */
    Optional<AiLlmModel> findByModelCodeAndProviderId(String modelCode, Long providerId);

    /**
     * 根据提供方ID查找所有模型
     */
    List<AiLlmModel> findByProviderId(Long providerId);

    /**
     * 根据模型类型查找所有模型
     */
    List<AiLlmModel> findByModelType(String modelType);

    /**
     * 根据状态查找所有模型
     */
    List<AiLlmModel> findByStatus(String status);

    /**
     * 根据提供方ID和状态查找可用模型
     */
    List<AiLlmModel> findByProviderIdAndStatus(Long providerId, String status);

    /**
     * 根据ID删除模型
     */
    void deleteById(Long id);

    /**
     * 查找所有可用模型
     */
    List<AiLlmModel> findAllAvailable();
}