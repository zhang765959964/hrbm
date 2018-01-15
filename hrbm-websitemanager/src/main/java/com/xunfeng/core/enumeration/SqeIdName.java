
package com.xunfeng.core.enumeration;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年7月2日-上午11:27:12 
* @version V1.0   
*/
public enum SqeIdName {
	Accounts("CCM01","seq_wz_yhid"),
	
	Corp("AB01","seq_dw_xxbh"),
	CorpPositionPublish("CB20","seq_dw_zpxx"),
	CorpPosition("CB21","seq_dw_kwxx"),
	
	PersonBaseInfo ("AC01","seq_gr_xxid"),
	PersonEducation("AC0D","seq_gr_jyid"),
	PersonJobRegist("CC20","seq_gr_qzid"),
	PersonQualification("AC0C","seq_gr_zhengs"),
	PersonSkill("CC0D","seq_gr_jnbh"),
	PersonTrain("CC0B","seq_gr_pxbh"),
	PersonWorkExpce("AC0B","seq_gr_jyid"),
	PersonFamily("RSDA_BS_PERSON_FAMILY","seq_gr_jtid"),
	PersonExpand("RSDA_BS_PERSON_EXPAND","seq_gr_jbxxkz"),
	
	LaborAccom("ACC0M","SEQ_ACC0M"),
	LaborAcemployed("ACEMPLOYED","SEQ_ACEMPLOYED"),
	LaborAcpost("ACPOST","SEQ_ACPOST"),
	
	SysDept ("OA_DEP","seq_oa_dep"),
	SysUser("CD23","seq_zp_cyry"),
	Attachment("cao04","seq_xt_rztj"),
	SysRole("FRU02","seq_fru02"),
	SysOrg("CD20","seq_zp_zjbh"),
	SysResource("FRU01","seq_fru01"),
	
	TrainOrg("PX_ORG","seq_px_org"),
	TrainOrgType("PX_ORG_TYPE","seq_px_org_type"),
	TrainCourse("PX_COURSE","seq_px_course"),
	TrainCourseType("PX_COURSE_TYPE","seq_px_course_type"),
	TrainSysSet("PX_SYS_SET","seq_px_sys_set");
	
	private  String tableName ;
	private  String seqName ;
	private SqeIdName(String tableName, String seqName) {
		this.tableName = tableName;
		this.seqName = seqName;
	}
	public String getTableName() {
		return tableName;
	}
	public String getSeqName() {
		return seqName;
	}

}
