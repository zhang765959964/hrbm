package com.xunfeng.business.personagency.subsidy.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 单位补贴申报 Form对象
 * @author:wanghan
 * @createDate 2016-07-14 15:38:33
 * @version V1.0
 */
public class SocialBatchSumDto implements Serializable {

	// 养老保险补贴人数
	protected Long pensionSubsidyNum;
	// 养老金补贴金额
	protected String pensionSubsidyAmount;
	// 医疗保险补贴人数
	protected Long medicalSubsidyNum;
	// 医疗保险费补贴金额
	protected String medicalSubsidyAmount;
	// 批次人数
	protected Long totalSubsidyNum;
	// 合计补贴金额
	protected String totalSubsidyAmount;
	
	protected Long passed;
	protected Long noPassed;
	protected Long noReview;
	public Long getPensionSubsidyNum() {
		return pensionSubsidyNum;
	}
	public void setPensionSubsidyNum(Long pensionSubsidyNum) {
		this.pensionSubsidyNum = pensionSubsidyNum;
	}
	public String getPensionSubsidyAmount() {
		return pensionSubsidyAmount;
	}
	public void setPensionSubsidyAmount(String pensionSubsidyAmount) {
		this.pensionSubsidyAmount = pensionSubsidyAmount;
	}
	public Long getMedicalSubsidyNum() {
		return medicalSubsidyNum;
	}
	public void setMedicalSubsidyNum(Long medicalSubsidyNum) {
		this.medicalSubsidyNum = medicalSubsidyNum;
	}
	public String getMedicalSubsidyAmount() {
		return medicalSubsidyAmount;
	}
	public void setMedicalSubsidyAmount(String medicalSubsidyAmount) {
		this.medicalSubsidyAmount = medicalSubsidyAmount;
	}
	public Long getTotalSubsidyNum() {
		return totalSubsidyNum;
	}
	public void setTotalSubsidyNum(Long totalSubsidyNum) {
		this.totalSubsidyNum = totalSubsidyNum;
	}
	public String getTotalSubsidyAmount() {
		return totalSubsidyAmount;
	}
	public void setTotalSubsidyAmount(String totalSubsidyAmount) {
		this.totalSubsidyAmount = totalSubsidyAmount;
	}
	public Long getPassed() {
		return passed;
	}
	public void setPassed(Long passed) {
		this.passed = passed;
	}
	public Long getNoPassed() {
		return noPassed;
	}
	public void setNoPassed(Long noPassed) {
		this.noPassed = noPassed;
	}
	public Long getNoReview() {
		return noReview;
	}
	public void setNoReview(Long noReview) {
		this.noReview = noReview;
	}
	
}