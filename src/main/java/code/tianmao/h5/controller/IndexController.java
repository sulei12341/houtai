package code.tianmao.h5.controller;

import code.tianmao.h5.dto.UserDto;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Junpeng.Su
 * @date 2016/11/24
 */
@Controller
public class IndexController {

    /**
     * 跳转系统首页
     *
     * @param model 模型
     * @return 跳转页面
     */
    @RequestMapping("/first")
    public String first(Model model)throws Exception{

        //从shiro的session中取activeUser
        Subject subject = SecurityUtils.getSubject();
        //取身份信息
        UserDto userDto = (UserDto) subject.getPrincipal();
        //通过model传到页面
        model.addAttribute("activeUser", userDto);

        return "/first";
    }

    //欢迎页面
    @RequestMapping("/welcome")
    public String welcome(Model model)throws Exception{
        return "/welcome";
    }

}
