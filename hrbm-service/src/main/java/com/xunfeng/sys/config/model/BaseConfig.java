package com.xunfeng.sys.config.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 系统配置表 Model对象
* @author:wxl
* @createDate 2015-08-07 17:39:43 
* @version V1.0   
*/
public class BaseConfig extends BaseModel
{
	// 系统配置自动编号
	protected Long  caos01;
	// 配置名称
	protected String  caos02;
	// 配置说明
	protected String  caos03;
	// 配置参数
	protected String  caos04;
	// 参数分类(1-网站专用2-客户端专用3-通用)
	protected Long  caos05;
	// 作用于模块
	protected String  caos06;
	public void setCaos01(Long caos01) 
	{
		this.caos01 = caos01;
	}
	/**
	 * 返回 系统配置自动编号
	 * @return
	 */
	public Long getCaos01() 
	{
		return this.caos01;
	}
	public void setCaos02(String caos02) 
	{
		this.caos02 = caos02;
	}
	/**
	 * 返回 配置名称
	 * @return
	 */
	public String getCaos02() 
	{
		return this.caos02;
	}
	public void setCaos03(String caos03) 
	{
		this.caos03 = caos03;
	}
	/**
	 * 返回 配置说明
	 * @return
	 */
	public String getCaos03() 
	{
		return this.caos03;
	}
	public void setCaos04(String caos04) 
	{
		this.caos04 = caos04;
	}
	/**
	 * 返回 配置参数
	 * @return
	 */
	public String getCaos04() 
	{
		return this.caos04;
	}
	public void setCaos05(Long caos05) 
	{
		this.caos05 = caos05;
	}
	/**
	 * 返回 参数分类(1-网站专用2-客户端专用3-通用)
	 * @return
	 */
	public Long getCaos05() 
	{
		return this.caos05;
	}
	public void setCaos06(String caos06) 
	{
		this.caos06 = caos06;
	}
	/**
	 * 返回 作用于模块
	 * @return
	 */
	public String getCaos06() 
	{
		return this.caos06;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof BaseConfig))
		{
			return false;
		}
		BaseConfig rhs = (BaseConfig) object;
		return new EqualsBuilder()
		.append(this.caos01, rhs.caos01)
		.append(this.caos02, rhs.caos02)
		.append(this.caos03, rhs.caos03)
		.append(this.caos04, rhs.caos04)
		.append(this.caos05, rhs.caos05)
		.append(this.caos06, rhs.caos06)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.caos01) 
		.append(this.caos02) 
		.append(this.caos03) 
		.append(this.caos04) 
		.append(this.caos05) 
		.append(this.caos06) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("caos01", this.caos01) 
		.append("caos02", this.caos02) 
		.append("caos03", this.caos03) 
		.append("caos04", this.caos04) 
		.append("caos05", this.caos05) 
		.append("caos06", this.caos06) 
		.toString();
	}
   
  

}