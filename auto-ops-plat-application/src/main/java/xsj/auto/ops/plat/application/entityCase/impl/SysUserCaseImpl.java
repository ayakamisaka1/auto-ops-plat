package xsj.auto.ops.plat.application.entityCase.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.api.request.SysUserRequest;
import xsj.auto.ops.plat.api.response.SysUserResponse;
import xsj.auto.ops.plat.application.entityCase.SysUserCase;
import xsj.auto.ops.plat.domain.entity.SysUser;
import xsj.auto.ops.plat.domain.repository.SysUserRepository;
import xsj.auto.ops.plat.domain.service.SysUserDomainService;

@Service
@RequiredArgsConstructor
public class SysUserCaseImpl implements SysUserCase {


    private final SysUserRepository sysUserRepository;
    private final SysUserDomainService sysUserDomainService;

    @Override
    @Transactional
    public SysUserResponse createSysUser(SysUserRequest sysUserRequest) {
        // 1️⃣ DTO → 领域对象（Application 的职责）
        SysUser user = SysUser.create(
                null,
                sysUserRequest.getUserName(),
                sysUserRequest.getPassword()
        );

        // 2️⃣ 领域规则（Domain 决定）
        sysUserDomainService.checkCreate(user);

        // 3️⃣ 持久化（通过 Domain 定义的仓储接口）
        sysUserRepository.save(user);

        // 4️⃣ 返回 API Response
        return new SysUserResponse(user.getId(),user.getUsername(),user.getPassword());
    }
}
