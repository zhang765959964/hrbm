package com.xunfeng.business.personagency.params.web.form;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.business.personagency.params.model.ParamsPayment;
import com.xunfeng.core.model.BaseForm;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: RSDA_BS_PARAMS_PAYMENT Form对象
 * @author:wanghan
 * @createDate 2016-09-05 09:47:42
 * @version V1.0
 */
public class ParamsPaymentForm extends BaseForm<ParamsPayment> {
	// 主键ID
	protected Long pkId;
	// 标准执行开始年月
	protected String fdStartdate;
	// 标准执行结束年月
	protected String fdEnddate;
	// 优惠标准
	protected Float fdStandard;
	// 持优惠证标准
	protected Float fdDiscountStandard;
	// 经办人ID
	protected Long fkCreaterId;
	// 经办人名称
	protected String fdCreaterName;
	// 经办时间
	protected java.util.Date fdCreaterDate;
	// 经办机构名称
	protected String fdCreaterOrgName;
	// 经办机构ID
	protected Long fkCreaterOrgId;

	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}

	/**
	 * 返回 主键ID
	 * 
	 * @return
	 */
	public Long getPkId() {
		return this.pkId;
	}

	public void setFdStartdate(String fdStartdate) {
		this.fdStartdate = fdStartdate;
	}

	/**
	 * 返回 标准执行开始年月
	 * 
	 * @return
	 */
	public String getFdStartdate() {
		return this.fdStartdate;
	}

	public void setFdEnddate(String fdEnddate) {
		this.fdEnddate = fdEnddate;
	}

	/**
	 * 返回 标准执行结束年月
	 * 
	 * @return
	 */
	public String getFdEnddate() {
		return this.fdEnddate;
	}

	public void setFdStandard(Float fdStandard) {
		this.fdStandard = fdStandard;
	}

	/**
	 * 返回 优惠标准
	 * 
	 * @return
	 */
	public Float getFdStandard() {
		return this.fdStandard;
	}

	public void setFdDiscountStandard(Float fdDiscountStandard) {
		this.fdDiscountStandard = fdDiscountStandard;
	}

	/**
	 * 返回 持优惠证标准
	 * 
	 * @return
	 */
	public Float getFdDiscountStandard() {
		return this.fdDiscountStandard;
	}

	public void setFkCreaterId(Long fkCreaterId) {
		this.fkCreaterId = fkCreaterId;
	}

	/**
	 * 返回 经办人ID
	 * 
	 * @return
	 */
	public Long getFkCreaterId() {
		return this.fkCreaterId;
	}

	public void setFdCreaterName(String fdCreaterName) {
		this.fdCreaterName = fdCreaterName;
	}

	/**
	 * 返回 经办人名称
	 * 
	 * @return
	 */
	public String getFdCreaterName() {
		return this.fdCreaterName;
	}

	public void setFdCreaterDate(java.util.Date fdCreaterDate) {
		this.fdCreaterDate = fdCreaterDate;
	}

	/**
	 * 返回 经办时间
	 * 
	 * @return
	 */
	public java.util.Date getFdCreaterDate() {
		return this.fdCreaterDate;
	}

	public void setFdCreaterOrgName(String fdCreaterOrgName) {
		this.fdCreaterOrgName = fdCreaterOrgName;
	}

	/**
	 * 返回 经办机构名称
	 * 
	 * @return
	 */
	public String getFdCreaterOrgName() {
		return this.fdCreaterOrgName;
	}

	public void setFkCreaterOrgId(Long fkCreaterOrgId) {
		this.fkCreaterOrgId = fkCreaterOrgId;
	}

	/**
	 * 返回 经办机构ID
	 * 
	 * @return
	 */
	public Long getFkCreaterOrgId() {
		return this.fkCreaterOrgId;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof ParamsPaymentForm)) {
			return false;
		}
		ParamsPaymentForm rhs = (ParamsPaymentForm) object;
		return new EqualsBuilder().append(this.pkId, rhs.pkId).append(this.fdStartdate, rhs.fdStartdate)
				.append(this.fdEnddate, rhs.fdEnddate).append(this.fdStandard, rhs.fdStandard)
				.append(this.fdDiscountStandard, rhs.fdDiscountStandard).append(this.fkCreaterId, rhs.fkCreaterId)
				.append(this.fdCreaterName, rhs.fdCreaterName).append(this.fdCreaterDate, rhs.fdCreaterDate)
				.append(this.fdCreaterOrgName, rhs.fdCreaterOrgName).append(this.fkCreaterOrgId, rhs.fkCreaterOrgId)
				.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973).append(this.pkId).append(this.fdStartdate)
				.append(this.fdEnddate).append(this.fdStandard).append(this.fdDiscountStandard)
				.append(this.fkCreaterId).append(this.fdCreaterName).append(this.fdCreaterDate)
				.append(this.fdCreaterOrgName).append(this.fkCreaterOrgId).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("pkId", this.pkId).append("fdStartdate", this.fdStartdate)
				.append("fdEnddate", this.fdEnddate).append("fdStandard", this.fdStandard)
				.append("fdDiscountStandard", this.fdDiscountStandard).append("fkCreaterId", this.fkCreaterId)
				.append("fdCreaterName", this.fdCreaterName).append("fdCreaterDate", this.fdCreaterDate)
				.append("fdCreaterOrgName", this.fdCreaterOrgName).append("fkCreaterOrgId", this.fkCreaterOrgId)
				.toString();
	}

	@Override
	public void setCreaterId(Long createrId) {

		this.fkCreaterId = createrId;
	}

	@Override
	public void setCreaterName(String createrName) {

		this.fdCreaterName = createrName;
	}

	@Override
	public void setCreaterDate(Date createrDate) {

		this.fdCreaterDate = createrDate;
	}

	@Override
	public void setCreaterOrgName(String createrOrgName) {

		this.fdCreaterOrgName = createrOrgName;
	}

	@Override
	public void setCreaterOrgId(Long createrOrgId) {
		this.fkCreaterOrgId = createrOrgId;
	}

}