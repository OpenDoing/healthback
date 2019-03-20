package com.wanyi.health.entity;

import javax.persistence.*;

@Entity
@Table(name = "likev")
@IdClass(LikeKey.class)
public class Likev {
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Id
    private String category;
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

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
