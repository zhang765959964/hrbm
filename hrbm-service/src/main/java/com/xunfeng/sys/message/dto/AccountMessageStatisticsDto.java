package com.xunfeng.sys.message.dto;

/**
 * Created by wxl on 2015/7/27.
 *
 */
public class AccountMessageStatisticsDto {
    private Integer totalCount;
    private Integer unreadCount;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
    }
}
