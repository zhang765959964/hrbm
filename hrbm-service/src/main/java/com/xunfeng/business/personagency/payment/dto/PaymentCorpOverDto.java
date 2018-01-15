package com.xunfeng.business.personagency.payment.dto;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;


/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 单位欠费记录dto对象
 * @author:wanghan
 * @createDate 2016-08-16 16:43:34
 * @version V1.0
 */
public class PaymentCorpOverDto implements Serializable{

	// 主键
	protected Long id;
	// 单位协议编号
	protected String uaNo;
	// 协议签订日期
	protected java.util.Date uaCreatetime;
	// 单位协议人
	protected String uaName;
	// 联系电话
	protected String uaPhone;
	// 是否免费0.是 1.否
	protected Long uaIsFree;
	// 经办人身份证号
	protected String uaCard;
	// 协议主要内容
	protected String uaContent;
	// 备注
	protected String uaNote;
	// 终止日期
	protected java.util.Date uaStopEndtime;
	// 终止原因
	protected String uaStopCause;
	// 单位ID(外键)
	protected Long uaUnitId;

	// 协议状态 0 签订协议 1.终止协议
	protected Long uaStatus;

	protected String uaStatuss;		// 0 有效 1 无效
	// 经办人
	protected Long createrId;
	// 经办人名称
	protected String createrName;
	// 经办日期
	protected java.util.Date createrDate;
	// 经办机构Id
	protected Long createrOrgId;
	// 经办机构名称
	protected String createrOrgName;

	// 协议实际终止日期
	protected java.util.Date stopDatexx;

	// 终止经办人id
	protected Long stopId;

	// 终止经办人名称
	protected String stopName;

	// 终止经办日期
	protected java.util.Date stopDate;

	// 终止机构id
	protected Long stopOrgId;

	// 终止机构名称
	protected String stopOrgName;

	// 单位编号
	protected Long aab001;

	// 单位名称
	protected String aab004;

	// 工商登记执照号码
	protected String aab007;

	// 单位性质
	protected String aab019;

	// 经济类型
	protected String aab020;

	// 地址
	protected String aae006;

	// 所属地区行政区划代码
	protected String aab301;
	protected String aaa021;

	// 联系人
	protected String aae004;

	// 联系电话
	protected String aae005;

	// 传真
	protected String bab002;

	// 单位性质
	protected String unitName;

	// 经济类型
	protected String econName;
	
	// 欠费金额
	protected String overAmount;
	
	// 欠费人数
	protected String overUserNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUaNo() {
		return uaNo;
	}

	public void setUaNo(String uaNo) {
		this.uaNo = uaNo;
	}
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getUaCreatetime() {
		return uaCreatetime;
	}

	public void setUaCreatetime(java.util.Date uaCreatetime) {
		this.uaCreatetime = uaCreatetime;
	}

	public String getUaName() {
		return uaName;
	}

	public void setUaName(String uaName) {
		this.uaName = uaName;
	}

	public String getUaPhone() {
		return uaPhone;
	}

	public void setUaPhone(String uaPhone) {
		this.uaPhone = uaPhone;
	}

	public Long getUaIsFree() {
		return uaIsFree;
	}

	public void setUaIsFree(Long uaIsFree) {
		this.uaIsFree = uaIsFree;
	}

	public String getUaCard() {
		return uaCard;
	}

	public void setUaCard(String uaCard) {
		this.uaCard = uaCard;
	}

	public String getUaContent() {
		return uaContent;
	}

	public void setUaContent(String uaContent) {
		this.uaContent = uaContent;
	}

	public String getUaNote() {
		return uaNote;
	}

	public void setUaNote(String uaNote) {
		this.uaNote = uaNote;
	}
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getUaStopEndtime() {
		return uaStopEndtime;
	}

	public void setUaStopEndtime(java.util.Date uaStopEndtime) {
		this.uaStopEndtime = uaStopEndtime;
	}

	public String getUaStopCause() {
		return uaStopCause;
	}

	public void setUaStopCause(String uaStopCause) {
		this.uaStopCause = uaStopCause;
	}

	public Long getUaUnitId() {
		return uaUnitId;
	}

	public void setUaUnitId(Long uaUnitId) {
		this.uaUnitId = uaUnitId;
	}

	public Long getUaStatus() {
		return uaStatus;
	}

	public void setUaStatus(Long uaStatus) {
		this.uaStatus = uaStatus;
	}

	public Long getCreaterId() {
		return createrId;
	}

	public void setCreaterId(Long createrId) {
		this.createrId = createrId;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getCreaterDate() {
		return createrDate;
	}

	public void setCreaterDate(java.util.Date createrDate) {
		this.createrDate = createrDate;
	}

	public Long getCreaterOrgId() {
		return createrOrgId;
	}

	public void setCreaterOrgId(Long createrOrgId) {
		this.createrOrgId = createrOrgId;
	}

	public String getCreaterOrgName() {
		return createrOrgName;
	}

	public void setCreaterOrgName(String createrOrgName) {
		this.createrOrgName = createrOrgName;
	}
	@JsonSerialize(using=JsonDateSerializer.class) 
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
	@JsonSerialize(using=JsonDateSerializer.class) 
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

	public String getAae004() {
		return aae004;
	}

	public void setAae004(String aae004) {
		this.aae004 = aae004;
	}

	public String getAae005() {
		return aae005;
	}

	public void setAae005(String aae005) {
		this.aae005 = aae005;
	}

	public String getBab002() {
		return bab002;
	}

	public void setBab002(String bab002) {
		this.bab002 = bab002;
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

	public String getOverAmount() {
		return overAmount;
	}

	public void setOverAmount(String overAmount) {
		this.overAmount = overAmount;
	}

	public String getOverUserNum() {
		return overUserNum;
	}

	public void setOverUserNum(String overUserNum) {
		this.overUserNum = overUserNum;
	}

	public String getAaa021() {
		return aaa021;
	}

	public void setAaa021(String aaa021) {
		this.aaa021 = aaa021;
	}

	
	public String getUaStatuss() {
	
		return uaStatuss;
	}

	
	public void setUaStatuss(String uaStatuss) {
	
		this.uaStatuss = uaStatuss;
	}
	
	

}