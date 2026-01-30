package xsj.auto.ops.plat.types.enums;

public enum ToolRiskLevel {
    /**
     * 只读、无副作用
     * 例如：
     * - 查询
     * - 搜索
     * - 校验
     */
    READ_ONLY(1, "只读能力，无任何副作用"),

    /**
     * 有副作用，但可回滚或可控
     * 例如：
     * - 发送消息
     * - 写日志
     * - 创建草稿
     */
    SIDE_EFFECT(2, "有副作用，但影响可控"),

    /**
     * 高风险、不可逆
     * 例如：
     * - 打款
     * - 删除数据
     * - 修改核心状态
     */
    CRITICAL(3, "高风险，不可逆操作");

    private final int level;
    private final String description;

    ToolRiskLevel(int level, String description) {
        this.level = level;
        this.description = description;
    }

    public int level() {
        return level;
    }

    public String description() {
        return description;
    }
}
