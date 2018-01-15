package com.xunfeng.business.personagency.retired.dto;

import java.io.Serializable;

/**
 * 养老申请dto
 * @author Administrator
 *
 */
public class RetiredYlDto implements Serializable{
	
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
		private Long personId;
		//退休申诉dto
		private RetiredDeclareDto retiredDeclareDto;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public java.util.Date getPayDate() {
			return payDate;
		}
		public void setPayDate(java.util.Date payDate) {
			this.payDate = payDate;
		}
		public java.util.Date getRetiredDate() {
			return retiredDate;
		}
		public void setRetiredDate(java.util.Date retiredDate) {
			this.retiredDate = retiredDate;
		}
		public String getDeclareNote() {
			return declareNote;
		}
		public void setDeclareNote(String declareNote) {
			this.declareNote = declareNote;
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
		public Long getRetiredId() {
			return retiredId;
		}
		public void setRetiredId(Long retiredId) {
			this.retiredId = retiredId;
		}
		public RetiredDeclareDto getRetiredDeclareDto() {
			return retiredDeclareDto;
		}
		public void setRetiredDeclareDto(RetiredDeclareDto retiredDeclareDto) {
			this.retiredDeclareDto = retiredDeclareDto;
		}
		public Long getPersonId() {
			return personId;
		}
		public void setPersonId(Long personId) {
			this.personId = personId;
		}
		
	
		
			
	
	
	
}
