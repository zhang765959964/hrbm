package com.xunfeng.business.personagency.retired.web.form;
import com.xunfeng.business.personagency.retired.model.YangLao;
import com.xunfeng.core.model.BaseForm;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 养老待遇申请 Form对象
* @author:zhangfan
* @createDate 2016-07-25 16:20:07 
* @version V1.0   
*/
public class YangLaoForm extends BaseForm<YangLao>
{
	// 主键
	protected Long  id;
	// 缴费年月
	protected java.util.Date  payDate;
	// 应退休年月
	protected java.util.Date  retiredDate;
	// 申报备注
	protected String  declareNote;
	// 经办人
	protected Long  createrId;
	// 经办机构
	protected String  createrName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 经办机构Id
	protected Long  createrOrgId;
	// 经办机构名称
	protected String  createrOrgName;
	// 申报id
	protected Long  retiredId;
	
	//人员id
	protected Long personId;
	
	//养老信息
	private RetiredYangLaoForm ylForm;
	
	//退休申诉form信息
	private RetiredDeclareForm retiredDeclareForm;
	
	public RetiredYangLaoForm getYlForm() {
		return ylForm;
	}
	public void setYlForm(RetiredYangLaoForm ylForm) {
		this.ylForm = ylForm;
	}
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
	public void setPayDate(java.util.Date payDate) 
	{
		this.payDate = payDate;
	}
	/**
	 * 返回 缴费年月
	 * @return
	 */
	public java.util.Date getPayDate() 
	{
		return this.payDate;
	}
	public void setRetiredDate(java.util.Date retiredDate) 
	{
		this.retiredDate = retiredDate;
	}
	/**
	 * 返回 应退休年月
	 * @return
	 */
	public java.util.Date getRetiredDate() 
	{
		return this.retiredDate;
	}
	public void setDeclareNote(String declareNote) 
	{
		this.declareNote = declareNote;
	}
	/**
	 * 返回 申报备注
	 * @return
	 */
	public String getDeclareNote() 
	{
		return this.declareNote;
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
	 * 返回 经办机构
	 * @return
	 */
	public String getCreaterName() 
	{
		return this.createrName;
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
	public void setRetiredId(Long retiredId) 
	{
		this.retiredId = retiredId;
	}
	/**
	 * 返回 申报id
	 * @return
	 */
	public Long getRetiredId() 
	{
		return this.retiredId;
	}
	
	

   	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public RetiredDeclareForm getRetiredDeclareForm() {
		return retiredDeclareForm;
	}
	public void setRetiredDeclareForm(RetiredDeclareForm retiredDeclareForm) {
		this.retiredDeclareForm = retiredDeclareForm;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof YangLaoForm)) 
		{
			return false;
		}
		YangLaoForm rhs = (YangLaoForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.payDate, rhs.payDate)
		.append(this.retiredDate, rhs.retiredDate)
		.append(this.declareNote, rhs.declareNote)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.retiredId, rhs.retiredId)
		.append(this.personId, rhs.personId)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.payDate) 
		.append(this.retiredDate) 
		.append(this.declareNote) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrDate) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.retiredId) 
		.append(this.personId) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("payDate", this.payDate) 
		.append("retiredDate", this.retiredDate) 
		.append("declareNote", this.declareNote) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("retiredId", this.retiredId) 
		.append("personId", this.personId) 
		.toString();
	}
   
  

}