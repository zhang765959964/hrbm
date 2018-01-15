package com.xunfeng.business.jobfair.model;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 招聘会信息表 Model对象
* @author:wanghan
* @createDate 2015-09-12 11:02:45 
* @version V1.0   
*/
public class JobFairInfo extends BaseModel
{
	// 招聘会编号
	protected Long  acb330;
	// 招聘会名称
	protected String  acb331;
	// 招聘会主题
	protected String  acb332;
	// 招聘会介绍
	protected String  acb337;
	// 主办单位
	protected String  aab045;
	// 承办单位代码
	protected String  acb338;
	// 举办城市代码
	protected String  aab301;
	// 举办城市
	protected String  acb336;
	// 摊位数
	protected Long  acb311;
	// 开始日期
	protected java.util.Date  acb333;
	// 结束日期
	protected java.util.Date  acb334;
	// 联系人
	protected String  aae004;
	// 联系人电话
	protected String  aae005;
	// 电子信箱
	protected String  aae159;
	// 数据更新标识(0-使用1-注销)
	protected String  ace750;
	// 报送机构
	protected String  aab091;
	// 原始网页地址
	protected String  ace760;
	// 大会类型
	protected String  acb335;
	// 大会状态01-开始02-结束
	protected String  aae100;
	// 单位数
	protected Long  acb33a;
	// 工种岗位数
	protected Long  acb35d;
	// 达成意向人数
	protected Long  acb356;
	// 其中男性
	protected Long  acb357;
	// 其中女性
	protected Long  acb358;
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
	// 场地编号
	protected String  acd200;
	// 倍数
	protected Float  ccbs01;
	// 展示图片
	protected String  ccbs02;
	// 最后修改时间
	protected java.util.Date  ccpr05;
	// 修改人
	protected String  ccpr06;
	// 修改来源
	protected String  ccpr07;
	// 是否删除状态（0-否1-是）暂不用使用ACE750
	protected String  ccpr08;
	// 公示时间（在中部就业网显示出来的时间）
	protected java.util.Date  ccbs03;
	// 是否显示在中部就业网1-显示0-不显示
	protected Long  ccbs04;
	// 审核标记（由中心市场审核）0-未审核1-职介中心添加无需审核2-自动审核通过3-已审核
	protected Long  ccbs05;
	// 是否开放网站预定 0:不开放 1:开放
	protected Long  acb339;
	public void setAcb330(Long acb330) 
	{
		this.acb330 = acb330;
	}
	/**
	 * 返回 招聘会编号
	 * @return
	 */
	public Long getAcb330() 
	{
		return this.acb330;
	}
	public void setAcb331(String acb331) 
	{
		this.acb331 = acb331;
	}
	/**
	 * 返回 招聘会名称
	 * @return
	 */
	public String getAcb331() 
	{
		return this.acb331;
	}
	public void setAcb332(String acb332) 
	{
		this.acb332 = acb332;
	}
	/**
	 * 返回 招聘会主题
	 * @return
	 */
	public String getAcb332() 
	{
		return this.acb332;
	}
	public void setAcb337(String acb337) 
	{
		this.acb337 = acb337;
	}
	/**
	 * 返回 招聘会介绍
	 * @return
	 */
	public String getAcb337() 
	{
		return this.acb337;
	}
	public void setAab045(String aab045) 
	{
		this.aab045 = aab045;
	}
	/**
	 * 返回 主办单位
	 * @return
	 */
	public String getAab045() 
	{
		return this.aab045;
	}
	public void setAcb338(String acb338) 
	{
		this.acb338 = acb338;
	}
	/**
	 * 返回 承办单位代码
	 * @return
	 */
	public String getAcb338() 
	{
		return this.acb338;
	}
	public void setAab301(String aab301) 
	{
		this.aab301 = aab301;
	}
	/**
	 * 返回 举办城市代码
	 * @return
	 */
	public String getAab301() 
	{
		return this.aab301;
	}
	public void setAcb336(String acb336) 
	{
		this.acb336 = acb336;
	}
	/**
	 * 返回 举办城市
	 * @return
	 */
	public String getAcb336() 
	{
		return this.acb336;
	}
	public void setAcb311(Long acb311) 
	{
		this.acb311 = acb311;
	}
	/**
	 * 返回 摊位数
	 * @return
	 */
	public Long getAcb311() 
	{
		return this.acb311;
	}
	public void setAcb333(java.util.Date acb333) 
	{
		this.acb333 = acb333;
	}
	/**
	 * 返回 开始日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class)
	public java.util.Date getAcb333() 
	{
		return this.acb333;
	}
	public void setAcb334(java.util.Date acb334) 
	{
		this.acb334 = acb334;
	}
	/**
	 * 返回 结束日期
	 * @return
	 */
	@JsonSerialize(using=JsonDateSerializer.class)
	public java.util.Date getAcb334() 
	{
		return this.acb334;
	}
	public void setAae004(String aae004) 
	{
		this.aae004 = aae004;
	}
	/**
	 * 返回 联系人
	 * @return
	 */
	public String getAae004() 
	{
		return this.aae004;
	}
	public void setAae005(String aae005) 
	{
		this.aae005 = aae005;
	}
	/**
	 * 返回 联系人电话
	 * @return
	 */
	public String getAae005() 
	{
		return this.aae005;
	}
	public void setAae159(String aae159) 
	{
		this.aae159 = aae159;
	}
	/**
	 * 返回 电子信箱
	 * @return
	 */
	public String getAae159() 
	{
		return this.aae159;
	}
	public void setAce750(String ace750) 
	{
		this.ace750 = ace750;
	}
	/**
	 * 返回 数据更新标识(0-使用1-注销)
	 * @return
	 */
	public String getAce750() 
	{
		return this.ace750;
	}
	public void setAab091(String aab091) 
	{
		this.aab091 = aab091;
	}
	/**
	 * 返回 报送机构
	 * @return
	 */
	public String getAab091() 
	{
		return this.aab091;
	}
	public void setAce760(String ace760) 
	{
		this.ace760 = ace760;
	}
	/**
	 * 返回 原始网页地址
	 * @return
	 */
	public String getAce760() 
	{
		return this.ace760;
	}
	public void setAcb335(String acb335) 
	{
		this.acb335 = acb335;
	}
	/**
	 * 返回 大会类型
	 * @return
	 */
	public String getAcb335() 
	{
		return this.acb335;
	}
	public void setAae100(String aae100) 
	{
		this.aae100 = aae100;
	}
	/**
	 * 返回 大会状态01-开始02-结束
	 * @return
	 */
	public String getAae100() 
	{
		return this.aae100;
	}
	public void setAcb33a(Long acb33a) 
	{
		this.acb33a = acb33a;
	}
	/**
	 * 返回 单位数
	 * @return
	 */
	public Long getAcb33a() 
	{
		return this.acb33a;
	}
	public void setAcb35d(Long acb35d) 
	{
		this.acb35d = acb35d;
	}
	/**
	 * 返回 工种岗位数
	 * @return
	 */
	public Long getAcb35d() 
	{
		return this.acb35d;
	}
	public void setAcb356(Long acb356) 
	{
		this.acb356 = acb356;
	}
	/**
	 * 返回 达成意向人数
	 * @return
	 */
	public Long getAcb356() 
	{
		return this.acb356;
	}
	public void setAcb357(Long acb357) 
	{
		this.acb357 = acb357;
	}
	/**
	 * 返回 其中男性
	 * @return
	 */
	public Long getAcb357() 
	{
		return this.acb357;
	}
	public void setAcb358(Long acb358) 
	{
		this.acb358 = acb358;
	}
	/**
	 * 返回 其中女性
	 * @return
	 */
	public Long getAcb358() 
	{
		return this.acb358;
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
	@JsonSerialize(using=JsonDateSerializer.class)
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
	public void setAcd200(String acd200) 
	{
		this.acd200 = acd200;
	}
	/**
	 * 返回 场地编号
	 * @return
	 */
	public String getAcd200() 
	{
		return this.acd200;
	}
	public void setCcbs01(Float ccbs01) 
	{
		this.ccbs01 = ccbs01;
	}
	/**
	 * 返回 倍数
	 * @return
	 */
	public Float getCcbs01() 
	{
		return this.ccbs01;
	}
	public void setCcbs02(String ccbs02) 
	{
		this.ccbs02 = ccbs02;
	}
	/**
	 * 返回 展示图片
	 * @return
	 */
	public String getCcbs02() 
	{
		return this.ccbs02;
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
	 * 返回 是否删除状态（0-否1-是）暂不用使用ACE750
	 * @return
	 */
	public String getCcpr08() 
	{
		return this.ccpr08;
	}
	public void setCcbs03(java.util.Date ccbs03) 
	{
		this.ccbs03 = ccbs03;
	}
	/**
	 * 返回 公示时间（在中部就业网显示出来的时间）
	 * @return
	 */
	public java.util.Date getCcbs03() 
	{
		return this.ccbs03;
	}
	public void setCcbs04(Long ccbs04) 
	{
		this.ccbs04 = ccbs04;
	}
	/**
	 * 返回 是否显示在中部就业网1-显示0-不显示
	 * @return
	 */
	public Long getCcbs04() 
	{
		return this.ccbs04;
	}
	public void setCcbs05(Long ccbs05) 
	{
		this.ccbs05 = ccbs05;
	}
	/**
	 * 返回 审核标记（由中心市场审核）0-未审核1-职介中心添加无需审核2-自动审核通过3-已审核
	 * @return
	 */
	public Long getCcbs05() 
	{
		return this.ccbs05;
	}
	public void setAcb339(Long acb339) 
	{
		this.acb339 = acb339;
	}
	/**
	 * 返回 是否开放网站预定 0:不开放 1:开放
	 * @return
	 */
	public Long getAcb339() 
	{
		return this.acb339;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof JobFairInfo)) 
		{
			return false;
		}
		JobFairInfo rhs = (JobFairInfo) object;
		return new EqualsBuilder()
		.append(this.acb330, rhs.acb330)
		.append(this.acb331, rhs.acb331)
		.append(this.acb332, rhs.acb332)
		.append(this.acb337, rhs.acb337)
		.append(this.aab045, rhs.aab045)
		.append(this.acb338, rhs.acb338)
		.append(this.aab301, rhs.aab301)
		.append(this.acb336, rhs.acb336)
		.append(this.acb311, rhs.acb311)
		.append(this.acb333, rhs.acb333)
		.append(this.acb334, rhs.acb334)
		.append(this.aae004, rhs.aae004)
		.append(this.aae005, rhs.aae005)
		.append(this.aae159, rhs.aae159)
		.append(this.ace750, rhs.ace750)
		.append(this.aab091, rhs.aab091)
		.append(this.ace760, rhs.ace760)
		.append(this.acb335, rhs.acb335)
		.append(this.aae100, rhs.aae100)
		.append(this.acb33a, rhs.acb33a)
		.append(this.acb35d, rhs.acb35d)
		.append(this.acb356, rhs.acb356)
		.append(this.acb357, rhs.acb357)
		.append(this.acb358, rhs.acb358)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae022, rhs.aae022)
		.append(this.acd200, rhs.acd200)
		.append(this.ccbs01, rhs.ccbs01)
		.append(this.ccbs02, rhs.ccbs02)
		.append(this.ccpr05, rhs.ccpr05)
		.append(this.ccpr06, rhs.ccpr06)
		.append(this.ccpr07, rhs.ccpr07)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.ccbs03, rhs.ccbs03)
		.append(this.ccbs04, rhs.ccbs04)
		.append(this.ccbs05, rhs.ccbs05)
		.append(this.acb339, rhs.acb339)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.acb330) 
		.append(this.acb331) 
		.append(this.acb332) 
		.append(this.acb337) 
		.append(this.aab045) 
		.append(this.acb338) 
		.append(this.aab301) 
		.append(this.acb336) 
		.append(this.acb311) 
		.append(this.acb333) 
		.append(this.acb334) 
		.append(this.aae004) 
		.append(this.aae005) 
		.append(this.aae159) 
		.append(this.ace750) 
		.append(this.aab091) 
		.append(this.ace760) 
		.append(this.acb335) 
		.append(this.aae100) 
		.append(this.acb33a) 
		.append(this.acb35d) 
		.append(this.acb356) 
		.append(this.acb357) 
		.append(this.acb358) 
		.append(this.aae013) 
		.append(this.aae011) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae022) 
		.append(this.acd200) 
		.append(this.ccbs01) 
		.append(this.ccbs02) 
		.append(this.ccpr05) 
		.append(this.ccpr06) 
		.append(this.ccpr07) 
		.append(this.ccpr08) 
		.append(this.ccbs03) 
		.append(this.ccbs04) 
		.append(this.ccbs05) 
		.append(this.acb339) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("acb330", this.acb330) 
		.append("acb331", this.acb331) 
		.append("acb332", this.acb332) 
		.append("acb337", this.acb337) 
		.append("aab045", this.aab045) 
		.append("acb338", this.acb338) 
		.append("aab301", this.aab301) 
		.append("acb336", this.acb336) 
		.append("acb311", this.acb311) 
		.append("acb333", this.acb333) 
		.append("acb334", this.acb334) 
		.append("aae004", this.aae004) 
		.append("aae005", this.aae005) 
		.append("aae159", this.aae159) 
		.append("ace750", this.ace750) 
		.append("aab091", this.aab091) 
		.append("ace760", this.ace760) 
		.append("acb335", this.acb335) 
		.append("aae100", this.aae100) 
		.append("acb33a", this.acb33a) 
		.append("acb35d", this.acb35d) 
		.append("acb356", this.acb356) 
		.append("acb357", this.acb357) 
		.append("acb358", this.acb358) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae022", this.aae022) 
		.append("acd200", this.acd200) 
		.append("ccbs01", this.ccbs01) 
		.append("ccbs02", this.ccbs02) 
		.append("ccpr05", this.ccpr05) 
		.append("ccpr06", this.ccpr06) 
		.append("ccpr07", this.ccpr07) 
		.append("ccpr08", this.ccpr08) 
		.append("ccbs03", this.ccbs03) 
		.append("ccbs04", this.ccbs04) 
		.append("ccbs05", this.ccbs05) 
		.append("acb339", this.acb339) 
		.toString();
	}
   
  

}