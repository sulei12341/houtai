package code.tianmao.h5.dao;

import code.tianmao.h5.domain.sys.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Junpeng.Su
 * @date 2016/11/21
 */
public interface UserDao extends Mapper<User> {

    /**
     * 根据用户名查询会员
     *
     * @param username 会员名称
     * @return 会员信息
     */
    User findUserByUsername(String username);

}
