package code.tianmao.h5.service.impl;

import code.tianmao.h5.dao.MemberDao;
import code.tianmao.h5.dao.PermissionDao;
import code.tianmao.h5.domain.business.Member;
import code.tianmao.h5.domain.sys.Permission;
import code.tianmao.h5.dto.MemberDto;
import code.tianmao.h5.service.MemberService;
import code.tianmao.h5.utils.BeanUtilPlus;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Junpeng.Su
 * @date 2016/11/18
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberDao memberDao;

    @Resource
    private PermissionDao permissionDao;

    @Value("${shiro.salt}")
    private String salt;

    @Value("${shiro.hashIterations}")
    private int hashIterations ;

    @Override
    public MemberDto findMemberById(Long id) {
        Member member = memberDao.selectByPrimaryKey(id);
        return BeanUtilPlus.copyAs(member, MemberDto.class);
    }
    
    @Override
    public void addMember(MemberDto memberDto) {
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo();
        Member member = new Member();
        Md5Hash md5Hash = new Md5Hash(memberDto.getPassword(),salt,hashIterations);
        member.setUsercode(memberDto.getUsercode());
        member.setUsername(memberDto.getUsername());
        member.setPassword(md5Hash.toString());
        member.setNickname(memberDto.getNickname());
        member.setPhone(memberDto.getPhone());
        member.setSalt(salt);
        memberDao.insert(member);

    }


    @Override
    public List<Permission> findMenuListByUserId(Long userId) {
        return permissionDao.findMenuListByUserId(userId);
    }
}
