package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.McpService;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.McpServicePO;

@Component
public class McpServiceMapper {

    public McpServicePO toJpa(McpService service) {
        McpServicePO po = new McpServicePO();
        if (service.getId() != null) {
            po.setId(service.getId());
        }
        po.setServiceCode(service.getServiceCode());
        po.setServiceName(service.getServiceName());
        po.setServiceType(service.getServiceType());
        po.setDescription(service.getDescription());
        po.setStatus(service.getStatus());
        return po;
    }

    public McpService toDomain(McpServicePO po) {
        return McpService.create(
                po.getId(),
                po.getServiceCode(),
                po.getServiceName(),
                po.getServiceType(),
                po.getDescription(),
                po.getStatus()
        );
    }
}
