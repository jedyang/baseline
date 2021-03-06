package org.seckill.web;

import org.seckill.entity.Result;
import org.seckill.entity.User;
import org.seckill.service.UserService;
import org.seckill.utils.MailTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger("User");

    @Autowired
    UserService userService;

    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
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

    /**
     * 注册时校验参数是否已经注册过
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "doCheckUser", method = RequestMethod.POST)
    @ResponseBody
    public boolean doCheckUser(HttpServletRequest request, HttpServletResponse response) {
        String param = request.getParameter("param");
        String column = request.getParameter("column");
        int result = userService.countRecord(param, column);
        if (result == 0) {
            return true;
        }
        return false;
    }

    /**
     * 用户注册
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "doSignup", method = RequestMethod.POST)
    @ResponseBody
    public boolean doSignup(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Result result = userService.reg(user, email, password, null);
        if (result.isSuccess()) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "doGetBack", method = RequestMethod.POST)
    @ResponseBody
    public Map doGetBack(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> m = new HashMap<String, String>();

        String user = request.getParameter("username");
        String email = request.getParameter("email");

        Result<User> result = userService.getUser(user);
        if (result.isSuccess()) {
            User resultObj = result.getResultObj();
            if (email.equals(resultObj.getMail())) {
                // 发送密码
                try {
                    MailTool.sendMail(email, resultObj.getPassword());
                    m.put("result", "0");
                } catch (Exception e) {
                    logger.error("doGetBack error", e);
                }

            } else {
                m.put("result", "1");
            }

        } else {
            m.put("result", "2");
        }
        return m;
    }

    @RequestMapping(value = "doReset", method = RequestMethod.POST)
    @ResponseBody
    public Map doReset(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> m = new HashMap<String, String>();

        String user = request.getParameter("username");
        String email = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");
        String oldPassword = request.getParameter("oldPassword");

        Result<User> result = userService.getUser(user);
        if (result.isSuccess()) {
            User resultObj = result.getResultObj();
            if (email.equals(resultObj.getMail()) && oldPassword.equals(resultObj.getPassword())) {
                resultObj.setPassword(newPassword);
                userService.updateUser(resultObj);
                m.put("result", "0");
            } else {
                m.put("result", "1");
            }

        } else {
            m.put("result", "2");
        }
        return m;
    }
}
