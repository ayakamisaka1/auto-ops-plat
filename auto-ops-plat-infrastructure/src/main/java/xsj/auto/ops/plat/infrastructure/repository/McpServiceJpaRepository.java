package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.McpServicePO;

import java.util.List;
import java.util.Optional;

public interface McpServiceJpaRepository extends JpaRepository<McpServicePO, Long> {
    Optional<McpServicePO> findByServiceCode(String serviceCode);
    List<McpServicePO> findByServiceType(String serviceType);
    List<McpServicePO> findByStatus(Integer status);
}
