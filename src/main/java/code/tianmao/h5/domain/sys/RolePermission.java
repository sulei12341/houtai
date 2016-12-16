package code.tianmao.h5.domain.sys;

import code.tianmao.h5.domain.base.BaseDomain;

import javax.persistence.Table;

@Table(name = "sys_role_permission")
public class RolePermission extends BaseDomain<Long, Long> {

    private static final long serialVersionUID = -5524312932380869754L;

    private Long roleId;

    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}