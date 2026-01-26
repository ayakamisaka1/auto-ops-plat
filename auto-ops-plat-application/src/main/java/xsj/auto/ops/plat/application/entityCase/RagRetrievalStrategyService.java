package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.RagRetrievalStrategyRequest;
import xsj.auto.ops.plat.api.response.RagRetrievalStrategyResponse;

import java.util.List;

/**
 * RAG检索策略服务接口
 */
public interface RagRetrievalStrategyService {

    /**
     * 查询所有RAG检索策略
     */
    List<RagRetrievalStrategyResponse> list();

    /**
     * 根据ID查询RAG检索策略
     */
    RagRetrievalStrategyResponse getById(Long id);

    /**
     * 创建RAG检索策略
     */
    RagRetrievalStrategyResponse create(RagRetrievalStrategyRequest request);

    /**
     * 更新RAG检索策略
     */
    RagRetrievalStrategyResponse update(RagRetrievalStrategyRequest request);

    /**
     * 删除RAG检索策略
     */
    void delete(Long id);
}
