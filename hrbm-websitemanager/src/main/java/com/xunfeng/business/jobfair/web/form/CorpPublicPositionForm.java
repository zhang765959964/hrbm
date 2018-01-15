package com.xunfeng.business.jobfair.web.form;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.business.corp.model.CorpPositionPublish;
import com.xunfeng.core.model.BaseForm;

/**
 * 单位招聘信息表
 *
 * @author Administrator
 *
 */
public class CorpPublicPositionForm extends BaseForm<CorpPositionPublish> {
	// 招聘登记号
	protected Long acb200;
	// 单位编号
	protected Long aab001;
	// // 组织机构代码
	// protected String aab003;
	// 单位名称
	protected String aab004;
	// 隶属关系
	// protected String aab021;
	// 所属行业
	// protected String aab022;
	// 产业类别
	// protected String aab054;
	// 单位性质
	// protected String aab019;
	// 经济类型
	// protected String aab020;
	// 主管部门
	// protected String aab023;
	// 所属地区行政区划代码
	// protected String aab301;
	// 行政区划名称
	// protected String aaa021;
	// 人员规模
	// protected String aab056;
	// 单位简介
	protected String acb206;
	// 地址
	protected String aae006;
	// 联系人
	protected String aae004;
	// 联系电话
	protected String aae005;
	// 联系人手机号码
	protected String aae139;
	// 电子信箱
	// protected String aae015;
	// 传真
	// protected String aae014;
	// 网址
	// protected String aae016;
	// 招聘套餐
	// 登记日期
	// protected java.util.Date aae043=new Date();
	// 冻结标记
	// 备注
	// protected String aae013;
	// 经办人代码
	// 经办机构代码
	// 经办日期
	// 经办人
	// 经办机构
	// 机构行政区划代码
	// protected String aae022;
	// 信息员编号
	// protected Long acc2b0;
	// 是否会员单位
	// protected String acb20g="0";
	// 猎头单位检验
	// protected String acb20p;
	// 历史未反馈校验
	// protected String acb20u;
	// 违规记录校验
	// protected String acb20y;
	// 信息发布方式
	// protected String acb20q;
	// 定向单位编号
	// protected String acb400;
	// 是否定向单位
	// protected String bcb20a;
	// 会员编号
	// protected Long acb260;
	// 会员号
	// protected String acb261;
	// 证件的有效期
	// protected java.util.Date aab011;
	// 证件的年检期
	// protected java.util.Date cab011;
	// 单位证件类型
	// protected String bae018;
	// 乘车路线
	protected String acb205;
	// 会员级别
	// protected String acb262;
	// 原费用
	// protected Float bcb20b=0f;
	// 应收费用
	// protected Float bcb20d=0f;
	// 费用状态
	// protected String bcb20e;
	// 发布名称
	protected String bab004;
	// 数据开放程度
	// protected String acb209;
	// 数据来源
	// protected String bcb209;
	// 数据开放对象
	// protected String acb207;
	// 数据分类
	// protected String bcb207;
	// 享受折扣
	// protected Float acb263;
	// 招聘套餐
	// protected String bcb201;
	// 审核标记
	// protected String abb561;
	// 审核时间
	// protected java.util.Date abb771;
	// 审核人
	// protected String abb769;
	// 审核机构
	// protected String abb770;
	// 审核意见
	// protected String abb772;
	// 审核标记
	// protected String abb773;
	// 套餐编号
	// protected Long ace230;
	// 招聘地点
	// protected String acb202;
	// 招聘地区
	// protected String acb203;
	// 用工形式
	// protected String aac013;
	// 工作地点
	// protected String acb204;
	// 公民身份证号码
	protected String aac002;
	// 面试地点
	protected String acb20c;
	// 面试详细说明
	protected String acb20f;
	// 冻结人员
	// protected String acb20d;
	// 冻结日期
	// protected java.util.Date acb20e;
	// 招聘信息采集员
	// protected String acb20b;
	// 开始日期
	protected java.util.Date aae030;
	// 终止日期
	protected java.util.Date aae031;

	// 是否在网站上显示(0-不显示1-显示)
	// protected Long cccj01=1l;
	// 浏览次数
	// protected Long cccj02=1l;
	// 刷新时间
	// protected java.util.Date cccj03=new Date();
	// 推荐值
	// protected Long cccj04=0l;
	// 是否在四六级显示(0-不显示1-显示)
	// protected Long cccj05=0l;
	// 是否在大屏幕显示(0-不显示1-显示)
	// protected Long cccj06=0l;
	// 是否在社区显示(0-不显示1-显示)
	// protected Long cccj07=0l;
	// 是否允许其它职介查看(0-不允许1-允许)
	// protected Long cccj08=0l;
	// 是否允许职介中心查看(0-不允许1-允许)
	// protected Long cccj09=0l;
	// 最后修改时间
	// 修改人
	// 修改来源
	// 是否删除状态（0-否1-是）
	// 自建行业代码
	// protected String ccpr10;
	// 委托标记1-非委托2-会后转委托
	// protected Long ccpr11=1l;
	// 卡SN号
	// protected String cahy12;
	// 设备编号
	// protected Long div001;
	// 橱窗摊位有效月份
	// protected Long acb20m=0l;
	// 橱窗摊位预定编号
	// protected Long cczf01;
	// 招聘会要求
	// protected String acb20n;

	// 不需要映射到数据库
	// protected Long acb330;

	public void setAcb200(Long acb200) {
		this.acb200 = acb200;
	}

	/**
	 * 返回 招聘登记号
	 * 
	 * @return
	 */
	public Long getAcb200() {
		return this.acb200;
	}

	public void setAab001(Long aab001) {
		this.aab001 = aab001;
	}

	/**
	 * 返回 单位编号
	 * 
	 * @return
	 */
	public Long getAab001() {
		return this.aab001;
	}

	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}

	/**
	 * 返回 单位名称
	 * 
	 * @return
	 */
	public String getAab004() {
		return this.aab004;
	}

	public void setAcb206(String acb206) {
		this.acb206 = acb206;
	}

	/**
	 * 返回 单位简介
	 * 
	 * @return
	 */
	public String getAcb206() {
		return this.acb206;
	}

	public void setAae006(String aae006) {
		this.aae006 = aae006;
	}

	/**
	 * 返回 地址
	 * 
	 * @return
	 */
	public String getAae006() {
		return this.aae006;
	}

	public void setAae004(String aae004) {
		this.aae004 = aae004;
	}

	/**
	 * 返回 联系人
	 * 
	 * @return
	 */
	public String getAae004() {
		return this.aae004;
	}

	public void setAae005(String aae005) {
		this.aae005 = aae005;
	}

	/**
	 * 返回 联系电话
	 * 
	 * @return
	 */
	public String getAae005() {
		return this.aae005;
	}

	public void setAae139(String aae139) {
		this.aae139 = aae139;
	}

	/**
	 * 返回 联系人手机号码
	 * 
	 * @return
	 */
	public String getAae139() {
		return this.aae139;
	}

	public String getAcb205() {
		return acb205;
	}

	public void setAcb205(String acb205) {
		this.acb205 = acb205;
	}

	public String getBab004() {
		return bab004;
	}

	public void setBab004(String bab004) {
		this.bab004 = bab004;
	}

	public String getAac002() {
		return aac002;
	}

	public void setAac002(String aac002) {
		this.aac002 = aac002;
	}

	public String getAcb20c() {
		return acb20c;
	}

	public void setAcb20c(String acb20c) {
		this.acb20c = acb20c;
	}

	public String getAcb20f() {
		return acb20f;
	}

	public void setAcb20f(String acb20f) {
		this.acb20f = acb20f;
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

	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof CorpPublicPositionForm)) {
			return false;
		}
		CorpPublicPositionForm rhs = (CorpPublicPositionForm) object;
		return new EqualsBuilder().append(this.acb200, rhs.acb200)
				.append(this.aab001, rhs.aab001)
				.append(this.aab004, rhs.aab004)
				.append(this.acb206, rhs.acb206)
				.append(this.aae006, rhs.aae006)
				.append(this.aae004, rhs.aae004)
				.append(this.aae005, rhs.aae005)
				.append(this.aae139, rhs.aae139)
				.append(this.acb205, rhs.acb205)
				.append(this.bab004, rhs.bab004)
				.append(this.aac002, rhs.aac002)
				.append(this.acb20c, rhs.acb20c)
				.append(this.acb20f, rhs.acb20f)
				.append(this.aae030, rhs.aae030)
				.append(this.aae031, rhs.aae031).isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973).append(this.acb200)
				.append(this.aab001).append(this.aab004).append(this.acb206)
				.append(this.aae006).append(this.aae004).append(this.aae005)
				.append(this.aae139).append(this.acb205).append(this.bab004)
				.append(this.aac002).append(this.acb20c).append(this.acb20f)
				.append(this.aae030).append(this.aae031).toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("acb200", this.acb200)
				.append("aab001", this.aab001).append("aab004", this.aab004)
				.append("acb206", this.acb206).append("aae006", this.aae006)
				.append("aae004", this.aae004).append("aae005", this.aae005)
				.append("aae139", this.aae139).append("acb205", this.acb205)
				.append("bab004", this.bab004).append("aac002", this.aac002)
				.append("acb20c", this.acb20c).append("acb20f", this.acb20f)
				.append("aae030", this.aae030).append("aae031", this.aae031)
				.toString();
	}

}