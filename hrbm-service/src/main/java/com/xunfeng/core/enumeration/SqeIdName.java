
package com.xunfeng.core.enumeration;
/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年7月2日-上午11:27:12 
* @version V1.0   
*/
public enum SqeIdName {
	Accounts("CCM01","seq_wz_yhid",""),
	ShortMessage("COM05","seq_com_con",""),
	 
	PersonBaseInfo ("AC01","seq_gr_xxid","基本信息"),
	PersonEducation("AC0D","seq_gr_jyid","教育经历"),
	PersonJobRegist("CC20","seq_gr_qzid","求职登记"),
	PersonQualification("AC0C","seq_gr_zhengs","个人资格证书"),
	PersonSkill("CC0D","seq_gr_jnbh","技能"),
	PersonTrain("CC0B","seq_gr_pxbh","培训经历"),
	PersonWorkExpce("AC0B","seq_gr_jyid","工作经历"),
	Personlanguage("AC0F","SEQ_AC0F","语言能力"),
	PersonProject("AC0E","SEQ_AC0E","项目经验表"),
	JobCollect ("CCP02","seq_wz_zwsc","个人职位收藏夹"),
	JobAuditionInvited("CCP03","seq_wz_msyq","面试邀请表"),
	JobApply("CCP04","seq_wz_zwsq","职位申请表"),
	AccountMailAuth("CCP05","seq_wz_yjrz","邮件认证"),
	AccountPhoneAuth("CCP06","seq_wz_sjrz","手机认证"), 
	AccountMessage("CCM06","seq_znx_bh","站内信"),
	CorpBlackList("AC0G","seq_ac0g","黑名单"),
	
	SysDept ("OA_DEP","seq_oa_dep",""),
	SysUser("CD23","seq_zp_cyry",""),
	SysOrg("CD20","seq_zp_zjbh",""),
	
	Corp("AB01","seq_dw_xxbh","企业基本信息表"),
	CorpRecruit ("CB20","seq_dw_zpxx","单位招聘信息表"),
	CorpPosition("CB21","seq_dw_kwxx","单位招聘岗位表"),
	CorpTalentFavorites("CCP08","seq_wz_rcsc","企业人才收藏夹"),
	CorpResumeDownLog("CCP09","seq_wz_jlxz","企业下载日志记录表"),
	CorpInterviewComment("CCP12","seq_ccp12","企业面试评语"),
	
	 
	Recruitment("CB33","seq_zp_dhxx","招聘会信息表"),
	RecruitCorpEnter("CB35","seq_zp_dwjc","单位进场招聘表"),
	
	Interview("CB36","seq_cb36","面试会表"),
	InterviewApplySignLog("CB37","seq_cb37","面试会报名签到记录表"),
	Site("CD25","seq_zp_cdbh","场地表"),
	Booth ("CE20","seq_zp_twbh","摊位初始化表"),
	BoothBook("CCZ01","seq_zp_twyd","摊位预定表"),
	BoothForegift("CCZ02","seq_zp_yj","摊位押金表"), 
	BoothDebook("CCZ03","seq_zp_twcd","摊位退订表"),
	PaymentType("CCZ04","seq_zp_zflx","支付类型表"),
	PaymentLog("CCZ05","seq_zp_zfjl","支付记录表"),
	
	/*
	 *这两个没有序列
	 * BoothChangeLog("CCZ09","seq_zp_twcd","摊位变更记录表"),
	
	CorpOccupyBoothLog("CCZ10","seq_zp_twcd","企业占用摊位对应记录表"),
	*/
	
	Attachment("cao04","seq_xt_rztj","网上认证提交信息表 上传信息表"),
	 
	JobRecommend("CC22","seq_gr_tjid","求职推荐匹配表");
	
	
	
	private  String tableName ;
	private  String tableDes ;
	private  String seqName ;
	private SqeIdName(String tableName, String seqName,String tableDes) {
		this.tableName = tableName;
		this.seqName = seqName;
		this.tableDes = tableDes;
	}
	public String getTableName() {
		return tableName;
	}
	public String getSeqName() {
		return seqName;
	}
	public String getTableDes() {
		return tableDes;
	}
}
