package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.request.ToolModelBindingRequest;
import xsj.auto.ops.plat.api.response.ToolModelBindingResponse;
import xsj.auto.ops.plat.application.entityCase.ToolModelBindingService;
import xsj.auto.ops.plat.domain.entity.ToolModelBinding;
import xsj.auto.ops.plat.domain.repository.ToolModelBindingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToolModelBindingCaseImpl implements ToolModelBindingService {

    private final ToolModelBindingRepository toolModelBindingRepository;

    @Override
    public List<ToolModelBindingResponse> list() {
        return toolModelBindingRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ToolModelBindingResponse getById(Long id) {
        return toolModelBindingRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    @Override
    @Transactional
    public ToolModelBindingResponse create(ToolModelBindingRequest request) {
        ToolModelBinding entity = ToolModelBinding.create(
                null,
                request.getToolId(),
                request.getLlmModelId(),
                request.getEnable(),
                request.getMaxCalls(),
                request.getRateLimit()
        );
        toolModelBindingRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public ToolModelBindingResponse update(ToolModelBindingRequest request) {
        ToolModelBinding entity = ToolModelBinding.create(
                request.getId(),
                request.getToolId(),
                request.getLlmModelId(),
                request.getEnable(),
                request.getMaxCalls(),
                request.getRateLimit()
        );
        toolModelBindingRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        toolModelBindingRepository.deleteById(id);
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
