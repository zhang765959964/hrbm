package com.xunfeng.business.personagency.payment.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 缴费记录 Form对象
* @author:wanghan
* @createDate 2016-08-23 16:03:24 
* @version V1.0   
*/
public class PaymentRecordForm extends BaseForm<PaymentRecord>
{
	// 主键ID
	protected Long  pkId;
	// 人员ID
	protected Long  fkPersonId;
//	// 经办人ID
//	protected Long  fkCreaterId;
//	// 经办人名称
//	protected String  fdCreaterName;
//	// 经办时间
//	protected java.util.Date  fdCreaterDate;
	// 经办机构名称
//	protected String  fdCreaterOrgName;
	// 经办机构ID
//	protected Long  fkCreaterOrgId;
	// 开始缴费日期
	protected String  fdStartDate;
	// 终止缴费日期
	protected String  fdEndDate;
	// 缴费金额
//	protected String  fdPaymentAmount;
	// 缴费月数
	protected Long  fdPaymentMonths;
	// 缴费类型
	protected String  fdPaymentType;
	// 缴费状态
//	protected String  fdPaymentStatus;
	// 缴费标准
	protected String  fdPaymentStandard;
	// 缴费日期
	protected java.util.Date  fdPaymentDate;
//	// 确认人Id
//	protected Long  fkConfirmsId;
//	// 确认人名称
//	protected String  fdConfirmsName;
//	// 确认日期
//	protected java.util.Date  fdConfirmsDate;
//	// 确认机构Id
//	protected Long  fkConfirmsOrgId;
//	// 确认机构名称
//	protected String  fdConfirmsOrgName;
	// 单位缴费记录ID
	protected Long  fkCorpRecordId;
	
	// 备注
	protected String  fdDesc;
	
	private ArchivesPersonBaseForm  archivesPersonBaseForm;
	public Long getPkId() {
		return pkId;
	}
	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}
	public String getFdStartDate() {
		return fdStartDate;
	}
	public void setFdStartDate(String fdStartDate) {
		this.fdStartDate = fdStartDate;
	}
	public String getFdEndDate() {
		return fdEndDate;
	}
	public void setFdEndDate(String fdEndDate) {
		this.fdEndDate = fdEndDate;
	}
	public Long getFdPaymentMonths() {
		return fdPaymentMonths;
	}
	public void setFdPaymentMonths(Long fdPaymentMonths) {
		this.fdPaymentMonths = fdPaymentMonths;
	}
	public java.util.Date getFdPaymentDate() {
		return fdPaymentDate;
	}
	public void setFdPaymentDate(java.util.Date fdPaymentDate) {
		this.fdPaymentDate = fdPaymentDate;
	}
	public Long getFkPersonId() {
		return fkPersonId;
	}
	public void setFkPersonId(Long fkPersonId) {
		this.fkPersonId = fkPersonId;
	}
	public Long getFkCorpRecordId() {
		return fkCorpRecordId;
	}
	public void setFkCorpRecordId(Long fkCorpRecordId) {
		this.fkCorpRecordId = fkCorpRecordId;
	}
	public ArchivesPersonBaseForm getArchivesPersonBaseForm() {
		return archivesPersonBaseForm;
	}
	public void setArchivesPersonBaseForm(ArchivesPersonBaseForm archivesPersonBaseForm) {
		this.archivesPersonBaseForm = archivesPersonBaseForm;
	}
	public String getFdPaymentType() {
		return fdPaymentType;
	}
	public void setFdPaymentType(String fdPaymentType) {
		this.fdPaymentType = fdPaymentType;
	}
	public String getFdPaymentStandard() {
		return fdPaymentStandard;
	}
	public void setFdPaymentStandard(String fdPaymentStandard) {
		this.fdPaymentStandard = fdPaymentStandard;
	}
	public String getFdDesc() {
		return fdDesc;
	}
	public void setFdDesc(String fdDesc) {
		this.fdDesc = fdDesc;
	}

   
  

}