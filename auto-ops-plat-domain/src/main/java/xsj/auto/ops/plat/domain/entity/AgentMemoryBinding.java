package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class AgentMemoryBinding {

    private Long id;
    private String agentId;
    private Integer priority;
    private Boolean active;

    private AgentMemoryBinding(Long id, String agentId, Integer priority, Boolean active) {
        this.id = id;
        this.agentId = agentId;
        this.priority = priority;
        this.active = active;
    }

    public static AgentMemoryBinding create(Long id, String agentId, Integer priority, Boolean active) {
        return new AgentMemoryBinding(id, agentId, priority, active);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
