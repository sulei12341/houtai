package code.tianmao.h5.dao;

import code.tianmao.h5.domain.sys.Permission;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Junpeng.Su
 * @date 2016/11/21
 */
public interface PermissionDao extends Mapper<Permission> {
    /**
     * 根据用户ID查询用户拥有的菜单
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<Permission> findMenuListByUserId(Long userId);

    /**
     * 根据用户ID查询用户拥有的权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    List<Permission> findPermissionListByUserId(Long userId);

}
