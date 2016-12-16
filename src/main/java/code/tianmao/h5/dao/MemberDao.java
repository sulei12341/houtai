package code.tianmao.h5.dao;

import code.tianmao.h5.domain.Member;
import code.tianmao.h5.dto.queryDto.MemberQueryDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Junpeng.Su
 * @date 2016/11/18
 */
public interface MemberDao extends Mapper<Member> {

    Member findMemberById(Long id);

    List<Member> findMemberList(MemberQueryDto memberQueryDto);

    void save(Member member);

    Member findMemberByUsername(String username);

}
