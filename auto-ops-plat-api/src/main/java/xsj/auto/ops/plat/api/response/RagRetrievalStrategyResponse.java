package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RagRetrievalStrategyResponse {

    private Long id;
    private String strategyName;
    private Integer topK;
    private Double scoreThreshold;
    private String filterCondition;
    private Long rerankModelId;
    private String promptTemplate;
}
