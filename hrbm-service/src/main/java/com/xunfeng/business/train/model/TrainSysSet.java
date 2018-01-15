package com.xunfeng.business.train.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训系统设置表 Model对象
* @author:Wang.CS
* @createDate 2016-05-23 09:31:57 
* @version V1.0   
*/
public class TrainSysSet extends BaseModel
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
	// 数据来源0未知1网站2窗口
	protected String  cczy06;
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

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof TrainSysSet)) 
		{
			return false;
		}
		TrainSysSet rhs = (TrainSysSet) object;
		return new EqualsBuilder()
		.append(this.caos01, rhs.caos01)
		.append(this.caos02, rhs.caos02)
		.append(this.caos03, rhs.caos03)
		.append(this.caos04, rhs.caos04)
		.append(this.caos05, rhs.caos05)
		.append(this.caos06, rhs.caos06)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.cczy06, rhs.cczy06)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
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
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.cczy06) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
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
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("cczy06", this.cczy06) 
		.toString();
	}
   
  

}