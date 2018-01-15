package com.xunfeng.business.careertalk.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;

public class CareerTalkView {

		// 宣讲会主键
		protected Long  ctId;
		// 标题
		protected String  ctTitle;
		// 内容
		protected String  ctContent;
		// 状态
		protected Long  ctStatus;
		// 创建人
		protected Long  ctCreateby;
		// 创建时间
		protected java.util.Date  ctCreatetime;
		// 最终修改人
		protected Long  ctUpdateby;
		// 最终修改时间
		protected java.util.Date  ctUpdatetime;
		// 宣讲会开会具体结束时间
		protected java.util.Date  ctCareerEndtime;
		// 宣讲会开会具体开始时间
		protected java.util.Date  ctCareerStarttime;
		// 审批人
		protected Long  ctApproveUserid;
		// 审批时间
		protected java.util.Date  ctApproveTime;
		// 审批意见
		protected String  ctApproveOpinion;
		// 宣讲会时间区段主键
		protected Long  ctbId;
		// 开始时间
		protected String  ctbStarttime;
		// 结束时间
		protected String  ctbEndtime;
		// 周几
		protected String ctbWeekday;
		// 宣讲会教室主键
		protected Long  crId;
		// 教室名称
		protected String  crName;
		// 教室地址
		protected String  crAddress;
		// 最大容纳人数
		protected Long  crMaxPeople;
		// 描述
		protected String  crDesc;
		// 状态
		protected Long  crStatus;
		// 创建时间
		protected java.util.Date  crCreatetime;
		// 最终修改时间
		protected java.util.Date  crUpdatetime;
		// 创建人
		protected Long  crCreateBy;
		// 最终修改人
		protected Long  crUpdateBy;
		// 创建企业name
		protected String ctCreatebyname;
		// 修改企业name
		protected String ctUpdatebyname;
		// 审批人name
		protected String ctApproveUsername;
		// 教室的创建人name
		protected String crCreateByName;
		// 教室的修改人name
		protected String crUpdateByName;
		
		protected String monthDay;
		
		protected String formantStartTime;
		
		protected String formantEndTime;
		
		
		public Long getCtId() {
			return ctId;
		}
		public void setCtId(Long ctId) {
			this.ctId = ctId;
		}
		public String getCtTitle() {
			return ctTitle;
		}
		public void setCtTitle(String ctTitle) {
			this.ctTitle = ctTitle;
		}
		public String getCtContent() {
			return ctContent;
		}
		public void setCtContent(String ctContent) {
			this.ctContent = ctContent;
		}
		public Long getCtStatus() {
			return ctStatus;
		}
		public void setCtStatus(Long ctStatus) {
			this.ctStatus = ctStatus;
		}
		public Long getCtCreateby() {
			return ctCreateby;
		}
		public void setCtCreateby(Long ctCreateby) {
			this.ctCreateby = ctCreateby;
		}
		public java.util.Date getCtCreatetime() {
			return ctCreatetime;
		}
		public void setCtCreatetime(java.util.Date ctCreatetime) {
			this.ctCreatetime = ctCreatetime;
		}
		public Long getCtUpdateby() {
			return ctUpdateby;
		}
		public void setCtUpdateby(Long ctUpdateby) {
			this.ctUpdateby = ctUpdateby;
		}
		public java.util.Date getCtUpdatetime() {
			return ctUpdatetime;
		}
		public void setCtUpdatetime(java.util.Date ctUpdatetime) {
			this.ctUpdatetime = ctUpdatetime;
		}
		@JsonSerialize(using = JsonDateSerializer.class)
		public java.util.Date getCtCareerEndtime() {
			return ctCareerEndtime;
		}
		public void setCtCareerEndtime(java.util.Date ctCareerEndtime) {
			this.ctCareerEndtime = ctCareerEndtime;
		}
		@JsonSerialize(using = JsonDateSerializer.class)
		public java.util.Date getCtCareerStarttime() {
			return ctCareerStarttime;
		}
		public void setCtCareerStarttime(java.util.Date ctCareerStarttime) {
			this.ctCareerStarttime = ctCareerStarttime;
		}
		public Long getCtApproveUserid() {
			return ctApproveUserid;
		}
		public void setCtApproveUserid(Long ctApproveUserid) {
			this.ctApproveUserid = ctApproveUserid;
		}
		public java.util.Date getCtApproveTime() {
			return ctApproveTime;
		}
		public void setCtApproveTime(java.util.Date ctApproveTime) {
			this.ctApproveTime = ctApproveTime;
		}
		public String getCtApproveOpinion() {
			return ctApproveOpinion;
		}
		public void setCtApproveOpinion(String ctApproveOpinion) {
			this.ctApproveOpinion = ctApproveOpinion;
		}
		public Long getCtbId() {
			return ctbId;
		}
		public void setCtbId(Long ctbId) {
			this.ctbId = ctbId;
		}
		public String getCtbStarttime() {
			return ctbStarttime;
		}
		public void setCtbStarttime(String ctbStarttime) {
			this.ctbStarttime = ctbStarttime;
		}
		public String getCtbEndtime() {
			return ctbEndtime;
		}
		public void setCtbEndtime(String ctbEndtime) {
			this.ctbEndtime = ctbEndtime;
		}
		public String getCtbWeekday() {
			return ctbWeekday;
		}
		public void setCtbWeekday(String ctbWeekday) {
			this.ctbWeekday = ctbWeekday;
		}
		public Long getCrId() {
			return crId;
		}
		public void setCrId(Long crId) {
			this.crId = crId;
		}
		public String getCrName() {
			return crName;
		}
		public void setCrName(String crName) {
			this.crName = crName;
		}
		public String getCrAddress() {
			return crAddress;
		}
		public void setCrAddress(String crAddress) {
			this.crAddress = crAddress;
		}
		public Long getCrMaxPeople() {
			return crMaxPeople;
		}
		public void setCrMaxPeople(Long crMaxPeople) {
			this.crMaxPeople = crMaxPeople;
		}
		public String getCrDesc() {
			return crDesc;
		}
		public void setCrDesc(String crDesc) {
			this.crDesc = crDesc;
		}
		public Long getCrStatus() {
			return crStatus;
		}
		public void setCrStatus(Long crStatus) {
			this.crStatus = crStatus;
		}
		public java.util.Date getCrCreatetime() {
			return crCreatetime;
		}
		public void setCrCreatetime(java.util.Date crCreatetime) {
			this.crCreatetime = crCreatetime;
		}
		public java.util.Date getCrUpdatetime() {
			return crUpdatetime;
		}
		public void setCrUpdatetime(java.util.Date crUpdatetime) {
			this.crUpdatetime = crUpdatetime;
		}
		public Long getCrCreateBy() {
			return crCreateBy;
		}
		public void setCrCreateBy(Long crCreateBy) {
			this.crCreateBy = crCreateBy;
		}
		public Long getCrUpdateBy() {
			return crUpdateBy;
		}
		public void setCrUpdateBy(Long crUpdateBy) {
			this.crUpdateBy = crUpdateBy;
		}
		public String getCtCreatebyname() {
			return ctCreatebyname;
		}
		public void setCtCreatebyname(String ctCreatebyname) {
			this.ctCreatebyname = ctCreatebyname;
		}
		public String getCtUpdatebyname() {
			return ctUpdatebyname;
		}
		public void setCtUpdatebyname(String ctUpdatebyname) {
			this.ctUpdatebyname = ctUpdatebyname;
		}
		public String getCtApproveUsername() {
			return ctApproveUsername;
		}
		public void setCtApproveUsername(String ctApproveUsername) {
			this.ctApproveUsername = ctApproveUsername;
		}
		public String getCrCreateByName() {
			return crCreateByName;
		}
		public void setCrCreateByName(String crCreateByName) {
			this.crCreateByName = crCreateByName;
		}
		public String getCrUpdateByName() {
			return crUpdateByName;
		}
		public void setCrUpdateByName(String crUpdateByName) {
			this.crUpdateByName = crUpdateByName;
		}
		public String getMonthDay() {
			return monthDay;
		}
		public void setMonthDay(String monthDay) {
			this.monthDay = monthDay;
		}
		public String getFormantStartTime() {
			return formantStartTime;
		}
		public void setFormantStartTime(String formantStartTime) {
			this.formantStartTime = formantStartTime;
		}
		public String getFormantEndTime() {
			return formantEndTime;
		}
		public void setFormantEndTime(String formantEndTime) {
			this.formantEndTime = formantEndTime;
		}
		
}
