package com.xunfeng.business.dissupport.divice.web.form;
import com.xunfeng.business.dissupport.divice.model.Divice;
import com.xunfeng.core.model.BaseForm;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 设备表 Form对象
* @author:wanghan
* @createDate 2016-07-27 11:46:42 
* @version V1.0   
*/
public class SysDiviceForm extends BaseForm<Divice>
{
	// 设备表编号seq_sb_bh
	protected Long  div001;
	// 设备名称
	protected String  div002;
	// 所属机构
	protected Long  acd200;
	// 所属型号
	protected Long  mod001;
	// 设备管理员
	protected String  div003;
	// 联系电话
	protected String  div004;
	// 最后读取时间
	protected java.util.Date  div005;
	// 运行时间
	protected String  div006;
	// 摆放位置
	protected String  div007;
	// 设备状态（F-关闭T-运行）
	protected String  div008;
	// 设备开机时间
	protected java.util.Date  div009;
	// 备注
	protected String  aae013;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办时间
	protected java.util.Date  aae036;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	// 是否禁用（F-否T-是）
	protected String  div010;
	// 网络状态（F-不通T-通）
	protected String  div011;
	// 设备编号
	protected String  div012;
	// 中心样式编号
	protected Long  sty001;
	// 机构样式编号
	protected Long  sty002;
	// 摊位编号
	protected String  div013;
	// 类型
	protected Long  div014;
	// 视频路径
	protected String  div015;
	// 显示方式1-显示图片2-显示视频
	protected Long  div016;
	// 状态是否改变0-未变1-改变
	protected String  div017;
	// 机器码
	protected String  div018;
	// 授权码
	protected String  div019;
	// 显示样式1-通用2-单一岗位3-图片加文字4-视频加文字
	protected Long  div020;
	// 运行模式0-无1-招聘会模式2-户外模式3-面试模式只对发布屏设备有效
	protected Long  div021;
	// 公办机构墙上发布屏广告位更新标识 0:无更新 1:有更新
	protected Long  div022;
	public void setDiv001(Long div001) 
	{
		this.div001 = div001;
	}
	/**
	 * 返回 设备表编号seq_sb_bh
	 * @return
	 */
	public Long getDiv001() 
	{
		return this.div001;
	}
	public void setDiv002(String div002) 
	{
		this.div002 = div002;
	}
	/**
	 * 返回 设备名称
	 * @return
	 */
	public String getDiv002() 
	{
		return this.div002;
	}
	public void setAcd200(Long acd200) 
	{
		this.acd200 = acd200;
	}
	/**
	 * 返回 所属机构
	 * @return
	 */
	public Long getAcd200() 
	{
		return this.acd200;
	}
	public void setMod001(Long mod001) 
	{
		this.mod001 = mod001;
	}
	/**
	 * 返回 所属型号
	 * @return
	 */
	public Long getMod001() 
	{
		return this.mod001;
	}
	public void setDiv003(String div003) 
	{
		this.div003 = div003;
	}
	/**
	 * 返回 设备管理员
	 * @return
	 */
	public String getDiv003() 
	{
		return this.div003;
	}
	public void setDiv004(String div004) 
	{
		this.div004 = div004;
	}
	/**
	 * 返回 联系电话
	 * @return
	 */
	public String getDiv004() 
	{
		return this.div004;
	}
	public void setDiv005(java.util.Date div005) 
	{
		this.div005 = div005;
	}
	/**
	 * 返回 最后读取时间
	 * @return
	 */
	public java.util.Date getDiv005() 
	{
		return this.div005;
	}
	public void setDiv006(String div006) 
	{
		this.div006 = div006;
	}
	/**
	 * 返回 运行时间
	 * @return
	 */
	public String getDiv006() 
	{
		return this.div006;
	}
	public void setDiv007(String div007) 
	{
		this.div007 = div007;
	}
	/**
	 * 返回 摆放位置
	 * @return
	 */
	public String getDiv007() 
	{
		return this.div007;
	}
	public void setDiv008(String div008) 
	{
		this.div008 = div008;
	}
	/**
	 * 返回 设备状态（F-关闭T-运行）
	 * @return
	 */
	public String getDiv008() 
	{
		return this.div008;
	}
	public void setDiv009(java.util.Date div009) 
	{
		this.div009 = div009;
	}
	/**
	 * 返回 设备开机时间
	 * @return
	 */
	public java.util.Date getDiv009() 
	{
		return this.div009;
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
	 * 返回 经办时间
	 * @return
	 */
	public java.util.Date getAae036() 
	{
		return this.aae036;
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
	public void setDiv010(String div010) 
	{
		this.div010 = div010;
	}
	/**
	 * 返回 是否禁用（F-否T-是）
	 * @return
	 */
	public String getDiv010() 
	{
		return this.div010;
	}
	public void setDiv011(String div011) 
	{
		this.div011 = div011;
	}
	/**
	 * 返回 网络状态（F-不通T-通）
	 * @return
	 */
	public String getDiv011() 
	{
		return this.div011;
	}
	public void setDiv012(String div012) 
	{
		this.div012 = div012;
	}
	/**
	 * 返回 设备编号
	 * @return
	 */
	public String getDiv012() 
	{
		return this.div012;
	}
	public void setSty001(Long sty001) 
	{
		this.sty001 = sty001;
	}
	/**
	 * 返回 中心样式编号
	 * @return
	 */
	public Long getSty001() 
	{
		return this.sty001;
	}
	public void setSty002(Long sty002) 
	{
		this.sty002 = sty002;
	}
	/**
	 * 返回 机构样式编号
	 * @return
	 */
	public Long getSty002() 
	{
		return this.sty002;
	}
	public void setDiv013(String div013) 
	{
		this.div013 = div013;
	}
	/**
	 * 返回 摊位编号
	 * @return
	 */
	public String getDiv013() 
	{
		return this.div013;
	}
	public void setDiv014(Long div014) 
	{
		this.div014 = div014;
	}
	/**
	 * 返回 类型
	 * @return
	 */
	public Long getDiv014() 
	{
		return this.div014;
	}
	public void setDiv015(String div015) 
	{
		this.div015 = div015;
	}
	/**
	 * 返回 视频路径
	 * @return
	 */
	public String getDiv015() 
	{
		return this.div015;
	}
	public void setDiv016(Long div016) 
	{
		this.div016 = div016;
	}
	/**
	 * 返回 显示方式1-显示图片2-显示视频
	 * @return
	 */
	public Long getDiv016() 
	{
		return this.div016;
	}
	public void setDiv017(String div017) 
	{
		this.div017 = div017;
	}
	/**
	 * 返回 状态是否改变0-未变1-改变
	 * @return
	 */
	public String getDiv017() 
	{
		return this.div017;
	}
	public void setDiv018(String div018) 
	{
		this.div018 = div018;
	}
	/**
	 * 返回 机器码
	 * @return
	 */
	public String getDiv018() 
	{
		return this.div018;
	}
	public void setDiv019(String div019) 
	{
		this.div019 = div019;
	}
	/**
	 * 返回 授权码
	 * @return
	 */
	public String getDiv019() 
	{
		return this.div019;
	}
	public void setDiv020(Long div020) 
	{
		this.div020 = div020;
	}
	/**
	 * 返回 显示样式1-通用2-单一岗位3-图片加文字4-视频加文字
	 * @return
	 */
	public Long getDiv020() 
	{
		return this.div020;
	}
	public void setDiv021(Long div021) 
	{
		this.div021 = div021;
	}
	/**
	 * 返回 运行模式0-无1-招聘会模式2-户外模式3-面试模式只对发布屏设备有效
	 * @return
	 */
	public Long getDiv021() 
	{
		return this.div021;
	}
	public void setDiv022(Long div022) 
	{
		this.div022 = div022;
	}
	/**
	 * 返回 公办机构墙上发布屏广告位更新标识 0:无更新 1:有更新
	 * @return
	 */
	public Long getDiv022() 
	{
		return this.div022;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SysDiviceForm)) 
		{
			return false;
		}
		SysDiviceForm rhs = (SysDiviceForm) object;
		return new EqualsBuilder()
		.append(this.div001, rhs.div001)
		.append(this.div002, rhs.div002)
		.append(this.acd200, rhs.acd200)
		.append(this.mod001, rhs.mod001)
		.append(this.div003, rhs.div003)
		.append(this.div004, rhs.div004)
		.append(this.div005, rhs.div005)
		.append(this.div006, rhs.div006)
		.append(this.div007, rhs.div007)
		.append(this.div008, rhs.div008)
		.append(this.div009, rhs.div009)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.div010, rhs.div010)
		.append(this.div011, rhs.div011)
		.append(this.div012, rhs.div012)
		.append(this.sty001, rhs.sty001)
		.append(this.sty002, rhs.sty002)
		.append(this.div013, rhs.div013)
		.append(this.div014, rhs.div014)
		.append(this.div015, rhs.div015)
		.append(this.div016, rhs.div016)
		.append(this.div017, rhs.div017)
		.append(this.div018, rhs.div018)
		.append(this.div019, rhs.div019)
		.append(this.div020, rhs.div020)
		.append(this.div021, rhs.div021)
		.append(this.div022, rhs.div022)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.div001) 
		.append(this.div002) 
		.append(this.acd200) 
		.append(this.mod001) 
		.append(this.div003) 
		.append(this.div004) 
		.append(this.div005) 
		.append(this.div006) 
		.append(this.div007) 
		.append(this.div008) 
		.append(this.div009) 
		.append(this.aae013) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.div010) 
		.append(this.div011) 
		.append(this.div012) 
		.append(this.sty001) 
		.append(this.sty002) 
		.append(this.div013) 
		.append(this.div014) 
		.append(this.div015) 
		.append(this.div016) 
		.append(this.div017) 
		.append(this.div018) 
		.append(this.div019) 
		.append(this.div020) 
		.append(this.div021) 
		.append(this.div022) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("div001", this.div001) 
		.append("div002", this.div002) 
		.append("acd200", this.acd200) 
		.append("mod001", this.mod001) 
		.append("div003", this.div003) 
		.append("div004", this.div004) 
		.append("div005", this.div005) 
		.append("div006", this.div006) 
		.append("div007", this.div007) 
		.append("div008", this.div008) 
		.append("div009", this.div009) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("div010", this.div010) 
		.append("div011", this.div011) 
		.append("div012", this.div012) 
		.append("sty001", this.sty001) 
		.append("sty002", this.sty002) 
		.append("div013", this.div013) 
		.append("div014", this.div014) 
		.append("div015", this.div015) 
		.append("div016", this.div016) 
		.append("div017", this.div017) 
		.append("div018", this.div018) 
		.append("div019", this.div019) 
		.append("div020", this.div020) 
		.append("div021", this.div021) 
		.append("div022", this.div022) 
		.toString();
	}
   
  

}