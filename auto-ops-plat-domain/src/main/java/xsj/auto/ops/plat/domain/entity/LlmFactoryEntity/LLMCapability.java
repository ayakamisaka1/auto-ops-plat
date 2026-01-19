package xsj.auto.ops.plat.domain.entity.LlmFactoryEntity;

import lombok.Getter;

import java.util.List;

@Getter
public class LLMCapability {
    private final String providerCode;
    private final String providerName;
    private final String providerType;
    private final String baseUrl;
    private final String key;
    private final String authType;

    private final String modelCode;
    private final String modelName;
    private final String modelType;
    private final Integer contextLength;
    private final Integer maxOutputTokens;
    private final List<Endpoint> endpoints;

    public LLMCapability(String providerCode,
                         String providerName,
                         String providerType,
                         String baseUrl,
                         String key,
                         String authType,
                         String modelCode,
                         String modelName,
                         String modelType,
                         Integer contextLength,
                         Integer maxOutputTokens,
                         List<Endpoint> endpoints) {
        this.providerCode = providerCode;
        this.providerName = providerName;
        this.providerType = providerType;
        this.baseUrl = baseUrl;
        this.key = key;
        this.authType = authType;
        this.modelCode = modelCode;
        this.modelName = modelName;
        this.modelType = modelType;
        this.contextLength = contextLength;
        this.maxOutputTokens = maxOutputTokens;
        this.endpoints = endpoints;
    }
    @Getter
    public static class Endpoint {
        private final String capabilityType;
        private final String httpMethod;
        private final String path;

        public Endpoint(String capabilityType, String httpMethod, String path) {
            this.capabilityType = capabilityType;
            this.httpMethod = httpMethod;
            this.path = path;
        }
    }
}
