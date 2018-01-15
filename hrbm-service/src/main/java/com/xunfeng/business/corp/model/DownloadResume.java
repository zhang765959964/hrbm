package com.xunfeng.business.corp.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 企业下载简历日志表 Model对象
* @author:wangyanyan
* @createDate 2016-04-07 10:59:12 
* @version V1.0   
*/
public class DownloadResume extends BaseModel
{
	// 企业下载简历自动编号
	protected Long  ccpd01;
	// 企业编号
	protected Long  ccmc01;
	// 个人编号
	protected Long  ccmp01;
	// 下载日期
	protected java.util.Date  ccpd02;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 是否查看（0-未查看1-已查看）
	protected Long  ccpr10;
	// 数据来源
	protected String  cczy06;
	public void setCcpd01(Long ccpd01) 
	{
		this.ccpd01 = ccpd01;
	}
	/**
	 * 返回 企业下载简历自动编号
	 * @return
	 */
	public Long getCcpd01() 
	{
		return this.ccpd01;
	}
	public void setCcmc01(Long ccmc01) 
	{
		this.ccmc01 = ccmc01;
	}
	/**
	 * 返回 企业编号
	 * @return
	 */
	public Long getCcmc01() 
	{
		return this.ccmc01;
	}
	public void setCcmp01(Long ccmp01) 
	{
		this.ccmp01 = ccmp01;
	}
	/**
	 * 返回 个人编号
	 * @return
	 */
	public Long getCcmp01() 
	{
		return this.ccmp01;
	}
	public void setCcpd02(java.util.Date ccpd02) 
	{
		this.ccpd02 = ccpd02;
	}
	/**
	 * 返回 下载日期
	 * @return
	 */
	public java.util.Date getCcpd02() 
	{
		return this.ccpd02;
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
	public void setCcpr10(Long ccpr10) 
	{
		this.ccpr10 = ccpr10;
	}
	/**
	 * 返回 是否查看（0-未查看1-已查看）
	 * @return
	 */
	public Long getCcpr10() 
	{
		return this.ccpr10;
	}
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源
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
		if (!(object instanceof DownloadResume)) 
		{
			return false;
		}
		DownloadResume rhs = (DownloadResume) object;
		return new EqualsBuilder()
		.append(this.ccpd01, rhs.ccpd01)
		.append(this.ccmc01, rhs.ccmc01)
		.append(this.ccmp01, rhs.ccmp01)
		.append(this.ccpd02, rhs.ccpd02)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.ccpr10, rhs.ccpr10)
		.append(this.cczy06, rhs.cczy06)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.ccpd01) 
		.append(this.ccmc01) 
		.append(this.ccmp01) 
		.append(this.ccpd02) 
		.append(this.ccpr08) 
		.append(this.ccpr10) 
		.append(this.cczy06) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("ccpd01", this.ccpd01) 
		.append("ccmc01", this.ccmc01) 
		.append("ccmp01", this.ccmp01) 
		.append("ccpd02", this.ccpd02) 
		.append("ccpr08", this.ccpr08) 
		.append("ccpr10", this.ccpr10) 
		.append("cczy06", this.cczy06) 
		.toString();
	}
   
  

}