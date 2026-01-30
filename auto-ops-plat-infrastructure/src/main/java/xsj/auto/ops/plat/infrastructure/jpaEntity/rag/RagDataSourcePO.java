package xsj.auto.ops.plat.infrastructure.jpaEntity.rag;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import xsj.auto.ops.plat.infrastructure.jpaEntity.BaseJpaEntity;

@Entity
@Table(name = "rag_data_source")
@Getter
@Setter
@Comment("RAG 数据源定义表：定义知识从哪里来")
public class RagDataSourcePO extends BaseJpaEntity {
    @Column(nullable = false, length = 128)
    @Comment("数据源名称，如：风控规则库 / 用户手册")
    private String sourceName;

    @Column(nullable = false, length = 32)
    @Comment("数据源类型：FILE / DB / API / LOG / MANUAL")
    private String sourceType;

    @Column(columnDefinition = "TEXT")
    @Comment("数据源配置(JSON)：连接信息、路径、SQL、接口地址等")
    private String config;

    @Column(length = 32)
    @Comment("同步模式：MANUAL / SCHEDULE / EVENT")
    private String syncMode;

    @Column(length = 64)
    @Comment("同步周期(cron 表达式)")
    private String syncInterval;

    @Comment("是否启用")
    private Boolean enabled = true;
}
