package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.ToolModelBindingServiceApi;
import xsj.auto.ops.plat.api.request.ToolModelBindingRequest;
import xsj.auto.ops.plat.api.response.ToolModelBindingResponse;
import xsj.auto.ops.plat.application.entityCase.ToolModelBindingCase;
import xsj.auto.ops.plat.domain.entity.ToolModelBinding;
import xsj.auto.ops.plat.domain.repository.ToolModelBindingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToolModelBindingCaseImpl implements ToolModelBindingServiceApi {

    private final ToolModelBindingRepository toolModelBindingRepository;

    @Override
    public ResultBody<List<ToolModelBindingResponse>> list() {
        return ResultBody.ok(toolModelBindingRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<ToolModelBindingResponse> getById(Long id) {
        return toolModelBindingRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<ToolModelBindingResponse> create(ToolModelBindingRequest request) {
        ToolModelBinding entity = ToolModelBinding.create(
                null,
                request.getToolId(),
                request.getLlmModelId(),
                request.getEnable(),
                request.getMaxCalls(),
                request.getRateLimit()
        );
        toolModelBindingRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<ToolModelBindingResponse> update(ToolModelBindingRequest request) {
        ToolModelBinding entity = ToolModelBinding.create(
                request.getId(),
                request.getToolId(),
                request.getLlmModelId(),
                request.getEnable(),
                request.getMaxCalls(),
                request.getRateLimit()
        );
        toolModelBindingRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        toolModelBindingRepository.deleteById(id);
        return ResultBody.ok();
    }

    private ToolModelBindingResponse toResponse(ToolModelBinding entity) {
        return new ToolModelBindingResponse(
                entity.getId(),
                entity.getToolId(),
                entity.getLlmModelId(),
                entity.getEnable(),
                entity.getMaxCalls(),
                entity.getRateLimit()
        );
    }
}
