package com.xunfeng.business.personagency.retired.dto;

import java.io.Serializable;


/**
 * 工作经历维护dto
 * @author Administrator
 *
 */
public class WorkExperienceDto implements Serializable {
	
	
		// 序号
		protected Long  id;
		// 起始时间
		protected java.util.Date  createTime;
		// 终止时间
		protected java.util.Date  endTime;
		// 工作单位
		protected String  workUnit;
		// 工种（职务
		protected Long  gzId;
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
		// 退休申诉id
		protected Long  retiredDeclareId;
		//人员id
		protected Long personId;
		
		//工种名称
		protected String gzName;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public java.util.Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(java.util.Date createTime) {
			this.createTime = createTime;
		}

		public java.util.Date getEndTime() {
			return endTime;
		}

		public void setEndTime(java.util.Date endTime) {
			this.endTime = endTime;
		}

		public String getWorkUnit() {
			return workUnit;
		}

		public void setWorkUnit(String workUnit) {
			this.workUnit = workUnit;
		}

		public Long getGzId() {
			return gzId;
		}

		public void setGzId(Long gzId) {
			this.gzId = gzId;
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

		public Long getRetiredDeclareId() {
			return retiredDeclareId;
		}

		public void setRetiredDeclareId(Long retiredDeclareId) {
			this.retiredDeclareId = retiredDeclareId;
		}

		public Long getPersonId() {
			return personId;
		}

		public void setPersonId(Long personId) {
			this.personId = personId;
		}

		public String getGzName() {
			return gzName;
		}

		public void setGzName(String gzName) {
			this.gzName = gzName;
		}
		
	
		
	
}
