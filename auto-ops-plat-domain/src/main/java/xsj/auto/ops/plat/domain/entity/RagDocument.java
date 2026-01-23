package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class RagDocument {

    private Long id;
    private Long sourceId;
    private String docName;
    private String docType;
    private String rawContent;
    private String meta;
    private String status;
    private Integer version;

    private RagDocument(Long id, Long sourceId, String docName, String docType,
                      String rawContent, String meta, String status, Integer version) {
        this.id = id;
        this.sourceId = sourceId;
        this.docName = docName;
        this.docType = docType;
        this.rawContent = rawContent;
        this.meta = meta;
        this.status = status;
        this.version = version;
    }

    public static RagDocument create(Long id, Long sourceId, String docName, String docType,
                                  String rawContent, String meta, String status, Integer version) {
        return new RagDocument(id, sourceId, docName, docType, rawContent, meta, status, version);
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
