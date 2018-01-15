package com.xunfeng.business.jobfair.dto;

import com.xunfeng.business.jobfair.model.JobFairInfo;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 招聘会信息表 Model对象
* @author:wanghan
* @createDate 2015-09-12 11:02:45 
* @version V1.0   
*/
public class JobFairInfoBoook extends JobFairInfo
{

	private String cczy05;
	private Long acb200;
	private Long cczy01;
	//参会类型
	private String jobFairType;
	
	public String getCczy05() {
		return cczy05;
	}
	public void setCczy05(String cczy05) {
		this.cczy05 = cczy05;
	}
	public Long getAcb200() {
		return acb200;
	}
	public void setAcb200(Long acb200) {
		this.acb200 = acb200;
	}
	public Long getCczy01() {
		return cczy01;
	}
	public void setCczy01(Long cczy01) {
		this.cczy01 = cczy01;
	}
	public String getJobFairType() {
		return jobFairType;
	}
	public void setJobFairType(String jobFairType) {
		this.jobFairType = jobFairType;
	}
	
}