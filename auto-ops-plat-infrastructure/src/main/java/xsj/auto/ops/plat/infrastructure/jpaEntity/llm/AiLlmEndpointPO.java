package xsj.auto.ops.plat.infrastructure.jpaEntity.llm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

/**
 * LLM 模型能力接口定义 * * 用于描述某个模型在某个 Provider 下
 * * 对外暴露的能力访问地址（如 Chat / Embedding）
 * * * 表名：ai_llm_endpoint
 */
@Getter
@Setter
@Entity
@Table(name = "ai_llm_endpoint")
@Comment("LLM 模型能力接口定义表")
public class AiLlmEndpointPO extends BaseJpaEntity {

    /**
     * 模型 ID
     */
    @Comment("模型 ID")
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false, foreignKey = @ForeignKey(name = "fk_llm_endpoint_model"))
    private AiLlmModelPO aiLlmModelPO;
    /**
     * 能力类型 * CHAT / EMBEDDING / IMAGE / AUDIO
     */
    @Column(name = "capability_type", nullable = false, length = 32)
    @Comment("能力类型：CHAT / EMBEDDING / IMAGE / AUDIO")
    private String capabilityType;
    /**
     * HTTP 请求方法 * POST / GET
     */
    @Column(name = "http_method", nullable = false, length = 16)
    @Comment("HTTP 请求方法")
    private String httpMethod;
    /**
     * 接口路径（不包含 base_url） * 例如：/v1/chat/completions
     */
    @Column(name = "path", nullable = false, length = 256)
    @Comment("接口访问路径（不包含 base_url）")
    private String path;
    /**
     * 当前状态 * ACTIVE / DISABLED
     */
    @Column(name = "status", nullable = false, length = 32)
    @Comment("接口状态：ACTIVE / DISABLED")
    private String status;
    /**
     * 接口描述
     */
    @Column(name = "description", length = 512)
    @Comment("接口描述")
    private String description;
}
