package com.xunfeng.business.cms.web.form;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.business.cms.model.ArticleColumn;
import com.xunfeng.core.model.BaseForm;
/**
 * 对象功能:新闻类别表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-08 10:08:15
 */
public class ArticleColumnForm extends BaseForm<ArticleColumn>
{
	// 新闻类别自动编号
	protected Long  canc01;
	// 父类编号
	protected Long  canc02;
	
	protected String  parentColName;
	// 类别名称
	protected String  canc03;
	// 模板路径
	protected String  canc04;
	// 内容页模板路径
	protected String  canc05;
	// 类别标题
	protected String  canc06;
	// 类别关键字
	protected String  canc07;
	// 类别描述
	protected String  canc08;
	// 是否频道页(0-否1-是)
	protected Long  canc09;
	// 所用域
	protected Long  canc10;
	// 类别别名
	protected String  canc11;

	// 排序号
	protected Long  canc13;
	public void setCanc01(Long canc01) 
	{
		this.canc01 = canc01;
	}
	/**
	 * 返回 新闻类别自动编号
	 * @return
	 */
	public Long getCanc01() 
	{
		return this.canc01;
	}
	public void setCanc02(Long canc02) 
	{
		this.canc02 = canc02;
	}
	/**
	 * 返回 父类编号
	 * @return
	 */
	public Long getCanc02() 
	{
		return this.canc02;
	}
	public void setCanc03(String canc03) 
	{
		this.canc03 = canc03;
	}
	/**
	 * 返回 类别名称
	 * @return
	 */
	public String getCanc03() 
	{
		return this.canc03;
	}
	public void setCanc04(String canc04) 
	{
		this.canc04 = canc04;
	}
	/**
	 * 返回 模板路径
	 * @return
	 */
	public String getCanc04() 
	{
		return this.canc04;
	}
	public void setCanc05(String canc05) 
	{
		this.canc05 = canc05;
	}
	/**
	 * 返回 内容页模板路径
	 * @return
	 */
	public String getCanc05() 
	{
		return this.canc05;
	}
	public void setCanc06(String canc06) 
	{
		this.canc06 = canc06;
	}
	/**
	 * 返回 类别标题
	 * @return
	 */
	public String getCanc06() 
	{
		return this.canc06;
	}
	public void setCanc07(String canc07) 
	{
		this.canc07 = canc07;
	}
	/**
	 * 返回 类别关键字
	 * @return
	 */
	public String getCanc07() 
	{
		return this.canc07;
	}
	public void setCanc08(String canc08) 
	{
		this.canc08 = canc08;
	}
	/**
	 * 返回 类别描述
	 * @return
	 */
	public String getCanc08() 
	{
		return this.canc08;
	}
	public void setCanc09(Long canc09) 
	{
		this.canc09 = canc09;
	}
	/**
	 * 返回 是否频道页(0-否1-是)
	 * @return
	 */
	public Long getCanc09() 
	{
		return this.canc09;
	}
	public void setCanc10(Long canc10) 
	{
		this.canc10 = canc10;
	}
	/**
	 * 返回 所用域
	 * @return
	 */
	public Long getCanc10() 
	{
		return this.canc10;
	}
	public void setCanc11(String canc11) 
	{
		this.canc11 = canc11;
	}
	/**
	 * 返回 类别别名
	 * @return
	 */
	public String getCanc11() 
	{
		return this.canc11;
	}

	public void setCanc13(Long canc13) 
	{
		this.canc13 = canc13;
	}
	/**
	 * 返回 排序号
	 * @return
	 */
	public Long getCanc13() 
	{
		return this.canc13;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ArticleColumnForm)) 
		{
			return false;
		}
		ArticleColumnForm rhs = (ArticleColumnForm) object;
		return new EqualsBuilder()
		.append(this.canc01, rhs.canc01)
		.append(this.canc02, rhs.canc02)
		.append(this.canc03, rhs.canc03)
		.append(this.canc04, rhs.canc04)
		.append(this.canc05, rhs.canc05)
		.append(this.canc06, rhs.canc06)
		.append(this.canc07, rhs.canc07)
		.append(this.canc08, rhs.canc08)
		.append(this.canc09, rhs.canc09)
		.append(this.canc10, rhs.canc10)
		.append(this.canc11, rhs.canc11)
		.append(this.canc13, rhs.canc13)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.canc01) 
		.append(this.canc02) 
		.append(this.canc03) 
		.append(this.canc04) 
		.append(this.canc05) 
		.append(this.canc06) 
		.append(this.canc07) 
		.append(this.canc08) 
		.append(this.canc09) 
		.append(this.canc10) 
		.append(this.canc11)
		.append(this.canc13) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("canc01", this.canc01) 
		.append("canc02", this.canc02) 
		.append("canc03", this.canc03) 
		.append("canc04", this.canc04) 
		.append("canc05", this.canc05) 
		.append("canc06", this.canc06) 
		.append("canc07", this.canc07) 
		.append("canc08", this.canc08) 
		.append("canc09", this.canc09) 
		.append("canc10", this.canc10) 
		.append("canc11", this.canc11)
		.append("canc13", this.canc13) 
		.toString();
	}
   
	public String getId() {
		return ""+canc01;
	}

	public String getpId() {
		return ""+canc02;
	}

	public String getName() {
		return canc03;
	}
	public String getParentColName() {
		return parentColName;
	}
	public void setParentColName(String parentColName) {
		this.parentColName = parentColName;
	}

}