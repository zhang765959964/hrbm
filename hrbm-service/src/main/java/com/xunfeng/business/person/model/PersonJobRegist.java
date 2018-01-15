package com.xunfeng.business.person.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 对象功能:个人求职登记表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:59:03
 */
public class PersonJobRegist extends BaseModel
{
	// 个人求职登记ID
	protected Long  acc200;
	// 个人编号
	protected Long  aac001;
	// 学历信息编号
	protected Long  aac0d0;
	// 工作经历编号
	protected Long  aac0b0;
	// 人员类别
	protected String  acc20t;
	// 人员类别名称
	protected String  acc20tName; 
	// 就业困难对象
	protected String  aac029;
	// 技能培训要求
	protected String  acc20d;
	// 食宿要求
	protected String  acb228;
	protected String  acb228n;
	// 求职区域
	protected String  bcb202;
	// 求职区域2
	protected String  bcb203;
	// 求职区域3
	protected String  bcb204;
	// 月工资
	protected String  acc034;
	// 月工资名称
	protected String  salay;
	// 报酬福利要求
	protected String  acc214;
	// 报酬福利要求名称
	protected String  acc214n;
	// 登记类别
	protected String  acc201;
	// 信息发布方式
	protected String  acc20q;
	// 登记日期
	protected java.util.Date  aae043;
	// 有效日期
	protected java.util.Date  ace014;
	// 工种代码1
	protected String  aca111;
	// 工种名称1
	protected String  aca112;
	// 形式工种代码1
	protected String  bca111;
	// 形式工种名称1
	protected String  bca112;
	// 工种代码2
	protected String  acaa11;
	// 工种名称2
	protected String  acaa12;
	// 形式工种代码2
	protected String  bcaa11;
	// 形式工种名称2
	protected String  bcaa12;
	// 工种代码3
	protected String  acab11;
	// 工种名称3
	protected String  acab12;
	// 形式工种代码3
	protected String  bcab11;
	// 形式工种名称3
	protected String  bcab12;
	// 冻结标记
	protected String  acb208;
	// 冻结人员
	protected String  acb20d;
	// 冻结日期
	protected java.util.Date  acb20e;
	// 冻结原因
	protected String  acc20l;
	// 推荐比例
	protected Long  acc21p;
	// 已推荐次数
	protected Long  acc21q;
	// 未反馈数
	protected Long  acc21f;
	// 已成功次数
	protected Long  acc21t;
	// 剩余推荐次数
	protected Long  acc21g;
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
	// 高级人才
	protected String  acc20p;
	// 历史未反馈校验
	protected String  acc20u;
	// 有效就业校验
	protected String  acc20y;
	// 就业失业登记证号码
	protected String  acc0m1;
	// 普通话水平
	protected String  bcc20x;
	// 是否定向报名
	protected String  bcc20a;
	// 结业院校
	protected String  aac045;
	// 毕业时间
	protected java.util.Date  aac046;
	// 所学专业代码
	protected String  acc01g;
	// 资格证书类型
	protected String  bcc02i;
	// 求职区域
	protected String  acb202;
	// 求职区域2
	protected String  acb203;
	// 求职区域3
	protected String  acb204;
	// 计算机水平TAB_CLEVEL
	protected String  aac038;
	//计算机水平name
	protected String aac038Name;
	// 英语水平TAB_fLEVEL
	protected String  aac039;
	// 工作要求
	protected String  bcc201;
	// 人员细类
	protected String  bcc20t;
	// 单位类型
	protected String  aab019;
	// 经济类型
	protected String  aab020;
	// 参加工作时间
	protected java.util.Date  aac007;
	// 所学专业名称
	protected String  bcc01g;
	// 专业技术职务
	protected String  bac014;
	// 掌握语言
	protected String  bcc038;
	// 匹配条件
	protected String  ccppcb;
	// 数据开放对象
	protected String  acb207;
	// 数据开放程度
	protected String  acb209;
	// 数据分类（用作登记方式1-个人求职添加2-达成意向添加3-劳务输出添加
	protected String  bcb207;
	// 数据来源
	protected String  bcb209;
	// 定向信息编号
	protected Long  acb210;
	// 定向单位及岗位
	protected String  aab004;
	// 输出组织编号
	protected Long  acb450;
	// 输出组织名称
	protected String  acb451;
	// 审核标识
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
	// 申请时间
	protected java.util.Date  acf271;
	// 高级人才申请状态
	protected String  acf272;
	// 是否已转高级人才
	protected String  acf273;
	// 信息保密
	protected String  bcc20b;
	// 意愿工种描述
	protected String  bcc20c;
	// 意愿2工种描述
	protected String  bcc20d;
	// 意愿3工种描述
	protected String  bcc20e;
	// 是否上岗
	protected String  bcc20f;
	// 上岗证名称 
	protected String  bcc20g;
	// 求职用工形式要求
	protected String  aac013;
	// 地区要求
	protected String  acc213;
	// 推荐次数
	protected Long  acc215;
	// 推荐情况
	protected String  acc223;
	// 求职成功日期
	protected java.util.Date  acc22c;
	// 录用单位编号
	protected Long  aab001;
	// 第二学历
	protected String  acc20i;
	// 第二外语
	protected String  aac041;
	// 第二外语熟练程度
	protected String  aac042;
	// 其它外语
	protected String  acc20e;
	// 从事本职业工种的时间
	protected String  aae162;
	// 下岗证号
	protected String  aac20c;
	// 再就业优惠证编号
	protected String  acc101;
	// 职业资格等级
	protected String  acc20g;
	// 联系人
	protected String  aae004;
	// 通讯地址
	protected String  aae006;
	// 原工作单位
	protected String  acc010;
	// 因何原因去过哪些国家
	protected String  acc206;
	// 是否境外求职
	protected String  acc207;
	// 是否4050人员
	protected String  acc02a;
	// 失业登记编号
	protected String  acc020;
	// 是否持有再就业优惠证
	protected String  acc03a;
	// 是否享受失业保险待遇
	protected String  acc20f;
	// 分配日期
	protected java.util.Date  acc20a;
	// 信息采集员
	protected String  acc20b;
	// 申请高级人才状态
	protected Long  ccpr01;
	// 被查看次数
	protected Long  ccpr02;
	// 刷新时间
	protected java.util.Date  ccpr03;
	// 推荐值
	protected Long  ccpr04;
	// 最后修改时间
	protected java.util.Date  ccpr05;
	// 修改人
	protected String  ccpr06;
	// 修改来源
	protected String  ccpr07;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 其他要求
	protected String  bae013;
	// 设备编号
	protected Long  div001;
	//性别
	protected String aac004;
	//户口性质
    protected String aac009;
    //户口性质code
    protected String aac009n;
    //婚姻情况
    protected String aac017;
    //政治面貌
    protected String aac024;
    //民族
    protected String aac005;
    //健康状况
    protected String aac033;
    protected String edu;
    //文化程度
    protected String aac011;
    //文化程度代码
    protected String aac011n;
	public String getAac011() {
		return aac011;
	}
    
	public String getAac011n() {
		return aac011n;
	}

	public void setAac011n(String aac011n) {
		this.aac011n = aac011n;
	}

	public void setAac011(String aac011) {
		this.aac011 = aac011;
	}

	public String getEdu() {
		return edu;
	}

	public String getAac009n() {
		return aac009n;
	}

	public void setAac009n(String aac009n) {
		this.aac009n = aac009n;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getAac004() {
		return aac004;
	}

	public void setAac004(String aac004) {
		this.aac004 = aac004;
	}

	public String getAac009() {
		return aac009;
	}

	public void setAac009(String aac009) {
		this.aac009 = aac009;
	}

	public String getAac017() {
		return aac017;
	}

	public void setAac017(String aac017) {
		this.aac017 = aac017;
	}

	public String getAac024() {
		return aac024;
	}

	public void setAac024(String aac024) {
		this.aac024 = aac024;
	}

	public String getAac005() {
		return aac005;
	}

	public void setAac005(String aac005) {
		this.aac005 = aac005;
	}

	public String getAac033() {
		return aac033;
	}

	public void setAac033(String aac033) {
		this.aac033 = aac033;
	}

	public void setAcc200(Long acc200) 
	{
		this.acc200 = acc200;
	}
	
	public String getSalay() {
		return salay;
	}

	public void setSalay(String salay) {
		this.salay = salay;
	}

	/**
	 * 返回 个人求职登记ID
	 * @return
	 */
	public Long getAcc200() 
	{
		return this.acc200;
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
	public void setAac0d0(Long aac0d0) 
	{
		this.aac0d0 = aac0d0;
	}
	/**
	 * 返回 学历信息编号
	 * @return
	 */
	public Long getAac0d0() 
	{
		return this.aac0d0;
	}
	public void setAac0b0(Long aac0b0) 
	{
		this.aac0b0 = aac0b0;
	}
	
	public String getAcc214n() {
		return acc214n;
	}
	public void setAcc214n(String acc214n) {
		this.acc214n = acc214n;
	}
	/**
	 * 返回 工作经历编号
	 * @return
	 */
	public Long getAac0b0() 
	{
		return this.aac0b0;
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
	public void setAcc20d(String acc20d) 
	{
		this.acc20d = acc20d;
	}
	/**
	 * 返回 技能培训要求
	 * @return
	 */
	public String getAcc20d() 
	{
		return this.acc20d;
	}
	public void setAcb228(String acb228) 
	{
		this.acb228 = acb228;
	}
	/**
	 * 返回 食宿要求
	 * @return
	 */
	public String getAcb228() 
	{
		return this.acb228;
	}
	public void setBcb202(String bcb202) 
	{
		this.bcb202 = bcb202;
	}
	/**
	 * 返回 求职区域
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
	 * 返回 求职区域2
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
	 * 返回 求职区域3
	 * @return
	 */
	public String getBcb204() 
	{
		return this.bcb204;
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
	public void setAcc201(String acc201) 
	{
		this.acc201 = acc201;
	}
	/**
	 * 返回 登记类别
	 * @return
	 */
	public String getAcc201() 
	{
		return this.acc201;
	}
	public void setAcc20q(String acc20q) 
	{
		this.acc20q = acc20q;
	}
	/**
	 * 返回 信息发布方式
	 * @return
	 */
	public String getAcc20q() 
	{
		return this.acc20q;
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
	public void setAce014(java.util.Date ace014) 
	{
		this.ace014 = ace014;
	}
	/**
	 * 返回 有效日期
	 * @return
	 */
	public java.util.Date getAce014() 
	{
		return this.ace014;
	}
	public void setAca111(String aca111) 
	{
		this.aca111 = aca111;
	}
	/**
	 * 返回 工种代码1
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
	 * 返回 工种名称1
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
	 * 返回 形式工种代码1
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
	 * 返回 形式工种名称1
	 * @return
	 */
	public String getBca112() 
	{
		return this.bca112;
	}
	public void setAcaa11(String acaa11) 
	{
		this.acaa11 = acaa11;
	}
	/**
	 * 返回 工种代码2
	 * @return
	 */
	public String getAcaa11() 
	{
		return this.acaa11;
	}
	public void setAcaa12(String acaa12) 
	{
		this.acaa12 = acaa12;
	}
	/**
	 * 返回 工种名称2
	 * @return
	 */
	public String getAcaa12() 
	{
		return this.acaa12;
	}
	public void setBcaa11(String bcaa11) 
	{
		this.bcaa11 = bcaa11;
	}
	/**
	 * 返回 形式工种代码2
	 * @return
	 */
	public String getBcaa11() 
	{
		return this.bcaa11;
	}
	public void setBcaa12(String bcaa12) 
	{
		this.bcaa12 = bcaa12;
	}
	/**
	 * 返回 形式工种名称2
	 * @return
	 */
	public String getBcaa12() 
	{
		return this.bcaa12;
	}
	public void setAcab11(String acab11) 
	{
		this.acab11 = acab11;
	}
	/**
	 * 返回 工种代码3
	 * @return
	 */
	public String getAcab11() 
	{
		return this.acab11;
	}
	public void setAcab12(String acab12) 
	{
		this.acab12 = acab12;
	}
	/**
	 * 返回 工种名称3
	 * @return
	 */
	public String getAcab12() 
	{
		return this.acab12;
	}
	public void setBcab11(String bcab11) 
	{
		this.bcab11 = bcab11;
	}
	/**
	 * 返回 形式工种代码3
	 * @return
	 */
	public String getBcab11() 
	{
		return this.bcab11;
	}
	public void setBcab12(String bcab12) 
	{
		this.bcab12 = bcab12;
	}
	/**
	 * 返回 形式工种名称3
	 * @return
	 */
	public String getBcab12() 
	{
		return this.bcab12;
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
	public void setAcc20l(String acc20l) 
	{
		this.acc20l = acc20l;
	}
	
	public String getAcb228n() {
		return acb228n;
	}

	public void setAcb228n(String acb228n) {
		this.acb228n = acb228n;
	}

	/**
	 * 返回 冻结原因
	 * @return
	 */
	public String getAcc20l() 
	{
		return this.acc20l;
	}
	public void setAcc21p(Long acc21p) 
	{
		this.acc21p = acc21p;
	}
	/**
	 * 返回 推荐比例
	 * @return
	 */
	public Long getAcc21p() 
	{
		return this.acc21p;
	}
	public void setAcc21q(Long acc21q) 
	{
		this.acc21q = acc21q;
	}
	/**
	 * 返回 已推荐次数
	 * @return
	 */
	public Long getAcc21q() 
	{
		return this.acc21q;
	}
	public void setAcc21f(Long acc21f) 
	{
		this.acc21f = acc21f;
	}
	/**
	 * 返回 未反馈数
	 * @return
	 */
	public Long getAcc21f() 
	{
		return this.acc21f;
	}
	public void setAcc21t(Long acc21t) 
	{
		this.acc21t = acc21t;
	}
	/**
	 * 返回 已成功次数
	 * @return
	 */
	public Long getAcc21t() 
	{
		return this.acc21t;
	}
	public void setAcc21g(Long acc21g) 
	{
		this.acc21g = acc21g;
	}
	/**
	 * 返回 剩余推荐次数
	 * @return
	 */
	public Long getAcc21g() 
	{
		return this.acc21g;
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
	public void setAcc20p(String acc20p) 
	{
		this.acc20p = acc20p;
	}
	/**
	 * 返回 高级人才
	 * @return
	 */
	public String getAcc20p() 
	{
		return this.acc20p;
	}
	public void setAcc20u(String acc20u) 
	{
		this.acc20u = acc20u;
	}
	/**
	 * 返回 历史未反馈校验
	 * @return
	 */
	public String getAcc20u() 
	{
		return this.acc20u;
	}
	public void setAcc20y(String acc20y) 
	{
		this.acc20y = acc20y;
	}
	/**
	 * 返回 有效就业校验
	 * @return
	 */
	public String getAcc20y() 
	{
		return this.acc20y;
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
	public void setBcc20a(String bcc20a) 
	{
		this.bcc20a = bcc20a;
	}
	/**
	 * 返回 是否定向报名
	 * @return
	 */
	public String getBcc20a() 
	{
		return this.bcc20a;
	}
	public void setAac045(String aac045) 
	{
		this.aac045 = aac045;
	}
	/**
	 * 返回 结业院校
	 * @return
	 */
	public String getAac045() 
	{
		return this.aac045;
	}
	public void setAac046(java.util.Date aac046) 
	{
		this.aac046 = aac046;
	}
	/**
	 * 返回 毕业时间
	 * @return
	 */
	public java.util.Date getAac046() 
	{
		return this.aac046;
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
	public void setAcb202(String acb202) 
	{
		this.acb202 = acb202;
	}
	/**
	 * 返回 求职区域
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
	 * 返回 求职区域2
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
	 * 返回 求职区域3
	 * @return
	 */
	public String getAcb204() 
	{
		return this.acb204;
	}
	public void setAac038(String aac038) 
	{
		this.aac038 = aac038;
	}
	/**
	 * 返回 计算机水平TAB_CLEVEL
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
	 * 返回 英语水平TAB_fLEVEL
	 * @return
	 */
	public String getAac039() 
	{
		return this.aac039;
	}
	public void setBcc201(String bcc201) 
	{
		this.bcc201 = bcc201;
	}
	/**
	 * 返回 工作要求
	 * @return
	 */
	public String getBcc201() 
	{
		return this.bcc201;
	}
	public void setBcc20t(String bcc20t) 
	{
		this.bcc20t = bcc20t;
	}
	/**
	 * 返回 人员细类
	 * @return
	 */
	public String getBcc20t() 
	{
		return this.bcc20t;
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
	public void setAac007(java.util.Date aac007) 
	{
		this.aac007 = aac007;
	}
	/**
	 * 返回 参加工作时间
	 * @return
	 */
	public java.util.Date getAac007() 
	{
		return this.aac007;
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
	 * 返回 专业技术职务
	 * @return
	 */
	public String getBac014() 
	{
		return this.bac014;
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
	public void setCcppcb(String ccppcb) 
	{
		this.ccppcb = ccppcb;
	}
	/**
	 * 返回 匹配条件
	 * @return
	 */
	public String getCcppcb() 
	{
		return this.ccppcb;
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
	public void setBcb207(String bcb207) 
	{
		this.bcb207 = bcb207;
	}
	/**
	 * 返回 数据分类（用作登记方式1-个人求职添加2-达成意向添加3-劳务输出添加
	 * @return
	 */
	public String getBcb207() 
	{
		return this.bcb207;
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
	public void setAcb210(Long acb210) 
	{
		this.acb210 = acb210;
	}
	/**
	 * 返回 定向信息编号
	 * @return
	 */
	public Long getAcb210() 
	{
		return this.acb210;
	}
	public void setAab004(String aab004) 
	{
		this.aab004 = aab004;
	}
	/**
	 * 返回 定向单位及岗位
	 * @return
	 */
	public String getAab004() 
	{
		return this.aab004;
	}
	public void setAcb450(Long acb450) 
	{
		this.acb450 = acb450;
	}
	/**
	 * 返回 输出组织编号
	 * @return
	 */
	public Long getAcb450() 
	{
		return this.acb450;
	}
	public void setAcb451(String acb451) 
	{
		this.acb451 = acb451;
	}
	/**
	 * 返回 输出组织名称
	 * @return
	 */
	public String getAcb451() 
	{
		return this.acb451;
	}
	public void setAbb561(String abb561) 
	{
		this.abb561 = abb561;
	}
	/**
	 * 返回 审核标识
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
	public void setAcf271(java.util.Date acf271) 
	{
		this.acf271 = acf271;
	}
	/**
	 * 返回 申请时间
	 * @return
	 */
	public java.util.Date getAcf271() 
	{
		return this.acf271;
	}
	public void setAcf272(String acf272) 
	{
		this.acf272 = acf272;
	}
	/**
	 * 返回 高级人才申请状态
	 * @return
	 */
	public String getAcf272() 
	{
		return this.acf272;
	}
	public void setAcf273(String acf273) 
	{
		this.acf273 = acf273;
	}
	/**
	 * 返回 是否已转高级人才
	 * @return
	 */
	public String getAcf273() 
	{
		return this.acf273;
	}
	public void setBcc20b(String bcc20b) 
	{
		this.bcc20b = bcc20b;
	}
	/**
	 * 返回 信息保密
	 * @return
	 */
	public String getBcc20b() 
	{
		return this.bcc20b;
	}
	public void setBcc20c(String bcc20c) 
	{
		this.bcc20c = bcc20c;
	}
	/**
	 * 返回 意愿工种描述
	 * @return
	 */
	public String getBcc20c() 
	{
		return this.bcc20c;
	}
	public void setBcc20d(String bcc20d) 
	{
		this.bcc20d = bcc20d;
	}
	/**
	 * 返回 意愿2工种描述
	 * @return
	 */
	public String getBcc20d() 
	{
		return this.bcc20d;
	}
	public void setBcc20e(String bcc20e) 
	{
		this.bcc20e = bcc20e;
	}
	/**
	 * 返回 意愿3工种描述
	 * @return
	 */
	public String getBcc20e() 
	{
		return this.bcc20e;
	}
	public void setBcc20f(String bcc20f) 
	{
		this.bcc20f = bcc20f;
	}
	/**
	 * 返回 是否上岗
	 * @return
	 */
	public String getBcc20f() 
	{
		return this.bcc20f;
	}
	public void setBcc20g(String bcc20g) 
	{
		this.bcc20g = bcc20g;
	}
	/**
	 * 返回 上岗证名称 
	 * @return
	 */
	public String getBcc20g() 
	{
		return this.bcc20g;
	}
	public void setAac013(String aac013) 
	{
		this.aac013 = aac013;
	}
	/**
	 * 返回 求职用工形式要求
	 * @return
	 */
	public String getAac013() 
	{
		return this.aac013;
	}
	public void setAcc213(String acc213) 
	{
		this.acc213 = acc213;
	}
	/**
	 * 返回 地区要求
	 * @return
	 */
	public String getAcc213() 
	{
		return this.acc213;
	}
	public void setAcc215(Long acc215) 
	{
		this.acc215 = acc215;
	}
	/**
	 * 返回 推荐次数
	 * @return
	 */
	public Long getAcc215() 
	{
		return this.acc215;
	}
	public void setAcc223(String acc223) 
	{
		this.acc223 = acc223;
	}
	/**
	 * 返回 推荐情况
	 * @return
	 */
	public String getAcc223() 
	{
		return this.acc223;
	}
	public void setAcc22c(java.util.Date acc22c) 
	{
		this.acc22c = acc22c;
	}
	/**
	 * 返回 求职成功日期
	 * @return
	 */
	public java.util.Date getAcc22c() 
	{
		return this.acc22c;
	}
	public void setAab001(Long aab001) 
	{
		this.aab001 = aab001;
	}
	/**
	 * 返回 录用单位编号
	 * @return
	 */
	public Long getAab001() 
	{
		return this.aab001;
	}
	public void setAcc20i(String acc20i) 
	{
		this.acc20i = acc20i;
	}
	/**
	 * 返回 第二学历
	 * @return
	 */
	public String getAcc20i() 
	{
		return this.acc20i;
	}
	public void setAac041(String aac041) 
	{
		this.aac041 = aac041;
	}
	/**
	 * 返回 第二外语
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
	 * 返回 第二外语熟练程度
	 * @return
	 */
	public String getAac042() 
	{
		return this.aac042;
	}
	public void setAcc20e(String acc20e) 
	{
		this.acc20e = acc20e;
	}
	/**
	 * 返回 其它外语
	 * @return
	 */
	public String getAcc20e() 
	{
		return this.acc20e;
	}
	public void setAae162(String aae162) 
	{
		this.aae162 = aae162;
	}
	/**
	 * 返回 从事本职业工种的时间

	 * @return
	 */
	public String getAae162() 
	{
		return this.aae162;
	}
	public void setAac20c(String aac20c) 
	{
		this.aac20c = aac20c;
	}
	/**
	 * 返回 下岗证号
	 * @return
	 */
	public String getAac20c() 
	{
		return this.aac20c;
	}
	public void setAcc101(String acc101) 
	{
		this.acc101 = acc101;
	}
	/**
	 * 返回 再就业优惠证编号
	 * @return
	 */
	public String getAcc101() 
	{
		return this.acc101;
	}
	public void setAcc20g(String acc20g) 
	{
		this.acc20g = acc20g;
	}
	/**
	 * 返回 职业资格等级
	 * @return
	 */
	public String getAcc20g() 
	{
		return this.acc20g;
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
	public void setAae006(String aae006) 
	{
		this.aae006 = aae006;
	}
	/**
	 * 返回 通讯地址
	 * @return
	 */
	public String getAae006() 
	{
		return this.aae006;
	}
	public void setAcc010(String acc010) 
	{
		this.acc010 = acc010;
	}
	/**
	 * 返回 原工作单位
	 * @return
	 */
	public String getAcc010() 
	{
		return this.acc010;
	}
	public void setAcc206(String acc206) 
	{
		this.acc206 = acc206;
	}
	
	public String getAcc20tName() {
		return acc20tName;
	}

	public void setAcc20tName(String acc20tName) {
		this.acc20tName = acc20tName;
	}

	/**
	 * 返回 因何原因去过哪些国家
	 * @return
	 */
	public String getAcc206() 
	{
		return this.acc206;
	}
	public void setAcc207(String acc207) 
	{
		this.acc207 = acc207;
	}
	/**
	 * 返回 是否境外求职
	 * @return
	 */
	public String getAcc207() 
	{
		return this.acc207;
	}
	public void setAcc02a(String acc02a) 
	{
		this.acc02a = acc02a;
	}
	/**
	 * 返回 是否4050人员
	 * @return
	 */
	public String getAcc02a() 
	{
		return this.acc02a;
	}
	public void setAcc020(String acc020) 
	{
		this.acc020 = acc020;
	}
	/**
	 * 返回 失业登记编号
	 * @return
	 */
	public String getAcc020() 
	{
		return this.acc020;
	}
	public void setAcc03a(String acc03a) 
	{
		this.acc03a = acc03a;
	}
	/**
	 * 返回 是否持有再就业优惠证
	 * @return
	 */
	public String getAcc03a() 
	{
		return this.acc03a;
	}
	public void setAcc20f(String acc20f) 
	{
		this.acc20f = acc20f;
	}
	/**
	 * 返回 是否享受失业保险待遇
	 * @return
	 */
	public String getAcc20f() 
	{
		return this.acc20f;
	}
	public void setAcc20a(java.util.Date acc20a) 
	{
		this.acc20a = acc20a;
	}
	public String getAac038Name() {
		return aac038Name;
	}

	public void setAac038Name(String aac038Name) {
		this.aac038Name = aac038Name;
	}

	/**
	 * 返回 分配日期
	 * @return
	 */
	public java.util.Date getAcc20a() 
	{
		return this.acc20a;
	}
	public void setAcc20b(String acc20b) 
	{
		this.acc20b = acc20b;
	}
	/**
	 * 返回 信息采集员
	 * @return
	 */
	public String getAcc20b() 
	{
		return this.acc20b;
	}
	public void setCcpr01(Long ccpr01) 
	{
		this.ccpr01 = ccpr01;
	}
	/**
	 * 返回 申请高级人才状态
	 * @return
	 */
	public Long getCcpr01() 
	{
		return this.ccpr01;
	}
	public void setCcpr02(Long ccpr02) 
	{
		this.ccpr02 = ccpr02;
	}
	/**
	 * 返回 被查看次数
	 * @return
	 */
	public Long getCcpr02() 
	{
		return this.ccpr02;
	}
	public void setCcpr03(java.util.Date ccpr03) 
	{
		this.ccpr03 = ccpr03;
	}
	/**
	 * 返回 刷新时间
	 * @return
	 */
	public java.util.Date getCcpr03() 
	{
		return this.ccpr03;
	}
	public void setCcpr04(Long ccpr04) 
	{
		this.ccpr04 = ccpr04;
	}
	/**
	 * 返回 推荐值
	 * @return
	 */
	public Long getCcpr04() 
	{
		return this.ccpr04;
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
	public void setBae013(String bae013) 
	{
		this.bae013 = bae013;
	}
	/**
	 * 返回 其他要求
	 * @return
	 */
	public String getBae013() 
	{
		return this.bae013;
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

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof PersonJobRegist))
		{
			return false;
		}
		PersonJobRegist rhs = (PersonJobRegist) object;
		return new EqualsBuilder()
		.append(this.acc200, rhs.acc200)
		.append(this.aac001, rhs.aac001)
		.append(this.aac0d0, rhs.aac0d0)
		.append(this.aac0b0, rhs.aac0b0)
		.append(this.acc20t, rhs.acc20t)
		.append(this.aac029, rhs.aac029)
		.append(this.acc20d, rhs.acc20d)
		.append(this.acb228, rhs.acb228)
		.append(this.bcb202, rhs.bcb202)
		.append(this.bcb203, rhs.bcb203)
		.append(this.bcb204, rhs.bcb204)
		.append(this.acc034, rhs.acc034)
		.append(this.acc214, rhs.acc214)
		.append(this.acc201, rhs.acc201)
		.append(this.acc20q, rhs.acc20q)
		.append(this.aae043, rhs.aae043)
		.append(this.ace014, rhs.ace014)
		.append(this.aca111, rhs.aca111)
		.append(this.aca112, rhs.aca112)
		.append(this.bca111, rhs.bca111)
		.append(this.bca112, rhs.bca112)
		.append(this.acaa11, rhs.acaa11)
		.append(this.acaa12, rhs.acaa12)
		.append(this.bcaa11, rhs.bcaa11)
		.append(this.bcaa12, rhs.bcaa12)
		.append(this.acab11, rhs.acab11)
		.append(this.acab12, rhs.acab12)
		.append(this.bcab11, rhs.bcab11)
		.append(this.bcab12, rhs.bcab12)
		.append(this.acb208, rhs.acb208)
		.append(this.acb20d, rhs.acb20d)
		.append(this.acb20e, rhs.acb20e)
		.append(this.acc20l, rhs.acc20l)
		.append(this.acc21p, rhs.acc21p)
		.append(this.acc21q, rhs.acc21q)
		.append(this.acc21f, rhs.acc21f)
		.append(this.acc21t, rhs.acc21t)
		.append(this.acc21g, rhs.acc21g)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae022, rhs.aae022)
		.append(this.acc20p, rhs.acc20p)
		.append(this.acc20u, rhs.acc20u)
		.append(this.acc20y, rhs.acc20y)
		.append(this.acc0m1, rhs.acc0m1)
		.append(this.bcc20x, rhs.bcc20x)
		.append(this.bcc20a, rhs.bcc20a)
		.append(this.aac045, rhs.aac045)
		.append(this.aac046, rhs.aac046)
		.append(this.acc01g, rhs.acc01g)
		.append(this.bcc02i, rhs.bcc02i)
		.append(this.acb202, rhs.acb202)
		.append(this.acb203, rhs.acb203)
		.append(this.acb204, rhs.acb204)
		.append(this.aac038, rhs.aac038)
		.append(this.aac039, rhs.aac039)
		.append(this.bcc201, rhs.bcc201)
		.append(this.bcc20t, rhs.bcc20t)
		.append(this.aab019, rhs.aab019)
		.append(this.aab020, rhs.aab020)
		.append(this.aac007, rhs.aac007)
		.append(this.bcc01g, rhs.bcc01g)
		.append(this.bac014, rhs.bac014)
		.append(this.bcc038, rhs.bcc038)
		.append(this.ccppcb, rhs.ccppcb)
		.append(this.acb207, rhs.acb207)
		.append(this.acb209, rhs.acb209)
		.append(this.bcb207, rhs.bcb207)
		.append(this.bcb209, rhs.bcb209)
		.append(this.acb210, rhs.acb210)
		.append(this.aab004, rhs.aab004)
		.append(this.acb450, rhs.acb450)
		.append(this.acb451, rhs.acb451)
		.append(this.abb561, rhs.abb561)
		.append(this.abb771, rhs.abb771)
		.append(this.abb769, rhs.abb769)
		.append(this.abb770, rhs.abb770)
		.append(this.abb772, rhs.abb772)
		.append(this.abb773, rhs.abb773)
		.append(this.acf271, rhs.acf271)
		.append(this.acf272, rhs.acf272)
		.append(this.acf273, rhs.acf273)
		.append(this.bcc20b, rhs.bcc20b)
		.append(this.bcc20c, rhs.bcc20c)
		.append(this.bcc20d, rhs.bcc20d)
		.append(this.bcc20e, rhs.bcc20e)
		.append(this.bcc20f, rhs.bcc20f)
		.append(this.bcc20g, rhs.bcc20g)
		.append(this.aac013, rhs.aac013)
		.append(this.acc213, rhs.acc213)
		.append(this.acc215, rhs.acc215)
		.append(this.acc223, rhs.acc223)
		.append(this.acc22c, rhs.acc22c)
		.append(this.aab001, rhs.aab001)
		.append(this.acc20i, rhs.acc20i)
		.append(this.aac041, rhs.aac041)
		.append(this.aac042, rhs.aac042)
		.append(this.acc20e, rhs.acc20e)
		.append(this.aae162, rhs.aae162)
		.append(this.aac20c, rhs.aac20c)
		.append(this.acc101, rhs.acc101)
		.append(this.acc20g, rhs.acc20g)
		.append(this.aae004, rhs.aae004)
		.append(this.aae006, rhs.aae006)
		.append(this.acc010, rhs.acc010)
		.append(this.acc206, rhs.acc206)
		.append(this.acc207, rhs.acc207)
		.append(this.acc02a, rhs.acc02a)
		.append(this.acc020, rhs.acc020)
		.append(this.acc03a, rhs.acc03a)
		.append(this.acc20f, rhs.acc20f)
		.append(this.acc20a, rhs.acc20a)
		.append(this.acc20b, rhs.acc20b)
		.append(this.ccpr01, rhs.ccpr01)
		.append(this.ccpr02, rhs.ccpr02)
		.append(this.ccpr03, rhs.ccpr03)
		.append(this.ccpr04, rhs.ccpr04)
		.append(this.ccpr05, rhs.ccpr05)
		.append(this.ccpr06, rhs.ccpr06)
		.append(this.ccpr07, rhs.ccpr07)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.bae013, rhs.bae013)
		.append(this.div001, rhs.div001)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.acc200)
		.append(this.aac001)
		.append(this.aac0d0)
		.append(this.aac0b0)
		.append(this.acc20t)
		.append(this.aac029)
		.append(this.acc20d)
		.append(this.acb228)
		.append(this.bcb202)
		.append(this.bcb203)
		.append(this.bcb204)
		.append(this.acc034)
		.append(this.acc214)
		.append(this.acc201)
		.append(this.acc20q)
		.append(this.aae043)
		.append(this.ace014)
		.append(this.aca111)
		.append(this.aca112)
		.append(this.bca111)
		.append(this.bca112)
		.append(this.acaa11)
		.append(this.acaa12)
		.append(this.bcaa11)
		.append(this.bcaa12)
		.append(this.acab11)
		.append(this.acab12)
		.append(this.bcab11)
		.append(this.bcab12)
		.append(this.acb208)
		.append(this.acb20d)
		.append(this.acb20e)
		.append(this.acc20l)
		.append(this.acc21p)
		.append(this.acc21q)
		.append(this.acc21f)
		.append(this.acc21t)
		.append(this.acc21g)
		.append(this.aae013)
		.append(this.aae011)
		.append(this.aae017)
		.append(this.aae036)
		.append(this.aae019)
		.append(this.aae020)
		.append(this.aae022)
		.append(this.acc20p)
		.append(this.acc20u)
		.append(this.acc20y)
		.append(this.acc0m1)
		.append(this.bcc20x)
		.append(this.bcc20a)
		.append(this.aac045)
		.append(this.aac046)
		.append(this.acc01g)
		.append(this.bcc02i)
		.append(this.acb202)
		.append(this.acb203)
		.append(this.acb204)
		.append(this.aac038)
		.append(this.aac039)
		.append(this.bcc201)
		.append(this.bcc20t)
		.append(this.aab019)
		.append(this.aab020)
		.append(this.aac007)
		.append(this.bcc01g)
		.append(this.bac014)
		.append(this.bcc038)
		.append(this.ccppcb)
		.append(this.acb207)
		.append(this.acb209)
		.append(this.bcb207)
		.append(this.bcb209)
		.append(this.acb210)
		.append(this.aab004)
		.append(this.acb450)
		.append(this.acb451)
		.append(this.abb561)
		.append(this.abb771)
		.append(this.abb769)
		.append(this.abb770)
		.append(this.abb772)
		.append(this.abb773)
		.append(this.acf271)
		.append(this.acf272)
		.append(this.acf273)
		.append(this.bcc20b)
		.append(this.bcc20c)
		.append(this.bcc20d)
		.append(this.bcc20e)
		.append(this.bcc20f)
		.append(this.bcc20g)
		.append(this.aac013)
		.append(this.acc213)
		.append(this.acc215)
		.append(this.acc223)
		.append(this.acc22c)
		.append(this.aab001)
		.append(this.acc20i)
		.append(this.aac041)
		.append(this.aac042)
		.append(this.acc20e)
		.append(this.aae162)
		.append(this.aac20c)
		.append(this.acc101)
		.append(this.acc20g)
		.append(this.aae004)
		.append(this.aae006)
		.append(this.acc010)
		.append(this.acc206)
		.append(this.acc207)
		.append(this.acc02a)
		.append(this.acc020)
		.append(this.acc03a)
		.append(this.acc20f)
		.append(this.acc20a)
		.append(this.acc20b)
		.append(this.ccpr01)
		.append(this.ccpr02)
		.append(this.ccpr03)
		.append(this.ccpr04)
		.append(this.ccpr05)
		.append(this.ccpr06)
		.append(this.ccpr07)
		.append(this.ccpr08)
		.append(this.bae013)
		.append(this.div001)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("acc200", this.acc200) 
		.append("aac001", this.aac001) 
		.append("aac0d0", this.aac0d0) 
		.append("aac0b0", this.aac0b0) 
		.append("acc20t", this.acc20t) 
		.append("aac029", this.aac029) 
		.append("acc20d", this.acc20d) 
		.append("acb228", this.acb228) 
		.append("bcb202", this.bcb202) 
		.append("bcb203", this.bcb203) 
		.append("bcb204", this.bcb204) 
		.append("acc034", this.acc034) 
		.append("acc214", this.acc214) 
		.append("acc201", this.acc201) 
		.append("acc20q", this.acc20q) 
		.append("aae043", this.aae043) 
		.append("ace014", this.ace014) 
		.append("aca111", this.aca111) 
		.append("aca112", this.aca112) 
		.append("bca111", this.bca111) 
		.append("bca112", this.bca112) 
		.append("acaa11", this.acaa11) 
		.append("acaa12", this.acaa12) 
		.append("bcaa11", this.bcaa11) 
		.append("bcaa12", this.bcaa12) 
		.append("acab11", this.acab11) 
		.append("acab12", this.acab12) 
		.append("bcab11", this.bcab11) 
		.append("bcab12", this.bcab12) 
		.append("acb208", this.acb208) 
		.append("acb20d", this.acb20d) 
		.append("acb20e", this.acb20e) 
		.append("acc20l", this.acc20l) 
		.append("acc21p", this.acc21p) 
		.append("acc21q", this.acc21q) 
		.append("acc21f", this.acc21f) 
		.append("acc21t", this.acc21t) 
		.append("acc21g", this.acc21g) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae022", this.aae022) 
		.append("acc20p", this.acc20p) 
		.append("acc20u", this.acc20u) 
		.append("acc20y", this.acc20y) 
		.append("acc0m1", this.acc0m1) 
		.append("bcc20x", this.bcc20x) 
		.append("bcc20a", this.bcc20a) 
		.append("aac045", this.aac045) 
		.append("aac046", this.aac046) 
		.append("acc01g", this.acc01g) 
		.append("bcc02i", this.bcc02i) 
		.append("acb202", this.acb202) 
		.append("acb203", this.acb203) 
		.append("acb204", this.acb204) 
		.append("aac038", this.aac038) 
		.append("aac039", this.aac039) 
		.append("bcc201", this.bcc201) 
		.append("bcc20t", this.bcc20t) 
		.append("aab019", this.aab019) 
		.append("aab020", this.aab020) 
		.append("aac007", this.aac007) 
		.append("bcc01g", this.bcc01g) 
		.append("bac014", this.bac014) 
		.append("bcc038", this.bcc038) 
		.append("ccppcb", this.ccppcb) 
		.append("acb207", this.acb207) 
		.append("acb209", this.acb209) 
		.append("bcb207", this.bcb207) 
		.append("bcb209", this.bcb209) 
		.append("acb210", this.acb210) 
		.append("aab004", this.aab004) 
		.append("acb450", this.acb450) 
		.append("acb451", this.acb451) 
		.append("abb561", this.abb561) 
		.append("abb771", this.abb771) 
		.append("abb769", this.abb769) 
		.append("abb770", this.abb770) 
		.append("abb772", this.abb772) 
		.append("abb773", this.abb773) 
		.append("acf271", this.acf271) 
		.append("acf272", this.acf272) 
		.append("acf273", this.acf273) 
		.append("bcc20b", this.bcc20b) 
		.append("bcc20c", this.bcc20c) 
		.append("bcc20d", this.bcc20d) 
		.append("bcc20e", this.bcc20e) 
		.append("bcc20f", this.bcc20f) 
		.append("bcc20g", this.bcc20g) 
		.append("aac013", this.aac013) 
		.append("acc213", this.acc213) 
		.append("acc215", this.acc215) 
		.append("acc223", this.acc223) 
		.append("acc22c", this.acc22c) 
		.append("aab001", this.aab001) 
		.append("acc20i", this.acc20i) 
		.append("aac041", this.aac041) 
		.append("aac042", this.aac042) 
		.append("acc20e", this.acc20e) 
		.append("aae162", this.aae162) 
		.append("aac20c", this.aac20c) 
		.append("acc101", this.acc101) 
		.append("acc20g", this.acc20g) 
		.append("aae004", this.aae004) 
		.append("aae006", this.aae006) 
		.append("acc010", this.acc010) 
		.append("acc206", this.acc206) 
		.append("acc207", this.acc207) 
		.append("acc02a", this.acc02a) 
		.append("acc020", this.acc020) 
		.append("acc03a", this.acc03a) 
		.append("acc20f", this.acc20f) 
		.append("acc20a", this.acc20a) 
		.append("acc20b", this.acc20b) 
		.append("ccpr01", this.ccpr01) 
		.append("ccpr02", this.ccpr02) 
		.append("ccpr03", this.ccpr03) 
		.append("ccpr04", this.ccpr04) 
		.append("ccpr05", this.ccpr05) 
		.append("ccpr06", this.ccpr06) 
		.append("ccpr07", this.ccpr07) 
		.append("ccpr08", this.ccpr08) 
		.append("bae013", this.bae013) 
		.append("div001", this.div001) 
		.toString();
	}
   
  

}