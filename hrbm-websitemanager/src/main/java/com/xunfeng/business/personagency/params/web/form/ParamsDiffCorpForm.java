package com.xunfeng.business.personagency.params.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.params.model.ParamsDiffCorp;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 困难企业 Form对象
* @author:zhangfan
* @createDate 2016-12-26 11:04:42 
* @version V1.0   
*/
public class ParamsDiffCorpForm extends BaseForm<ParamsDiffCorp>
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

   
  

}