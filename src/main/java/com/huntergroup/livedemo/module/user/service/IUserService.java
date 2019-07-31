package com.huntergroup.livedemo.module.user.service;

import com.huntergroup.livedemo.module.user.model.UserRedis;
import java.util.List;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 用户service接口类
 * @time 2019/7/30 20:28
 */
public interface IUserService {

    /**
     * 添加用户
     * @param user
     */
    void saveUser(UserRedis user);

    /**
     * 获取所有用户信息
     * @return
     */
    List<UserRedis> getAll();

    /**
     * 用户是否存在
     * @param user
     * @return
     */
    Boolean isUser(UserRedis user);
}
