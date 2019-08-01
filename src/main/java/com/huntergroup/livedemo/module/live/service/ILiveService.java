package com.huntergroup.livedemo.module.live.service;

import com.huntergroup.livedemo.module.live.model.LiveRedis;

import java.util.List;

/**
 * @description 直播service接口
 * @author ChenLiang
 * @data: 2019/7/31 20:59
 * @version 1.0.0
 */
public interface ILiveService {

    /**
     * 获取全部
     * @return
     */
    List<LiveRedis> getAll();

    /**
     * 保存
     * @param liveRedis
     */
    void save(LiveRedis liveRedis);
}
