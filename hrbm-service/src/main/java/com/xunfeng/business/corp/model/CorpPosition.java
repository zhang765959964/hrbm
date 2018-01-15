package com.xunfeng.business.corp.model;

import java.util.Date;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 招聘空位信息表 Model对象
* @author:wxl
* @createDate 2015-07-24 11:31:13 
* @version V1.0   
*/
public class CorpPosition extends BaseModel
{
	// 招聘空位编号
	protected Long  acb210;
	// 招聘编号
	protected Long  acb200;
	// 单位编号
	protected Long  aab001;
	// 单位名称
	protected String  aab004;
	// 开始日期
	protected java.util.Date  aae030;
	// 终止日期
	protected java.util.Date  aae031;
	// 工种代码
	protected String  aca111;
	// 工种名称
	protected String  aca112;
	// 形式工种代码
	protected String  bca111;
	// 形式工种名称
	protected String  bca112;
	// 招聘人数
	protected Integer  acb21r;
	// 推荐比例
	protected Long  acb21p;
	// 性别
	protected String  aad004;
	// 民族
	protected String  aac005;
	// 最低年龄
	protected Long  acb221;
	// 最高年龄
	protected Long  acb222;
	// 户口性质
	protected String  aac009;
	// 文化程度
	protected String  aac011;
	// 政治面貌
	protected String  aac024;
	// 婚姻状况
	protected String  aac017;
	// 健康状况
	protected String  aac033;
	// 身高
	protected Float  aac034;
	// 体重
	protected Float  aac035;
	// 视力
	protected String  aac036;
	// 工作年限
	protected String  acc217;
	// 职业资格技术等级
	protected String  aac015="9";
	// 专业技术职务
	protected String  aac014;
	// 外语语种
	protected String  aac038;
	// 外语水平
	protected String  aac039;
	// 计算机水平
	protected String  aac043;
	// 其它技能要求
	protected String  acb224;
	// 招聘对象
	protected String  acc20t;
	// 就业困难对象
	protected String  aac029;
	// 工作地点代码
	protected String  acb202;
	// 工作地点2代码
	protected String  acb203;
	// 工作地点3代码
	protected String  acb204;
	// 试用期
	protected String  acb21x;
	// 试用期工资
	protected String  acb21y;
	// 月工资
	protected String  acc034;
	// 福利待遇
	protected String  acc214="9";
	// 食宿提供
	protected String  acb228;
	// 提供培训项目
	protected String  acb22d;
	// 合同期限
	protected String  acb214;
	// 冻结标记
	protected String  acb208;
	// 冻结人员
	protected String  acb20d;
	// 冻结日期
	protected java.util.Date  acb20e;
	// 冻结原因
	protected String  acb20l;
	// 已推荐总数
	protected Long  acb21q;
	// 已成功总数
	protected Long  acb21t;
	// 可推荐总数
	protected Long  acb21g;
	// 未反馈总数
	protected Long  acb21f;
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
	// 面试地点
	protected String  acb20c;
	// 组织机构代码
	protected String  aab003;
	// 所学专业
	protected String  acc01g;
	// 工作职责
	protected String  bcb21a;
	// 序号
	protected Long  bcb21b;
	// 所学专业名称
	protected String  bcc01g;
	// 专业技术职务名称
	protected String  bac014;
	// 英语水平
	protected String  bcc039;
	// 掌握语言
	protected String  bcc038;
	// 普通话水平
	protected String  bcc20x;
	// 资格证书类型
	protected String  bcc02i;
	// 匹配条件
	protected String  cbppcc;
	// 工作地点名称
	protected String  bcb202;
	// 工作地点2名称
	protected String  bcb203;
	// 工作地点3名称
	protected String  bcb204;
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
	// 工种描述主键
	protected Long  cca111;
	// 工种描述
	protected String  cca112;
	// 职位说明
	protected String  cca113;
	// 岗位描述
	protected String  cca114;
	// 招收区域
	protected String  acb217;
	// 用工形式
	protected String  aac013="1";
	// 劳动报酬
	protected Float  acb21h=1f;
	// 工资待遇说明(工作性质)
	protected String  acb21i;
	// 是否招收优惠人员

	protected String  acb21k="0";
	// 是否招收外来人员（工作环境）
	protected String  acb21c="0";
	// 是否招收大龄人员

	protected String  acb035="0";
	// 男性人数
	protected Long  acb21d=0l;
	// 女性人数
	protected Long  acb21e;
	// 委托招聘男性人数

	protected Long  acb211;
	// 委托招聘女性人数
	protected Long  acb212;
	// 委托招聘兼招人数
	protected Long  acb213;
	// 已推荐男性人数

	protected Long  acb219;
	// 已推荐女性人数
	protected Long  acb218;
	// 已成功男性人数

	protected Long  acb21a;
	// 已成功女性人数

	protected Long  acb21b;
	// 剩余推荐男性人数

	protected Long  acb21l;
	// 剩余推荐女性人数
	protected Long  acb21m;
	// 剩余推荐兼招人数

	protected Long  acb21n;
	// 招聘信息采集员

	protected String  acb20b;
	// 数据来源0未知1网站2窗口
	protected String  cczy06;
	// 置顶排序(0-不置顶1-置顶)
	protected Long  cczy07=0l;
	// 浏览次数
	protected Long  cczy08=0l;
	// 信息发布方式
	protected String  acb20q;
	// 最后修改时间
	protected java.util.Date  ccpr05=new Date();
	// 刷新时间
	protected java.util.Date  cczy09=new Date();
	// 置顶时间2013-01-15
	protected java.util.Date  cczy10;
	// 最后修改人
	protected String  ccpr06;
	// 修改来源
	protected String  ccpr07;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08="0";
	// 会后是否转委托0-否1-自动转
	protected Long  ccpr09=0l;
	// 委托标记1-正常委托2-会后转委托3-现场应用到委托4-委托应用于现场
	protected Long  ccpr11=1l;
	// 年龄段标记1-（16-24岁）2-（25-34岁）3-（35-44岁）4-（45岁以上）9-无要求
	protected String  acb223;
	// 设备编号
	protected Long  div001;
	// 发布内容
	protected String  cca115;
	// 橱窗下对应原来的岗位编号
	protected Long  bcb210=0l;
	// 招聘会下的岗位描述
	protected String  cca116;
	
	//工作经验
	protected String workYearsName;
	

	public String getWorkYearsName() {
		return workYearsName;
	}

	public void setWorkYearsName(String workYearsName) {
		this.workYearsName = workYearsName;
	}


	public void setAcb210(Long acb210)
	{
		this.acb210 = acb210;
	}
	/**
	 * 返回 招聘空位编号
	 * @return
	 */
	public Long getAcb210() 
	{
		return this.acb210;
	}
	public void setAcb200(Long acb200) 
	{
		this.acb200 = acb200;
	}
	/**
	 * 返回 招聘编号
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
	public void setAae030(java.util.Date aae030) 
	{
		this.aae030 = aae030;
	}
	/**
	 * 返回 开始日期
	 * @return
	 */
	@JsonSerialize(using = JsonDateSerializer.class)
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
	@JsonSerialize(using = JsonDateSerializer.class)
	public java.util.Date getAae031() 
	{
		return this.aae031;
	}
	public void setAca111(String aca111) 
	{
		this.aca111 = aca111;
	}
	/**
	 * 返回 工种代码
	 * @return
	 */
	public String getAca111() 
	{
		return this.aca111;
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
	public void setBca111(String bca111) 
	{
		this.bca111 = bca111;
	}
	/**
	 * 返回 形式工种代码
	 * @return
	 */
	public String getBca111() 
	{
		return this.bca111;
	}
	public void setBca112(String bca112) 
	{
		this.bca112 = bca112;
	}
	/**
	 * 返回 形式工种名称
	 * @return
	 */
	public String getBca112() 
	{
		return this.bca112;
	}
	public void setAcb21r(Integer acb21r)
	{
		this.acb21r = acb21r;
	}
	/**
	 * 返回 招聘人数
	 * @return
	 */
	public Integer getAcb21r()
	{
		return this.acb21r;
	}
	public void setAcb21p(Long acb21p) 
	{
		this.acb21p = acb21p;
	}
	/**
	 * 返回 推荐比例
	 * @return
	 */
	public Long getAcb21p() 
	{
		return this.acb21p;
	}
	public void setAad004(String aad004) 
	{
		this.aad004 = aad004;
	}
	/**
	 * 返回 性别
	 * @return
	 */
	public String getAad004() 
	{
		return this.aad004;
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
	public void setAcb221(Long acb221) 
	{
		this.acb221 = acb221;
	}
	/**
	 * 返回 最低年龄
	 * @return
	 */
	public Long getAcb221() 
	{
		return this.acb221;
	}
	public void setAcb222(Long acb222) 
	{
		this.acb222 = acb222;
	}
	/**
	 * 返回 最高年龄
	 * @return
	 */
	public Long getAcb222() 
	{
		return this.acb222;
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
	public void setAcc217(String acc217) 
	{
		this.acc217 = acc217;
	}
	/**
	 * 返回 工作年限
	 * @return
	 */
	public String getAcc217() 
	{
		return this.acc217;
	}
	public void setAac015(String aac015) 
	{
		this.aac015 = aac015;
	}
	/**
	 * 返回 职业资格技术等级
	 * @return
	 */
	public String getAac015() 
	{
		return this.aac015;
	}
	public void setAac014(String aac014) 
	{
		this.aac014 = aac014;
	}
	/**
	 * 返回 专业技术职务
	 * @return
	 */
	public String getAac014() 
	{
		return this.aac014;
	}
	public void setAac038(String aac038) 
	{
		this.aac038 = aac038;
	}
	/**
	 * 返回 外语语种
	 * @return
	 */
	public String getAac038() 
	{
		return this.aac038;
	}
	public void setAac039(String aac039) 
	{
		this.aac039 = aac039;
	}
	/**
	 * 返回 外语水平
	 * @return
	 */
	public String getAac039() 
	{
		return this.aac039;
	}
	public void setAac043(String aac043) 
	{
		this.aac043 = aac043;
	}
	/**
	 * 返回 计算机水平
	 * @return
	 */
	public String getAac043() 
	{
		return this.aac043;
	}
	public void setAcb224(String acb224) 
	{
		this.acb224 = acb224;
	}
	/**
	 * 返回 其它技能要求
	 * @return
	 */
	public String getAcb224() 
	{
		return this.acb224;
	}
	public void setAcc20t(String acc20t) 
	{
		this.acc20t = acc20t;
	}
	/**
	 * 返回 招聘对象
	 * @return
	 */
	public String getAcc20t() 
	{
		return this.acc20t;
	}
	public void setAac029(String aac029) 
	{
		this.aac029 = aac029;
	}
	/**
	 * 返回 就业困难对象
	 * @return
	 */
	public String getAac029() 
	{
		return this.aac029;
	}
	public void setAcb202(String acb202) 
	{
		this.acb202 = acb202;
	}
	/**
	 * 返回 工作地点代码
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
	 * 返回 工作地点2代码
	 * @return
	 */
	public String getAcb203() 
	{
		return this.acb203;
	}
	public void setAcb204(String acb204) 
	{
		this.acb204 = acb204;
	}
	/**
	 * 返回 工作地点3代码
	 * @return
	 */
	public String getAcb204() 
	{
		return this.acb204;
	}
	public void setAcb21x(String acb21x) 
	{
		this.acb21x = acb21x;
	}
	/**
	 * 返回 试用期
	 * @return
	 */
	public String getAcb21x() 
	{
		return this.acb21x;
	}
	public void setAcb21y(String acb21y) 
	{
		this.acb21y = acb21y;
	}
	/**
	 * 返回 试用期工资
	 * @return
	 */
	public String getAcb21y() 
	{
		return this.acb21y;
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
	 * 返回 福利待遇
	 * @return
	 */
	public String getAcc214() 
	{
		return this.acc214;
	}
	public void setAcb228(String acb228) 
	{
		this.acb228 = acb228;
	}
	/**
	 * 返回 食宿提供
	 * @return
	 */
	public String getAcb228() 
	{
		return this.acb228;
	}
	public void setAcb22d(String acb22d) 
	{
		this.acb22d = acb22d;
	}
	/**
	 * 返回 提供培训项目
	 * @return
	 */
	public String getAcb22d() 
	{
		return this.acb22d;
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
	public void setAcb20l(String acb20l) 
	{
		this.acb20l = acb20l;
	}
	/**
	 * 返回 冻结原因
	 * @return
	 */
	public String getAcb20l() 
	{
		return this.acb20l;
	}
	public void setAcb21q(Long acb21q) 
	{
		this.acb21q = acb21q;
	}
	/**
	 * 返回 已推荐总数
	 * @return
	 */
	public Long getAcb21q() 
	{
		return this.acb21q;
	}
	public void setAcb21t(Long acb21t) 
	{
		this.acb21t = acb21t;
	}
	/**
	 * 返回 已成功总数
	 * @return
	 */
	public Long getAcb21t() 
	{
		return this.acb21t;
	}
	public void setAcb21g(Long acb21g) 
	{
		this.acb21g = acb21g;
	}
	/**
	 * 返回 可推荐总数
	 * @return
	 */
	public Long getAcb21g() 
	{
		return this.acb21g;
	}
	public void setAcb21f(Long acb21f) 
	{
		this.acb21f = acb21f;
	}
	/**
	 * 返回 未反馈总数
	 * @return
	 */
	public Long getAcb21f() 
	{
		return this.acb21f;
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
	public void setAcc01g(String acc01g) 
	{
		this.acc01g = acc01g;
	}
	/**
	 * 返回 所学专业
	 * @return
	 */
	public String getAcc01g() 
	{
		return this.acc01g;
	}
	public void setBcb21a(String bcb21a) 
	{
		this.bcb21a = bcb21a;
	}
	/**
	 * 返回 工作职责
	 * @return
	 */
	public String getBcb21a() 
	{
		return this.bcb21a;
	}
	public void setBcb21b(Long bcb21b) 
	{
		this.bcb21b = bcb21b;
	}
	/**
	 * 返回 序号
	 * @return
	 */
	public Long getBcb21b() 
	{
		return this.bcb21b;
	}
	public void setBcc01g(String bcc01g) 
	{
		this.bcc01g = bcc01g;
	}
	/**
	 * 返回 所学专业名称
	 * @return
	 */
	public String getBcc01g() 
	{
		return this.bcc01g;
	}
	public void setBac014(String bac014) 
	{
		this.bac014 = bac014;
	}
	/**
	 * 返回 专业技术职务名称
	 * @return
	 */
	public String getBac014() 
	{
		return this.bac014;
	}
	public void setBcc039(String bcc039) 
	{
		this.bcc039 = bcc039;
	}
	/**
	 * 返回 英语水平
	 * @return
	 */
	public String getBcc039() 
	{
		return this.bcc039;
	}
	public void setBcc038(String bcc038) 
	{
		this.bcc038 = bcc038;
	}
	/**
	 * 返回 掌握语言
	 * @return
	 */
	public String getBcc038() 
	{
		return this.bcc038;
	}
	public void setBcc20x(String bcc20x) 
	{
		this.bcc20x = bcc20x;
	}
	/**
	 * 返回 普通话水平
	 * @return
	 */
	public String getBcc20x() 
	{
		return this.bcc20x;
	}
	public void setBcc02i(String bcc02i) 
	{
		this.bcc02i = bcc02i;
	}
	/**
	 * 返回 资格证书类型
	 * @return
	 */
	public String getBcc02i() 
	{
		return this.bcc02i;
	}
	public void setCbppcc(String cbppcc) 
	{
		this.cbppcc = cbppcc;
	}
	/**
	 * 返回 匹配条件
	 * @return
	 */
	public String getCbppcc() 
	{
		return this.cbppcc;
	}
	public void setBcb202(String bcb202) 
	{
		this.bcb202 = bcb202;
	}
	/**
	 * 返回 工作地点名称
	 * @return
	 */
	public String getBcb202() 
	{
		return this.bcb202;
	}
	public void setBcb203(String bcb203) 
	{
		this.bcb203 = bcb203;
	}
	/**
	 * 返回 工作地点2名称
	 * @return
	 */
	public String getBcb203() 
	{
		return this.bcb203;
	}
	public void setBcb204(String bcb204) 
	{
		this.bcb204 = bcb204;
	}
	/**
	 * 返回 工作地点3名称
	 * @return
	 */
	public String getBcb204() 
	{
		return this.bcb204;
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
	 * 返回 职位说明
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
	public void setAcb217(String acb217) 
	{
		this.acb217 = acb217;
	}
	/**
	 * 返回 招收区域
	 * @return
	 */
	public String getAcb217() 
	{
		return this.acb217;
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
	public void setAcb21h(Float acb21h) 
	{
		this.acb21h = acb21h;
	}
	/**
	 * 返回 劳动报酬
	 * @return
	 */
	public Float getAcb21h() 
	{
		return this.acb21h;
	}
	public void setAcb21i(String acb21i) 
	{
		this.acb21i = acb21i;
	}
	/**
	 * 返回 工资待遇说明(工作性质)
	 * @return
	 */
	public String getAcb21i() 
	{
		return this.acb21i;
	}
	public void setAcb21k(String acb21k) 
	{
		this.acb21k = acb21k;
	}
	/**
	 * 返回 是否招收优惠人员

	 * @return
	 */
	public String getAcb21k() 
	{
		return this.acb21k;
	}
	public void setAcb21c(String acb21c) 
	{
		this.acb21c = acb21c;
	}
	/**
	 * 返回 是否招收外来人员
（工作环境）
	 * @return
	 */
	public String getAcb21c() 
	{
		return this.acb21c;
	}
	public void setAcb035(String acb035) 
	{
		this.acb035 = acb035;
	}
	/**
	 * 返回 是否招收大龄人员

	 * @return
	 */
	public String getAcb035() 
	{
		return this.acb035;
	}
	public void setAcb21d(Long acb21d) 
	{
		this.acb21d = acb21d;
	}
	/**
	 * 返回 男性人数
	 * @return
	 */
	public Long getAcb21d() 
	{
		return this.acb21d;
	}
	public void setAcb21e(Long acb21e) 
	{
		this.acb21e = acb21e;
	}
	/**
	 * 返回 女性人数
	 * @return
	 */
	public Long getAcb21e() 
	{
		return this.acb21e;
	}
	public void setAcb211(Long acb211) 
	{
		this.acb211 = acb211;
	}
	/**
	 * 返回 委托招聘男性人数

	 * @return
	 */
	public Long getAcb211() 
	{
		return this.acb211;
	}
	public void setAcb212(Long acb212) 
	{
		this.acb212 = acb212;
	}
	/**
	 * 返回 委托招聘女性人数
	 * @return
	 */
	public Long getAcb212() 
	{
		return this.acb212;
	}
	public void setAcb213(Long acb213) 
	{
		this.acb213 = acb213;
	}
	/**
	 * 返回 委托招聘兼招人数
	 * @return
	 */
	public Long getAcb213() 
	{
		return this.acb213;
	}
	public void setAcb219(Long acb219) 
	{
		this.acb219 = acb219;
	}
	/**
	 * 返回 已推荐男性人数

	 * @return
	 */
	public Long getAcb219() 
	{
		return this.acb219;
	}
	public void setAcb218(Long acb218) 
	{
		this.acb218 = acb218;
	}
	/**
	 * 返回 已推荐女性人数
	 * @return
	 */
	public Long getAcb218() 
	{
		return this.acb218;
	}
	public void setAcb21a(Long acb21a) 
	{
		this.acb21a = acb21a;
	}
	/**
	 * 返回 已成功男性人数

	 * @return
	 */
	public Long getAcb21a() 
	{
		return this.acb21a;
	}
	public void setAcb21b(Long acb21b) 
	{
		this.acb21b = acb21b;
	}
	/**
	 * 返回 已成功女性人数

	 * @return
	 */
	public Long getAcb21b() 
	{
		return this.acb21b;
	}
	public void setAcb21l(Long acb21l) 
	{
		this.acb21l = acb21l;
	}
	/**
	 * 返回 剩余推荐男性人数

	 * @return
	 */
	public Long getAcb21l() 
	{
		return this.acb21l;
	}
	public void setAcb21m(Long acb21m) 
	{
		this.acb21m = acb21m;
	}
	/**
	 * 返回 剩余推荐女性人数
	 * @return
	 */
	public Long getAcb21m() 
	{
		return this.acb21m;
	}
	public void setAcb21n(Long acb21n) 
	{
		this.acb21n = acb21n;
	}
	/**
	 * 返回 剩余推荐兼招人数

	 * @return
	 */
	public Long getAcb21n() 
	{
		return this.acb21n;
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
	public void setCczy07(Long cczy07) 
	{
		this.cczy07 = cczy07;
	}
	/**
	 * 返回 置顶排序(0-不置顶1-置顶)
	 * @return
	 */
	public Long getCczy07() 
	{
		return this.cczy07;
	}
	public void setCczy08(Long cczy08) 
	{
		this.cczy08 = cczy08;
	}
	/**
	 * 返回 浏览次数
	 * @return
	 */
	public Long getCczy08() 
	{
		return this.cczy08;
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
	public void setCczy09(java.util.Date cczy09) 
	{
		this.cczy09 = cczy09;
	}
	/**
	 * 返回 刷新时间
	 * @return
	 */
	public java.util.Date getCczy09() 
	{
		return this.cczy09;
	}
	public void setCczy10(java.util.Date cczy10) 
	{
		this.cczy10 = cczy10;
	}
	/**
	 * 返回 置顶时间2013-01-15
	 * @return
	 */
	public java.util.Date getCczy10() 
	{
		return this.cczy10;
	}
	public void setCcpr06(String ccpr06) 
	{
		this.ccpr06 = ccpr06;
	}
	/**
	 * 返回 最后修改人
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
	public void setCcpr09(Long ccpr09) 
	{
		this.ccpr09 = ccpr09;
	}
	/**
	 * 返回 会后是否转委托0-否1-自动转
	 * @return
	 */
	public Long getCcpr09() 
	{
		return this.ccpr09;
	}
	public void setCcpr11(Long ccpr11) 
	{
		this.ccpr11 = ccpr11;
	}
	/**
	 * 返回 委托标记1-正常委托2-会后转委托3-现场应用到委托4-委托应用于现场
	 * @return
	 */
	public Long getCcpr11() 
	{
		return this.ccpr11;
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
	public void setCca115(String cca115) 
	{
		this.cca115 = cca115;
	}
	/**
	 * 返回 发布内容
	 * @return
	 */
	public String getCca115() 
	{
		return this.cca115;
	}
	public void setBcb210(Long bcb210) 
	{
		this.bcb210 = bcb210;
	}
	/**
	 * 返回 橱窗下对应原来的岗位编号
	 * @return
	 */
	public Long getBcb210() 
	{
		return this.bcb210;
	}
	public void setCca116(String cca116) 
	{
		this.cca116 = cca116;
	}
	/**
	 * 返回 招聘会下的岗位描述
	 * @return
	 */
	public String getCca116() 
	{
		return this.cca116;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof CorpPosition))
		{
			return false;
		}
		CorpPosition rhs = (CorpPosition) object;
		return new EqualsBuilder()
		.append(this.acb210, rhs.acb210)
		.append(this.acb200, rhs.acb200)
		.append(this.aab001, rhs.aab001)
		.append(this.aab004, rhs.aab004)
		.append(this.aae030, rhs.aae030)
		.append(this.aae031, rhs.aae031)
		.append(this.aca111, rhs.aca111)
		.append(this.aca112, rhs.aca112)
		.append(this.bca111, rhs.bca111)
		.append(this.bca112, rhs.bca112)
		.append(this.acb21r, rhs.acb21r)
		.append(this.acb21p, rhs.acb21p)
		.append(this.aad004, rhs.aad004)
		.append(this.aac005, rhs.aac005)
		.append(this.acb221, rhs.acb221)
		.append(this.acb222, rhs.acb222)
		.append(this.aac009, rhs.aac009)
		.append(this.aac011, rhs.aac011)
		.append(this.aac024, rhs.aac024)
		.append(this.aac017, rhs.aac017)
		.append(this.aac033, rhs.aac033)
		.append(this.aac034, rhs.aac034)
		.append(this.aac035, rhs.aac035)
		.append(this.aac036, rhs.aac036)
		.append(this.acc217, rhs.acc217)
		.append(this.aac015, rhs.aac015)
		.append(this.aac014, rhs.aac014)
		.append(this.aac038, rhs.aac038)
		.append(this.aac039, rhs.aac039)
		.append(this.aac043, rhs.aac043)
		.append(this.acb224, rhs.acb224)
		.append(this.acc20t, rhs.acc20t)
		.append(this.aac029, rhs.aac029)
		.append(this.acb202, rhs.acb202)
		.append(this.acb203, rhs.acb203)
		.append(this.acb204, rhs.acb204)
		.append(this.acb21x, rhs.acb21x)
		.append(this.acb21y, rhs.acb21y)
		.append(this.acc034, rhs.acc034)
		.append(this.acc214, rhs.acc214)
		.append(this.acb228, rhs.acb228)
		.append(this.acb22d, rhs.acb22d)
		.append(this.acb214, rhs.acb214)
		.append(this.acb208, rhs.acb208)
		.append(this.acb20d, rhs.acb20d)
		.append(this.acb20e, rhs.acb20e)
		.append(this.acb20l, rhs.acb20l)
		.append(this.acb21q, rhs.acb21q)
		.append(this.acb21t, rhs.acb21t)
		.append(this.acb21g, rhs.acb21g)
		.append(this.acb21f, rhs.acb21f)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae022, rhs.aae022)
		.append(this.acb20c, rhs.acb20c)
		.append(this.aab003, rhs.aab003)
		.append(this.acc01g, rhs.acc01g)
		.append(this.bcb21a, rhs.bcb21a)
		.append(this.bcb21b, rhs.bcb21b)
		.append(this.bcc01g, rhs.bcc01g)
		.append(this.bac014, rhs.bac014)
		.append(this.bcc039, rhs.bcc039)
		.append(this.bcc038, rhs.bcc038)
		.append(this.bcc20x, rhs.bcc20x)
		.append(this.bcc02i, rhs.bcc02i)
		.append(this.cbppcc, rhs.cbppcc)
		.append(this.bcb202, rhs.bcb202)
		.append(this.bcb203, rhs.bcb203)
		.append(this.bcb204, rhs.bcb204)
		.append(this.abb561, rhs.abb561)
		.append(this.abb771, rhs.abb771)
		.append(this.abb769, rhs.abb769)
		.append(this.abb770, rhs.abb770)
		.append(this.abb772, rhs.abb772)
		.append(this.abb773, rhs.abb773)
		.append(this.cca111, rhs.cca111)
		.append(this.cca112, rhs.cca112)
		.append(this.cca113, rhs.cca113)
		.append(this.cca114, rhs.cca114)
		.append(this.acb217, rhs.acb217)
		.append(this.aac013, rhs.aac013)
		.append(this.acb21h, rhs.acb21h)
		.append(this.acb21i, rhs.acb21i)
		.append(this.acb21k, rhs.acb21k)
		.append(this.acb21c, rhs.acb21c)
		.append(this.acb035, rhs.acb035)
		.append(this.acb21d, rhs.acb21d)
		.append(this.acb21e, rhs.acb21e)
		.append(this.acb211, rhs.acb211)
		.append(this.acb212, rhs.acb212)
		.append(this.acb213, rhs.acb213)
		.append(this.acb219, rhs.acb219)
		.append(this.acb218, rhs.acb218)
		.append(this.acb21a, rhs.acb21a)
		.append(this.acb21b, rhs.acb21b)
		.append(this.acb21l, rhs.acb21l)
		.append(this.acb21m, rhs.acb21m)
		.append(this.acb21n, rhs.acb21n)
		.append(this.acb20b, rhs.acb20b)
		.append(this.cczy06, rhs.cczy06)
		.append(this.cczy07, rhs.cczy07)
		.append(this.cczy08, rhs.cczy08)
		.append(this.acb20q, rhs.acb20q)
		.append(this.ccpr05, rhs.ccpr05)
		.append(this.cczy09, rhs.cczy09)
		.append(this.cczy10, rhs.cczy10)
		.append(this.ccpr06, rhs.ccpr06)
		.append(this.ccpr07, rhs.ccpr07)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.ccpr09, rhs.ccpr09)
		.append(this.ccpr11, rhs.ccpr11)
		.append(this.acb223, rhs.acb223)
		.append(this.div001, rhs.div001)
		.append(this.cca115, rhs.cca115)
		.append(this.bcb210, rhs.bcb210)
		.append(this.cca116, rhs.cca116)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.acb210)
		.append(this.acb200)
		.append(this.aab001)
		.append(this.aab004)
		.append(this.aae030)
		.append(this.aae031)
		.append(this.aca111)
		.append(this.aca112)
		.append(this.bca111)
		.append(this.bca112)
		.append(this.acb21r)
		.append(this.acb21p)
		.append(this.aad004)
		.append(this.aac005)
		.append(this.acb221)
		.append(this.acb222)
		.append(this.aac009)
		.append(this.aac011)
		.append(this.aac024)
		.append(this.aac017)
		.append(this.aac033)
		.append(this.aac034)
		.append(this.aac035)
		.append(this.aac036)
		.append(this.acc217)
		.append(this.aac015)
		.append(this.aac014)
		.append(this.aac038)
		.append(this.aac039)
		.append(this.aac043)
		.append(this.acb224)
		.append(this.acc20t)
		.append(this.aac029)
		.append(this.acb202)
		.append(this.acb203)
		.append(this.acb204)
		.append(this.acb21x)
		.append(this.acb21y)
		.append(this.acc034)
		.append(this.acc214)
		.append(this.acb228)
		.append(this.acb22d)
		.append(this.acb214)
		.append(this.acb208)
		.append(this.acb20d)
		.append(this.acb20e)
		.append(this.acb20l)
		.append(this.acb21q)
		.append(this.acb21t)
		.append(this.acb21g)
		.append(this.acb21f)
		.append(this.aae013)
		.append(this.aae011)
		.append(this.aae017)
		.append(this.aae036)
		.append(this.aae019)
		.append(this.aae020)
		.append(this.aae022)
		.append(this.acb20c)
		.append(this.aab003)
		.append(this.acc01g)
		.append(this.bcb21a)
		.append(this.bcb21b)
		.append(this.bcc01g)
		.append(this.bac014)
		.append(this.bcc039)
		.append(this.bcc038)
		.append(this.bcc20x)
		.append(this.bcc02i)
		.append(this.cbppcc)
		.append(this.bcb202)
		.append(this.bcb203)
		.append(this.bcb204)
		.append(this.abb561)
		.append(this.abb771)
		.append(this.abb769)
		.append(this.abb770)
		.append(this.abb772)
		.append(this.abb773)
		.append(this.cca111)
		.append(this.cca112)
		.append(this.cca113)
		.append(this.cca114)
		.append(this.acb217)
		.append(this.aac013)
		.append(this.acb21h)
		.append(this.acb21i)
		.append(this.acb21k)
		.append(this.acb21c)
		.append(this.acb035)
		.append(this.acb21d)
		.append(this.acb21e)
		.append(this.acb211)
		.append(this.acb212)
		.append(this.acb213)
		.append(this.acb219)
		.append(this.acb218)
		.append(this.acb21a)
		.append(this.acb21b)
		.append(this.acb21l)
		.append(this.acb21m)
		.append(this.acb21n)
		.append(this.acb20b)
		.append(this.cczy06)
		.append(this.cczy07)
		.append(this.cczy08)
		.append(this.acb20q)
		.append(this.ccpr05)
		.append(this.cczy09)
		.append(this.cczy10)
		.append(this.ccpr06)
		.append(this.ccpr07)
		.append(this.ccpr08)
		.append(this.ccpr09)
		.append(this.ccpr11)
		.append(this.acb223)
		.append(this.div001)
		.append(this.cca115)
		.append(this.bcb210)
		.append(this.cca116)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("acb210", this.acb210) 
		.append("acb200", this.acb200) 
		.append("aab001", this.aab001) 
		.append("aab004", this.aab004) 
		.append("aae030", this.aae030) 
		.append("aae031", this.aae031) 
		.append("aca111", this.aca111) 
		.append("aca112", this.aca112) 
		.append("bca111", this.bca111) 
		.append("bca112", this.bca112) 
		.append("acb21r", this.acb21r) 
		.append("acb21p", this.acb21p) 
		.append("aad004", this.aad004) 
		.append("aac005", this.aac005) 
		.append("acb221", this.acb221) 
		.append("acb222", this.acb222) 
		.append("aac009", this.aac009) 
		.append("aac011", this.aac011) 
		.append("aac024", this.aac024) 
		.append("aac017", this.aac017) 
		.append("aac033", this.aac033) 
		.append("aac034", this.aac034) 
		.append("aac035", this.aac035) 
		.append("aac036", this.aac036) 
		.append("acc217", this.acc217) 
		.append("aac015", this.aac015) 
		.append("aac014", this.aac014) 
		.append("aac038", this.aac038) 
		.append("aac039", this.aac039) 
		.append("aac043", this.aac043) 
		.append("acb224", this.acb224) 
		.append("acc20t", this.acc20t) 
		.append("aac029", this.aac029) 
		.append("acb202", this.acb202) 
		.append("acb203", this.acb203) 
		.append("acb204", this.acb204) 
		.append("acb21x", this.acb21x) 
		.append("acb21y", this.acb21y) 
		.append("acc034", this.acc034) 
		.append("acc214", this.acc214) 
		.append("acb228", this.acb228) 
		.append("acb22d", this.acb22d) 
		.append("acb214", this.acb214) 
		.append("acb208", this.acb208) 
		.append("acb20d", this.acb20d) 
		.append("acb20e", this.acb20e) 
		.append("acb20l", this.acb20l) 
		.append("acb21q", this.acb21q) 
		.append("acb21t", this.acb21t) 
		.append("acb21g", this.acb21g) 
		.append("acb21f", this.acb21f) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae022", this.aae022) 
		.append("acb20c", this.acb20c) 
		.append("aab003", this.aab003) 
		.append("acc01g", this.acc01g) 
		.append("bcb21a", this.bcb21a) 
		.append("bcb21b", this.bcb21b) 
		.append("bcc01g", this.bcc01g) 
		.append("bac014", this.bac014) 
		.append("bcc039", this.bcc039) 
		.append("bcc038", this.bcc038) 
		.append("bcc20x", this.bcc20x) 
		.append("bcc02i", this.bcc02i) 
		.append("cbppcc", this.cbppcc) 
		.append("bcb202", this.bcb202) 
		.append("bcb203", this.bcb203) 
		.append("bcb204", this.bcb204) 
		.append("abb561", this.abb561) 
		.append("abb771", this.abb771) 
		.append("abb769", this.abb769) 
		.append("abb770", this.abb770) 
		.append("abb772", this.abb772) 
		.append("abb773", this.abb773) 
		.append("cca111", this.cca111) 
		.append("cca112", this.cca112) 
		.append("cca113", this.cca113) 
		.append("cca114", this.cca114) 
		.append("acb217", this.acb217) 
		.append("aac013", this.aac013) 
		.append("acb21h", this.acb21h) 
		.append("acb21i", this.acb21i) 
		.append("acb21k", this.acb21k) 
		.append("acb21c", this.acb21c) 
		.append("acb035", this.acb035) 
		.append("acb21d", this.acb21d) 
		.append("acb21e", this.acb21e) 
		.append("acb211", this.acb211) 
		.append("acb212", this.acb212) 
		.append("acb213", this.acb213) 
		.append("acb219", this.acb219) 
		.append("acb218", this.acb218) 
		.append("acb21a", this.acb21a) 
		.append("acb21b", this.acb21b) 
		.append("acb21l", this.acb21l) 
		.append("acb21m", this.acb21m) 
		.append("acb21n", this.acb21n) 
		.append("acb20b", this.acb20b) 
		.append("cczy06", this.cczy06) 
		.append("cczy07", this.cczy07) 
		.append("cczy08", this.cczy08) 
		.append("acb20q", this.acb20q) 
		.append("ccpr05", this.ccpr05) 
		.append("cczy09", this.cczy09) 
		.append("cczy10", this.cczy10) 
		.append("ccpr06", this.ccpr06) 
		.append("ccpr07", this.ccpr07) 
		.append("ccpr08", this.ccpr08) 
		.append("ccpr09", this.ccpr09) 
		.append("ccpr11", this.ccpr11) 
		.append("acb223", this.acb223) 
		.append("div001", this.div001) 
		.append("cca115", this.cca115) 
		.append("bcb210", this.bcb210) 
		.append("cca116", this.cca116) 
		.toString();
	}
   
  

}