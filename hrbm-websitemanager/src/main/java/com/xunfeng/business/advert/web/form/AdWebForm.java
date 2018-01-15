package com.xunfeng.business.advert.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.advert.model.AdWeb;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告位内容表 Form对象
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
public class AdWebForm extends BaseForm<AdWeb>
{
	// 广告位内容自动编号
	protected Long  caad01;
	// 类别编号
	protected Long  caac01;
	// 类别名称
	protected String  caac02;
	// 广告描述
	protected String  caad02;
	// 广告代码
	protected String  caad13;
	// 上传图片或Flash地址
	protected String  caad03;
	// 指向地址
	protected String  caad12;
	//  广告位显示状态 1:显示 0:隐藏
	protected Long  caad06;
	// 广告类型(1-文体2-图片3-flash)
	protected Long  caad11;
	public Long getCaad01() {
		return caad01;
	}
	public void setCaad01(Long caad01) {
		this.caad01 = caad01;
	}
	public Long getCaac01() {
		return caac01;
	}
	public void setCaac01(Long caac01) {
		this.caac01 = caac01;
	}
	public String getCaac02() {
		return caac02;
	}
	public void setCaac02(String caac02) {
		this.caac02 = caac02;
	}
	public String getCaad02() {
		return caad02;
	}
	public void setCaad02(String caad02) {
		this.caad02 = caad02;
	}
	public String getCaad13() {
		return caad13;
	}
	public void setCaad13(String caad13) {
		this.caad13 = caad13;
	}
	public String getCaad03() {
		return caad03;
	}
	public void setCaad03(String caad03) {
		this.caad03 = caad03;
	}
	public String getCaad12() {
		return caad12;
	}
	public void setCaad12(String caad12) {
		this.caad12 = caad12;
	}
	public Long getCaad06() {
		return caad06;
	}
	public void setCaad06(Long caad06) {
		this.caad06 = caad06;
	}
	public Long getCaad11() {
		return caad11;
	}
	public void setCaad11(Long caad11) {
		this.caad11 = caad11;
	}

}