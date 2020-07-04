package com.natsumes.stefanie.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Achievement {
    private Integer id;

    private Integer userId;

    private Integer parentId;

    private Integer level;

    private BigDecimal profit;

    private BigDecimal achievement;

    private BigDecimal selfAchievement;

    private BigDecimal subAchievement;

    private Date startTime;

    private Date endTime;

    private Date completeTime;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getAchievement() {
        return achievement;
    }

    public void setAchievement(BigDecimal achievement) {
        this.achievement = achievement;
    }

    public BigDecimal getSelfAchievement() {
        return selfAchievement;
    }

    public void setSelfAchievement(BigDecimal selfAchievement) {
        this.selfAchievement = selfAchievement;
    }

    public BigDecimal getSubAchievement() {
        return subAchievement;
    }

    public void setSubAchievement(BigDecimal subAchievement) {
        this.subAchievement = subAchievement;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}