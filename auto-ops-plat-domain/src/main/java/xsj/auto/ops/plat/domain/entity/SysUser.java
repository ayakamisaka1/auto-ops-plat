package xsj.auto.ops.plat.domain.entity;

import lombok.Getter;

@Getter
public class SysUser {

    private Long id;
    private String username;
    private String password;

    private SysUser(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static SysUser create(Long id, String username, String password) {
        return new SysUser(id, username, password);
    }


    public void assignId(Long id) {
        this.id = id;
    }
}
