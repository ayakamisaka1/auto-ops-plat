package xsj.auto.ops.plat.domain.service.AgentFlowService;

public interface AgentFlowParser {
    /**
     * 解析Agent流程JSON
     *
     * @param flowJson Agent流程JSON字符串
     * @return AgentFlow对象
     */
    AgentParseResult parseFlowJson(String flowJson);
}
