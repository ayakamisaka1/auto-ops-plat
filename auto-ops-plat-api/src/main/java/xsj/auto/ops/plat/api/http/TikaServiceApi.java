package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;

public interface TikaServiceApi {
    ResultBody<String> textCut(String fileUrl);
}
