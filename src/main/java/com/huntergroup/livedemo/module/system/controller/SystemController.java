package com.huntergroup.livedemo.module.system.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description
 * @time 2019/7/30 17:59
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/bullfighting/system")
public class SystemController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView toLogin(ModelMap model) {
        return new ModelAndView("system/login");
    }

}
