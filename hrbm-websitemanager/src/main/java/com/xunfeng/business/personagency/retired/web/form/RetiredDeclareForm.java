package com.xunfeng.business.personagency.retired.web.form;
import java.util.List;

import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.archive.web.form.ArchivesForm;
import com.xunfeng.business.personagency.receive.web.form.GongZuoForm;
import com.xunfeng.business.personagency.receive.web.form.PersonBaseForm;
import com.xunfeng.business.personagency.receive.web.form.ReceiveArchivesPersonForm;
import com.xunfeng.business.personagency.retired.dto.RetiredDto;
import com.xunfeng.business.personagency.retired.model.RetiredDeclare;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员申报表 Form对象
* @author:zhangfan
* @createDate 2016-07-16 11:24:12 
* @version V1.0   
*/
public class RetiredDeclareForm extends BaseForm<RetiredDeclare>
{
	// 退休申报表id
	protected Long  id;
	// 单位名称
	protected String  unitName;
	// 单位编号
	protected String  unitNo;
	// 郑劳退字（）年（）号
	protected String  zltzh;
	// 序号
	protected String  xh;
	// 工种
	protected String  gzId;
	// 参加工作日期
	protected java.util.Date  createWorkDate;
	// 退休人员所属区域
	protected String  retiredArea;
	// 退休（退职）依据
	protected String  retiredYjId;
	// 退休类别
	protected String  retiredTypeId;
	// 退休后安置点
	protected String  retiredSite;
	// 民族(56)
	protected String  nationalId;
	// 申报分类
	protected String  declareType;
	// 公示开始时间
	protected java.util.Date  gsCreateDate;
	// 公示结束时间
	protected java.util.Date  gsStopDate;
	// 个人编号
	protected String  retiredPeopleNo;
	// 退休申报状态
	protected String  retiredDeclareStatus;
	// 退休个人编码
	protected String  retiredPeopleBm;
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
	// 工作经历维护ID   外键
	protected Long  workExperienceId;
	// 工作扣减情况id  外键
	protected Long  workKjId;
	// 个人基本信息id 外键
	protected Long  peopleId;
	// 档案基本信息ID 外键
	protected Long  archiveId;
	//是否正式退休（0.否 1.是 ）
	protected Long retiredStatus;
	//工种
	protected String craft;
	
	public RetiredDto retiredDto;

	//个人基本信息
	public PersonBaseForm personBaseForm;
	//工作情况
	public GongZuoForm gongZuoForm;
	//档案信息
	public ReceiveArchivesPersonForm receiveArchivesPersonForm;
	//档案信息
	public ArchivesForm archivesForm;
	

	
	//工作经历维护List
	private List<WorkExperienceForm> workExperienceFormList;
	
	
	//工作扣减list
	private List<WorkKjForm> workKjFormList;
	
	
	//工作扣减form
	private WorkKjForm workKjForm;
	
	//养老待遇申请Form
	private YangLaoForm yangLaoForm;


	public List<WorkExperienceForm> getWorkExperienceFormList() {
		return workExperienceFormList;
	}

	public void setWorkExperienceFormList(
			List<WorkExperienceForm> workExperienceFormList) {
		this.workExperienceFormList = workExperienceFormList;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}
	
	/**
	 * 返回 退休申报表id
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setUnitName(String unitName) 
	{
		this.unitName = unitName;
	}
	/**
	 * 返回 单位名称
	 * @return
	 */
	public String getUnitName() 
	{
		return this.unitName;
	}
	public void setUnitNo(String unitNo) 
	{
		this.unitNo = unitNo;
	}
	/**
	 * 返回 单位编号
	 * @return
	 */
	public String getUnitNo() 
	{
		return this.unitNo;
	}
	public void setZltzh(String zltzh) 
	{
		this.zltzh = zltzh;
	}
	/**
	 * 返回 郑劳退字（）年（）号
	 * @return
	 */
	public String getZltzh() 
	{
		return this.zltzh;
	}
	public void setXh(String xh) 
	{
		this.xh = xh;
	}
	/**
	 * 返回 序号
	 * @return
	 */
	public String getXh() 
	{
		return this.xh;
	}
	public void setGzId(String gzId) 
	{
		this.gzId = gzId;
	}
	/**
	 * 返回 工种
	 * @return
	 */
	public String getGzId() 
	{
		return this.gzId;
	}
	public void setCreateWorkDate(java.util.Date createWorkDate) 
	{
		this.createWorkDate = createWorkDate;
	}
	/**
	 * 返回 参加工作日期
	 * @return
	 */
	public java.util.Date getCreateWorkDate() 
	{
		return this.createWorkDate;
	}
	public void setRetiredArea(String retiredArea) 
	{
		this.retiredArea = retiredArea;
	}
	/**
	 * 返回 退休人员所属区域
	 * @return
	 */
	public String getRetiredArea() 
	{
		return this.retiredArea;
	}
	public void setRetiredYjId(String retiredYjId) 
	{
		this.retiredYjId = retiredYjId;
	}
	/**
	 * 返回 退休（退职）依据
	 * @return
	 */
	public String getRetiredYjId() 
	{
		return this.retiredYjId;
	}
	public void setRetiredTypeId(String retiredTypeId) 
	{
		this.retiredTypeId = retiredTypeId;
	}
	/**
	 * 返回 退休类别
	 * @return
	 */
	public String getRetiredTypeId() 
	{
		return this.retiredTypeId;
	}
	public void setRetiredSite(String retiredSite) 
	{
		this.retiredSite = retiredSite;
	}
	public void setCreaterId(Long createrId) {
		this.createrId = createrId;
	}

	/**
	 * 返回 退休后安置点
	 * @return
	 */
	public String getRetiredSite() 
	{
		return this.retiredSite;
	}
	public void setNationalId(String nationalId) 
	{
		this.nationalId = nationalId;
	}
	/**
	 * 返回 民族(56)
	 * @return
	 */
	public String getNationalId() 
	{
		return this.nationalId;
	}
	public void setDeclareType(String declareType) 
	{
		this.declareType = declareType;
	}
	/**
	 * 返回 申报分类
	 * @return
	 */
	public String getDeclareType() 
	{
		return this.declareType;
	}
	public void setGsCreateDate(java.util.Date gsCreateDate) 
	{
		this.gsCreateDate = gsCreateDate;
	}
	/**
	 * 返回 公示开始时间
	 * @return
	 */
	public java.util.Date getGsCreateDate() 
	{
		return this.gsCreateDate;
	}
	public void setGsStopDate(java.util.Date gsStopDate) 
	{
		this.gsStopDate = gsStopDate;
	}
	/**
	 * 返回 公示结束时间
	 * @return
	 */
	public java.util.Date getGsStopDate() 
	{
		return this.gsStopDate;
	}
	public void setRetiredPeopleNo(String retiredPeopleNo) 
	{
		this.retiredPeopleNo = retiredPeopleNo;
	}
	/**
	 * 返回 个人编号
	 * @return
	 */
	public String getRetiredPeopleNo() 
	{
		return this.retiredPeopleNo;
	}
	public void setRetiredDeclareStatus(String retiredDeclareStatus) 
	{
		this.retiredDeclareStatus = retiredDeclareStatus;
	}
	/**
	 * 返回 退休申报状态
	 * @return
	 */
	public String getRetiredDeclareStatus() 
	{
		return this.retiredDeclareStatus;
	}
	public void setRetiredPeopleBm(String retiredPeopleBm) 
	{
		this.retiredPeopleBm = retiredPeopleBm;
	}
	/**
	 * 返回 退休个人编码
	 * @return
	 */
	public String getRetiredPeopleBm() 
	{
		return this.retiredPeopleBm;
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
	public void setWorkExperienceId(Long workExperienceId) 
	{
		this.workExperienceId = workExperienceId;
	}
	/**
	 * 返回 工作经历维护ID   外键
	 * @return
	 */
	public Long getWorkExperienceId() 
	{
		return this.workExperienceId;
	}
	public void setWorkKjId(Long workKjId) 
	{
		this.workKjId = workKjId;
	}
	/**
	 * 返回 工作扣减情况id  外键
	 * @return
	 */
	public Long getWorkKjId() 
	{
		return this.workKjId;
	}
	public void setPeopleId(Long peopleId) 
	{
		this.peopleId = peopleId;
	}
	/**
	 * 返回 个人基本信息id 外键
	 * @return
	 */
	public Long getPeopleId() 
	{
		return this.peopleId;
	}
	public void setArchiveId(Long archiveId) 
	{
		this.archiveId = archiveId;
	}
	/**
	 * 返回 档案基本信息ID 外键
	 * @return
	 */
	public Long getArchiveId() 
	{
		return this.archiveId;
	}

	public PersonBaseForm getPersonBaseForm() {
		return personBaseForm;
	}

	public void setPersonBaseForm(PersonBaseForm personBaseForm) {
		this.personBaseForm = personBaseForm;
	}

	public GongZuoForm getGongZuoForm() {
		return gongZuoForm;
	}

	public void setGongZuoForm(GongZuoForm gongZuoForm) {
		this.gongZuoForm = gongZuoForm;
	}

	public ReceiveArchivesPersonForm getReceiveArchivesPersonForm() {
		return receiveArchivesPersonForm;
	}

	public void setReceiveArchivesPersonForm(
			ReceiveArchivesPersonForm receiveArchivesPersonForm) {
		this.receiveArchivesPersonForm = receiveArchivesPersonForm;
	}

	public ArchivesForm getArchivesForm() {
		return archivesForm;
	}

	public void setArchivesForm(ArchivesForm archivesForm) {
		this.archivesForm = archivesForm;
	}

	public RetiredDto getRetiredDto() {
		return retiredDto;
	}

	public void setRetiredDto(RetiredDto retiredDto) {
		this.retiredDto = retiredDto;
	}

	public List<WorkKjForm> getWorkKjFormList() {
		return workKjFormList;
	}

	public void setWorkKjFormList(List<WorkKjForm> workKjFormList) {
		this.workKjFormList = workKjFormList;
	}

	public WorkKjForm getWorkKjForm() {
		return workKjForm;
	}

	public void setWorkKjForm(WorkKjForm workKjForm) {
		this.workKjForm = workKjForm;
	}

	public YangLaoForm getYangLaoForm() {
		return yangLaoForm;
	}

	public void setYangLaoForm(YangLaoForm yangLaoForm) {
		this.yangLaoForm = yangLaoForm;
	}

	public Long getRetiredStatus() {
		return retiredStatus;
	}

	public void setRetiredStatus(Long retiredStatus) {
		this.retiredStatus = retiredStatus;
	}


	public String getCraft() {
		return craft;
	}

	public void setCraft(String craft) {
		this.craft = craft;
	}


	
	
	


  

}