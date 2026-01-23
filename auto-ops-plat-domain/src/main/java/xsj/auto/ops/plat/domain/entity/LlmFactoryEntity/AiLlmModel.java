package xsj.auto.ops.plat.domain.entity.LlmFactoryEntity;

import lombok.Getter;
import xsj.auto.ops.plat.domain.entity.LlmFactoryEntity.AiLlmProvider;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class AiLlmModel {
    /** 领域唯一标识 */
    private Long id;

    /** 所属LLM提供方ID */
    private Long providerId;

    /** 模型代码（在同一提供方下唯一） */
    private String modelCode;

    /** 模型名称 */
    private String modelName;

    /** 模型版本 */
    private String modelVersion;

    /** 模型类型 */
    private String modelType;

    /** 最大上下文长度（token） */
    private Integer contextLength;

    /** 最大输出token数 */
    private Integer maxOutputTokens;

    /** 是否支持流式输出 */
    private Boolean supportsStream;

    /** 是否支持工具/函数调用 */
    private Boolean supportsFunctionCall;

    /** 是否支持视觉输入 */
    private Boolean supportsVision;

    /** 模型状态 */
    private String status;

    /** 模型描述说明 */
    private String description;

    /** 审计字段 */
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    // =========================
    // 构造（工厂控制创建）
    // =========================
    private AiLlmModel(Long providerId, String modelCode, String modelName, String modelType) {
        this.providerId = providerId;
        this.modelCode = modelCode;
        this.modelName = modelName;
        this.modelType = modelType;
        this.status = "AVAILABLE";
        this.createdAt = LocalDateTime.now();
    }

    private AiLlmModel() {
    }

    // =========================
    // 领域工厂方法
    // =========================
    public static AiLlmModel create(Long providerId, String modelCode, String modelName, String modelType) {
        Objects.requireNonNull(providerId);
        Objects.requireNonNull(modelCode);
        Objects.requireNonNull(modelName);
        Objects.requireNonNull(modelType);

        return new AiLlmModel(providerId, modelCode, modelName, modelType);
    }

    /**
     * 从持久化状态恢复 Model（重建聚合）
     */
    public static AiLlmModel restore(Long id, Long providerId, String modelCode, String modelName,
                                     String modelVersion, String modelType, Integer contextLength,
                                     Integer maxOutputTokens, Boolean supportsStream,
                                     Boolean supportsFunctionCall, Boolean supportsVision,
                                     String status, String description) {
        AiLlmModel model = new AiLlmModel();
        model.id = id;
        model.providerId = providerId;
        model.modelCode = modelCode;
        model.modelName = modelName;
        model.modelVersion = modelVersion;
        model.modelType = modelType;
        model.contextLength = contextLength;
        model.maxOutputTokens = maxOutputTokens;
        model.supportsStream = supportsStream;
        model.supportsFunctionCall = supportsFunctionCall;
        model.supportsVision = supportsVision;
        model.status = status;
        model.description = description;
        return model;
    }

    // =========================
    // 领域行为
    // =========================

    /** 启用模型 */
    public void enable() {
        this.status = "AVAILABLE";
    }

    /** 废弃模型 */
    public void deprecate() {
        this.status = "DEPRECATED";
    }

    /** 禁用模型 */
    public void disable() {
        this.status = "DISABLED";
    }

    /** 更新模型版本 */
    public void updateVersion(String modelVersion) {
        this.modelVersion = modelVersion;
        this.updatedAt = LocalDateTime.now();
    }

    /** 更新模型名称 */
    public void updateName(String modelName) {
        this.modelName = modelName;
        this.updatedAt = LocalDateTime.now();
    }

    /** 更新上下文长度 */
    public void updateContextLength(Integer contextLength) {
        this.contextLength = contextLength;
        this.updatedAt = LocalDateTime.now();
    }

    /** 更新最大输出token数 */
    public void updateMaxOutputTokens(Integer maxOutputTokens) {
        this.maxOutputTokens = maxOutputTokens;
        this.updatedAt = LocalDateTime.now();
    }

    /** 设置支持流式输出 */
    public void setSupportsStream(Boolean supportsStream) {
        this.supportsStream = supportsStream;
        this.updatedAt = LocalDateTime.now();
    }

    /** 设置支持工具调用 */
    public void setSupportsFunctionCall(Boolean supportsFunctionCall) {
        this.supportsFunctionCall = supportsFunctionCall;
        this.updatedAt = LocalDateTime.now();
    }

    /** 设置支持视觉输入 */
    public void setSupportsVision(Boolean supportsVision) {
        this.supportsVision = supportsVision;
        this.updatedAt = LocalDateTime.now();
    }

    /** 更新描述 */
    public void updateDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    /** 是否可用 */
    public boolean isAvailable() {
        return "AVAILABLE".equals(this.status);
    }

    /** 是否支持流式输出 */
    public boolean hasStreamingSupport() {
        return Boolean.TRUE.equals(this.supportsStream);
    }

    /** 是否支持工具调用 */
    public boolean hasFunctionCallSupport() {
        return Boolean.TRUE.equals(this.supportsFunctionCall);
    }

    /** 是否支持视觉 */
    public boolean hasVisionSupport() {
        return Boolean.TRUE.equals(this.supportsVision);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}