package xsj.auto.ops.plat.api.response;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RagDocumentResponse {

    private Long id;
    private Long sourceId;
    private String docName;
    private String docType;
    private String rawContent;
    private String meta;
    private String status;
    private Integer version;
}
