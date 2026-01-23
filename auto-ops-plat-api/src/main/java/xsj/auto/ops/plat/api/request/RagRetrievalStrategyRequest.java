package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class RagRetrievalStrategyRequest {

    private Long id;
    private String strategyName;
    private Integer topK;
    private Double scoreThreshold;
    private String filterCondition;
    private Long rerankModelId;
    private String promptTemplate;
}
