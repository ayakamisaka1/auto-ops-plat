package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.RagDataSource;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagDataSourcePO;

@Component
public class RagDataSourceMapper {

    public RagDataSourcePO toJpa(RagDataSource dataSource) {
        RagDataSourcePO po = new RagDataSourcePO();
        if (dataSource.getId() != null) {
            po.setId(dataSource.getId());
        }
        po.setSourceName(dataSource.getSourceName());
        po.setSourceType(dataSource.getSourceType());
        po.setConfig(dataSource.getConfig());
        po.setSyncMode(dataSource.getSyncMode());
        po.setSyncInterval(dataSource.getSyncInterval());
        po.setEnabled(dataSource.getEnabled());
        return po;
    }

    public RagDataSource toDomain(RagDataSourcePO po) {
        return RagDataSource.create(
                po.getId(),
                po.getSourceName(),
                po.getSourceType(),
                po.getConfig(),
                po.getSyncMode(),
                po.getSyncInterval(),
                po.getEnabled()
        );
    }
}
