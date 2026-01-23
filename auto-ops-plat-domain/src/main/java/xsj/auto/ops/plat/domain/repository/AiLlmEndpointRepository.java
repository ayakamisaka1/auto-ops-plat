package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.LlmFactoryEntity.AiLlmEndpoint;

import java.util.List;

public interface AiLlmEndpointRepository {
    /**
     * 保存LLM端点
     */
    AiLlmEndpoint save(AiLlmEndpoint aiLlmEndpoint);

    /**
     * 根据ID查找LLM端点
     */
    AiLlmEndpoint findById(Long id);

    /**
     * 根据模型ID查找所有端点
     */
    List<AiLlmEndpoint> findByModelId(Long modelId);

    /**
     * 根据能力类型查找所有端点
     */
    List<AiLlmEndpoint> findByCapabilityType(String capabilityType);

    /**
     * 根据状态查找所有端点
     */
    List<AiLlmEndpoint> findByStatus(String status);

    /**
     * 根据ID删除端点
     */
    void deleteById(Long id);

    /**
     * 查找所有可用端点
     */
    List<AiLlmEndpoint> findAllAvailable();
}