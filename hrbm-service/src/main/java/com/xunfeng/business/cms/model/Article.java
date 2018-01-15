package com.xunfeng.business.cms.model;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
/**
 * 对象功能:新闻内容表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-08 10:08:39
 */
public class Article extends BaseModel
{
	// 新闻内容自动编号
	protected Long  cand01;
	// 类别编号
	protected Long  canc01;
	// 标题
	protected String  cand03;
	// 内容
	protected String  cand04;
	// 新闻模式(1正常显示2-外部链接)
	protected Long  cand05;
	// 外部链接地址
	protected String  cand06;
	// 创建时间
	protected java.util.Date  cand07;
	// 发布人编号
	protected Long  ccmu01;
	// 新闻状态(1-正常2-隐藏4-删除)
	protected Long  cand09;
	// 排序
	protected Long  cand10;
	// 新闻图片地址
	protected String  cand11;
	// 是否显示标题图片(0-不显示1-显示)
	protected Long  cand12;
	// 浏览次数
	protected Long  cand13;
	// 新闻描述
	protected String  cand14;
	// 关键字
	protected String  cand15;
	// 是否推荐新闻0-否1-是
	protected Long  cand16;
	// 是否置顶新闻0-否1-是
	protected Long  cand17=0L;
	// 信息发布方式0-通用1-中部就业网2-民营职介
	protected Long  cand18;
	protected String cand19;
	
	protected String  cand20;

	protected String  cand21;

	public String getCand19() {
		return cand19;
	}

	public void setCand19(String cand19) {
		this.cand19 = cand19;
	}
	

	public void setCand01(Long cand01)
	{
		this.cand01 = cand01;
	}
	/**
	 * 返回 新闻内容自动编号
	 * @return
	 */
	public Long getCand01() 
	{
		return this.cand01;
	}
	public void setCanc01(Long canc01) 
	{
		this.canc01 = canc01;
	}
	/**
	 * 返回 类别编号
	 * @return
	 */
	public Long getCanc01() 
	{
		return this.canc01;
	}
	public void setCand03(String cand03) 
	{
		this.cand03 = cand03;
	}
	/**
	 * 返回 标题
	 * @return
	 */
	public String getCand03() 
	{
		return this.cand03;
	}
	public void setCand04(String cand04) 
	{
		this.cand04 = cand04;
	}
	/**
	 * 返回 内容
	 * @return
	 */
	public String getCand04() 
	{
		return this.cand04;
	}
	public void setCand05(Long cand05) 
	{
		this.cand05 = cand05;
	}
	/**
	 * 返回 新闻模式(1正常显示2-外部链接)
	 * @return
	 */
	public Long getCand05() 
	{
		return this.cand05;
	}
	public void setCand06(String cand06) 
	{
		this.cand06 = cand06;
	}
	/**
	 * 返回 外部链接地址
	 * @return
	 */
	public String getCand06() 
	{
		return this.cand06;
	}
	public void setCand07(java.util.Date cand07) 
	{
		this.cand07 = cand07;
	}
	/**
	 * 返回 创建时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getCand07() 
	{
		return this.cand07;
	}
	public void setCcmu01(Long ccmu01) 
	{
		this.ccmu01 = ccmu01;
	}
	/**
	 * 返回 发布人编号
	 * @return
	 */
	public Long getCcmu01() 
	{
		return this.ccmu01;
	}
	public void setCand09(Long cand09) 
	{
		this.cand09 = cand09;
	}
	/**
	 * 返回 新闻状态(1-正常2-隐藏4-删除)
	 * @return
	 */
	public Long getCand09() 
	{
		return this.cand09;
	}
	public void setCand10(Long cand10) 
	{
		this.cand10 = cand10;
	}
	/**
	 * 返回 排序
	 * @return
	 */
	public Long getCand10() 
	{
		return this.cand10;
	}
	public void setCand11(String cand11) 
	{
		this.cand11 = cand11;
	}
	/**
	 * 返回 新闻图片地址
	 * @return
	 */
	public String getCand11() 
	{
		return this.cand11;
	}
	public void setCand12(Long cand12) 
	{
		this.cand12 = cand12;
	}
	/**
	 * 返回 是否显示标题图片(0-不显示1-显示)
	 * @return
	 */
	public Long getCand12() 
	{
		return this.cand12;
	}
	public void setCand13(Long cand13) 
	{
		this.cand13 = cand13;
	}
	/**
	 * 返回 浏览次数
	 * @return
	 */
	public Long getCand13() 
	{
		return this.cand13;
	}
	public void setCand14(String cand14) 
	{
		this.cand14 = cand14;
	}
	/**
	 * 返回 新闻描述
	 * @return
	 */
	public String getCand14() 
	{
		return this.cand14;
	}
	public void setCand15(String cand15) 
	{
		this.cand15 = cand15;
	}
	/**
	 * 返回 关键字
	 * @return
	 */
	public String getCand15() 
	{
		return this.cand15;
	}
	public void setCand16(Long cand16) 
	{
		this.cand16 = cand16;
	}
	/**
	 * 返回 是否推荐新闻0-否1-是
	 * @return
	 */
	public Long getCand16() 
	{
		return this.cand16;
	}
	public void setCand17(Long cand17) 
	{
		this.cand17 = cand17;
	}
	/**
	 * 返回 是否置顶新闻0-否1-是
	 * @return
	 */
	public Long getCand17() 
	{
		return this.cand17;
	}
	public void setCand18(Long cand18) 
	{
		this.cand18 = cand18;
	}
	/**
	 * 返回 信息发布方式0-通用1-中部就业网2-民营职介
	 * @return
	 */
	public Long getCand18() 
	{
		return this.cand18;
	}
	public void setCand20(String cand20) 
	{
		this.cand20 = cand20;
	}
	/**
	 * 返回 类别路径
	 * @return
	 */
	public String getCand20() 
	{
		return this.cand20;
	}

	public String getCand21() {
		return cand21;
	}

	public void setCand21(String cand21) {
		this.cand21 = cand21;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof Article)) 
		{
			return false;
		}
		Article rhs = (Article) object;
		return new EqualsBuilder()
		.append(this.cand01, rhs.cand01)
		.append(this.canc01, rhs.canc01)
		.append(this.cand03, rhs.cand03)
		.append(this.cand04, rhs.cand04)
		.append(this.cand05, rhs.cand05)
		.append(this.cand06, rhs.cand06)
		.append(this.cand07, rhs.cand07)
		.append(this.ccmu01, rhs.ccmu01)
		.append(this.cand09, rhs.cand09)
		.append(this.cand10, rhs.cand10)
		.append(this.cand11, rhs.cand11)
		.append(this.cand12, rhs.cand12)
		.append(this.cand13, rhs.cand13)
		.append(this.cand14, rhs.cand14)
		.append(this.cand15, rhs.cand15)
		.append(this.cand16, rhs.cand16)
		.append(this.cand17, rhs.cand17)
		.append(this.cand18, rhs.cand18)
		.append(this.cand19, rhs.cand19)
		.append(this.cand20, rhs.cand20)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.cand01) 
		.append(this.canc01) 
		.append(this.cand03) 
		.append(this.cand04) 
		.append(this.cand05) 
		.append(this.cand06) 
		.append(this.cand07) 
		.append(this.ccmu01) 
		.append(this.cand09) 
		.append(this.cand10) 
		.append(this.cand11) 
		.append(this.cand12) 
		.append(this.cand13) 
		.append(this.cand14) 
		.append(this.cand15) 
		.append(this.cand16) 
		.append(this.cand17) 
		.append(this.cand18) 
		.append(this.cand19) 
		.append(this.cand20) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("cand01", this.cand01) 
		.append("canc01", this.canc01) 
		.append("cand03", this.cand03) 
		.append("cand04", this.cand04) 
		.append("cand05", this.cand05) 
		.append("cand06", this.cand06) 
		.append("cand07", this.cand07) 
		.append("ccmu01", this.ccmu01) 
		.append("cand09", this.cand09) 
		.append("cand10", this.cand10) 
		.append("cand11", this.cand11) 
		.append("cand12", this.cand12) 
		.append("cand13", this.cand13) 
		.append("cand14", this.cand14) 
		.append("cand15", this.cand15) 
		.append("cand16", this.cand16) 
		.append("cand17", this.cand17) 
		.append("cand18", this.cand18) 
		.append("cand19", this.cand19) 
		.append("cand20", this.cand20) 
		.toString();
	}
   
  

}