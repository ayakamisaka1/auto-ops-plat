package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.PromptDefinitionServiceApi;
import xsj.auto.ops.plat.api.request.PromptDefinitionRequest;
import xsj.auto.ops.plat.api.response.PromptDefinitionResponse;
import xsj.auto.ops.plat.application.entityCase.PromptDefinitionCase;
import xsj.auto.ops.plat.domain.entity.PromptDefinition;
import xsj.auto.ops.plat.domain.repository.PromptDefinitionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PromptDefinitionCaseImpl implements PromptDefinitionServiceApi {

    private final PromptDefinitionRepository promptDefinitionRepository;

    @Override
    public ResultBody<List<PromptDefinitionResponse>> list() {
        return ResultBody.ok(promptDefinitionRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<PromptDefinitionResponse> getById(Long id) {
        return promptDefinitionRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<PromptDefinitionResponse> create(PromptDefinitionRequest request) {
        PromptDefinition entity = PromptDefinition.create(
                null,
                request.getName(),
                request.getPromptType(),
                request.getContent(),
                request.getDescription(),
                request.getEnabled()
        );
        promptDefinitionRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<PromptDefinitionResponse> update(PromptDefinitionRequest request) {
        PromptDefinition entity = PromptDefinition.create(
                request.getId(),
                request.getName(),
                request.getPromptType(),
                request.getContent(),
                request.getDescription(),
                request.getEnabled()
        );
        promptDefinitionRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        promptDefinitionRepository.deleteById(id);
        return ResultBody.ok();
    }

    private PromptDefinitionResponse toResponse(PromptDefinition entity) {
        return new PromptDefinitionResponse(
                entity.getId(),
                entity.getName(),
                entity.getPromptType(),
                entity.getContent(),
                entity.getDescription(),
                entity.getEnabled()
        );
    }
}
