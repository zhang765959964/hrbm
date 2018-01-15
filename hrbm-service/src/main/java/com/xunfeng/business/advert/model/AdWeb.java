package com.xunfeng.business.advert.model;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告位内容表 Model对象
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
public class AdWeb extends BaseModel
{
	// 广告位内容自动编号
	protected Long  caad01;
	// 类别编号
	protected Long  caac01;
	// 广告描述
	protected String  caad02;
	// 广告代码
	protected String  caad13;
	// 上传图片或Flash地址
	protected String  caad03;
	// 指向地址
	protected String  caad12;
	// 广告位宽度
	protected Long  caad04;
	// 广告位高度
	protected Long  caad05;
	//  广告位显示状态 1:显示 0:隐藏
	protected Long  caad06;
	// 广告位人才币价格
	protected Long  caad07;
	// 广告位人民币价格
	protected Long  caad08;
	// 广告类型(1-文体2-图片3-flash)
	protected Long  caad11;
	//网站点击量
	protected Long  caad14;
	//网站广告排序
	protected Long  caad15;
	//广告添加时间
	protected Date  caad16;
	// 岗位id(用于楼层广告展示)
	protected Long  craftAsId;
	public void setCaad01(Long caad01) 
	{
		this.caad01 = caad01;
	}
	/**
	 * 返回 广告位内容自动编号
	 * @return
	 */
	public Long getCaad01() 
	{
		return this.caad01;
	}
	public void setCaac01(Long caac01) 
	{
		this.caac01 = caac01;
	}
	/**
	 * 返回 类别编号
	 * @return
	 */
	public Long getCaac01() 
	{
		return this.caac01;
	}
	public void setCaad02(String caad02) 
	{
		this.caad02 = caad02;
	}
	/**
	 * 返回 广告描述
	 * @return
	 */
	public String getCaad02() 
	{
		return this.caad02;
	}
	public void setCaad13(String caad13) 
	{
		this.caad13 = caad13;
	}
	/**
	 * 返回 广告代码
	 * @return
	 */
	public String getCaad13() 
	{
		return this.caad13;
	}
	public void setCaad03(String caad03) 
	{
		this.caad03 = caad03;
	}
	/**
	 * 返回 上传图片或Flash地址
	 * @return
	 */
	public String getCaad03() 
	{
		return this.caad03;
	}
	public void setCaad12(String caad12) 
	{
		this.caad12 = caad12;
	}
	/**
	 * 返回 指向地址
	 * @return
	 */
	public String getCaad12() 
	{
		return this.caad12;
	}
	public void setCaad04(Long caad04) 
	{
		this.caad04 = caad04;
	}
	/**
	 * 返回 广告位宽度
	 * @return
	 */
	public Long getCaad04() 
	{
		return this.caad04;
	}
	public void setCaad05(Long caad05) 
	{
		this.caad05 = caad05;
	}
	/**
	 * 返回 广告位高度
	 * @return
	 */
	public Long getCaad05() 
	{
		return this.caad05;
	}
	public void setCaad06(Long caad06) 
	{
		this.caad06 = caad06;
	}
	/**
	 * 返回  广告位显示状态 1:显示 0:隐藏
	 * @return
	 */
	public Long getCaad06() 
	{
		return this.caad06;
	}
	public void setCaad07(Long caad07) 
	{
		this.caad07 = caad07;
	}
	/**
	 * 返回 广告位人才币价格
	 * @return
	 */
	public Long getCaad07() 
	{
		return this.caad07;
	}
	public void setCaad08(Long caad08) 
	{
		this.caad08 = caad08;
	}
	/**
	 * 返回 广告位人民币价格
	 * @return
	 */
	public Long getCaad08() 
	{
		return this.caad08;
	}
	public void setCaad11(Long caad11) 
	{
		this.caad11 = caad11;
	}
	/**
	 * 返回 广告类型(1-文体2-图片3-flash)
	 * @return
	 */
	public Long getCaad11() 
	{
		return this.caad11;
	}
	public void setCraftAsId(Long craftAsId) 
	{
		this.craftAsId = craftAsId;
	}
	/**
	 * 返回 岗位id(用于楼层广告展示)
	 * @return
	 */
	public Long getCraftAsId() 
	{
		return this.craftAsId;
	}
    /**
     * 广告排序
     * @return
     */
   	public Long getCaad14() {
		return caad14;
	}
	public void setCaad14(Long caad14) {
		this.caad14 = caad14;
	}
	public Long getCaad15() {
		return caad15;
	}
	public void setCaad15(Long caad15) {
		this.caad15 = caad15;
	}
	public Date getCaad16() {
		return caad16;
	}
	public void setCaad16(Date caad16) {
		this.caad16 = caad16;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof AdWeb)) 
		{
			return false;
		}
		AdWeb rhs = (AdWeb) object;
		return new EqualsBuilder()
		.append(this.caad01, rhs.caad01)
		.append(this.caac01, rhs.caac01)
		.append(this.caad02, rhs.caad02)
		.append(this.caad13, rhs.caad13)
		.append(this.caad03, rhs.caad03)
		.append(this.caad12, rhs.caad12)
		.append(this.caad04, rhs.caad04)
		.append(this.caad05, rhs.caad05)
		.append(this.caad06, rhs.caad06)
		.append(this.caad07, rhs.caad07)
		.append(this.caad08, rhs.caad08)
		.append(this.caad11, rhs.caad11)
		.append(this.craftAsId, rhs.craftAsId)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.caad01) 
		.append(this.caac01) 
		.append(this.caad02) 
		.append(this.caad13) 
		.append(this.caad03) 
		.append(this.caad12) 
		.append(this.caad04) 
		.append(this.caad05) 
		.append(this.caad06) 
		.append(this.caad07) 
		.append(this.caad08) 
		.append(this.caad11) 
		.append(this.craftAsId) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("caad01", this.caad01) 
		.append("caac01", this.caac01) 
		.append("caad02", this.caad02) 
		.append("caad13", this.caad13) 
		.append("caad03", this.caad03) 
		.append("caad12", this.caad12) 
		.append("caad04", this.caad04) 
		.append("caad05", this.caad05) 
		.append("caad06", this.caad06) 
		.append("caad07", this.caad07) 
		.append("caad08", this.caad08) 
		.append("caad11", this.caad11) 
		.append("craftAsId", this.craftAsId) 
		.toString();
	}
   
  

}