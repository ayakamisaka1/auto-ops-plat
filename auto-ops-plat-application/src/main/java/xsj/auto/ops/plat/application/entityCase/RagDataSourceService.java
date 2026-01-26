package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.RagDataSourceRequest;
import xsj.auto.ops.plat.api.response.RagDataSourceResponse;

import java.util.List;

/**
 * RAG数据源服务接口
 */
public interface RagDataSourceService {

    /**
     * 查询所有RAG数据源
     */
    List<RagDataSourceResponse> list();

    /**
     * 根据ID查询RAG数据源
     */
    RagDataSourceResponse getById(Long id);

    /**
     * 创建RAG数据源
     */
    RagDataSourceResponse create(RagDataSourceRequest request);

    /**
     * 更新RAG数据源
     */
    RagDataSourceResponse update(RagDataSourceRequest request);

    /**
     * 删除RAG数据源
     */
    void delete(Long id);
}
