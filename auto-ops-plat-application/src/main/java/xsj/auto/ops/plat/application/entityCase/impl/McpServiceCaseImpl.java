package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.request.McpServiceRequest;
import xsj.auto.ops.plat.api.response.McpServiceResponse;
import xsj.auto.ops.plat.application.entityCase.McpServiceCase;
import xsj.auto.ops.plat.domain.entity.McpService;
import xsj.auto.ops.plat.domain.repository.McpServiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class McpServiceCaseImpl implements McpServiceCase {

    private final McpServiceRepository mcpServiceRepository;

    @Override
    public List<McpServiceResponse> list() {
        return mcpServiceRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public McpServiceResponse getById(Long id) {
        return mcpServiceRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    @Override
    @Transactional
    public McpServiceResponse create(McpServiceRequest request) {
        McpService entity = McpService.create(
                null,
                request.getServiceCode(),
                request.getServiceName(),
                request.getServiceType(),
                request.getDescription(),
                request.getStatus()
        );
        mcpServiceRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public McpServiceResponse update(McpServiceRequest request) {
        McpService entity = McpService.create(
                request.getId(),
                request.getServiceCode(),
                request.getServiceName(),
                request.getServiceType(),
                request.getDescription(),
                request.getStatus()
        );
        mcpServiceRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        mcpServiceRepository.deleteById(id);
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
