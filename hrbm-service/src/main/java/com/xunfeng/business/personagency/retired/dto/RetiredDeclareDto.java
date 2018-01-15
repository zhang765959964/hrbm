package com.xunfeng.business.personagency.retired.dto;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;

/**
 * 
 * 退休申诉dto
 * @date 2016年7月19日10:41:52
 * @author zf
 *
 */
public class RetiredDeclareDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
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
		
		//工种name
		protected String gzName;
		
		//工种
		protected String craft;
		
		/**** 以下是个人基本信息表    ****/
		
		
		private Long aac001;	//个人id 主键
		
	
		private String aac002;	//身份证号
		
		private String aae005;	//手机号
		
		
		/****  以下是个人基本信息扩展表     ***/
		
		
		private Long  expandId;		// 个人扩展表 主键
		
		private Long expPersonId;	//个人信息表外键
		
		private String expPersonPhone;	//联系电话
		
		private String expCardNumber; 	//身份证地址
		
		private String expAddress;		//现居住地址
		
		private String expOldCompany;		//原单位名称
		
		private String expSoctalNumber;		//社会保障号
		
		
		/********** 以下 是档案表信息  *************/
		
		
		private Long daId; 	//人员档案id 主键
		
		private java.util.Date archiveBirthDate; //档案出生日期
		
		private Long personId;	//人员id   跟个人表关联
		
		private RetiredDto retiredDto;	//退休申诉dto
		
		
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
		
		public String getCraft() {
			return craft;
		}
		public void setCraft(String craft) {
			this.craft = craft;
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
		@JsonSerialize(using=JsonDateSerializer.class) 
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
		@JsonSerialize(using=JsonDateSerializer.class) 
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
		@JsonSerialize(using=JsonDateSerializer.class) 
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
		public Long getAac001() {
			return aac001;
		}
		public void setAac001(Long aac001) {
			this.aac001 = aac001;
		}
		public String getAac002() {
			return aac002;
		}
		public void setAac002(String aac002) {
			this.aac002 = aac002;
		}
		public String getAae005() {
			return aae005;
		}
		public void setAae005(String aae005) {
			this.aae005 = aae005;
		}
		public Long getExpandId() {
			return expandId;
		}
		public void setExpandId(Long expandId) {
			this.expandId = expandId;
		}
		public Long getExpPersonId() {
			return expPersonId;
		}
		public void setExpPersonId(Long expPersonId) {
			this.expPersonId = expPersonId;
		}
		public String getExpPersonPhone() {
			return expPersonPhone;
		}
		public void setExpPersonPhone(String expPersonPhone) {
			this.expPersonPhone = expPersonPhone;
		}
		public String getExpCardNumber() {
			return expCardNumber;
		}
		public void setExpCardNumber(String expCardNumber) {
			this.expCardNumber = expCardNumber;
		}
		public String getExpAddress() {
			return expAddress;
		}
		public void setExpAddress(String expAddress) {
			this.expAddress = expAddress;
		}
		public String getExpOldCompany() {
			return expOldCompany;
		}
		public void setExpOldCompany(String expOldCompany) {
			this.expOldCompany = expOldCompany;
		}
		public String getExpSoctalNumber() {
			return expSoctalNumber;
		}
		public void setExpSoctalNumber(String expSoctalNumber) {
			this.expSoctalNumber = expSoctalNumber;
		}
		public Long getDaId() {
			return daId;
		}
		public void setDaId(Long daId) {
			this.daId = daId;
		}
		public java.util.Date getArchiveBirthDate() {
			return archiveBirthDate;
		}
		public void setArchiveBirthDate(java.util.Date archiveBirthDate) {
			this.archiveBirthDate = archiveBirthDate;
		}
		public Long getPersonId() {
			return personId;
		}
		public void setPersonId(Long personId) {
			this.personId = personId;
		}
		public RetiredDto getRetiredDto() {
			return retiredDto;
		}
		public void setRetiredDto(RetiredDto retiredDto) {
			this.retiredDto = retiredDto;
		}
		public Long getRetiredStatus() {
			return retiredStatus;
		}
		public void setRetiredStatus(Long retiredStatus) {
			this.retiredStatus = retiredStatus;
		}
		public String getGzName() {
			return gzName;
		}
		public void setGzName(String gzName) {
			this.gzName = gzName;
		}

		
		
	
		
		
		
		
	

}
