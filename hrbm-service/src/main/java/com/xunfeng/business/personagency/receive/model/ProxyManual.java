package com.xunfeng.business.personagency.receive.model;
import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 代理手册表 Model对象
* @author:jiangxin
* @createDate 2016-09-26 15:04:14 
* @version V1.0   
*/
public class ProxyManual extends BaseModel
{
	// 主键id
	protected Long  pmId;
	// 人员id
	protected Long  personId;
	// 代理人id
	protected Long  agentofId;
	// 代理人姓名
	protected String  agentofName;
	// 代理人身份证号
	protected String  agentofCard;
	// 代理人联系方式
	protected String  agentofPhone;
	// 发证单位
	protected String  lssuingUnit;
	// 发证日期
	protected java.util.Date  lssuingDate;
	// 代理手册类型
	protected Long  proxyType;
	// 代理手册原因
	protected String  proxyReaseon;
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
	// 备注
	protected String  description;
	// 是否删除（0-未删除1.已删除）
	protected Long  proxyDelete;
	// 有效标记（0-无效，1-有效）
	protected String  effectiveMark;
	// 发放人
	protected String  proxyIssuer;
	public void setPmId(Long pmId) 
	{
		this.pmId = pmId;
	}
	/**
	 * 返回 主键id
	 * @return
	 */
	public Long getPmId() 
	{
		return this.pmId;
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
	public void setAgentofId(Long agentofId) 
	{
		this.agentofId = agentofId;
	}
	/**
	 * 返回 代理人id
	 * @return
	 */
	public Long getAgentofId() 
	{
		return this.agentofId;
	}
	public void setAgentofName(String agentofName) 
	{
		this.agentofName = agentofName;
	}
	/**
	 * 返回 代理人姓名
	 * @return
	 */
	public String getAgentofName() 
	{
		return this.agentofName;
	}
	public void setAgentofCard(String agentofCard) 
	{
		this.agentofCard = agentofCard;
	}
	/**
	 * 返回 代理人身份证号
	 * @return
	 */
	public String getAgentofCard() 
	{
		return this.agentofCard;
	}
	public void setAgentofPhone(String agentofPhone) 
	{
		this.agentofPhone = agentofPhone;
	}
	/**
	 * 返回 代理人联系方式
	 * @return
	 */
	public String getAgentofPhone() 
	{
		return this.agentofPhone;
	}
	public void setLssuingUnit(String lssuingUnit) 
	{
		this.lssuingUnit = lssuingUnit;
	}
	/**
	 * 返回 发证单位
	 * @return
	 */
	public String getLssuingUnit() 
	{
		return this.lssuingUnit;
	}
	public void setLssuingDate(java.util.Date lssuingDate) 
	{
		this.lssuingDate = lssuingDate;
	}
	/**
	 * 返回 发证日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getLssuingDate() 
	{
		return this.lssuingDate;
	}
	public void setProxyType(Long proxyType) 
	{
		this.proxyType = proxyType;
	}
	/**
	 * 返回 代理手册类型
	 * @return
	 */
	public Long getProxyType() 
	{
		return this.proxyType;
	}
	public void setProxyReaseon(String proxyReaseon) 
	{
		this.proxyReaseon = proxyReaseon;
	}
	/**
	 * 返回 代理手册原因
	 * @return
	 */
	public String getProxyReaseon() 
	{
		return this.proxyReaseon;
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
	public void setProxyDelete(Long proxyDelete) 
	{
		this.proxyDelete = proxyDelete;
	}
	/**
	 * 返回 是否删除（0-未删除1.已删除）
	 * @return
	 */
	public Long getProxyDelete() 
	{
		return this.proxyDelete;
	}
	public void setEffectiveMark(String effectiveMark) 
	{
		this.effectiveMark = effectiveMark;
	}
	/**
	 * 返回 有效标记（0-无效，1-有效）
	 * @return
	 */
	public String getEffectiveMark() 
	{
		return this.effectiveMark;
	}
	public void setProxyIssuer(String proxyIssuer) 
	{
		this.proxyIssuer = proxyIssuer;
	}
	/**
	 * 返回 发放人
	 * @return
	 */
	public String getProxyIssuer() 
	{
		return this.proxyIssuer;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ProxyManual)) 
		{
			return false;
		}
		ProxyManual rhs = (ProxyManual) object;
		return new EqualsBuilder()
		.append(this.pmId, rhs.pmId)
		.append(this.personId, rhs.personId)
		.append(this.agentofId, rhs.agentofId)
		.append(this.agentofName, rhs.agentofName)
		.append(this.agentofCard, rhs.agentofCard)
		.append(this.agentofPhone, rhs.agentofPhone)
		.append(this.lssuingUnit, rhs.lssuingUnit)
		.append(this.lssuingDate, rhs.lssuingDate)
		.append(this.proxyType, rhs.proxyType)
		.append(this.proxyReaseon, rhs.proxyReaseon)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.description, rhs.description)
		.append(this.proxyDelete, rhs.proxyDelete)
		.append(this.effectiveMark, rhs.effectiveMark)
		.append(this.proxyIssuer, rhs.proxyIssuer)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.pmId) 
		.append(this.personId) 
		.append(this.agentofId) 
		.append(this.agentofName) 
		.append(this.agentofCard) 
		.append(this.agentofPhone) 
		.append(this.lssuingUnit) 
		.append(this.lssuingDate) 
		.append(this.proxyType) 
		.append(this.proxyReaseon) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.createrDate) 
		.append(this.description) 
		.append(this.proxyDelete) 
		.append(this.effectiveMark) 
		.append(this.proxyIssuer) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("pmId", this.pmId) 
		.append("personId", this.personId) 
		.append("agentofId", this.agentofId) 
		.append("agentofName", this.agentofName) 
		.append("agentofCard", this.agentofCard) 
		.append("agentofPhone", this.agentofPhone) 
		.append("lssuingUnit", this.lssuingUnit) 
		.append("lssuingDate", this.lssuingDate) 
		.append("proxyType", this.proxyType) 
		.append("proxyReaseon", this.proxyReaseon) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrDate", this.createrDate) 
		.append("description", this.description) 
		.append("proxyDelete", this.proxyDelete) 
		.append("effectiveMark", this.effectiveMark) 
		.append("proxyIssuer", this.proxyIssuer) 
		.toString();
	}
   
  

}