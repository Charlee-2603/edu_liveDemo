package com.huntergroup.livedemo;

import com.huntergroup.livedemo.common.config.RedisConfig;
import com.huntergroup.livedemo.module.user.dao.UserRedisDao;
import com.huntergroup.livedemo.module.user.model.UserRedis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description
 * @time 2019/7/30 14:59
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class, UserRedisDao.class})
public class UserRedisTest {

    @Autowired
    private UserRedisDao userRedisDao;

    @Test
    public void testPut() {
        UserRedis user = new UserRedis();
        user.setName("武则天");
        user.setPassword("123456");
        userRedisDao.put(user.getName(), user, -1);
    }

    @Test
    public void testFindAll() {
        List<UserRedis> users = userRedisDao.getAll();
        for (UserRedis user : users) {
            System.err.println(user.getName() + "- 密码：" + user.getPassword());
        }
    }


}
