package xsj.auto.ops.plat.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysUserResponse {
    private Long id;
    private String userName;
    private String password;

    public SysUserResponse(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
