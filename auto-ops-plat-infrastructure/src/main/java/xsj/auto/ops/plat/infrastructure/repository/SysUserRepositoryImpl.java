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

    @Override
    public void save(SysUser user) {
        SysUserPO po = SysUserMapper.toJpa(user);
        SysUserPO saved = sysUserJpaRepository.save(po);
        user.assignId(saved.getId());
    }

    @Override
    public Optional<SysUser> findById(Long id) {
        Optional<SysUserPO> byId = sysUserJpaRepository.findById(id);
        return Optional.of(SysUserMapper.toDomain(byId.get()));
    }

    @Override
    public boolean existsByUsername(String username) {
        return sysUserJpaRepository.existsByUsername(username);
    }
}
