package com.xunfeng.business.person.web.form;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.core.model.BaseForm;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人基本信息表 Form对象
* @author:wanghan
* @createDate 2016-01-05 09:39:44 
* @version V1.0   
*/
public class PersonForm extends BaseForm<PersonBaseInfo>
{
	// 个人编号
	protected Long  aac001;
	// 公民身份证号码
	protected String  aac002;
	// 军人证号
	protected String  aac00a;
	// 姓名
	protected String  aac003;
	// 性别
	protected String  aac004;
	// 民族
	protected String  aac005;
	// 出生日期
	protected java.util.Date  aac006;
	// 户口性质
	protected String  aac009;
	// 居住所在地
	protected String  aab301;
	// 楼院
	protected String  aac00b;
	// 单元
	protected String  aac00c;
	// 门牌号
	protected String  aac00d;
	// 户口所在地
	protected String  bab305;
	// 联系电话
	protected String  aae005;
	// 目前住房情况
	protected String  aac00e;
	// 文化程度
	protected String  aac011;
	// 毕业学校
	protected String  aac180;
	// 毕业时间
	protected java.util.Date  aac181;
	// 婚姻状况
	protected String  aac017;
	// 政治面貌
	protected String  aac024;
	// 健康状况
	protected String  aac033;
	// 电子信箱
	protected String  aae015;
	// 姓名拼音码
	protected String  aac022;
	// 邮编
	protected String  aae007;
	// 个人英文名称
	protected String  aac023;
	// 血型
	protected String  aac032;
	// 身高
	protected Float  aac034;
	// 体重
	protected Float  aac035;
	// 视力
	protected String  aac036;
	// 祖籍
	protected String  aac025;
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
	// 经办机构区划
	protected String  aae022;
	// 会员编号
	protected Long  ccmu01;
	// 简历完成百分比
	protected Long  ccmu50;
	// 求职意向是否完整
	protected String  ccmu51;
	// 技能特长是否完整 
	protected String  ccmu52;
	// 教育经历是否完整
	protected String  ccmu53;
	// 工作经历 是否完整
	protected String  ccmu54;
	// 形象照片是否完整
	protected String  ccmu55;
	// 头像是否显示
	protected String  ccmu56;
	// 数据来源（0-未知1-网站2-窗口3-民营机构4-公办机构5-导入数据）
	protected String  cczy06;
	// 培训经历是否完整
	protected String  ccmu57;
	// 认证标志（0-未认证1-已上传未认证2-网站后台认证3-职介人工认证4-设备认证）
	protected Long  ccmu58;
	// 手机认证标志（0-未认证1-已发送未认证2-手机已认证)
	protected Long  ccmu59;
	// 邮件认证标志（0-未认证1-已发送未认证2-邮件已认证)
	protected Long  ccmu60;
	// 身份证头像
	protected String  ccmu61;
	// 身份证扫描件
	protected String  ccmu62;
	// 最后修改时间
	protected java.util.Date  ccpr05;
	// 修改人
	protected String  ccpr06;
	// 修改来源
	protected String  ccpr07;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 是否有资格证书
	protected String  ccmu63;
	// 最后认证时间
	protected java.util.Date  ccmu64;
	// 年龄段标记1-（16-24岁）2-（25-34岁）3-（35-44岁）4-（45岁以上）9-无要求
	protected String  acb223;
	// 所学专业代码
	protected String  acc01g;
	// 户籍辖区
	protected String  aab305;
	// 所在辖区
	protected String  bab301;
	// 就业失业登记证号码
	protected String  acc0m1;
	// 设备编号
	protected Long  div001;
	// 个人求职卡号
	protected String  cahy12;
	// 个人工作经历描述
	protected String  aac037;
	// 个人工作经验编号,tab_workyears
	protected String  aac038;
	// 最后修改经办机构
	protected String  ccpr04;
	// 专业类别名称
	protected String  aac039;
	// 专业名称
	protected String  aac040;
	// 个人简介
	protected String  aac041;
	// 技能简介
	protected String  aac042;
	// 祖籍省
	protected String  aac026;
	// 祖籍市
	protected String  aac027;
	// 祖籍县区
	protected String  aac028;
	public void setAac001(Long aac001) 
	{
		this.aac001 = aac001;
	}
	/**
	 * 返回 个人编号
	 * @return
	 */
	public Long getAac001() 
	{
		return this.aac001;
	}
	public void setAac002(String aac002) 
	{
		this.aac002 = aac002;
	}
	/**
	 * 返回 公民身份证号码
	 * @return
	 */
	public String getAac002() 
	{
		return this.aac002;
	}
	public void setAac00a(String aac00a) 
	{
		this.aac00a = aac00a;
	}
	/**
	 * 返回 军人证号
	 * @return
	 */
	public String getAac00a() 
	{
		return this.aac00a;
	}
	public void setAac003(String aac003) 
	{
		this.aac003 = aac003;
	}
	/**
	 * 返回 姓名
	 * @return
	 */
	public String getAac003() 
	{
		return this.aac003;
	}
	public void setAac004(String aac004) 
	{
		this.aac004 = aac004;
	}
	/**
	 * 返回 性别
	 * @return
	 */
	public String getAac004() 
	{
		return this.aac004;
	}
	public void setAac005(String aac005) 
	{
		this.aac005 = aac005;
	}
	/**
	 * 返回 民族
	 * @return
	 */
	public String getAac005() 
	{
		return this.aac005;
	}
	public void setAac006(java.util.Date aac006) 
	{
		this.aac006 = aac006;
	}
	/**
	 * 返回 出生日期
	 * @return
	 */
	public java.util.Date getAac006() 
	{
		return this.aac006;
	}
	public void setAac009(String aac009) 
	{
		this.aac009 = aac009;
	}
	/**
	 * 返回 户口性质
	 * @return
	 */
	public String getAac009() 
	{
		return this.aac009;
	}
	public void setAab301(String aab301) 
	{
		this.aab301 = aab301;
	}
	/**
	 * 返回 居住所在地
	 * @return
	 */
	public String getAab301() 
	{
		return this.aab301;
	}
	public void setAac00b(String aac00b) 
	{
		this.aac00b = aac00b;
	}
	/**
	 * 返回 楼院
	 * @return
	 */
	public String getAac00b() 
	{
		return this.aac00b;
	}
	public void setAac00c(String aac00c) 
	{
		this.aac00c = aac00c;
	}
	/**
	 * 返回 单元
	 * @return
	 */
	public String getAac00c() 
	{
		return this.aac00c;
	}
	public void setAac00d(String aac00d) 
	{
		this.aac00d = aac00d;
	}
	/**
	 * 返回 门牌号
	 * @return
	 */
	public String getAac00d() 
	{
		return this.aac00d;
	}
	public void setBab305(String bab305) 
	{
		this.bab305 = bab305;
	}
	/**
	 * 返回 户口所在地
	 * @return
	 */
	public String getBab305() 
	{
		return this.bab305;
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
	public void setAac00e(String aac00e) 
	{
		this.aac00e = aac00e;
	}
	/**
	 * 返回 目前住房情况
	 * @return
	 */
	public String getAac00e() 
	{
		return this.aac00e;
	}
	public void setAac011(String aac011) 
	{
		this.aac011 = aac011;
	}
	/**
	 * 返回 文化程度
	 * @return
	 */
	public String getAac011() 
	{
		return this.aac011;
	}
	public void setAac180(String aac180) 
	{
		this.aac180 = aac180;
	}
	/**
	 * 返回 毕业学校
	 * @return
	 */
	public String getAac180() 
	{
		return this.aac180;
	}
	public void setAac181(java.util.Date aac181) 
	{
		this.aac181 = aac181;
	}
	/**
	 * 返回 毕业时间
	 * @return
	 */
	public java.util.Date getAac181() 
	{
		return this.aac181;
	}
	public void setAac017(String aac017) 
	{
		this.aac017 = aac017;
	}
	/**
	 * 返回 婚姻状况
	 * @return
	 */
	public String getAac017() 
	{
		return this.aac017;
	}
	public void setAac024(String aac024) 
	{
		this.aac024 = aac024;
	}
	/**
	 * 返回 政治面貌
	 * @return
	 */
	public String getAac024() 
	{
		return this.aac024;
	}
	public void setAac033(String aac033) 
	{
		this.aac033 = aac033;
	}
	/**
	 * 返回 健康状况
	 * @return
	 */
	public String getAac033() 
	{
		return this.aac033;
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
	public void setAac022(String aac022) 
	{
		this.aac022 = aac022;
	}
	/**
	 * 返回 姓名拼音码
	 * @return
	 */
	public String getAac022() 
	{
		return this.aac022;
	}
	public void setAae007(String aae007) 
	{
		this.aae007 = aae007;
	}
	/**
	 * 返回 邮编
	 * @return
	 */
	public String getAae007() 
	{
		return this.aae007;
	}
	public void setAac023(String aac023) 
	{
		this.aac023 = aac023;
	}
	/**
	 * 返回 个人英文名称
	 * @return
	 */
	public String getAac023() 
	{
		return this.aac023;
	}
	public void setAac032(String aac032) 
	{
		this.aac032 = aac032;
	}
	/**
	 * 返回 血型
	 * @return
	 */
	public String getAac032() 
	{
		return this.aac032;
	}
	public void setAac034(Float aac034) 
	{
		this.aac034 = aac034;
	}
	/**
	 * 返回 身高
	 * @return
	 */
	public Float getAac034() 
	{
		return this.aac034;
	}
	public void setAac035(Float aac035) 
	{
		this.aac035 = aac035;
	}
	/**
	 * 返回 体重
	 * @return
	 */
	public Float getAac035() 
	{
		return this.aac035;
	}
	public void setAac036(String aac036) 
	{
		this.aac036 = aac036;
	}
	/**
	 * 返回 视力
	 * @return
	 */
	public String getAac036() 
	{
		return this.aac036;
	}
	public void setAac025(String aac025) 
	{
		this.aac025 = aac025;
	}
	/**
	 * 返回 祖籍
	 * @return
	 */
	public String getAac025() 
	{
		return this.aac025;
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
	public void setAae022(String aae022) 
	{
		this.aae022 = aae022;
	}
	/**
	 * 返回 经办机构区划
	 * @return
	 */
	public String getAae022() 
	{
		return this.aae022;
	}
	public void setCcmu01(Long ccmu01) 
	{
		this.ccmu01 = ccmu01;
	}
	/**
	 * 返回 会员编号
	 * @return
	 */
	public Long getCcmu01() 
	{
		return this.ccmu01;
	}
	public void setCcmu50(Long ccmu50) 
	{
		this.ccmu50 = ccmu50;
	}
	/**
	 * 返回 简历完成百分比
	 * @return
	 */
	public Long getCcmu50() 
	{
		return this.ccmu50;
	}
	public void setCcmu51(String ccmu51) 
	{
		this.ccmu51 = ccmu51;
	}
	/**
	 * 返回 求职意向是否完整
	 * @return
	 */
	public String getCcmu51() 
	{
		return this.ccmu51;
	}
	public void setCcmu52(String ccmu52) 
	{
		this.ccmu52 = ccmu52;
	}
	/**
	 * 返回 技能特长是否完整 
	 * @return
	 */
	public String getCcmu52() 
	{
		return this.ccmu52;
	}
	public void setCcmu53(String ccmu53) 
	{
		this.ccmu53 = ccmu53;
	}
	/**
	 * 返回 教育经历是否完整
	 * @return
	 */
	public String getCcmu53() 
	{
		return this.ccmu53;
	}
	public void setCcmu54(String ccmu54) 
	{
		this.ccmu54 = ccmu54;
	}
	/**
	 * 返回 工作经历 是否完整
	 * @return
	 */
	public String getCcmu54() 
	{
		return this.ccmu54;
	}
	public void setCcmu55(String ccmu55) 
	{
		this.ccmu55 = ccmu55;
	}
	/**
	 * 返回 形象照片是否完整
	 * @return
	 */
	public String getCcmu55() 
	{
		return this.ccmu55;
	}
	public void setCcmu56(String ccmu56) 
	{
		this.ccmu56 = ccmu56;
	}
	/**
	 * 返回 头像是否显示
	 * @return
	 */
	public String getCcmu56() 
	{
		return this.ccmu56;
	}
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源（0-未知1-网站2-窗口3-民营机构4-公办机构5-导入数据）
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}
	public void setCcmu57(String ccmu57) 
	{
		this.ccmu57 = ccmu57;
	}
	/**
	 * 返回 培训经历是否完整
	 * @return
	 */
	public String getCcmu57() 
	{
		return this.ccmu57;
	}
	public void setCcmu58(Long ccmu58) 
	{
		this.ccmu58 = ccmu58;
	}
	/**
	 * 返回 认证标志（0-未认证1-已上传未认证2-网站后台认证3-职介人工认证4-设备认证）
	 * @return
	 */
	public Long getCcmu58() 
	{
		return this.ccmu58;
	}
	public void setCcmu59(Long ccmu59) 
	{
		this.ccmu59 = ccmu59;
	}
	/**
	 * 返回 手机认证标志（0-未认证1-已发送未认证2-手机已认证)
	 * @return
	 */
	public Long getCcmu59() 
	{
		return this.ccmu59;
	}
	public void setCcmu60(Long ccmu60) 
	{
		this.ccmu60 = ccmu60;
	}
	/**
	 * 返回 邮件认证标志（0-未认证1-已发送未认证2-邮件已认证)
	 * @return
	 */
	public Long getCcmu60() 
	{
		return this.ccmu60;
	}
	public void setCcmu61(String ccmu61) 
	{
		this.ccmu61 = ccmu61;
	}
	/**
	 * 返回 身份证头像
	 * @return
	 */
	public String getCcmu61() 
	{
		return this.ccmu61;
	}
	public void setCcmu62(String ccmu62) 
	{
		this.ccmu62 = ccmu62;
	}
	/**
	 * 返回 身份证扫描件
	 * @return
	 */
	public String getCcmu62() 
	{
		return this.ccmu62;
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
	 * 返回 是否删除状态（0-否1-是）
	 * @return
	 */
	public String getCcpr08() 
	{
		return this.ccpr08;
	}
	public void setCcmu63(String ccmu63) 
	{
		this.ccmu63 = ccmu63;
	}
	/**
	 * 返回 是否有资格证书
	 * @return
	 */
	public String getCcmu63() 
	{
		return this.ccmu63;
	}
	public void setCcmu64(java.util.Date ccmu64) 
	{
		this.ccmu64 = ccmu64;
	}
	/**
	 * 返回 最后认证时间
	 * @return
	 */
	public java.util.Date getCcmu64() 
	{
		return this.ccmu64;
	}
	public void setAcb223(String acb223) 
	{
		this.acb223 = acb223;
	}
	/**
	 * 返回 年龄段标记1-（16-24岁）2-（25-34岁）3-（35-44岁）4-（45岁以上）9-无要求
	 * @return
	 */
	public String getAcb223() 
	{
		return this.acb223;
	}
	public void setAcc01g(String acc01g) 
	{
		this.acc01g = acc01g;
	}
	/**
	 * 返回 所学专业代码
	 * @return
	 */
	public String getAcc01g() 
	{
		return this.acc01g;
	}
	public void setAab305(String aab305) 
	{
		this.aab305 = aab305;
	}
	/**
	 * 返回 户籍辖区
	 * @return
	 */
	public String getAab305() 
	{
		return this.aab305;
	}
	public void setBab301(String bab301) 
	{
		this.bab301 = bab301;
	}
	/**
	 * 返回 所在辖区
	 * @return
	 */
	public String getBab301() 
	{
		return this.bab301;
	}
	public void setAcc0m1(String acc0m1) 
	{
		this.acc0m1 = acc0m1;
	}
	/**
	 * 返回 就业失业登记证号码
	 * @return
	 */
	public String getAcc0m1() 
	{
		return this.acc0m1;
	}
	public void setDiv001(Long div001) 
	{
		this.div001 = div001;
	}
	/**
	 * 返回 设备编号
	 * @return
	 */
	public Long getDiv001() 
	{
		return this.div001;
	}
	public void setCahy12(String cahy12) 
	{
		this.cahy12 = cahy12;
	}
	/**
	 * 返回 个人求职卡号
	 * @return
	 */
	public String getCahy12() 
	{
		return this.cahy12;
	}
	public void setAac037(String aac037) 
	{
		this.aac037 = aac037;
	}
	/**
	 * 返回 个人工作经历描述
	 * @return
	 */
	public String getAac037() 
	{
		return this.aac037;
	}
	public void setAac038(String aac038) 
	{
		this.aac038 = aac038;
	}
	/**
	 * 返回 个人工作经验编号,tab_workyears
	 * @return
	 */
	public String getAac038() 
	{
		return this.aac038;
	}
	public void setCcpr04(String ccpr04) 
	{
		this.ccpr04 = ccpr04;
	}
	/**
	 * 返回 最后修改经办机构
	 * @return
	 */
	public String getCcpr04() 
	{
		return this.ccpr04;
	}
	public void setAac039(String aac039) 
	{
		this.aac039 = aac039;
	}
	/**
	 * 返回 专业类别名称
	 * @return
	 */
	public String getAac039() 
	{
		return this.aac039;
	}
	public void setAac040(String aac040) 
	{
		this.aac040 = aac040;
	}
	/**
	 * 返回 专业名称
	 * @return
	 */
	public String getAac040() 
	{
		return this.aac040;
	}
	public void setAac041(String aac041) 
	{
		this.aac041 = aac041;
	}
	/**
	 * 返回 个人简介
	 * @return
	 */
	public String getAac041() 
	{
		return this.aac041;
	}
	public void setAac042(String aac042) 
	{
		this.aac042 = aac042;
	}
	/**
	 * 返回 技能简介
	 * @return
	 */
	public String getAac042() 
	{
		return this.aac042;
	}
	public void setAac026(String aac026) 
	{
		this.aac026 = aac026;
	}
	/**
	 * 返回 祖籍省
	 * @return
	 */
	public String getAac026() 
	{
		return this.aac026;
	}
	public void setAac027(String aac027) 
	{
		this.aac027 = aac027;
	}
	/**
	 * 返回 祖籍市
	 * @return
	 */
	public String getAac027() 
	{
		return this.aac027;
	}
	public void setAac028(String aac028) 
	{
		this.aac028 = aac028;
	}
	/**
	 * 返回 祖籍县区
	 * @return
	 */
	public String getAac028() 
	{
		return this.aac028;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof PersonForm)) 
		{
			return false;
		}
		PersonForm rhs = (PersonForm) object;
		return new EqualsBuilder()
		.append(this.aac001, rhs.aac001)
		.append(this.aac002, rhs.aac002)
		.append(this.aac00a, rhs.aac00a)
		.append(this.aac003, rhs.aac003)
		.append(this.aac004, rhs.aac004)
		.append(this.aac005, rhs.aac005)
		.append(this.aac006, rhs.aac006)
		.append(this.aac009, rhs.aac009)
		.append(this.aab301, rhs.aab301)
		.append(this.aac00b, rhs.aac00b)
		.append(this.aac00c, rhs.aac00c)
		.append(this.aac00d, rhs.aac00d)
		.append(this.bab305, rhs.bab305)
		.append(this.aae005, rhs.aae005)
		.append(this.aac00e, rhs.aac00e)
		.append(this.aac011, rhs.aac011)
		.append(this.aac180, rhs.aac180)
		.append(this.aac181, rhs.aac181)
		.append(this.aac017, rhs.aac017)
		.append(this.aac024, rhs.aac024)
		.append(this.aac033, rhs.aac033)
		.append(this.aae015, rhs.aae015)
		.append(this.aac022, rhs.aac022)
		.append(this.aae007, rhs.aae007)
		.append(this.aac023, rhs.aac023)
		.append(this.aac032, rhs.aac032)
		.append(this.aac034, rhs.aac034)
		.append(this.aac035, rhs.aac035)
		.append(this.aac036, rhs.aac036)
		.append(this.aac025, rhs.aac025)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae022, rhs.aae022)
		.append(this.ccmu01, rhs.ccmu01)
		.append(this.ccmu50, rhs.ccmu50)
		.append(this.ccmu51, rhs.ccmu51)
		.append(this.ccmu52, rhs.ccmu52)
		.append(this.ccmu53, rhs.ccmu53)
		.append(this.ccmu54, rhs.ccmu54)
		.append(this.ccmu55, rhs.ccmu55)
		.append(this.ccmu56, rhs.ccmu56)
		.append(this.cczy06, rhs.cczy06)
		.append(this.ccmu57, rhs.ccmu57)
		.append(this.ccmu58, rhs.ccmu58)
		.append(this.ccmu59, rhs.ccmu59)
		.append(this.ccmu60, rhs.ccmu60)
		.append(this.ccmu61, rhs.ccmu61)
		.append(this.ccmu62, rhs.ccmu62)
		.append(this.ccpr05, rhs.ccpr05)
		.append(this.ccpr06, rhs.ccpr06)
		.append(this.ccpr07, rhs.ccpr07)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.ccmu63, rhs.ccmu63)
		.append(this.ccmu64, rhs.ccmu64)
		.append(this.acb223, rhs.acb223)
		.append(this.acc01g, rhs.acc01g)
		.append(this.aab305, rhs.aab305)
		.append(this.bab301, rhs.bab301)
		.append(this.acc0m1, rhs.acc0m1)
		.append(this.div001, rhs.div001)
		.append(this.cahy12, rhs.cahy12)
		.append(this.aac037, rhs.aac037)
		.append(this.aac038, rhs.aac038)
		.append(this.ccpr04, rhs.ccpr04)
		.append(this.aac039, rhs.aac039)
		.append(this.aac040, rhs.aac040)
		.append(this.aac041, rhs.aac041)
		.append(this.aac042, rhs.aac042)
		.append(this.aac026, rhs.aac026)
		.append(this.aac027, rhs.aac027)
		.append(this.aac028, rhs.aac028)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.aac001) 
		.append(this.aac002) 
		.append(this.aac00a) 
		.append(this.aac003) 
		.append(this.aac004) 
		.append(this.aac005) 
		.append(this.aac006) 
		.append(this.aac009) 
		.append(this.aab301) 
		.append(this.aac00b) 
		.append(this.aac00c) 
		.append(this.aac00d) 
		.append(this.bab305) 
		.append(this.aae005) 
		.append(this.aac00e) 
		.append(this.aac011) 
		.append(this.aac180) 
		.append(this.aac181) 
		.append(this.aac017) 
		.append(this.aac024) 
		.append(this.aac033) 
		.append(this.aae015) 
		.append(this.aac022) 
		.append(this.aae007) 
		.append(this.aac023) 
		.append(this.aac032) 
		.append(this.aac034) 
		.append(this.aac035) 
		.append(this.aac036) 
		.append(this.aac025) 
		.append(this.aae013) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.aae022) 
		.append(this.ccmu01) 
		.append(this.ccmu50) 
		.append(this.ccmu51) 
		.append(this.ccmu52) 
		.append(this.ccmu53) 
		.append(this.ccmu54) 
		.append(this.ccmu55) 
		.append(this.ccmu56) 
		.append(this.cczy06) 
		.append(this.ccmu57) 
		.append(this.ccmu58) 
		.append(this.ccmu59) 
		.append(this.ccmu60) 
		.append(this.ccmu61) 
		.append(this.ccmu62) 
		.append(this.ccpr05) 
		.append(this.ccpr06) 
		.append(this.ccpr07) 
		.append(this.ccpr08) 
		.append(this.ccmu63) 
		.append(this.ccmu64) 
		.append(this.acb223) 
		.append(this.acc01g) 
		.append(this.aab305) 
		.append(this.bab301) 
		.append(this.acc0m1) 
		.append(this.div001) 
		.append(this.cahy12) 
		.append(this.aac037) 
		.append(this.aac038) 
		.append(this.ccpr04) 
		.append(this.aac039) 
		.append(this.aac040) 
		.append(this.aac041) 
		.append(this.aac042) 
		.append(this.aac026) 
		.append(this.aac027) 
		.append(this.aac028) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("aac001", this.aac001) 
		.append("aac002", this.aac002) 
		.append("aac00a", this.aac00a) 
		.append("aac003", this.aac003) 
		.append("aac004", this.aac004) 
		.append("aac005", this.aac005) 
		.append("aac006", this.aac006) 
		.append("aac009", this.aac009) 
		.append("aab301", this.aab301) 
		.append("aac00b", this.aac00b) 
		.append("aac00c", this.aac00c) 
		.append("aac00d", this.aac00d) 
		.append("bab305", this.bab305) 
		.append("aae005", this.aae005) 
		.append("aac00e", this.aac00e) 
		.append("aac011", this.aac011) 
		.append("aac180", this.aac180) 
		.append("aac181", this.aac181) 
		.append("aac017", this.aac017) 
		.append("aac024", this.aac024) 
		.append("aac033", this.aac033) 
		.append("aae015", this.aae015) 
		.append("aac022", this.aac022) 
		.append("aae007", this.aae007) 
		.append("aac023", this.aac023) 
		.append("aac032", this.aac032) 
		.append("aac034", this.aac034) 
		.append("aac035", this.aac035) 
		.append("aac036", this.aac036) 
		.append("aac025", this.aac025) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae022", this.aae022) 
		.append("ccmu01", this.ccmu01) 
		.append("ccmu50", this.ccmu50) 
		.append("ccmu51", this.ccmu51) 
		.append("ccmu52", this.ccmu52) 
		.append("ccmu53", this.ccmu53) 
		.append("ccmu54", this.ccmu54) 
		.append("ccmu55", this.ccmu55) 
		.append("ccmu56", this.ccmu56) 
		.append("cczy06", this.cczy06) 
		.append("ccmu57", this.ccmu57) 
		.append("ccmu58", this.ccmu58) 
		.append("ccmu59", this.ccmu59) 
		.append("ccmu60", this.ccmu60) 
		.append("ccmu61", this.ccmu61) 
		.append("ccmu62", this.ccmu62) 
		.append("ccpr05", this.ccpr05) 
		.append("ccpr06", this.ccpr06) 
		.append("ccpr07", this.ccpr07) 
		.append("ccpr08", this.ccpr08) 
		.append("ccmu63", this.ccmu63) 
		.append("ccmu64", this.ccmu64) 
		.append("acb223", this.acb223) 
		.append("acc01g", this.acc01g) 
		.append("aab305", this.aab305) 
		.append("bab301", this.bab301) 
		.append("acc0m1", this.acc0m1) 
		.append("div001", this.div001) 
		.append("cahy12", this.cahy12) 
		.append("aac037", this.aac037) 
		.append("aac038", this.aac038) 
		.append("ccpr04", this.ccpr04) 
		.append("aac039", this.aac039) 
		.append("aac040", this.aac040) 
		.append("aac041", this.aac041) 
		.append("aac042", this.aac042) 
		.append("aac026", this.aac026) 
		.append("aac027", this.aac027) 
		.append("aac028", this.aac028) 
		.toString();
	}
   
  

}