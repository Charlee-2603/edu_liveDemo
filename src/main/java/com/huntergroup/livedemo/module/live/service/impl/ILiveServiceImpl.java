package com.huntergroup.livedemo.module.live.service.impl;

import com.huntergroup.livedemo.module.live.dao.LiveRedisDao;
import com.huntergroup.livedemo.module.live.model.LiveRedis;
import com.huntergroup.livedemo.module.live.service.ILiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description
 * @time 2019/7/31 20:54
 */
@Service
public class ILiveServiceImpl implements ILiveService {

    @Autowired
    private LiveRedisDao liveRedisDao;

    @Override
    public List<LiveRedis> getAll() {
        List<LiveRedis> users = liveRedisDao.getAll();
        return users;
    }

    @Override
    public void save(LiveRedis live) {
        liveRedisDao.put(live.getKeyName(), live, -1);
    }


}
