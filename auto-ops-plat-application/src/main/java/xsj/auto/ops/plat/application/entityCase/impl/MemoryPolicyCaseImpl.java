package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.MemoryPolicyServiceApi;
import xsj.auto.ops.plat.api.request.MemoryPolicyRequest;
import xsj.auto.ops.plat.api.response.MemoryPolicyResponse;
import xsj.auto.ops.plat.application.entityCase.MemoryPolicyCase;
import xsj.auto.ops.plat.domain.entity.MemoryPolicy;
import xsj.auto.ops.plat.domain.repository.MemoryPolicyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemoryPolicyCaseImpl implements MemoryPolicyServiceApi {

    private final MemoryPolicyRepository memoryPolicyRepository;

    @Override
    public ResultBody<List<MemoryPolicyResponse>> list() {
        return ResultBody.ok(memoryPolicyRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<MemoryPolicyResponse> getById(Long id) {
        return memoryPolicyRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<MemoryPolicyResponse> create(MemoryPolicyRequest request) {
        MemoryPolicy entity = MemoryPolicy.create(
                null,
                request.getPolicyCode(),
                request.getPolicyName(),
                request.getDescription(),
                request.getTriggerType(),
                request.getTriggerValue(),
                request.getIncludeRole(),
                request.getImportanceMin(),
                request.getSummaryPrompt(),
                request.getSummaryModel(),
                request.getTtlDays(),
                request.getActive()
        );
        memoryPolicyRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<MemoryPolicyResponse> update(MemoryPolicyRequest request) {
        MemoryPolicy entity = MemoryPolicy.create(
                request.getId(),
                request.getPolicyCode(),
                request.getPolicyName(),
                request.getDescription(),
                request.getTriggerType(),
                request.getTriggerValue(),
                request.getIncludeRole(),
                request.getImportanceMin(),
                request.getSummaryPrompt(),
                request.getSummaryModel(),
                request.getTtlDays(),
                request.getActive()
        );
        memoryPolicyRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        memoryPolicyRepository.deleteById(id);
        return ResultBody.ok();
    }

    private MemoryPolicyResponse toResponse(MemoryPolicy entity) {
        return new MemoryPolicyResponse(
                entity.getId(),
                entity.getPolicyCode(),
                entity.getPolicyName(),
                entity.getDescription(),
                entity.getTriggerType(),
                entity.getTriggerValue(),
                entity.getIncludeRole(),
                entity.getImportanceMin(),
                entity.getSummaryPrompt(),
                entity.getSummaryModel(),
                entity.getTtlDays(),
                entity.getActive()
        );
    }
}
