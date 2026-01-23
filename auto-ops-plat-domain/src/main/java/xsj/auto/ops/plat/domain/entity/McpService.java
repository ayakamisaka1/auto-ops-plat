package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class McpService {

    private Long id;
    private String serviceCode;
    private String serviceName;
    private String serviceType;
    private String description;
    private Integer status;

    private McpService(Long id, String serviceCode, String serviceName,
                    String serviceType, String description, Integer status) {
        this.id = id;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.description = description;
        this.status = status;
    }

    public static McpService create(Long id, String serviceCode, String serviceName,
                                  String serviceType, String description, Integer status) {
        return new McpService(id, serviceCode, serviceName, serviceType, description, status);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
