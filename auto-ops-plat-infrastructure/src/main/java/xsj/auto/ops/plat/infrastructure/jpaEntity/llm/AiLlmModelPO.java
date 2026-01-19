package xsj.auto.ops.plat.infrastructure.jpaEntity.llm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

/**
 * LLM 模型实体 * * <p> * 表示 AI 中台中一个「可被使用的逻辑模型单元」，
 * * 例如：gpt-4o、qwen-max、llama-3-70b 等。 *
 * * <p> * 该实体用于描述模型的能力特征与基础约束，
 * * 不包含任何调用参数（temperature、top_p 等）。 *
 * * <p> * 模型的选择、路由、使用策略均不在该实体中定义，
 * * 由上层 Agent / Flow / Policy 决定。
 */
@Getter
@Setter
@Entity
@Table(name = "ai_llm_model")
@Comment("LLM 模型")
public class AiLlmModelPO extends BaseJpaEntity {
    /**
     * 所属 LLM 提供方 ID * <p> * 外键关联 ai_llm_provider.provider_id
     */
    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false, foreignKey = @ForeignKey(name = "fk_llm_model_provider"))
    @Comment("LLM 提供方 ID")
    private AiLlmProviderPO aiLlmProviderPO;
    /**
     * 模型代码 * <p> * 在同一提供方下唯一，例如：gpt-4o、qwen-max
     */
    @Comment("模型代码")
    @Column(name = "model_code", nullable = false, length = 64)
    private String modelCode;
    /**
     * 模型名称 * <p> * 用于展示，不作为逻辑判断依据。
     */
    @Comment("模型名称")
    @Column(name = "model_name", nullable = false, length = 128)
    private String modelName;
    /**
     * 模型版本 * <p> * 可选字段，用于区分同一模型的不同版本。
     */
    @Comment("模型版本")
    @Column(name = "model_version", length = 64)
    private String modelVersion;
    /**
     * 模型类型 * <p> * CHAT / EMBEDDING / MULTIMODAL
     */
    @Comment("模型类型")
    @Column(name = "model_type", nullable = false, length = 32)
    private String modelType;
    /**
     * 最大上下文长度（token）
     */
    @Comment("最大上下文长度（token）")
    @Column(name = "context_length")
    private Integer contextLength;
    /**
     * 最大输出 token 数
     */
    @Comment("最大输出 token 数")
    @Column(name = "max_output_tokens")
    private Integer maxOutputTokens;
    /**
     * 是否支持流式输出
     */
    @Comment("是否支持流式输出")
    @Column(name = "supports_stream")
    private Boolean supportsStream;
    /**
     * 是否支持工具 / 函数调用
     */
    @Comment("是否支持工具 / 函数调用")
    @Column(name = "supports_function_call")
    private Boolean supportsFunctionCall;
    /**
     * 是否支持视觉输入
     */
    @Comment("是否支持视觉输入")
    @Column(name = "supports_vision")
    private Boolean supportsVision;
    /**
     * 模型状态 * <p> * AVAILABLE：可用 * DEPRECATED：已废弃（不推荐使用） * DISABLED：不可用
     */
    @Comment("模型状态")
    @Column(name = "status", nullable = false, length = 32)
    private String status;
    /**
     * 模型描述说明
     */
    @Comment("模型描述说明")
    @Column(name = "description", length = 512)
    private String description;
}
