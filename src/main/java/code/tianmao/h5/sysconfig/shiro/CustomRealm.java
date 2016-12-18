package code.tianmao.h5.sysconfig.shiro;

import code.tianmao.h5.domain.sys.Permission;
import code.tianmao.h5.dto.PermissionDto;
import code.tianmao.h5.dto.UserDto;
import code.tianmao.h5.service.MemberService;
import code.tianmao.h5.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Title: CustomRealm
 * </p>
 * <p>
 * Description:自定义realm
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 *
 * @author 传智.燕青
 * @version 1.0
 * @date 2015-3-23下午4:54:47
 */
public class CustomRealm extends AuthorizingRealm {

    //注入service
    @Autowired
    private MemberService memberService;

    @Autowired
    private UserService userService;

    // 设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    //realm的认证方法，从数据库查询用户信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {

        // token是用户输入的用户名和密码
        // 第一步从token中取出用户名
        String username = (String) token.getPrincipal();

        // 第二步：根据用户输入的userCode从数据库查询
        UserDto userDto = null;
        try {
            userDto = userService.findUserByUsername(username);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // 如果查询不到返回null
        if (userDto == null) {//
            return null;
        }
        // 从数据库查询到密码
        String password = userDto.getPassword();

        //盐
        String salt = userDto.getSalt();


        //根据用户id取出菜单
        List<Permission> menus = null;
        try {
            //通过service取出菜单
            menus = memberService.findMenuListByUserId(userDto.getId());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //将用户菜单 设置到activeUser
        userDto.setMenus(menus);
        //将activeUser设置simpleAuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                userDto, password, ByteSource.Util.bytes(salt), this.getName());
        return simpleAuthenticationInfo;
    }


    // 用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {

        //从 principals获取主身份信息
        //将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
        UserDto userDto = (UserDto) principals.getPrimaryPrincipal();

        //根据身份信息获取权限信息
        //从数据库获取到权限数据
        List<PermissionDto> permissionList = null;
        try {
            permissionList = userService.findPermissionListByUserId(userDto.getId());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //单独定一个集合对象
        List<String> permissions = new ArrayList<String>();
        if (permissionList != null) {
            for (PermissionDto permissionDto : permissionList) {
                //将数据库中的权限标签 符放入集合
                permissions.add(permissionDto.getPercode());
            }
        }

        //查到权限数据，返回授权信息(要包括 上边的permissions)
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将上边查询到授权信息填充到simpleAuthorizationInfo对象中
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }


}
