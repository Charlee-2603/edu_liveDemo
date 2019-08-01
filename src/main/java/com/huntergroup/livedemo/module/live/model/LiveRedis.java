package com.huntergroup.livedemo.module.live.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 发布直播实体类
 * @time 2019/7/31 20:53
 */
@Component
public class LiveRedis implements Serializable {
    private String liveName;
    private String userName;
    private String keyName;
    private String content;

    public String getLiveName() {
        return liveName;
    }

    public void setLiveName(String liveName) {
        this.liveName = liveName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "LiveRedis{" +
                "liveName='" + liveName + '\'' +
                ", userName='" + userName + '\'' +
                ", keyName='" + keyName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
