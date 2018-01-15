package com.xunfeng.business.dissupport.divice.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 样式表 Model对象
* @author:wanghan
* @createDate 2016-07-27 17:06:34 
* @version V1.0   
*/
public class DiviceStyle extends BaseModel
{
	// 型号表编号seq_sb_ys
	protected Long  sty001;
	// 样式英文名称
	protected String  sty002;
	// 样式中文名称
	protected String  sty003;
	// 备注
	protected String  aae013;
	// 所属型号
	protected Long  mod001;
	// 样式效果图（上传图片路径）
	protected String  sty004;
	public void setSty001(Long sty001) 
	{
		this.sty001 = sty001;
	}
	/**
	 * 返回 型号表编号seq_sb_ys
	 * @return
	 */
	public Long getSty001() 
	{
		return this.sty001;
	}
	public void setSty002(String sty002) 
	{
		this.sty002 = sty002;
	}
	/**
	 * 返回 样式英文名称
	 * @return
	 */
	public String getSty002() 
	{
		return this.sty002;
	}
	public void setSty003(String sty003) 
	{
		this.sty003 = sty003;
	}
	/**
	 * 返回 样式中文名称
	 * @return
	 */
	public String getSty003() 
	{
		return this.sty003;
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
	public void setMod001(Long mod001) 
	{
		this.mod001 = mod001;
	}
	/**
	 * 返回 所属型号
	 * @return
	 */
	public Long getMod001() 
	{
		return this.mod001;
	}
	public void setSty004(String sty004) 
	{
		this.sty004 = sty004;
	}
	/**
	 * 返回 样式效果图（上传图片路径）
	 * @return
	 */
	public String getSty004() 
	{
		return this.sty004;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof DiviceStyle)) 
		{
			return false;
		}
		DiviceStyle rhs = (DiviceStyle) object;
		return new EqualsBuilder()
		.append(this.sty001, rhs.sty001)
		.append(this.sty002, rhs.sty002)
		.append(this.sty003, rhs.sty003)
		.append(this.aae013, rhs.aae013)
		.append(this.mod001, rhs.mod001)
		.append(this.sty004, rhs.sty004)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.sty001) 
		.append(this.sty002) 
		.append(this.sty003) 
		.append(this.aae013) 
		.append(this.mod001) 
		.append(this.sty004) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("sty001", this.sty001) 
		.append("sty002", this.sty002) 
		.append("sty003", this.sty003) 
		.append("aae013", this.aae013) 
		.append("mod001", this.mod001) 
		.append("sty004", this.sty004) 
		.toString();
	}
   
  

}