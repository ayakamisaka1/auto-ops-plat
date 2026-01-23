package xsj.auto.ops.plat.app.config;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public OpenAiApi defaultOpenAiApi() {
        return OpenAiApi.builder()
                .baseUrl("https://open.bigmodel.cn/api/paas/v4/")
                .apiKey("7fabb674620d43e8948e6096ad10bf7c.7NvkHWRWQetkMQQ1")
                .completionsPath("chat/completions")
                .embeddingsPath("embeddings")
                .build();
    }

    @Bean
    public ChatModel defaultChatModel(OpenAiApi defaultOpenAiApi) {
        return OpenAiChatModel.builder()
                .openAiApi(defaultOpenAiApi)
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("glm-4.7")
                        .build())
                .build();
    }
}
