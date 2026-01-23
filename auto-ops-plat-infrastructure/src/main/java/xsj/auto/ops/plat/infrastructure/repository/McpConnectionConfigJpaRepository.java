package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.mcp.McpConnectionConfigPO;

import java.util.List;

public interface McpConnectionConfigJpaRepository extends JpaRepository<McpConnectionConfigPO, Long> {
    List<McpConnectionConfigPO> findByProtocol(String protocol);
    List<McpConnectionConfigPO> findByEnabled(Boolean enabled);
}
