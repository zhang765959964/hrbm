package com.xunfeng.sys.attachment.dto;

import com.xunfeng.core.model.BaseModel;


/*
 * 企业认证  蒋鑫  2015.11.10
 */
public class CorpAttachmentDto extends BaseModel {
	// 单位编号
	protected Long  aab001;
	// 单位名称
	protected String  aab004;
	// 工商登记执照种类
	protected String  aab006;
	// 工商登记执照号码
	protected String  aab007;
	// 人员规模
	protected String  aab056;
	// 工商登记发照日期
	protected java.util.Date  aab008;
	// 法定代表人
	protected String  aab013;
	// 法定代表人身份证号码
	protected String  aab014;
	// 法定代表人电话
	protected String  aab015;
	// 单位简介
	protected String  acb206;
	// 乘车路线
	protected String  acb205;
	// 地址
	protected String  aae006;
	//工伤登记执照种类名字
	protected String zhengJianName;
	// 用户编号
	protected Long  ccmu01;
	// 窗口验证是否通过(0-未通过1-手工认证2-设备认证3-公办认证)
	protected Long  cabq08;
	
	//网上认证提交信息表
	// 认证提交自动编号
	protected Long  caoa01;
	// 提交营业执照扫描件的地址
	protected String  caoa02;
	// 说明文字
	protected String  caoa03;
	// 证件类型(1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频)
	protected Long  caoa04;
	// 提交时间
	protected java.util.Date  caoa05;
	// 从业人员编号
	protected Long  acd230;
	// 处理认证日期
	protected java.util.Date  caoa06;
	// 是否通过认证(0-未审核1-审核已通过2-审核失败3-退回资料4-自动审核)
	protected Long  caoa07;
	// 认证意见备注
	protected String  caoa08;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 数据来源1网站3民营职介4-公办职介
	protected String  cczy06;
	// 是否已经上传(0-未上传1-已上传)
	protected Long  caoa09;
	// 提交法人身份证扫描件的地址
	protected String  caoa10;
	
	
	public Long getCabq08() {
		return cabq08;
	}
	public void setCabq08(Long cabq08) {
		this.cabq08 = cabq08;
	}
	public Long getAab001() {
		return aab001;
	}
	public void setAab001(Long aab001) {
		this.aab001 = aab001;
	}
	public String getAab004() {
		return aab004;
	}
	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}
	public String getAab006() {
		return aab006;
	}
	public void setAab006(String aab006) {
		this.aab006 = aab006;
	}
	public String getAab007() {
		return aab007;
	}
	public void setAab007(String aab007) {
		this.aab007 = aab007;
	}
	public String getAab056() {
		return aab056;
	}
	public void setAab056(String aab056) {
		this.aab056 = aab056;
	}
	public java.util.Date getAab008() {
		return aab008;
	}
	public void setAab008(java.util.Date aab008) {
		this.aab008 = aab008;
	}
	public String getAab013() {
		return aab013;
	}
	public void setAab013(String aab013) {
		this.aab013 = aab013;
	}
	public String getAab014() {
		return aab014;
	}
	public void setAab014(String aab014) {
		this.aab014 = aab014;
	}
	public String getAab015() {
		return aab015;
	}
	public void setAab015(String aab015) {
		this.aab015 = aab015;
	}
	public String getAcb206() {
		return acb206;
	}
	public void setAcb206(String acb206) {
		this.acb206 = acb206;
	}
	public String getAcb205() {
		return acb205;
	}
	public void setAcb205(String acb205) {
		this.acb205 = acb205;
	}
	public Long getCaoa01() {
		return caoa01;
	}
	public void setCaoa01(Long caoa01) {
		this.caoa01 = caoa01;
	}
	public Long getCcmu01() {
		return ccmu01;
	}
	public void setCcmu01(Long ccmu01) {
		this.ccmu01 = ccmu01;
	}
	public String getCaoa02() {
		return caoa02;
	}
	public void setCaoa02(String caoa02) {
		this.caoa02 = caoa02;
	}
	public String getCaoa03() {
		return caoa03;
	}
	public void setCaoa03(String caoa03) {
		this.caoa03 = caoa03;
	}
	public Long getCaoa04() {
		return caoa04;
	}
	public void setCaoa04(Long caoa04) {
		this.caoa04 = caoa04;
	}
	public java.util.Date getCaoa05() {
		return caoa05;
	}
	public void setCaoa05(java.util.Date caoa05) {
		this.caoa05 = caoa05;
	}
	public Long getAcd230() {
		return acd230;
	}
	public void setAcd230(Long acd230) {
		this.acd230 = acd230;
	}
	public java.util.Date getCaoa06() {
		return caoa06;
	}
	public void setCaoa06(java.util.Date caoa06) {
		this.caoa06 = caoa06;
	}
	public Long getCaoa07() {
		return caoa07;
	}
	public void setCaoa07(Long caoa07) {
		this.caoa07 = caoa07;
	}
	public String getCaoa08() {
		return caoa08;
	}
	public void setCaoa08(String caoa08) {
		this.caoa08 = caoa08;
	}
	public String getCcpr08() {
		return ccpr08;
	}
	public void setCcpr08(String ccpr08) {
		this.ccpr08 = ccpr08;
	}
	public String getCczy06() {
		return cczy06;
	}
	public void setCczy06(String cczy06) {
		this.cczy06 = cczy06;
	}
	public Long getCaoa09() {
		return caoa09;
	}
	public void setCaoa09(Long caoa09) {
		this.caoa09 = caoa09;
	}
	public String getCaoa10() {
		return caoa10;
	}
	public void setCaoa10(String caoa10) {
		this.caoa10 = caoa10;
	}
	public String getAae006() {
		return aae006;
	}
	public void setAae006(String aae006) {
		this.aae006 = aae006;
	}
	public String getZhengJianName() {
		return zhengJianName;
	}
	public void setZhengJianName(String zhengJianName) {
		this.zhengJianName = zhengJianName;
	}
	
}
