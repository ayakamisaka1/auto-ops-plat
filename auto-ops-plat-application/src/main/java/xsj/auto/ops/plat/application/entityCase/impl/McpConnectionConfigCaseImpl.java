package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.request.McpConnectionConfigRequest;
import xsj.auto.ops.plat.api.response.McpConnectionConfigResponse;
import xsj.auto.ops.plat.application.entityCase.McpConnectionConfigService;
import xsj.auto.ops.plat.domain.entity.McpConnectionConfig;
import xsj.auto.ops.plat.domain.repository.McpConnectionConfigRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class McpConnectionConfigCaseImpl implements McpConnectionConfigService {

    private final McpConnectionConfigRepository mcpConnectionConfigRepository;

    @Override
    public List<McpConnectionConfigResponse> list() {
        return mcpConnectionConfigRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public McpConnectionConfigResponse getById(Long id) {
        return mcpConnectionConfigRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    @Override
    @Transactional
    public McpConnectionConfigResponse create(McpConnectionConfigRequest request) {
        McpConnectionConfig entity = McpConnectionConfig.create(
                null,
                request.getName(),
                request.getProtocol(),
                request.getBaseUrl(),
                request.getEndpoint(),
                request.getAuthType(),
                request.getApiKey(),
                request.getHeadersJson(),
                request.getTimeoutSeconds(),
                request.getEnabled(),
                request.getExtensionConfigJson(),
                request.getMcpServerId()
        );
        mcpConnectionConfigRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public McpConnectionConfigResponse update(McpConnectionConfigRequest request) {
        McpConnectionConfig entity = McpConnectionConfig.create(
                request.getId(),
                request.getName(),
                request.getProtocol(),
                request.getBaseUrl(),
                request.getEndpoint(),
                request.getAuthType(),
                request.getApiKey(),
                request.getHeadersJson(),
                request.getTimeoutSeconds(),
                request.getEnabled(),
                request.getExtensionConfigJson(),
                request.getMcpServerId()
        );
        mcpConnectionConfigRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        mcpConnectionConfigRepository.deleteById(id);
    }

    private McpConnectionConfigResponse toResponse(McpConnectionConfig entity) {
        return new McpConnectionConfigResponse(
                entity.getId(),
                entity.getName(),
                entity.getProtocol(),
                entity.getBaseUrl(),
                entity.getEndpoint(),
                entity.getAuthType(),
                entity.getApiKey(),
                entity.getHeadersJson(),
                entity.getTimeoutSeconds(),
                entity.getEnabled(),
                entity.getExtensionConfigJson(),
                entity.getMcpServerId()
        );
    }
}
