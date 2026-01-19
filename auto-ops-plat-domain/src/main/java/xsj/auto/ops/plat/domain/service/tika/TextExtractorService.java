package xsj.auto.ops.plat.domain.service.tika;

import xsj.auto.ops.plat.domain.entity.tika.ExtractSourceEntity;
import xsj.auto.ops.plat.domain.entity.tika.ExtractedTextEntity;

import java.io.InputStream;

public interface TextExtractorService {
    ExtractedTextEntity extract(ExtractSourceEntity source, InputStream inputStream);
}
