package xsj.auto.ops.plat.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xsj.auto.ops.plat.infrastructure.jpaEntity.SysUserPO;

public interface SysUserJpaRepository extends JpaRepository<SysUserPO, Long> {
    boolean existsByUsername(String username);
}
