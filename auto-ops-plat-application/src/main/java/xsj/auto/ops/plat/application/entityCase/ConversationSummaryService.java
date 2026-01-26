package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.ConversationSummaryRequest;
import xsj.auto.ops.plat.api.response.ConversationSummaryResponse;

import java.util.List;

/**
 * 对话摘要服务接口
 */
public interface ConversationSummaryService {

    /**
     * 查询所有对话摘要
     */
    List<ConversationSummaryResponse> list();

    /**
     * 根据ID查询对话摘要
     */
    ConversationSummaryResponse getById(Long id);

    /**
     * 创建对话摘要
     */
    ConversationSummaryResponse create(ConversationSummaryRequest request);

    /**
     * 更新对话摘要
     */
    ConversationSummaryResponse update(ConversationSummaryRequest request);

    /**
     * 删除对话摘要
     */
    void delete(Long id);
}
