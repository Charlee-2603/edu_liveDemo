package com.huntergroup.livedemo.module.user.service.impl;

import com.huntergroup.livedemo.module.user.dao.UserRedisDao;
import com.huntergroup.livedemo.module.user.model.UserRedis;
import com.huntergroup.livedemo.module.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 用户service实现类
 * @time 2019/7/30 20:32
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserRedisDao userRedisDao;

    @Override
    public void saveUser(UserRedis user) {
        userRedisDao.put(user.getName(), user, -1);
    }

    @Override
    public List<UserRedis> getAll() {
        List<UserRedis> users = userRedisDao.getAll();
        return users;
    }

    @Override
    public Boolean isUser(UserRedis user) {
        boolean isUser = true;
        UserRedis realUser = userRedisDao.get(user.getName());
        if (realUser == null) {
            isUser = false;
        } else {
            // 验证邮箱和密码是否可以匹配对应用户信息
            if (!realUser.getPassword().equals(user.getPassword()) && !realUser.getEmail().equals(user.getEmail())) {
                isUser = false;
            }
        }
        return isUser;
    }
}
