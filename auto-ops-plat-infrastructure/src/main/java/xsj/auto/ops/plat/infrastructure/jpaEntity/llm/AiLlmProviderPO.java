package xsj.auto.ops.plat.infrastructure.jpaEntity.llm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

/**
 * LLM 服务提供方实体 * * <p> * 表示一个逻辑上的大模型服务提供者，例如： * OpenAI、阿里云、腾讯云、本地私有化部署等。
 * * * <p> * 该实体仅描述「提供方的存在与能力接入方式」，
 * * 不包含任何具体模型信息，也不包含鉴权密钥等敏感数据。 *
 * * <p> * 在 AI 中台中，该实体属于【基础能力资源层】，
 * * 被 Agent / Tool / Flow 间接使用。
 */
@Getter
@Setter
@Entity
@Table(name = "ai_llm_provider")
@Comment("LLM 服务提供商")
public class AiLlmProviderPO extends BaseJpaEntity {
    /**
     * 提供方代码（中台级唯一） * <p> * 用于逻辑引用，例如：openai / aliyun / local
     */
    @Comment("提供方代码（中台级唯一）")
    @Column(name = "provider_code", nullable = false, length = 64)
    private String providerCode;
    /**
     * 提供方名称 * <p> * 用于展示与运维识别，不参与逻辑判断。
     */
    @Comment("提供方名称")
    @Column(name = "provider_name", nullable = false, length = 128)
    private String providerName;
    /**
     * 提供方类型 * <p> * 例如：CLOUD / PRIVATE / LOCAL
     */
    @Comment("提供方类型")
    @Column(name = "provider_type", nullable = false, length = 32)
    private String providerType;
    /**
     * 提供方基础访问地址 * <p> * 作为默认 base url 使用，具体调用时允许覆盖。
     */
    @Comment("提供方基础访问地址")
    @Column(name = "base_url", length = 256)
    private String baseUrl;
    /**
     * 鉴权方式类型 * <p> * 例如：API_KEY / OAUTH / NONE * 仅描述方式，不存储任何密钥信息。
     */
    @Comment("鉴权方式类型")
    @Column(name = "auth_type", nullable = false, length = 32)
    private String authType;
    /**
     * key
     */
    @Comment("鉴权方式类型")
    @Column(name = "api_key", nullable = false, length = 225)
    private String apiKey;
    /**
     * 提供方状态 * <p> * ACTIVE：可用 * DISABLED：已禁用（不可被选择）
     */
    @Comment("提供方状态")
    @Column(name = "status", nullable = false, length = 32)
    private String status;

    /**
     * 备注描述 * <p> * 用于说明提供方特性或补充信息。
     */
    @Comment("备注描述")
    @Column(name = "description", length = 512)
    private String description;
}
