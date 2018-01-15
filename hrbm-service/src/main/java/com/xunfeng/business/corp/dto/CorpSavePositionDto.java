package com.xunfeng.business.corp.dto;

import java.io.Serializable;
import java.util.Date;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 招聘空位信息表 Form对象
* @author:jx
* @createDate 2016-04-14 11:31:13
* @version V1.0
*/
public class CorpSavePositionDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 招聘空位编号
	protected Long  acb210;
	// 招聘编号
	protected Long  acb200;
	//单位编号
	private Long aab001;
	//企业名称
	private String aab004;
	//发布名称（*）
	private String bab004;
	//联系人
	private String aae004;
	//联系人手机号码
	private String aae139;
	//联系电话
	private String aae005;
	//单位地址
	private String aab040;
	//乘车路线
	private String acb205;
	private String  aca111;
	private String  aca112;
	//形式工种代码
	private String bca111;
	private String bca112;
	//自定义工种名称(*)
	private String cca113;
	//招聘人数
	private Integer acb21r;
	private Date aae030;
	//p_aae031 varchar2, --终止日期[截止时间]
	private Date aae031;
	//p_aac011 varchar2, --文化程度[学历要求]
	private String aac011;
	//p_acc034 varchar2, --月工资[薪资待遇]
	private String acc034;
	//p_aad004 varchar2, --性别
	private String aad004;
	//	p_acc217 varchar2, --工作年限[工作经验]
	private String acc217;
	//p_acc20t varchar2, --招聘对象[适合人员]
	private String acc20t;
	//	p_acc214 varchar2 default '9', --福利待遇默认为其它福利
	private String acc214;
	//p_acb202 varchar2, --工作地点代码
	private String acb202;
	//	p_acb21i varchar2, --用工形式[工作性质]
	private String acb21i;
	//p_acb228 varchar2, --食宿提供
	private String acb228;
	//p_cca114 varchar2, --岗位描述
	private String cca114;
	//p_acb20q varchar2, --信息发布方式（*）
	private String acb20q;
	//p_aae013 varchar2, --备注     网站传null,手机端调用传数据来源
	private String aae013;

	private String bcb202;
	// 会后是否转委托0-否1-自动转
	protected Long  ccpr09;
	//标识是不是重新发布职位状态
	protected String releaseStatus;
	// 代办人联系电话
	protected String  aab115;
	
	protected Long acb330;
	// 自建行业代码
	protected String  ccpr10;
	
	//cb20 地址
	protected String aae006;
	
	protected String acb206;
	
	
	
	
	public String getAae006() {
		return aae006;
	}

	public void setAae006(String aae006) {
		this.aae006 = aae006;
	}

	public String getAcb206() {
		return acb206;
	}

	public void setAcb206(String acb206) {
		this.acb206 = acb206;
	}

	public String getCcpr10() {
		return ccpr10;
	}

	public void setCcpr10(String ccpr10) {
		this.ccpr10 = ccpr10;
	}

	public Long getAcb330() {
		return acb330;
	}

	public void setAcb330(Long acb330) {
		this.acb330 = acb330;
	}

	public String getAab115() {
		return aab115;
	}

	public void setAab115(String aab115) {
		this.aab115 = aab115;
	}

	public String getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	public String getAab040() {
		return aab040;
	}

	public void setAab040(String aab040) {
		this.aab040 = aab040;
	}

	public String getAac011() {
		return aac011;
	}

	public void setAac011(String aac011) {
		this.aac011 = aac011;
	}

	public String getAad004() {
		return aad004;
	}

	public void setAad004(String aad004) {
		this.aad004 = aad004;
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

	public String getAae013() {
		return aae013;
	}

	public void setAae013(String aae013) {
		this.aae013 = aae013;
	}

	public Date getAae031() {
		return aae031;
	}

	public void setAae031(Date aae031) {
		this.aae031 = aae031;
	}

	public String getAae139() {
		return aae139;
	}

	public void setAae139(String aae139) {
		this.aae139 = aae139;
	}

	public String getAcb202() {
		return acb202;
	}

	public void setAcb202(String acb202) {
		this.acb202 = acb202;
	}

	public String getAcb205() {
		return acb205;
	}

	public void setAcb205(String acb205) {
		this.acb205 = acb205;
	}

	public String getAcb20q() {
		return acb20q;
	}

	public void setAcb20q(String acb20q) {
		this.acb20q = acb20q;
	}

	public String getAcb21i() {
		return acb21i;
	}

	public void setAcb21i(String acb21i) {
		this.acb21i = acb21i;
	}

	public Integer getAcb21r() {
		return acb21r;
	}

	public void setAcb21r(Integer acb21r) {
		this.acb21r = acb21r;
	}

	public String getAcb228() {
		return acb228;
	}

	public void setAcb228(String acb228) {
		this.acb228 = acb228;
	}

	public String getAcc034() {
		return acc034;
	}

	public void setAcc034(String acc034) {
		this.acc034 = acc034;
	}

	public String getAcc20t() {
		return acc20t;
	}

	public void setAcc20t(String acc20t) {
		this.acc20t = acc20t;
	}

	public String getAcc214() {
		return acc214;
	}

	public void setAcc214(String acc214) {
		this.acc214 = acc214;
	}

	public String getAcc217() {
		return acc217;
	}

	public void setAcc217(String acc217) {
		this.acc217 = acc217;
	}

	public String getBca111() {
		return bca111;
	}

	public void setBca111(String bca111) {
		this.bca111 = bca111;
	}

	public String getCca113() {
		return cca113;
	}

	public void setCca113(String cca113) {
		this.cca113 = cca113;
	}

	public String getCca114() {
		return cca114;
	}

	public void setCca114(String cca114) {
		this.cca114 = cca114;
	}

	public Long getAab001() {
		return aab001;
	}

	public void setAab001(Long aab001) {
		this.aab001 = aab001;
	}

	public String getBab004() {
		return bab004;
	}

	public void setBab004(String bab004) {
		this.bab004 = bab004;
	}

	public Long getAcb210() {
		return acb210;
	}

	public void setAcb210(Long acb210) {
		this.acb210 = acb210;
	}

	public Long getAcb200() {
		return acb200;
	}

	public void setAcb200(Long acb200) {
		this.acb200 = acb200;
	}

	public String getAab004() {
		return aab004;
	}

	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}

	public String getAca111() {
		return aca111;
	}

	public void setAca111(String aca111) {
		this.aca111 = aca111;
	}

	public String getBca112() {
		return bca112;
	}

	public void setBca112(String bca112) {
		this.bca112 = bca112;
	}

	public String getAca112() {
		return aca112;
	}

	public void setAca112(String aca112) {
		this.aca112 = aca112;
	}

	public String getBcb202() {
		return bcb202;
	}

	public void setBcb202(String bcb202) {
		this.bcb202 = bcb202;
	}

	public Long getCcpr09() {
		return ccpr09;
	}

	public void setCcpr09(Long ccpr09) {
		this.ccpr09 = ccpr09;
	}

	public Date getAae030() {
		return aae030;
	}

	public void setAae030(Date aae030) {
		this.aae030 = aae030;
	}
	
}