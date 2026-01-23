package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.McpService;

import java.util.List;
import java.util.Optional;

public interface McpServiceRepository {

    void save(McpService service);

    Optional<McpService> findById(Long id);

    List<McpService> findAll();

    void deleteById(Long id);

    Optional<McpService> findByServiceCode(String serviceCode);

    List<McpService> findByServiceType(String serviceType);

    List<McpService> findByStatus(Integer status);
}
