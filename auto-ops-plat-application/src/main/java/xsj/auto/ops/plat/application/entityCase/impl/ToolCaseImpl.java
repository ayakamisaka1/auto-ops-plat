package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.ToolServiceApi;
import xsj.auto.ops.plat.api.request.ToolRequest;
import xsj.auto.ops.plat.api.response.ToolResponse;
import xsj.auto.ops.plat.application.entityCase.ToolCase;
import xsj.auto.ops.plat.domain.entity.Tool;
import xsj.auto.ops.plat.domain.repository.ToolRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToolCaseImpl implements ToolServiceApi {

    private final ToolRepository toolRepository;

    @Override
    public ResultBody<List<ToolResponse>> list() {
        return ResultBody.ok(toolRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<ToolResponse> getById(Long id) {
        return toolRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<ToolResponse> create(ToolRequest request) {
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
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<ToolResponse> update(ToolRequest request) {
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
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        toolRepository.deleteById(id);
        return ResultBody.ok();
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
