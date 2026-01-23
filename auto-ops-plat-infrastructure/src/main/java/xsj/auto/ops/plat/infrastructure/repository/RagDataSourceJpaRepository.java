package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagDataSourcePO;

import java.util.List;
import java.util.Optional;

public interface RagDataSourceJpaRepository extends JpaRepository<RagDataSourcePO, Long> {
    Optional<RagDataSourcePO> findBySourceName(String sourceName);
    List<RagDataSourcePO> findBySourceType(String sourceType);
    List<RagDataSourcePO> findByEnabled(Boolean enabled);
}
