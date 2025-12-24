package xsj.auto.ops.plat.api.http;

import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.request.SysUserRequest;
import xsj.auto.ops.plat.api.response.SysUserResponse;

public interface SysUserServiceApi {
    ResultBody<SysUserResponse> createSysUser(SysUserRequest sysUserRequest);
}
