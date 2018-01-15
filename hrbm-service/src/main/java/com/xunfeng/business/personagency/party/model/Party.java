package com.xunfeng.business.personagency.party.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 党组织关系表 Model对象
* @author:zhangfan
* @createDate 2016-08-17 11:32:11 
* @version V1.0   
*/
public class Party extends BaseModel
{
	// 主键
	protected Long  id;
	// 人员id
	protected Long  partyPersonId;
	// 转入时间
	protected java.util.Date  partyIntoDate;
	// 转出时间
	protected java.util.Date  partyOutDate;
	// 转出原因
	protected String  partyOutReason;
	// 转出去向
	protected String  partyOutWhere;
	// 代党组织关系状态 0 否 1.是
	protected Long  partyStatus;
	// 入党时间
	protected java.util.Date  partyDate;
	// 备注
	protected String  partyNote;
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
	// 曾用名
	protected String  partyOldName;
	// 专业
	protected String  partyZhuanye;
	// 毕业院校
	protected String  partySchoolName;
	// 毕业时间
	protected java.util.Date  partySchoolDate;
	// 手机
	protected String  partyPhone;
	// qq
	protected String  partyQq;
	// 其它联系方式
	protected String  partyOtherAdd;
	// 转正时间
	protected java.util.Date  partyPositiveDate;
	//提醒状态
	protected Long isParty;
	//是否缴费
	protected Long isPay;	
	
	//交纳截止年月
	protected java.util.Date lastPartyDate;
	
	//交纳开始年月
	protected java.util.Date firstPartyDate;
	
	
	//缴费金额
	protected Float partyMoney;	
	
	//终止人id
	protected Long outCreaterId;
	
	//终止经办人
	protected String outCreaterName;
	
	//终止经办时间
	protected java.util.Date outCreaterDate;
	
	//终止经办机构
	protected Long outCreaterOrgId;
	
	//终止经办机构名称
	protected String outCreaterOrgName;
	

	
	
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
	public void setPartyPersonId(Long partyPersonId) 
	{
		this.partyPersonId = partyPersonId;
	}
	/**
	 * 返回 人员id
	 * @return
	 */
	public Long getPartyPersonId() 
	{
		return this.partyPersonId;
	}
	public void setPartyIntoDate(java.util.Date partyIntoDate) 
	{
		this.partyIntoDate = partyIntoDate;
	}
	/**
	 * 返回 转入时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getPartyIntoDate() 
	{
		return this.partyIntoDate;
	}
	public void setPartyOutDate(java.util.Date partyOutDate) 
	{
		this.partyOutDate = partyOutDate;
	}
	/**
	 * 返回 转出时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getPartyOutDate() 
	{
		return this.partyOutDate;
	}
	public void setPartyOutReason(String partyOutReason) 
	{
		this.partyOutReason = partyOutReason;
	}
	/**
	 * 返回 转出原因
	 * @return
	 */
	public String getPartyOutReason() 
	{
		return this.partyOutReason;
	}
	public void setPartyOutWhere(String partyOutWhere) 
	{
		this.partyOutWhere = partyOutWhere;
	}
	/**
	 * 返回 转出去向
	 * @return
	 */
	public String getPartyOutWhere() 
	{
		return this.partyOutWhere;
	}
	public void setPartyStatus(Long partyStatus) 
	{
		this.partyStatus = partyStatus;
	}
	/**
	 * 返回 代党组织关系状态 0 否 1.是
	 * @return
	 */
	public Long getPartyStatus() 
	{
		return this.partyStatus;
	}
	public void setPartyDate(java.util.Date partyDate) 
	{
		this.partyDate = partyDate;
	}
	/**
	 * 返回 入党时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getPartyDate() 
	{
		return this.partyDate;
	}
	
	
	public String getPartyNote() {
		return partyNote;
	}
	public void setPartyNote(String partyNote) {
		this.partyNote = partyNote;
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
	public void setPartyOldName(String partyOldName) 
	{
		this.partyOldName = partyOldName;
	}
	/**
	 * 返回 曾用名
	 * @return
	 */
	public String getPartyOldName() 
	{
		return this.partyOldName;
	}
	public void setPartyZhuanye(String partyZhuanye) 
	{
		this.partyZhuanye = partyZhuanye;
	}
	/**
	 * 返回 专业
	 * @return
	 */
	public String getPartyZhuanye() 
	{
		return this.partyZhuanye;
	}
	public void setPartySchoolName(String partySchoolName) 
	{
		this.partySchoolName = partySchoolName;
	}
	/**
	 * 返回 毕业院校
	 * @return
	 */
	public String getPartySchoolName() 
	{
		return this.partySchoolName;
	}
	public void setPartySchoolDate(java.util.Date partySchoolDate) 
	{
		this.partySchoolDate = partySchoolDate;
	}
	/**
	 * 返回 毕业时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getPartySchoolDate() 
	{
		return this.partySchoolDate;
	}
	public void setPartyPhone(String partyPhone) 
	{
		this.partyPhone = partyPhone;
	}
	/**
	 * 返回 手机
	 * @return
	 */
	public String getPartyPhone() 
	{
		return this.partyPhone;
	}
	public void setPartyQq(String partyQq) 
	{
		this.partyQq = partyQq;
	}
	/**
	 * 返回 qq
	 * @return
	 */
	public String getPartyQq() 
	{
		return this.partyQq;
	}
	public void setPartyOtherAdd(String partyOtherAdd) 
	{
		this.partyOtherAdd = partyOtherAdd;
	}
	/**
	 * 返回 其它联系方式
	 * @return
	 */
	public String getPartyOtherAdd() 
	{
		return this.partyOtherAdd;
	}
	public void setPartyPositiveDate(java.util.Date partyPositiveDate) 
	{
		this.partyPositiveDate = partyPositiveDate;
	}
	/**
	 * 返回 转正时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getPartyPositiveDate() 
	{
		return this.partyPositiveDate;
	}
	
	
	

   	public Long getIsPay() {
		return isPay;
	}
	public void setIsPay(Long isPay) {
		this.isPay = isPay;
	}
	
	
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getLastPartyDate() {
		return lastPartyDate;
	}
	public void setLastPartyDate(java.util.Date lastPartyDate) {
		this.lastPartyDate = lastPartyDate;
	}
	
	
	
	public Long getOutCreaterId() {
		return outCreaterId;
	}
	public void setOutCreaterId(Long outCreaterId) {
		this.outCreaterId = outCreaterId;
	}
	public String getOutCreaterName() {
		return outCreaterName;
	}
	public void setOutCreaterName(String outCreaterName) {
		this.outCreaterName = outCreaterName;
	}
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getOutCreaterDate() {
		return outCreaterDate;
	}
	public void setOutCreaterDate(java.util.Date outCreaterDate) {
		this.outCreaterDate = outCreaterDate;
	}
	public Long getOutCreaterOrgId() {
		return outCreaterOrgId;
	}
	public void setOutCreaterOrgId(Long outCreaterOrgId) {
		this.outCreaterOrgId = outCreaterOrgId;
	}
	public String getOutCreaterOrgName() {
		return outCreaterOrgName;
	}
	public void setOutCreaterOrgName(String outCreaterOrgName) {
		this.outCreaterOrgName = outCreaterOrgName;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof Party)) 
		{
			return false;
		}
		Party rhs = (Party) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.partyPersonId, rhs.partyPersonId)
		.append(this.partyIntoDate, rhs.partyIntoDate)
		.append(this.partyOutDate, rhs.partyOutDate)
		.append(this.partyOutReason, rhs.partyOutReason)
		.append(this.partyOutWhere, rhs.partyOutWhere)
		.append(this.partyStatus, rhs.partyStatus)
		.append(this.partyDate, rhs.partyDate)
		.append(this.partyNote, rhs.partyNote)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.partyOldName, rhs.partyOldName)
		.append(this.partyZhuanye, rhs.partyZhuanye)
		.append(this.partySchoolName, rhs.partySchoolName)
		.append(this.partySchoolDate, rhs.partySchoolDate)
		.append(this.partyPhone, rhs.partyPhone)
		.append(this.partyQq, rhs.partyQq)
		.append(this.partyOtherAdd, rhs.partyOtherAdd)
		.append(this.partyPositiveDate, rhs.partyPositiveDate)
		.append(this.isParty,rhs.isParty)
		.append(this.isPay,rhs.isPay)
		.append(this.lastPartyDate ,rhs.lastPartyDate)
		.append(this.firstPartyDate ,rhs.firstPartyDate)
		.append(this.partyMoney ,rhs.partyMoney)
		.append(this.outCreaterId ,rhs.outCreaterId)
		.append(this.outCreaterName ,rhs.outCreaterName)
		.append(this.outCreaterDate ,rhs.outCreaterDate)
		.append(this.outCreaterOrgId ,rhs.outCreaterOrgId)
		.append(this.outCreaterOrgName ,rhs.outCreaterOrgName)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.partyPersonId) 
		.append(this.partyIntoDate) 
		.append(this.partyOutDate) 
		.append(this.partyOutReason) 
		.append(this.partyOutWhere) 
		.append(this.partyStatus) 
		.append(this.partyDate) 
		.append(this.partyNote) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrDate) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.partyOldName) 
		.append(this.partyZhuanye) 
		.append(this.partySchoolName) 
		.append(this.partySchoolDate) 
		.append(this.partyPhone) 
		.append(this.partyQq) 
		.append(this.partyOtherAdd) 
		.append(this.partyPositiveDate) 
		.append(this.isParty)
		.append(this.isPay)
		.append(this.lastPartyDate)
		.append(this.firstPartyDate)
		.append(this.partyMoney)
		.append(this.outCreaterId)
		.append(this.outCreaterName)
		.append(this.outCreaterDate)
		.append(this.outCreaterOrgId)
		.append(this.outCreaterOrgName)
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("partyPersonId", this.partyPersonId) 
		.append("partyIntoDate", this.partyIntoDate) 
		.append("partyOutDate", this.partyOutDate) 
		.append("partyOutReason", this.partyOutReason) 
		.append("partyOutWhere", this.partyOutWhere) 
		.append("partyStatus", this.partyStatus) 
		.append("partyDate", this.partyDate) 
		.append("partyNote", this.partyNote) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("partyOldName", this.partyOldName) 
		.append("partyZhuanye", this.partyZhuanye) 
		.append("partySchoolName", this.partySchoolName) 
		.append("partySchoolDate", this.partySchoolDate) 
		.append("partyPhone", this.partyPhone) 
		.append("partyQq", this.partyQq) 
		.append("partyOtherAdd", this.partyOtherAdd) 
		.append("partyPositiveDate", this.partyPositiveDate)
		.append("isParty",this.isParty)
		.append("isPay",this.isPay)
		.append("lastPartyDate",this.lastPartyDate )
		.append("firstPartyDate",this.firstPartyDate )
		.append("partyMoney",this.partyMoney )
		.append("outCreaterId",this.outCreaterId )
		.append("outCreaterName",this.outCreaterName )
		.append("outCreaterOrgId",this.outCreaterOrgId )
		.append("outCreaterOrgName",this.outCreaterOrgName )
		.append("outCreaterDate",this.outCreaterDate )
		.toString();
	}
	public Long getIsParty() {
		return isParty;
	}
	public void setIsParty(Long isParty) {
		this.isParty = isParty;
	}
	public java.util.Date getFirstPartyDate() {
		return firstPartyDate;
	}
	public void setFirstPartyDate(java.util.Date firstPartyDate) {
		this.firstPartyDate = firstPartyDate;
	}
	public Float getPartyMoney() {
		return partyMoney;
	}
	public void setPartyMoney(Float partyMoney) {
		this.partyMoney = partyMoney;
	}
   
  

}