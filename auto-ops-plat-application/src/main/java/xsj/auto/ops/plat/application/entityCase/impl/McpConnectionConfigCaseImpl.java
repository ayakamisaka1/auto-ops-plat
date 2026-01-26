package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.McpConnectionConfigServiceApi;
import xsj.auto.ops.plat.api.request.McpConnectionConfigRequest;
import xsj.auto.ops.plat.api.response.McpConnectionConfigResponse;
import xsj.auto.ops.plat.application.entityCase.McpConnectionConfigCase;
import xsj.auto.ops.plat.domain.entity.McpConnectionConfig;
import xsj.auto.ops.plat.domain.repository.McpConnectionConfigRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class McpConnectionConfigCaseImpl implements McpConnectionConfigServiceApi {

    private final McpConnectionConfigRepository mcpConnectionConfigRepository;

    @Override
    public ResultBody<List<McpConnectionConfigResponse>> list() {
        return ResultBody.ok(mcpConnectionConfigRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<McpConnectionConfigResponse> getById(Long id) {
        return mcpConnectionConfigRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<McpConnectionConfigResponse> create(McpConnectionConfigRequest request) {
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
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<McpConnectionConfigResponse> update(McpConnectionConfigRequest request) {
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
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        mcpConnectionConfigRepository.deleteById(id);
        return ResultBody.ok();
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
