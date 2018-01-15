package com.xunfeng.business.corp.model;

import java.util.Date;

import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 对象功能:单位招聘信息表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-22 17:34:19
 */
public class CorpPositionPublish extends BaseModel
{
	// 招聘登记号
	protected Long  acb200;
	// 单位编号
	protected Long  aab001;
	// 组织机构代码
	protected String  aab003;
	// 单位名称
	protected String  aab004;
	// 隶属关系
	protected String  aab021;
	// 所属行业
	protected String  aab022;
	// 产业类别
	protected String  aab054;
	// 单位性质
	protected String  aab019;
	// 经济类型
	protected String  aab020;
	// 主管部门
	protected String  aab023;
	// 所属地区行政区划代码
	protected String  aab301;
	// 行政区划名称
	protected String  aaa021;
	// 人员规模
	protected String  aab056;
	// 单位简介
	protected String  acb206;
	// 地址
	protected String  aae006;
	// 联系人
	protected String  aae004;
	// 联系电话
	protected String  aae005;
	// 联系人手机号码
	protected String  aae139;
	// 电子信箱
	protected String  aae015;
	// 传真
	protected String  aae014;
	// 网址
	protected String  aae016;
	// 招聘套餐
	protected String  acb201;
	// 登记日期
	protected java.util.Date  aae043=new Date();
	// 冻结标记
	protected String  acb208="0";
	// 备注
	protected String  aae013;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036=new Date();
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	// 机构行政区划代码
	protected String  aae022;
	// 信息员编号
	protected Long  acc2b0;
	// 是否会员单位
	protected String  acb20g="0";
	// 猎头单位检验
	protected String  acb20p;
	// 历史未反馈校验
	protected String  acb20u;
	// 违规记录校验
	protected String  acb20y;
	// 信息发布方式
	protected String  acb20q;
	// 定向单位编号
	protected String  acb400;
	// 是否定向单位
	protected String  bcb20a;
	// 会员编号
	protected Long  acb260;
	// 会员号
	protected String  acb261;
	// 证件的有效期
	protected java.util.Date  aab011;
	// 证件的年检期
	protected java.util.Date  cab011;
	// 单位证件类型
	protected String  bae018;
	// 乘车路线
	protected String  acb205;
	// 会员级别
	protected String  acb262;
	// 原费用
	protected Float  bcb20b=0f;
	// 应收费用
	protected Float  bcb20d=0f;
	// 费用状态
	protected String  bcb20e;
	// 发布名称
	protected String  bab004;
	// 数据开放程度
	protected String  acb209;
	// 数据来源
	protected String  bcb209;
	// 数据开放对象
	protected String  acb207;
	// 数据分类
	protected String  bcb207;
	// 享受折扣
	protected Float  acb263;
	// 招聘套餐
	protected String  bcb201;
	// 审核标记
	protected String  abb561;
	// 审核时间
	protected java.util.Date  abb771;
	// 审核人
	protected String  abb769;
	// 审核机构
	protected String  abb770;
	// 审核意见
	protected String  abb772;
	// 审核标记
	protected String  abb773;
	// 套餐编号
	protected Long  ace230;
	// 招聘地点
	protected String  acb202;
	// 招聘地区
	protected String  acb203;
	// 用工形式
	protected String  aac013;
	// 工作地点
	protected String  acb204;
	// 公民身份证号码
	protected String  aac002;
	// 面试地点
	protected String  acb20c;
	// 面试详细说明
	protected String  acb20f;
	// 冻结人员
	protected String  acb20d;
	// 冻结日期
	protected java.util.Date  acb20e;
	// 招聘信息采集员
	protected String  acb20b;
	// 开始日期
	protected java.util.Date  aae030;
	// 终止日期
	protected java.util.Date  aae031;
	// 是否在网站上显示(0-不显示1-显示)
	protected Long  cccj01=1l;
	// 浏览次数
	protected Long  cccj02=1l;
	// 刷新时间
	protected java.util.Date  cccj03=new Date();
	// 推荐值
	protected Long  cccj04=0l;
	// 是否在四六级显示(0-不显示1-显示)
	protected Long  cccj05=0l;
	// 是否在大屏幕显示(0-不显示1-显示)
	protected Long  cccj06=0l;
	// 是否在社区显示(0-不显示1-显示)
	protected Long  cccj07=0l;
	// 是否允许其它职介查看(0-不允许1-允许)
	protected Long  cccj08=0l;
	// 是否允许职介中心查看(0-不允许1-允许)
	protected Long  cccj09=0l;
	// 最后修改时间
	protected java.util.Date  ccpr05=new Date();
	// 修改人
	protected String  ccpr06;
	// 修改来源
	protected String  ccpr07;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08="0";
	// 自建行业代码
	protected String  ccpr10;
	// 委托标记1-非委托2-会后转委托
	protected Long  ccpr11=1l;
	// 卡SN号
	protected String  cahy12;
	// 设备编号
	protected Long  div001;
	// 橱窗摊位有效月份
	protected Long  acb20m=0l;
	// 橱窗摊位预定编号
	protected Long  cczf01;
	// 招聘会要求
	protected String  acb20n;
	
	// 不需要映射到数据库
	protected Long  acb330;
	
	
	public Long getAcb330() {
		return acb330;
	}
	public void setAcb330(Long acb330) {
		this.acb330 = acb330;
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
	public void setAae014(String aae014) 
	{
		this.aae014 = aae014;
	}
	/**
	 * 返回 传真
	 * @return
	 */
	public String getAae014() 
	{
		return this.aae014;
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
	public void setAcb201(String acb201) 
	{
		this.acb201 = acb201;
	}
	/**
	 * 返回 招聘套餐
	 * @return
	 */
	public String getAcb201() 
	{
		return this.acb201;
	}
	public void setAae043(java.util.Date aae043) 
	{
		this.aae043 = aae043;
	}
	/**
	 * 返回 登记日期
	 * @return
	 */
	public java.util.Date getAae043() 
	{
		return this.aae043;
	}
	public void setAcb208(String acb208) 
	{
		this.acb208 = acb208;
	}
	/**
	 * 返回 冻结标记
	 * @return
	 */
	public String getAcb208() 
	{
		return this.acb208;
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
	 * 返回 机构行政区划代码
	 * @return
	 */
	public String getAae022() 
	{
		return this.aae022;
	}
	public void setAcc2b0(Long acc2b0) 
	{
		this.acc2b0 = acc2b0;
	}
	/**
	 * 返回 信息员编号
	 * @return
	 */
	public Long getAcc2b0() 
	{
		return this.acc2b0;
	}
	public void setAcb20g(String acb20g) 
	{
		this.acb20g = acb20g;
	}
	/**
	 * 返回 是否会员单位
	 * @return
	 */
	public String getAcb20g() 
	{
		return this.acb20g;
	}
	public void setAcb20p(String acb20p) 
	{
		this.acb20p = acb20p;
	}
	/**
	 * 返回 猎头单位检验
	 * @return
	 */
	public String getAcb20p() 
	{
		return this.acb20p;
	}
	public void setAcb20u(String acb20u) 
	{
		this.acb20u = acb20u;
	}
	/**
	 * 返回 历史未反馈校验
	 * @return
	 */
	public String getAcb20u() 
	{
		return this.acb20u;
	}
	public void setAcb20y(String acb20y) 
	{
		this.acb20y = acb20y;
	}
	/**
	 * 返回 违规记录校验
	 * @return
	 */
	public String getAcb20y() 
	{
		return this.acb20y;
	}
	public void setAcb20q(String acb20q) 
	{
		this.acb20q = acb20q;
	}
	/**
	 * 返回 信息发布方式
	 * @return
	 */
	public String getAcb20q() 
	{
		return this.acb20q;
	}
	public void setAcb400(String acb400) 
	{
		this.acb400 = acb400;
	}
	/**
	 * 返回 定向单位编号
	 * @return
	 */
	public String getAcb400() 
	{
		return this.acb400;
	}
	public void setBcb20a(String bcb20a) 
	{
		this.bcb20a = bcb20a;
	}
	/**
	 * 返回 是否定向单位
	 * @return
	 */
	public String getBcb20a() 
	{
		return this.bcb20a;
	}
	public void setAcb260(Long acb260) 
	{
		this.acb260 = acb260;
	}
	/**
	 * 返回 会员编号
	 * @return
	 */
	public Long getAcb260() 
	{
		return this.acb260;
	}
	public void setAcb261(String acb261) 
	{
		this.acb261 = acb261;
	}
	/**
	 * 返回 会员号
	 * @return
	 */
	public String getAcb261() 
	{
		return this.acb261;
	}
	public void setAab011(java.util.Date aab011) 
	{
		this.aab011 = aab011;
	}
	/**
	 * 返回 证件的有效期
	 * @return
	 */
	public java.util.Date getAab011() 
	{
		return this.aab011;
	}
	public void setCab011(java.util.Date cab011) 
	{
		this.cab011 = cab011;
	}
	/**
	 * 返回 证件的年检期
	 * @return
	 */
	public java.util.Date getCab011() 
	{
		return this.cab011;
	}
	public void setBae018(String bae018) 
	{
		this.bae018 = bae018;
	}
	/**
	 * 返回 单位证件类型
	 * @return
	 */
	public String getBae018() 
	{
		return this.bae018;
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
	public void setAcb262(String acb262) 
	{
		this.acb262 = acb262;
	}
	/**
	 * 返回 会员级别
	 * @return
	 */
	public String getAcb262() 
	{
		return this.acb262;
	}
	public void setBcb20b(Float bcb20b) 
	{
		this.bcb20b = bcb20b;
	}
	/**
	 * 返回 原费用
	 * @return
	 */
	public Float getBcb20b() 
	{
		return this.bcb20b;
	}
	public void setBcb20d(Float bcb20d) 
	{
		this.bcb20d = bcb20d;
	}
	/**
	 * 返回 应收费用
	 * @return
	 */
	public Float getBcb20d() 
	{
		return this.bcb20d;
	}
	public void setBcb20e(String bcb20e) 
	{
		this.bcb20e = bcb20e;
	}
	/**
	 * 返回 费用状态
	 * @return
	 */
	public String getBcb20e() 
	{
		return this.bcb20e;
	}
	public void setBab004(String bab004) 
	{
		this.bab004 = bab004;
	}
	/**
	 * 返回 发布名称
	 * @return
	 */
	public String getBab004() 
	{
		return this.bab004;
	}
	public void setAcb209(String acb209) 
	{
		this.acb209 = acb209;
	}
	/**
	 * 返回 数据开放程度
	 * @return
	 */
	public String getAcb209() 
	{
		return this.acb209;
	}
	public void setBcb209(String bcb209) 
	{
		this.bcb209 = bcb209;
	}
	/**
	 * 返回 数据来源
	 * @return
	 */
	public String getBcb209() 
	{
		return this.bcb209;
	}
	public void setAcb207(String acb207) 
	{
		this.acb207 = acb207;
	}
	/**
	 * 返回 数据开放对象
	 * @return
	 */
	public String getAcb207() 
	{
		return this.acb207;
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
	public void setAcb263(Float acb263) 
	{
		this.acb263 = acb263;
	}
	/**
	 * 返回 享受折扣
	 * @return
	 */
	public Float getAcb263() 
	{
		return this.acb263;
	}
	public void setBcb201(String bcb201) 
	{
		this.bcb201 = bcb201;
	}
	/**
	 * 返回 招聘套餐
	 * @return
	 */
	public String getBcb201() 
	{
		return this.bcb201;
	}
	public void setAbb561(String abb561) 
	{
		this.abb561 = abb561;
	}
	/**
	 * 返回 审核标记
	 * @return
	 */
	public String getAbb561() 
	{
		return this.abb561;
	}
	public void setAbb771(java.util.Date abb771) 
	{
		this.abb771 = abb771;
	}
	/**
	 * 返回 审核时间
	 * @return
	 */
	public java.util.Date getAbb771() 
	{
		return this.abb771;
	}
	public void setAbb769(String abb769) 
	{
		this.abb769 = abb769;
	}
	/**
	 * 返回 审核人
	 * @return
	 */
	public String getAbb769() 
	{
		return this.abb769;
	}
	public void setAbb770(String abb770) 
	{
		this.abb770 = abb770;
	}
	/**
	 * 返回 审核机构
	 * @return
	 */
	public String getAbb770() 
	{
		return this.abb770;
	}
	public void setAbb772(String abb772) 
	{
		this.abb772 = abb772;
	}
	/**
	 * 返回 审核意见
	 * @return
	 */
	public String getAbb772() 
	{
		return this.abb772;
	}
	public void setAbb773(String abb773) 
	{
		this.abb773 = abb773;
	}
	/**
	 * 返回 审核标记
	 * @return
	 */
	public String getAbb773() 
	{
		return this.abb773;
	}
	public void setAce230(Long ace230) 
	{
		this.ace230 = ace230;
	}
	/**
	 * 返回 套餐编号
	 * @return
	 */
	public Long getAce230() 
	{
		return this.ace230;
	}
	public void setAcb202(String acb202) 
	{
		this.acb202 = acb202;
	}
	/**
	 * 返回 招聘地点
	 * @return
	 */
	public String getAcb202() 
	{
		return this.acb202;
	}
	public void setAcb203(String acb203) 
	{
		this.acb203 = acb203;
	}
	/**
	 * 返回 招聘地区
	 * @return
	 */
	public String getAcb203() 
	{
		return this.acb203;
	}
	public void setAac013(String aac013) 
	{
		this.aac013 = aac013;
	}
	/**
	 * 返回 用工形式
	 * @return
	 */
	public String getAac013() 
	{
		return this.aac013;
	}
	public void setAcb204(String acb204) 
	{
		this.acb204 = acb204;
	}
	/**
	 * 返回 工作地点
	 * @return
	 */
	public String getAcb204() 
	{
		return this.acb204;
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
	public void setAcb20f(String acb20f) 
	{
		this.acb20f = acb20f;
	}
	/**
	 * 返回 面试详细说明
	 * @return
	 */
	public String getAcb20f() 
	{
		return this.acb20f;
	}
	public void setAcb20d(String acb20d) 
	{
		this.acb20d = acb20d;
	}
	/**
	 * 返回 冻结人员
	 * @return
	 */
	public String getAcb20d() 
	{
		return this.acb20d;
	}
	public void setAcb20e(java.util.Date acb20e) 
	{
		this.acb20e = acb20e;
	}
	/**
	 * 返回 冻结日期
	 * @return
	 */
	public java.util.Date getAcb20e() 
	{
		return this.acb20e;
	}
	public void setAcb20b(String acb20b) 
	{
		this.acb20b = acb20b;
	}
	/**
	 * 返回 招聘信息采集员
	 * @return
	 */
	public String getAcb20b() 
	{
		return this.acb20b;
	}
	public void setAae030(java.util.Date aae030) 
	{
		this.aae030 = aae030;
	}
	/**
	 * 返回 开始日期
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
	 * 返回 终止日期
	 * @return
	 */
	public java.util.Date getAae031() 
	{
		return this.aae031;
	}
	public void setCccj01(Long cccj01) 
	{
		this.cccj01 = cccj01;
	}
	/**
	 * 返回 是否在网站上显示(0-不显示1-显示)
	 * @return
	 */
	public Long getCccj01() 
	{
		return this.cccj01;
	}
	public void setCccj02(Long cccj02) 
	{
		this.cccj02 = cccj02;
	}
	/**
	 * 返回 浏览次数
	 * @return
	 */
	public Long getCccj02() 
	{
		return this.cccj02;
	}
	public void setCccj03(java.util.Date cccj03) 
	{
		this.cccj03 = cccj03;
	}
	/**
	 * 返回 刷新时间
	 * @return
	 */
	public java.util.Date getCccj03() 
	{
		return this.cccj03;
	}
	public void setCccj04(Long cccj04) 
	{
		this.cccj04 = cccj04;
	}
	/**
	 * 返回 推荐值
	 * @return
	 */
	public Long getCccj04() 
	{
		return this.cccj04;
	}
	public void setCccj05(Long cccj05) 
	{
		this.cccj05 = cccj05;
	}
	/**
	 * 返回 是否在四六级显示(0-不显示1-显示)
	 * @return
	 */
	public Long getCccj05() 
	{
		return this.cccj05;
	}
	public void setCccj06(Long cccj06) 
	{
		this.cccj06 = cccj06;
	}
	/**
	 * 返回 是否在大屏幕显示(0-不显示1-显示)
	 * @return
	 */
	public Long getCccj06() 
	{
		return this.cccj06;
	}
	public void setCccj07(Long cccj07) 
	{
		this.cccj07 = cccj07;
	}
	/**
	 * 返回 是否在社区显示(0-不显示1-显示)
	 * @return
	 */
	public Long getCccj07() 
	{
		return this.cccj07;
	}
	public void setCccj08(Long cccj08) 
	{
		this.cccj08 = cccj08;
	}
	/**
	 * 返回 是否允许其它职介查看(0-不允许1-允许)
	 * @return
	 */
	public Long getCccj08() 
	{
		return this.cccj08;
	}
	public void setCccj09(Long cccj09) 
	{
		this.cccj09 = cccj09;
	}
	/**
	 * 返回 是否允许职介中心查看(0-不允许1-允许)
	 * @return
	 */
	public Long getCccj09() 
	{
		return this.cccj09;
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
	 * 返回 委托标记1-非委托2-会后转委托
	 * @return
	 */
	public Long getCcpr11() 
	{
		return this.ccpr11;
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
	public void setAcb20m(Long acb20m) 
	{
		this.acb20m = acb20m;
	}
	/**
	 * 返回 橱窗摊位有效月份
	 * @return
	 */
	public Long getAcb20m() 
	{
		return this.acb20m;
	}
	public void setCczf01(Long cczf01) 
	{
		this.cczf01 = cczf01;
	}
	/**
	 * 返回 橱窗摊位预定编号
	 * @return
	 */
	public Long getCczf01() 
	{
		return this.cczf01;
	}
	public void setAcb20n(String acb20n) 
	{
		this.acb20n = acb20n;
	}
	/**
	 * 返回 招聘会要求
	 * @return
	 */
	public String getAcb20n() 
	{
		return this.acb20n;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof CorpPositionPublish))
		{
			return false;
		}
		CorpPositionPublish rhs = (CorpPositionPublish) object;
		return new EqualsBuilder()
		.append(this.acb200, rhs.acb200)
		.append(this.aab001, rhs.aab001)
		.append(this.aab003, rhs.aab003)
		.append(this.aab004, rhs.aab004)
		.append(this.aab021, rhs.aab021)
		.append(this.aab022, rhs.aab022)
		.append(this.aab054, rhs.aab054)
		.append(this.aab019, rhs.aab019)
		.append(this.aab020, rhs.aab020)
		.append(this.aab023, rhs.aab023)
		.append(this.aab301, rhs.aab301)
		.append(this.aaa021, rhs.aaa021)
		.append(this.aab056, rhs.aab056)
		.append(this.acb206, rhs.acb206)
		.append(this.aae006, rhs.aae006)
		.append(this.aae004, rhs.aae004)
		.append(this.aae005, rhs.aae005)
		.append(this.aae139, rhs.aae139)
		.append(this.aae015, rhs.aae015)
		.append(this.aae014, rhs.aae014)
		.append(this.aae016, rhs.aae016)
		.append(this.acb201, rhs.acb201)
		.append(this.aae043, rhs.aae043)
		.append(this.acb208, rhs.acb208)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae022, rhs.aae022)
		.append(this.acc2b0, rhs.acc2b0)
		.append(this.acb20g, rhs.acb20g)
		.append(this.acb20p, rhs.acb20p)
		.append(this.acb20u, rhs.acb20u)
		.append(this.acb20y, rhs.acb20y)
		.append(this.acb20q, rhs.acb20q)
		.append(this.acb400, rhs.acb400)
		.append(this.bcb20a, rhs.bcb20a)
		.append(this.acb260, rhs.acb260)
		.append(this.acb261, rhs.acb261)
		.append(this.aab011, rhs.aab011)
		.append(this.cab011, rhs.cab011)
		.append(this.bae018, rhs.bae018)
		.append(this.acb205, rhs.acb205)
		.append(this.acb262, rhs.acb262)
		.append(this.bcb20b, rhs.bcb20b)
		.append(this.bcb20d, rhs.bcb20d)
		.append(this.bcb20e, rhs.bcb20e)
		.append(this.bab004, rhs.bab004)
		.append(this.acb209, rhs.acb209)
		.append(this.bcb209, rhs.bcb209)
		.append(this.acb207, rhs.acb207)
		.append(this.bcb207, rhs.bcb207)
		.append(this.acb263, rhs.acb263)
		.append(this.bcb201, rhs.bcb201)
		.append(this.abb561, rhs.abb561)
		.append(this.abb771, rhs.abb771)
		.append(this.abb769, rhs.abb769)
		.append(this.abb770, rhs.abb770)
		.append(this.abb772, rhs.abb772)
		.append(this.abb773, rhs.abb773)
		.append(this.ace230, rhs.ace230)
		.append(this.acb202, rhs.acb202)
		.append(this.acb203, rhs.acb203)
		.append(this.aac013, rhs.aac013)
		.append(this.acb204, rhs.acb204)
		.append(this.aac002, rhs.aac002)
		.append(this.acb20c, rhs.acb20c)
		.append(this.acb20f, rhs.acb20f)
		.append(this.acb20d, rhs.acb20d)
		.append(this.acb20e, rhs.acb20e)
		.append(this.acb20b, rhs.acb20b)
		.append(this.aae030, rhs.aae030)
		.append(this.aae031, rhs.aae031)
		.append(this.cccj01, rhs.cccj01)
		.append(this.cccj02, rhs.cccj02)
		.append(this.cccj03, rhs.cccj03)
		.append(this.cccj04, rhs.cccj04)
		.append(this.cccj05, rhs.cccj05)
		.append(this.cccj06, rhs.cccj06)
		.append(this.cccj07, rhs.cccj07)
		.append(this.cccj08, rhs.cccj08)
		.append(this.cccj09, rhs.cccj09)
		.append(this.ccpr05, rhs.ccpr05)
		.append(this.ccpr06, rhs.ccpr06)
		.append(this.ccpr07, rhs.ccpr07)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.ccpr10, rhs.ccpr10)
		.append(this.ccpr11, rhs.ccpr11)
		.append(this.cahy12, rhs.cahy12)
		.append(this.div001, rhs.div001)
		.append(this.acb20m, rhs.acb20m)
		.append(this.cczf01, rhs.cczf01)
		.append(this.acb20n, rhs.acb20n)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.acb200)
		.append(this.aab001)
		.append(this.aab003)
		.append(this.aab004)
		.append(this.aab021)
		.append(this.aab022)
		.append(this.aab054)
		.append(this.aab019)
		.append(this.aab020)
		.append(this.aab023)
		.append(this.aab301)
		.append(this.aaa021)
		.append(this.aab056)
		.append(this.acb206)
		.append(this.aae006)
		.append(this.aae004)
		.append(this.aae005)
		.append(this.aae139)
		.append(this.aae015)
		.append(this.aae014)
		.append(this.aae016)
		.append(this.acb201)
		.append(this.aae043)
		.append(this.acb208)
		.append(this.aae013)
		.append(this.aae011)
		.append(this.aae017)
		.append(this.aae036)
		.append(this.aae019)
		.append(this.aae020)
		.append(this.aae022)
		.append(this.acc2b0)
		.append(this.acb20g)
		.append(this.acb20p)
		.append(this.acb20u)
		.append(this.acb20y)
		.append(this.acb20q)
		.append(this.acb400)
		.append(this.bcb20a)
		.append(this.acb260)
		.append(this.acb261)
		.append(this.aab011)
		.append(this.cab011)
		.append(this.bae018)
		.append(this.acb205)
		.append(this.acb262)
		.append(this.bcb20b)
		.append(this.bcb20d)
		.append(this.bcb20e)
		.append(this.bab004)
		.append(this.acb209)
		.append(this.bcb209)
		.append(this.acb207)
		.append(this.bcb207)
		.append(this.acb263)
		.append(this.bcb201)
		.append(this.abb561)
		.append(this.abb771)
		.append(this.abb769)
		.append(this.abb770)
		.append(this.abb772)
		.append(this.abb773)
		.append(this.ace230)
		.append(this.acb202)
		.append(this.acb203)
		.append(this.aac013)
		.append(this.acb204)
		.append(this.aac002)
		.append(this.acb20c)
		.append(this.acb20f)
		.append(this.acb20d)
		.append(this.acb20e)
		.append(this.acb20b)
		.append(this.aae030)
		.append(this.aae031)
		.append(this.cccj01)
		.append(this.cccj02)
		.append(this.cccj03)
		.append(this.cccj04)
		.append(this.cccj05)
		.append(this.cccj06)
		.append(this.cccj07)
		.append(this.cccj08)
		.append(this.cccj09)
		.append(this.ccpr05)
		.append(this.ccpr06)
		.append(this.ccpr07)
		.append(this.ccpr08)
		.append(this.ccpr10)
		.append(this.ccpr11)
		.append(this.cahy12)
		.append(this.div001)
		.append(this.acb20m)
		.append(this.cczf01)
		.append(this.acb20n)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("acb200", this.acb200) 
		.append("aab001", this.aab001) 
		.append("aab003", this.aab003) 
		.append("aab004", this.aab004) 
		.append("aab021", this.aab021) 
		.append("aab022", this.aab022) 
		.append("aab054", this.aab054) 
		.append("aab019", this.aab019) 
		.append("aab020", this.aab020) 
		.append("aab023", this.aab023) 
		.append("aab301", this.aab301) 
		.append("aaa021", this.aaa021) 
		.append("aab056", this.aab056) 
		.append("acb206", this.acb206) 
		.append("aae006", this.aae006) 
		.append("aae004", this.aae004) 
		.append("aae005", this.aae005) 
		.append("aae139", this.aae139) 
		.append("aae015", this.aae015) 
		.append("aae014", this.aae014) 
		.append("aae016", this.aae016) 
		.append("acb201", this.acb201) 
		.append("aae043", this.aae043) 
		.append("acb208", this.acb208) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae022", this.aae022) 
		.append("acc2b0", this.acc2b0) 
		.append("acb20g", this.acb20g) 
		.append("acb20p", this.acb20p) 
		.append("acb20u", this.acb20u) 
		.append("acb20y", this.acb20y) 
		.append("acb20q", this.acb20q) 
		.append("acb400", this.acb400) 
		.append("bcb20a", this.bcb20a) 
		.append("acb260", this.acb260) 
		.append("acb261", this.acb261) 
		.append("aab011", this.aab011) 
		.append("cab011", this.cab011) 
		.append("bae018", this.bae018) 
		.append("acb205", this.acb205) 
		.append("acb262", this.acb262) 
		.append("bcb20b", this.bcb20b) 
		.append("bcb20d", this.bcb20d) 
		.append("bcb20e", this.bcb20e) 
		.append("bab004", this.bab004) 
		.append("acb209", this.acb209) 
		.append("bcb209", this.bcb209) 
		.append("acb207", this.acb207) 
		.append("bcb207", this.bcb207) 
		.append("acb263", this.acb263) 
		.append("bcb201", this.bcb201) 
		.append("abb561", this.abb561) 
		.append("abb771", this.abb771) 
		.append("abb769", this.abb769) 
		.append("abb770", this.abb770) 
		.append("abb772", this.abb772) 
		.append("abb773", this.abb773) 
		.append("ace230", this.ace230) 
		.append("acb202", this.acb202) 
		.append("acb203", this.acb203) 
		.append("aac013", this.aac013) 
		.append("acb204", this.acb204) 
		.append("aac002", this.aac002) 
		.append("acb20c", this.acb20c) 
		.append("acb20f", this.acb20f) 
		.append("acb20d", this.acb20d) 
		.append("acb20e", this.acb20e) 
		.append("acb20b", this.acb20b) 
		.append("aae030", this.aae030) 
		.append("aae031", this.aae031) 
		.append("cccj01", this.cccj01) 
		.append("cccj02", this.cccj02) 
		.append("cccj03", this.cccj03) 
		.append("cccj04", this.cccj04) 
		.append("cccj05", this.cccj05) 
		.append("cccj06", this.cccj06) 
		.append("cccj07", this.cccj07) 
		.append("cccj08", this.cccj08) 
		.append("cccj09", this.cccj09) 
		.append("ccpr05", this.ccpr05) 
		.append("ccpr06", this.ccpr06) 
		.append("ccpr07", this.ccpr07) 
		.append("ccpr08", this.ccpr08) 
		.append("ccpr10", this.ccpr10) 
		.append("ccpr11", this.ccpr11) 
		.append("cahy12", this.cahy12) 
		.append("div001", this.div001) 
		.append("acb20m", this.acb20m) 
		.append("cczf01", this.cczf01) 
		.append("acb20n", this.acb20n) 
		.toString();
	}
   
  

}