package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.RagRetrievalStrategy;
import xsj.auto.ops.plat.infrastructure.jpaEntity.rag.RagRetrievalStrategyPO;

@Component
public class RagRetrievalStrategyMapper {

    public RagRetrievalStrategyPO toJpa(RagRetrievalStrategy strategy) {
        RagRetrievalStrategyPO po = new RagRetrievalStrategyPO();
        if (strategy.getId() != null) {
            po.setId(strategy.getId());
        }
        po.setStrategyName(strategy.getStrategyName());
        po.setTopK(strategy.getTopK());
        po.setScoreThreshold(strategy.getScoreThreshold());
        po.setFilterCondition(strategy.getFilterCondition());
        po.setRerankModelId(strategy.getRerankModelId());
        po.setPromptTemplate(strategy.getPromptTemplate());
        return po;
    }

    public RagRetrievalStrategy toDomain(RagRetrievalStrategyPO po) {
        return RagRetrievalStrategy.create(
                po.getId(),
                po.getStrategyName(),
                po.getTopK(),
                po.getScoreThreshold(),
                po.getFilterCondition(),
                po.getRerankModelId(),
                po.getPromptTemplate()
        );
    }
}
