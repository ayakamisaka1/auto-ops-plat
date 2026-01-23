package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class PromptDefinition {

    private Long id;
    private String name;
    private String promptType;
    private String content;
    private String description;
    private Boolean enabled;

    private PromptDefinition(Long id, String name, String promptType, String content,
                          String description, Boolean enabled) {
        this.id = id;
        this.name = name;
        this.promptType = promptType;
        this.content = content;
        this.description = description;
        this.enabled = enabled;
    }

    public static PromptDefinition create(Long id, String name, String promptType, String content,
                                       String description, Boolean enabled) {
        return new PromptDefinition(id, name, promptType, content, description, enabled);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
