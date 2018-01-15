package com.xunfeng.business.personagency.params.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 困难企业 Model对象
* @author:zhangfan
* @createDate 2016-12-26 11:04:42 
* @version V1.0   
*/
public class ParamsDiffCorp extends BaseModel
{
	// 主键ID
	protected Long  pkId;
	// 困难企业名称
	protected String  fdCorpName;
	// 困难企业代码
	protected String  fdCorpCode;
	// 所属区域
	protected String  fdCorpAddre;
	// 详细信息
	protected String  fdCorpDetail;
	// 备注
	protected String  fdCorpNote;
	public void setPkId(Long pkId) 
	{
		this.pkId = pkId;
	}
	/**
	 * 返回 主键ID
	 * @return
	 */
	public Long getPkId() 
	{
		return this.pkId;
	}
	public void setFdCorpName(String fdCorpName) 
	{
		this.fdCorpName = fdCorpName;
	}
	/**
	 * 返回 困难企业名称
	 * @return
	 */
	public String getFdCorpName() 
	{
		return this.fdCorpName;
	}
	public void setFdCorpCode(String fdCorpCode) 
	{
		this.fdCorpCode = fdCorpCode;
	}
	/**
	 * 返回 困难企业代码
	 * @return
	 */
	public String getFdCorpCode() 
	{
		return this.fdCorpCode;
	}
	public void setFdCorpAddre(String fdCorpAddre) 
	{
		this.fdCorpAddre = fdCorpAddre;
	}
	/**
	 * 返回 所属区域
	 * @return
	 */
	public String getFdCorpAddre() 
	{
		return this.fdCorpAddre;
	}
	public void setFdCorpDetail(String fdCorpDetail) 
	{
		this.fdCorpDetail = fdCorpDetail;
	}
	/**
	 * 返回 详细信息
	 * @return
	 */
	public String getFdCorpDetail() 
	{
		return this.fdCorpDetail;
	}
	public void setFdCorpNote(String fdCorpNote) 
	{
		this.fdCorpNote = fdCorpNote;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getFdCorpNote() 
	{
		return this.fdCorpNote;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ParamsDiffCorp)) 
		{
			return false;
		}
		ParamsDiffCorp rhs = (ParamsDiffCorp) object;
		return new EqualsBuilder()
		.append(this.pkId, rhs.pkId)
		.append(this.fdCorpName, rhs.fdCorpName)
		.append(this.fdCorpCode, rhs.fdCorpCode)
		.append(this.fdCorpAddre, rhs.fdCorpAddre)
		.append(this.fdCorpDetail, rhs.fdCorpDetail)
		.append(this.fdCorpNote, rhs.fdCorpNote)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.pkId) 
		.append(this.fdCorpName) 
		.append(this.fdCorpCode) 
		.append(this.fdCorpAddre) 
		.append(this.fdCorpDetail) 
		.append(this.fdCorpNote) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("pkId", this.pkId) 
		.append("fdCorpName", this.fdCorpName) 
		.append("fdCorpCode", this.fdCorpCode) 
		.append("fdCorpAddre", this.fdCorpAddre) 
		.append("fdCorpDetail", this.fdCorpDetail) 
		.append("fdCorpNote", this.fdCorpNote) 
		.toString();
	}
   
  

}