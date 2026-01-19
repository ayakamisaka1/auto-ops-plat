package xsj.auto.ops.plat.infrastructure.tika;

import org.apache.tika.Tika;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.domain.entity.tika.ExtractSourceEntity;
import xsj.auto.ops.plat.domain.entity.tika.ExtractedTextEntity;
import xsj.auto.ops.plat.domain.service.tika.TextExtractorService;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Tika文本提取服务实现类
 * <p>
 * 该类实现了TextExtractorService接口，使用Apache Tika进行文本提取
 * 支持处理各种格式的文件，并针对大文件进行了优化，避免内存爆炸
 * </p>
 */
@Service
public class TikaTextExtractorServiceImpl implements TextExtractorService {

    // 大文件处理配置
    private static final int MAX_TEXT_LENGTH = 10 * 1024 * 1024; // 10MB 最大文本提取长度
    private static final int MAX_CHARACTERS = -1; // -1表示不限制字符数，使用流处理
    
    private final Tika tika;
    private final AutoDetectParser autoDetectParser;
    private final ParseContext parseContext;
    
    /**
     * 构造函数
     * <p>
     * 初始化Tika核心组件，包括：
     * 1. Tika配置
     * 2. Tika核心实例
     * 3. 自动检测解析器
     * 4. 解析上下文
     * </p>
     */
    public TikaTextExtractorServiceImpl() {
        try {
            // 初始化Tika配置
            TikaConfig tikaConfig = TikaConfig.getDefaultConfig();
            // 初始化Tika核心实例，使用配置
            this.tika = new Tika(tikaConfig);
            // 创建自动检测解析器，根据文件类型自动选择合适的解析器
            this.autoDetectParser = new AutoDetectParser(tikaConfig);
            // 创建解析上下文
            this.parseContext = new ParseContext();
            // 在上下文中注册解析器，用于递归解析（如zip中的文档）
            this.parseContext.set(Parser.class, autoDetectParser);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Tika components", e);
        }
    }
    
    /**
     * 提取文本
     * <p>
     * 核心逻辑：
     * 1. 使用TikaInputStream包装输入流，优化大文件处理
     * 2. 创建元数据对象，设置文件名和MIME类型
     * 3. 使用BodyContentHandler处理文本提取，配置为流处理模式
     * 4. 使用AutoDetectParser自动选择解析器
     * 5. 提取文本并进行长度检查和截断
     * 6. 返回提取结果
     * </p>
     * 
     * @param source 提取源信息
     * @param inputStream 输入流
     * @return 提取结果实体
     */
    @Override
    public ExtractedTextEntity extract(ExtractSourceEntity source, InputStream inputStream) {
        try (TikaInputStream tikaInputStream = TikaInputStream.get(inputStream)) {
            // 创建元数据对象，用于存储解析结果和传递信息
            Metadata metadata = new Metadata();
            
            // 设置文件名到元数据，有助于Tika更准确地检测文件类型
            if (source.getFileName() != null) {
                metadata.set(Metadata.RESOURCE_NAME_KEY, source.getFileName());
            }
            
            // 如果提供了MIME类型，也设置到元数据中
            if (source.getMimeType() != null) {
                metadata.set(Metadata.CONTENT_TYPE, source.getMimeType());
            }
            
            // 创建内容处理器，用于获取提取的文本
            // 使用MAX_CHARACTERS=-1配置，表示不限制字符数，使用流处理
            BodyContentHandler contentHandler = new BodyContentHandler(MAX_CHARACTERS);
            
            // 使用自动检测解析器解析文档
            // 自动检测解析器会根据文件内容和元数据选择最合适的解析器
            autoDetectParser.parse(tikaInputStream, contentHandler, metadata, parseContext);
            
            // 获取提取的文本并去除首尾空白
            String text = contentHandler.toString().trim();
            
            // 提取文件的MIME类型
            String detectedMimeType = metadata.get(Metadata.CONTENT_TYPE);
            
            // 提取元数据到Map中
            Map<String, String> extractedMetadata = new HashMap<>();
            for (String name : metadata.names()) {
                extractedMetadata.put(name, metadata.get(name));
            }
            
            // 返回提取结果
            if (!text.isBlank()) {
                // 如果文本超过最大长度，截断处理
                if (text.length() > MAX_TEXT_LENGTH) {
                    text = text.substring(0, MAX_TEXT_LENGTH) + "... [TRUNCATED]";
                }
                return ExtractedTextEntity.of(
                        text,
                        source.getFileName(),
                        detectedMimeType,
                        extractedMetadata
                );
            } else {
                // 文本为空，返回失败结果
                return ExtractedTextEntity.ofFailed(
                        source.getFileName(),
                        detectedMimeType,
                        extractedMetadata
                );
            }
        } catch (Exception e) {
            // 处理异常情况
            return ExtractedTextEntity.ofFailed(
                    source.getFileName(),
                    source.getMimeType(),
                    Map.of()
            );
        }
    }
}