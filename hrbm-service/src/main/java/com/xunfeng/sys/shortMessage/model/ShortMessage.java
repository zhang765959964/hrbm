package com.xunfeng.sys.shortMessage.model;
import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 短信发送内容表 Model对象
* @author:wanlupeng
* @createDate 2016-08-15 15:17:45 
* @version V1.0   
*/
public class ShortMessage extends BaseModel
{
	// 短信内容编号seq_com_con
	protected Long  comc01;
	// 手机号码
	protected String  comc02;
	// 短信内容
	protected String  comc03;
	// 发送状态（1-正在发送2-等待发送3-发送成功4-发送失败）
	protected Long  comc04;
	// 短信来源（1.节点发送。2.定时发送。3.为个人用户手动发送。4.为企业用户手动发送。5.为职介职工手动发送。6.任意方式发送）

	protected Long  comc05;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036;
	// 节点编号
	protected Long  comn01;
	// 定时发送模式（1、招聘会预定信息统计2、招聘参加企业及岗位统计3、就业网信息统计）

	protected Long  comc06;
	// 短信返回标识
	protected Long  comc07;
	public void setComc01(Long comc01) 
	{
		this.comc01 = comc01;
	}
	/**
	 * 返回 短信内容编号seq_com_con
	 * @return
	 */
	public Long getComc01() 
	{
		return this.comc01;
	}
	public void setComc02(String comc02) 
	{
		this.comc02 = comc02;
	}
	/**
	 * 返回 手机号码
	 * @return
	 */
	public String getComc02() 
	{
		return this.comc02;
	}
	public void setComc03(String comc03) 
	{
		this.comc03 = comc03;
	}
	/**
	 * 返回 短信内容
	 * @return
	 */
	public String getComc03() 
	{
		return this.comc03;
	}
	public void setComc04(Long comc04) 
	{
		this.comc04 = comc04;
	}
	/**
	 * 返回 发送状态（1-正在发送2-等待发送3-发送成功4-发送失败）
	 * @return
	 */
	public Long getComc04() 
	{
		return this.comc04;
	}
	public void setComc05(Long comc05) 
	{
		this.comc05 = comc05;
	}
	/**
	 * 返回 短信来源（1.节点发送。2.定时发送。3.为个人用户手动发送。4.为企业用户手动发送。5.为职介职工手动发送。6.任意方式发送）

	 * @return
	 */
	public Long getComc05() 
	{
		return this.comc05;
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
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getAae036() 
	{
		return this.aae036;
	}
	public void setComn01(Long comn01) 
	{
		this.comn01 = comn01;
	}
	/**
	 * 返回 节点编号
	 * @return
	 */
	public Long getComn01() 
	{
		return this.comn01;
	}
	public void setComc06(Long comc06) 
	{
		this.comc06 = comc06;
	}
	/**
	 * 返回 定时发送模式（1、招聘会预定信息统计2、招聘参加企业及岗位统计3、就业网信息统计）

	 * @return
	 */
	public Long getComc06() 
	{
		return this.comc06;
	}
	public void setComc07(Long comc07) 
	{
		this.comc07 = comc07;
	}
	/**
	 * 返回 短信返回标识
	 * @return
	 */
	public Long getComc07() 
	{
		return this.comc07;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ShortMessage)) 
		{
			return false;
		}
		ShortMessage rhs = (ShortMessage) object;
		return new EqualsBuilder()
		.append(this.comc01, rhs.comc01)
		.append(this.comc02, rhs.comc02)
		.append(this.comc03, rhs.comc03)
		.append(this.comc04, rhs.comc04)
		.append(this.comc05, rhs.comc05)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.comn01, rhs.comn01)
		.append(this.comc06, rhs.comc06)
		.append(this.comc07, rhs.comc07)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.comc01) 
		.append(this.comc02) 
		.append(this.comc03) 
		.append(this.comc04) 
		.append(this.comc05) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.comn01) 
		.append(this.comc06) 
		.append(this.comc07) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("comc01", this.comc01) 
		.append("comc02", this.comc02) 
		.append("comc03", this.comc03) 
		.append("comc04", this.comc04) 
		.append("comc05", this.comc05) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("comn01", this.comn01) 
		.append("comc06", this.comc06) 
		.append("comc07", this.comc07) 
		.toString();
	}
   
  

}