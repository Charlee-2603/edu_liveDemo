package com.huntergroup.livedemo.module.user.controller;

import com.huntergroup.livedemo.module.user.dao.UserRedisDao;
import com.huntergroup.livedemo.module.user.model.UserRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description
 * @time 2019/7/30 10:55
 */

@RestController
public class UserController {

    @Autowired
    UserRedisDao userRedisDao;

    @RequestMapping("/userList")
    public ModelAndView list(Model model) {
        // 整合Redis数据到Thymeleaf
        List<UserRedis> users = userRedisDao.getAll();
        model.addAttribute("users", users);
        return new ModelAndView("user/userList");
    }

    @RequestMapping("/")
    public String home() {
        return "hello world";
    }

    @RequestMapping("/hello/{userName}")
    public String index(@PathVariable String userName) {
        return "Hello " + userName + " !!!";
    }

}
