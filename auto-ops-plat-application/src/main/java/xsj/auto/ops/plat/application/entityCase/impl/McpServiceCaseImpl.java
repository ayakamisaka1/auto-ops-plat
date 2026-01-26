package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.McpServiceServiceApi;
import xsj.auto.ops.plat.api.request.McpServiceRequest;
import xsj.auto.ops.plat.api.response.McpServiceResponse;
import xsj.auto.ops.plat.application.entityCase.McpServiceCase;
import xsj.auto.ops.plat.domain.entity.McpService;
import xsj.auto.ops.plat.domain.repository.McpServiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class McpServiceCaseImpl implements McpServiceServiceApi {

    private final McpServiceRepository mcpServiceRepository;

    @Override
    public ResultBody<List<McpServiceResponse>> list() {
        return ResultBody.ok(mcpServiceRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<McpServiceResponse> getById(Long id) {
        return mcpServiceRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<McpServiceResponse> create(McpServiceRequest request) {
        McpService entity = McpService.create(
                null,
                request.getServiceCode(),
                request.getServiceName(),
                request.getServiceType(),
                request.getDescription(),
                request.getStatus()
        );
        mcpServiceRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<McpServiceResponse> update(McpServiceRequest request) {
        McpService entity = McpService.create(
                request.getId(),
                request.getServiceCode(),
                request.getServiceName(),
                request.getServiceType(),
                request.getDescription(),
                request.getStatus()
        );
        mcpServiceRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        mcpServiceRepository.deleteById(id);
        return ResultBody.ok();
    }

    private McpServiceResponse toResponse(McpService entity) {
        return new McpServiceResponse(
                entity.getId(),
                entity.getServiceCode(),
                entity.getServiceName(),
                entity.getServiceType(),
                entity.getDescription(),
                entity.getStatus()
        );
    }
}
