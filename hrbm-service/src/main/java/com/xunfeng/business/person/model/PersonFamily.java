package com.xunfeng.business.person.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员家庭关系表 Model对象
* @author:wanlupeng
* @createDate 2016-07-07 09:13:01 
* @version V1.0   
*/
public class PersonFamily extends BaseModel
{
	// 主键ID
	protected Long  id;
	// 配偶姓名
	protected String  faName;
	// 婚姻状况
	protected String  faMarriage;
	// 结婚时间
	protected java.util.Date  faMarriageDate;
	// 配偶身份证号
	protected String  faSpouseCard;
	// 人员ID
	protected Long  faPersonId;
	// 配偶出生日期
	protected java.util.Date  faSpouseBirth;
	// 配偶民族
	protected String  faSpouseNational;
	// 配偶单位
	protected String  faSpouseCompany;
	// 配偶电话
	protected String  faSpousePhone;
	// 计生情况（TAB_CONDITION）
	protected String  faBirthCondition;
	// 节育措施（TAB_BIRTHCONTROL）
	protected String  faBirthControl;
	// 家庭情况备注
	protected String  faFamilyBark;
	// 数据来源（0-未知1-网站2-窗口3-民营机构4-公办机构5-导入数据,16人事档案）
	protected String  cczy06;
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
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键ID
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setFaName(String faName) 
	{
		this.faName = faName;
	}
	/**
	 * 返回 配偶姓名
	 * @return
	 */
	public String getFaName() 
	{
		return this.faName;
	}
	public void setFaMarriage(String faMarriage) 
	{
		this.faMarriage = faMarriage;
	}
	/**
	 * 返回 婚姻状况
	 * @return
	 */
	public String getFaMarriage() 
	{
		return this.faMarriage;
	}
	public void setFaMarriageDate(java.util.Date faMarriageDate) 
	{
		this.faMarriageDate = faMarriageDate;
	}
	/**
	 * 返回 结婚时间
	 * @return
	 */
	public java.util.Date getFaMarriageDate() 
	{
		return this.faMarriageDate;
	}
	public void setFaSpouseCard(String faSpouseCard) 
	{
		this.faSpouseCard = faSpouseCard;
	}
	/**
	 * 返回 配偶身份证号
	 * @return
	 */
	public String getFaSpouseCard() 
	{
		return this.faSpouseCard;
	}
	public void setFaPersonId(Long faPersonId) 
	{
		this.faPersonId = faPersonId;
	}
	/**
	 * 返回 人员ID
	 * @return
	 */
	public Long getFaPersonId() 
	{
		return this.faPersonId;
	}
	public void setFaSpouseBirth(java.util.Date faSpouseBirth) 
	{
		this.faSpouseBirth = faSpouseBirth;
	}
	/**
	 * 返回 配偶出生日期
	 * @return
	 */
	public java.util.Date getFaSpouseBirth() 
	{
		return this.faSpouseBirth;
	}
	public void setFaSpouseNational(String faSpouseNational) 
	{
		this.faSpouseNational = faSpouseNational;
	}
	/**
	 * 返回 配偶民族
	 * @return
	 */
	public String getFaSpouseNational() 
	{
		return this.faSpouseNational;
	}
	public void setFaSpouseCompany(String faSpouseCompany) 
	{
		this.faSpouseCompany = faSpouseCompany;
	}
	/**
	 * 返回 配偶单位
	 * @return
	 */
	public String getFaSpouseCompany() 
	{
		return this.faSpouseCompany;
	}
	public void setFaSpousePhone(String faSpousePhone) 
	{
		this.faSpousePhone = faSpousePhone;
	}
	/**
	 * 返回 配偶电话
	 * @return
	 */
	public String getFaSpousePhone() 
	{
		return this.faSpousePhone;
	}
	public void setFaBirthCondition(String faBirthCondition) 
	{
		this.faBirthCondition = faBirthCondition;
	}
	/**
	 * 返回 计生情况（TAB_CONDITION）
	 * @return
	 */
	public String getFaBirthCondition() 
	{
		return this.faBirthCondition;
	}
	public void setFaBirthControl(String faBirthControl) 
	{
		this.faBirthControl = faBirthControl;
	}
	/**
	 * 返回 节育措施（TAB_BIRTHCONTROL）
	 * @return
	 */
	public String getFaBirthControl() 
	{
		return this.faBirthControl;
	}
	public void setFaFamilyBark(String faFamilyBark) 
	{
		this.faFamilyBark = faFamilyBark;
	}
	/**
	 * 返回 家庭情况备注
	 * @return
	 */
	public String getFaFamilyBark() 
	{
		return this.faFamilyBark;
	}
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源（0-未知1-网站2-窗口3-民营机构4-公办机构5-导入数据,16人事档案）
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
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
	public java.util.Date getCreaterDate() 
	{
		return this.createrDate;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof PersonFamily)) 
		{
			return false;
		}
		PersonFamily rhs = (PersonFamily) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.faName, rhs.faName)
		.append(this.faMarriage, rhs.faMarriage)
		.append(this.faMarriageDate, rhs.faMarriageDate)
		.append(this.faSpouseCard, rhs.faSpouseCard)
		.append(this.faPersonId, rhs.faPersonId)
		.append(this.faSpouseBirth, rhs.faSpouseBirth)
		.append(this.faSpouseNational, rhs.faSpouseNational)
		.append(this.faSpouseCompany, rhs.faSpouseCompany)
		.append(this.faSpousePhone, rhs.faSpousePhone)
		.append(this.faBirthCondition, rhs.faBirthCondition)
		.append(this.faBirthControl, rhs.faBirthControl)
		.append(this.faFamilyBark, rhs.faFamilyBark)
		.append(this.cczy06, rhs.cczy06)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrDate, rhs.createrDate)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.faName) 
		.append(this.faMarriage) 
		.append(this.faMarriageDate) 
		.append(this.faSpouseCard) 
		.append(this.faPersonId) 
		.append(this.faSpouseBirth) 
		.append(this.faSpouseNational) 
		.append(this.faSpouseCompany) 
		.append(this.faSpousePhone) 
		.append(this.faBirthCondition) 
		.append(this.faBirthControl) 
		.append(this.faFamilyBark) 
		.append(this.cczy06) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.createrDate) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("faName", this.faName) 
		.append("faMarriage", this.faMarriage) 
		.append("faMarriageDate", this.faMarriageDate) 
		.append("faSpouseCard", this.faSpouseCard) 
		.append("faPersonId", this.faPersonId) 
		.append("faSpouseBirth", this.faSpouseBirth) 
		.append("faSpouseNational", this.faSpouseNational) 
		.append("faSpouseCompany", this.faSpouseCompany) 
		.append("faSpousePhone", this.faSpousePhone) 
		.append("faBirthCondition", this.faBirthCondition) 
		.append("faBirthControl", this.faBirthControl) 
		.append("faFamilyBark", this.faFamilyBark) 
		.append("cczy06", this.cczy06) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrDate", this.createrDate) 
		.toString();
	}
   
  

}