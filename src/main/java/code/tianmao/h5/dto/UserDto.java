package code.tianmao.h5.dto;

import code.tianmao.h5.domain.Permission;

import java.util.List;

/**
 * @author Junpeng.Su
 * @date 2016/12/9
 */
public class UserDto  extends BaseDto<Long, Long> {

    private static final long serialVersionUID = 4212044722058803049L;


    /**
     * 用户账号
     */
    private String username ;

    /**
     * 用户编码
     */
    private String usercode;

    /**
     * 密码
     */
    private String password ;

    /**
     * 手机号
     */
    private String phone ;

    /**
     * 盐值
     */
    private String salt;

    private List<Permission> menus;// 菜单

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<Permission> getMenus() {
        return menus;
    }

    public void setMenus(List<Permission> menus) {
        this.menus = menus;
    }
}
