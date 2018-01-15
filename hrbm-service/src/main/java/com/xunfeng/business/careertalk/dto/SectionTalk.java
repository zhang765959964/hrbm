package com.xunfeng.business.careertalk.dto;

/**
 * Created by Administrator on 2015/10/13.
 */
public class SectionTalk {
    private String startTime;

    private String endTime;

    private int colSpan=1;
    /**
     */
    private String status;

    private Long ctbId;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getCtbId() {
        return ctbId;
    }

    public void setCtbId(Long ctbId) {
        this.ctbId = ctbId;
    }

    public int getColSpan() {
        return colSpan;
    }

    public void setColSpan(int colSpan) {
        this.colSpan = colSpan;
    }
}
