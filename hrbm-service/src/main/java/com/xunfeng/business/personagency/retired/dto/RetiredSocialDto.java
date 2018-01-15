package com.xunfeng.business.personagency.retired.dto;

import java.io.Serializable;

/**
 * 退休人员转社会化dto
 * @author Administrator
 *
 */
public class RetiredSocialDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	// 主键
	protected Long  id;
	// 转社会化协议编号
	protected String  retiredSocialNo;
	// 转社会化协议日期
	protected java.util.Date  retiredSocialDate;
	// 对方经办人
	protected String  retiredSocialName;
	// 转入单位
	protected String  retiredSocialUnit;
	// 是否转社会化（0否1是）
	protected Long  isRetiredSocial;
	// 退休申诉id
	protected Long  retiredDeclareId;
	// 经办人id
	protected Long  createrId;
	// 经办人名称
	protected String  createrName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 经办机构Id
	protected Long  createrOrgId;
	// 经办机构名称
	protected String  createrOrgName;
	
	//退休申诉状态
	protected String retiredDeclareStatus;
	
	//是否退休
	protected Long retiredStatus;
	


	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRetiredSocialNo() {
		return retiredSocialNo;
	}

	public void setRetiredSocialNo(String retiredSocialNo) {
		this.retiredSocialNo = retiredSocialNo;
	}

	public java.util.Date getRetiredSocialDate() {
		return retiredSocialDate;
	}

	public void setRetiredSocialDate(java.util.Date retiredSocialDate) {
		this.retiredSocialDate = retiredSocialDate;
	}

	public String getRetiredSocialName() {
		return retiredSocialName;
	}

	public void setRetiredSocialName(String retiredSocialName) {
		this.retiredSocialName = retiredSocialName;
	}

	public String getRetiredSocialUnit() {
		return retiredSocialUnit;
	}

	public void setRetiredSocialUnit(String retiredSocialUnit) {
		this.retiredSocialUnit = retiredSocialUnit;
	}

	public Long getIsRetiredSocial() {
		return isRetiredSocial;
	}

	public void setIsRetiredSocial(Long isRetiredSocial) {
		this.isRetiredSocial = isRetiredSocial;
	}

	public Long getRetiredDeclareId() {
		return retiredDeclareId;
	}

	public void setRetiredDeclareId(Long retiredDeclareId) {
		this.retiredDeclareId = retiredDeclareId;
	}

	public Long getCreaterId() {
		return createrId;
	}

	public void setCreaterId(Long createrId) {
		this.createrId = createrId;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public java.util.Date getCreaterDate() {
		return createrDate;
	}

	public void setCreaterDate(java.util.Date createrDate) {
		this.createrDate = createrDate;
	}

	public Long getCreaterOrgId() {
		return createrOrgId;
	}

	public void setCreaterOrgId(Long createrOrgId) {
		this.createrOrgId = createrOrgId;
	}

	public String getCreaterOrgName() {
		return createrOrgName;
	}

	public void setCreaterOrgName(String createrOrgName) {
		this.createrOrgName = createrOrgName;
	}

	public String getRetiredDeclareStatus() {
		return retiredDeclareStatus;
	}

	public void setRetiredDeclareStatus(String retiredDeclareStatus) {
		this.retiredDeclareStatus = retiredDeclareStatus;
	}

	public Long getRetiredStatus() {
		return retiredStatus;
	}

	public void setRetiredStatus(Long retiredStatus) {
		this.retiredStatus = retiredStatus;
	} 
	
	
	
}
