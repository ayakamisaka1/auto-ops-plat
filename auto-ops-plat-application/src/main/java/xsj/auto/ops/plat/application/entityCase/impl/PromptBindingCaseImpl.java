package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.PromptBindingServiceApi;
import xsj.auto.ops.plat.api.request.PromptBindingRequest;
import xsj.auto.ops.plat.api.response.PromptBindingResponse;
import xsj.auto.ops.plat.application.entityCase.PromptBindingCase;
import xsj.auto.ops.plat.domain.entity.PromptBinding;
import xsj.auto.ops.plat.domain.repository.PromptBindingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PromptBindingCaseImpl implements PromptBindingServiceApi {

    private final PromptBindingRepository promptBindingRepository;

    @Override
    public ResultBody<List<PromptBindingResponse>> list() {
        return ResultBody.ok(promptBindingRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<PromptBindingResponse> getById(Long id) {
        return promptBindingRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<PromptBindingResponse> create(PromptBindingRequest request) {
        PromptBinding entity = PromptBinding.create(
                null,
                request.getBindType(),
                request.getBindId(),
                request.getPromptId(),
                request.getOrderIndex(),
                request.getEnabled()
        );
        promptBindingRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<PromptBindingResponse> update(PromptBindingRequest request) {
        PromptBinding entity = PromptBinding.create(
                request.getId(),
                request.getBindType(),
                request.getBindId(),
                request.getPromptId(),
                request.getOrderIndex(),
                request.getEnabled()
        );
        promptBindingRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        promptBindingRepository.deleteById(id);
        return ResultBody.ok();
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
