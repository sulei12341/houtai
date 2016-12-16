package code.tianmao.h5.service;

import code.tianmao.h5.domain.sys.Permission;
import code.tianmao.h5.dto.MemberDto;

import java.util.List;

/**
 * @author Junpeng.Su
 * @date 2016/11/18
 */
public interface MemberService {

    MemberDto findMemberById(Long id);

    void addMember(MemberDto memberDto);

    /**
     * 根据用户ID查询用户可以访问的菜单
     *
     * @return 菜单列表
     */
    List<Permission> findMenuListByUserId(Long userId);

}
