package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RagDataSourceResponse {

    private Long id;
    private String sourceName;
    private String sourceType;
    private String config;
    private String syncMode;
    private String syncInterval;
    private Boolean enabled;
}
