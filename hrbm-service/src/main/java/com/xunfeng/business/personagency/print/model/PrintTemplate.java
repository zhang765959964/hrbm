package com.xunfeng.business.personagency.print.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PRINT_MODEL Model对象
* @author:user
* @createDate 2016-12-27 17:38:33 
* @version V1.0   
*/
public class PrintTemplate extends BaseModel
{
	// 主键
	protected Long  pkId;
	// 模版名称
	protected String  fdModelName;
	// html模版
	protected String  fdModelHtml;
	// 模版服务
	protected String  fdModelService;
	// 模版类型
	protected Long  fkModelType;
	// freemark模版
	protected String  fdModelTemplate;
	// 经办人ID
	protected Long  fkCreaterId;
	// 经办人名称
	protected String  fdCreaterName;
	// 经办时间
	protected java.util.Date  fdCreaterDate;
	// 经办机构ID
	protected Long  fkCreaterOrgId;
	// 经办机构名称
	protected String  fdCreaterOrgName;
	// 模版别名
	protected String  fdModelAlias;
	public void setPkId(Long pkId) 
	{
		this.pkId = pkId;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getPkId() 
	{
		return this.pkId;
	}
	public void setFdModelName(String fdModelName) 
	{
		this.fdModelName = fdModelName;
	}
	/**
	 * 返回 模版名称
	 * @return
	 */
	public String getFdModelName() 
	{
		return this.fdModelName;
	}
	public void setFdModelHtml(String fdModelHtml) 
	{
		this.fdModelHtml = fdModelHtml;
	}
	/**
	 * 返回 html模版
	 * @return
	 */
	public String getFdModelHtml() 
	{
		return this.fdModelHtml;
	}
	public void setFdModelService(String fdModelService) 
	{
		this.fdModelService = fdModelService;
	}
	/**
	 * 返回 模版服务
	 * @return
	 */
	public String getFdModelService() 
	{
		return this.fdModelService;
	}
	public void setFkModelType(Long fkModelType) 
	{
		this.fkModelType = fkModelType;
	}
	/**
	 * 返回 模版类型
	 * @return
	 */
	public Long getFkModelType() 
	{
		return this.fkModelType;
	}
	public void setFdModelTemplate(String fdModelTemplate) 
	{
		this.fdModelTemplate = fdModelTemplate;
	}
	/**
	 * 返回 freemark模版
	 * @return
	 */
	public String getFdModelTemplate() 
	{
		return this.fdModelTemplate;
	}
	public void setFkCreaterId(Long fkCreaterId) 
	{
		this.fkCreaterId = fkCreaterId;
	}
	/**
	 * 返回 经办人ID
	 * @return
	 */
	public Long getFkCreaterId() 
	{
		return this.fkCreaterId;
	}
	public void setFdCreaterName(String fdCreaterName) 
	{
		this.fdCreaterName = fdCreaterName;
	}
	/**
	 * 返回 经办人名称
	 * @return
	 */
	public String getFdCreaterName() 
	{
		return this.fdCreaterName;
	}
	public void setFdCreaterDate(java.util.Date fdCreaterDate) 
	{
		this.fdCreaterDate = fdCreaterDate;
	}
	/**
	 * 返回 经办时间
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class) 
	public java.util.Date getFdCreaterDate() 
	{
		return this.fdCreaterDate;
	}
	public void setFkCreaterOrgId(Long fkCreaterOrgId) 
	{
		this.fkCreaterOrgId = fkCreaterOrgId;
	}
	/**
	 * 返回 经办机构ID
	 * @return
	 */
	public Long getFkCreaterOrgId() 
	{
		return this.fkCreaterOrgId;
	}
	public void setFdCreaterOrgName(String fdCreaterOrgName) 
	{
		this.fdCreaterOrgName = fdCreaterOrgName;
	}
	/**
	 * 返回 经办机构名称
	 * @return
	 */
	public String getFdCreaterOrgName() 
	{
		return this.fdCreaterOrgName;
	}
	public void setFdModelAlias(String fdModelAlias) 
	{
		this.fdModelAlias = fdModelAlias;
	}
	/**
	 * 返回 模版别名
	 * @return
	 */
	public String getFdModelAlias() 
	{
		return this.fdModelAlias;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof PrintTemplate)) 
		{
			return false;
		}
		PrintTemplate rhs = (PrintTemplate) object;
		return new EqualsBuilder()
		.append(this.pkId, rhs.pkId)
		.append(this.fdModelName, rhs.fdModelName)
		.append(this.fdModelHtml, rhs.fdModelHtml)
		.append(this.fdModelService, rhs.fdModelService)
		.append(this.fkModelType, rhs.fkModelType)
		.append(this.fdModelTemplate, rhs.fdModelTemplate)
		.append(this.fkCreaterId, rhs.fkCreaterId)
		.append(this.fdCreaterName, rhs.fdCreaterName)
		.append(this.fdCreaterDate, rhs.fdCreaterDate)
		.append(this.fkCreaterOrgId, rhs.fkCreaterOrgId)
		.append(this.fdCreaterOrgName, rhs.fdCreaterOrgName)
		.append(this.fdModelAlias, rhs.fdModelAlias)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.pkId) 
		.append(this.fdModelName) 
		.append(this.fdModelHtml) 
		.append(this.fdModelService) 
		.append(this.fkModelType) 
		.append(this.fdModelTemplate) 
		.append(this.fkCreaterId) 
		.append(this.fdCreaterName) 
		.append(this.fdCreaterDate) 
		.append(this.fkCreaterOrgId) 
		.append(this.fdCreaterOrgName) 
		.append(this.fdModelAlias) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("pkId", this.pkId) 
		.append("fdModelName", this.fdModelName) 
		.append("fdModelHtml", this.fdModelHtml) 
		.append("fdModelService", this.fdModelService) 
		.append("fkModelType", this.fkModelType) 
		.append("fdModelTemplate", this.fdModelTemplate) 
		.append("fkCreaterId", this.fkCreaterId) 
		.append("fdCreaterName", this.fdCreaterName) 
		.append("fdCreaterDate", this.fdCreaterDate) 
		.append("fkCreaterOrgId", this.fkCreaterOrgId) 
		.append("fdCreaterOrgName", this.fdCreaterOrgName) 
		.append("fdModelAlias", this.fdModelAlias) 
		.toString();
	}
   
  

}