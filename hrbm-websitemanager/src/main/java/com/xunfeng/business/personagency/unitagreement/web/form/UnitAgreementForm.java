package com.xunfeng.business.personagency.unitagreement.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.unitagreement.model.UnitAgreement;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位协议表 Form对象
* @author:zhangfan
* @createDate 2016-07-06 12:11:01 
* @version V1.0   
*/
public class UnitAgreementForm extends BaseForm<UnitAgreement>
{
	// 主键
	protected Long  id;
	// 单位协议编号
	protected String  uaNo;
	// 协议签订日期
	protected java.util.Date  uaCreatetime;
	// 单位协议人
	protected String  uaName;
	// 联系电话
	protected String  uaPhone;
	// 是否免费0.是 1.否
	protected Long  uaIsFree;
	// 经办人身份证号
	protected String  uaCard;
	// 协议主要内容
	protected String  uaContent;
	// 备注
	protected String  uaNote;
	// 终止日期
	protected java.util.Date  uaStopEndtime;
	// 终止原因
	protected String  uaStopCause;
	// 单位ID(外键)
	protected Long  uaUnitId;
	
	// 协议状态 0 签订  1 终止
	protected Long uaStatus;
	// 经办人
	protected Long  createrId;
	// 经办人名称
	protected String  createrName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 经办机构Id
	protected Long  createrOrgId;
	// 经办机构名称
	protected String  createrOrgName;
	//协议实际终止日期
	protected java.util.Date stopDatexx;
	//终止经办人id
	protected Long stopId;
	//终止经办人名称
	protected String stopName;
	//终止经办日期
	protected java.util.Date stopDate;
	//终止机构id
	protected Long stopOrgId;
		
	//终止机构名称
	protected String stopOrgName;
	
	
	
	public java.util.Date getStopDatexx() {
		return stopDatexx;
	}
	public void setStopDatexx(java.util.Date stopDatexx) {
		this.stopDatexx = stopDatexx;
	}
	public Long getStopId() {
		return stopId;
	}
	public void setStopId(Long stopId) {
		this.stopId = stopId;
	}
	public String getStopName() {
		return stopName;
	}
	public void setStopName(String stopName) {
		this.stopName = stopName;
	}
	public java.util.Date getStopDate() {
		return stopDate;
	}
	public void setStopDate(java.util.Date stopDate) {
		this.stopDate = stopDate;
	}
	public Long getStopOrgId() {
		return stopOrgId;
	}
	public void setStopOrgId(Long stopOrgId) {
		this.stopOrgId = stopOrgId;
	}
	public String getStopOrgName() {
		return stopOrgName;
	}
	public void setStopOrgName(String stopOrgName) {
		this.stopOrgName = stopOrgName;
	}
	// 单位编号
	protected Long  aab001;
	
	// 单位名称
	protected String  aab004;
	
	// 工商登记执照号码
	protected String  aab007;
	
	// 单位性质
	protected String  aab019;
	
	// 经济类型
	protected String  aab020;
	
	// 地址
	protected String  aae006;
	
	// 所属地区行政区划代码
	protected String  aab301;
	
	//联系人
	protected String aae004;
	

	
	

	
	
	//单位性质
	protected String unitName;
	
	//经济类型
	protected String econName;
	
	//所在地区
	protected String aaa021;
	
	public String getAae004() {
		return aae004;
	}
	public void setAae004(String aae004) {
		this.aae004 = aae004;
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
	public void setUaNo(String uaNo) 
	{
		this.uaNo = uaNo;
	}
	/**
	 * 返回 单位协议编号
	 * @return
	 */
	public String getUaNo() 
	{
		return this.uaNo;
	}
	public void setUaCreatetime(java.util.Date uaCreatetime) 
	{
		this.uaCreatetime = uaCreatetime;
	}
	/**
	 * 返回 协议签订日期
	 * @return
	 */
	public java.util.Date getUaCreatetime() 
	{
		return this.uaCreatetime;
	}
	public void setUaName(String uaName) 
	{
		this.uaName = uaName;
	}
	/**
	 * 返回 单位协议人
	 * @return
	 */
	public String getUaName() 
	{
		return this.uaName;
	}
	public void setUaPhone(String uaPhone) 
	{
		this.uaPhone = uaPhone;
	}
	/**
	 * 返回 联系电话
	 * @return
	 */
	public String getUaPhone() 
	{
		return this.uaPhone;
	}
	public void setUaIsFree(Long uaIsFree) 
	{
		this.uaIsFree = uaIsFree;
	}
	/**
	 * 返回 是否免费0.是 1.否
	 * @return
	 */
	public Long getUaIsFree() 
	{
		return this.uaIsFree;
	}
	public void setUaCard(String uaCard) 
	{
		this.uaCard = uaCard;
	}
	/**
	 * 返回 经办人身份证号
	 * @return
	 */
	public String getUaCard() 
	{
		return this.uaCard;
	}
	public void setUaContent(String uaContent) 
	{
		this.uaContent = uaContent;
	}
	/**
	 * 返回 协议主要内容
	 * @return
	 */
	public String getUaContent() 
	{
		return this.uaContent;
	}
	public void setUaNote(String uaNote) 
	{
		this.uaNote = uaNote;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getUaNote() 
	{
		return this.uaNote;
	}
	public void setUaStopEndtime(java.util.Date uaStopEndtime) 
	{
		this.uaStopEndtime = uaStopEndtime;
	}
	/**
	 * 返回 终止日期
	 * @return
	 */
	public java.util.Date getUaStopEndtime() 
	{
		return this.uaStopEndtime;
	}
	public void setUaStopCause(String uaStopCause) 
	{
		this.uaStopCause = uaStopCause;
	}
	/**
	 * 返回 终止原因
	 * @return
	 */
	public String getUaStopCause() 
	{
		return this.uaStopCause;
	}
	public void setUaUnitId(Long uaUnitId) 
	{
		this.uaUnitId = uaUnitId;
	}
	/**
	 * 返回 单位ID(外键)
	 * @return
	 */
	public Long getUaUnitId() 
	{
		return this.uaUnitId;
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

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof UnitAgreementForm)) 
		{
			return false;
		}
		UnitAgreementForm rhs = (UnitAgreementForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.uaNo, rhs.uaNo)
		.append(this.uaCreatetime, rhs.uaCreatetime)
		.append(this.uaName, rhs.uaName)
		.append(this.uaPhone, rhs.uaPhone)
		.append(this.uaIsFree, rhs.uaIsFree)
		.append(this.uaCard, rhs.uaCard)
		.append(this.uaContent, rhs.uaContent)
		.append(this.uaNote, rhs.uaNote)
		.append(this.uaStopEndtime, rhs.uaStopEndtime)
		.append(this.uaStopCause, rhs.uaStopCause)
		.append(this.uaUnitId, rhs.uaUnitId)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.stopDatexx, rhs.stopDatexx)
		.append(this.stopDate, rhs.stopDate)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.uaNo) 
		.append(this.uaCreatetime) 
		.append(this.uaName) 
		.append(this.uaPhone) 
		.append(this.uaIsFree) 
		.append(this.uaCard) 
		.append(this.uaContent) 
		.append(this.uaNote) 
		.append(this.uaStopEndtime) 
		.append(this.uaStopCause) 
		.append(this.uaUnitId) 
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
		.append("uaNo", this.uaNo) 
		.append("uaCreatetime", this.uaCreatetime) 
		.append("uaName", this.uaName) 
		.append("uaPhone", this.uaPhone) 
		.append("uaIsFree", this.uaIsFree) 
		.append("uaCard", this.uaCard) 
		.append("uaContent", this.uaContent) 
		.append("uaNote", this.uaNote) 
		.append("uaStopEndtime", this.uaStopEndtime) 
		.append("uaStopCause", this.uaStopCause) 
		.append("uaUnitId", this.uaUnitId) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrDate", this.createrDate) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("stopDate",this.stopDate)
		.append("stopDatexx",this.stopDatexx)
		.toString();
	}
	public Long getAab001() {
		return aab001;
	}
	public void setAab001(Long aab001) {
		this.aab001 = aab001;
	}
	public String getAab004() {
		return aab004;
	}
	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}
	public String getAab007() {
		return aab007;
	}
	public void setAab007(String aab007) {
		this.aab007 = aab007;
	}
	public String getAab019() {
		return aab019;
	}
	public void setAab019(String aab019) {
		this.aab019 = aab019;
	}
	public String getAab020() {
		return aab020;
	}
	public void setAab020(String aab020) {
		this.aab020 = aab020;
	}
	public String getAae006() {
		return aae006;
	}
	public void setAae006(String aae006) {
		this.aae006 = aae006;
	}
	public String getAab301() {
		return aab301;
	}
	public void setAab301(String aab301) {
		this.aab301 = aab301;
	}
	
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getEconName() {
		return econName;
	}
	public void setEconName(String econName) {
		this.econName = econName;
	}
	public Long getUaStatus() {
		return uaStatus;
	}
	public void setUaStatus(Long uaStatus) {
		this.uaStatus = uaStatus;
	}
	public String getAaa021() {
		return aaa021;
	}
	public void setAaa021(String aaa021) {
		this.aaa021 = aaa021;
	}
	
   
  

}