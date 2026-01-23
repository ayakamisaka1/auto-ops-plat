package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.RagEmbedding;

import java.util.List;
import java.util.Optional;

public interface RagEmbeddingRepository {

    void save(RagEmbedding ragEmbedding);

    Optional<RagEmbedding> findById(Long id);

    List<RagEmbedding> findAll();

    void deleteById(Long id);

    List<RagEmbedding> findByChunkId(Long chunkId);

    List<RagEmbedding> findByEmbeddingModelId(Long embeddingModelId);

    List<RagEmbedding> findByStatus(String status);
}
