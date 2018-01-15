package com.xunfeng.business.advert.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.advert.model.AdCompany;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告位放置表 Form对象
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
public class AdCompanyForm extends BaseForm<AdCompany>
{
	// 广告位放置表自动编号
	protected Long  caae01;
	// 广告类编号
	protected Long  caac01;
	// 广告描述
	protected String  caae02;
	// 单位基本信息编号
	protected Long  aab001;
	// 上传图片或Flash地址
	protected String  caae03;
	// 指向地址
	protected String  caae04;
	// 职位编号
	protected Long  jobid;
	//分类名称
	protected String  caac02;
	//公司名称
	protected String aab004;
	//职位名称
	protected String cca113;
	public Long getCaae01() {
		return caae01;
	}
	public void setCaae01(Long caae01) {
		this.caae01 = caae01;
	}
	public Long getCaac01() {
		return caac01;
	}
	public void setCaac01(Long caac01) {
		this.caac01 = caac01;
	}
	public String getCaae02() {
		return caae02;
	}
	public void setCaae02(String caae02) {
		this.caae02 = caae02;
	}
	public Long getAab001() {
		return aab001;
	}
	public void setAab001(Long aab001) {
		this.aab001 = aab001;
	}
	public String getCaae03() {
		return caae03;
	}
	public void setCaae03(String caae03) {
		this.caae03 = caae03;
	}
	public String getCaae04() {
		return caae04;
	}
	public void setCaae04(String caae04) {
		this.caae04 = caae04;
	}
	public Long getJobid() {
		return jobid;
	}
	public void setJobid(Long jobid) {
		this.jobid = jobid;
	}
	public String getCaac02() {
		return caac02;
	}
	public void setCaac02(String caac02) {
		this.caac02 = caac02;
	}
	public String getAab004() {
		return aab004;
	}
	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}
	public String getCca113() {
		return cca113;
	}
	public void setCca113(String cca113) {
		this.cca113 = cca113;
	}

}