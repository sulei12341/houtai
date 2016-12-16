package code.tianmao.h5.service;

import code.tianmao.h5.domain.Permission;
import code.tianmao.h5.dto.MemberDto;
import code.tianmao.h5.dto.queryDto.MemberQueryDto;

import java.util.List;

/**
 * @author Junpeng.Su
 * @date 2016/11/18
 */
public interface MemberService {

    MemberDto findMemberById(Long id);

    List<MemberDto> findMemberList(MemberQueryDto memberQueryDto);

    void addMember(MemberDto memberDto);

    MemberDto findMemberByUsername(String username);

    /**
     * 根据用户ID查询用户可以访问的菜单
     *
     * @return 菜单列表
     */
    List<Permission> findMenuListByUserId(Long userId);

}
