package xsj.auto.ops.plat.domain.entity.LlmFactoryEntity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class AiLlmEndpoint {
    /** 领域唯一标识 */
    private Long id;

    /** 关联的模型ID */
    private Long modelId;

    /** 能力类型 */
    private String capabilityType;

    /** HTTP请求方法 */
    private String httpMethod;

    /** 接口路径（不包含base_url） */
    private String path;

    /** 当前状态 */
    private String status;

    /** 接口描述 */
    private String description;

    /** 审计字段 */
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    // =========================
    // 构造（工厂控制创建）
    // =========================
    private AiLlmEndpoint(Long modelId, String capabilityType, String httpMethod, String path) {
        this.modelId = modelId;
        this.capabilityType = capabilityType;
        this.httpMethod = httpMethod;
        this.path = path;
        this.status = "ACTIVE";
        this.createdAt = LocalDateTime.now();
    }

    private AiLlmEndpoint() {
    }

    // =========================
    // 领域工厂方法
    // =========================
    public static AiLlmEndpoint create(Long modelId, String capabilityType,
                                       String httpMethod, String path) {
        Objects.requireNonNull(modelId);
        Objects.requireNonNull(capabilityType);
        Objects.requireNonNull(httpMethod);
        Objects.requireNonNull(path);

        return new AiLlmEndpoint(modelId, capabilityType, httpMethod, path);
    }

    /**
     * 从持久化状态恢复 Endpoint（重建聚合）
     */
    public static AiLlmEndpoint restore(Long id, Long modelId, String capabilityType,
                                        String httpMethod, String path, String status,
                                        String description) {
        AiLlmEndpoint endpoint = new AiLlmEndpoint();
        endpoint.id = id;
        endpoint.modelId = modelId;
        endpoint.capabilityType = capabilityType;
        endpoint.httpMethod = httpMethod;
        endpoint.path = path;
        endpoint.status = status;
        endpoint.description = description;
        return endpoint;
    }

    // =========================
    // 领域行为
    // =========================

    /** 启用端点 */
    public void enable() {
        this.status = "ACTIVE";
    }

    /** 禁用端点 */
    public void disable() {
        this.status = "DISABLED";
    }

    /** 更新接口路径 */
    public void updatePath(String path) {
        Objects.requireNonNull(path);
        this.path = path;
        this.updatedAt = LocalDateTime.now();
    }

    /** 更新接口描述 */
    public void updateDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    /** 是否可被选用 */
    public boolean isAvailable() {
        return "ACTIVE".equals(this.status);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}