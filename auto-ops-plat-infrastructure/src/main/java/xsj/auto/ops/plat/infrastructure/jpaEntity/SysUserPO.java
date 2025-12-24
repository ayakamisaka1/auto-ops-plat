package xsj.auto.ops.plat.infrastructure.jpaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sys_user")
public class SysUserPO extends BaseJpaEntity{
    @Column(nullable = false, unique = true)
    private String username;

    @Column(length = 20)
    private String password;
}
