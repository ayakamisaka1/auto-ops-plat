package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class RagRetrievalStrategy {

    private Long id;
    private String strategyName;
    private Integer topK;
    private Double scoreThreshold;
    private String filterCondition;
    private Long rerankModelId;
    private String promptTemplate;

    private RagRetrievalStrategy(Long id, String strategyName, Integer topK, Double scoreThreshold,
                                String filterCondition, Long rerankModelId, String promptTemplate) {
        this.id = id;
        this.strategyName = strategyName;
        this.topK = topK;
        this.scoreThreshold = scoreThreshold;
        this.filterCondition = filterCondition;
        this.rerankModelId = rerankModelId;
        this.promptTemplate = promptTemplate;
    }

    public static RagRetrievalStrategy create(Long id, String strategyName, Integer topK, Double scoreThreshold,
                                              String filterCondition, Long rerankModelId, String promptTemplate) {
        return new RagRetrievalStrategy(id, strategyName, topK, scoreThreshold, filterCondition, rerankModelId, promptTemplate);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
