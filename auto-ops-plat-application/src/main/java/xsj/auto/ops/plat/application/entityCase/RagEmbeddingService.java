package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.RagEmbeddingRequest;
import xsj.auto.ops.plat.api.response.RagEmbeddingResponse;

import java.util.List;

/**
 * RAG嵌入服务接口
 */
public interface RagEmbeddingService {

    /**
     * 查询所有RAG嵌入
     */
    List<RagEmbeddingResponse> list();

    /**
     * 根据ID查询RAG嵌入
     */
    RagEmbeddingResponse getById(Long id);

    /**
     * 创建RAG嵌入
     */
    RagEmbeddingResponse create(RagEmbeddingRequest request);

    /**
     * 更新RAG嵌入
     */
    RagEmbeddingResponse update(RagEmbeddingRequest request);

    /**
     * 删除RAG嵌入
     */
    void delete(Long id);
}
