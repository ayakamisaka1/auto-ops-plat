package xsj.auto.ops.plat.application.entityCase;
import xsj.auto.ops.plat.api.request.SysUserRequest;
import xsj.auto.ops.plat.api.response.SysUserResponse;

public interface SysUserCase {

    SysUserResponse createSysUser(SysUserRequest sysUserRequest);
}
