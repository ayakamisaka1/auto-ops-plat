package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.RagDocumentRequest;
import xsj.auto.ops.plat.api.response.RagDocumentResponse;

import java.util.List;

/**
 * RAG文档服务接口
 */
public interface RagDocumentService {

    /**
     * 查询所有RAG文档
     */
    List<RagDocumentResponse> list();

    /**
     * 根据ID查询RAG文档
     */
    RagDocumentResponse getById(Long id);

    /**
     * 创建RAG文档
     */
    RagDocumentResponse create(RagDocumentRequest request);

    /**
     * 更新RAG文档
     */
    RagDocumentResponse update(RagDocumentRequest request);

    /**
     * 删除RAG文档
     */
    void delete(Long id);
}
