package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.AgentMemoryBindingServiceApi;
import xsj.auto.ops.plat.api.request.AgentMemoryBindingRequest;
import xsj.auto.ops.plat.api.response.AgentMemoryBindingResponse;
import xsj.auto.ops.plat.application.entityCase.AgentMemoryBindingCase;
import xsj.auto.ops.plat.domain.entity.AgentMemoryBinding;
import xsj.auto.ops.plat.domain.repository.AgentMemoryBindingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgentMemoryBindingCaseImpl implements AgentMemoryBindingServiceApi {

    private final AgentMemoryBindingRepository agentMemoryBindingRepository;

    @Override
    public ResultBody<List<AgentMemoryBindingResponse>> list() {
        java.util.List<AgentMemoryBindingResponse> list = agentMemoryBindingRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResultBody.ok(list);
    }

    @Override
    public ResultBody<AgentMemoryBindingResponse> getById(Long id) {
        return agentMemoryBindingRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<AgentMemoryBindingResponse> create(AgentMemoryBindingRequest request) {
        AgentMemoryBinding entity = AgentMemoryBinding.create(
                null,
                request.getAgentId(),
                request.getPriority(),
                request.getActive()
        );
        agentMemoryBindingRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<AgentMemoryBindingResponse> update(AgentMemoryBindingRequest request) {
        AgentMemoryBinding entity = AgentMemoryBinding.create(
                request.getId(),
                request.getAgentId(),
                request.getPriority(),
                request.getActive()
        );
        agentMemoryBindingRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        agentMemoryBindingRepository.deleteById(id);
        return ResultBody.ok();
    }

    private AgentMemoryBindingResponse toResponse(AgentMemoryBinding entity) {
        return new AgentMemoryBindingResponse(
                entity.getId(),
                entity.getAgentId(),
                entity.getPriority(),
                entity.getActive()
        );
    }
}
