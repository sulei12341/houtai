package code.tianmao.h5.controller.member;

import code.tianmao.h5.dto.MemberDto;
import code.tianmao.h5.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Junpeng.Su
 * @date 2016/11/17
 */
@Controller
public class MemberController {

    @Resource
    private MemberService memberService ;

    /**
     * 跳转个人中心
     *
     * @param model 数据模型
     * @return 跳转页面
     */
    @RequestMapping("/memberCenter")
    public String memberCenter(Model model)throws Exception{
        return "member/memberCenter";
    }

    @RequestMapping("/findMemberById")
    @ResponseBody
    public MemberDto findMemberById(Long id)throws Exception{
        return memberService.findMemberById(id);
    }

    @RequestMapping("/pmall/addMember")
    @ResponseBody
    public void addMember(MemberDto memberDto)throws Exception{
        memberService.addMember(memberDto);
    }
}
