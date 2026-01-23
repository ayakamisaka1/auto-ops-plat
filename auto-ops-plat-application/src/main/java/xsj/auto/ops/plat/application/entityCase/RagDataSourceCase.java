package xsj.auto.ops.plat.application.entityCase;

import xsj.auto.ops.plat.api.request.RagDataSourceRequest;
import xsj.auto.ops.plat.api.response.RagDataSourceResponse;

import java.util.List;

public interface RagDataSourceCase {

    List<RagDataSourceResponse> list();

    RagDataSourceResponse getById(Long id);

    RagDataSourceResponse create(RagDataSourceRequest request);

    RagDataSourceResponse update(RagDataSourceRequest request);

    void delete(Long id);
}
