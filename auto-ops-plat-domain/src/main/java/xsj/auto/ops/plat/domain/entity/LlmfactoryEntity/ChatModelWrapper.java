package xsj.auto.ops.plat.domain.entity.LlmfactoryEntity;

import lombok.Getter;
import org.springframework.ai.chat.model.ChatModel;

@Getter
public class ChatModelWrapper {
    private final ChatModel chatModel;

    public ChatModelWrapper(ChatModel chatModel) {
        this.chatModel = chatModel;
    }
}
