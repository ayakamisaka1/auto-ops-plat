package xsj.auto.ops.plat.trigger.test;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xsj.auto.ops.plat.domain.service.AgentFlowService.AgentFlowParser;
import xsj.auto.ops.plat.domain.service.AgentFlowService.AgentParseResult;

import java.util.Map;

@RestController
@RequestMapping("/agent-flow")
@RequiredArgsConstructor
public class AgentFlowController {

     @Resource AgentFlowParser agentFlowParser;
    /**
     * 解析 Agent Flow
     * 只做 JSON → 执行计划 & 资源需求
     */
    @PostMapping("/parse")
    public Map<String, Object> parse(@RequestBody String flowJson) {

        try {
            AgentParseResult result = agentFlowParser.parseFlowJson(flowJson);

            return Map.of(
                    "success", true,
                    "requiredResources", result.getRequiredResources(),
                    "executionOrder", result.getExecutionOrder()
            );

        } catch (Exception e) {
            return Map.of(
                    "success", false,
                    "error", e.getMessage()
            );
        }
    }
}
