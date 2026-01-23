package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.RagChunk;

import java.util.List;
import java.util.Optional;

public interface RagChunkRepository {

    void save(RagChunk chunk);

    Optional<RagChunk> findById(Long id);

    List<RagChunk> findAll();

    void deleteById(Long id);

    List<RagChunk> findByDocumentId(Long documentId);

    List<RagChunk> findByChunkStrategy(String chunkStrategy);
}
