package com.xunfeng.business.corp.model;
import java.util.Date;

import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位进场招聘表 Model对象
* @author:wanghan
* @createDate 2016-04-14 09:11:39 
* @version V1.0   
*/
public class CorpEnter extends BaseModel
{
	// 单位进场招聘编号
	protected Long  acb350;
	// 招聘编号
	protected Long  acb200;
	// 单位名称
	protected String  aab004;
	// 招聘会编号
	protected Long  acb330;
	// 签到人
	protected String  acb35a;
	// 签到时间
	protected java.util.Date  acb35b;
	// 是否到场
	protected String  acb35c;
	// 发放物品
	protected String  acb35k;
	// 工种岗位数
	protected Long  acb35d;
	// 计划招收人数
	protected Long  acb355;
	// 达成意向其中男性
	protected Long  acb357;
	// 达成意向其中女性
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
	protected java.util.Date  aae036=new Date();
	// 机构行政区划代码
	protected String  aae022;
	// 摊位安排状态
	protected String  acb35e;
	// 招聘会名称
	protected String  acb331;
	// 开始日期
	protected java.util.Date  acb333;
	// 结束日期
	protected java.util.Date  acb334;
	// 大会类型
	protected String  acb335;
	// 数据分类
	protected String  bcb207;
	// 摊位预定编号
	protected Long  ace200;
	// 单位编号
	protected Long  aab001;
	// 押金
	protected Float  acb353;
	// 进场工作人员数
	protected Long  ccbs02;
	// 达成意向人数
	protected Long  acb356;
	// 报名人数
	protected Long  acb35h;
	// 报名人数其中男性
	protected Long  acb35i;
	// 报名人数其中女性
	protected Long  acb35j;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 设备编号
	protected Long  div001;
	// 签到方式1-客户端人工签到2-自助刷会员卡签到3-自助会员账号签到4-自助订单号签到
	protected String  ccbs04;
	public void setAcb350(Long acb350) 
	{
		this.acb350 = acb350;
	}
	/**
	 * 返回 单位进场招聘编号
	 * @return
	 */
	public Long getAcb350() 
	{
		return this.acb350;
	}
	public void setAcb200(Long acb200) 
	{
		this.acb200 = acb200;
	}
	/**
	 * 返回 招聘编号
	 * @return
	 */
	public Long getAcb200() 
	{
		return this.acb200;
	}
	public void setAab004(String aab004) 
	{
		this.aab004 = aab004;
	}
	/**
	 * 返回 单位名称
	 * @return
	 */
	public String getAab004() 
	{
		return this.aab004;
	}
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
	public void setAcb35a(String acb35a) 
	{
		this.acb35a = acb35a;
	}
	/**
	 * 返回 签到人
	 * @return
	 */
	public String getAcb35a() 
	{
		return this.acb35a;
	}
	public void setAcb35b(java.util.Date acb35b) 
	{
		this.acb35b = acb35b;
	}
	/**
	 * 返回 签到时间
	 * @return
	 */
	public java.util.Date getAcb35b() 
	{
		return this.acb35b;
	}
	public void setAcb35c(String acb35c) 
	{
		this.acb35c = acb35c;
	}
	/**
	 * 返回 是否到场
	 * @return
	 */
	public String getAcb35c() 
	{
		return this.acb35c;
	}
	public void setAcb35k(String acb35k) 
	{
		this.acb35k = acb35k;
	}
	/**
	 * 返回 发放物品
	 * @return
	 */
	public String getAcb35k() 
	{
		return this.acb35k;
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
	public void setAcb355(Long acb355) 
	{
		this.acb355 = acb355;
	}
	/**
	 * 返回 计划招收人数
	 * @return
	 */
	public Long getAcb355() 
	{
		return this.acb355;
	}
	public void setAcb357(Long acb357) 
	{
		this.acb357 = acb357;
	}
	/**
	 * 返回 达成意向其中男性
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
	 * 返回 达成意向其中女性
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
	public void setAcb35e(String acb35e) 
	{
		this.acb35e = acb35e;
	}
	/**
	 * 返回 摊位安排状态
	 * @return
	 */
	public String getAcb35e() 
	{
		return this.acb35e;
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
	public void setAcb333(java.util.Date acb333) 
	{
		this.acb333 = acb333;
	}
	/**
	 * 返回 开始日期
	 * @return
	 */
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
	public java.util.Date getAcb334() 
	{
		return this.acb334;
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
	public void setBcb207(String bcb207) 
	{
		this.bcb207 = bcb207;
	}
	/**
	 * 返回 数据分类
	 * @return
	 */
	public String getBcb207() 
	{
		return this.bcb207;
	}
	public void setAce200(Long ace200) 
	{
		this.ace200 = ace200;
	}
	/**
	 * 返回 摊位预定编号
	 * @return
	 */
	public Long getAce200() 
	{
		return this.ace200;
	}
	public void setAab001(Long aab001) 
	{
		this.aab001 = aab001;
	}
	/**
	 * 返回 单位编号
	 * @return
	 */
	public Long getAab001() 
	{
		return this.aab001;
	}
	public void setAcb353(Float acb353) 
	{
		this.acb353 = acb353;
	}
	/**
	 * 返回 押金
	 * @return
	 */
	public Float getAcb353() 
	{
		return this.acb353;
	}
	public void setCcbs02(Long ccbs02) 
	{
		this.ccbs02 = ccbs02;
	}
	/**
	 * 返回 进场工作人员数
	 * @return
	 */
	public Long getCcbs02() 
	{
		return this.ccbs02;
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
	public void setAcb35h(Long acb35h) 
	{
		this.acb35h = acb35h;
	}
	/**
	 * 返回 报名人数
	 * @return
	 */
	public Long getAcb35h() 
	{
		return this.acb35h;
	}
	public void setAcb35i(Long acb35i) 
	{
		this.acb35i = acb35i;
	}
	/**
	 * 返回 报名人数其中男性
	 * @return
	 */
	public Long getAcb35i() 
	{
		return this.acb35i;
	}
	public void setAcb35j(Long acb35j) 
	{
		this.acb35j = acb35j;
	}
	/**
	 * 返回 报名人数其中女性
	 * @return
	 */
	public Long getAcb35j() 
	{
		return this.acb35j;
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
	public void setDiv001(Long div001) 
	{
		this.div001 = div001;
	}
	/**
	 * 返回 设备编号
	 * @return
	 */
	public Long getDiv001() 
	{
		return this.div001;
	}
	public void setCcbs04(String ccbs04) 
	{
		this.ccbs04 = ccbs04;
	}
	/**
	 * 返回 签到方式1-客户端人工签到2-自助刷会员卡签到3-自助会员账号签到4-自助订单号签到
	 * @return
	 */
	public String getCcbs04() 
	{
		return this.ccbs04;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof CorpEnter)) 
		{
			return false;
		}
		CorpEnter rhs = (CorpEnter) object;
		return new EqualsBuilder()
		.append(this.acb350, rhs.acb350)
		.append(this.acb200, rhs.acb200)
		.append(this.aab004, rhs.aab004)
		.append(this.acb330, rhs.acb330)
		.append(this.acb35a, rhs.acb35a)
		.append(this.acb35b, rhs.acb35b)
		.append(this.acb35c, rhs.acb35c)
		.append(this.acb35k, rhs.acb35k)
		.append(this.acb35d, rhs.acb35d)
		.append(this.acb355, rhs.acb355)
		.append(this.acb357, rhs.acb357)
		.append(this.acb358, rhs.acb358)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae022, rhs.aae022)
		.append(this.acb35e, rhs.acb35e)
		.append(this.acb331, rhs.acb331)
		.append(this.acb333, rhs.acb333)
		.append(this.acb334, rhs.acb334)
		.append(this.acb335, rhs.acb335)
		.append(this.bcb207, rhs.bcb207)
		.append(this.ace200, rhs.ace200)
		.append(this.aab001, rhs.aab001)
		.append(this.acb353, rhs.acb353)
		.append(this.ccbs02, rhs.ccbs02)
		.append(this.acb356, rhs.acb356)
		.append(this.acb35h, rhs.acb35h)
		.append(this.acb35i, rhs.acb35i)
		.append(this.acb35j, rhs.acb35j)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.div001, rhs.div001)
		.append(this.ccbs04, rhs.ccbs04)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.acb350) 
		.append(this.acb200) 
		.append(this.aab004) 
		.append(this.acb330) 
		.append(this.acb35a) 
		.append(this.acb35b) 
		.append(this.acb35c) 
		.append(this.acb35k) 
		.append(this.acb35d) 
		.append(this.acb355) 
		.append(this.acb357) 
		.append(this.acb358) 
		.append(this.aae013) 
		.append(this.aae011) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae022) 
		.append(this.acb35e) 
		.append(this.acb331) 
		.append(this.acb333) 
		.append(this.acb334) 
		.append(this.acb335) 
		.append(this.bcb207) 
		.append(this.ace200) 
		.append(this.aab001) 
		.append(this.acb353) 
		.append(this.ccbs02) 
		.append(this.acb356) 
		.append(this.acb35h) 
		.append(this.acb35i) 
		.append(this.acb35j) 
		.append(this.ccpr08) 
		.append(this.div001) 
		.append(this.ccbs04) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("acb350", this.acb350) 
		.append("acb200", this.acb200) 
		.append("aab004", this.aab004) 
		.append("acb330", this.acb330) 
		.append("acb35a", this.acb35a) 
		.append("acb35b", this.acb35b) 
		.append("acb35c", this.acb35c) 
		.append("acb35k", this.acb35k) 
		.append("acb35d", this.acb35d) 
		.append("acb355", this.acb355) 
		.append("acb357", this.acb357) 
		.append("acb358", this.acb358) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae022", this.aae022) 
		.append("acb35e", this.acb35e) 
		.append("acb331", this.acb331) 
		.append("acb333", this.acb333) 
		.append("acb334", this.acb334) 
		.append("acb335", this.acb335) 
		.append("bcb207", this.bcb207) 
		.append("ace200", this.ace200) 
		.append("aab001", this.aab001) 
		.append("acb353", this.acb353) 
		.append("ccbs02", this.ccbs02) 
		.append("acb356", this.acb356) 
		.append("acb35h", this.acb35h) 
		.append("acb35i", this.acb35i) 
		.append("acb35j", this.acb35j) 
		.append("ccpr08", this.ccpr08) 
		.append("div001", this.div001) 
		.append("ccbs04", this.ccbs04) 
		.toString();
	}
   
  

}