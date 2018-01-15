package com.xunfeng.business.personagency.print.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.print.model.PrintTemplate;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PRINT_MODEL Form对象
* @author:user
* @createDate 2016-12-27 17:38:33 
* @version V1.0   
*/
public class PrintTemplateForm extends BaseForm<PrintTemplate>
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

   
  

}