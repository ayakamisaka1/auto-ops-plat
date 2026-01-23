package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class McpServiceRequest {

    private Long id;
    private String serviceCode;
    private String serviceName;
    private String serviceType;
    private String description;
    private Integer status;
}
