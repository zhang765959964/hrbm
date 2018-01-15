package com.xunfeng.business.jobfair.dto;

import java.io.Serializable;


/**
 * 对象功能:单位招聘信息表 Form对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-22 17:34:19
 */
public class JobFairBoothBookDto  implements Serializable
{
	// 单位编号
	protected Long  cczy01;
	// 单位编号
	protected Long  aab001;
	
	protected Long acb200;
	// 发布名称
	protected String  bab004;
	// 单位名称
	protected String  aab004;
	// 地址
	protected String  acb204;
	// 联系人
	protected String  aae004;
	// 联系电话
	protected String  aae005; 
	// 联系人手机号码
	protected String  aae139;
	//乘车路线
	protected String acb205;
	//是否扣费 0:不扣费  1：扣费
	protected String isCharg="0";
		
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
	public String getBab004() {
		return bab004;
	}
	public void setBab004(String bab004) {
		this.bab004 = bab004;
	}
	public Long getAab001() {
		return aab001;
	}
	public void setAab001(Long aab001) {
		this.aab001 = aab001;
	}
	public String getAab004() {
		return aab004;
	}
	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}
	public String getAcb204() {
		return acb204;
	}
	public void setAcb204(String acb204) {
		this.acb204 = acb204;
	}
	public String getAae004() {
		return aae004;
	}
	public void setAae004(String aae004) {
		this.aae004 = aae004;
	}
	public String getAae005() {
		return aae005;
	}
	public void setAae005(String aae005) {
		this.aae005 = aae005;
	}
	public String getAae139() {
		return aae139;
	}
	public void setAae139(String aae139) {
		this.aae139 = aae139;
	}
	
	public String getAcb205() {
		return acb205;
	}
	public void setAcb205(String acb205) {
		this.acb205 = acb205;
	}
	public String getIsCharg() {
		return isCharg;
	}
	public void setIsCharg(String isCharg) {
		this.isCharg = isCharg;
	}
	
}