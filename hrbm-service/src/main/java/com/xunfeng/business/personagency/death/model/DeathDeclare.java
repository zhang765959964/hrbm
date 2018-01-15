package com.xunfeng.business.personagency.death.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 死亡待遇申报 Model对象
* @author:zhangfan
* @createDate 2016-08-26 16:25:11 
* @version V1.0   
*/
public class DeathDeclare extends BaseModel
{
	// 主键
	protected Long  id;
	// 人员id
	protected Long  personId;
	// 个人编号
	protected String  deathNo;
	// 离退休或退职(字典表rsda_tab_tx_tz  )
	protected Long  txTzId;
	// 已统筹月离退休费
	protected Float  retiredMonthMoney;
	// 死亡日期
	protected java.util.Date  deathDate;
	// 工伤死或病死(字典表rsda_tab_gs_bs)
	protected Long  gsBsId;
	// 火葬或土葬(字典表RSDA_tab_hz_tz)
	protected Long  hzTzId;
	// 亲属
	protected String  relatives;
	// 亲属联系电话1
	protected String  relativesPhoneOne;
	// 亲属联系电话2
	protected String  relativesPhoneTwo;
	// 本企业月平均工资
	protected Float  monthAgeMoney;
	// 备注
	protected String  deathNote;
	// 月抚恤救金额
	protected Float  monthFjMoney;
	// 月付粮价补金额
	protected Float  monthFlMoney;
	// 以上两项月费用合计
	protected Float  monthSumMoney;
	// 一次性抚恤救济金额
	protected Float  oneMoney;
	// 丧葬补助金额
	protected Float  sfMoney;
	// 以上两项一次性费用合计
	protected Float  oneSumMoney;
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
	public void setDeathNo(String deathNo) 
	{
		this.deathNo = deathNo;
	}
	/**
	 * 返回 个人编号
	 * @return
	 */
	public String getDeathNo() 
	{
		return this.deathNo;
	}
	public void setTxTzId(Long txTzId) 
	{
		this.txTzId = txTzId;
	}
	/**
	 * 返回 离退休或退职(字典表rsda_tab_tx_tz  )
	 * @return
	 */
	public Long getTxTzId() 
	{
		return this.txTzId;
	}
	public void setRetiredMonthMoney(Float retiredMonthMoney) 
	{
		this.retiredMonthMoney = retiredMonthMoney;
	}
	/**
	 * 返回 已统筹月离退休费
	 * @return
	 */
	public Float getRetiredMonthMoney() 
	{
		return this.retiredMonthMoney;
	}
	public void setDeathDate(java.util.Date deathDate) 
	{
		this.deathDate = deathDate;
	}
	/**
	 * 返回 死亡日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getDeathDate() 
	{
		return this.deathDate;
	}
	public void setGsBsId(Long gsBsId) 
	{
		this.gsBsId = gsBsId;
	}
	/**
	 * 返回 工伤死或病死(字典表rsda_tab_gs_bs)
	 * @return
	 */
	public Long getGsBsId() 
	{
		return this.gsBsId;
	}
	public void setHzTzId(Long hzTzId) 
	{
		this.hzTzId = hzTzId;
	}
	/**
	 * 返回 火葬或土葬(字典表RSDA_tab_hz_tz)
	 * @return
	 */
	public Long getHzTzId() 
	{
		return this.hzTzId;
	}
	public void setRelatives(String relatives) 
	{
		this.relatives = relatives;
	}
	/**
	 * 返回 亲属
	 * @return
	 */
	public String getRelatives() 
	{
		return this.relatives;
	}
	public void setRelativesPhoneOne(String relativesPhoneOne) 
	{
		this.relativesPhoneOne = relativesPhoneOne;
	}
	/**
	 * 返回 亲属联系电话1
	 * @return
	 */
	public String getRelativesPhoneOne() 
	{
		return this.relativesPhoneOne;
	}
	public void setRelativesPhoneTwo(String relativesPhoneTwo) 
	{
		this.relativesPhoneTwo = relativesPhoneTwo;
	}
	/**
	 * 返回 亲属联系电话2
	 * @return
	 */
	public String getRelativesPhoneTwo() 
	{
		return this.relativesPhoneTwo;
	}
	public void setMonthAgeMoney(Float monthAgeMoney) 
	{
		this.monthAgeMoney = monthAgeMoney;
	}
	/**
	 * 返回 本企业月平均工资
	 * @return
	 */
	public Float getMonthAgeMoney() 
	{
		return this.monthAgeMoney;
	}
	public void setDeathNote(String deathNote) 
	{
		this.deathNote = deathNote;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getDeathNote() 
	{
		return this.deathNote;
	}
	public void setMonthFjMoney(Float monthFjMoney) 
	{
		this.monthFjMoney = monthFjMoney;
	}
	/**
	 * 返回 月抚恤救金额
	 * @return
	 */
	public Float getMonthFjMoney() 
	{
		return this.monthFjMoney;
	}
	public void setMonthFlMoney(Float monthFlMoney) 
	{
		this.monthFlMoney = monthFlMoney;
	}
	/**
	 * 返回 月付粮价补金额
	 * @return
	 */
	public Float getMonthFlMoney() 
	{
		return this.monthFlMoney;
	}
	public void setMonthSumMoney(Float monthSumMoney) 
	{
		this.monthSumMoney = monthSumMoney;
	}
	/**
	 * 返回 以上两项月费用合计
	 * @return
	 */
	public Float getMonthSumMoney() 
	{
		return this.monthSumMoney;
	}
	public void setOneMoney(Float oneMoney) 
	{
		this.oneMoney = oneMoney;
	}
	/**
	 * 返回 一次性抚恤救济金额
	 * @return
	 */
	public Float getOneMoney() 
	{
		return this.oneMoney;
	}
	public void setSfMoney(Float sfMoney) 
	{
		this.sfMoney = sfMoney;
	}
	/**
	 * 返回 丧葬补助金额
	 * @return
	 */
	public Float getSfMoney() 
	{
		return this.sfMoney;
	}
	public void setOneSumMoney(Float oneSumMoney) 
	{
		this.oneSumMoney = oneSumMoney;
	}
	/**
	 * 返回 以上两项一次性费用合计
	 * @return
	 */
	public Float getOneSumMoney() 
	{
		return this.oneSumMoney;
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
	 * 返回 经办人名称
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
	@JsonSerialize(using=JsonDateSerializer.class) 
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

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof DeathDeclare)) 
		{
			return false;
		}
		DeathDeclare rhs = (DeathDeclare) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.personId, rhs.personId)
		.append(this.deathNo, rhs.deathNo)
		.append(this.txTzId, rhs.txTzId)
		.append(this.retiredMonthMoney, rhs.retiredMonthMoney)
		.append(this.deathDate, rhs.deathDate)
		.append(this.gsBsId, rhs.gsBsId)
		.append(this.hzTzId, rhs.hzTzId)
		.append(this.relatives, rhs.relatives)
		.append(this.relativesPhoneOne, rhs.relativesPhoneOne)
		.append(this.relativesPhoneTwo, rhs.relativesPhoneTwo)
		.append(this.monthAgeMoney, rhs.monthAgeMoney)
		.append(this.deathNote, rhs.deathNote)
		.append(this.monthFjMoney, rhs.monthFjMoney)
		.append(this.monthFlMoney, rhs.monthFlMoney)
		.append(this.monthSumMoney, rhs.monthSumMoney)
		.append(this.oneMoney, rhs.oneMoney)
		.append(this.sfMoney, rhs.sfMoney)
		.append(this.oneSumMoney, rhs.oneSumMoney)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.personId) 
		.append(this.deathNo) 
		.append(this.txTzId) 
		.append(this.retiredMonthMoney) 
		.append(this.deathDate) 
		.append(this.gsBsId) 
		.append(this.hzTzId) 
		.append(this.relatives) 
		.append(this.relativesPhoneOne) 
		.append(this.relativesPhoneTwo) 
		.append(this.monthAgeMoney) 
		.append(this.deathNote) 
		.append(this.monthFjMoney) 
		.append(this.monthFlMoney) 
		.append(this.monthSumMoney) 
		.append(this.oneMoney) 
		.append(this.sfMoney) 
		.append(this.oneSumMoney) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrDate) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("personId", this.personId) 
		.append("deathNo", this.deathNo) 
		.append("txTzId", this.txTzId) 
		.append("retiredMonthMoney", this.retiredMonthMoney) 
		.append("deathDate", this.deathDate) 
		.append("gsBsId", this.gsBsId) 
		.append("hzTzId", this.hzTzId) 
		.append("relatives", this.relatives) 
		.append("relativesPhoneOne", this.relativesPhoneOne) 
		.append("relativesPhoneTwo", this.relativesPhoneTwo) 
		.append("monthAgeMoney", this.monthAgeMoney) 
		.append("deathNote", this.deathNote) 
		.append("monthFjMoney", this.monthFjMoney) 
		.append("monthFlMoney", this.monthFlMoney) 
		.append("monthSumMoney", this.monthSumMoney) 
		.append("oneMoney", this.oneMoney) 
		.append("sfMoney", this.sfMoney) 
		.append("oneSumMoney", this.oneSumMoney) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.toString();
	}
   
  

}