package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class PromptBinding {

    private Long id;
    private String bindType;
    private Long bindId;
    private Long promptId;
    private Integer orderIndex;
    private Boolean enabled;

    private PromptBinding(Long id, String bindType, Long bindId, Long promptId, Integer orderIndex, Boolean enabled) {
        this.id = id;
        this.bindType = bindType;
        this.bindId = bindId;
        this.promptId = promptId;
        this.orderIndex = orderIndex;
        this.enabled = enabled;
    }

    public static PromptBinding create(Long id, String bindType, Long bindId, Long promptId, Integer orderIndex, Boolean enabled) {
        return new PromptBinding(id, bindType, bindId, promptId, orderIndex, enabled);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
