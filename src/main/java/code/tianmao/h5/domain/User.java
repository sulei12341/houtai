package code.tianmao.h5.domain;

import javax.persistence.Table;

/**
 * @author Junpeng.Su
 * @date 2016/11/21
 */
@Table(name = "sys_user")
public class User extends BaseDomain<Long, Long>  {

    private static final long serialVersionUID = -5524308939380869754L;

    /**
     * 用户账号
     */
    private String username ;

    /**
     * 用户昵称
     */
    private String nickname;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
}
