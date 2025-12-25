package xsj.auto.ops.plat.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import xsj.auto.ops.plat.domain.entity.SysUser;
import xsj.auto.ops.plat.domain.repository.SysUserRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.SysUserPO;
import xsj.auto.ops.plat.infrastructure.mapper.SysUserMapper;

import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class SysUserRepositoryImpl implements SysUserRepository {

    private final SysUserJpaRepository sysUserJpaRepository;
    private final SysUserMapper SysUserMapper;
    @Override
    public void save(SysUser user) {
        SysUserPO po = SysUserMapper.toJpa(user);
        SysUserPO saved = sysUserJpaRepository.save(po);
        user.assignId(saved.getId());
    }

    @Override
    public Optional<SysUser> findById(Long id) {
        return sysUserJpaRepository.findById(id).map(SysUserMapper::toDomain);
    }

    @Override
    public boolean existsByUsername(String username) {
        return sysUserJpaRepository.existsByUsername(username);
    }
}
