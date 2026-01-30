package xsj.auto.ops.plat.domain.entity.LlmFactoryEntity;

import lombok.Getter;
import xsj.auto.ops.plat.types.enums.AuthType;
import xsj.auto.ops.plat.types.enums.ProviderStatus;
import xsj.auto.ops.plat.types.enums.ProviderType;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class AiLlmProvider {
    /** 领域唯一标识 */
    private  Long id;

    /** 中台级唯一编码（逻辑主键） */
    private  String providerCode;

    /** 展示名称 */
    private String providerName;

    /** 提供方类型 */
    private ProviderType providerType;

    /** 默认 Base URL */
    private String baseUrl;

    /** 鉴权方式（不包含密钥） */
    private AuthType authType;

    /** 当前状态 */
    private ProviderStatus status;

    /** 描述说明 */
    private String description;

    /** 审计字段 */
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    // =========================
    // 构造（工厂控制创建）
    // =========================
    private AiLlmProvider(
            Long id,
            String providerCode,
            String providerName,
            ProviderType providerType,
            AuthType authType
    ) {
        this.id = id;
        this.providerCode = providerCode;
        this.providerName = providerName;
        this.providerType = providerType;
        this.authType = authType;
        this.status = ProviderStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
    }

    private AiLlmProvider() {

    }

    // =========================
    // 领域工厂方法
    // =========================
    public static AiLlmProvider create(
            Long id,
            String providerCode,
            String providerName,
            ProviderType providerType,
            AuthType authType
    ) {
        Objects.requireNonNull(providerCode);
        Objects.requireNonNull(providerType);
        Objects.requireNonNull(authType);

        return new AiLlmProvider(
                id,
                providerCode,
                providerName,
                providerType,
                authType
        );
    }

    /**
     * 从持久化状态恢复 Provider（重建聚合）
     */
    public static AiLlmProvider restore(
            String providerCode,
            String providerName,
            ProviderType providerType,
            String baseUrl,
            AuthType authType,
            ProviderStatus status,
            String description
    ) {
        AiLlmProvider provider = new AiLlmProvider();
        provider.providerCode = providerCode;
        provider.providerName = providerName;
        provider.providerType = providerType;
        provider.baseUrl = baseUrl;
        provider.authType = authType;
        provider.status = status;
        provider.description = description;
        return provider;
    }
    // =========================
    // 领域行为
    // =========================

    /** 启用提供方 */
    public void enable() {
        this.status = ProviderStatus.ACTIVE;
    }

    /** 禁用提供方 */
    public void disable() {
        this.status = ProviderStatus.DISABLED;
    }

    /** 修改基础访问地址 */
    public void changeBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /** 修改展示名称 */
    public void rename(String providerName) {
        this.providerName = providerName;
    }

    /** 是否可被选用 */
    public boolean isAvailable() {
        return this.status == ProviderStatus.ACTIVE;
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
