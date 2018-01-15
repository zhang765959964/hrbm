package com.xunfeng.business.personagency.retired.dto;

import java.io.Serializable;

/**
 * 退休人员登记dto
 * @author Administrator
 *
 */
public class RetiredCardDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 主键
	protected Long  id;
	// 是否领取退休证（0.否1.是）
	protected Long  isRetiredCard;
	// 领取退休证时间
	protected java.util.Date  retiredCardDate;
	// 退休证号
	protected String  retiredCardCode;
	// 退休证领取人
	protected String  retiredCardName;
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
	
	//退休申诉id
	protected Long retiredDeclareId;
	
	//退休申诉状态
	protected String retiredDeclareStatus;
		
	//是否退休
	protected Long retiredStatus; 
	
	
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



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIsRetiredCard() {
		return isRetiredCard;
	}

	public void setIsRetiredCard(Long isRetiredCard) {
		this.isRetiredCard = isRetiredCard;
	}

	public java.util.Date getRetiredCardDate() {
		return retiredCardDate;
	}

	public void setRetiredCardDate(java.util.Date retiredCardDate) {
		this.retiredCardDate = retiredCardDate;
	}

	public String getRetiredCardCode() {
		return retiredCardCode;
	}

	public void setRetiredCardCode(String retiredCardCode) {
		this.retiredCardCode = retiredCardCode;
	}

	public String getRetiredCardName() {
		return retiredCardName;
	}

	public void setRetiredCardName(String retiredCardName) {
		this.retiredCardName = retiredCardName;
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

	public Long getRetiredDeclareId() {
		return retiredDeclareId;
	}

	public void setRetiredDeclareId(Long retiredDeclareId) {
		this.retiredDeclareId = retiredDeclareId;
	}


	
	
	
	
}
