package xsj.auto.ops.plat.domain.service.AgentFlowService;

import java.util.List;

public class AgentParseResult {
    // agent 需要的资源（给你做“能力组合”）
    private List<Object> requiredResources;

    // agent 的执行顺序（给执行器）
    private List<Object> executionOrder;

    public AgentParseResult(List<Object> requiredResources, List<Object> executionOrder) {
        this.requiredResources = requiredResources;
        this.executionOrder = executionOrder;
    }

    public List<Object> getRequiredResources() {
        return requiredResources;
    }

    public List<Object> getExecutionOrder() {
        return executionOrder;
    }
}
