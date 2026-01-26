package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.PromptCapabilityConstraintServiceApi;
import xsj.auto.ops.plat.api.request.PromptCapabilityConstraintRequest;
import xsj.auto.ops.plat.api.response.PromptCapabilityConstraintResponse;
import xsj.auto.ops.plat.application.entityCase.PromptCapabilityConstraintCase;
import xsj.auto.ops.plat.domain.entity.PromptCapabilityConstraint;
import xsj.auto.ops.plat.domain.repository.PromptCapabilityConstraintRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PromptCapabilityConstraintCaseImpl implements PromptCapabilityConstraintServiceApi {

    private final PromptCapabilityConstraintRepository promptCapabilityConstraintRepository;

    @Override
    public ResultBody<List<PromptCapabilityConstraintResponse>> list() {
        return ResultBody.ok(promptCapabilityConstraintRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<PromptCapabilityConstraintResponse> getById(Long id) {
        return promptCapabilityConstraintRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<PromptCapabilityConstraintResponse> create(PromptCapabilityConstraintRequest request) {
        PromptCapabilityConstraint entity = PromptCapabilityConstraint.create(
                null,
                request.getPromptId(),
                request.getCapabilityType(),
                request.getConstraintRule()
        );
        promptCapabilityConstraintRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<PromptCapabilityConstraintResponse> update(PromptCapabilityConstraintRequest request) {
        PromptCapabilityConstraint entity = PromptCapabilityConstraint.create(
                request.getId(),
                request.getPromptId(),
                request.getCapabilityType(),
                request.getConstraintRule()
        );
        promptCapabilityConstraintRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        promptCapabilityConstraintRepository.deleteById(id);
        return ResultBody.ok();
    }

    private PromptCapabilityConstraintResponse toResponse(PromptCapabilityConstraint entity) {
        return new PromptCapabilityConstraintResponse(
                entity.getId(),
                entity.getPromptId(),
                entity.getCapabilityType(),
                entity.getConstraintRule()
        );
    }
}
