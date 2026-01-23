package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.RagDataSource;

import java.util.List;
import java.util.Optional;

public interface RagDataSourceRepository {

    void save(RagDataSource dataSource);

    Optional<RagDataSource> findById(Long id);

    List<RagDataSource> findAll();

    void deleteById(Long id);

    Optional<RagDataSource> findBySourceName(String sourceName);

    List<RagDataSource> findBySourceType(String sourceType);

    List<RagDataSource> findByEnabled(Boolean enabled);
}
