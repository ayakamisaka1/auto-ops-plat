package xsj.auto.ops.plat.application.entityCase.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.application.entityCase.TikaResource;
import xsj.auto.ops.plat.domain.entity.tika.ExtractSourceEntity;
import xsj.auto.ops.plat.domain.entity.tika.ExtractedTextEntity;
import xsj.auto.ops.plat.domain.service.tika.TextExtractorService;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
@RequiredArgsConstructor
public class TikaResourceImpl implements TikaResource {

    private final TextExtractorService textExtractorService;

    @Override
    public String fileCut(String filePath) {
        try {
            // 1. 清理文件路径：去除首尾空白字符，特别是末尾的空格
            String cleanedFilePath = filePath.trim();
            // 2. 将清理后的filePath转换为Path对象
            Path path = Paths.get(cleanedFilePath);
            // 3. 验证文件是否存在
            if (!Files.exists(path)) {
                return "File not found: " + cleanedFilePath;
            }
            // 4. 验证是否为文件
            if (!Files.isRegularFile(path)) {
                return "Path is not a file: " + cleanedFilePath;
            }
            // 5. 获取文件名
            String fileName = path.getFileName().toString();
            // 6. 创建文件输入流
            try (InputStream inputStream = new FileInputStream(path.toFile())) {
                // 7. 创建提取源信息
                ExtractSourceEntity source = ExtractSourceEntity.of(
                        fileName, // 文件名
                        null,     // MIME类型，由Tika自动检测
                        "local",  // 源类型
                        cleanedFilePath  // 源ID，使用清理后的路径
                );
                // 8. 提取文本
                ExtractedTextEntity result = textExtractorService.extract(source, inputStream);
                // 9. 返回提取结果
                if (result.isSuccess()) {
                    return result.getText();
                } else {
                    String mimeType = result.getMimeType();
                    return "Text extraction failed: " + (mimeType != null ? mimeType : "unknown mime type");
                }
            }
        } catch (Exception e) {
            return "Error extracting text: " + e.getMessage();
        }
    }
}
