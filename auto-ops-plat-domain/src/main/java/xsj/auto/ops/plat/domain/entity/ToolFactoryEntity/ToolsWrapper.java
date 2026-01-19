package xsj.auto.ops.plat.domain.entity.ToolFactoryEntity;

import lombok.Getter;
import org.springframework.ai.tool.ToolCallback;

import java.util.List;
@Getter
public class ToolsWrapper {
    //工具集
    private List<ToolCallback> toolCallbacks;

    public ToolsWrapper(List<ToolCallback> toolCallbacks) {
        this.toolCallbacks = toolCallbacks;
    }
}
