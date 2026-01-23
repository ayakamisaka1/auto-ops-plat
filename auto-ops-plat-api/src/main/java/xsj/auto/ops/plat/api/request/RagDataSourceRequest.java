package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class RagDataSourceRequest {

    private Long id;
    private String sourceName;
    private String sourceType;
    private String config;
    private String syncMode;
    private String syncInterval;
    private Boolean enabled;
}
