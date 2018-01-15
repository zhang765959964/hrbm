package com.xunfeng.business.corp.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.corp.model.Corp;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位基本信息表 Form对象
* @author:wanghan
* @createDate 2015-11-03 14:28:56 
* @version V1.0   
*/
public class CorpForm extends BaseForm<Corp>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 单位编号
	protected Long  aab001;
//	// 社会保险登记证编码
//	protected String  aab002;
//	// 社会保险登记证发证日期
//	protected java.util.Date  aab036;
	// 组织机构代码
	protected String  aab003;
	// 单位名称
	protected String  aab004;
//	// 单位英文名称
//	protected String  aab041;
//	// 单位简称
//	protected String  aab042;
//	// 单位拼音码
//	protected String  aab043;
//	// 单位IC卡号
//	protected String  aab038;
	// 单位性质
	protected String  aab019;
	// 经济类型
	protected String  aab020;
	// 产业类别
	protected String  aab054;
	// 所属行业
	protected String  aab022;
	// 邮政编码
	protected String  aae007;
	// 联系人
	protected String  aae004;
	// 联系电话
	protected String  aae005;
	// 地址
	protected String  aae006;
	// 电子信箱
	protected String  aae015;
	// 网址
	protected String  aae016;
	// 所属地区行政区划代码
	protected String  aab301;
	// 行政区划名称
	protected String  aaa021;
	// 工商登记执照号码
	protected String  aab007;
	// 工商执照起始日期
	protected java.util.Date  aab010;
//	// 工商执照起始日期(详情页面)
//	protected String  aab010n;
	// 工商执照终止日期
	protected java.util.Date  aab011;
//	// 工商执照终止日期(详情页面)
//	protected String  aab011n;
//	// 是否已经发送执照年检提醒(0-未发送1-已发送)
//	protected Long  cabq05;
//	// 组织机构代码或营业执照图片
//	protected String  cabq06;
//	// 网上后台验证是否通过(0-未通过1-已通过)
//	protected Long  cabq07;
//	// 窗口验证是否通过(0-未通过1-手工认证2-设备认证3-公办认证)
//	protected Long  cabq08;
//	// 工商登记执照种类
//	protected String  aab006;
//	// 工商登记发照日期
//	protected java.util.Date  aab008;
	// 隶属关系
	protected String  aab021;
	// 法定代表人
	protected String  aab013;
	// 法定代表人身份证号码
	protected String  aab014;
//	// 法定代表人电话
//	protected String  aab015;
	// 主营范围
	protected String  aab052;
	// 主管部门
	protected String  aab023;
	// 经营方式
	protected String  aab048;
	// 兼营范围
	protected String  aab053;
	// 享受优惠政策单位类型
	protected String  acb101;
//	// 注销标记
//	protected String  aab01d;
	// 备注
	protected String  aae013;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036;
//	// 经办日期(详情页面)
//	protected String  aae036n;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
//	// 注销经办人代码
//	protected String  bae011;
//	// 注销经办机构代码
//	protected String  bae017;
//	// 注销日期
//	protected java.util.Date  bae036;
//	// 注销经办人
//	protected String  bae019;
//	// 注销经办机构
//	protected String  bae020;
//	// 注销经办机构行政区划
//	protected String  bae022;
	// 行业细类
	protected String  aab025;
	// 细类说明
	protected String  aab026;
	// 从业人员总数
	protected Long  aab01e;
	// 其中本市人员
	protected Long  aab01f;
	// 其中外来人员
	protected Long  aab01g;
//	// 单位状态，用作删除标志 1登记在册 2破产 3注销  4被兼并 9其它
//	protected String  aae119;
//	// 用工登记证号
//	protected String  aab039;
//	// 国别代码
//	protected String  aaa130;
//	// 工资基金使用手册编号（用作公司办公地址）
//	protected String  aab040;
//	// 人员规模
//	protected String  aab056;
//	// 主办部门
//	protected String  aab045;
	// 传真
	protected String  bab002;
//	// 批准文号
//	protected String  aab012;
//	// 银行行号
//	protected String  aae008;
//	// 银行户名
//	protected String  aae009;
//	// 银行账号
//	protected String  aae010;
//	// 支付开户银行行号
//	protected String  aab027;
//	// 支付开户户名
//	protected String  aab028;
//	// 支付开户账号
//	protected String  aab029;
//	// 国税税务登记号
//	protected String  aab030;
//	// 国税税务机构编号
//	protected String  aab031;
//	// 国税税务机构名称
//	protected String  aab032;
//	// 国税税务证批准日期
//	protected java.util.Date  aab037;
//	// 地税税务登记号
//	protected String  aab046;
//	// 地税税务机构名称
//	protected String  aab047;
//	// 缴费单位专管员姓名
//	protected String  aab016;
//	// 缴费单位专管员所在部门
//	protected String  aab017;
//	// 缴费单位专管员电话
//	protected String  aab018;
//	// 缴费开户银行行号
//	protected String  aab024;
//	// 缴费方式
//	protected String  aab033;
//	// 缴费周期
//	protected String  aab500;
//	// 社会保险经办机构编码
//	protected String  aab034;
//	// 单位年检情况
//	protected String  aab341;
//	// 单位级别
//	protected String  aab342;
//	// 一级单位编号
//	protected String  aab343;
//	// 用户编号
//	protected Long  ccmu01;
//	// 是否开通地图
//	protected Long  cabq01;
//	// X坐标
//	protected Float  cabq02;
//	// Y坐标
//	protected Float  cabq03;
//	// 缩放比例
//	protected Long  cabq04;
//	// 窗口认证时间
//	protected java.util.Date  cabq09;
//	// 窗口认证到期时间
//	protected java.util.Date  cabq10;
//	// 网上认证时间
//	protected java.util.Date  cabq11;
//	// 网上认证到期时间
//	protected java.util.Date  cabq12;
//	// 是否持卡会员F否T是
//	protected String  cabq13;
//	// 信用等级
//	protected String  cabq14;
//	// 有效期
//	protected java.util.Date  cabq15;
//	// 申请时间
//	protected java.util.Date  cabq16;
//	// 单位简介
//	protected String  acb206;
//	// 乘车路线
//	protected String  acb205;
//	// 单位证件年检期
//	protected java.util.Date  cab011;
	// 数据来源0未知1网站2窗口
	protected String  cczy06;
//	// 会员积分
//	protected Long  cabq17;
//	// 最后修改时间
//	protected java.util.Date  ccpr05;
	// 联系人手机号码
	protected String  aae139;
//	// 注册资金(万元)
//	protected Float  aab049;
//	// 修改人
//	protected String  ccpr06;
//	// 修改来源
//	protected String  ccpr07;
//	// 暂不用使用AAE119
//	protected String  ccpr08;
//	// 是否推荐单位（0-否1-是）
//	protected String  ccpr09;
//	// 自建行业代码
//	protected String  ccpr10;
//	// 本月置顶次数
//	protected Long  ccpr11;
//	// 最后置顶月份2013-01
//	protected String  ccpr12;
//	// 是否用人单位协会会员0-否1-是
//	protected Long  ccpr13;
//	// 联系人身份证号码
//	protected String  bab014;
//	// 联系人职务
//	protected String  bab015;
//	// 卡SN号
//	protected String  cahy12;
//	// 代办人姓名
//	protected String  aab113;
//	// 代办人身份证号码
//	protected String  aab114;
//	// 代办人联系电话
//	protected String  aab115;
//	// 完善标记0-未完善1-已完善2-已合并
//	protected String  ccpr14;
//	// 是否存档0-否1-是
//	protected String  ccpr15;
//	// CCPR16
//	protected String  ccpr16;
//	// 提交高拍仪证件照的地址
//	protected String  ccpr17;
//	// 是否推荐单位（0-否1-是）用于BS专题:网络招聘月
//	protected String  ccpr18;
//	// 用于劳务输出标志 0:非劳务输出单位 1:是劳务输出单位
//	protected String  ccpr19;
//	// 图片是否上传 0:未上传 1:已上传
//	protected String  ccpr20;
//	// 视频是否上传 0:未上传 1:已上传
//	protected String  ccpr21;
//	// 是否境外就业企业 0:否 1:是
//	protected String  ccpr22;
//	// 是否开通即时通信 0:未开通 1:已开通
//	protected String  ccpr23;
//	// 是否开通素质测评 0:未开通 1:已开通
//	protected String  ccpr24;
//	// 是否重点企业 0:否 1:是
//	protected Long  ccpr25;
//	// 是否重点推荐 0:否 1:是
//	protected Long  ccpr26;
//	// 最后修改经办机构
//	protected String  ccpr04;
//	// 单位信息完整度
//	protected Long  ccmu50;
//	// 审核提交自动编号
//	protected Long  caoa01;
//	//审核意见
//	protected String  caoa08;
//	//营业执照扫描地址
//	protected String  caoa02;
//	//法人身份证扫描地址
//	protected String  caoa10;
//	// 审核时间
//	protected java.util.Date  caoa06;
//	// 工商登记执照种类 （名称）
//	protected String  name1;
//	// 公司性质 （名称）
//	protected String  name2;
//	// 经济类型 （名称）
//	protected String  name3;
//	// 行业类型 （名称）
//	protected String  name4;
//	// 人员规模 （名称）
//	protected String  name5;
//	// 单位信息维护页面（根据单位名称或者工商登记号码）查询
//	protected String  nameNumber;
//	// 是否发送短信标志
//	protected String  nodeLogs;
//	// 会员名
//	protected String  ccmu02;
//	// 认证状态
//	protected String  cabq08n;
//	// 来源
//	protected String  eczy06;
//	// 会员卡号
//	protected String  cahy02;
//	// 会员卡号类型
//	protected String  cahy05;
//	// 人才币
//	protected String  ccmu19;
	public Long getAab001() {
		return aab001;
	}
	public void setAab001(Long aab001) {
		this.aab001 = aab001;
	}
	public String getAab003() {
		return aab003;
	}
	public void setAab003(String aab003) {
		this.aab003 = aab003;
	}
	public String getAab004() {
		return aab004;
	}
	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}
	public String getAab019() {
		return aab019;
	}
	public void setAab019(String aab019) {
		this.aab019 = aab019;
	}
	public String getAab020() {
		return aab020;
	}
	public void setAab020(String aab020) {
		this.aab020 = aab020;
	}
	public String getAab054() {
		return aab054;
	}
	public void setAab054(String aab054) {
		this.aab054 = aab054;
	}
	public String getAab022() {
		return aab022;
	}
	public void setAab022(String aab022) {
		this.aab022 = aab022;
	}
	public String getAae007() {
		return aae007;
	}
	public void setAae007(String aae007) {
		this.aae007 = aae007;
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
	public String getAae006() {
		return aae006;
	}
	public void setAae006(String aae006) {
		this.aae006 = aae006;
	}
	public String getAae015() {
		return aae015;
	}
	public void setAae015(String aae015) {
		this.aae015 = aae015;
	}
	public String getAae016() {
		return aae016;
	}
	public void setAae016(String aae016) {
		this.aae016 = aae016;
	}
	public String getAab301() {
		return aab301;
	}
	public void setAab301(String aab301) {
		this.aab301 = aab301;
	}
	public String getAab007() {
		return aab007;
	}
	public void setAab007(String aab007) {
		this.aab007 = aab007;
	}
	public java.util.Date getAab010() {
		return aab010;
	}
	public void setAab010(java.util.Date aab010) {
		this.aab010 = aab010;
	}
	public java.util.Date getAab011() {
		return aab011;
	}
	public void setAab011(java.util.Date aab011) {
		this.aab011 = aab011;
	}
	public String getAab021() {
		return aab021;
	}
	public void setAab021(String aab021) {
		this.aab021 = aab021;
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
	public String getAab052() {
		return aab052;
	}
	public void setAab052(String aab052) {
		this.aab052 = aab052;
	}
	public String getAab023() {
		return aab023;
	}
	public void setAab023(String aab023) {
		this.aab023 = aab023;
	}
	public String getAab048() {
		return aab048;
	}
	public void setAab048(String aab048) {
		this.aab048 = aab048;
	}
	public String getAab053() {
		return aab053;
	}
	public void setAab053(String aab053) {
		this.aab053 = aab053;
	}
	public String getAcb101() {
		return acb101;
	}
	public void setAcb101(String acb101) {
		this.acb101 = acb101;
	}
	public String getAae013() {
		return aae013;
	}
	public void setAae013(String aae013) {
		this.aae013 = aae013;
	}
	public java.util.Date getAae036() {
		return aae036;
	}
	public void setAae036(java.util.Date aae036) {
		this.aae036 = aae036;
	}
	public String getAae019() {
		return aae019;
	}
	public void setAae019(String aae019) {
		this.aae019 = aae019;
	}
	public String getAae020() {
		return aae020;
	}
	public void setAae020(String aae020) {
		this.aae020 = aae020;
	}
	public String getAab025() {
		return aab025;
	}
	public void setAab025(String aab025) {
		this.aab025 = aab025;
	}
	public String getAab026() {
		return aab026;
	}
	public void setAab026(String aab026) {
		this.aab026 = aab026;
	}
	public Long getAab01e() {
		return aab01e;
	}
	public void setAab01e(Long aab01e) {
		this.aab01e = aab01e;
	}
	public Long getAab01f() {
		return aab01f;
	}
	public void setAab01f(Long aab01f) {
		this.aab01f = aab01f;
	}
	public Long getAab01g() {
		return aab01g;
	}
	public void setAab01g(Long aab01g) {
		this.aab01g = aab01g;
	}
	public String getBab002() {
		return bab002;
	}
	public void setBab002(String bab002) {
		this.bab002 = bab002;
	}
	public String getCczy06() {
		return cczy06;
	}
	public void setCczy06(String cczy06) {
		this.cczy06 = cczy06;
	}
	public String getAae011() {
		return aae011;
	}
	public void setAae011(String aae011) {
		this.aae011 = aae011;
	}
	public String getAae017() {
		return aae017;
	}
	public void setAae017(String aae017) {
		this.aae017 = aae017;
	}
	public String getAaa021() {
		return aaa021;
	}
	public void setAaa021(String aaa021) {
		this.aaa021 = aaa021;
	}
	
	

}