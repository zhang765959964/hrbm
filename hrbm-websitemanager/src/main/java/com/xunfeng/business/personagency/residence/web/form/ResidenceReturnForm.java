package com.xunfeng.business.personagency.residence.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.residence.model.ResidenceReturn;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 户口借用归还表 Form对象
* @author:jiangxin
* @createDate 2016-08-30 10:37:00 
* @version V1.0   
*/
public class ResidenceReturnForm extends BaseForm<ResidenceReturn>
{
	// 主键id
	protected Long  id;
	// 档案id
	protected Long  archivesId;
	// 人员id
	protected Long  personId;
	// 户口迁入迁移表id
	protected Long  moId;
	// 借用人姓名
	protected String  borrowerName;
	// 借用人身份证号
	protected String  borrowerCard;
	// 借用人联系电话
	protected String  borrowerPhone;
	// 借用日期
	protected java.util.Date  borrowerDate;
	// 到期日期
	protected java.util.Date  maturityDate;
	// 归还日期
	protected java.util.Date  returnDate;
	// 经办人id
	protected Long  createrId;
	// 经办人
	protected String  createrName;
	// 经办机构id
	protected Long  createrOrgId;
	// 经办机构
	protected String  createrOrgName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 归还经办人id
	protected Long  returnCreaterId;
	// 归还经办人
	protected String  returnCreaterName;
	// 归还经办机构id
	protected Long  returnCreaterOrgId;
	// 归还经办机构
	protected String  returnCreaterOrgName;
	// 归还经办日期
	protected java.util.Date  returnCreaterDate;
	// 数据来源（16人事档案）
	protected String  cczy06;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键id
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setArchivesId(Long archivesId) 
	{
		this.archivesId = archivesId;
	}
	/**
	 * 返回 档案id
	 * @return
	 */
	public Long getArchivesId() 
	{
		return this.archivesId;
	}
	public void setPersonId(Long personId) 
	{
		this.personId = personId;
	}
	/**
	 * 返回 人员id
	 * @return
	 */
	public Long getPersonId() 
	{
		return this.personId;
	}
	public void setMoId(Long moId) 
	{
		this.moId = moId;
	}
	/**
	 * 返回 户口迁入迁移表id
	 * @return
	 */
	public Long getMoId() 
	{
		return this.moId;
	}
	public void setBorrowerName(String borrowerName) 
	{
		this.borrowerName = borrowerName;
	}
	/**
	 * 返回 借用人姓名
	 * @return
	 */
	public String getBorrowerName() 
	{
		return this.borrowerName;
	}
	public void setBorrowerCard(String borrowerCard) 
	{
		this.borrowerCard = borrowerCard;
	}
	/**
	 * 返回 借用人身份证号
	 * @return
	 */
	public String getBorrowerCard() 
	{
		return this.borrowerCard;
	}
	public void setBorrowerPhone(String borrowerPhone) 
	{
		this.borrowerPhone = borrowerPhone;
	}
	/**
	 * 返回 借用人联系电话
	 * @return
	 */
	public String getBorrowerPhone() 
	{
		return this.borrowerPhone;
	}
	public void setBorrowerDate(java.util.Date borrowerDate) 
	{
		this.borrowerDate = borrowerDate;
	}
	/**
	 * 返回 借用日期
	 * @return
	 */
	public java.util.Date getBorrowerDate() 
	{
		return this.borrowerDate;
	}
	public void setMaturityDate(java.util.Date maturityDate) 
	{
		this.maturityDate = maturityDate;
	}
	/**
	 * 返回 到期日期
	 * @return
	 */
	public java.util.Date getMaturityDate() 
	{
		return this.maturityDate;
	}
	public void setReturnDate(java.util.Date returnDate) 
	{
		this.returnDate = returnDate;
	}
	/**
	 * 返回 归还日期
	 * @return
	 */
	public java.util.Date getReturnDate() 
	{
		return this.returnDate;
	}
	public void setCreaterId(Long createrId) 
	{
		this.createrId = createrId;
	}
	/**
	 * 返回 经办人id
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
	 * 返回 经办人
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
	 * 返回 经办机构id
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
	 * 返回 经办机构
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
	public java.util.Date getCreaterDate() 
	{
		return this.createrDate;
	}
	public void setReturnCreaterId(Long returnCreaterId) 
	{
		this.returnCreaterId = returnCreaterId;
	}
	/**
	 * 返回 归还经办人id
	 * @return
	 */
	public Long getReturnCreaterId() 
	{
		return this.returnCreaterId;
	}
	public void setReturnCreaterName(String returnCreaterName) 
	{
		this.returnCreaterName = returnCreaterName;
	}
	/**
	 * 返回 归还经办人
	 * @return
	 */
	public String getReturnCreaterName() 
	{
		return this.returnCreaterName;
	}
	public void setReturnCreaterOrgId(Long returnCreaterOrgId) 
	{
		this.returnCreaterOrgId = returnCreaterOrgId;
	}
	/**
	 * 返回 归还经办机构id
	 * @return
	 */
	public Long getReturnCreaterOrgId() 
	{
		return this.returnCreaterOrgId;
	}
	public void setReturnCreaterOrgName(String returnCreaterOrgName) 
	{
		this.returnCreaterOrgName = returnCreaterOrgName;
	}
	/**
	 * 返回 归还经办机构
	 * @return
	 */
	public String getReturnCreaterOrgName() 
	{
		return this.returnCreaterOrgName;
	}
	public void setReturnCreaterDate(java.util.Date returnCreaterDate) 
	{
		this.returnCreaterDate = returnCreaterDate;
	}
	/**
	 * 返回 归还经办日期
	 * @return
	 */
	public java.util.Date getReturnCreaterDate() 
	{
		return this.returnCreaterDate;
	}
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源（16人事档案）
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}
	public void setCcpr08(String ccpr08) 
	{
		this.ccpr08 = ccpr08;
	}
	/**
	 * 返回 是否删除状态（0-否1-是）
	 * @return
	 */
	public String getCcpr08() 
	{
		return this.ccpr08;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ResidenceReturnForm)) 
		{
			return false;
		}
		ResidenceReturnForm rhs = (ResidenceReturnForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.archivesId, rhs.archivesId)
		.append(this.personId, rhs.personId)
		.append(this.moId, rhs.moId)
		.append(this.borrowerName, rhs.borrowerName)
		.append(this.borrowerCard, rhs.borrowerCard)
		.append(this.borrowerPhone, rhs.borrowerPhone)
		.append(this.borrowerDate, rhs.borrowerDate)
		.append(this.maturityDate, rhs.maturityDate)
		.append(this.returnDate, rhs.returnDate)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.returnCreaterId, rhs.returnCreaterId)
		.append(this.returnCreaterName, rhs.returnCreaterName)
		.append(this.returnCreaterOrgId, rhs.returnCreaterOrgId)
		.append(this.returnCreaterOrgName, rhs.returnCreaterOrgName)
		.append(this.returnCreaterDate, rhs.returnCreaterDate)
		.append(this.cczy06, rhs.cczy06)
		.append(this.ccpr08, rhs.ccpr08)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.archivesId) 
		.append(this.personId) 
		.append(this.moId) 
		.append(this.borrowerName) 
		.append(this.borrowerCard) 
		.append(this.borrowerPhone) 
		.append(this.borrowerDate) 
		.append(this.maturityDate) 
		.append(this.returnDate) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.createrDate) 
		.append(this.returnCreaterId) 
		.append(this.returnCreaterName) 
		.append(this.returnCreaterOrgId) 
		.append(this.returnCreaterOrgName) 
		.append(this.returnCreaterDate) 
		.append(this.cczy06) 
		.append(this.ccpr08) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("archivesId", this.archivesId) 
		.append("personId", this.personId) 
		.append("moId", this.moId) 
		.append("borrowerName", this.borrowerName) 
		.append("borrowerCard", this.borrowerCard) 
		.append("borrowerPhone", this.borrowerPhone) 
		.append("borrowerDate", this.borrowerDate) 
		.append("maturityDate", this.maturityDate) 
		.append("returnDate", this.returnDate) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrDate", this.createrDate) 
		.append("returnCreaterId", this.returnCreaterId) 
		.append("returnCreaterName", this.returnCreaterName) 
		.append("returnCreaterOrgId", this.returnCreaterOrgId) 
		.append("returnCreaterOrgName", this.returnCreaterOrgName) 
		.append("returnCreaterDate", this.returnCreaterDate) 
		.append("cczy06", this.cczy06) 
		.append("ccpr08", this.ccpr08) 
		.toString();
	}
   
  

}