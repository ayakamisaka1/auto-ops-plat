package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.MessageRequest;
import xsj.auto.ops.plat.api.response.MessageResponse;

import java.util.List;

/**
 * 消息服务接口
 */
public interface MessageService {

    /**
     * 查询所有消息
     */
    List<MessageResponse> list();

    /**
     * 根据ID查询消息
     */
    MessageResponse getById(Long id);

    /**
     * 创建消息
     */
    MessageResponse create(MessageRequest request);

    /**
     * 更新消息
     */
    MessageResponse update(MessageRequest request);

    /**
     * 删除消息
     */
    void delete(Long id);
}
