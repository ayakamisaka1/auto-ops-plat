package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class PromptBindingRequest {

    private Long id;
    private String bindType;
    private Long bindId;
    private Long promptId;
    private Integer orderIndex;
    private Boolean enabled;
}
