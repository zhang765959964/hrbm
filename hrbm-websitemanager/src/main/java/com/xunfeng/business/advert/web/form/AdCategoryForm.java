package com.xunfeng.business.advert.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.advert.model.AdCategory;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告类别表 Form对象
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
public class AdCategoryForm extends BaseForm<AdCategory>
{
	// 广告类别自动编号
	protected Long  caac01;
	// 分类名称
	protected String  caac02;
	// 广告父类编号
	protected Long  caac03;
	// 广告位数量
	protected Long  caac04;
	// 人才币价格
	protected Long  caac05;
	// 使用范围1-网站广告2-企业广告
	protected Long  caac06;
	protected String  indent;
	public void setCaac01(Long caac01) 
	{
		this.caac01 = caac01;
	}
	/**
	 * 返回 广告类别自动编号
	 * @return
	 */
	public Long getCaac01() 
	{
		return this.caac01;
	}
	
	public String getIndent() {
		return indent;
	}
	public void setIndent(String indent) {
		this.indent = indent;
	}
	public void setCaac02(String caac02) 
	{
		this.caac02 = caac02;
	}
	/**
	 * 返回 分类名称
	 * @return
	 */
	public String getCaac02() 
	{
		return this.caac02;
	}
	public void setCaac03(Long caac03) 
	{
		this.caac03 = caac03;
	}
	/**
	 * 返回 广告父类编号
	 * @return
	 */
	public Long getCaac03() 
	{
		return this.caac03;
	}
	public void setCaac04(Long caac04) 
	{
		this.caac04 = caac04;
	}
	/**
	 * 返回 广告位数量
	 * @return
	 */
	public Long getCaac04() 
	{
		return this.caac04;
	}
	public void setCaac05(Long caac05) 
	{
		this.caac05 = caac05;
	}
	/**
	 * 返回 人才币价格
	 * @return
	 */
	public Long getCaac05() 
	{
		return this.caac05;
	}
	public void setCaac06(Long caac06) 
	{
		this.caac06 = caac06;
	}
	/**
	 * 返回 使用范围1-网站广告2-企业广告
	 * @return
	 */
	public Long getCaac06() 
	{
		return this.caac06;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof AdCategoryForm)) 
		{
			return false;
		}
		AdCategoryForm rhs = (AdCategoryForm) object;
		return new EqualsBuilder()
		.append(this.caac01, rhs.caac01)
		.append(this.caac02, rhs.caac02)
		.append(this.caac03, rhs.caac03)
		.append(this.caac04, rhs.caac04)
		.append(this.caac05, rhs.caac05)
		.append(this.caac06, rhs.caac06)
		.append(this.indent, rhs.indent)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.caac01) 
		.append(this.caac02) 
		.append(this.caac03) 
		.append(this.caac04) 
		.append(this.caac05) 
		.append(this.caac06) 
		.append(this.indent) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("caac01", this.caac01) 
		.append("caac02", this.caac02) 
		.append("caac03", this.caac03) 
		.append("caac04", this.caac04) 
		.append("caac05", this.caac05) 
		.append("caac06", this.caac06) 
		.append("indent", this.indent) 
		.toString();
	}
   
  

}