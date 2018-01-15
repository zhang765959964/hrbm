package com.xunfeng.business.careertalk.dto;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;

/**
 * Created by Administrator on 2015/10/13.
 */
public class careerTalkJobfairDto {
	
	
	private Long mergeId;
	//宣讲会||招聘会
    private String mergeName;
    //月份日数
    private String mergeMonth;
    //日数
    private String mergeDay;
    //标题
    private String mergeTitle;
    //内容
    private String mergeContent;
    // 开始时间
    private java.util.Date  mergeStartTime;
 	 // 开始时间
    private java.util.Date  mergeEndTime;
 	//举办场地
 	private  String mergeAddress;
 	//创建时间
 	private java.util.Date  mergeCreateTime;
 	//开始时间
 	private String  startTime;
 	//结束时间
 	private String  endTime;
 	
	public Long getMergeId() {
		return mergeId;
	}
	public void setMergeId(Long mergeId) {
		this.mergeId = mergeId;
	}
	public String getMergeName() {
		return mergeName;
	}
	public void setMergeName(String mergeName) {
		this.mergeName = mergeName;
	}
	public String getMergeMonth() {
		return mergeMonth;
	}
	public void setMergeMonth(String mergeMonth) {
		this.mergeMonth = mergeMonth;
	}
	public String getMergeTitle() {
		return mergeTitle;
	}
	public void setMergeTitle(String mergeTitle) {
		this.mergeTitle = mergeTitle;
	}
	@JsonSerialize(using = JsonDateSerializer.class)
	public java.util.Date getMergeStartTime() {
		return mergeStartTime;
	}
	public void setMergeStartTime(java.util.Date mergeStartTime) {
		this.mergeStartTime = mergeStartTime;
	}
	@JsonSerialize(using = JsonDateSerializer.class)
	public java.util.Date getMergeEndTime() {
		return mergeEndTime;
	}
	public void setMergeEndTime(java.util.Date mergeEndTime) {
		this.mergeEndTime = mergeEndTime;
	}
	public String getMergeAddress() {
		return mergeAddress;
	}
	public void setMergeAddress(String mergeAddress) {
		this.mergeAddress = mergeAddress;
	}
	public String getMergeContent() {
		return mergeContent;
	}
	public void setMergeContent(String mergeContent) {
		this.mergeContent = mergeContent;
	}
	@JsonSerialize(using = JsonDateSerializer.class)
	public java.util.Date getMergeCreateTime() {
		return mergeCreateTime;
	}
	public void setMergeCreateTime(java.util.Date mergeCreateTime) {
		this.mergeCreateTime = mergeCreateTime;
	}
	public String getMergeDay() {
		return mergeDay;
	}
	public void setMergeDay(String mergeDay) {
		this.mergeDay = mergeDay;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
 	
   
}
