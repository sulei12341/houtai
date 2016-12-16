package code.tianmao.h5.dao;

import code.tianmao.h5.domain.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Junpeng.Su
 * @date 2016/11/21
 */
public interface UserDao extends Mapper<User> {

    User findUserByUsername(String username);

}
