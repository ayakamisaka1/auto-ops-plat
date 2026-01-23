package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromptBindingResponse {

    private Long id;
    private String bindType;
    private Long bindId;
    private Long promptId;
    private Integer orderIndex;
    private Boolean enabled;
}
