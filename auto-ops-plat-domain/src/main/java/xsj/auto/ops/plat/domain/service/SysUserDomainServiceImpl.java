package xsj.auto.ops.plat.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.domain.entity.SysUser;
import xsj.auto.ops.plat.domain.repository.SysUserRepository;
@Service
@RequiredArgsConstructor
public class SysUserDomainServiceImpl implements SysUserDomainService {

    private final SysUserRepository sysUserRepository;

    @Override
    public void checkCreate(SysUser sysUser) {
        if (sysUserRepository.existsByUsername(sysUser.getUsername())) {
            throw new RuntimeException("用户名已存在");
        }
    }
}
