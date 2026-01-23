package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class McpServiceResponse {

    private Long id;
    private String serviceCode;
    private String serviceName;
    private String serviceType;
    private String description;
    private Integer status;
}
