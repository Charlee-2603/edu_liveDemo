package com.huntergroup.livedemo.module.user.model;

import java.io.Serializable;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 用户实体类
 * @time 2019/7/30 14:20
 */
public class UserRedis implements Serializable {

    private static final long serialVersionUID = -2215033125161334161L;

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRedis{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
