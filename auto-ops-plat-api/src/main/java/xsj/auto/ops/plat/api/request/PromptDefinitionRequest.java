package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class PromptDefinitionRequest {

    private Long id;
    private String name;
    private String promptType;
    private String content;
    private String description;
    private Boolean enabled;
}
