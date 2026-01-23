package xsj.auto.ops.plat.api.request;

import lombok.Data;

@Data
public class RagDocumentRequest {

    private Long id;
    private Long sourceId;
    private String docName;
    private String docType;
    private String rawContent;
    private String meta;
    private String status;
    private Integer version;
}
