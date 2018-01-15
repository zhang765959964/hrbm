package com.xunfeng.business.dissupport.divice.web.form;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.xunfeng.core.model.BaseForm;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.business.dissupport.divice.model.DiviConfig;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 设备配置表 Form对象
* @author:wanghan
* @createDate 2016-07-28 15:30:48 
* @version V1.0   
*/
public class DiviConfigForm extends BaseForm<DiviConfig>
{
	// 设备配置表编号seq_sb_pz
	protected Long  con001;
	// 所属机构
	protected Long  acd200;
	// 设备编号
	protected Long  div001;
	// 岗位名称(CS)
	protected String  con002;
	// 单位名称(CS)
	protected String  con003;
	// 单位类型(CS)
	protected String  con004;
	// 经济类型(CS)
	protected String  con005;
	// 行业类型(CS)
	protected String  con006;
	// 工作性质(CS)
	protected String  con007;
	// 食宿要求(CS)
	protected String  con008;
	// 学历要求(CS)
	protected String  con009;
	// 单位地址(CS)
	protected String  con010;
	// 月薪范围(CS)
	protected String  con011;
	// 工作地点(CS)
	protected String  con012;
	// 联系人(CS)
	protected String  con013;
	// 信息公开范围(CS)
	protected String  con014;
	// 最后修改人(CS)
	protected String  con015;
	// 信息来源(CS)
	protected String  con016;
	// 总过滤条件
	protected String  con999;
	// 备注(CS)
	protected String  aae013;
	// 经办人代码(CS)
	protected String  aae011;
	// 经办机构代码(CS)
	protected String  aae017;
	// 经办时间(CS)
	protected java.util.Date  aae036;
	// 经办人(CS)
	protected String  aae019;
	// 经办机构(CS)
	protected String  aae020;
	// 岗位名称(BS)
	protected String  con202;
	// 单位名称(BS)
	protected String  con203;
	// 单位类型(BS)
	protected String  con204;
	// 经济类型(BS)
	protected String  con205;
	// 行业类型(BS)
	protected String  con206;
	// 工作性质(BS)
	protected String  con207;
	// 食宿要求(BS)
	protected String  con208;
	// 学历要求(BS)
	protected String  con209;
	// 单位地址(BS)
	protected String  con210;
	// 月薪范围(BS)
	protected String  con211;
	// 工作地点(BS)
	protected String  con212;
	// 联系人(BS)
	protected String  con213;
	// 公开范围(BS)
	protected String  con214;
	// 最后修改人(BS)
	protected String  con215;
	// 信息来源（BS）
	protected String  con216;
	// 过滤条件(CS)
	protected String  con099;
	// 过滤条件(BS)
	protected String  con299;
	// 是否应用过滤条件(CS)T-应用F-不应用
	protected String  con017;
	// 备注(BS)
	protected String  bae013;
	// 经办人代码(BS)
	protected String  bae011;
	// 经办机构代码(BS)
	protected String  bae017;
	// 经办时间(BS)
	protected java.util.Date  bae036;
	// 经办人(BS)
	protected String  bae019;
	// 经办机构(BS)
	protected String  bae020;
	// 岗位编号(CS)
	protected String  con018;
	// 职位名称（CS）
	protected String  con019;
	// 职位说明（CS）
	protected String  con020;
	// 人数（CS）
	protected String  con021;
	// 性别(CS)
	protected String  con022;
	// 年龄要求（CS）
	protected String  con024;
	// 工作经验（CS）
	protected String  con025;
	// 是否适合应届（CS）
	protected String  con026;
	// 招聘开始日期（CS）
	protected String  con027;
	// 招聘结束日期（CS）
	protected String  con028;
	// 备用（CS）
	protected String  con031;
	// 备用（CS）
	protected String  con032;
	// 备用（CS）
	protected String  con033;
	// 岗位编号（BS）
	protected String  con217;
	// 职位名称（BS）
	protected String  con218;
	// 职位说明（BS）
	protected String  con219;
	// 性别（BS）
	protected String  con220;
	// 人数（BS）
	protected String  con221;
	// 年龄要求（BS）
	protected String  con222;
	// 工作经验（BS）
	protected String  con223;
	// 是否适合应届（BS）
	protected String  con224;
	// 招聘开始日期(BS)
	protected String  con225;
	// 招聘结束日期(BS)
	protected String  con226;
	// 添加人(BS)
	protected String  con227;
	// 添加时间(BS)
	protected java.util.Date  con228;
	// 修改人(BS)
	protected String  con229;
	// 修改时间(BS)
	protected java.util.Date  con230;
	// 修改时间(CS)
	protected String  con034;
	// CON232
	protected String  con232;
 
	public void setCon001(Long con001) 
	{
		this.con001 = con001;
	}
	/**
	 * 返回 设备配置表编号seq_sb_pz
	 * @return
	 */
	public Long getCon001() 
	{
		return this.con001;
	}
	public void setAcd200(Long acd200) 
	{
		this.acd200 = acd200;
	}
	/**
	 * 返回 所属机构
	 * @return
	 */
	public Long getAcd200() 
	{
		return this.acd200;
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
	public void setCon002(String con002) 
	{
		this.con002 = con002;
	}
	/**
	 * 返回 岗位名称(CS)
	 * @return
	 */
	public String getCon002() 
	{
		return this.con002;
	}
	public void setCon003(String con003) 
	{
		this.con003 = con003;
	}
	/**
	 * 返回 单位名称(CS)
	 * @return
	 */
	@QueryField(column="AAB004",type=SystemConst.CS_TYPE)
	public String getCon003() 
	{
		return this.con003;
	}
	public void setCon004(String con004) 
	{
		this.con004 = con004;
	}
	/**
	 * 返回 单位类型(CS)
	 * @return
	 */
	@QueryField(column="AAB019",type=SystemConst.CS_TYPE)
	public String getCon004() 
	{
		return this.con004;
	}
	public void setCon005(String con005) 
	{
		this.con005 = con005;
	}
	/**
	 * 返回 经济类型(CS)
	 * @return
	 */
	@QueryField(column="AAB020",type=SystemConst.CS_TYPE)
	public String getCon005() 
	{
		return this.con005;
	}
	public void setCon006(String con006) 
	{
		this.con006 = con006;
	}
	/**
	 * 返回 行业类型(CS)
	 * @return
	 */
	@QueryField(column="AAB022",type=SystemConst.CS_TYPE)
	public String getCon006() 
	{
		return this.con006;
	}
	public void setCon007(String con007) 
	{
		this.con007 = con007;
	}
	/**
	 * 返回 工作性质(CS)
	 * @return
	 */
	@QueryField(column="ACB21I",type=SystemConst.CS_TYPE)
	public String getCon007() 
	{
		return this.con007;
	}
	public void setCon008(String con008) 
	{
		this.con008 = con008;
	}
	/**
	 * 返回 食宿要求(CS)
	 * @return
	 */
	@QueryField(column="ACB228N",type=SystemConst.CS_TYPE)
	public String getCon008() 
	{
		return this.con008;
	}
	public void setCon009(String con009) 
	{
		this.con009 = con009;
	}
	/**
	 * 返回 学历要求(CS)
	 * @return
	 */
	@QueryField(column="AAC011N",type=SystemConst.CS_TYPE)
	public String getCon009() 
	{
		return this.con009;
	}
	public void setCon010(String con010) 
	{
		this.con010 = con010;
	}
	/**
	 * 返回 单位地址(CS)
	 * @return
	 */
	@QueryField(column="AAB040",type=SystemConst.CS_TYPE)
	public String getCon010() 
	{
		return this.con010;
	}
	public void setCon011(String con011) 
	{
		this.con011 = con011;
	}
	/**
	 * 返回 月薪范围(CS)
	 * @return
	 */
	@QueryField(column="ACC034N",type=SystemConst.CS_TYPE,operation=">=")
	public String getCon011() 
	{
		return this.con011;
	}
	public void setCon012(String con012) 
	{
		this.con012 = con012;
	}
	/**
	 * 返回 工作地点(CS)
	 * @return
	 */
	public String getCon012() 
	{
		return this.con012;
	}
	public void setCon013(String con013) 
	{
		this.con013 = con013;
	}
	/**
	 * 返回 联系人(CS)
	 * @return
	 */
	@QueryField(column="AAE004",type=SystemConst.CS_TYPE)
	public String getCon013() 
	{
		return this.con013;
	}
	public void setCon014(String con014) 
	{
		this.con014 = con014;
	}
	/**
	 * 返回 信息公开范围(CS)
	 * @return
	 */
	public String getCon014() 
	{
		return this.con014;
	}
	public void setCon015(String con015) 
	{
		this.con015 = con015;
	}
	/**
	 * 返回 最后修改人(CS)
	 * @return
	 */
	@QueryField(column="CCPR06",type=SystemConst.CS_TYPE)
	public String getCon015() 
	{
		return this.con015;
	}
	public void setCon016(String con016) 
	{
		this.con016 = con016;
	}
	/**
	 * 返回 信息来源(CS)
	 * @return
	 */
	@QueryField(column="CCZY06",type=SystemConst.CS_TYPE)
	public String getCon016() 
	{
		return this.con016;
	}
	public void setCon999(String con999) 
	{
		this.con999 = con999;
	}
	/**
	 * 返回 总过滤条件
	 * @return
	 */
	public String getCon999() 
	{
		return this.con999;
	}
	public void setAae013(String aae013) 
	{
		this.aae013 = aae013;
	}
	/**
	 * 返回 备注(CS)
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
	 * 返回 经办人代码(CS)
	 * @return
	 */
	@QueryField(column="AAE011",type=SystemConst.CS_TYPE)
	public String getAae011() 
	{
		return this.aae011;
	}
	public void setAae017(String aae017) 
	{
		this.aae017 = aae017;
	}
	/**
	 * 返回 经办机构代码(CS)
	 * @return
	 */
	@QueryField(column="BAE017",type=SystemConst.CS_TYPE)
	public String getAae017() 
	{
		return this.aae017;
	}
	public void setAae036(java.util.Date aae036) 
	{
		this.aae036 = aae036;
	}
	/**
	 * 返回 经办时间(CS)
	 * @return
	 */
	@QueryField(column="AAE036",type=SystemConst.CS_TYPE)
	public java.util.Date getAae036() 
	{
		return this.aae036;
	}
	public void setAae019(String aae019) 
	{
		this.aae019 = aae019;
	}
	/**
	 * 返回 经办人(CS)
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
	 * 返回 经办机构(CS)
	 * @return
	 */
	public String getAae020() 
	{
		return this.aae020;
	}
	public void setCon202(String con202) 
	{
		this.con202 = con202;
	}
	/**
	 * 返回 岗位名称(BS)
	 * @return
	 */
	public String getCon202() 
	{
		return this.con202;
	}
	public void setCon203(String con203) 
	{
		this.con203 = con203;
	}
	/**
	 * 返回 单位名称(BS)
	 * @return
	 */
	@QueryField(column="AAB004",type=SystemConst.BS_TYPE)
	public String getCon203() 
	{
		return this.con203;
	}
	public void setCon204(String con204) 
	{
		this.con204 = con204;
	}
	/**
	 * 返回 单位类型(BS)
	 * @return
	 */
	@QueryField(column="AAB019",type=SystemConst.BS_TYPE)
	public String getCon204() 
	{
		return this.con204;
	}
	public void setCon205(String con205) 
	{
		this.con205 = con205;
	}
	/**
	 * 返回 经济类型(BS)
	 * @return
	 */
	@QueryField(column="AAB020",type=SystemConst.BS_TYPE)
	public String getCon205() 
	{
		return this.con205;
	}
	public void setCon206(String con206) 
	{
		this.con206 = con206;
	}
	/**
	 * 返回 行业类型(BS)
	 * @return
	 */
	@QueryField(column="AAB022",type=SystemConst.BS_TYPE)
	public String getCon206() 
	{
		return this.con206;
	}
	public void setCon207(String con207) 
	{
		this.con207 = con207;
	}
	/**
	 * 返回 工作性质(BS)
	 * @return
	 */
	@QueryField(column="ACB21I",type=SystemConst.BS_TYPE)
	public String getCon207() 
	{
		return this.con207;
	}
	public void setCon208(String con208) 
	{
		this.con208 = con208;
	}
	/**
	 * 返回 食宿要求(BS)
	 * @return
	 */
	@QueryField(column="ACB228N",type=SystemConst.BS_TYPE)
	public String getCon208() 
	{
		return this.con208;
	}
	public void setCon209(String con209) 
	{
		this.con209 = con209;
	}
	/**
	 * 返回 学历要求(BS)
	 * @return
	 */
	@QueryField(column="AAC011N",type=SystemConst.BS_TYPE)
	public String getCon209() 
	{
		return this.con209;
	}
	public void setCon210(String con210) 
	{
		this.con210 = con210;
	}
	/**
	 * 返回 单位地址(BS)
	 * @return
	 */
	@QueryField(column="AAB040",type=SystemConst.BS_TYPE)
	public String getCon210() 
	{
		return this.con210;
	}
	public void setCon211(String con211) 
	{
		this.con211 = con211;
	}
	/**
	 * 返回 月薪范围(BS)
	 * @return
	 */
	@QueryField(column="ACC034N",type=SystemConst.BS_TYPE,operation=">=")
	public String getCon211() 
	{
		return this.con211;
	}
	public void setCon212(String con212) 
	{
		this.con212 = con212;
	}
	/**
	 * 返回 工作地点(BS)
	 * @return
	 */
	public String getCon212() 
	{
		return this.con212;
	}
	public void setCon213(String con213) 
	{
		this.con213 = con213;
	}
	/**
	 * 返回 联系人(BS)
	 * @return
	 */
	@QueryField(column="AAE004",type=SystemConst.BS_TYPE)
	public String getCon213() 
	{
		return this.con213;
	}
	public void setCon214(String con214) 
	{
		this.con214 = con214;
	}
	/**
	 * 返回 公开范围(BS)
	 * @return
	 */
	public String getCon214() 
	{
		return this.con214;
	}
	public void setCon215(String con215) 
	{
		this.con215 = con215;
	}
	/**
	 * 返回 最后修改人(BS)
	 * @return
	 */
	@QueryField(column="CCPR06",type=SystemConst.BS_TYPE)
	public String getCon215() 
	{
		return this.con215;
	}
	public void setCon216(String con216) 
	{
		this.con216 = con216;
	}
	/**
	 * 返回 信息来源（BS）
	 * @return
	 */
	@QueryField(column="CCZY06",type=SystemConst.BS_TYPE)
	public String getCon216() 
	{
		return this.con216;
	}
	public void setCon099(String con099) 
	{
		this.con099 = con099;
	}
	/**
	 * 返回 过滤条件(CS)
	 * @return
	 */
	public String getCon099() 
	{
		return this.con099;
	}
	public void setCon299(String con299) 
	{
		this.con299 = con299;
	}
	/**
	 * 返回 过滤条件(BS)
	 * @return
	 */
	public String getCon299() 
	{
		return this.con299;
	}
	public void setCon017(String con017) 
	{
		this.con017 = con017;
	}
	/**
	 * 返回 是否应用过滤条件(CS)T-应用F-不应用
	 * @return
	 */
	public String getCon017() 
	{
		return this.con017;
	}
	public void setBae013(String bae013) 
	{
		this.bae013 = bae013;
	}
	/**
	 * 返回 备注(BS)
	 * @return
	 */
	public String getBae013() 
	{
		return this.bae013;
	}
	public void setBae011(String bae011) 
	{
		this.bae011 = bae011;
	}
	/**
	 * 返回 经办人代码(BS)
	 * @return
	 */
	@QueryField(column="AAE011",type=SystemConst.BS_TYPE)
	public String getBae011() 
	{
		return this.bae011;
	}
	public void setBae017(String bae017) 
	{
		this.bae017 = bae017;
	}
	/**
	 * 返回 经办机构代码(BS)
	 * @return
	 */
	@QueryField(column="BAE017",type=SystemConst.BS_TYPE)
	public String getBae017() 
	{
		return this.bae017;
	}
	public void setBae036(java.util.Date bae036) 
	{
		this.bae036 = bae036;
	}
	/**
	 * 返回 经办时间(BS)
	 * @return
	 */
	@QueryField(column="AAE036",type=SystemConst.BS_TYPE)
	public java.util.Date getBae036() 
	{
		return this.bae036;
	}
	public void setBae019(String bae019) 
	{
		this.bae019 = bae019;
	}
	/**
	 * 返回 经办人(BS)
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
	 * 返回 经办机构(BS)
	 * @return
	 */
	public String getBae020() 
	{
		return this.bae020;
	}
	public void setCon018(String con018) 
	{
		this.con018 = con018;
	}
	/**
	 * 返回 岗位编号(CS)
	 * @return
	 */
	@QueryField(column="ACA111",type=SystemConst.CS_TYPE)
	public String getCon018() 
	{
		return this.con018;
	}
	public void setCon019(String con019) 
	{
		this.con019 = con019;
	}
	/**
	 * 返回 职位名称（CS）
	 * @return
	 */
	@QueryField(column="ACA112",type=SystemConst.CS_TYPE)
	public String getCon019() 
	{
		return this.con019;
	}
	public void setCon020(String con020) 
	{
		this.con020 = con020;
	}
	/**
	 * 返回 职位说明（CS）
	 * @return
	 */
	@QueryField(column="CCA113",type=SystemConst.CS_TYPE)
	public String getCon020() 
	{
		return this.con020;
	}
	public void setCon021(String con021) 
	{
		this.con021 = con021;
	}
	/**
	 * 返回 人数（CS）
	 * @return
	 */
	@QueryField(column="ACB21R",type=SystemConst.CS_TYPE)
	public String getCon021() 
	{
		return this.con021;
	}
	public void setCon022(String con022) 
	{
		this.con022 = con022;
	}
	/**
	 * 返回 性别(CS)
	 * @return
	 */
	@QueryField(column="AAD004N",type=SystemConst.CS_TYPE)
	public String getCon022() 
	{
		return this.con022;
	}
	public void setCon024(String con024) 
	{
		this.con024 = con024;
	}
	/**
	 * 返回 年龄要求（CS）
	 * @return
	 */
	@QueryField(column="ACB223",type=SystemConst.CS_TYPE)
	public String getCon024() 
	{
		return this.con024;
	}
	public void setCon025(String con025) 
	{
		this.con025 = con025;
	}
	/**
	 * 返回 工作经验（CS）
	 * @return
	 */
	@QueryField(column="ACC217N",type=SystemConst.CS_TYPE)
	public String getCon025() 
	{
		return this.con025;
	}
	public void setCon026(String con026) 
	{
		this.con026 = con026;
	}
	/**
	 * 返回 是否适合应届（CS）
	 * @return
	 */
	@QueryField(column="ACC20TN",type=SystemConst.CS_TYPE)
	public String getCon026() 
	{
		return this.con026;
	}
	public void setCon027(String con027) 
	{
		this.con027 = con027;
	}
	/**
	 * 返回 招聘开始日期（CS）
	 * @return
	 */
	@QueryField(column="AAE030",type=SystemConst.CS_TYPE,operation=">=")
	public String getCon027() 
	{
		return this.con027;
	}
	public void setCon028(String con028) 
	{
		this.con028 = con028;
	}
	/**
	 * 返回 招聘结束日期（CS）
	 * @return
	 */
	@QueryField(column="AAE031",type=SystemConst.CS_TYPE,operation="<=")
	public String getCon028() 
	{
		return this.con028;
	}
	public void setCon031(String con031) 
	{
		this.con031 = con031;
	}
	/**
	 * 返回 备用（CS）
	 * @return
	 */
	public String getCon031() 
	{
		return this.con031;
	}
	public void setCon032(String con032) 
	{
		this.con032 = con032;
	}
	/**
	 * 返回 备用（CS）
	 * @return
	 */
	public String getCon032() 
	{
		return this.con032;
	}
	public void setCon033(String con033) 
	{
		this.con033 = con033;
	}
	/**
	 * 返回 备用（CS）
	 * @return
	 */
	public String getCon033() 
	{
		return this.con033;
	}
	public void setCon217(String con217) 
	{
		this.con217 = con217;
	}
	/**
	 * 返回 岗位编号（BS）
	 * @return
	 */
	@QueryField(column="ACA111",type=SystemConst.BS_TYPE)
	public String getCon217() 
	{
		return this.con217;
	}
	public void setCon218(String con218) 
	{
		this.con218 = con218;
	}
	/**
	 * 返回 职位名称（BS）
	 * @return
	 */
	@QueryField(column="ACA112",type=SystemConst.BS_TYPE)
	public String getCon218() 
	{
		return this.con218;
	}
	public void setCon219(String con219) 
	{
		this.con219 = con219;
	}
	/**
	 * 返回 职位说明（BS）
	 * @return
	 */
	@QueryField(column="CCA113",type=SystemConst.BS_TYPE)
	public String getCon219() 
	{
		return this.con219;
	}
	public void setCon220(String con220) 
	{
		this.con220 = con220;
	}
	/**
	 * 返回 性别（BS）
	 * @return
	 */
	@QueryField(column="AAD004N",type=SystemConst.BS_TYPE)
	public String getCon220() 
	{
		return this.con220;
	}
	public void setCon221(String con221) 
	{
		this.con221 = con221;
	}
	/**
	 * 返回 人数（BS）
	 * @return
	 */
	@QueryField(column="ACB21R",type=SystemConst.BS_TYPE)
	public String getCon221() 
	{
		return this.con221;
	}
	public void setCon222(String con222) 
	{
		this.con222 = con222;
	}
	/**
	 * 返回 年龄要求（BS）
	 * @return
	 */
	@QueryField(column="ACB223",type=SystemConst.BS_TYPE)
	public String getCon222() 
	{
		return this.con222;
	}
	public void setCon223(String con223) 
	{
		this.con223 = con223;
	}
	/**
	 * 返回 工作经验（BS）
	 * @return
	 */
	@QueryField(column="ACC217N",type=SystemConst.BS_TYPE)
	public String getCon223() 
	{
		return this.con223;
	}
	public void setCon224(String con224) 
	{
		this.con224 = con224;
	}
	/**
	 * 返回 是否适合应届（BS）
	 * @return
	 */
	@QueryField(column="ACC20TN",type=SystemConst.BS_TYPE)
	public String getCon224() 
	{
		return this.con224;
	}
	public void setCon225(String con225) 
	{
		this.con225 = con225;
	}
	/**
	 * 返回 招聘开始日期(BS)
	 * @return
	 */
	@QueryField(column="AAE030",type=SystemConst.BS_TYPE,operation=">=")
	public String getCon225() 
	{
		return this.con225;
	}
	public void setCon226(String con226) 
	{
		this.con226 = con226;
	}
	/**
	 * 返回 招聘结束日期(BS)
	 * @return
	 */
	@QueryField(column="AAE031",type=SystemConst.BS_TYPE,operation="<=")
	public String getCon226() 
	{
		return this.con226;
	}
	public void setCon227(String con227) 
	{
		this.con227 = con227;
	}
	/**
	 * 返回 添加人(BS)
	 * @return
	 */
	public String getCon227() 
	{
		return this.con227;
	}
	public void setCon228(java.util.Date con228) 
	{
		this.con228 = con228;
	}
	/**
	 * 返回 添加时间(BS)
	 * @return
	 */
	public java.util.Date getCon228() 
	{
		return this.con228;
	}
	public void setCon229(String con229) 
	{
		this.con229 = con229;
	}
	/**
	 * 返回 修改人(BS)
	 * @return
	 */
	@QueryField(column="CCPR06",type=SystemConst.BS_TYPE)
	public String getCon229() 
	{
		return this.con229;
	}
	public void setCon230(java.util.Date con230) 
	{
		this.con230 = con230;
	}
	/**
	 * 返回 修改时间(BS)
	 * @return
	 */
	public java.util.Date getCon230() 
	{
		return this.con230;
	}
	public void setCon034(String con034) 
	{
		this.con034 = con034;
	}
	/**
	 * 返回 修改时间(CS)
	 * @return
	 */
	public String getCon034() 
	{
		return this.con034;
	}
	public void setCon232(String con232) 
	{
		this.con232 = con232;
	}
	/**
	 * 返回 CON232
	 * @return
	 */
	public String getCon232() 
	{
		return this.con232;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof DiviConfigForm)) 
		{
			return false;
		}
		DiviConfigForm rhs = (DiviConfigForm) object;
		return new EqualsBuilder()
		.append(this.con001, rhs.con001)
		.append(this.acd200, rhs.acd200)
		.append(this.div001, rhs.div001)
		.append(this.con002, rhs.con002)
		.append(this.con003, rhs.con003)
		.append(this.con004, rhs.con004)
		.append(this.con005, rhs.con005)
		.append(this.con006, rhs.con006)
		.append(this.con007, rhs.con007)
		.append(this.con008, rhs.con008)
		.append(this.con009, rhs.con009)
		.append(this.con010, rhs.con010)
		.append(this.con011, rhs.con011)
		.append(this.con012, rhs.con012)
		.append(this.con013, rhs.con013)
		.append(this.con014, rhs.con014)
		.append(this.con015, rhs.con015)
		.append(this.con016, rhs.con016)
		.append(this.con999, rhs.con999)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.con202, rhs.con202)
		.append(this.con203, rhs.con203)
		.append(this.con204, rhs.con204)
		.append(this.con205, rhs.con205)
		.append(this.con206, rhs.con206)
		.append(this.con207, rhs.con207)
		.append(this.con208, rhs.con208)
		.append(this.con209, rhs.con209)
		.append(this.con210, rhs.con210)
		.append(this.con211, rhs.con211)
		.append(this.con212, rhs.con212)
		.append(this.con213, rhs.con213)
		.append(this.con214, rhs.con214)
		.append(this.con215, rhs.con215)
		.append(this.con216, rhs.con216)
		.append(this.con099, rhs.con099)
		.append(this.con299, rhs.con299)
		.append(this.con017, rhs.con017)
		.append(this.bae013, rhs.bae013)
		.append(this.bae011, rhs.bae011)
		.append(this.bae017, rhs.bae017)
		.append(this.bae036, rhs.bae036)
		.append(this.bae019, rhs.bae019)
		.append(this.bae020, rhs.bae020)
		.append(this.con018, rhs.con018)
		.append(this.con019, rhs.con019)
		.append(this.con020, rhs.con020)
		.append(this.con021, rhs.con021)
		.append(this.con022, rhs.con022)
		.append(this.con024, rhs.con024)
		.append(this.con025, rhs.con025)
		.append(this.con026, rhs.con026)
		.append(this.con027, rhs.con027)
		.append(this.con028, rhs.con028)
		.append(this.con031, rhs.con031)
		.append(this.con032, rhs.con032)
		.append(this.con033, rhs.con033)
		.append(this.con217, rhs.con217)
		.append(this.con218, rhs.con218)
		.append(this.con219, rhs.con219)
		.append(this.con220, rhs.con220)
		.append(this.con221, rhs.con221)
		.append(this.con222, rhs.con222)
		.append(this.con223, rhs.con223)
		.append(this.con224, rhs.con224)
		.append(this.con225, rhs.con225)
		.append(this.con226, rhs.con226)
		.append(this.con227, rhs.con227)
		.append(this.con228, rhs.con228)
		.append(this.con229, rhs.con229)
		.append(this.con230, rhs.con230)
		.append(this.con034, rhs.con034)
		.append(this.con232, rhs.con232)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.con001) 
		.append(this.acd200) 
		.append(this.div001) 
		.append(this.con002) 
		.append(this.con003) 
		.append(this.con004) 
		.append(this.con005) 
		.append(this.con006) 
		.append(this.con007) 
		.append(this.con008) 
		.append(this.con009) 
		.append(this.con010) 
		.append(this.con011) 
		.append(this.con012) 
		.append(this.con013) 
		.append(this.con014) 
		.append(this.con015) 
		.append(this.con016) 
		.append(this.con999) 
		.append(this.aae013) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.con202) 
		.append(this.con203) 
		.append(this.con204) 
		.append(this.con205) 
		.append(this.con206) 
		.append(this.con207) 
		.append(this.con208) 
		.append(this.con209) 
		.append(this.con210) 
		.append(this.con211) 
		.append(this.con212) 
		.append(this.con213) 
		.append(this.con214) 
		.append(this.con215) 
		.append(this.con216) 
		.append(this.con099) 
		.append(this.con299) 
		.append(this.con017) 
		.append(this.bae013) 
		.append(this.bae011) 
		.append(this.bae017) 
		.append(this.bae036) 
		.append(this.bae019) 
		.append(this.bae020) 
		.append(this.con018) 
		.append(this.con019) 
		.append(this.con020) 
		.append(this.con021) 
		.append(this.con022) 
		.append(this.con024) 
		.append(this.con025) 
		.append(this.con026) 
		.append(this.con027) 
		.append(this.con028) 
		.append(this.con031) 
		.append(this.con032) 
		.append(this.con033) 
		.append(this.con217) 
		.append(this.con218) 
		.append(this.con219) 
		.append(this.con220) 
		.append(this.con221) 
		.append(this.con222) 
		.append(this.con223) 
		.append(this.con224) 
		.append(this.con225) 
		.append(this.con226) 
		.append(this.con227) 
		.append(this.con228) 
		.append(this.con229) 
		.append(this.con230) 
		.append(this.con034) 
		.append(this.con232) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("con001", this.con001) 
		.append("acd200", this.acd200) 
		.append("div001", this.div001) 
		.append("con002", this.con002) 
		.append("con003", this.con003) 
		.append("con004", this.con004) 
		.append("con005", this.con005) 
		.append("con006", this.con006) 
		.append("con007", this.con007) 
		.append("con008", this.con008) 
		.append("con009", this.con009) 
		.append("con010", this.con010) 
		.append("con011", this.con011) 
		.append("con012", this.con012) 
		.append("con013", this.con013) 
		.append("con014", this.con014) 
		.append("con015", this.con015) 
		.append("con016", this.con016) 
		.append("con999", this.con999) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("con202", this.con202) 
		.append("con203", this.con203) 
		.append("con204", this.con204) 
		.append("con205", this.con205) 
		.append("con206", this.con206) 
		.append("con207", this.con207) 
		.append("con208", this.con208) 
		.append("con209", this.con209) 
		.append("con210", this.con210) 
		.append("con211", this.con211) 
		.append("con212", this.con212) 
		.append("con213", this.con213) 
		.append("con214", this.con214) 
		.append("con215", this.con215) 
		.append("con216", this.con216) 
		.append("con099", this.con099) 
		.append("con299", this.con299) 
		.append("con017", this.con017) 
		.append("bae013", this.bae013) 
		.append("bae011", this.bae011) 
		.append("bae017", this.bae017) 
		.append("bae036", this.bae036) 
		.append("bae019", this.bae019) 
		.append("bae020", this.bae020) 
		.append("con018", this.con018) 
		.append("con019", this.con019) 
		.append("con020", this.con020) 
		.append("con021", this.con021) 
		.append("con022", this.con022) 
		.append("con024", this.con024) 
		.append("con025", this.con025) 
		.append("con026", this.con026) 
		.append("con027", this.con027) 
		.append("con028", this.con028) 
		.append("con031", this.con031) 
		.append("con032", this.con032) 
		.append("con033", this.con033) 
		.append("con217", this.con217) 
		.append("con218", this.con218) 
		.append("con219", this.con219) 
		.append("con220", this.con220) 
		.append("con221", this.con221) 
		.append("con222", this.con222) 
		.append("con223", this.con223) 
		.append("con224", this.con224) 
		.append("con225", this.con225) 
		.append("con226", this.con226) 
		.append("con227", this.con227) 
		.append("con228", this.con228) 
		.append("con229", this.con229) 
		.append("con230", this.con230) 
		.append("con034", this.con034) 
		.append("con232", this.con232) 
		.toString();
	}
   
  

}