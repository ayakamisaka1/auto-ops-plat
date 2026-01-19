package xsj.auto.ops.plat.trigger.tika;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.TikaServiceApi;
import xsj.auto.ops.plat.application.entityCase.TikaResource;


@RestController
@RequestMapping("/tika")
public class TikaController implements TikaServiceApi {
    @Resource
    private TikaResource tikaResource;

    @Override
    @PostMapping("/cut")
    public ResultBody<String> textCut(String fileUrl) {
        return ResultBody.ok(tikaResource.fileCut(fileUrl));
    }
}
