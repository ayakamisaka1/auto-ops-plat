package xsj.auto.ops.plat.domain.entity.tika;

import lombok.Getter;

@Getter
public class ExtractSourceEntity {
    private final String fileName;
    private final String mimeType;
    private final String sourceType;
    private final String sourceId;

    private ExtractSourceEntity(
            String fileName,
            String mimeType,
            String sourceType,
            String sourceId
    ) {
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.sourceType = sourceType;
        this.sourceId = sourceId;
    }

    public static ExtractSourceEntity of(
            String fileName,
            String mimeType,
            String sourceType,
            String sourceId
    ) {
        return new ExtractSourceEntity(fileName, mimeType, sourceType, sourceId);
    }
}
