package com.mycompany.myapp.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
public class LoginController
{
    @Autowired
    UserService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }

    @RequestMapping(value = "/login_ok", method = RequestMethod.POST)
    public String loginCheck(HttpSession session, RedirectAttributes redirectAttr, UserVO vo)
    {
        if (session.getAttribute("login") != null)
        {
            session.removeAttribute("login");
        }

        UserVO loginVO = service.getUser(vo);
        String returnURL = "";

        if (loginVO != null)
        { // 로그인 성공
            System.out.println("로그인 성공");
            session.setAttribute("login", loginVO);
            returnURL = "redirect:/";
        }
        else
        { // 로그인 실패
            System.out.println("로그인 실패");
            redirectAttr.addFlashAttribute("msg", "wrong");
            returnURL = "redirect:/login/login";
        }

        return returnURL;
    }

    // 로그아웃하는 부분
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttr)
    {
        session.invalidate();
        redirectAttr.addFlashAttribute("msg", "bye");
        return "redirect:/login/login";
    }
}
