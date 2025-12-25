package xsj.auto.ops.plat.infrastructure.mapper;

import org.springframework.stereotype.Component;
import xsj.auto.ops.plat.domain.entity.SysUser;
import xsj.auto.ops.plat.infrastructure.jpaEntity.SysUserPO;
@Component
public class SysUserMapper {

    public  SysUserPO toJpa(SysUser user) {
        SysUserPO po = new SysUserPO();
        // 注意：不设置 id
        po.setUsername(user.getUsername());
        po.setPassword(user.getPassword());
        return po;
    }

    public  SysUser toDomain(SysUserPO po) {
        return SysUser.create(po.getId(), po.getUsername(), po.getPassword());
    }
}
