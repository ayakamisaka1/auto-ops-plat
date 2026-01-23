package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.McpConnectionConfig;

import java.util.List;
import java.util.Optional;

public interface McpConnectionConfigRepository {

    void save(McpConnectionConfig config);

    Optional<McpConnectionConfig> findById(Long id);

    List<McpConnectionConfig> findAll();

    void deleteById(Long id);

    List<McpConnectionConfig> findByProtocol(String protocol);

    List<McpConnectionConfig> findByEnabled(Boolean enabled);
}
