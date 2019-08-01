package com.huntergroup.livedemo.module.live.dao;

import com.huntergroup.livedemo.module.live.model.LiveRedis;
import com.huntergroup.livedemo.module.user.dao.IRedisDao;
import org.springframework.stereotype.Repository;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 直播dao接口
 * @time 2019/7/31 20:54
 */
@Repository
public class LiveRedisDao extends IRedisDao<LiveRedis> {

    private static final String REDIS_KEY = "com.huntergroup.livedemo.module.live.model.LiveRedis";

    @SuppressWarnings("static-access")
    @Override
    protected String getRedisKey() {
        return LiveRedisDao.REDIS_KEY;
    }
}
