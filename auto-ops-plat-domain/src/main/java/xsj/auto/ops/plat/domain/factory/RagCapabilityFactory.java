package xsj.auto.ops.plat.domain.factory;

public interface RagCapabilityFactory {
    /**
     * 查询agent对应的能使用的知识库
     */
    String usingRag(Long agentId);
}
