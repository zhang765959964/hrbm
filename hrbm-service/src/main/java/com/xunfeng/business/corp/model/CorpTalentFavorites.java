package com.xunfeng.business.corp.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 企业人才收藏夹 Model对象
* @author:wxl
* @createDate 2015-07-25 09:38:50 
* @version V1.0   
*/
public class CorpTalentFavorites extends BaseModel
{
	// 企业人才收藏夹自动编号
	protected Long  ccpg01;
	// 企业编号
	protected Long  ccmc01;
	// 个人编号
	protected Long  ccmp01;
	// 收藏日期
	protected java.util.Date  ccpg02;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 是否查看（0-未查看1-已查看）
	protected Long  ccpr10;
	// 招聘会编号
	protected Long  acb330;
	// 岗位编号
	protected Long  acb210;
	public void setCcpg01(Long ccpg01) 
	{
		this.ccpg01 = ccpg01;
	}
	/**
	 * 返回 企业人才收藏夹自动编号
	 * @return
	 */
	public Long getCcpg01() 
	{
		return this.ccpg01;
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
	public void setCcpg02(java.util.Date ccpg02) 
	{
		this.ccpg02 = ccpg02;
	}
	/**
	 * 返回 收藏日期
	 * @return
	 */
	public java.util.Date getCcpg02() 
	{
		return this.ccpg02;
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
	public void setAcb330(Long acb330) 
	{
		this.acb330 = acb330;
	}
	/**
	 * 返回 招聘会编号
	 * @return
	 */
	public Long getAcb330() 
	{
		return this.acb330;
	}
	public void setAcb210(Long acb210) 
	{
		this.acb210 = acb210;
	}
	/**
	 * 返回 岗位编号
	 * @return
	 */
	public Long getAcb210() 
	{
		return this.acb210;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof CorpTalentFavorites))
		{
			return false;
		}
		CorpTalentFavorites rhs = (CorpTalentFavorites) object;
		return new EqualsBuilder()
		.append(this.ccpg01, rhs.ccpg01)
		.append(this.ccmc01, rhs.ccmc01)
		.append(this.ccmp01, rhs.ccmp01)
		.append(this.ccpg02, rhs.ccpg02)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.ccpr10, rhs.ccpr10)
		.append(this.acb330, rhs.acb330)
		.append(this.acb210, rhs.acb210)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.ccpg01) 
		.append(this.ccmc01) 
		.append(this.ccmp01) 
		.append(this.ccpg02) 
		.append(this.ccpr08) 
		.append(this.ccpr10) 
		.append(this.acb330) 
		.append(this.acb210) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("ccpg01", this.ccpg01) 
		.append("ccmc01", this.ccmc01) 
		.append("ccmp01", this.ccmp01) 
		.append("ccpg02", this.ccpg02) 
		.append("ccpr08", this.ccpr08) 
		.append("ccpr10", this.ccpr10) 
		.append("acb330", this.acb330) 
		.append("acb210", this.acb210) 
		.toString();
	}
   
  

}