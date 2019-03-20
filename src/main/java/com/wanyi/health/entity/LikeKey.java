package com.wanyi.health.entity;

import java.io.Serializable;

public class LikeKey implements Serializable {

    private Integer userId;

    private String category;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
