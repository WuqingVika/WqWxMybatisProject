package com.wq.entity;

import java.util.Date;

/**
 * Created by wuqingvika on 2018/3/5.
 */
public class Area {
    /**
    * 主键ID
    **/
    private int areaId;
    /**
    * 区域名称
    **/
    private String areaName;
    /**
    * 优先级
    **/
    private int priority;
    /**
    * 创建时间
    **/
    private Date createDate;

    /*
    * 更新时间
    **/
    private Date lastEditTime;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
