package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.request.PromptBindingRequest;
import xsj.auto.ops.plat.api.response.PromptBindingResponse;
import xsj.auto.ops.plat.application.entityCase.PromptBindingService;
import xsj.auto.ops.plat.domain.entity.PromptBinding;
import xsj.auto.ops.plat.domain.repository.PromptBindingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PromptBindingCaseImpl implements PromptBindingService {

    private final PromptBindingRepository promptBindingRepository;

    @Override
    public List<PromptBindingResponse> list() {
        return promptBindingRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PromptBindingResponse getById(Long id) {
        return promptBindingRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    @Override
    @Transactional
    public PromptBindingResponse create(PromptBindingRequest request) {
        PromptBinding entity = PromptBinding.create(
                null,
                request.getBindType(),
                request.getBindId(),
                request.getPromptId(),
                request.getOrderIndex(),
                request.getEnabled()
        );
        promptBindingRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public PromptBindingResponse update(PromptBindingRequest request) {
        PromptBinding entity = PromptBinding.create(
                request.getId(),
                request.getBindType(),
                request.getBindId(),
                request.getPromptId(),
                request.getOrderIndex(),
                request.getEnabled()
        );
        promptBindingRepository.save(entity);
        return toResponse(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        promptBindingRepository.deleteById(id);
    }

    private PromptBindingResponse toResponse(PromptBinding entity) {
        return new PromptBindingResponse(
                entity.getId(),
                entity.getBindType(),
                entity.getBindId(),
                entity.getPromptId(),
                entity.getOrderIndex(),
                entity.getEnabled()
        );
    }
}
