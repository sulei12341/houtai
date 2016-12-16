package code.tianmao.h5.dao;

import code.tianmao.h5.domain.business.Member;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Junpeng.Su
 * @date 2016/11/18
 */
public interface MemberDao extends Mapper<Member> {
    /**
     * 根据会员账号查询会员
     *
     * @param username 会员账号
     * @return 会员
     */
    Member findMemberByUsername(String username);

}
