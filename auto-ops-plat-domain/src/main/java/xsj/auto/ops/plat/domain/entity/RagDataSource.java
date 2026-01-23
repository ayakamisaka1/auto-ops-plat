package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class RagDataSource {

    private Long id;
    private String sourceName;
    private String sourceType;
    private String config;
    private String syncMode;
    private String syncInterval;
    private Boolean enabled;

    private RagDataSource(Long id, String sourceName, String sourceType, String config,
                       String syncMode, String syncInterval, Boolean enabled) {
        this.id = id;
        this.sourceName = sourceName;
        this.sourceType = sourceType;
        this.config = config;
        this.syncMode = syncMode;
        this.syncInterval = syncInterval;
        this.enabled = enabled;
    }

    public static RagDataSource create(Long id, String sourceName, String sourceType, String config,
                                    String syncMode, String syncInterval, Boolean enabled) {
        return new RagDataSource(id, sourceName, sourceType, config, syncMode, syncInterval, enabled);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
