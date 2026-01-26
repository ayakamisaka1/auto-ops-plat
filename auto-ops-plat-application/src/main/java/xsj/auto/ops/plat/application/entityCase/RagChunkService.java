package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.RagChunkRequest;
import xsj.auto.ops.plat.api.response.RagChunkResponse;

import java.util.List;

/**
 * RAG块服务接口
 */
public interface RagChunkService {

    /**
     * 查询所有RAG块
     */
    List<RagChunkResponse> list();

    /**
     * 根据ID查询RAG块
     */
    RagChunkResponse getById(Long id);

    /**
     * 创建RAG块
     */
    RagChunkResponse create(RagChunkRequest request);

    /**
     * 更新RAG块
     */
    RagChunkResponse update(RagChunkRequest request);

    /**
     * 删除RAG块
     */
    void delete(Long id);
}
