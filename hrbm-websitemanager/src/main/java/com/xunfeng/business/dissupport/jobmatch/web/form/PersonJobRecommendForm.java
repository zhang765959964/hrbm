package com.xunfeng.business.dissupport.jobmatch.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.dissupport.jobmatch.model.PersonJobRecommend;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 求职推荐匹配表 Form对象
* @author:wanghan
* @createDate 2016-08-15 20:00:42 
* @version V1.0   
*/
public class PersonJobRecommendForm extends BaseForm<PersonJobRecommend>
{
	// 推荐编号
	protected Long  acc220;
	// 介绍信编号
	protected String  acc221;
	// 大会编号
	protected Long  acb330;
	// 大会招聘编号
	protected Long  acb350;
	// 单位编号
	protected Long  aab001;
	// 招聘登记号
	protected Long  acb200;
	// 空位编号
	protected Long  acb210;
	// 招聘方式
	protected String  acb201;
	// 单位名称
	protected String  aab004;
	// 组织机构代码
	protected String  aab003;
	// 行业类型
	protected String  aab022;
	// 单位类型
	protected String  aab019;
	// 经济类型
	protected String  aab020;
	// 单位联系人
	protected String  aae004;
	// 单位联系电话
	protected String  aae005;
	// 单位联系手机
	protected String  aae139;
	// 单位地址
	protected String  aae006;
	// 面试起始日期
	protected java.util.Date  aae030;
	// 面试终止日期
	protected java.util.Date  aae031;
	// 面试地点
	protected String  acb20c;
	// 招聘信息经办人代码
	protected String  aaeb11;
	// 招聘信息经办机构代码
	protected String  aaeb17;
	// 招聘信息经办日期
	protected java.util.Date  aaeb36;
	// 招聘信息经办人
	protected String  aaeb19;
	// 招聘信息经办机构
	protected String  aaeb20;
	// 招聘信息经办机构行政区划
	protected String  aaeb22;
	// 个人编号
	protected Long  aac001;
	// 求职登记号
	protected Long  acc200;
	// 公民身份证号码
	protected String  aac002;
	// 姓名
	protected String  aac003;
	// 性别
	protected String  aac004;
	// 出生日期
	protected java.util.Date  aac006;
	// 年龄
	protected Long  bac006;
	// 职业资格等级
	protected String  aac015;
	// 户口性质
	protected String  aac009;
	// 文化程度
	protected String  aac011;
	// 人员类别
	protected String  acc20t;
	// 个人联系电话
	protected String  ace005;
	// 个人联系手机
	protected String  ace139;
	// 个人联系地址
	protected String  ace006;
	// 求职信息经办人代码
	protected String  aaec11;
	// 求职信息经办机构代码
	protected String  aaec17;
	// 求职信息经办日期
	protected java.util.Date  aaec36;
	// 求职信息经办人
	protected String  aaec19;
	// 求职信息经办机构
	protected String  aaec20;
	// 求职信息经办机构行政区划
	protected String  aaec22;
	// 工种名称
	protected String  aca112;
	// 职业
	protected String  aca111;
	// 工种2名称
	protected String  bca112;
	// 工种2代码
	protected String  bca111;
	// 工作地点1
	protected String  acb202;
	// 工作地点2
	protected String  bcb202;
	// 到岗日期
	protected java.util.Date  acc22c;
	// 是否签订劳动合同
	protected String  acc22b;
	// 合同期限
	protected String  acb214;
	// 月工资
	protected String  acc034;
	// 报酬福利要求
	protected String  acc214;
	// 推荐有效期
	protected java.util.Date  ace014;
	// 推荐状态详见TAB_RECTYPE
	protected String  acc223;
	// 数据来源
	protected String  bcc229;
	// 数据分类
	protected String  bcb207;
	// 备注
	protected String  aae013;
	// 推荐机构电话
	protected String  aab390;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036;
	// 经办人
	protected String  aae019;
	// 经办机构名称
	protected String  aae020;
	// 机构行政区划
	protected String  aae022;
	// 推荐失败原因详见TAB_RECFR
	protected String  acc22e;
	// 反馈机构经办意见
	protected String  aaea13;
	// 反馈机构经办人代码
	protected String  aaea11;
	// 反馈机构代码
	protected String  aaea17;
	// 反馈机构经办日期
	protected java.util.Date  aaea36;
	// 反馈机构经办人
	protected String  aaea19;
	// 反馈机构经办名称
	protected String  aaea20;
	// 反馈经办机构行政区划
	protected String  aaea22;
	// 是否转就业
	protected String  acc22h;
	// 转就业日期
	protected java.util.Date  acc22k;
	// 是否转输出
	protected String  acc22i;
	// 转输出时间
	protected java.util.Date  acc201;
	// 是否转补贴
	protected String  acc22m;
	// 转补贴时间
	protected java.util.Date  acc22n;
	// 证件号码
	protected String  aab007;
	// 工种描述主键
	protected Long  cca111;
	// 工种描述
	protected String  cca112;
	// 工种备注
	protected String  cca113;
	// 岗位描述
	protected String  cca114;
	// 最后修改时间
	protected java.util.Date  ccpr05;
	// 修改人
	protected String  ccpr06;
	// 修改来源
	protected String  ccpr07;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 推荐方式详见TAB_RECDATA
	protected String  ccpr09;
	// 是否查看（0-未查看1-已查看）
	protected Long  ccpr10;
	// 反馈数据来源（1-网站2-客户端3-民营职介4-公办职介）
	protected String  ccpr11;
	// 设备编号
	protected Long  div001;
	// 是否发送邀请面试[0:未邀请 1:已邀请]
	protected String  ccps01;
	// 面试评语编号
	protected Long  acp001;
	// 面试评语内容
	protected String  acp002;
	public void setAcc220(Long acc220) 
	{
		this.acc220 = acc220;
	}
	/**
	 * 返回 推荐编号
	 * @return
	 */
	public Long getAcc220() 
	{
		return this.acc220;
	}
	public void setAcc221(String acc221) 
	{
		this.acc221 = acc221;
	}
	/**
	 * 返回 介绍信编号
	 * @return
	 */
	public String getAcc221() 
	{
		return this.acc221;
	}
	public void setAcb330(Long acb330) 
	{
		this.acb330 = acb330;
	}
	/**
	 * 返回 大会编号
	 * @return
	 */
	public Long getAcb330() 
	{
		return this.acb330;
	}
	public void setAcb350(Long acb350) 
	{
		this.acb350 = acb350;
	}
	/**
	 * 返回 大会招聘编号
	 * @return
	 */
	public Long getAcb350() 
	{
		return this.acb350;
	}
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
	public void setAcb200(Long acb200) 
	{
		this.acb200 = acb200;
	}
	/**
	 * 返回 招聘登记号
	 * @return
	 */
	public Long getAcb200() 
	{
		return this.acb200;
	}
	public void setAcb210(Long acb210) 
	{
		this.acb210 = acb210;
	}
	/**
	 * 返回 空位编号
	 * @return
	 */
	public Long getAcb210() 
	{
		return this.acb210;
	}
	public void setAcb201(String acb201) 
	{
		this.acb201 = acb201;
	}
	/**
	 * 返回 招聘方式
	 * @return
	 */
	public String getAcb201() 
	{
		return this.acb201;
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
	public void setAab022(String aab022) 
	{
		this.aab022 = aab022;
	}
	/**
	 * 返回 行业类型
	 * @return
	 */
	public String getAab022() 
	{
		return this.aab022;
	}
	public void setAab019(String aab019) 
	{
		this.aab019 = aab019;
	}
	/**
	 * 返回 单位类型
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
	public void setAae004(String aae004) 
	{
		this.aae004 = aae004;
	}
	/**
	 * 返回 单位联系人
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
	 * 返回 单位联系电话
	 * @return
	 */
	public String getAae005() 
	{
		return this.aae005;
	}
	public void setAae139(String aae139) 
	{
		this.aae139 = aae139;
	}
	/**
	 * 返回 单位联系手机
	 * @return
	 */
	public String getAae139() 
	{
		return this.aae139;
	}
	public void setAae006(String aae006) 
	{
		this.aae006 = aae006;
	}
	/**
	 * 返回 单位地址
	 * @return
	 */
	public String getAae006() 
	{
		return this.aae006;
	}
	public void setAae030(java.util.Date aae030) 
	{
		this.aae030 = aae030;
	}
	/**
	 * 返回 面试起始日期
	 * @return
	 */
	public java.util.Date getAae030() 
	{
		return this.aae030;
	}
	public void setAae031(java.util.Date aae031) 
	{
		this.aae031 = aae031;
	}
	/**
	 * 返回 面试终止日期
	 * @return
	 */
	public java.util.Date getAae031() 
	{
		return this.aae031;
	}
	public void setAcb20c(String acb20c) 
	{
		this.acb20c = acb20c;
	}
	/**
	 * 返回 面试地点
	 * @return
	 */
	public String getAcb20c() 
	{
		return this.acb20c;
	}
	public void setAaeb11(String aaeb11) 
	{
		this.aaeb11 = aaeb11;
	}
	/**
	 * 返回 招聘信息经办人代码
	 * @return
	 */
	public String getAaeb11() 
	{
		return this.aaeb11;
	}
	public void setAaeb17(String aaeb17) 
	{
		this.aaeb17 = aaeb17;
	}
	/**
	 * 返回 招聘信息经办机构代码
	 * @return
	 */
	public String getAaeb17() 
	{
		return this.aaeb17;
	}
	public void setAaeb36(java.util.Date aaeb36) 
	{
		this.aaeb36 = aaeb36;
	}
	/**
	 * 返回 招聘信息经办日期
	 * @return
	 */
	public java.util.Date getAaeb36() 
	{
		return this.aaeb36;
	}
	public void setAaeb19(String aaeb19) 
	{
		this.aaeb19 = aaeb19;
	}
	/**
	 * 返回 招聘信息经办人
	 * @return
	 */
	public String getAaeb19() 
	{
		return this.aaeb19;
	}
	public void setAaeb20(String aaeb20) 
	{
		this.aaeb20 = aaeb20;
	}
	/**
	 * 返回 招聘信息经办机构
	 * @return
	 */
	public String getAaeb20() 
	{
		return this.aaeb20;
	}
	public void setAaeb22(String aaeb22) 
	{
		this.aaeb22 = aaeb22;
	}
	/**
	 * 返回 招聘信息经办机构行政区划
	 * @return
	 */
	public String getAaeb22() 
	{
		return this.aaeb22;
	}
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
	public void setAcc200(Long acc200) 
	{
		this.acc200 = acc200;
	}
	/**
	 * 返回 求职登记号
	 * @return
	 */
	public Long getAcc200() 
	{
		return this.acc200;
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
	public void setBac006(Long bac006) 
	{
		this.bac006 = bac006;
	}
	/**
	 * 返回 年龄
	 * @return
	 */
	public Long getBac006() 
	{
		return this.bac006;
	}
	public void setAac015(String aac015) 
	{
		this.aac015 = aac015;
	}
	/**
	 * 返回 职业资格等级
	 * @return
	 */
	public String getAac015() 
	{
		return this.aac015;
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
	public void setAcc20t(String acc20t) 
	{
		this.acc20t = acc20t;
	}
	/**
	 * 返回 人员类别
	 * @return
	 */
	public String getAcc20t() 
	{
		return this.acc20t;
	}
	public void setAce005(String ace005) 
	{
		this.ace005 = ace005;
	}
	/**
	 * 返回 个人联系电话
	 * @return
	 */
	public String getAce005() 
	{
		return this.ace005;
	}
	public void setAce139(String ace139) 
	{
		this.ace139 = ace139;
	}
	/**
	 * 返回 个人联系手机
	 * @return
	 */
	public String getAce139() 
	{
		return this.ace139;
	}
	public void setAce006(String ace006) 
	{
		this.ace006 = ace006;
	}
	/**
	 * 返回 个人联系地址
	 * @return
	 */
	public String getAce006() 
	{
		return this.ace006;
	}
	public void setAaec11(String aaec11) 
	{
		this.aaec11 = aaec11;
	}
	/**
	 * 返回 求职信息经办人代码
	 * @return
	 */
	public String getAaec11() 
	{
		return this.aaec11;
	}
	public void setAaec17(String aaec17) 
	{
		this.aaec17 = aaec17;
	}
	/**
	 * 返回 求职信息经办机构代码
	 * @return
	 */
	public String getAaec17() 
	{
		return this.aaec17;
	}
	public void setAaec36(java.util.Date aaec36) 
	{
		this.aaec36 = aaec36;
	}
	/**
	 * 返回 求职信息经办日期
	 * @return
	 */
	public java.util.Date getAaec36() 
	{
		return this.aaec36;
	}
	public void setAaec19(String aaec19) 
	{
		this.aaec19 = aaec19;
	}
	/**
	 * 返回 求职信息经办人
	 * @return
	 */
	public String getAaec19() 
	{
		return this.aaec19;
	}
	public void setAaec20(String aaec20) 
	{
		this.aaec20 = aaec20;
	}
	/**
	 * 返回 求职信息经办机构
	 * @return
	 */
	public String getAaec20() 
	{
		return this.aaec20;
	}
	public void setAaec22(String aaec22) 
	{
		this.aaec22 = aaec22;
	}
	/**
	 * 返回 求职信息经办机构行政区划
	 * @return
	 */
	public String getAaec22() 
	{
		return this.aaec22;
	}
	public void setAca112(String aca112) 
	{
		this.aca112 = aca112;
	}
	/**
	 * 返回 工种名称
	 * @return
	 */
	public String getAca112() 
	{
		return this.aca112;
	}
	public void setAca111(String aca111) 
	{
		this.aca111 = aca111;
	}
	/**
	 * 返回 职业
	 * @return
	 */
	public String getAca111() 
	{
		return this.aca111;
	}
	public void setBca112(String bca112) 
	{
		this.bca112 = bca112;
	}
	/**
	 * 返回 工种2名称
	 * @return
	 */
	public String getBca112() 
	{
		return this.bca112;
	}
	public void setBca111(String bca111) 
	{
		this.bca111 = bca111;
	}
	/**
	 * 返回 工种2代码
	 * @return
	 */
	public String getBca111() 
	{
		return this.bca111;
	}
	public void setAcb202(String acb202) 
	{
		this.acb202 = acb202;
	}
	/**
	 * 返回 工作地点1
	 * @return
	 */
	public String getAcb202() 
	{
		return this.acb202;
	}
	public void setBcb202(String bcb202) 
	{
		this.bcb202 = bcb202;
	}
	/**
	 * 返回 工作地点2
	 * @return
	 */
	public String getBcb202() 
	{
		return this.bcb202;
	}
	public void setAcc22c(java.util.Date acc22c) 
	{
		this.acc22c = acc22c;
	}
	/**
	 * 返回 到岗日期
	 * @return
	 */
	public java.util.Date getAcc22c() 
	{
		return this.acc22c;
	}
	public void setAcc22b(String acc22b) 
	{
		this.acc22b = acc22b;
	}
	/**
	 * 返回 是否签订劳动合同
	 * @return
	 */
	public String getAcc22b() 
	{
		return this.acc22b;
	}
	public void setAcb214(String acb214) 
	{
		this.acb214 = acb214;
	}
	/**
	 * 返回 合同期限
	 * @return
	 */
	public String getAcb214() 
	{
		return this.acb214;
	}
	public void setAcc034(String acc034) 
	{
		this.acc034 = acc034;
	}
	/**
	 * 返回 月工资
	 * @return
	 */
	public String getAcc034() 
	{
		return this.acc034;
	}
	public void setAcc214(String acc214) 
	{
		this.acc214 = acc214;
	}
	/**
	 * 返回 报酬福利要求
	 * @return
	 */
	public String getAcc214() 
	{
		return this.acc214;
	}
	public void setAce014(java.util.Date ace014) 
	{
		this.ace014 = ace014;
	}
	/**
	 * 返回 推荐有效期
	 * @return
	 */
	public java.util.Date getAce014() 
	{
		return this.ace014;
	}
	public void setAcc223(String acc223) 
	{
		this.acc223 = acc223;
	}
	/**
	 * 返回 推荐状态详见TAB_RECTYPE
	 * @return
	 */
	public String getAcc223() 
	{
		return this.acc223;
	}
	public void setBcc229(String bcc229) 
	{
		this.bcc229 = bcc229;
	}
	/**
	 * 返回 数据来源
	 * @return
	 */
	public String getBcc229() 
	{
		return this.bcc229;
	}
	public void setBcb207(String bcb207) 
	{
		this.bcb207 = bcb207;
	}
	/**
	 * 返回 数据分类
	 * @return
	 */
	public String getBcb207() 
	{
		return this.bcb207;
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
	public void setAab390(String aab390) 
	{
		this.aab390 = aab390;
	}
	/**
	 * 返回 推荐机构电话
	 * @return
	 */
	public String getAab390() 
	{
		return this.aab390;
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
	 * 返回 经办机构名称
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
	 * 返回 机构行政区划
	 * @return
	 */
	public String getAae022() 
	{
		return this.aae022;
	}
	public void setAcc22e(String acc22e) 
	{
		this.acc22e = acc22e;
	}
	/**
	 * 返回 推荐失败原因详见TAB_RECFR
	 * @return
	 */
	public String getAcc22e() 
	{
		return this.acc22e;
	}
	public void setAaea13(String aaea13) 
	{
		this.aaea13 = aaea13;
	}
	/**
	 * 返回 反馈机构经办意见
	 * @return
	 */
	public String getAaea13() 
	{
		return this.aaea13;
	}
	public void setAaea11(String aaea11) 
	{
		this.aaea11 = aaea11;
	}
	/**
	 * 返回 反馈机构经办人代码
	 * @return
	 */
	public String getAaea11() 
	{
		return this.aaea11;
	}
	public void setAaea17(String aaea17) 
	{
		this.aaea17 = aaea17;
	}
	/**
	 * 返回 反馈机构代码
	 * @return
	 */
	public String getAaea17() 
	{
		return this.aaea17;
	}
	public void setAaea36(java.util.Date aaea36) 
	{
		this.aaea36 = aaea36;
	}
	/**
	 * 返回 反馈机构经办日期
	 * @return
	 */
	public java.util.Date getAaea36() 
	{
		return this.aaea36;
	}
	public void setAaea19(String aaea19) 
	{
		this.aaea19 = aaea19;
	}
	/**
	 * 返回 反馈机构经办人
	 * @return
	 */
	public String getAaea19() 
	{
		return this.aaea19;
	}
	public void setAaea20(String aaea20) 
	{
		this.aaea20 = aaea20;
	}
	/**
	 * 返回 反馈机构经办名称
	 * @return
	 */
	public String getAaea20() 
	{
		return this.aaea20;
	}
	public void setAaea22(String aaea22) 
	{
		this.aaea22 = aaea22;
	}
	/**
	 * 返回 反馈经办机构行政区划
	 * @return
	 */
	public String getAaea22() 
	{
		return this.aaea22;
	}
	public void setAcc22h(String acc22h) 
	{
		this.acc22h = acc22h;
	}
	/**
	 * 返回 是否转就业
	 * @return
	 */
	public String getAcc22h() 
	{
		return this.acc22h;
	}
	public void setAcc22k(java.util.Date acc22k) 
	{
		this.acc22k = acc22k;
	}
	/**
	 * 返回 转就业日期
	 * @return
	 */
	public java.util.Date getAcc22k() 
	{
		return this.acc22k;
	}
	public void setAcc22i(String acc22i) 
	{
		this.acc22i = acc22i;
	}
	/**
	 * 返回 是否转输出
	 * @return
	 */
	public String getAcc22i() 
	{
		return this.acc22i;
	}
	public void setAcc201(java.util.Date acc201) 
	{
		this.acc201 = acc201;
	}
	/**
	 * 返回 转输出时间
	 * @return
	 */
	public java.util.Date getAcc201() 
	{
		return this.acc201;
	}
	public void setAcc22m(String acc22m) 
	{
		this.acc22m = acc22m;
	}
	/**
	 * 返回 是否转补贴
	 * @return
	 */
	public String getAcc22m() 
	{
		return this.acc22m;
	}
	public void setAcc22n(java.util.Date acc22n) 
	{
		this.acc22n = acc22n;
	}
	/**
	 * 返回 转补贴时间
	 * @return
	 */
	public java.util.Date getAcc22n() 
	{
		return this.acc22n;
	}
	public void setAab007(String aab007) 
	{
		this.aab007 = aab007;
	}
	/**
	 * 返回 证件号码
	 * @return
	 */
	public String getAab007() 
	{
		return this.aab007;
	}
	public void setCca111(Long cca111) 
	{
		this.cca111 = cca111;
	}
	/**
	 * 返回 工种描述主键
	 * @return
	 */
	public Long getCca111() 
	{
		return this.cca111;
	}
	public void setCca112(String cca112) 
	{
		this.cca112 = cca112;
	}
	/**
	 * 返回 工种描述
	 * @return
	 */
	public String getCca112() 
	{
		return this.cca112;
	}
	public void setCca113(String cca113) 
	{
		this.cca113 = cca113;
	}
	/**
	 * 返回 工种备注
	 * @return
	 */
	public String getCca113() 
	{
		return this.cca113;
	}
	public void setCca114(String cca114) 
	{
		this.cca114 = cca114;
	}
	/**
	 * 返回 岗位描述
	 * @return
	 */
	public String getCca114() 
	{
		return this.cca114;
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
	public void setCcpr09(String ccpr09) 
	{
		this.ccpr09 = ccpr09;
	}
	/**
	 * 返回 推荐方式详见TAB_RECDATA
	 * @return
	 */
	public String getCcpr09() 
	{
		return this.ccpr09;
	}
	public void setCcpr10(Long ccpr10) 
	{
		this.ccpr10 = ccpr10;
	}
	/**
	 * 返回 是否查看（0-未查看1-已查看）
	 * @return
	 */
	public Long getCcpr10() 
	{
		return this.ccpr10;
	}
	public void setCcpr11(String ccpr11) 
	{
		this.ccpr11 = ccpr11;
	}
	/**
	 * 返回 反馈数据来源（1-网站2-客户端3-民营职介4-公办职介）
	 * @return
	 */
	public String getCcpr11() 
	{
		return this.ccpr11;
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
	public void setCcps01(String ccps01) 
	{
		this.ccps01 = ccps01;
	}
	/**
	 * 返回 是否发送邀请面试[0:未邀请 1:已邀请]
	 * @return
	 */
	public String getCcps01() 
	{
		return this.ccps01;
	}
	public void setAcp001(Long acp001) 
	{
		this.acp001 = acp001;
	}
	/**
	 * 返回 面试评语编号
	 * @return
	 */
	public Long getAcp001() 
	{
		return this.acp001;
	}
	public void setAcp002(String acp002) 
	{
		this.acp002 = acp002;
	}
	/**
	 * 返回 面试评语内容
	 * @return
	 */
	public String getAcp002() 
	{
		return this.acp002;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof PersonJobRecommendForm)) 
		{
			return false;
		}
		PersonJobRecommendForm rhs = (PersonJobRecommendForm) object;
		return new EqualsBuilder()
		.append(this.acc220, rhs.acc220)
		.append(this.acc221, rhs.acc221)
		.append(this.acb330, rhs.acb330)
		.append(this.acb350, rhs.acb350)
		.append(this.aab001, rhs.aab001)
		.append(this.acb200, rhs.acb200)
		.append(this.acb210, rhs.acb210)
		.append(this.acb201, rhs.acb201)
		.append(this.aab004, rhs.aab004)
		.append(this.aab003, rhs.aab003)
		.append(this.aab022, rhs.aab022)
		.append(this.aab019, rhs.aab019)
		.append(this.aab020, rhs.aab020)
		.append(this.aae004, rhs.aae004)
		.append(this.aae005, rhs.aae005)
		.append(this.aae139, rhs.aae139)
		.append(this.aae006, rhs.aae006)
		.append(this.aae030, rhs.aae030)
		.append(this.aae031, rhs.aae031)
		.append(this.acb20c, rhs.acb20c)
		.append(this.aaeb11, rhs.aaeb11)
		.append(this.aaeb17, rhs.aaeb17)
		.append(this.aaeb36, rhs.aaeb36)
		.append(this.aaeb19, rhs.aaeb19)
		.append(this.aaeb20, rhs.aaeb20)
		.append(this.aaeb22, rhs.aaeb22)
		.append(this.aac001, rhs.aac001)
		.append(this.acc200, rhs.acc200)
		.append(this.aac002, rhs.aac002)
		.append(this.aac003, rhs.aac003)
		.append(this.aac004, rhs.aac004)
		.append(this.aac006, rhs.aac006)
		.append(this.bac006, rhs.bac006)
		.append(this.aac015, rhs.aac015)
		.append(this.aac009, rhs.aac009)
		.append(this.aac011, rhs.aac011)
		.append(this.acc20t, rhs.acc20t)
		.append(this.ace005, rhs.ace005)
		.append(this.ace139, rhs.ace139)
		.append(this.ace006, rhs.ace006)
		.append(this.aaec11, rhs.aaec11)
		.append(this.aaec17, rhs.aaec17)
		.append(this.aaec36, rhs.aaec36)
		.append(this.aaec19, rhs.aaec19)
		.append(this.aaec20, rhs.aaec20)
		.append(this.aaec22, rhs.aaec22)
		.append(this.aca112, rhs.aca112)
		.append(this.aca111, rhs.aca111)
		.append(this.bca112, rhs.bca112)
		.append(this.bca111, rhs.bca111)
		.append(this.acb202, rhs.acb202)
		.append(this.bcb202, rhs.bcb202)
		.append(this.acc22c, rhs.acc22c)
		.append(this.acc22b, rhs.acc22b)
		.append(this.acb214, rhs.acb214)
		.append(this.acc034, rhs.acc034)
		.append(this.acc214, rhs.acc214)
		.append(this.ace014, rhs.ace014)
		.append(this.acc223, rhs.acc223)
		.append(this.bcc229, rhs.bcc229)
		.append(this.bcb207, rhs.bcb207)
		.append(this.aae013, rhs.aae013)
		.append(this.aab390, rhs.aab390)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae022, rhs.aae022)
		.append(this.acc22e, rhs.acc22e)
		.append(this.aaea13, rhs.aaea13)
		.append(this.aaea11, rhs.aaea11)
		.append(this.aaea17, rhs.aaea17)
		.append(this.aaea36, rhs.aaea36)
		.append(this.aaea19, rhs.aaea19)
		.append(this.aaea20, rhs.aaea20)
		.append(this.aaea22, rhs.aaea22)
		.append(this.acc22h, rhs.acc22h)
		.append(this.acc22k, rhs.acc22k)
		.append(this.acc22i, rhs.acc22i)
		.append(this.acc201, rhs.acc201)
		.append(this.acc22m, rhs.acc22m)
		.append(this.acc22n, rhs.acc22n)
		.append(this.aab007, rhs.aab007)
		.append(this.cca111, rhs.cca111)
		.append(this.cca112, rhs.cca112)
		.append(this.cca113, rhs.cca113)
		.append(this.cca114, rhs.cca114)
		.append(this.ccpr05, rhs.ccpr05)
		.append(this.ccpr06, rhs.ccpr06)
		.append(this.ccpr07, rhs.ccpr07)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.ccpr09, rhs.ccpr09)
		.append(this.ccpr10, rhs.ccpr10)
		.append(this.ccpr11, rhs.ccpr11)
		.append(this.div001, rhs.div001)
		.append(this.ccps01, rhs.ccps01)
		.append(this.acp001, rhs.acp001)
		.append(this.acp002, rhs.acp002)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.acc220) 
		.append(this.acc221) 
		.append(this.acb330) 
		.append(this.acb350) 
		.append(this.aab001) 
		.append(this.acb200) 
		.append(this.acb210) 
		.append(this.acb201) 
		.append(this.aab004) 
		.append(this.aab003) 
		.append(this.aab022) 
		.append(this.aab019) 
		.append(this.aab020) 
		.append(this.aae004) 
		.append(this.aae005) 
		.append(this.aae139) 
		.append(this.aae006) 
		.append(this.aae030) 
		.append(this.aae031) 
		.append(this.acb20c) 
		.append(this.aaeb11) 
		.append(this.aaeb17) 
		.append(this.aaeb36) 
		.append(this.aaeb19) 
		.append(this.aaeb20) 
		.append(this.aaeb22) 
		.append(this.aac001) 
		.append(this.acc200) 
		.append(this.aac002) 
		.append(this.aac003) 
		.append(this.aac004) 
		.append(this.aac006) 
		.append(this.bac006) 
		.append(this.aac015) 
		.append(this.aac009) 
		.append(this.aac011) 
		.append(this.acc20t) 
		.append(this.ace005) 
		.append(this.ace139) 
		.append(this.ace006) 
		.append(this.aaec11) 
		.append(this.aaec17) 
		.append(this.aaec36) 
		.append(this.aaec19) 
		.append(this.aaec20) 
		.append(this.aaec22) 
		.append(this.aca112) 
		.append(this.aca111) 
		.append(this.bca112) 
		.append(this.bca111) 
		.append(this.acb202) 
		.append(this.bcb202) 
		.append(this.acc22c) 
		.append(this.acc22b) 
		.append(this.acb214) 
		.append(this.acc034) 
		.append(this.acc214) 
		.append(this.ace014) 
		.append(this.acc223) 
		.append(this.bcc229) 
		.append(this.bcb207) 
		.append(this.aae013) 
		.append(this.aab390) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.aae022) 
		.append(this.acc22e) 
		.append(this.aaea13) 
		.append(this.aaea11) 
		.append(this.aaea17) 
		.append(this.aaea36) 
		.append(this.aaea19) 
		.append(this.aaea20) 
		.append(this.aaea22) 
		.append(this.acc22h) 
		.append(this.acc22k) 
		.append(this.acc22i) 
		.append(this.acc201) 
		.append(this.acc22m) 
		.append(this.acc22n) 
		.append(this.aab007) 
		.append(this.cca111) 
		.append(this.cca112) 
		.append(this.cca113) 
		.append(this.cca114) 
		.append(this.ccpr05) 
		.append(this.ccpr06) 
		.append(this.ccpr07) 
		.append(this.ccpr08) 
		.append(this.ccpr09) 
		.append(this.ccpr10) 
		.append(this.ccpr11) 
		.append(this.div001) 
		.append(this.ccps01) 
		.append(this.acp001) 
		.append(this.acp002) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("acc220", this.acc220) 
		.append("acc221", this.acc221) 
		.append("acb330", this.acb330) 
		.append("acb350", this.acb350) 
		.append("aab001", this.aab001) 
		.append("acb200", this.acb200) 
		.append("acb210", this.acb210) 
		.append("acb201", this.acb201) 
		.append("aab004", this.aab004) 
		.append("aab003", this.aab003) 
		.append("aab022", this.aab022) 
		.append("aab019", this.aab019) 
		.append("aab020", this.aab020) 
		.append("aae004", this.aae004) 
		.append("aae005", this.aae005) 
		.append("aae139", this.aae139) 
		.append("aae006", this.aae006) 
		.append("aae030", this.aae030) 
		.append("aae031", this.aae031) 
		.append("acb20c", this.acb20c) 
		.append("aaeb11", this.aaeb11) 
		.append("aaeb17", this.aaeb17) 
		.append("aaeb36", this.aaeb36) 
		.append("aaeb19", this.aaeb19) 
		.append("aaeb20", this.aaeb20) 
		.append("aaeb22", this.aaeb22) 
		.append("aac001", this.aac001) 
		.append("acc200", this.acc200) 
		.append("aac002", this.aac002) 
		.append("aac003", this.aac003) 
		.append("aac004", this.aac004) 
		.append("aac006", this.aac006) 
		.append("bac006", this.bac006) 
		.append("aac015", this.aac015) 
		.append("aac009", this.aac009) 
		.append("aac011", this.aac011) 
		.append("acc20t", this.acc20t) 
		.append("ace005", this.ace005) 
		.append("ace139", this.ace139) 
		.append("ace006", this.ace006) 
		.append("aaec11", this.aaec11) 
		.append("aaec17", this.aaec17) 
		.append("aaec36", this.aaec36) 
		.append("aaec19", this.aaec19) 
		.append("aaec20", this.aaec20) 
		.append("aaec22", this.aaec22) 
		.append("aca112", this.aca112) 
		.append("aca111", this.aca111) 
		.append("bca112", this.bca112) 
		.append("bca111", this.bca111) 
		.append("acb202", this.acb202) 
		.append("bcb202", this.bcb202) 
		.append("acc22c", this.acc22c) 
		.append("acc22b", this.acc22b) 
		.append("acb214", this.acb214) 
		.append("acc034", this.acc034) 
		.append("acc214", this.acc214) 
		.append("ace014", this.ace014) 
		.append("acc223", this.acc223) 
		.append("bcc229", this.bcc229) 
		.append("bcb207", this.bcb207) 
		.append("aae013", this.aae013) 
		.append("aab390", this.aab390) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae022", this.aae022) 
		.append("acc22e", this.acc22e) 
		.append("aaea13", this.aaea13) 
		.append("aaea11", this.aaea11) 
		.append("aaea17", this.aaea17) 
		.append("aaea36", this.aaea36) 
		.append("aaea19", this.aaea19) 
		.append("aaea20", this.aaea20) 
		.append("aaea22", this.aaea22) 
		.append("acc22h", this.acc22h) 
		.append("acc22k", this.acc22k) 
		.append("acc22i", this.acc22i) 
		.append("acc201", this.acc201) 
		.append("acc22m", this.acc22m) 
		.append("acc22n", this.acc22n) 
		.append("aab007", this.aab007) 
		.append("cca111", this.cca111) 
		.append("cca112", this.cca112) 
		.append("cca113", this.cca113) 
		.append("cca114", this.cca114) 
		.append("ccpr05", this.ccpr05) 
		.append("ccpr06", this.ccpr06) 
		.append("ccpr07", this.ccpr07) 
		.append("ccpr08", this.ccpr08) 
		.append("ccpr09", this.ccpr09) 
		.append("ccpr10", this.ccpr10) 
		.append("ccpr11", this.ccpr11) 
		.append("div001", this.div001) 
		.append("ccps01", this.ccps01) 
		.append("acp001", this.acp001) 
		.append("acp002", this.acp002) 
		.toString();
	}
   
  

}