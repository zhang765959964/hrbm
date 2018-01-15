package com.xunfeng.business.personagency.retired.web.form;

import java.io.Serializable;
import java.util.Date;

import com.xunfeng.business.personagency.death.model.DeathDeclare;
import com.xunfeng.core.model.BaseForm;

/**
 * 代理退休人员更新
 * @author Administrator
 *
 */
public class RetiredAllForm extends BaseForm<DeathDeclare> {
	
	
	private Long id; //退休id
	
	private Long personId;	//人员id
	
	private String retiredPeopleNo;	//个人编号
	
	private String retiredPeopleBm;	//退休个人编码
	
	private Long createrOrgId;	//经办机构id
	
	private String createrOrgName;	//经办机构
	
	private Date createrDate;	//经办日期
	
	private String xh;	//序号
	
	protected Long  createrId;
	
	private String createrName;		//创建人名称
	
	private Long nationId;	//民族
	
	private String nationName;	//退休民族名称
	
	
	private Long retiredTypeId;	//退休类别
	
	private Long retiredDeclareStatus;	//退休申报状态
	
	
	private String unitName;	//原单位名称
	
	private String retiredArea;	//退休人员所属区域
	
	private String retiredSite;	//退休后安置点
	
	private String declareNote;	//申报备注
	
	private Date createWorkDate;	//参加工作时间
	
	private Long retiredYjId;	//符合离退休规定条款
	
	private String ylName;	//符合离退休规定条款名称
	
	private Date payDate;	//缴费年月
	
	private Date retiredDate;	//应退休时间

	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getRetiredPeopleNo() {
		return retiredPeopleNo;
	}

	public void setRetiredPeopleNo(String retiredPeopleNo) {
		this.retiredPeopleNo = retiredPeopleNo;
	}

	public String getRetiredPeopleBm() {
		return retiredPeopleBm;
	}

	public void setRetiredPeopleBm(String retiredPeopleBm) {
		this.retiredPeopleBm = retiredPeopleBm;
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

	public Date getCreaterDate() {
		return createrDate;
	}

	public void setCreaterDate(Date createrDate) {
		this.createrDate = createrDate;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public Long getNationId() {
		return nationId;
	}

	public void setNationId(Long nationId) {
		this.nationId = nationId;
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public Long getRetiredTypeId() {
		return retiredTypeId;
	}

	public void setRetiredTypeId(Long retiredTypeId) {
		this.retiredTypeId = retiredTypeId;
	}

	public Long getRetiredDeclareStatus() {
		return retiredDeclareStatus;
	}

	public void setRetiredDeclareStatus(Long retiredDeclareStatus) {
		this.retiredDeclareStatus = retiredDeclareStatus;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getRetiredArea() {
		return retiredArea;
	}

	public void setRetiredArea(String retiredArea) {
		this.retiredArea = retiredArea;
	}

	public String getRetiredSite() {
		return retiredSite;
	}

	public void setRetiredSite(String retiredSite) {
		this.retiredSite = retiredSite;
	}

	public String getDeclareNote() {
		return declareNote;
	}

	public void setDeclareNote(String declareNote) {
		this.declareNote = declareNote;
	}

	public Date getCreateWorkDate() {
		return createWorkDate;
	}

	public void setCreateWorkDate(Date createWorkDate) {
		this.createWorkDate = createWorkDate;
	}

	public Long getRetiredYjId() {
		return retiredYjId;
	}

	public void setRetiredYjId(Long retiredYjId) {
		this.retiredYjId = retiredYjId;
	}

	public String getYlName() {
		return ylName;
	}

	public void setYlName(String ylName) {
		this.ylName = ylName;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getRetiredDate() {
		return retiredDate;
	}

	public void setRetiredDate(Date retiredDate) {
		this.retiredDate = retiredDate;
	}

	public Long getCreaterId() {
		return createrId;
	}

	public void setCreaterId(Long createrId) {
		this.createrId = createrId;
	}
	
	
	
	
	

}
