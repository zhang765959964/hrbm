package com.xunfeng.business.jobfair.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.jobfair.model.JobFairBooth;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 摊位初始化表 Form对象
* @author:wanghan
* @createDate 2015-09-12 11:06:53 
* @version V1.0   
*/
public class JobFairBoothForm extends BaseForm<JobFairBooth>
{
	// 摊位编号
	protected Long  ace200;
	// 摊位编码
	protected String  ace201;
	// 有效标记
	protected String  aae100;
	// 摊位面积
	protected Float  ace203;
	// 座位数
	protected Long  ace204;
	// 大厅
	protected String  ace205;
	// 场地编号
	protected Long  acd250;
	// X坐标
	protected String  ace206;
	// Y坐标
	protected String  ace207;
	// 摊位说明
	protected String  ace208;
	// 摊位屏幕IP地址
	protected String  ace209;
	// 备注
	protected String  aae013;
	// 经办人代码
	protected String  aae011;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036;
	// 机构行政区划代码
	protected String  aae022;
	// 基数
	protected Float  cczy02;
	// 摊位状态(1-临时2-固定)
	protected Long  cczy03;
	// 是否贵宾摊位(0-否1-是)
	protected Long  cczy04;
	// 最后修改时间
	protected java.util.Date  ccpr05;
	// 修改人
	protected String  ccpr06;
	// 修改来源
	protected String  ccpr07;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	public void setAce200(Long ace200) 
	{
		this.ace200 = ace200;
	}
	/**
	 * 返回 摊位编号
	 * @return
	 */
	public Long getAce200() 
	{
		return this.ace200;
	}
	public void setAce201(String ace201) 
	{
		this.ace201 = ace201;
	}
	/**
	 * 返回 摊位编码
	 * @return
	 */
	public String getAce201() 
	{
		return this.ace201;
	}
	public void setAae100(String aae100) 
	{
		this.aae100 = aae100;
	}
	/**
	 * 返回 有效标记
	 * @return
	 */
	public String getAae100() 
	{
		return this.aae100;
	}
	public void setAce203(Float ace203) 
	{
		this.ace203 = ace203;
	}
	/**
	 * 返回 摊位面积
	 * @return
	 */
	public Float getAce203() 
	{
		return this.ace203;
	}
	public void setAce204(Long ace204) 
	{
		this.ace204 = ace204;
	}
	/**
	 * 返回 座位数
	 * @return
	 */
	public Long getAce204() 
	{
		return this.ace204;
	}
	public void setAce205(String ace205) 
	{
		this.ace205 = ace205;
	}
	/**
	 * 返回 大厅
	 * @return
	 */
	public String getAce205() 
	{
		return this.ace205;
	}
	public void setAcd250(Long acd250) 
	{
		this.acd250 = acd250;
	}
	/**
	 * 返回 场地编号
	 * @return
	 */
	public Long getAcd250() 
	{
		return this.acd250;
	}
	public void setAce206(String ace206) 
	{
		this.ace206 = ace206;
	}
	/**
	 * 返回 X坐标
	 * @return
	 */
	public String getAce206() 
	{
		return this.ace206;
	}
	public void setAce207(String ace207) 
	{
		this.ace207 = ace207;
	}
	/**
	 * 返回 Y坐标
	 * @return
	 */
	public String getAce207() 
	{
		return this.ace207;
	}
	public void setAce208(String ace208) 
	{
		this.ace208 = ace208;
	}
	/**
	 * 返回 摊位说明
	 * @return
	 */
	public String getAce208() 
	{
		return this.ace208;
	}
	public void setAce209(String ace209) 
	{
		this.ace209 = ace209;
	}
	/**
	 * 返回 摊位屏幕IP地址
	 * @return
	 */
	public String getAce209() 
	{
		return this.ace209;
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
	public void setAae011(String aae011) 
	{
		this.aae011 = aae011;
	}
	/**
	 * 返回 经办人代码
	 * @return
	 */
	public String getAae011() 
	{
		return this.aae011;
	}
	public void setAae019(String aae019) 
	{
		this.aae019 = aae019;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public String getAae019() 
	{
		return this.aae019;
	}
	public void setAae020(String aae020) 
	{
		this.aae020 = aae020;
	}
	/**
	 * 返回 经办机构
	 * @return
	 */
	public String getAae020() 
	{
		return this.aae020;
	}
	public void setAae017(String aae017) 
	{
		this.aae017 = aae017;
	}
	/**
	 * 返回 经办机构代码
	 * @return
	 */
	public String getAae017() 
	{
		return this.aae017;
	}
	public void setAae036(java.util.Date aae036) 
	{
		this.aae036 = aae036;
	}
	/**
	 * 返回 经办日期
	 * @return
	 */
	public java.util.Date getAae036() 
	{
		return this.aae036;
	}
	public void setAae022(String aae022) 
	{
		this.aae022 = aae022;
	}
	/**
	 * 返回 机构行政区划代码
	 * @return
	 */
	public String getAae022() 
	{
		return this.aae022;
	}
	public void setCczy02(Float cczy02) 
	{
		this.cczy02 = cczy02;
	}
	/**
	 * 返回 基数
	 * @return
	 */
	public Float getCczy02() 
	{
		return this.cczy02;
	}
	public void setCczy03(Long cczy03) 
	{
		this.cczy03 = cczy03;
	}
	/**
	 * 返回 摊位状态(1-临时2-固定)
	 * @return
	 */
	public Long getCczy03() 
	{
		return this.cczy03;
	}
	public void setCczy04(Long cczy04) 
	{
		this.cczy04 = cczy04;
	}
	/**
	 * 返回 是否贵宾摊位(0-否1-是)
	 * @return
	 */
	public Long getCczy04() 
	{
		return this.cczy04;
	}
	public void setCcpr05(java.util.Date ccpr05) 
	{
		this.ccpr05 = ccpr05;
	}
	/**
	 * 返回 最后修改时间
	 * @return
	 */
	public java.util.Date getCcpr05() 
	{
		return this.ccpr05;
	}
	public void setCcpr06(String ccpr06) 
	{
		this.ccpr06 = ccpr06;
	}
	/**
	 * 返回 修改人
	 * @return
	 */
	public String getCcpr06() 
	{
		return this.ccpr06;
	}
	public void setCcpr07(String ccpr07) 
	{
		this.ccpr07 = ccpr07;
	}
	/**
	 * 返回 修改来源
	 * @return
	 */
	public String getCcpr07() 
	{
		return this.ccpr07;
	}
	public void setCcpr08(String ccpr08) 
	{
		this.ccpr08 = ccpr08;
	}
	/**
	 * 返回 是否删除状态（0-否1-是）
	 * @return
	 */
	public String getCcpr08() 
	{
		return this.ccpr08;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof JobFairBoothForm)) 
		{
			return false;
		}
		JobFairBoothForm rhs = (JobFairBoothForm) object;
		return new EqualsBuilder()
		.append(this.ace200, rhs.ace200)
		.append(this.ace201, rhs.ace201)
		.append(this.aae100, rhs.aae100)
		.append(this.ace203, rhs.ace203)
		.append(this.ace204, rhs.ace204)
		.append(this.ace205, rhs.ace205)
		.append(this.acd250, rhs.acd250)
		.append(this.ace206, rhs.ace206)
		.append(this.ace207, rhs.ace207)
		.append(this.ace208, rhs.ace208)
		.append(this.ace209, rhs.ace209)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae022, rhs.aae022)
		.append(this.cczy02, rhs.cczy02)
		.append(this.cczy03, rhs.cczy03)
		.append(this.cczy04, rhs.cczy04)
		.append(this.ccpr05, rhs.ccpr05)
		.append(this.ccpr06, rhs.ccpr06)
		.append(this.ccpr07, rhs.ccpr07)
		.append(this.ccpr08, rhs.ccpr08)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.ace200) 
		.append(this.ace201) 
		.append(this.aae100) 
		.append(this.ace203) 
		.append(this.ace204) 
		.append(this.ace205) 
		.append(this.acd250) 
		.append(this.ace206) 
		.append(this.ace207) 
		.append(this.ace208) 
		.append(this.ace209) 
		.append(this.aae013) 
		.append(this.aae011) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae022) 
		.append(this.cczy02) 
		.append(this.cczy03) 
		.append(this.cczy04) 
		.append(this.ccpr05) 
		.append(this.ccpr06) 
		.append(this.ccpr07) 
		.append(this.ccpr08) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("ace200", this.ace200) 
		.append("ace201", this.ace201) 
		.append("aae100", this.aae100) 
		.append("ace203", this.ace203) 
		.append("ace204", this.ace204) 
		.append("ace205", this.ace205) 
		.append("acd250", this.acd250) 
		.append("ace206", this.ace206) 
		.append("ace207", this.ace207) 
		.append("ace208", this.ace208) 
		.append("ace209", this.ace209) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae022", this.aae022) 
		.append("cczy02", this.cczy02) 
		.append("cczy03", this.cczy03) 
		.append("cczy04", this.cczy04) 
		.append("ccpr05", this.ccpr05) 
		.append("ccpr06", this.ccpr06) 
		.append("ccpr07", this.ccpr07) 
		.append("ccpr08", this.ccpr08) 
		.toString();
	}
   
  

}