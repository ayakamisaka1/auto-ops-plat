package xsj.auto.ops.plat.domain.factory;

import org.springframework.ai.tool.ToolCallback;

import java.util.List;

public interface ToolCapabilityFactory {
    /**
     * 查询llm对应的所有的工具
     */
    List<ToolCallback> findAllTools(Long id);
}
