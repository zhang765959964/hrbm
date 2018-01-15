package com.xunfeng.business.dissupport.divice.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.dissupport.divice.model.DiviceModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 型号表 Form对象
* @author:wanghan
* @createDate 2016-07-27 17:03:37 
* @version V1.0   
*/
public class DiviceModelForm extends BaseForm<DiviceModel>
{
	// 型号表编号seq_sb_xh
	protected Long  mod001;
	// 型号名称
	protected String  mod002;
	// 所属机构
	protected Long  acd200;
	// 中心样式
	protected String  mod003;
	// 机构样式
	protected String  mod004;
	// 备注
	protected String  aae013;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办时间
	protected java.util.Date  aae036;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	public void setMod001(Long mod001) 
	{
		this.mod001 = mod001;
	}
	/**
	 * 返回 型号表编号seq_sb_xh
	 * @return
	 */
	public Long getMod001() 
	{
		return this.mod001;
	}
	public void setMod002(String mod002) 
	{
		this.mod002 = mod002;
	}
	/**
	 * 返回 型号名称
	 * @return
	 */
	public String getMod002() 
	{
		return this.mod002;
	}
	public void setAcd200(Long acd200) 
	{
		this.acd200 = acd200;
	}
	/**
	 * 返回 所属机构
	 * @return
	 */
	public Long getAcd200() 
	{
		return this.acd200;
	}
	public void setMod003(String mod003) 
	{
		this.mod003 = mod003;
	}
	/**
	 * 返回 中心样式
	 * @return
	 */
	public String getMod003() 
	{
		return this.mod003;
	}
	public void setMod004(String mod004) 
	{
		this.mod004 = mod004;
	}
	/**
	 * 返回 机构样式
	 * @return
	 */
	public String getMod004() 
	{
		return this.mod004;
	}
	public void setAae013(String aae013) 
	{
		this.aae013 = aae013;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getAae013() 
	{
		return this.aae013;
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
	 * 返回 经办时间
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

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof DiviceModelForm)) 
		{
			return false;
		}
		DiviceModelForm rhs = (DiviceModelForm) object;
		return new EqualsBuilder()
		.append(this.mod001, rhs.mod001)
		.append(this.mod002, rhs.mod002)
		.append(this.acd200, rhs.acd200)
		.append(this.mod003, rhs.mod003)
		.append(this.mod004, rhs.mod004)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.mod001) 
		.append(this.mod002) 
		.append(this.acd200) 
		.append(this.mod003) 
		.append(this.mod004) 
		.append(this.aae013) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("mod001", this.mod001) 
		.append("mod002", this.mod002) 
		.append("acd200", this.acd200) 
		.append("mod003", this.mod003) 
		.append("mod004", this.mod004) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.toString();
	}
   
  

}