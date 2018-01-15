package com.xunfeng.business.personagency.subsidy.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位补贴申报 Model对象
* @author:wanghan
* @createDate 2016-07-16 10:40:59 
* @version V1.0   
*/
public class SocialCorpDeclare extends BaseModel
{
	// 主键
	protected Long  id;
	// 养老保险补贴人数
	protected Long  pensionSubsidyNum;
	// 养老金补贴金额
	protected String  pensionSubsidyAmount;
	// 医疗保险补贴人数
	protected Long  medicalSubsidyNum;
	// 医疗保险费补贴金额
	protected String  medicalSubsidyAmount;
	// 批次人数
	protected Long  totalSubsidyNum;
	// 合计补贴金额
	protected String  totalSubsidyAmount;
	// 审批情况
	protected String  approvalDesc;
	// 备注
	protected String  description;
	// 经办人
	protected Long  createrId;
	// 经办人名称
	protected String  createrName;
	// 经办机构Id
	protected Long  createrOrgId;
	// 经办机构名称
	protected String  createrOrgName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 批次Id
	protected Long  batchId;
	// 单位Id
	protected Long  corpid;
	// 开户银行
	protected String  bankName;
	// 银行卡号
	protected String  bankCardNo;
	// 银行账户名
	protected String  bankOwnerName;
	// 填报日期
	protected java.util.Date  fillDate;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setPensionSubsidyNum(Long pensionSubsidyNum) 
	{
		this.pensionSubsidyNum = pensionSubsidyNum;
	}
	/**
	 * 返回 养老保险补贴人数
	 * @return
	 */
	public Long getPensionSubsidyNum() 
	{
		return this.pensionSubsidyNum;
	}
	public void setPensionSubsidyAmount(String pensionSubsidyAmount) 
	{
		this.pensionSubsidyAmount = pensionSubsidyAmount;
	}
	/**
	 * 返回 养老金补贴金额
	 * @return
	 */
	public String getPensionSubsidyAmount() 
	{
		return this.pensionSubsidyAmount;
	}
	public void setMedicalSubsidyNum(Long medicalSubsidyNum) 
	{
		this.medicalSubsidyNum = medicalSubsidyNum;
	}
	/**
	 * 返回 医疗保险补贴人数
	 * @return
	 */
	public Long getMedicalSubsidyNum() 
	{
		return this.medicalSubsidyNum;
	}
	public void setMedicalSubsidyAmount(String medicalSubsidyAmount) 
	{
		this.medicalSubsidyAmount = medicalSubsidyAmount;
	}
	/**
	 * 返回 医疗保险费补贴金额
	 * @return
	 */
	public String getMedicalSubsidyAmount() 
	{
		return this.medicalSubsidyAmount;
	}
	public void setTotalSubsidyNum(Long totalSubsidyNum) 
	{
		this.totalSubsidyNum = totalSubsidyNum;
	}
	/**
	 * 返回 批次人数
	 * @return
	 */
	public Long getTotalSubsidyNum() 
	{
		return this.totalSubsidyNum;
	}
	public void setTotalSubsidyAmount(String totalSubsidyAmount) 
	{
		this.totalSubsidyAmount = totalSubsidyAmount;
	}
	/**
	 * 返回 合计补贴金额
	 * @return
	 */
	public String getTotalSubsidyAmount() 
	{
		return this.totalSubsidyAmount;
	}
	public void setApprovalDesc(String approvalDesc) 
	{
		this.approvalDesc = approvalDesc;
	}
	/**
	 * 返回 审批情况
	 * @return
	 */
	public String getApprovalDesc() 
	{
		return this.approvalDesc;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getDescription() 
	{
		return this.description;
	}
	public void setCreaterId(Long createrId) 
	{
		this.createrId = createrId;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public Long getCreaterId() 
	{
		return this.createrId;
	}
	public void setCreaterName(String createrName) 
	{
		this.createrName = createrName;
	}
	/**
	 * 返回 经办人名称
	 * @return
	 */
	public String getCreaterName() 
	{
		return this.createrName;
	}
	public void setCreaterOrgId(Long createrOrgId) 
	{
		this.createrOrgId = createrOrgId;
	}
	/**
	 * 返回 经办机构Id
	 * @return
	 */
	public Long getCreaterOrgId() 
	{
		return this.createrOrgId;
	}
	public void setCreaterOrgName(String createrOrgName) 
	{
		this.createrOrgName = createrOrgName;
	}
	/**
	 * 返回 经办机构名称
	 * @return
	 */
	public String getCreaterOrgName() 
	{
		return this.createrOrgName;
	}
	public void setCreaterDate(java.util.Date createrDate) 
	{
		this.createrDate = createrDate;
	}
	/**
	 * 返回 经办日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getCreaterDate() 
	{
		return this.createrDate;
	}
	public void setBatchId(Long batchId) 
	{
		this.batchId = batchId;
	}
	/**
	 * 返回 批次Id
	 * @return
	 */
	public Long getBatchId() 
	{
		return this.batchId;
	}
	public void setCorpid(Long corpid) 
	{
		this.corpid = corpid;
	}
	/**
	 * 返回 单位Id
	 * @return
	 */
	public Long getCorpid() 
	{
		return this.corpid;
	}
	public void setBankName(String bankName) 
	{
		this.bankName = bankName;
	}
	/**
	 * 返回 开户银行
	 * @return
	 */
	public String getBankName() 
	{
		return this.bankName;
	}
	public void setBankCardNo(String bankCardNo) 
	{
		this.bankCardNo = bankCardNo;
	}
	/**
	 * 返回 银行卡号
	 * @return
	 */
	public String getBankCardNo() 
	{
		return this.bankCardNo;
	}
	public void setBankOwnerName(String bankOwnerName) 
	{
		this.bankOwnerName = bankOwnerName;
	}
	/**
	 * 返回 银行账户名
	 * @return
	 */
	public String getBankOwnerName() 
	{
		return this.bankOwnerName;
	}
	public void setFillDate(java.util.Date fillDate) 
	{
		this.fillDate = fillDate;
	}
	/**
	 * 返回 填报日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getFillDate() 
	{
		return this.fillDate;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SocialCorpDeclare)) 
		{
			return false;
		}
		SocialCorpDeclare rhs = (SocialCorpDeclare) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.pensionSubsidyNum, rhs.pensionSubsidyNum)
		.append(this.pensionSubsidyAmount, rhs.pensionSubsidyAmount)
		.append(this.medicalSubsidyNum, rhs.medicalSubsidyNum)
		.append(this.medicalSubsidyAmount, rhs.medicalSubsidyAmount)
		.append(this.totalSubsidyNum, rhs.totalSubsidyNum)
		.append(this.totalSubsidyAmount, rhs.totalSubsidyAmount)
		.append(this.approvalDesc, rhs.approvalDesc)
		.append(this.description, rhs.description)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.batchId, rhs.batchId)
		.append(this.corpid, rhs.corpid)
		.append(this.bankName, rhs.bankName)
		.append(this.bankCardNo, rhs.bankCardNo)
		.append(this.bankOwnerName, rhs.bankOwnerName)
		.append(this.fillDate, rhs.fillDate)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.pensionSubsidyNum) 
		.append(this.pensionSubsidyAmount) 
		.append(this.medicalSubsidyNum) 
		.append(this.medicalSubsidyAmount) 
		.append(this.totalSubsidyNum) 
		.append(this.totalSubsidyAmount) 
		.append(this.approvalDesc) 
		.append(this.description) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.createrDate) 
		.append(this.batchId) 
		.append(this.corpid) 
		.append(this.bankName) 
		.append(this.bankCardNo) 
		.append(this.bankOwnerName) 
		.append(this.fillDate) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("pensionSubsidyNum", this.pensionSubsidyNum) 
		.append("pensionSubsidyAmount", this.pensionSubsidyAmount) 
		.append("medicalSubsidyNum", this.medicalSubsidyNum) 
		.append("medicalSubsidyAmount", this.medicalSubsidyAmount) 
		.append("totalSubsidyNum", this.totalSubsidyNum) 
		.append("totalSubsidyAmount", this.totalSubsidyAmount) 
		.append("approvalDesc", this.approvalDesc) 
		.append("description", this.description) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrDate", this.createrDate) 
		.append("batchId", this.batchId) 
		.append("corpid", this.corpid) 
		.append("bankName", this.bankName) 
		.append("bankCardNo", this.bankCardNo) 
		.append("bankOwnerName", this.bankOwnerName) 
		.append("fillDate", this.fillDate) 
		.toString();
	}
   
  

}