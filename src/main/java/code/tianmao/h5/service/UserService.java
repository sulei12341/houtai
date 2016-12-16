package code.tianmao.h5.service;

import code.tianmao.h5.dto.PermissionDto;
import code.tianmao.h5.dto.UserDto;

import java.util.List;

/**
 * @author Junpeng.Su
 * @date 2016/11/21
 */
public interface UserService {

    /**
     * 根据用户名查询会员
     *
     * @param username 会员名称
     * @return 会员信息
     */
    UserDto findUserByUsername(String username);

    /**
     * 根据用户ID查询用户可以访问的菜单
     *
     * @return 菜单列表
     */
    List<PermissionDto> findMenuListByUserId(Long userId);

    List<PermissionDto> findPermissionListByUserId(Long userId) throws Exception;


}
