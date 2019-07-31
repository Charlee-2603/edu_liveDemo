package com.huntergroup.livedemo.module.system.controller;

import com.huntergroup.livedemo.module.user.model.UserRedis;
import com.huntergroup.livedemo.module.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author ChenLiang
 * @version 1.0.0
 * @description
 * @time 2019/7/30 17:59
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/sys")
public class SystemController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView toLogin(ModelMap model) {
        System.out.println("\033[36;4m" + "toLogin()方法执行了..." + "\033[0m");
        UserRedis user = new UserRedis();
        model.addAttribute("user", user);
        return new ModelAndView("system/login");
    }

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute(value = "user") UserRedis user, ModelMap model, HttpSession session) {
        String url = "liveList";

        // 邮箱正则表达式
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        if (!user.getEmail().matches(regEx1)) {
            model.addAttribute("user", user);
            model.addAttribute("msg", "邮箱格式错误！");
            logger.info("邮箱 = " + user.getEmail());
            url = "system/login";
            return new ModelAndView(url);
        }

        if (userService.isUser(user)) {
            session.setAttribute("user", user);
        } else {
            model.addAttribute("user", user);
            model.addAttribute("msg", "用户密码错误！");
            logger.info("用户名 = " + user.getName());
            url = "system/login";
        }
        return new ModelAndView(url);
    }


    /**
     * 跳转到首页
     *
     * @return
     */
    @RequestMapping(value = "/liveList", method = RequestMethod.GET)
    public ModelAndView liveList() {
        System.out.println("\033[36;4m" + "liveList()方法执行了..." + "\033[0m");
        return new ModelAndView("liveList");
    }

    /**
     * 跳转到登录页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public ModelAndView toRegister(ModelMap model) {
        UserRedis user = new UserRedis();
        model.addAttribute("user", user);
        System.out.println(user);
        return new ModelAndView("system/register");
    }

    /**
     * 注册
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, String> register(@ModelAttribute(value = "user") UserRedis user, HttpSession session) throws IOException {
        System.out.println("\033[36;4m" + "register()方法执行了..." + "\033[0m");
        Map<String, String> data = new HashMap<>(100);
        System.out.println(user);
        if (user.getName().isEmpty()) {
            data.put("type", "error");
            data.put("msg", "用户名不能为空！");
            return data;
        } else if (user.getPassword().isEmpty() || (user.getPassword().length() < 6 && user.getPassword().length() > 20)) {
            data.put("type", "error");
            data.put("msg", "密码必须由大小写英文字母、数字组成，长度6－20位");
            return data;
        } else if (user.getEmail().isEmpty()) {
            data.put("type", "error");
            data.put("msg", "需要填写有效的email地址");
            return data;
        } else if (userService.isUser(user)) {
            data.put("type", "error");
            data.put("msg", "用户名已存在！");
            return data;
        }
        userService.saveUser(user);
        session.setAttribute("user", user);
        data.put("type", "success");
        data.put("msg", "注册成功！");
        return data;
    }

}
