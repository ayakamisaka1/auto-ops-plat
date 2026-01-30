package xsj.auto.ops.plat.infrastructure.tika;

import java.io.InputStream;

public interface  DocumentSource {
    InputStream openStream();

    String fileName();

    String mimeType();

    String sourceType();

    String sourceId();
}
