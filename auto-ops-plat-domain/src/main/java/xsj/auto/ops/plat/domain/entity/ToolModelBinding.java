package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class ToolModelBinding {

    private Long id;
    private Long toolId;
    private Long llmModelId;
    private Integer enable;
    private Integer maxCalls;
    private Integer rateLimit;

    private ToolModelBinding(Long id, Long toolId, Long llmModelId, Integer enable, Integer maxCalls, Integer rateLimit) {
        this.id = id;
        this.toolId = toolId;
        this.llmModelId = llmModelId;
        this.enable = enable;
        this.maxCalls = maxCalls;
        this.rateLimit = rateLimit;
    }

    public static ToolModelBinding create(Long id, Long toolId, Long llmModelId, Integer enable, Integer maxCalls, Integer rateLimit) {
        return new ToolModelBinding(id, toolId, llmModelId, enable, maxCalls, rateLimit);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
