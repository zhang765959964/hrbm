package com.xunfeng.sys.attachment.model;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 网上认证提交信息表 Model对象
* @author:wxl
* @createDate 2015-08-02 17:37:04 
* @version V1.0   
*/
public class Attachment extends BaseModel
{
	// 认证提交自动编号
	protected Long  caoa01;
	// 用户编号
	protected Long  ccmu01;
	// 提交营业执照扫描件的地址
	protected String  caoa02;
	// 说明文字
	protected String  caoa03;
	// 证件类型(1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频)
	protected Long  caoa04;
	// 提交时间
	protected java.util.Date  caoa05;
	// 从业人员编号
	protected Long  acd230;
	// 处理认证日期
	protected java.util.Date  caoa06;
	// 是否通过认证(0-未审核1-审核已通过2-审核失败3-退回资料4-自动审核)
	protected Long  caoa07;
	// 认证意见备注
	protected String  caoa08;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 数据来源1网站3民营职介4-公办职介
	protected String  cczy06;
	// 是否已经上传(0-未上传1-已上传)
	protected Long  caoa09;
	// 提交法人身份证扫描件的地址
	protected String  caoa10;
	// 单位编号
	protected Long  aab001;
	public void setCaoa01(Long caoa01) 
	{
		this.caoa01 = caoa01;
	}
	/**
	 * 返回 认证提交自动编号
	 * @return
	 */
	public Long getCaoa01() 
	{
		return this.caoa01;
	}
	public void setCcmu01(Long ccmu01) 
	{
		this.ccmu01 = ccmu01;
	}
	/**
	 * 返回 用户编号
	 * @return
	 */
	public Long getCcmu01() 
	{
		return this.ccmu01;
	}
	public void setCaoa02(String caoa02) 
	{
		this.caoa02 = caoa02;
	}
	/**
	 * 返回 提交营业执照扫描件的地址
	 * @return
	 */
	public String getCaoa02() 
	{
		return this.caoa02;
	}
	public void setCaoa03(String caoa03) 
	{
		this.caoa03 = caoa03;
	}
	/**
	 * 返回 说明文字
	 * @return
	 */
	public String getCaoa03() 
	{
		return this.caoa03;
	}
	public void setCaoa04(Long caoa04) 
	{
		this.caoa04 = caoa04;
	}
	/**
	 * 返回 证件类型(1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频)
	 * @return
	 */
	public Long getCaoa04() 
	{
		return this.caoa04;
	}
	public void setCaoa05(java.util.Date caoa05) 
	{
		this.caoa05 = caoa05;
	}
	/**
	 * 返回 提交时间
	 * @return
	 */
	@JsonSerialize(using = JsonDateSerializer.class)
	public java.util.Date getCaoa05() 
	{
		return this.caoa05;
	}
	public void setAcd230(Long acd230) 
	{
		this.acd230 = acd230;
	}
	/**
	 * 返回 从业人员编号
	 * @return
	 */
	public Long getAcd230() 
	{
		return this.acd230;
	}
	public void setCaoa06(java.util.Date caoa06) 
	{
		this.caoa06 = caoa06;
	}
	/**
	 * 返回 处理认证日期
	 * @return
	 */
	public java.util.Date getCaoa06() 
	{
		return this.caoa06;
	}
	public void setCaoa07(Long caoa07) 
	{
		this.caoa07 = caoa07;
	}
	/**
	 * 返回 是否通过认证(0-未审核1-审核已通过2-审核失败3-退回资料4-自动审核)
	 * @return
	 */
	public Long getCaoa07() 
	{
		return this.caoa07;
	}
	public void setCaoa08(String caoa08) 
	{
		this.caoa08 = caoa08;
	}
	/**
	 * 返回 认证意见备注
	 * @return
	 */
	public String getCaoa08() 
	{
		return this.caoa08;
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
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源1网站3民营职介4-公办职介
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}
	public void setCaoa09(Long caoa09) 
	{
		this.caoa09 = caoa09;
	}
	/**
	 * 返回 是否已经上传(0-未上传1-已上传)
	 * @return
	 */
	public Long getCaoa09() 
	{
		return this.caoa09;
	}
	public void setCaoa10(String caoa10) 
	{
		this.caoa10 = caoa10;
	}
	/**
	 * 返回 提交法人身份证扫描件的地址
	 * @return
	 */
	public String getCaoa10() 
	{
		return this.caoa10;
	}
	public void setAab001(Long aab001) 
	{
		this.aab001 = aab001;
	}
	/**
	 * 返回 单位编号
	 * @return
	 */
	public Long getAab001() 
	{
		return this.aab001;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof Attachment)) 
		{
			return false;
		}
		Attachment rhs = (Attachment) object;
		return new EqualsBuilder()
		.append(this.caoa01, rhs.caoa01)
		.append(this.ccmu01, rhs.ccmu01)
		.append(this.caoa02, rhs.caoa02)
		.append(this.caoa03, rhs.caoa03)
		.append(this.caoa04, rhs.caoa04)
		.append(this.caoa05, rhs.caoa05)
		.append(this.acd230, rhs.acd230)
		.append(this.caoa06, rhs.caoa06)
		.append(this.caoa07, rhs.caoa07)
		.append(this.caoa08, rhs.caoa08)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.cczy06, rhs.cczy06)
		.append(this.caoa09, rhs.caoa09)
		.append(this.caoa10, rhs.caoa10)
		.append(this.aab001, rhs.aab001)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.caoa01) 
		.append(this.ccmu01) 
		.append(this.caoa02) 
		.append(this.caoa03) 
		.append(this.caoa04) 
		.append(this.caoa05) 
		.append(this.acd230) 
		.append(this.caoa06) 
		.append(this.caoa07) 
		.append(this.caoa08) 
		.append(this.ccpr08) 
		.append(this.cczy06) 
		.append(this.caoa09) 
		.append(this.caoa10) 
		.append(this.aab001) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("caoa01", this.caoa01) 
		.append("ccmu01", this.ccmu01) 
		.append("caoa02", this.caoa02) 
		.append("caoa03", this.caoa03) 
		.append("caoa04", this.caoa04) 
		.append("caoa05", this.caoa05) 
		.append("acd230", this.acd230) 
		.append("caoa06", this.caoa06) 
		.append("caoa07", this.caoa07) 
		.append("caoa08", this.caoa08) 
		.append("ccpr08", this.ccpr08) 
		.append("cczy06", this.cczy06) 
		.append("caoa09", this.caoa09) 
		.append("caoa10", this.caoa10) 
		.append("aab001", this.aab001) 
		.toString();
	}
   
  

}