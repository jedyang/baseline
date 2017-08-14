package org.seckill.web;

import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    @ResponseBody
    public boolean signIn(HttpServletRequest request, HttpServletResponse response) {
        String nameString = request.getParameter("username");
        String password = request.getParameter("password");
        //获取session;
        HttpSession session = request.getSession(true);
        ModelAndView mav;

        String correctPassword = userService.getPassword(nameString);
        if (correctPassword.equals(password)) {
            //把这些东西都加到session中去;
            //在session的数据， 在界面中也可以直接通过${}获取到;
            session.setAttribute("name", nameString);
            session.setAttribute("id", userService.getId(nameString));
            if (1 == userService.getRole(nameString)) {
                session.setAttribute("role", 1);
            } else {
                session.setAttribute("role", 0);
            }
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "signOut", method = RequestMethod.POST)
    @ResponseBody
    public boolean signOut(HttpServletRequest request, HttpServletResponse response) {
        //获取session;
        HttpSession session = request.getSession(true);
        session.removeAttribute("name");
        session.removeAttribute("id");
        session.removeAttribute("role");
        return true;

    }
}
