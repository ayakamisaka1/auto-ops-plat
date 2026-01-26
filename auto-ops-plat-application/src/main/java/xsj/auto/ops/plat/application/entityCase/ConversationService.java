package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.ConversationRequest;
import xsj.auto.ops.plat.api.response.ConversationResponse;

import java.util.List;

/**
 * 对话服务接口
 */
public interface ConversationService {

    /**
     * 查询所有对话
     */
    List<ConversationResponse> list();

    /**
     * 根据ID查询对话
     */
    ConversationResponse getById(Long id);

    /**
     * 创建对话
     */
    ConversationResponse create(ConversationRequest request);

    /**
     * 更新对话
     */
    ConversationResponse update(ConversationRequest request);

    /**
     * 删除对话
     */
    void delete(Long id);
}
