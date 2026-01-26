package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.RagDataSourceServiceApi;
import xsj.auto.ops.plat.api.request.RagDataSourceRequest;
import xsj.auto.ops.plat.api.response.RagDataSourceResponse;
import xsj.auto.ops.plat.application.entityCase.RagDataSourceCase;
import xsj.auto.ops.plat.domain.entity.RagDataSource;
import xsj.auto.ops.plat.domain.repository.RagDataSourceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RagDataSourceCaseImpl implements RagDataSourceServiceApi {

    private final RagDataSourceRepository ragDataSourceRepository;

    @Override
    public ResultBody<List<RagDataSourceResponse>> list() {
        return ResultBody.ok(ragDataSourceRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList()));
    }

    @Override
    public ResultBody<RagDataSourceResponse> getById(Long id) {
        return ragDataSourceRepository.findById(id)
                .map(this::toResponse)
                .map(ResultBody::ok)
                .orElse(null);
    }

    @Override
    @Transactional
    public ResultBody<RagDataSourceResponse> create(RagDataSourceRequest request) {
        RagDataSource entity = RagDataSource.create(
                null,
                request.getSourceName(),
                request.getSourceType(),
                request.getConfig(),
                request.getSyncMode(),
                request.getSyncInterval(),
                request.getEnabled()
        );
        ragDataSourceRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<RagDataSourceResponse> update(RagDataSourceRequest request) {
        RagDataSource entity = RagDataSource.create(
                request.getId(),
                request.getSourceName(),
                request.getSourceType(),
                request.getConfig(),
                request.getSyncMode(),
                request.getSyncInterval(),
                request.getEnabled()
        );
        ragDataSourceRepository.save(entity);
        return ResultBody.ok(toResponse(entity));
    }

    @Override
    @Transactional
    public ResultBody<Void> delete(Long id) {
        ragDataSourceRepository.deleteById(id);
        return ResultBody.ok();
    }

    private RagDataSourceResponse toResponse(RagDataSource entity) {
        return new RagDataSourceResponse(
                entity.getId(),
                entity.getSourceName(),
                entity.getSourceType(),
                entity.getConfig(),
                entity.getSyncMode(),
                entity.getSyncInterval(),
                entity.getEnabled()
        );
    }
}
