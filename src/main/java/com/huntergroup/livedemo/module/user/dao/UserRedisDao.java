package com.huntergroup.livedemo.module.user.dao;

import com.huntergroup.livedemo.module.user.model.UserRedis;
import org.springframework.stereotype.Repository;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description User的Redis数据操作类
 * @time 2019/7/30 14:56
 */

@Repository
public class UserRedisDao extends IRedisDao<UserRedis> {

    private static final String REDIS_KEY = "com.huntergroup.livedemo.module.user.model.UserRedis";

    @SuppressWarnings("static-access")
    @Override
    protected String getRedisKey() {
        return UserRedisDao.REDIS_KEY;
    }
}
