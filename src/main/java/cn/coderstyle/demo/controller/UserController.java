package cn.coderstyle.demo.controller;

import cn.coderstyle.demo.bean.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Date: 2019/1/24 0024 14:51
 * @Auth: championjing
 */
@RestController
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String name, String password,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        User user = new User();
        user.setId(1L);
        user.setName("jing");
        user.setPassword("******");
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        session.setAttribute("sessionId",session.getId() );
        Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
        response.addCookie(cookie);
        model.addAttribute("user", user);
        return "userInfo";
    }

    /**
     * 将所有没有匹配的get请求引流给index
     * @param model
     * @return
     */
    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public String index(Model model){
        return "redirect:/index";
    }
}
