package xsj.auto.ops.plat.domain.entity.tika;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;
@Getter
public class ExtractedTextEntity {
    private final String text;

    // 文档基本属性
    private final String fileName;
    private final String mimeType;

    // 技术元数据（来源于解析器）
    private final Map<String, String> metadata;

    private ExtractedTextEntity(
            String text,
            String fileName,
            String mimeType,
            Map<String, String> metadata
    ) {
        this.text = text;
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.metadata = metadata == null
                ? Collections.emptyMap()
                : Collections.unmodifiableMap(metadata);
    }

    /** 工厂方法：正常抽取结果 */
    public static ExtractedTextEntity of(
            String text,
            String fileName,
            String mimeType,
            Map<String, String> metadata
    ) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Extracted text cannot be empty");
        }
        return new ExtractedTextEntity(text, fileName, mimeType, metadata);
    }

    /** 工厂方法：抽取失败结果 */
    public static ExtractedTextEntity ofFailed(
            String fileName,
            String mimeType,
            Map<String, String> metadata
    ) {
        return new ExtractedTextEntity(null, fileName, mimeType, metadata);
    }

    /** 领域行为，而不是字段 */
    public int length() {
        return text != null ? text.length() : 0;
    }

    /** 领域行为：判断抽取是否成功 */
    public boolean isSuccess() {
        return text != null && !text.isBlank();
    }
}
