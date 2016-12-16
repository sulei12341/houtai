package code.tianmao.h5.dao;

import code.tianmao.h5.domain.Permission;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Junpeng.Su
 * @date 2016/11/21
 */
public interface PermissionDao extends Mapper<Permission> {

    List<Permission> findMenuListByUserId(Long userId);

    List<Permission> findPermissionListByUserId(Long userId);

}
