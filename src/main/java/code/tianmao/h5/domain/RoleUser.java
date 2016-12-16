package code.tianmao.h5.domain;

import javax.persistence.Table;

@Table(name = "sys_role_user")
public class RoleUser extends BaseDomain<Long, Long>  {

    private static final long serialVersionUID = -5524312912380869754L;

    private Long userId;

    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}