package com.xunfeng.business.person.web.form;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.core.model.BaseForm;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人基本信息表 Form对象
* @author:wanlupeng
* @createDate 2016-06-08 10:48:15 
* @version V1.0   
*/
public class PersonBaseInfoForm extends BaseForm<PersonBaseInfo>
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
	// 数据来源（0-未知1-网站2-窗口3-民营机构4-公办机构）其他详见tab_datasources
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
	// 个人基本信息是否完整
	protected String  ccmu70;
	/** 就业 **/
	// 就业失业ID
	protected Long  acc0m01;
	// 单位名称
	protected String  aab004;
	// 单位性质
	protected String  aab019;
	// 产业类别
	protected String  aab054;
	// 经济类型
	protected String  aab020;
	// 就业形势
	protected String  accm02;
	// 就业时间
	protected java.util.Date  accm03;
	// 签订劳动合同情况（1是2否）
	protected String  accm04;
	// 合同开始时间
	protected java.util.Date  accm05;
	// 合同结束时间
	protected java.util.Date  accm06;
	// 合同情况（1本县内，2本镇内，3本镇外，4本市外区，5出国务工，6外省市）
	protected String  accm07;
	// 出国务工外出时间
	protected java.util.Date  accm08;
	// 外省市外出时间
	protected java.util.Date  accm09;
	// 外省市工作地点代码
	protected String  accm10;
	// 对目前工作是否满意（1是，2否）
	protected String  accm11;
	// 对工作不满意的原因
	protected String  accm12;
	// 人员类别
	protected String  acc20t;
	// 灵活就业类别（1企业零散用工，2弹性就业3家政服务，4自由职业5街头自营，6打零工，7其他）
	protected String  accm13;
	/** 不在岗信息  **/
	// 不在岗ID
	protected Long  acpost01;
	// 单位名称
	protected String  aab004t;
	// 单位性质
	protected String  aab019t;
	// 经济类型
	protected String  aab020t;
	// 不在岗原因（1、不安排工作岗位，2、轮岗，3、停薪留职，4、办理内退，5其他形式）
	protected String  accm14;
	// 不在岗原因其他形式
	protected String  accm15;
	// 不在岗时间
	protected java.util.Date  accm16;
	// 是否发放生活费（1是，2否）
	protected String  accm17;
	// 生活费标准
	protected String  accm18;
	/** 未就业以及失业 **/
	//未就业以及失业ID
	protected Long  acemp01;
	// 单位名称
	protected String  aab004m;
	// 单位性质
	protected String  aab019m;
	// 经济类型
	protected String  aab020m;
	// 未就业及失业人员类别
	protected String  acc20m;
	// 未就业原因（1无就业愿望，2家庭原因，3无就业能力，4正在培训，5没有合适的工作，6年龄偏大，7对找工作丧失信心，8其他原因）
	protected String  accm19;
	// 失业主要原因
	protected String  accm20;
	// 最后一次失业登记时间
	protected java.util.Date  accm21;
	// 上一次劳动合同终止或解除时间
	protected java.util.Date  accm22;
	// 经劳动部门认定的困难群体
	protected String  accm23;
	/** 个人培训经历  **/
	
	// 培训经历编号
	protected Long  acc0b0;
	// 培训机构名称
	protected String  acc0b1;
	// 培训课程
	protected String  acc0b2;
	// 培训内容
	protected String  acc0b3;
	// 开始时间
	protected java.util.Date  aae030;
	// 结束时间
	protected java.util.Date  aae031;
	/**扩展表字段**/
	// 主键id
	protected Long  expandId;
	// 主键id
	protected Long  expPersonId;
	// 参加工作时间
	protected java.util.Date  expStartJobDate;
	// 曾用名
	protected String  expUserName;
	// 个人编号
	protected String  expPersonNumber;
	// 档案编号
	protected String  expArchivesNumber;
	// 通用1
	protected String  expGengral1;
	// 原工作单位
	protected String  expOldCompany;
	// 社保状态
	protected Long  expSecStatus;
	// 备注
	protected String  expRemarks;
	// 创建人id
	protected Long  expOpeartorUserId;
	// 创建时间
	protected java.util.Date  expOpeartorDate;
	// 视同
	protected String  expEquate;
	// 个人状态(TAB_PSTATUS)
	protected String  expPersonStatus;
	// 联系电话(ac01中AAE005存手机号)
	protected String  expPersonPhone;
	// 户口登记日期
	protected java.util.Date  expHourseDate;
	// 详细地址
	protected String  expAddress;
	// 职务
	protected String  expPost;
	// 国家职业资格等级(TAB_COQ)
	protected String  expLevel;
	// 取得职业资格等级日期
	protected java.util.Date  expLevelDate;
	// 职业工种资格ID（TAB_CRAFT）
	protected String  expPositionCode;
	// 职业工种资格名称（TAB_CRAFT）
	protected String  expPositionName;
	// 专业技术职务（TAB_TITLE）
	protected String  expTechnical;
	// 取得专业技术职务资格日期
	protected java.util.Date  expTechnicalDate;
	// 是否零就业家庭（0-否，1-是）
	protected String  expIsFamily;
	// 是否就业困难人员（0-否，1-是）
	protected String  expIsDifficult;
	// 是否转干部（0-否，1-是）
	protected String  expIsCadre;
	// 是否享有再就业优惠证标准（0-否，1-是）
	protected String  expIsDiscount;
	// 是否持有就业失业登记证（0-否，1-是）
	protected String  expIsRegisgration;
	// 再就业优惠证编号
	protected String  expRegisgration;
	// 身份证住址
	protected String  expCardNumber;
	// 就业困难人员类别（TAB_EDO）
	protected String  expHardPerson;
	//社会保障号
	protected String  expSoctalNumber;
	//委托单位名称
	protected String  expEntrustCompany;
	/**家庭关系字段**/
	// 主键ID
	protected Long  id;
	// 配偶姓名
	protected String  faName;
	// 婚姻状况
	protected String  faMarriage;
	// 结婚时间
	protected java.util.Date  faMarriageDate;
	// 配偶身份证号
	protected String  faSpouseCard;
	// 人员ID
	protected Long  faPersonId;
	// 配偶出生日期
	protected java.util.Date  faSpouseBirth;
	// 配偶民族
	protected String  faSpouseNational;
	// 配偶单位
	protected String  faSpouseCompany;
	// 配偶电话
	protected String  faSpousePhone;
	// 计生情况（TAB_CONDITION）
	protected String  faBirthCondition;
	// 节育措施（TAB_BIRTHCONTROL）
	protected String  faBirthControl;
	// 家庭情况备注
	protected String  faFamilyBark;
	//就业失业情况（1-就业，2-不在岗，3-未就业及失业，4-服刑，5-出国定居，6-在学）
	protected String  expacc0m;
	//标记（1-劳动力系统，0-其他系统）
	protected String  sign;
	//是否发送短信标志
	protected String  nodeLogs;
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
	 * 返回 数据来源（0-未知1-网站2-窗口3-民营机构4-公办机构）其他详见tab_datasources
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
	public void setAcc0m01(Long acc0m01) 
	{
		this.acc0m01 = acc0m01;
	}
	/**
	 * 返回 就业失业ID
	 * @return
	 */
	public Long getAcc0m01() 
	{
		return this.acc0m01;
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
	public void setCcmu70(String ccmu70) 
	{
		this.ccmu70 = ccmu70;
	}
	/**
	 * 返回 个人基本信息是否完整
	 * @return
	 */
	public String getCcmu70() 
	{
		return this.ccmu70;
	}/**
	 * 返回 单位名称
	 * @return
	 */
	public String getAab004() 
	{
		return this.aab004;
	}
	public void setAab004(String aab004) 
	{
		this.aab004 = aab004;
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
	public void setAccm02(String accm02) 
	{
		this.accm02 = accm02;
	}
	/**
	 * 返回 就业形势
	 * @return
	 */
	public String getAccm02() 
	{
		return this.accm02;
	}
	public void setAccm03(java.util.Date accm03) 
	{
		this.accm03 = accm03;
	}
	/**
	 * 返回 就业时间
	 * @return
	 */
	public java.util.Date getAccm03() 
	{
		return this.accm03;
	}
	public void setAccm04(String accm04) 
	{
		this.accm04 = accm04;
	}
	/**
	 * 返回 签订劳动合同情况（1是2否）
	 * @return
	 */
	public String getAccm04() 
	{
		return this.accm04;
	}
	public void setAccm05(java.util.Date accm05) 
	{
		this.accm05 = accm05;
	}
	/**
	 * 返回 合同开始时间
	 * @return
	 */
	public java.util.Date getAccm05() 
	{
		return this.accm05;
	}
	public void setAccm06(java.util.Date accm06) 
	{
		this.accm06 = accm06;
	}
	/**
	 * 返回 合同结束时间
	 * @return
	 */
	public java.util.Date getAccm06() 
	{
		return this.accm06;
	}
	public void setAccm07(String accm07) 
	{
		this.accm07 = accm07;
	}
	/**
	 * 返回 合同情况（1本县内，2本镇内，3本镇外，4本市外区，5出国务工，6外省市）
	 * @return
	 */
	public String getAccm07() 
	{
		return this.accm07;
	}
	public void setAccm08(java.util.Date accm08) 
	{
		this.accm08 = accm08;
	}
	/**
	 * 返回 出国务工外出时间
	 * @return
	 */
	public java.util.Date getAccm08() 
	{
		return this.accm08;
	}
	public void setAccm09(java.util.Date accm09) 
	{
		this.accm09 = accm09;
	}
	/**
	 * 返回 外省市外出时间
	 * @return
	 */
	public java.util.Date getAccm09() 
	{
		return this.accm09;
	}
	public void setAccm10(String accm10) 
	{
		this.accm10 = accm10;
	}
	/**
	 * 返回 外省市工作地点代码
	 * @return
	 */
	public String getAccm10() 
	{
		return this.accm10;
	}
	public void setAccm11(String accm11) 
	{
		this.accm11 = accm11;
	}
	/**
	 * 返回 对目前工作是否满意（1是，2否）
	 * @return
	 */
	public String getAccm11() 
	{
		return this.accm11;
	}
	public void setAccm12(String accm12) 
	{
		this.accm12 = accm12;
	}
	public String getAab004m() {
		return aab004m;
	}
	public void setAab004m(String aab004m) {
		this.aab004m = aab004m;
	}
	public String getAab019m() {
		return aab019m;
	}
	public void setAab019m(String aab019m) {
		this.aab019m = aab019m;
	}
	public String getAab020m() {
		return aab020m;
	}
	public void setAab020m(String aab020m) {
		this.aab020m = aab020m;
	}
	public String getAcc20m() {
		return acc20m;
	}
	public void setAcc20m(String acc20m) {
		this.acc20m = acc20m;
	}
	public String getAccm19() {
		return accm19;
	}
	public void setAccm19(String accm19) {
		this.accm19 = accm19;
	}
	public String getAccm20() {
		return accm20;
	}
	public void setAccm20(String accm20) {
		this.accm20 = accm20;
	}
	public java.util.Date getAccm21() {
		return accm21;
	}
	public void setAccm21(java.util.Date accm21) {
		this.accm21 = accm21;
	}
	public java.util.Date getAccm22() {
		return accm22;
	}
	public void setAccm22(java.util.Date accm22) {
		this.accm22 = accm22;
	}
	public String getAccm23() {
		return accm23;
	}
	public void setAccm23(String accm23) {
		this.accm23 = accm23;
	}
	/**
	 * 返回 对工作不满意的原因
	 * @return
	 */
	public String getAccm12() 
	{
		return this.accm12;
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
	public void setAccm13(String accm13) 
	{
		this.accm13 = accm13;
	}
	/**
	 * 返回 灵活就业类别（1企业零散用工，2弹性就业3家政服务，4自由职业5街头自营，6打零工，7其他）
	 * @return
	 */
	public String getAccm13() 
	{
		return this.accm13;
	}
	
   	public Long getAcpost01() {
		return acpost01;
	}
	public void setAcpost01(Long acpost01) {
		this.acpost01 = acpost01;
	}
	public String getAab004t() {
		return aab004t;
	}
	public void setAab004t(String aab004t) {
		this.aab004t = aab004t;
	}
	public String getAab019t() {
		return aab019t;
	}
	public void setAab019t(String aab019t) {
		this.aab019t = aab019t;
	}
	public String getAab020t() {
		return aab020t;
	}
	public void setAab020t(String aab020t) {
		this.aab020t = aab020t;
	}
	public String getAccm14() {
		return accm14;
	}
	public void setAccm14(String accm14) {
		this.accm14 = accm14;
	}
	public String getAccm15() {
		return accm15;
	}
	public void setAccm15(String accm15) {
		this.accm15 = accm15;
	}
	public java.util.Date getAccm16() {
		return accm16;
	}
	public void setAccm16(java.util.Date accm16) {
		this.accm16 = accm16;
	}
	public String getAccm17() {
		return accm17;
	}
	public void setAccm17(String accm17) {
		this.accm17 = accm17;
	}
	public String getAccm18() {
		return accm18;
	}
	public void setAccm18(String accm18) {
		this.accm18 = accm18;
	}
	public Long getAcemp01() {
		return acemp01;
	}
	public void setAcemp01(Long acemp01) {
		this.acemp01 = acemp01;
	}
	public Long getAcc0b0() {
		return acc0b0;
	}
	public void setAcc0b0(Long acc0b0) {
		this.acc0b0 = acc0b0;
	}
	public String getAcc0b1() {
		return acc0b1;
	}
	public void setAcc0b1(String acc0b1) {
		this.acc0b1 = acc0b1;
	}
	public String getAcc0b2() {
		return acc0b2;
	}
	public void setAcc0b2(String acc0b2) {
		this.acc0b2 = acc0b2;
	}
	public String getAcc0b3() {
		return acc0b3;
	}
	public void setAcc0b3(String acc0b3) {
		this.acc0b3 = acc0b3;
	}
	public java.util.Date getAae030() {
		return aae030;
	}
	public void setAae030(java.util.Date aae030) {
		this.aae030 = aae030;
	}
	public java.util.Date getAae031() {
		return aae031;
	}
	public void setAae031(java.util.Date aae031) {
		this.aae031 = aae031;
	}
	public void setExpStartJobDate(java.util.Date expStartJobDate) 
	{
		this.expStartJobDate = expStartJobDate;
	}
	/**
	 * 返回 参加工作时间
	 * @return
	 */
	public java.util.Date getExpStartJobDate() 
	{
		return this.expStartJobDate;
	}
	public void setExpUserName(String expUserName) 
	{
		this.expUserName = expUserName;
	}
	/**
	 * 返回 曾用名
	 * @return
	 */
	public String getExpUserName() 
	{
		return this.expUserName;
	}
	public void setExpPersonNumber(String expPersonNumber) 
	{
		this.expPersonNumber = expPersonNumber;
	}
	/**
	 * 返回 个人编号
	 * @return
	 */
	public String getExpPersonNumber() 
	{
		return this.expPersonNumber;
	}
	public void setExpArchivesNumber(String expArchivesNumber) 
	{
		this.expArchivesNumber = expArchivesNumber;
	}
	/**
	 * 返回 档案编号
	 * @return
	 */
	public String getExpArchivesNumber() 
	{
		return this.expArchivesNumber;
	}
	public void setExpGengral1(String expGengral1) 
	{
		this.expGengral1 = expGengral1;
	}
	/**
	 * 返回 通用1
	 * @return
	 */
	public String getExpGengral1() 
	{
		return this.expGengral1;
	}
	public void setExpOldCompany(String expOldCompany) 
	{
		this.expOldCompany = expOldCompany;
	}
	/**
	 * 返回 原工作单位
	 * @return
	 */
	public String getExpOldCompany() 
	{
		return this.expOldCompany;
	}
	public void setExpSecStatus(Long expSecStatus) 
	{
		this.expSecStatus = expSecStatus;
	}
	/**
	 * 返回 社保状态
	 * @return
	 */
	public Long getExpSecStatus() 
	{
		return this.expSecStatus;
	}
	public void setExpRemarks(String expRemarks) 
	{
		this.expRemarks = expRemarks;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getExpRemarks() 
	{
		return this.expRemarks;
	}
	public void setExpOpeartorUserId(Long expOpeartorUserId) 
	{
		this.expOpeartorUserId = expOpeartorUserId;
	}
	/**
	 * 返回 创建人id
	 * @return
	 */
	public Long getExpOpeartorUserId() 
	{
		return this.expOpeartorUserId;
	}
	public void setExpOpeartorDate(java.util.Date expOpeartorDate) 
	{
		this.expOpeartorDate = expOpeartorDate;
	}
	/**
	 * 返回 创建时间
	 * @return
	 */
	public java.util.Date getExpOpeartorDate() 
	{
		return this.expOpeartorDate;
	}
	public void setExpEquate(String expEquate) 
	{
		this.expEquate = expEquate;
	}
	/**
	 * 返回 视同
	 * @return
	 */
	public String getExpEquate() 
	{
		return this.expEquate;
	}
	public void setExpPersonStatus(String expPersonStatus) 
	{
		this.expPersonStatus = expPersonStatus;
	}
	/**
	 * 返回 个人状态(TAB_PSTATUS)
	 * @return
	 */
	public String getExpPersonStatus() 
	{
		return this.expPersonStatus;
	}
	public void setExpPersonPhone(String expPersonPhone) 
	{
		this.expPersonPhone = expPersonPhone;
	}
	/**
	 * 返回 联系电话(ac01中AAE005存手机号)
	 * @return
	 */
	public String getExpPersonPhone() 
	{
		return this.expPersonPhone;
	}
	public void setExpHourseDate(java.util.Date expHourseDate) 
	{
		this.expHourseDate = expHourseDate;
	}
	/**
	 * 返回 户口登记日期
	 * @return
	 */
	public java.util.Date getExpHourseDate() 
	{
		return this.expHourseDate;
	}
	public void setExpAddress(String expAddress) 
	{
		this.expAddress = expAddress;
	}
	/**
	 * 返回 详细地址
	 * @return
	 */
	public String getExpAddress() 
	{
		return this.expAddress;
	}
	public void setExpPost(String expPost) 
	{
		this.expPost = expPost;
	}
	/**
	 * 返回 职务
	 * @return
	 */
	public String getExpPost() 
	{
		return this.expPost;
	}
	public void setExpLevel(String expLevel) 
	{
		this.expLevel = expLevel;
	}
	/**
	 * 返回 国家职业资格等级(TAB_COQ)
	 * @return
	 */
	public String getExpLevel() 
	{
		return this.expLevel;
	}
	public void setExpLevelDate(java.util.Date expLevelDate) 
	{
		this.expLevelDate = expLevelDate;
	}
	/**
	 * 返回 取得职业资格等级日期
	 * @return
	 */
	public java.util.Date getExpLevelDate() 
	{
		return this.expLevelDate;
	}
	public void setExpPositionCode(String expPositionCode) 
	{
		this.expPositionCode = expPositionCode;
	}
	/**
	 * 返回 职业工种资格ID（TAB_CRAFT）
	 * @return
	 */
	public String getExpPositionCode() 
	{
		return this.expPositionCode;
	}
	public void setExpPositionName(String expPositionName) 
	{
		this.expPositionName = expPositionName;
	}
	/**
	 * 返回 职业工种资格名称（TAB_CRAFT）
	 * @return
	 */
	public String getExpPositionName() 
	{
		return this.expPositionName;
	}
	public void setExpTechnical(String expTechnical) 
	{
		this.expTechnical = expTechnical;
	}
	/**
	 * 返回 专业技术职务（TAB_TITLE）
	 * @return
	 */
	public String getExpTechnical() 
	{
		return this.expTechnical;
	}
	public void setExpTechnicalDate(java.util.Date expTechnicalDate) 
	{
		this.expTechnicalDate = expTechnicalDate;
	}
	/**
	 * 返回 取得专业技术职务资格日期
	 * @return
	 */
	public java.util.Date getExpTechnicalDate() 
	{
		return this.expTechnicalDate;
	}
	public void setExpIsFamily(String expIsFamily) 
	{
		this.expIsFamily = expIsFamily;
	}
	/**
	 * 返回 是否零就业家庭（0-否，1-是）
	 * @return
	 */
	public String getExpIsFamily() 
	{
		return this.expIsFamily;
	}
	public void setExpIsDifficult(String expIsDifficult) 
	{
		this.expIsDifficult = expIsDifficult;
	}
	/**
	 * 返回 是否就业困难人员（0-否，1-是）
	 * @return
	 */
	public String getExpIsDifficult() 
	{
		return this.expIsDifficult;
	}
	public void setExpIsCadre(String expIsCadre) 
	{
		this.expIsCadre = expIsCadre;
	}
	/**
	 * 返回 是否转干部（0-否，1-是）
	 * @return
	 */
	public String getExpIsCadre() 
	{
		return this.expIsCadre;
	}
	public void setExpIsDiscount(String expIsDiscount) 
	{
		this.expIsDiscount = expIsDiscount;
	}
	/**
	 * 返回 是否享有再就业优惠证标准（0-否，1-是）
	 * @return
	 */
	public String getExpIsDiscount() 
	{
		return this.expIsDiscount;
	}
	public void setExpIsRegisgration(String expIsRegisgration) 
	{
		this.expIsRegisgration = expIsRegisgration;
	}
	/**
	 * 返回 是否持有就业失业登记证（0-否，1-是）
	 * @return
	 */
	public String getExpIsRegisgration() 
	{
		return this.expIsRegisgration;
	}
	public void setExpRegisgration(String expRegisgration) 
	{
		this.expRegisgration = expRegisgration;
	}
	/**
	 * 返回 再就业优惠证编号
	 * @return
	 */
	public String getExpRegisgration() 
	{
		return this.expRegisgration;
	}
	public void setExpCardNumber(String expCardNumber) 
	{
		this.expCardNumber = expCardNumber;
	}
	/**
	 * 返回 身份证住址
	 * @return
	 */
	public String getExpCardNumber() 
	{
		return this.expCardNumber;
	}
	public void setExpHardPerson(String expHardPerson) 
	{
		this.expHardPerson = expHardPerson;
	}
	/**
	 * 返回 就业困难人员类别（TAB_EDO）
	 * @return
	 */
	public String getExpHardPerson() 
	{
		return this.expHardPerson;
	}
	public void setExpSoctalNumber(String expSoctalNumber) {
		this.expSoctalNumber = expSoctalNumber;
	}
	/**
	 * 返回 社会保障号
	 * @return
	 */
	public String getExpSoctalNumber() {
		return this.expSoctalNumber;
	}
	public void setExpEntrustCompany(String expEntrustCompany) {
		this.expEntrustCompany = expEntrustCompany;
	}
	/**
	 * 返回 委托单位名称
	 * @return
	 */
	public String getExpEntrustCompany() {
		return this.expEntrustCompany;
	}
	public void setFaName(String faName) 
	{
		this.faName = faName;
	}
	/**
	 * 返回 配偶姓名
	 * @return
	 */
	public String getFaName() 
	{
		return this.faName;
	}
	public void setFaMarriage(String faMarriage) 
	{
		this.faMarriage = faMarriage;
	}
	/**
	 * 返回 婚姻状况
	 * @return
	 */
	public String getFaMarriage() 
	{
		return this.faMarriage;
	}
	public void setFaMarriageDate(java.util.Date faMarriageDate) 
	{
		this.faMarriageDate = faMarriageDate;
	}
	/**
	 * 返回 结婚时间
	 * @return
	 */
	public java.util.Date getFaMarriageDate() 
	{
		return this.faMarriageDate;
	}
	public void setFaSpouseCard(String faSpouseCard) 
	{
		this.faSpouseCard = faSpouseCard;
	}
	/**
	 * 返回 配偶身份证号
	 * @return
	 */
	public String getFaSpouseCard() 
	{
		return this.faSpouseCard;
	}
	public void setFaPersonId(Long faPersonId) 
	{
		this.faPersonId = faPersonId;
	}
	/**
	 * 返回 人员ID
	 * @return
	 */
	public Long getFaPersonId() 
	{
		return this.faPersonId;
	}
	public void setFaSpouseBirth(java.util.Date faSpouseBirth) 
	{
		this.faSpouseBirth = faSpouseBirth;
	}
	/**
	 * 返回 配偶出生日期
	 * @return
	 */
	public java.util.Date getFaSpouseBirth() 
	{
		return this.faSpouseBirth;
	}
	public void setFaSpouseNational(String faSpouseNational) 
	{
		this.faSpouseNational = faSpouseNational;
	}
	/**
	 * 返回 配偶民族
	 * @return
	 */
	public String getFaSpouseNational() 
	{
		return this.faSpouseNational;
	}
	public void setFaSpouseCompany(String faSpouseCompany) 
	{
		this.faSpouseCompany = faSpouseCompany;
	}
	/**
	 * 返回 配偶单位
	 * @return
	 */
	public String getFaSpouseCompany() 
	{
		return this.faSpouseCompany;
	}
	public void setFaSpousePhone(String faSpousePhone) 
	{
		this.faSpousePhone = faSpousePhone;
	}
	/**
	 * 返回 配偶电话
	 * @return
	 */
	public String getFaSpousePhone() 
	{
		return this.faSpousePhone;
	}
	public void setFaBirthCondition(String faBirthCondition) 
	{
		this.faBirthCondition = faBirthCondition;
	}
	/**
	 * 返回 计生情况（TAB_CONDITION）
	 * @return
	 */
	public String getFaBirthCondition() 
	{
		return this.faBirthCondition;
	}
	public void setFaBirthControl(String faBirthControl) 
	{
		this.faBirthControl = faBirthControl;
	}
	/**
	 * 返回 节育措施（TAB_BIRTHCONTROL）
	 * @return
	 */
	public String getFaBirthControl() 
	{
		return this.faBirthControl;
	}
	public void setFaFamilyBark(String faFamilyBark) 
	{
		this.faFamilyBark = faFamilyBark;
	}
	/**
	 * 返回 家庭情况备注
	 * @return
	 */
	public String getFaFamilyBark() 
	{
		return this.faFamilyBark;
	}
	
	public Long getExpandId() {
		return this.expandId;
	}
	public void setExpandId(Long expandId) {
		this.expandId = expandId;
	}
	public Long getExpPersonId() {
		return this.expPersonId;
	}
	public void setExpPersonId(Long expPersonId) {
		this.expPersonId = expPersonId;
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpacc0m() {
		return this.expacc0m;
	}
	public void setExpacc0m(String expacc0m) {
		this.expacc0m = expacc0m;
	}
	public String getSign() {
		return this.sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getNodeLogs() {
		return this.nodeLogs;
	}
	public void setNodeLogs(String nodeLogs) {
		this.nodeLogs = nodeLogs;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof PersonBaseInfoForm)) 
		{
			return false;
		}
		PersonBaseInfoForm rhs = (PersonBaseInfoForm) object;
		return new EqualsBuilder()
		.append(this.sign, rhs.sign)
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
		.append(this.ccmu70, rhs.ccmu70)
		.append(this.acc0m1, rhs.acc0m1)
		.append(this.aab004, rhs.aab004)
		.append(this.aab019, rhs.aab019)
		.append(this.aab054, rhs.aab054)
		.append(this.aab020, rhs.aab020)
		.append(this.accm02, rhs.accm02)
		.append(this.accm03, rhs.accm03)
		.append(this.accm04, rhs.accm04)
		.append(this.accm05, rhs.accm05)
		.append(this.accm06, rhs.accm06)
		.append(this.accm07, rhs.accm07)
		.append(this.accm08, rhs.accm08)
		.append(this.accm09, rhs.accm09)
		.append(this.accm10, rhs.accm10)
		.append(this.accm11, rhs.accm11)
		.append(this.accm12, rhs.accm12)
		.append(this.acc20t, rhs.acc20t)
		.append(this.accm13, rhs.accm13)
		.append(this.accm14, rhs.accm14)
		.append(this.accm15, rhs.accm15)
		.append(this.accm16, rhs.accm16)
		.append(this.accm17, rhs.accm17)
		.append(this.accm18, rhs.accm18)
		.append(this.expacc0m, rhs.expacc0m)
		.append(this.acc0m01, rhs.acc0m01)
		.append(this.aab004t, rhs.aab004t)
		.append(this.aab019t, rhs.aab019t)
		.append(this.aab020t, rhs.aab020t)
		.append(this.acpost01, rhs.acpost01)
		.append(this.aab004m, rhs.aab004m)
		.append(this.aab019m, rhs.aab019m)
		.append(this.aab020m, rhs.aab020m)
		.append(this.acemp01, rhs.acemp01)
		.append(this.acc20m, rhs.acc20m)
		.append(this.accm19, rhs.accm19)
		.append(this.accm20, rhs.accm20)
		.append(this.accm21, rhs.accm21)
		.append(this.accm22, rhs.accm22)
		.append(this.accm23, rhs.accm23)
		.append(this.acc0b0, rhs.acc0b0)
		.append(this.acc0b1, rhs.acc0b1)
		.append(this.acc0b2, rhs.acc0b2)
		.append(this.acc0b3, rhs.acc0b3)
		.append(this.aae030, rhs.aae030)
		.append(this.aae031, rhs.aae031)
		.append(this.nodeLogs, rhs.nodeLogs)
		.append(this.expandId, rhs.expandId)
		.append(this.expPersonId, rhs.expPersonId)
		.append(this.id, rhs.id)
		.append(this.faName, rhs.faName)
		.append(this.faMarriage, rhs.faMarriage)
		.append(this.faMarriageDate, rhs.faMarriageDate)
		.append(this.faSpouseCard, rhs.faSpouseCard)
		.append(this.faPersonId, rhs.faPersonId)
		.append(this.faSpouseBirth, rhs.faSpouseBirth)
		.append(this.faSpouseNational, rhs.faSpouseNational)
		.append(this.faSpouseCompany, rhs.faSpouseCompany)
		.append(this.faSpousePhone, rhs.faSpousePhone)
		.append(this.faBirthCondition, rhs.faBirthCondition)
		.append(this.faBirthControl, rhs.faBirthControl)
		.append(this.faFamilyBark, rhs.faFamilyBark)
		.append(this.expStartJobDate, rhs.expStartJobDate)
		.append(this.expUserName, rhs.expUserName)
		.append(this.expPersonNumber, rhs.expPersonNumber)
		.append(this.expArchivesNumber, rhs.expArchivesNumber)
		.append(this.expGengral1, rhs.expGengral1)
		.append(this.expOldCompany, rhs.expOldCompany)
		.append(this.expSecStatus, rhs.expSecStatus)
		.append(this.expRemarks, rhs.expRemarks)
		.append(this.expOpeartorUserId, rhs.expOpeartorUserId)
		.append(this.expOpeartorDate, rhs.expOpeartorDate)
		.append(this.expEquate, rhs.expEquate)
		.append(this.expPersonStatus, rhs.expPersonStatus)
		.append(this.expPersonPhone, rhs.expPersonPhone)
		.append(this.expHourseDate, rhs.expHourseDate)
		.append(this.expAddress, rhs.expAddress)
		.append(this.expPost, rhs.expPost)
		.append(this.expLevel, rhs.expLevel)
		.append(this.expLevelDate, rhs.expLevelDate)
		.append(this.expPositionCode, rhs.expPositionCode)
		.append(this.expPositionName, rhs.expPositionName)
		.append(this.expTechnical, rhs.expTechnical)
		.append(this.expTechnicalDate, rhs.expTechnicalDate)
		.append(this.expIsFamily, rhs.expIsFamily)
		.append(this.expIsDifficult, rhs.expIsDifficult)
		.append(this.expIsCadre, rhs.expIsCadre)
		.append(this.expIsDiscount, rhs.expIsDiscount)
		.append(this.expIsRegisgration, rhs.expIsRegisgration)
		.append(this.expRegisgration, rhs.expRegisgration)
		.append(this.expCardNumber, rhs.expCardNumber)
		.append(this.expHardPerson, rhs.expHardPerson)
		.append(this.expSoctalNumber, rhs.expSoctalNumber)
		.append(this.expEntrustCompany, rhs.expEntrustCompany)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.sign) 
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
		.append(this.ccmu70) 
		.append(this.acc0m1) 
		.append(this.aab004) 
		.append(this.aab019) 
		.append(this.aab054) 
		.append(this.aab020) 
		.append(this.accm02) 
		.append(this.accm03) 
		.append(this.accm04) 
		.append(this.accm05) 
		.append(this.accm06) 
		.append(this.accm07) 
		.append(this.accm08) 
		.append(this.accm09) 
		.append(this.accm10) 
		.append(this.accm11) 
		.append(this.accm12) 
		.append(this.acc20t) 
		.append(this.accm13) 
		.append(this.accm14)
		.append(this.accm15)
		.append(this.accm16)
		.append(this.accm17)
		.append(this.accm18)
		.append(this.expacc0m)
		.append(this.acc0m01)
		.append(this.aab004t)
		.append(this.aab019t)
		.append(this.aab020t)
		.append(this.acpost01)
		.append(this.aab004m)
		.append(this.aab019m)
		.append(this.aab020m)
		.append(this.acemp01)
		.append(this.acc20m)
		.append(this.accm19)
		.append(this.accm20)
		.append(this.accm21)
		.append(this.accm22)
		.append(this.accm23)
		.append(this.acc0b0)
		.append(this.acc0b1)
		.append(this.acc0b2)
		.append(this.acc0b3)
		.append(this.aae030)
		.append(this.aae031)
		.append(this.nodeLogs)
		.append(this.expandId)
		.append(this.expPersonId)
		.append(this.id)
		.append(this.faName) 
		.append(this.faMarriage) 
		.append(this.faMarriageDate) 
		.append(this.faSpouseCard) 
		.append(this.faPersonId) 
		.append(this.faSpouseBirth) 
		.append(this.faSpouseNational) 
		.append(this.faSpouseCompany) 
		.append(this.faSpousePhone) 
		.append(this.faBirthCondition) 
		.append(this.faBirthControl) 
		.append(this.faFamilyBark) 
		.append(this.expStartJobDate) 
		.append(this.expUserName) 
		.append(this.expPersonNumber) 
		.append(this.expArchivesNumber) 
		.append(this.expGengral1) 
		.append(this.expOldCompany) 
		.append(this.expSecStatus) 
		.append(this.expRemarks) 
		.append(this.expOpeartorUserId) 
		.append(this.expOpeartorDate) 
		.append(this.expEquate) 
		.append(this.expPersonStatus) 
		.append(this.expPersonPhone) 
		.append(this.expHourseDate) 
		.append(this.expAddress) 
		.append(this.expPost) 
		.append(this.expLevel) 
		.append(this.expLevelDate) 
		.append(this.expPositionCode) 
		.append(this.expPositionName) 
		.append(this.expTechnical) 
		.append(this.expTechnicalDate) 
		.append(this.expIsFamily) 
		.append(this.expIsDifficult) 
		.append(this.expIsCadre) 
		.append(this.expIsDiscount) 
		.append(this.expIsRegisgration) 
		.append(this.expRegisgration) 
		.append(this.expCardNumber) 
		.append(this.expHardPerson) 
		.append(this.expSoctalNumber) 
		.append(this.expEntrustCompany) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("sign", this.sign) 
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
		.append("ccmu70", this.ccmu70) 
		.append("acc0m1", this.acc0m1) 
		.append("aab004", this.aab004) 
		.append("aab019", this.aab019) 
		.append("aab054", this.aab054) 
		.append("aab020", this.aab020) 
		.append("accm02", this.accm02) 
		.append("accm03", this.accm03) 
		.append("accm04", this.accm04) 
		.append("accm05", this.accm05) 
		.append("accm06", this.accm06) 
		.append("accm07", this.accm07) 
		.append("accm08", this.accm08) 
		.append("accm09", this.accm09) 
		.append("accm10", this.accm10) 
		.append("accm11", this.accm11) 
		.append("accm12", this.accm12) 
		.append("acc20t", this.acc20t) 
		.append("accm13", this.accm13) 
		.append("accm14", this.accm14) 
		.append("accm15", this.accm15) 
		.append("accm16", this.accm16) 
		.append("accm17", this.accm17) 
		.append("accm18", this.accm18)
		.append("aab004m", this.aab004m) 
		.append("aab019m", this.aab019m) 
		.append("aab020m", this.aab020m) 
		.append("acc20m", this.acc20m) 
		.append("accm19", this.accm19) 
		.append("accm20", this.accm20) 
		.append("accm21", this.accm21) 
		.append("accm22", this.accm22) 
		.append("accm23", this.accm23)
		.append("expacc0m", this.expacc0m)
		.append("acemp01", this.acemp01) 
		.append("acc0m01", this.acc0m01) 
		.append("aab004t", this.aab004t) 
		.append("aab019t", this.aab019t) 
		.append("aab020t", this.aab020t)
		.append("acpost01", this.acpost01)
		.append("acc0b0",this.acc0b0)
		.append("acc0b1",this.acc0b1)
		.append("acc0b2",this.acc0b2)
		.append("acc0b3",this.acc0b3)
		.append("aae030",this.aae030)
		.append("aae031",this.aae031)
		.append("nodeLogs",this.nodeLogs)
		.append("expandId",this.expandId)
		.append("expPersonId",this.expPersonId)
		.append("id",this.id)
		.append("faName", this.faName) 
		.append("faMarriage", this.faMarriage) 
		.append("faMarriageDate", this.faMarriageDate) 
		.append("faSpouseCard", this.faSpouseCard) 
		.append("faPersonId", this.faPersonId) 
		.append("faSpouseBirth", this.faSpouseBirth) 
		.append("faSpouseNational", this.faSpouseNational) 
		.append("faSpouseCompany", this.faSpouseCompany) 
		.append("faSpousePhone", this.faSpousePhone) 
		.append("faBirthCondition", this.faBirthCondition) 
		.append("faBirthControl", this.faBirthControl) 
		.append("faFamilyBark", this.faFamilyBark)
		.append("expStartJobDate", this.expStartJobDate) 
		.append("expUserName", this.expUserName) 
		.append("expPersonNumber", this.expPersonNumber) 
		.append("expArchivesNumber", this.expArchivesNumber) 
		.append("expGengral1", this.expGengral1) 
		.append("expOldCompany", this.expOldCompany) 
		.append("expSecStatus", this.expSecStatus) 
		.append("expRemarks", this.expRemarks) 
		.append("expOpeartorUserId", this.expOpeartorUserId) 
		.append("expOpeartorDate", this.expOpeartorDate) 
		.append("expEquate", this.expEquate) 
		.append("expPersonStatus", this.expPersonStatus) 
		.append("expPersonPhone", this.expPersonPhone) 
		.append("expHourseDate", this.expHourseDate) 
		.append("expAddress", this.expAddress) 
		.append("expPost", this.expPost) 
		.append("expLevel", this.expLevel) 
		.append("expLevelDate", this.expLevelDate) 
		.append("expPositionCode", this.expPositionCode) 
		.append("expPositionName", this.expPositionName) 
		.append("expTechnical", this.expTechnical) 
		.append("expTechnicalDate", this.expTechnicalDate) 
		.append("expIsFamily", this.expIsFamily) 
		.append("expIsDifficult", this.expIsDifficult) 
		.append("expIsCadre", this.expIsCadre) 
		.append("expIsDiscount", this.expIsDiscount) 
		.append("expIsRegisgration", this.expIsRegisgration) 
		.append("expRegisgration", this.expRegisgration) 
		.append("expCardNumber", this.expCardNumber) 
		.append("expHardPerson", this.expHardPerson) 
		.append("expSoctalNumber", this.expSoctalNumber) 
		.append("expEntrustCompany", this.expEntrustCompany)
		.toString();
	}
	

}