package com.xunfeng.business.jobfair.dto;

import com.xunfeng.business.jobfair.model.JobFairInfo;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 招聘会信息表 Model对象
* @author:wanghan
* @createDate 2015-09-12 11:02:45 
* @version V1.0   
*/
public class JobFairInfoSiteDto extends JobFairInfo
{

		// 场地名称
		protected String  acd253;
		// 场地地址
		protected String  cczc004;
		// 乘车路线
		protected String  cczc005;
		//状态
		protected String  status;
		//参会企业
		protected Long fairCorp=0l;
		//发布职位
		protected Long fairJob=0l;
		//累计入场人数
		protected Long fairPerson=0l;
		//招聘会是否到截止时间不能预定 (0 代表能预定，1代表不能预定)
		protected  int  isCanBookFair= 0;
		
		public Long getFairCorp() {
			return fairCorp;
		}
		public void setFairCorp(Long fairCorp) {
			this.fairCorp = fairCorp;
		}
		public Long getFairJob() {
			return fairJob;
		}
		public void setFairJob(Long fairJob) {
			this.fairJob = fairJob;
		}
		public Long getFairPerson() {
			return fairPerson;
		}
		public void setFairPerson(Long fairPerson) {
			this.fairPerson = fairPerson;
		}
		public String getAcd253() {
			return acd253;
		}
		public void setAcd253(String acd253) {
			this.acd253 = acd253;
		}
		public String getCczc004() {
			return cczc004;
		}
		public void setCczc004(String cczc004) {
			this.cczc004 = cczc004;
		}
		public String getCczc005() {
			return cczc005;
		}
		public void setCczc005(String cczc005) {
			this.cczc005 = cczc005;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getIsCanBookFair() {
			
			return isCanBookFair;
		}
		public void setIsCanBookFair(int isCanBookFair) {
			this.isCanBookFair = isCanBookFair;
		}
		
		

	
}