package code.tianmao.h5.service.impl;

import code.tianmao.h5.dao.PermissionDao;
import code.tianmao.h5.dao.UserDao;
import code.tianmao.h5.domain.Permission;
import code.tianmao.h5.domain.User;
import code.tianmao.h5.dto.PermissionDto;
import code.tianmao.h5.dto.UserDto;
import code.tianmao.h5.service.UserService;
import code.tianmao.h5.utils.BeanUtilPlus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Junpeng.Su
 * @date 2016/11/21
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private PermissionDao permissionDao;

    @Override
    public UserDto findUserByUsername(String username) {
        User user = userDao.findUserByUsername(username);
        return BeanUtilPlus.copyAs(user, UserDto.class);
    }

    @Override
    public List<PermissionDto> findMenuListByUserId(Long userId) {
        List<Permission> permissionList = permissionDao.findMenuListByUserId(userId);
        List<PermissionDto> permissionDtoList = new ArrayList<>();
        for (Permission permission : permissionList) {
            permissionDtoList.add(BeanUtilPlus.copyAs(permission, PermissionDto.class));
        }
        return permissionDtoList;
    }

    @Override
    public List<PermissionDto> findPermissionListByUserId(Long userId) {
        List<Permission> permissionList = permissionDao.findPermissionListByUserId(userId);
        List<PermissionDto> permissionDtoList = new ArrayList<>();
        for (Permission permission : permissionList) {
            permissionDtoList.add(BeanUtilPlus.copyAs(permission, PermissionDto.class));
        }
        return permissionDtoList;
    }
}
