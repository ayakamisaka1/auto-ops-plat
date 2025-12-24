package xsj.auto.ops.plat.trigger.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.SysUserServiceApi;
import xsj.auto.ops.plat.api.request.SysUserRequest;
import xsj.auto.ops.plat.api.response.SysUserResponse;
import xsj.auto.ops.plat.application.entityCase.SysUserCase;
@RestController
@RequestMapping("/test")
public class SysUserController implements SysUserServiceApi {

    @Resource
    private SysUserCase sysUserCase;

    @Override
    @PostMapping("/createSysUser")
    public ResultBody<SysUserResponse> createSysUser(@RequestBody SysUserRequest sysUserRequest) {
        return ResultBody.ok(sysUserCase.createSysUser(sysUserRequest));
    }
}
