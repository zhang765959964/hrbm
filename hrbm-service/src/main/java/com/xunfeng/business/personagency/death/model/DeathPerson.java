package com.xunfeng.business.personagency.death.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 供养直系亲属情况 Model对象
* @author:zhangfan
* @createDate 2016-08-30 10:12:09 
* @version V1.0   
*/
public class DeathPerson extends BaseModel
{
	// 主键
	protected Long  id;
	// 死亡外键
	protected Long  deathDeclareId;
	// 姓名
	protected String  deathName;
	// 出生日期
	protected java.util.Date  deathBirthDate;
	// 与死者关系
	protected String  deathRelation;
	// 供养理由
	protected String  deathResaon;
	// 原吃统销粮否（0.否，1是）
	protected Long  isflag;
	// 户口所在省市（县）乡（镇）村
	protected String  address;
	// 抚恤救济终止年月
	protected java.util.Date  deathEndDate;
	//人员id
	protected Long personId;
	
	
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
	public void setDeathDeclareId(Long deathDeclareId) 
	{
		this.deathDeclareId = deathDeclareId;
	}
	/**
	 * 返回 死亡外键
	 * @return
	 */
	public Long getDeathDeclareId() 
	{
		return this.deathDeclareId;
	}
	public void setDeathName(String deathName) 
	{
		this.deathName = deathName;
	}
	/**
	 * 返回 姓名
	 * @return
	 */
	public String getDeathName() 
	{
		return this.deathName;
	}
	public void setDeathBirthDate(java.util.Date deathBirthDate) 
	{
		this.deathBirthDate = deathBirthDate;
	}
	/**
	 * 返回 出生日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getDeathBirthDate() 
	{
		return this.deathBirthDate;
	}
	public void setDeathRelation(String deathRelation) 
	{
		this.deathRelation = deathRelation;
	}
	/**
	 * 返回 与死者关系
	 * @return
	 */
	public String getDeathRelation() 
	{
		return this.deathRelation;
	}
	public void setDeathResaon(String deathResaon) 
	{
		this.deathResaon = deathResaon;
	}
	/**
	 * 返回 供养理由
	 * @return
	 */
	public String getDeathResaon() 
	{
		return this.deathResaon;
	}
	public void setIsflag(Long isflag) 
	{
		this.isflag = isflag;
	}
	/**
	 * 返回 原吃统销粮否（0.否，1是）
	 * @return
	 */
	public Long getIsflag() 
	{
		return this.isflag;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	/**
	 * 返回 户口所在省市（县）乡（镇）村
	 * @return
	 */
	public String getAddress() 
	{
		return this.address;
	}
	public void setDeathEndDate(java.util.Date deathEndDate) 
	{
		this.deathEndDate = deathEndDate;
	}
	/**
	 * 返回 抚恤救济终止年月
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getDeathEndDate() 
	{
		return this.deathEndDate;
	}

	
   	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof DeathPerson)) 
		{
			return false;
		}
		DeathPerson rhs = (DeathPerson) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.deathDeclareId, rhs.deathDeclareId)
		.append(this.deathName, rhs.deathName)
		.append(this.deathBirthDate, rhs.deathBirthDate)
		.append(this.deathRelation, rhs.deathRelation)
		.append(this.deathResaon, rhs.deathResaon)
		.append(this.isflag, rhs.isflag)
		.append(this.address, rhs.address)
		.append(this.deathEndDate, rhs.deathEndDate)
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
		.append(this.deathDeclareId) 
		.append(this.deathName) 
		.append(this.deathBirthDate) 
		.append(this.deathRelation) 
		.append(this.deathResaon) 
		.append(this.isflag) 
		.append(this.address) 
		.append(this.deathEndDate) 
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
		.append("deathDeclareId", this.deathDeclareId) 
		.append("deathName", this.deathName) 
		.append("deathBirthDate", this.deathBirthDate) 
		.append("deathRelation", this.deathRelation) 
		.append("deathResaon", this.deathResaon) 
		.append("isflag", this.isflag) 
		.append("address", this.address) 
		.append("deathEndDate", this.deathEndDate) 
		.append("personId", this.personId) 
		.toString();
	}
   
  

}