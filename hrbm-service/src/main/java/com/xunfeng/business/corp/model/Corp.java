package com.xunfeng.business.corp.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 对象功能:单位基本信息表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 10:55:12
 */
public class Corp extends BaseModel
{
	// 单位编号
	protected Long  aab001;
	// 社会保险登记证编码
	protected String  aab002;
	// 社会保险登记证发证日期
	protected java.util.Date  aab036;
	// 组织机构代码
	protected String  aab003;
	// 单位名称
	protected String  aab004;
	// 单位英文名称
	protected String  aab041;
	// 单位简称
	protected String  aab042;
	// 单位拼音码
	protected String  aab043;
	// 单位IC卡号
	protected String  aab038;
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
	// 工商执照终止日期
	protected java.util.Date  aab011;
	// 是否已经发送执照年检提醒(0-未发送1-已发送)
	protected Long  cabq05;
	// 组织机构代码或营业执照图片
	protected String  cabq06;
	// 网上后台验证是否通过(0-未通过1-已通过)
	protected Long  cabq07;
	// 窗口验证是否通过(0-未通过1-手工认证2-设备认证3-公办认证)
	protected Long  cabq08;
	// 工商登记执照种类
	protected String  aab006;
	// 工商登记发照日期
	protected java.util.Date  aab008;
	// 隶属关系
	protected String  aab021;
	// 法定代表人
	protected String  aab013;
	// 法定代表人身份证号码
	protected String  aab014;
	// 法定代表人电话
	protected String  aab015;
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
	// 注销标记
	protected String  aab01d;
	// 备注
	protected String  aae013;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	// 注销经办人代码
	protected String  bae011;
	// 注销经办机构代码
	protected String  bae017;
	// 注销日期
	protected java.util.Date  bae036;
	// 注销经办人
	protected String  bae019;
	// 注销经办机构
	protected String  bae020;
	// 注销经办机构行政区划
	protected String  bae022;
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
	// 单位状态，用作删除标志1	登记在册2	破产3	注销4	被兼并9	其它

	protected String  aae119;
	// 用工登记证号
	protected String  aab039;
	// 国别代码
	protected String  aaa130;
	// 工资基金使用手册编号（用作公司办公地址）
	protected String  aab040;
	// 人员规模
	protected String  aab056;
	// 主办部门
	protected String  aab045;
	// 传真
	protected String  bab002;
	// 批准文号
	protected String  aab012;
	// 银行行号
	protected String  aae008;
	// 银行户名
	protected String  aae009;
	// 银行账号
	protected String  aae010;
	// 支付开户银行行号
	protected String  aab027;
	// 支付开户户名
	protected String  aab028;
	// 支付开户账号
	protected String  aab029;
	// 国税税务登记号
	protected String  aab030;
	// 国税税务机构编号
	protected String  aab031;
	// 国税税务机构名称
	protected String  aab032;
	// 国税税务证批准日期
	protected java.util.Date  aab037;
	// 地税税务登记号
	protected String  aab046;
	// 地税税务机构名称
	protected String  aab047;
	// 缴费单位专管员姓名
	protected String  aab016;
	// 缴费单位专管员所在部门
	protected String  aab017;
	// 缴费单位专管员电话
	protected String  aab018;
	// 缴费开户银行行号
	protected String  aab024;
	// 缴费方式
	protected String  aab033;
	// 缴费周期
	protected String  aab500;
	// 社会保险经办机构编码
	protected String  aab034;
	// 单位年检情况
	protected String  aab341;
	// 单位级别
	protected String  aab342;
	// 一级单位编号
	protected String  aab343;
	// 用户编号
	protected Long  ccmu01;
	// 是否开通地图
	protected Long  cabq01;
	// X坐标
	protected Float  cabq02;
	// Y坐标
	protected Float  cabq03;
	// 缩放比例
	protected Long  cabq04;
	// 窗口认证时间
	protected java.util.Date  cabq09;
	// 窗口认证到期时间
	protected java.util.Date  cabq10;
	// 网上认证时间
	protected java.util.Date  cabq11;
	// 网上认证到期时间
	protected java.util.Date  cabq12;
	// 是否持卡会员F否T是
	protected String  cabq13;
	// 信用等级
	protected String  cabq14;
	// 有效期
	protected java.util.Date  cabq15;
	// 申请时间
	protected java.util.Date  cabq16;
	// 单位简介
	protected String  acb206;
	// 乘车路线
	protected String  acb205;
	// 单位证件年检期
	protected java.util.Date  cab011;
	// 数据来源0未知1网站2窗口
	protected String  cczy06;
	// 会员积分
	protected Long  cabq17;
	// 最后修改时间
	protected java.util.Date  ccpr05;
	// 联系人手机号码
	protected String  aae139;
	// 注册资金(万元)
	protected Float  aab049;
	// 修改人
	protected String  ccpr06;
	// 修改来源
	protected String  ccpr07;
	// 暂不用使用AAE119
	protected String  ccpr08;
	// 是否推荐单位（0-否1-是）
	protected String  ccpr09;
	// 自建行业代码
	protected String  ccpr10;
	// 本月置顶次数
	protected Long  ccpr11;
	// 最后置顶月份2013-01
	protected String  ccpr12;
	// 是否用人单位协会会员0-否1-是

	protected Long  ccpr13;
	// 联系人身份证号码
	protected String  bab014;
	// 联系人职务
	protected String  bab015;
	// 卡SN号
	protected String  cahy12;
	// 代办人姓名
	protected String  aab113;
	// 代办人身份证号码
	protected String  aab114;
	// 代办人联系电话
	protected String  aab115;
	// 完善标记0-未完善1-已完善2-已合并
	protected String  ccpr14;
	// 是否存档0-否1-是
	protected String  ccpr15;
	// CCPR16
	protected String  ccpr16;
	// 提交高拍仪证件照的地址
	protected String  ccpr17;
	// 是否推荐单位（0-否1-是）用于BS专题:网络招聘月
	protected String  ccpr18;
	// 用于劳务输出标志 0:非劳务输出单位 1:是劳务输出单位
	protected String  ccpr19;
	// 图片是否上传 0:未上传 1:已上传
	protected String  ccpr20;
	// 视频是否上传 0:未上传 1:已上传
	protected String  ccpr21;
	// 是否境外就业企业 0:否 1:是
	protected String  ccpr22;
	// 是否开通即时通信 0:未开通 1:已开通
	protected String  ccpr23;
	// 是否开通素质测评 0:未开通 1:已开通
	protected String  ccpr24;


	public void setAab001(Long aab001)
	{
		this.aab001 = aab001;
	}
	/**
	 * 返回 单位编号
	 * @return
	 */
	public Long getAab001() 
	{
		return this.aab001;
	}
	public void setAab002(String aab002) 
	{
		this.aab002 = aab002;
	}
	/**
	 * 返回 社会保险登记证编码
	 * @return
	 */
	public String getAab002() 
	{
		return this.aab002;
	}
	public void setAab036(java.util.Date aab036) 
	{
		this.aab036 = aab036;
	}
	/**
	 * 返回 社会保险登记证发证日期
	 * @return
	 */
	public java.util.Date getAab036() 
	{
		return this.aab036;
	}
	public void setAab003(String aab003) 
	{
		this.aab003 = aab003;
	}
	/**
	 * 返回 组织机构代码
	 * @return
	 */
	public String getAab003() 
	{
		return this.aab003;
	}
	public void setAab004(String aab004) 
	{
		this.aab004 = aab004;
	}
	/**
	 * 返回 单位名称
	 * @return
	 */
	public String getAab004() 
	{
		return this.aab004;
	}
	public void setAab041(String aab041) 
	{
		this.aab041 = aab041;
	}
	/**
	 * 返回 单位英文名称
	 * @return
	 */
	public String getAab041() 
	{
		return this.aab041;
	}
	public void setAab042(String aab042) 
	{
		this.aab042 = aab042;
	}
	/**
	 * 返回 单位简称
	 * @return
	 */
	public String getAab042() 
	{
		return this.aab042;
	}
	public void setAab043(String aab043) 
	{
		this.aab043 = aab043;
	}
	/**
	 * 返回 单位拼音码
	 * @return
	 */
	public String getAab043() 
	{
		return this.aab043;
	}
	public void setAab038(String aab038) 
	{
		this.aab038 = aab038;
	}
	/**
	 * 返回 单位IC卡号
	 * @return
	 */
	public String getAab038() 
	{
		return this.aab038;
	}
	public void setAab019(String aab019) 
	{
		this.aab019 = aab019;
	}
	/**
	 * 返回 单位性质
	 * @return
	 */
	public String getAab019() 
	{
		return this.aab019;
	}
	public void setAab020(String aab020) 
	{
		this.aab020 = aab020;
	}
	/**
	 * 返回 经济类型
	 * @return
	 */
	public String getAab020() 
	{
		return this.aab020;
	}
	public void setAab054(String aab054) 
	{
		this.aab054 = aab054;
	}
	/**
	 * 返回 产业类别
	 * @return
	 */
	public String getAab054() 
	{
		return this.aab054;
	}
	public void setAab022(String aab022) 
	{
		this.aab022 = aab022;
	}
	/**
	 * 返回 所属行业
	 * @return
	 */
	public String getAab022() 
	{
		return this.aab022;
	}
	public void setAae007(String aae007) 
	{
		this.aae007 = aae007;
	}
	/**
	 * 返回 邮政编码
	 * @return
	 */
	public String getAae007() 
	{
		return this.aae007;
	}
	public void setAae004(String aae004) 
	{
		this.aae004 = aae004;
	}
	/**
	 * 返回 联系人
	 * @return
	 */
	public String getAae004() 
	{
		return this.aae004;
	}
	public void setAae005(String aae005) 
	{
		this.aae005 = aae005;
	}
	/**
	 * 返回 联系电话
	 * @return
	 */
	public String getAae005() 
	{
		return this.aae005;
	}
	public void setAae006(String aae006) 
	{
		this.aae006 = aae006;
	}
	/**
	 * 返回 地址
	 * @return
	 */
	public String getAae006() 
	{
		return this.aae006;
	}
	public void setAae015(String aae015) 
	{
		this.aae015 = aae015;
	}
	/**
	 * 返回 电子信箱
	 * @return
	 */
	public String getAae015() 
	{
		return this.aae015;
	}
	public void setAae016(String aae016) 
	{
		this.aae016 = aae016;
	}
	/**
	 * 返回 网址
	 * @return
	 */
	public String getAae016() 
	{
		return this.aae016;
	}
	public void setAab301(String aab301) 
	{
		this.aab301 = aab301;
	}
	/**
	 * 返回 所属地区行政区划代码
	 * @return
	 */
	public String getAab301() 
	{
		return this.aab301;
	}
	public void setAaa021(String aaa021) 
	{
		this.aaa021 = aaa021;
	}
	/**
	 * 返回 行政区划名称
	 * @return
	 */
	public String getAaa021() 
	{
		return this.aaa021;
	}
	public void setAab007(String aab007) 
	{
		this.aab007 = aab007;
	}
	/**
	 * 返回 工商登记执照号码
	 * @return
	 */
	public String getAab007() 
	{
		return this.aab007;
	}
	public void setAab010(java.util.Date aab010) 
	{
		this.aab010 = aab010;
	}
	/**
	 * 返回 工商执照起始日期
	 * @return
	 */
	public java.util.Date getAab010() 
	{
		return this.aab010;
	}
	public void setAab011(java.util.Date aab011) 
	{
		this.aab011 = aab011;
	}
	/**
	 * 返回 工商执照终止日期
	 * @return
	 */
	public java.util.Date getAab011() 
	{
		return this.aab011;
	}
	public void setCabq05(Long cabq05) 
	{
		this.cabq05 = cabq05;
	}
	/**
	 * 返回 是否已经发送执照年检提醒(0-未发送1-已发送)
	 * @return
	 */
	public Long getCabq05() 
	{
		return this.cabq05;
	}
	public void setCabq06(String cabq06) 
	{
		this.cabq06 = cabq06;
	}
	/**
	 * 返回 组织机构代码或营业执照图片
	 * @return
	 */
	public String getCabq06() 
	{
		return this.cabq06;
	}
	public void setCabq07(Long cabq07) 
	{
		this.cabq07 = cabq07;
	}
	/**
	 * 返回 网上后台验证是否通过(0-未通过1-已通过)
	 * @return
	 */
	public Long getCabq07() 
	{
		return this.cabq07;
	}
	public void setCabq08(Long cabq08) 
	{
		this.cabq08 = cabq08;
	}
	/**
	 * 返回 窗口验证是否通过(0-未通过1-手工认证2-设备认证3-公办认证)
	 * @return
	 */
	public Long getCabq08() 
	{
		return this.cabq08;
	}
	public void setAab006(String aab006) 
	{
		this.aab006 = aab006;
	}
	/**
	 * 返回 工商登记执照种类
	 * @return
	 */
	public String getAab006() 
	{
		return this.aab006;
	}
	public void setAab008(java.util.Date aab008) 
	{
		this.aab008 = aab008;
	}
	/**
	 * 返回 工商登记发照日期
	 * @return
	 */
	public java.util.Date getAab008() 
	{
		return this.aab008;
	}
	public void setAab021(String aab021) 
	{
		this.aab021 = aab021;
	}
	/**
	 * 返回 隶属关系
	 * @return
	 */
	public String getAab021() 
	{
		return this.aab021;
	}
	public void setAab013(String aab013) 
	{
		this.aab013 = aab013;
	}
	/**
	 * 返回 法定代表人
	 * @return
	 */
	public String getAab013() 
	{
		return this.aab013;
	}
	public void setAab014(String aab014) 
	{
		this.aab014 = aab014;
	}
	/**
	 * 返回 法定代表人身份证号码
	 * @return
	 */
	public String getAab014() 
	{
		return this.aab014;
	}
	public void setAab015(String aab015) 
	{
		this.aab015 = aab015;
	}
	/**
	 * 返回 法定代表人电话
	 * @return
	 */
	public String getAab015() 
	{
		return this.aab015;
	}
	public void setAab052(String aab052) 
	{
		this.aab052 = aab052;
	}
	/**
	 * 返回 主营范围
	 * @return
	 */
	public String getAab052() 
	{
		return this.aab052;
	}
	public void setAab023(String aab023) 
	{
		this.aab023 = aab023;
	}
	/**
	 * 返回 主管部门
	 * @return
	 */
	public String getAab023() 
	{
		return this.aab023;
	}
	public void setAab048(String aab048) 
	{
		this.aab048 = aab048;
	}
	/**
	 * 返回 经营方式
	 * @return
	 */
	public String getAab048() 
	{
		return this.aab048;
	}
	public void setAab053(String aab053) 
	{
		this.aab053 = aab053;
	}
	/**
	 * 返回 兼营范围
	 * @return
	 */
	public String getAab053() 
	{
		return this.aab053;
	}
	public void setAcb101(String acb101) 
	{
		this.acb101 = acb101;
	}
	/**
	 * 返回 享受优惠政策单位类型
	 * @return
	 */
	public String getAcb101() 
	{
		return this.acb101;
	}
	public void setAab01d(String aab01d) 
	{
		this.aab01d = aab01d;
	}
	/**
	 * 返回 注销标记
	 * @return
	 */
	public String getAab01d() 
	{
		return this.aab01d;
	}
	public void setAae013(String aae013) 
	{
		this.aae013 = aae013;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getAae013() 
	{
		return this.aae013;
	}
	public void setAae011(String aae011) 
	{
		this.aae011 = aae011;
	}
	/**
	 * 返回 经办人代码
	 * @return
	 */
	public String getAae011() 
	{
		return this.aae011;
	}
	public void setAae017(String aae017) 
	{
		this.aae017 = aae017;
	}
	/**
	 * 返回 经办机构代码
	 * @return
	 */
	public String getAae017() 
	{
		return this.aae017;
	}
	public void setAae036(java.util.Date aae036) 
	{
		this.aae036 = aae036;
	}
	/**
	 * 返回 经办日期
	 * @return
	 */
	public java.util.Date getAae036() 
	{
		return this.aae036;
	}
	public void setAae019(String aae019) 
	{
		this.aae019 = aae019;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public String getAae019() 
	{
		return this.aae019;
	}
	public void setAae020(String aae020) 
	{
		this.aae020 = aae020;
	}
	/**
	 * 返回 经办机构
	 * @return
	 */
	public String getAae020() 
	{
		return this.aae020;
	}
	public void setBae011(String bae011) 
	{
		this.bae011 = bae011;
	}
	/**
	 * 返回 注销经办人代码
	 * @return
	 */
	public String getBae011() 
	{
		return this.bae011;
	}
	public void setBae017(String bae017) 
	{
		this.bae017 = bae017;
	}
	/**
	 * 返回 注销经办机构代码
	 * @return
	 */
	public String getBae017() 
	{
		return this.bae017;
	}
	public void setBae036(java.util.Date bae036) 
	{
		this.bae036 = bae036;
	}
	/**
	 * 返回 注销日期
	 * @return
	 */
	public java.util.Date getBae036() 
	{
		return this.bae036;
	}
	public void setBae019(String bae019) 
	{
		this.bae019 = bae019;
	}
	/**
	 * 返回 注销经办人
	 * @return
	 */
	public String getBae019() 
	{
		return this.bae019;
	}
	public void setBae020(String bae020) 
	{
		this.bae020 = bae020;
	}
	/**
	 * 返回 注销经办机构
	 * @return
	 */
	public String getBae020() 
	{
		return this.bae020;
	}
	public void setBae022(String bae022) 
	{
		this.bae022 = bae022;
	}
	/**
	 * 返回 注销经办机构行政区划
	 * @return
	 */
	public String getBae022() 
	{
		return this.bae022;
	}
	public void setAab025(String aab025) 
	{
		this.aab025 = aab025;
	}
	/**
	 * 返回 行业细类
	 * @return
	 */
	public String getAab025() 
	{
		return this.aab025;
	}
	public void setAab026(String aab026) 
	{
		this.aab026 = aab026;
	}
	/**
	 * 返回 细类说明
	 * @return
	 */
	public String getAab026() 
	{
		return this.aab026;
	}
	public void setAab01e(Long aab01e) 
	{
		this.aab01e = aab01e;
	}
	/**
	 * 返回 从业人员总数
	 * @return
	 */
	public Long getAab01e() 
	{
		return this.aab01e;
	}
	public void setAab01f(Long aab01f) 
	{
		this.aab01f = aab01f;
	}
	/**
	 * 返回 其中本市人员
	 * @return
	 */
	public Long getAab01f() 
	{
		return this.aab01f;
	}
	public void setAab01g(Long aab01g) 
	{
		this.aab01g = aab01g;
	}
	/**
	 * 返回 其中外来人员
	 * @return
	 */
	public Long getAab01g() 
	{
		return this.aab01g;
	}
	public void setAae119(String aae119) 
	{
		this.aae119 = aae119;
	}
	/**
	 * 返回 单位状态，用作删除标志1	登记在册
2	破产
3	注销
4	被兼并
9	其它

	 * @return
	 */
	public String getAae119() 
	{
		return this.aae119;
	}
	public void setAab039(String aab039) 
	{
		this.aab039 = aab039;
	}
	/**
	 * 返回 用工登记证号
	 * @return
	 */
	public String getAab039() 
	{
		return this.aab039;
	}
	public void setAaa130(String aaa130) 
	{
		this.aaa130 = aaa130;
	}
	/**
	 * 返回 国别代码
	 * @return
	 */
	public String getAaa130() 
	{
		return this.aaa130;
	}
	public void setAab040(String aab040) 
	{
		this.aab040 = aab040;
	}
	/**
	 * 返回 工资基金使用手册编号（用作公司办公地址）
	 * @return
	 */
	public String getAab040() 
	{
		return this.aab040;
	}
	public void setAab056(String aab056) 
	{
		this.aab056 = aab056;
	}
	/**
	 * 返回 人员规模
	 * @return
	 */
	public String getAab056() 
	{
		return this.aab056;
	}
	public void setAab045(String aab045) 
	{
		this.aab045 = aab045;
	}
	/**
	 * 返回 主办部门
	 * @return
	 */
	public String getAab045() 
	{
		return this.aab045;
	}
	public void setBab002(String bab002) 
	{
		this.bab002 = bab002;
	}
	/**
	 * 返回 传真
	 * @return
	 */
	public String getBab002() 
	{
		return this.bab002;
	}
	public void setAab012(String aab012) 
	{
		this.aab012 = aab012;
	}
	/**
	 * 返回 批准文号
	 * @return
	 */
	public String getAab012() 
	{
		return this.aab012;
	}
	public void setAae008(String aae008) 
	{
		this.aae008 = aae008;
	}
	/**
	 * 返回 银行行号
	 * @return
	 */
	public String getAae008() 
	{
		return this.aae008;
	}
	public void setAae009(String aae009) 
	{
		this.aae009 = aae009;
	}
	/**
	 * 返回 银行户名
	 * @return
	 */
	public String getAae009() 
	{
		return this.aae009;
	}
	public void setAae010(String aae010) 
	{
		this.aae010 = aae010;
	}
	/**
	 * 返回 银行账号
	 * @return
	 */
	public String getAae010() 
	{
		return this.aae010;
	}
	public void setAab027(String aab027) 
	{
		this.aab027 = aab027;
	}
	/**
	 * 返回 支付开户银行行号
	 * @return
	 */
	public String getAab027() 
	{
		return this.aab027;
	}
	public void setAab028(String aab028) 
	{
		this.aab028 = aab028;
	}
	/**
	 * 返回 支付开户户名
	 * @return
	 */
	public String getAab028() 
	{
		return this.aab028;
	}
	public void setAab029(String aab029) 
	{
		this.aab029 = aab029;
	}
	/**
	 * 返回 支付开户账号
	 * @return
	 */
	public String getAab029() 
	{
		return this.aab029;
	}
	public void setAab030(String aab030) 
	{
		this.aab030 = aab030;
	}
	/**
	 * 返回 国税税务登记号
	 * @return
	 */
	public String getAab030() 
	{
		return this.aab030;
	}
	public void setAab031(String aab031) 
	{
		this.aab031 = aab031;
	}
	/**
	 * 返回 国税税务机构编号
	 * @return
	 */
	public String getAab031() 
	{
		return this.aab031;
	}
	public void setAab032(String aab032) 
	{
		this.aab032 = aab032;
	}
	/**
	 * 返回 国税税务机构名称
	 * @return
	 */
	public String getAab032() 
	{
		return this.aab032;
	}
	public void setAab037(java.util.Date aab037) 
	{
		this.aab037 = aab037;
	}
	/**
	 * 返回 国税税务证批准日期
	 * @return
	 */
	public java.util.Date getAab037() 
	{
		return this.aab037;
	}
	public void setAab046(String aab046) 
	{
		this.aab046 = aab046;
	}
	/**
	 * 返回 地税税务登记号
	 * @return
	 */
	public String getAab046() 
	{
		return this.aab046;
	}
	public void setAab047(String aab047) 
	{
		this.aab047 = aab047;
	}
	/**
	 * 返回 地税税务机构名称
	 * @return
	 */
	public String getAab047() 
	{
		return this.aab047;
	}
	public void setAab016(String aab016) 
	{
		this.aab016 = aab016;
	}
	/**
	 * 返回 缴费单位专管员姓名
	 * @return
	 */
	public String getAab016() 
	{
		return this.aab016;
	}
	public void setAab017(String aab017) 
	{
		this.aab017 = aab017;
	}
	/**
	 * 返回 缴费单位专管员所在部门
	 * @return
	 */
	public String getAab017() 
	{
		return this.aab017;
	}
	public void setAab018(String aab018) 
	{
		this.aab018 = aab018;
	}
	/**
	 * 返回 缴费单位专管员电话
	 * @return
	 */
	public String getAab018() 
	{
		return this.aab018;
	}
	public void setAab024(String aab024) 
	{
		this.aab024 = aab024;
	}
	/**
	 * 返回 缴费开户银行行号
	 * @return
	 */
	public String getAab024() 
	{
		return this.aab024;
	}
	public void setAab033(String aab033) 
	{
		this.aab033 = aab033;
	}
	/**
	 * 返回 缴费方式
	 * @return
	 */
	public String getAab033() 
	{
		return this.aab033;
	}
	public void setAab500(String aab500) 
	{
		this.aab500 = aab500;
	}
	/**
	 * 返回 缴费周期
	 * @return
	 */
	public String getAab500() 
	{
		return this.aab500;
	}
	public void setAab034(String aab034) 
	{
		this.aab034 = aab034;
	}
	/**
	 * 返回 社会保险经办机构编码
	 * @return
	 */
	public String getAab034() 
	{
		return this.aab034;
	}
	public void setAab341(String aab341) 
	{
		this.aab341 = aab341;
	}
	/**
	 * 返回 单位年检情况
	 * @return
	 */
	public String getAab341() 
	{
		return this.aab341;
	}
	public void setAab342(String aab342) 
	{
		this.aab342 = aab342;
	}
	/**
	 * 返回 单位级别
	 * @return
	 */
	public String getAab342() 
	{
		return this.aab342;
	}
	public void setAab343(String aab343) 
	{
		this.aab343 = aab343;
	}
	/**
	 * 返回 一级单位编号
	 * @return
	 */
	public String getAab343() 
	{
		return this.aab343;
	}
	public void setCcmu01(Long ccmu01) 
	{
		this.ccmu01 = ccmu01;
	}
	/**
	 * 返回 用户编号
	 * @return
	 */
	public Long getCcmu01() 
	{
		return this.ccmu01;
	}
	public void setCabq01(Long cabq01) 
	{
		this.cabq01 = cabq01;
	}
	/**
	 * 返回 是否开通地图
	 * @return
	 */
	public Long getCabq01() 
	{
		return this.cabq01;
	}
	public void setCabq02(Float cabq02) 
	{
		this.cabq02 = cabq02;
	}
	/**
	 * 返回 X坐标
	 * @return
	 */
	public Float getCabq02() 
	{
		return this.cabq02;
	}
	public void setCabq03(Float cabq03) 
	{
		this.cabq03 = cabq03;
	}
	/**
	 * 返回 Y坐标
	 * @return
	 */
	public Float getCabq03() 
	{
		return this.cabq03;
	}
	public void setCabq04(Long cabq04) 
	{
		this.cabq04 = cabq04;
	}
	/**
	 * 返回 缩放比例
	 * @return
	 */
	public Long getCabq04() 
	{
		return this.cabq04;
	}
	public void setCabq09(java.util.Date cabq09) 
	{
		this.cabq09 = cabq09;
	}
	/**
	 * 返回 窗口认证时间
	 * @return
	 */
	public java.util.Date getCabq09() 
	{
		return this.cabq09;
	}
	public void setCabq10(java.util.Date cabq10) 
	{
		this.cabq10 = cabq10;
	}
	/**
	 * 返回 窗口认证到期时间
	 * @return
	 */
	public java.util.Date getCabq10() 
	{
		return this.cabq10;
	}
	public void setCabq11(java.util.Date cabq11) 
	{
		this.cabq11 = cabq11;
	}
	/**
	 * 返回 网上认证时间
	 * @return
	 */
	public java.util.Date getCabq11() 
	{
		return this.cabq11;
	}
	public void setCabq12(java.util.Date cabq12) 
	{
		this.cabq12 = cabq12;
	}
	/**
	 * 返回 网上认证到期时间
	 * @return
	 */
	public java.util.Date getCabq12() 
	{
		return this.cabq12;
	}
	public void setCabq13(String cabq13) 
	{
		this.cabq13 = cabq13;
	}
	/**
	 * 返回 是否持卡会员F否T是
	 * @return
	 */
	public String getCabq13() 
	{
		return this.cabq13;
	}
	public void setCabq14(String cabq14) 
	{
		this.cabq14 = cabq14;
	}
	/**
	 * 返回 信用等级
	 * @return
	 */
	public String getCabq14() 
	{
		return this.cabq14;
	}
	public void setCabq15(java.util.Date cabq15) 
	{
		this.cabq15 = cabq15;
	}
	/**
	 * 返回 有效期
	 * @return
	 */
	public java.util.Date getCabq15() 
	{
		return this.cabq15;
	}
	public void setCabq16(java.util.Date cabq16) 
	{
		this.cabq16 = cabq16;
	}
	/**
	 * 返回 申请时间
	 * @return
	 */
	public java.util.Date getCabq16() 
	{
		return this.cabq16;
	}
	public void setAcb206(String acb206) 
	{
		this.acb206 = acb206;
	}
	/**
	 * 返回 单位简介
	 * @return
	 */
	public String getAcb206() 
	{
		return this.acb206;
	}
	public void setAcb205(String acb205) 
	{
		this.acb205 = acb205;
	}
	/**
	 * 返回 乘车路线
	 * @return
	 */
	public String getAcb205() 
	{
		return this.acb205;
	}
	public void setCab011(java.util.Date cab011) 
	{
		this.cab011 = cab011;
	}
	/**
	 * 返回 单位证件年检期
	 * @return
	 */
	public java.util.Date getCab011() 
	{
		return this.cab011;
	}
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源0未知1网站2窗口
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}
	public void setCabq17(Long cabq17) 
	{
		this.cabq17 = cabq17;
	}
	/**
	 * 返回 会员积分
	 * @return
	 */
	public Long getCabq17() 
	{
		return this.cabq17;
	}
	public void setCcpr05(java.util.Date ccpr05) 
	{
		this.ccpr05 = ccpr05;
	}
	/**
	 * 返回 最后修改时间
	 * @return
	 */
	public java.util.Date getCcpr05() 
	{
		return this.ccpr05;
	}
	public void setAae139(String aae139) 
	{
		this.aae139 = aae139;
	}
	/**
	 * 返回 联系人手机号码
	 * @return
	 */
	public String getAae139() 
	{
		return this.aae139;
	}
	public void setAab049(Float aab049) 
	{
		this.aab049 = aab049;
	}
	/**
	 * 返回 注册资金(万元)
	 * @return
	 */
	public Float getAab049() 
	{
		return this.aab049;
	}
	public void setCcpr06(String ccpr06) 
	{
		this.ccpr06 = ccpr06;
	}
	/**
	 * 返回 修改人
	 * @return
	 */
	public String getCcpr06() 
	{
		return this.ccpr06;
	}
	public void setCcpr07(String ccpr07) 
	{
		this.ccpr07 = ccpr07;
	}
	/**
	 * 返回 修改来源
	 * @return
	 */
	public String getCcpr07() 
	{
		return this.ccpr07;
	}
	public void setCcpr08(String ccpr08) 
	{
		this.ccpr08 = ccpr08;
	}
	/**
	 * 返回 暂不用使用AAE119
	 * @return
	 */
	public String getCcpr08() 
	{
		return this.ccpr08;
	}
	public void setCcpr09(String ccpr09) 
	{
		this.ccpr09 = ccpr09;
	}
	/**
	 * 返回 是否推荐单位（0-否1-是）
	 * @return
	 */
	public String getCcpr09() 
	{
		return this.ccpr09;
	}
	public void setCcpr10(String ccpr10) 
	{
		this.ccpr10 = ccpr10;
	}
	/**
	 * 返回 自建行业代码
	 * @return
	 */
	public String getCcpr10() 
	{
		return this.ccpr10;
	}
	public void setCcpr11(Long ccpr11) 
	{
		this.ccpr11 = ccpr11;
	}
	/**
	 * 返回 本月置顶次数
	 * @return
	 */
	public Long getCcpr11() 
	{
		return this.ccpr11;
	}
	public void setCcpr12(String ccpr12) 
	{
		this.ccpr12 = ccpr12;
	}
	/**
	 * 返回 最后置顶月份2013-01
	 * @return
	 */
	public String getCcpr12() 
	{
		return this.ccpr12;
	}
	public void setCcpr13(Long ccpr13) 
	{
		this.ccpr13 = ccpr13;
	}
	/**
	 * 返回 是否用人单位协会会员0-否1-是

	 * @return
	 */
	public Long getCcpr13() 
	{
		return this.ccpr13;
	}
	public void setBab014(String bab014) 
	{
		this.bab014 = bab014;
	}
	/**
	 * 返回 联系人身份证号码
	 * @return
	 */
	public String getBab014() 
	{
		return this.bab014;
	}
	public void setBab015(String bab015) 
	{
		this.bab015 = bab015;
	}
	/**
	 * 返回 联系人职务
	 * @return
	 */
	public String getBab015() 
	{
		return this.bab015;
	}
	public void setCahy12(String cahy12) 
	{
		this.cahy12 = cahy12;
	}
	/**
	 * 返回 卡SN号
	 * @return
	 */
	public String getCahy12() 
	{
		return this.cahy12;
	}
	public void setAab113(String aab113) 
	{
		this.aab113 = aab113;
	}
	/**
	 * 返回 代办人姓名
	 * @return
	 */
	public String getAab113() 
	{
		return this.aab113;
	}
	public void setAab114(String aab114) 
	{
		this.aab114 = aab114;
	}
	/**
	 * 返回 代办人身份证号码
	 * @return
	 */
	public String getAab114() 
	{
		return this.aab114;
	}
	public void setAab115(String aab115) 
	{
		this.aab115 = aab115;
	}
	/**
	 * 返回 代办人联系电话
	 * @return
	 */
	public String getAab115() 
	{
		return this.aab115;
	}
	public void setCcpr14(String ccpr14) 
	{
		this.ccpr14 = ccpr14;
	}
	/**
	 * 返回 完善标记0-未完善1-已完善2-已合并
	 * @return
	 */
	public String getCcpr14() 
	{
		return this.ccpr14;
	}
	public void setCcpr15(String ccpr15) 
	{
		this.ccpr15 = ccpr15;
	}
	/**
	 * 返回 是否存档0-否1-是
	 * @return
	 */
	public String getCcpr15() 
	{
		return this.ccpr15;
	}
	public void setCcpr16(String ccpr16) 
	{
		this.ccpr16 = ccpr16;
	}
	/**
	 * 返回 CCPR16
	 * @return
	 */
	public String getCcpr16() 
	{
		return this.ccpr16;
	}
	public void setCcpr17(String ccpr17) 
	{
		this.ccpr17 = ccpr17;
	}
	/**
	 * 返回 提交高拍仪证件照的地址
	 * @return
	 */
	public String getCcpr17() 
	{
		return this.ccpr17;
	}
	public void setCcpr18(String ccpr18) 
	{
		this.ccpr18 = ccpr18;
	}
	/**
	 * 返回 是否推荐单位（0-否1-是）用于BS专题:网络招聘月
	 * @return
	 */
	public String getCcpr18() 
	{
		return this.ccpr18;
	}
	public void setCcpr19(String ccpr19) 
	{
		this.ccpr19 = ccpr19;
	}
	/**
	 * 返回 用于劳务输出标志 0:非劳务输出单位 1:是劳务输出单位
	 * @return
	 */
	public String getCcpr19() 
	{
		return this.ccpr19;
	}
	public void setCcpr20(String ccpr20) 
	{
		this.ccpr20 = ccpr20;
	}
	/**
	 * 返回 图片是否上传 0:未上传 1:已上传
	 * @return
	 */
	public String getCcpr20() 
	{
		return this.ccpr20;
	}
	public void setCcpr21(String ccpr21) 
	{
		this.ccpr21 = ccpr21;
	}
	/**
	 * 返回 视频是否上传 0:未上传 1:已上传
	 * @return
	 */
	public String getCcpr21() 
	{
		return this.ccpr21;
	}
	public void setCcpr22(String ccpr22) 
	{
		this.ccpr22 = ccpr22;
	}
	/**
	 * 返回 是否境外就业企业 0:否 1:是
	 * @return
	 */
	public String getCcpr22() 
	{
		return this.ccpr22;
	}
	public void setCcpr23(String ccpr23) 
	{
		this.ccpr23 = ccpr23;
	}
	/**
	 * 返回 是否开通即时通信 0:未开通 1:已开通
	 * @return
	 */
	public String getCcpr23() 
	{
		return this.ccpr23;
	}
	public void setCcpr24(String ccpr24) 
	{
		this.ccpr24 = ccpr24;
	}
	/**
	 * 返回 是否开通素质测评 0:未开通 1:已开通
	 * @return
	 */
	public String getCcpr24() 
	{
		return this.ccpr24;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof Corp))
		{
			return false;
		}
		Corp rhs = (Corp) object;
		return new EqualsBuilder()
		.append(this.aab001, rhs.aab001)
		.append(this.aab002, rhs.aab002)
		.append(this.aab036, rhs.aab036)
		.append(this.aab003, rhs.aab003)
		.append(this.aab004, rhs.aab004)
		.append(this.aab041, rhs.aab041)
		.append(this.aab042, rhs.aab042)
		.append(this.aab043, rhs.aab043)
		.append(this.aab038, rhs.aab038)
		.append(this.aab019, rhs.aab019)
		.append(this.aab020, rhs.aab020)
		.append(this.aab054, rhs.aab054)
		.append(this.aab022, rhs.aab022)
		.append(this.aae007, rhs.aae007)
		.append(this.aae004, rhs.aae004)
		.append(this.aae005, rhs.aae005)
		.append(this.aae006, rhs.aae006)
		.append(this.aae015, rhs.aae015)
		.append(this.aae016, rhs.aae016)
		.append(this.aab301, rhs.aab301)
		.append(this.aaa021, rhs.aaa021)
		.append(this.aab007, rhs.aab007)
		.append(this.aab010, rhs.aab010)
		.append(this.aab011, rhs.aab011)
		.append(this.cabq05, rhs.cabq05)
		.append(this.cabq06, rhs.cabq06)
		.append(this.cabq07, rhs.cabq07)
		.append(this.cabq08, rhs.cabq08)
		.append(this.aab006, rhs.aab006)
		.append(this.aab008, rhs.aab008)
		.append(this.aab021, rhs.aab021)
		.append(this.aab013, rhs.aab013)
		.append(this.aab014, rhs.aab014)
		.append(this.aab015, rhs.aab015)
		.append(this.aab052, rhs.aab052)
		.append(this.aab023, rhs.aab023)
		.append(this.aab048, rhs.aab048)
		.append(this.aab053, rhs.aab053)
		.append(this.acb101, rhs.acb101)
		.append(this.aab01d, rhs.aab01d)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.bae011, rhs.bae011)
		.append(this.bae017, rhs.bae017)
		.append(this.bae036, rhs.bae036)
		.append(this.bae019, rhs.bae019)
		.append(this.bae020, rhs.bae020)
		.append(this.bae022, rhs.bae022)
		.append(this.aab025, rhs.aab025)
		.append(this.aab026, rhs.aab026)
		.append(this.aab01e, rhs.aab01e)
		.append(this.aab01f, rhs.aab01f)
		.append(this.aab01g, rhs.aab01g)
		.append(this.aae119, rhs.aae119)
		.append(this.aab039, rhs.aab039)
		.append(this.aaa130, rhs.aaa130)
		.append(this.aab040, rhs.aab040)
		.append(this.aab056, rhs.aab056)
		.append(this.aab045, rhs.aab045)
		.append(this.bab002, rhs.bab002)
		.append(this.aab012, rhs.aab012)
		.append(this.aae008, rhs.aae008)
		.append(this.aae009, rhs.aae009)
		.append(this.aae010, rhs.aae010)
		.append(this.aab027, rhs.aab027)
		.append(this.aab028, rhs.aab028)
		.append(this.aab029, rhs.aab029)
		.append(this.aab030, rhs.aab030)
		.append(this.aab031, rhs.aab031)
		.append(this.aab032, rhs.aab032)
		.append(this.aab037, rhs.aab037)
		.append(this.aab046, rhs.aab046)
		.append(this.aab047, rhs.aab047)
		.append(this.aab016, rhs.aab016)
		.append(this.aab017, rhs.aab017)
		.append(this.aab018, rhs.aab018)
		.append(this.aab024, rhs.aab024)
		.append(this.aab033, rhs.aab033)
		.append(this.aab500, rhs.aab500)
		.append(this.aab034, rhs.aab034)
		.append(this.aab341, rhs.aab341)
		.append(this.aab342, rhs.aab342)
		.append(this.aab343, rhs.aab343)
		.append(this.ccmu01, rhs.ccmu01)
		.append(this.cabq01, rhs.cabq01)
		.append(this.cabq02, rhs.cabq02)
		.append(this.cabq03, rhs.cabq03)
		.append(this.cabq04, rhs.cabq04)
		.append(this.cabq09, rhs.cabq09)
		.append(this.cabq10, rhs.cabq10)
		.append(this.cabq11, rhs.cabq11)
		.append(this.cabq12, rhs.cabq12)
		.append(this.cabq13, rhs.cabq13)
		.append(this.cabq14, rhs.cabq14)
		.append(this.cabq15, rhs.cabq15)
		.append(this.cabq16, rhs.cabq16)
		.append(this.acb206, rhs.acb206)
		.append(this.acb205, rhs.acb205)
		.append(this.cab011, rhs.cab011)
		.append(this.cczy06, rhs.cczy06)
		.append(this.cabq17, rhs.cabq17)
		.append(this.ccpr05, rhs.ccpr05)
		.append(this.aae139, rhs.aae139)
		.append(this.aab049, rhs.aab049)
		.append(this.ccpr06, rhs.ccpr06)
		.append(this.ccpr07, rhs.ccpr07)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.ccpr09, rhs.ccpr09)
		.append(this.ccpr10, rhs.ccpr10)
		.append(this.ccpr11, rhs.ccpr11)
		.append(this.ccpr12, rhs.ccpr12)
		.append(this.ccpr13, rhs.ccpr13)
		.append(this.bab014, rhs.bab014)
		.append(this.bab015, rhs.bab015)
		.append(this.cahy12, rhs.cahy12)
		.append(this.aab113, rhs.aab113)
		.append(this.aab114, rhs.aab114)
		.append(this.aab115, rhs.aab115)
		.append(this.ccpr14, rhs.ccpr14)
		.append(this.ccpr15, rhs.ccpr15)
		.append(this.ccpr16, rhs.ccpr16)
		.append(this.ccpr17, rhs.ccpr17)
		.append(this.ccpr18, rhs.ccpr18)
		.append(this.ccpr19, rhs.ccpr19)
		.append(this.ccpr20, rhs.ccpr20)
		.append(this.ccpr21, rhs.ccpr21)
		.append(this.ccpr22, rhs.ccpr22)
		.append(this.ccpr23, rhs.ccpr23)
		.append(this.ccpr24, rhs.ccpr24)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.aab001)
		.append(this.aab002)
		.append(this.aab036)
		.append(this.aab003)
		.append(this.aab004)
		.append(this.aab041)
		.append(this.aab042)
		.append(this.aab043)
		.append(this.aab038)
		.append(this.aab019)
		.append(this.aab020)
		.append(this.aab054)
		.append(this.aab022)
		.append(this.aae007)
		.append(this.aae004)
		.append(this.aae005)
		.append(this.aae006)
		.append(this.aae015)
		.append(this.aae016)
		.append(this.aab301)
		.append(this.aaa021)
		.append(this.aab007)
		.append(this.aab010)
		.append(this.aab011)
		.append(this.cabq05)
		.append(this.cabq06)
		.append(this.cabq07)
		.append(this.cabq08)
		.append(this.aab006)
		.append(this.aab008)
		.append(this.aab021)
		.append(this.aab013)
		.append(this.aab014)
		.append(this.aab015)
		.append(this.aab052)
		.append(this.aab023)
		.append(this.aab048)
		.append(this.aab053)
		.append(this.acb101)
		.append(this.aab01d)
		.append(this.aae013)
		.append(this.aae011)
		.append(this.aae017)
		.append(this.aae036)
		.append(this.aae019)
		.append(this.aae020)
		.append(this.bae011)
		.append(this.bae017)
		.append(this.bae036)
		.append(this.bae019)
		.append(this.bae020)
		.append(this.bae022)
		.append(this.aab025)
		.append(this.aab026)
		.append(this.aab01e)
		.append(this.aab01f)
		.append(this.aab01g)
		.append(this.aae119)
		.append(this.aab039)
		.append(this.aaa130)
		.append(this.aab040)
		.append(this.aab056)
		.append(this.aab045)
		.append(this.bab002)
		.append(this.aab012)
		.append(this.aae008)
		.append(this.aae009)
		.append(this.aae010)
		.append(this.aab027)
		.append(this.aab028)
		.append(this.aab029)
		.append(this.aab030)
		.append(this.aab031)
		.append(this.aab032)
		.append(this.aab037)
		.append(this.aab046)
		.append(this.aab047)
		.append(this.aab016)
		.append(this.aab017)
		.append(this.aab018)
		.append(this.aab024)
		.append(this.aab033)
		.append(this.aab500)
		.append(this.aab034)
		.append(this.aab341)
		.append(this.aab342)
		.append(this.aab343)
		.append(this.ccmu01)
		.append(this.cabq01)
		.append(this.cabq02)
		.append(this.cabq03)
		.append(this.cabq04)
		.append(this.cabq09)
		.append(this.cabq10)
		.append(this.cabq11)
		.append(this.cabq12)
		.append(this.cabq13)
		.append(this.cabq14)
		.append(this.cabq15)
		.append(this.cabq16)
		.append(this.acb206)
		.append(this.acb205)
		.append(this.cab011)
		.append(this.cczy06)
		.append(this.cabq17)
		.append(this.ccpr05)
		.append(this.aae139)
		.append(this.aab049)
		.append(this.ccpr06)
		.append(this.ccpr07)
		.append(this.ccpr08)
		.append(this.ccpr09)
		.append(this.ccpr10)
		.append(this.ccpr11)
		.append(this.ccpr12)
		.append(this.ccpr13)
		.append(this.bab014)
		.append(this.bab015)
		.append(this.cahy12)
		.append(this.aab113)
		.append(this.aab114)
		.append(this.aab115)
		.append(this.ccpr14)
		.append(this.ccpr15)
		.append(this.ccpr16)
		.append(this.ccpr17)
		.append(this.ccpr18)
		.append(this.ccpr19)
		.append(this.ccpr20)
		.append(this.ccpr21)
		.append(this.ccpr22)
		.append(this.ccpr23)
		.append(this.ccpr24)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("aab001", this.aab001) 
		.append("aab002", this.aab002) 
		.append("aab036", this.aab036) 
		.append("aab003", this.aab003) 
		.append("aab004", this.aab004) 
		.append("aab041", this.aab041) 
		.append("aab042", this.aab042) 
		.append("aab043", this.aab043) 
		.append("aab038", this.aab038) 
		.append("aab019", this.aab019) 
		.append("aab020", this.aab020) 
		.append("aab054", this.aab054) 
		.append("aab022", this.aab022) 
		.append("aae007", this.aae007) 
		.append("aae004", this.aae004) 
		.append("aae005", this.aae005) 
		.append("aae006", this.aae006) 
		.append("aae015", this.aae015) 
		.append("aae016", this.aae016) 
		.append("aab301", this.aab301) 
		.append("aaa021", this.aaa021) 
		.append("aab007", this.aab007) 
		.append("aab010", this.aab010) 
		.append("aab011", this.aab011) 
		.append("cabq05", this.cabq05) 
		.append("cabq06", this.cabq06) 
		.append("cabq07", this.cabq07) 
		.append("cabq08", this.cabq08) 
		.append("aab006", this.aab006) 
		.append("aab008", this.aab008) 
		.append("aab021", this.aab021) 
		.append("aab013", this.aab013) 
		.append("aab014", this.aab014) 
		.append("aab015", this.aab015) 
		.append("aab052", this.aab052) 
		.append("aab023", this.aab023) 
		.append("aab048", this.aab048) 
		.append("aab053", this.aab053) 
		.append("acb101", this.acb101) 
		.append("aab01d", this.aab01d) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("bae011", this.bae011) 
		.append("bae017", this.bae017) 
		.append("bae036", this.bae036) 
		.append("bae019", this.bae019) 
		.append("bae020", this.bae020) 
		.append("bae022", this.bae022) 
		.append("aab025", this.aab025) 
		.append("aab026", this.aab026) 
		.append("aab01e", this.aab01e) 
		.append("aab01f", this.aab01f) 
		.append("aab01g", this.aab01g) 
		.append("aae119", this.aae119) 
		.append("aab039", this.aab039) 
		.append("aaa130", this.aaa130) 
		.append("aab040", this.aab040) 
		.append("aab056", this.aab056) 
		.append("aab045", this.aab045) 
		.append("bab002", this.bab002) 
		.append("aab012", this.aab012) 
		.append("aae008", this.aae008) 
		.append("aae009", this.aae009) 
		.append("aae010", this.aae010) 
		.append("aab027", this.aab027) 
		.append("aab028", this.aab028) 
		.append("aab029", this.aab029) 
		.append("aab030", this.aab030) 
		.append("aab031", this.aab031) 
		.append("aab032", this.aab032) 
		.append("aab037", this.aab037) 
		.append("aab046", this.aab046) 
		.append("aab047", this.aab047) 
		.append("aab016", this.aab016) 
		.append("aab017", this.aab017) 
		.append("aab018", this.aab018) 
		.append("aab024", this.aab024) 
		.append("aab033", this.aab033) 
		.append("aab500", this.aab500) 
		.append("aab034", this.aab034) 
		.append("aab341", this.aab341) 
		.append("aab342", this.aab342) 
		.append("aab343", this.aab343) 
		.append("ccmu01", this.ccmu01) 
		.append("cabq01", this.cabq01) 
		.append("cabq02", this.cabq02) 
		.append("cabq03", this.cabq03) 
		.append("cabq04", this.cabq04) 
		.append("cabq09", this.cabq09) 
		.append("cabq10", this.cabq10) 
		.append("cabq11", this.cabq11) 
		.append("cabq12", this.cabq12) 
		.append("cabq13", this.cabq13) 
		.append("cabq14", this.cabq14) 
		.append("cabq15", this.cabq15) 
		.append("cabq16", this.cabq16) 
		.append("acb206", this.acb206) 
		.append("acb205", this.acb205) 
		.append("cab011", this.cab011) 
		.append("cczy06", this.cczy06) 
		.append("cabq17", this.cabq17) 
		.append("ccpr05", this.ccpr05) 
		.append("aae139", this.aae139) 
		.append("aab049", this.aab049) 
		.append("ccpr06", this.ccpr06) 
		.append("ccpr07", this.ccpr07) 
		.append("ccpr08", this.ccpr08) 
		.append("ccpr09", this.ccpr09) 
		.append("ccpr10", this.ccpr10) 
		.append("ccpr11", this.ccpr11) 
		.append("ccpr12", this.ccpr12) 
		.append("ccpr13", this.ccpr13) 
		.append("bab014", this.bab014) 
		.append("bab015", this.bab015) 
		.append("cahy12", this.cahy12) 
		.append("aab113", this.aab113) 
		.append("aab114", this.aab114) 
		.append("aab115", this.aab115) 
		.append("ccpr14", this.ccpr14) 
		.append("ccpr15", this.ccpr15) 
		.append("ccpr16", this.ccpr16) 
		.append("ccpr17", this.ccpr17) 
		.append("ccpr18", this.ccpr18) 
		.append("ccpr19", this.ccpr19) 
		.append("ccpr20", this.ccpr20) 
		.append("ccpr21", this.ccpr21) 
		.append("ccpr22", this.ccpr22) 
		.append("ccpr23", this.ccpr23) 
		.append("ccpr24", this.ccpr24) 
		.toString();
	}
   
  

}