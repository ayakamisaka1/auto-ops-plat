package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.request.RagDataSourceRequest;
import xsj.auto.ops.plat.api.response.RagDataSourceResponse;
import xsj.auto.ops.plat.application.entityCase.RagDataSourceService;
import xsj.auto.ops.plat.domain.entity.RagDataSource;
import xsj.auto.ops.plat.domain.repository.RagDataSourceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RagDataSourceCaseImpl implements RagDataSourceService {

    private final RagDataSourceRepository ragDataSourceRepository;

    @Override
    public List<RagDataSourceResponse> list() {
        return ragDataSourceRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RagDataSourceResponse getById(Long id) {
        return ragDataSourceRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    @Override
    @Transactional
    public RagDataSourceResponse create(RagDataSourceRequest request) {
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
        return toResponse(entity);
    }

    @Override
    @Transactional
    public RagDataSourceResponse update(RagDataSourceRequest request) {
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
        return toResponse(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ragDataSourceRepository.deleteById(id);
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
