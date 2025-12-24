package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.SysUser;

import java.util.Optional;

public interface SysUserRepository {

    void save(SysUser user);

    Optional<SysUser> findById(Long id);

    boolean existsByUsername(String username);
}
