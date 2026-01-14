package xsj.auto.ops.plat.infrastructure.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.domain.service.AgentFlowService.AgentFlowParser;
import xsj.auto.ops.plat.domain.service.AgentFlowService.AgentParseResult;

import java.util.*;

@Service
public class AgentFlowParserImpl implements AgentFlowParser {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public AgentParseResult parseFlowJson(String flowJson) {
        try {
            return this.parse(flowJson);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public AgentParseResult parse(String json) throws Exception {

        JsonNode root = MAPPER.readTree(json);

        JsonNode nodesNode = root.get("nodes");
        JsonNode edgesNode = root.get("edges"); // 可能为 null

        if (nodesNode == null || !nodesNode.isArray()) {
            throw new IllegalArgumentException("Invalid flow json: nodes is missing or not array");
        }

        // ---------- 1. 收集节点 ----------
        Map<String, JsonNode> nodeMap = new LinkedHashMap<>();
        for (JsonNode node : nodesNode) {
            nodeMap.put(node.get("id").asText(), node);
        }

        // ---------- 2. 解析执行顺序 ----------
        List<Object> executionOrder;
        if (edgesNode == null || !edgesNode.isArray() || edgesNode.isEmpty()) {
            executionOrder = parseByNodeOrder(nodesNode);
        } else {
            executionOrder = parseByEdges(nodeMap, edgesNode);
        }

        // ---------- 3. 扫描所需资源 ----------
        Map<String, Object> requiredResources = scanRequiredResources(nodesNode);

        return new AgentParseResult(
                List.of(requiredResources), // 你现在是 List<Object>，先包一层
                executionOrder
        );
    }

    // ======================= 资源扫描 =======================

    private Map<String, Object> scanRequiredResources(JsonNode nodesNode) {

        List<Object> llms = new ArrayList<>();
        List<Object> rags = new ArrayList<>();
        List<Object> memories = new ArrayList<>();

        for (JsonNode node : nodesNode) {
            String type = node.get("type").asText();
            String nodeId = node.get("id").asText();

            JsonNode dataNode = node.get("data");
            if (dataNode == null) continue;

            JsonNode inputsValues = dataNode.get("inputsValues");
            if (inputsValues == null) continue;

            switch (type) {
                case "llm" -> llms.add(parseLLM(nodeId, inputsValues));
                case "rag" -> rags.add(parseRAG(nodeId, inputsValues));
                case "memory" -> memories.add(parseMemory(nodeId, inputsValues));
                default -> {
                    // 非资源节点，忽略
                }
            }
        }

        Map<String, Object> resources = new HashMap<>();
        resources.put("llms", llms);
        resources.put("rags", rags);
        resources.put("memories", memories);
        return resources;
    }

    private Map<String, Object> parseLLM(String nodeId, JsonNode inputsValues) {
        Map<String, Object> llm = new HashMap<>();
        llm.put("resourceType", "LLM");
        llm.put("nodeId", nodeId);
        llm.put("model", getContent(inputsValues, "modelType"));
        llm.put("temperature", getContent(inputsValues, "temperature"));
        llm.put("tools", getContent(inputsValues, "tools"));
        return llm;
    }

    private Map<String, Object> parseRAG(String nodeId, JsonNode inputsValues) {
        Map<String, Object> rag = new HashMap<>();
        rag.put("resourceType", "RAG");
        rag.put("nodeId", nodeId);
        rag.put("knowledgeBase", getContent(inputsValues, "knowledgeBase"));
        rag.put("topK", getContent(inputsValues, "topK"));
        rag.put("temperature", getContent(inputsValues, "temperature"));
        return rag;
    }

    private Map<String, Object> parseMemory(String nodeId, JsonNode inputsValues) {
        Map<String, Object> memory = new HashMap<>();
        memory.put("resourceType", "MEMORY");
        memory.put("nodeId", nodeId);
        memory.put("scope", getContent(inputsValues, "memoryScope"));
        memory.put("contextCount", getContent(inputsValues, "contextCount"));
        memory.put("archiveInterval", getContent(inputsValues, "archiveInterval"));
        memory.put("enableArchive", getContent(inputsValues, "enableArchive"));
        return memory;
    }

    private Object getContent(JsonNode inputsValues, String key) {
        JsonNode node = inputsValues.get(key);
        if (node == null) return null;
        return MAPPER.convertValue(node.get("content"), Object.class);
    }

    // ======================= 执行顺序解析 =======================

    private static List<Object> parseByNodeOrder(JsonNode nodesNode) {
        List<Object> result = new ArrayList<>();

        for (JsonNode node : nodesNode) {
            Map<String, Object> step = new HashMap<>();
            step.put("nodeId", node.get("id").asText());
            step.put("type", node.get("type").asText());
            step.put("raw", MAPPER.convertValue(node, Object.class));
            result.add(step);
        }
        return result;
    }

    private static List<Object> parseByEdges(
            Map<String, JsonNode> nodeMap,
            JsonNode edgesNode
    ) {

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        for (String nodeId : nodeMap.keySet()) {
            graph.put(nodeId, new ArrayList<>());
            inDegree.put(nodeId, 0);
        }

        for (JsonNode edge : edgesNode) {
            String from = edge.get("from").asText();
            String to = edge.get("to").asText();
            if (!graph.containsKey(from) || !graph.containsKey(to)) continue;
            graph.get(from).add(to);
            inDegree.put(to, inDegree.get(to) + 1);
        }

        Queue<String> queue = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        List<Object> executionOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            String nodeId = queue.poll();
            JsonNode node = nodeMap.get(nodeId);

            Map<String, Object> step = new HashMap<>();
            step.put("nodeId", nodeId);
            step.put("type", node.get("type").asText());
            step.put("raw", MAPPER.convertValue(node, Object.class));
            executionOrder.add(step);

            for (String next : graph.get(nodeId)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.add(next);
                }
            }
        }

        return executionOrder;
    }
}
