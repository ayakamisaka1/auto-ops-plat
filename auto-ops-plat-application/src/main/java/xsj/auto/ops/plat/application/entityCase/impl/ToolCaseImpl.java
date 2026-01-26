package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.request.ToolRequest;
import xsj.auto.ops.plat.api.response.ToolResponse;
import xsj.auto.ops.plat.application.entityCase.ToolService;
import xsj.auto.ops.plat.domain.entity.Tool;
import xsj.auto.ops.plat.domain.repository.ToolRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToolCaseImpl implements ToolService {

    private final ToolRepository toolRepository;

    @Override
    public List<ToolResponse> list() {
        return toolRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ToolResponse getById(Long id) {
        return toolRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    @Override
    @Transactional
    public ToolResponse create(ToolRequest request) {
        Tool entity = Tool.create(
                null,
                request.getToolCode(),
                request.getToolName(),
                request.getMcpServiceId(),
                request.getMcpMethod(),
                request.getInputSchema(),
                request.getOutputSchema(),
                request.getDescription(),
                request.getRiskLevel(),
                request.getStatus()
        );
        toolRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public ToolResponse update(ToolRequest request) {
        Tool entity = Tool.create(
                request.getId(),
                request.getToolCode(),
                request.getToolName(),
                request.getMcpServiceId(),
                request.getMcpMethod(),
                request.getInputSchema(),
                request.getOutputSchema(),
                request.getDescription(),
                request.getRiskLevel(),
                request.getStatus()
        );
        toolRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        toolRepository.deleteById(id);
    }

    private ToolResponse toResponse(Tool entity) {
        return new ToolResponse(
                entity.getId(),
                entity.getToolCode(),
                entity.getToolName(),
                entity.getMcpServiceId(),
                entity.getMcpMethod(),
                entity.getInputSchema(),
                entity.getOutputSchema(),
                entity.getDescription(),
                entity.getRiskLevel(),
                entity.getStatus()
        );
    }
}
