package com.huntergroup.livedemo.module.live.controller;

import com.huntergroup.livedemo.module.live.model.LiveRedis;
import com.huntergroup.livedemo.module.live.service.ILiveService;
import com.huntergroup.livedemo.module.user.model.UserRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description
 * @time 2019/7/31 20:52
 */
@RestController
@RequestMapping("/api/live")
public class LiveController {

    @Autowired
    private ILiveService liveService;

    /**
     * 直播间
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/live", method = RequestMethod.GET)
    public ModelAndView live(ModelMap model, HttpServletRequest request) {
        System.out.println("\033[36;4m" + "live()方法执行了..." + "\033[0m");
        String keyName = request.getParameter("keyName");
        System.out.println("keyName:" + keyName);
        model.addAttribute("keyName", keyName);
        return new ModelAndView("live");
    }

    /**
     * 跳转到直播页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/publisher", method = RequestMethod.GET)
    public ModelAndView toPublisher(ModelMap model) {
        LiveRedis liveRedis = new LiveRedis();
        model.addAttribute("live", liveRedis);
        return new ModelAndView("publisher");
    }

    /**
     * 发布直播
     *
     * @param liveRedis
     * @param model
     * @return
     */
    @RequestMapping(value = "/publisher", method = RequestMethod.POST)
    public ModelAndView publisher(@ModelAttribute(value = "live") LiveRedis liveRedis, ModelMap model, HttpSession session) {
        System.out.println("\033[36;4m" + "publisher()方法执行了..." + "\033[0m");
        System.out.println(liveRedis);

        liveService.save(liveRedis);
        List<LiveRedis> list = liveService.getAll();

        // 判断session中用户是否还存在 不存在重新登录
        UserRedis user = (UserRedis) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("user", null);
            return new ModelAndView("system/login");
        }
        model.addAttribute("user", user);
        model.addAttribute("liveList", list);
        return new ModelAndView("liveList");
    }

}
