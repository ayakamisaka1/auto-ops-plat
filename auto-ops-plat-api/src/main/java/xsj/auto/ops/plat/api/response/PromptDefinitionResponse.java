package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromptDefinitionResponse {

    private Long id;
    private String name;
    private String promptType;
    private String content;
    private String description;
    private Boolean enabled;
}
