package com.xunfeng.business.careertalk.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/13.
 */
public class DayTalk {

    private  String date;
    private  Long crId;
    private List<SectionTalk> sectionTalkList=new ArrayList<SectionTalk>();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<SectionTalk> getSectionTalkList() {
        return sectionTalkList;
    }

    public void setSectionTalkList(List<SectionTalk> sectionTalkList) {
        this.sectionTalkList = sectionTalkList;
    }

    public Long getCrId() {
        return crId;
    }

    public void setCrId(Long crId) {
        this.crId = crId;
    }
}
