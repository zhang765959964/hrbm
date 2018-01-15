package com.xunfeng.business.personagency.storage.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.storage.model.WageStandard;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 工资标准表 Form对象
* @author:jiangxin
* @createDate 2016-08-17 11:06:20 
* @version V1.0   
*/
public class WageStandardForm extends BaseForm<WageStandard>
{
	// 主键id
	protected Long  id;
	// 档案id
	protected Long  archivesId;
	// 人员id
	protected Long  personId;
	// 姓名
	protected String  aac003;
	// 性别
	protected String  aac004;
	// 民族
	protected String  aac005;
	// 出生日期
	protected java.util.Date  aac006;
	// 参加工作时间
	protected java.util.Date  expStartJobDate;
	// 调整日期
	protected java.util.Date  adjustDate;
	// 现岗位职位工种
	protected String  positionType;
	// 调整前执行何工资制度
	protected String  ja01;
	// 调整后执行何工资制度
	protected String  jb01;
	// 调整前技能或等级工资级别
	protected String  ja02;
	// 调整后技能或等级工资级别
	protected String  jb02;
	// 调整前技能或等级工资额（元）
	protected String  ja03;
	// 调整后技能或等级工资额（元）
	protected String  jb03;
	// 调整前岗位级工资级别
	protected String  ja04;
	// 调整后岗位级工资级别
	protected String  jb04;
	// 调整前岗位级工资额（元）
	protected String  ja05;
	// 调整后岗位级工资额（元）
	protected String  jb05;
	// 调整前连动工资额
	protected String  ja06;
	// 调整后连动工资额
	protected String  jb06;
	// 调整前工龄工资额
	protected String  ja07;
	// 调整后工龄工资额
	protected String  jb07;
	// 调整前合计
	protected String  ja08;
	// 调整后合计
	protected String  jb08;
	// 升级前等级
	protected String  ja09;
	// 升级后等级
	protected String  jb09;
	// 升级前月工资标准
	protected String  ja10;
	// 升级后月工资标准
	protected String  jb10;
	// 经办人id
	protected Long  createrId;
	// 经办人
	protected String  createrName;
	// 经办机构id
	protected Long  createrOrgId;
	// 经办机构
	protected String  createrOrgName;
	// 经办日期
	protected java.util.Date  createrDate;
	// 文化程度
	protected String  aac011;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键id
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setArchivesId(Long archivesId) 
	{
		this.archivesId = archivesId;
	}
	/**
	 * 返回 档案id
	 * @return
	 */
	public Long getArchivesId() 
	{
		return this.archivesId;
	}
	public void setPersonId(Long personId) 
	{
		this.personId = personId;
	}
	/**
	 * 返回 人员id
	 * @return
	 */
	public Long getPersonId() 
	{
		return this.personId;
	}
	public void setAac003(String aac003) 
	{
		this.aac003 = aac003;
	}
	/**
	 * 返回 姓名
	 * @return
	 */
	public String getAac003() 
	{
		return this.aac003;
	}
	public void setAac004(String aac004) 
	{
		this.aac004 = aac004;
	}
	/**
	 * 返回 性别
	 * @return
	 */
	public String getAac004() 
	{
		return this.aac004;
	}
	public void setAac005(String aac005) 
	{
		this.aac005 = aac005;
	}
	/**
	 * 返回 民族
	 * @return
	 */
	public String getAac005() 
	{
		return this.aac005;
	}
	public void setAac006(java.util.Date aac006) 
	{
		this.aac006 = aac006;
	}
	/**
	 * 返回 出生日期
	 * @return
	 */
	public java.util.Date getAac006() 
	{
		return this.aac006;
	}
	public void setExpStartJobDate(java.util.Date expStartJobDate) 
	{
		this.expStartJobDate = expStartJobDate;
	}
	/**
	 * 返回 参加工作时间
	 * @return
	 */
	public java.util.Date getExpStartJobDate() 
	{
		return this.expStartJobDate;
	}
	public void setAdjustDate(java.util.Date adjustDate) 
	{
		this.adjustDate = adjustDate;
	}
	/**
	 * 返回 调整日期
	 * @return
	 */
	public java.util.Date getAdjustDate() 
	{
		return this.adjustDate;
	}
	public void setPositionType(String positionType) 
	{
		this.positionType = positionType;
	}
	/**
	 * 返回 现岗位职位工种
	 * @return
	 */
	public String getPositionType() 
	{
		return this.positionType;
	}
	public void setJa01(String ja01) 
	{
		this.ja01 = ja01;
	}
	/**
	 * 返回 调整前执行何工资制度
	 * @return
	 */
	public String getJa01() 
	{
		return this.ja01;
	}
	public void setJb01(String jb01) 
	{
		this.jb01 = jb01;
	}
	/**
	 * 返回 调整后执行何工资制度
	 * @return
	 */
	public String getJb01() 
	{
		return this.jb01;
	}
	public void setJa02(String ja02) 
	{
		this.ja02 = ja02;
	}
	/**
	 * 返回 调整前技能或等级工资级别
	 * @return
	 */
	public String getJa02() 
	{
		return this.ja02;
	}
	public void setJb02(String jb02) 
	{
		this.jb02 = jb02;
	}
	/**
	 * 返回 调整后技能或等级工资级别
	 * @return
	 */
	public String getJb02() 
	{
		return this.jb02;
	}
	public void setJa03(String ja03) 
	{
		this.ja03 = ja03;
	}
	/**
	 * 返回 调整前技能或等级工资额（元）
	 * @return
	 */
	public String getJa03() 
	{
		return this.ja03;
	}
	public void setJb03(String jb03) 
	{
		this.jb03 = jb03;
	}
	/**
	 * 返回 调整后技能或等级工资额（元）
	 * @return
	 */
	public String getJb03() 
	{
		return this.jb03;
	}
	public void setJa04(String ja04) 
	{
		this.ja04 = ja04;
	}
	/**
	 * 返回 调整前岗位级工资级别
	 * @return
	 */
	public String getJa04() 
	{
		return this.ja04;
	}
	public void setJb04(String jb04) 
	{
		this.jb04 = jb04;
	}
	/**
	 * 返回 调整后岗位级工资级别
	 * @return
	 */
	public String getJb04() 
	{
		return this.jb04;
	}
	public void setJa05(String ja05) 
	{
		this.ja05 = ja05;
	}
	/**
	 * 返回 调整前岗位级工资额（元）
	 * @return
	 */
	public String getJa05() 
	{
		return this.ja05;
	}
	public void setJb05(String jb05) 
	{
		this.jb05 = jb05;
	}
	/**
	 * 返回 调整后岗位级工资额（元）
	 * @return
	 */
	public String getJb05() 
	{
		return this.jb05;
	}
	public void setJa06(String ja06) 
	{
		this.ja06 = ja06;
	}
	/**
	 * 返回 调整前连动工资额
	 * @return
	 */
	public String getJa06() 
	{
		return this.ja06;
	}
	public void setJb06(String jb06) 
	{
		this.jb06 = jb06;
	}
	/**
	 * 返回 调整后连动工资额
	 * @return
	 */
	public String getJb06() 
	{
		return this.jb06;
	}
	public void setJa07(String ja07) 
	{
		this.ja07 = ja07;
	}
	/**
	 * 返回 调整前工龄工资额
	 * @return
	 */
	public String getJa07() 
	{
		return this.ja07;
	}
	public void setJb07(String jb07) 
	{
		this.jb07 = jb07;
	}
	/**
	 * 返回 调整后工龄工资额
	 * @return
	 */
	public String getJb07() 
	{
		return this.jb07;
	}
	public void setJa08(String ja08) 
	{
		this.ja08 = ja08;
	}
	/**
	 * 返回 调整前合计
	 * @return
	 */
	public String getJa08() 
	{
		return this.ja08;
	}
	public void setJb08(String jb08) 
	{
		this.jb08 = jb08;
	}
	/**
	 * 返回 调整后合计
	 * @return
	 */
	public String getJb08() 
	{
		return this.jb08;
	}
	public void setJa09(String ja09) 
	{
		this.ja09 = ja09;
	}
	/**
	 * 返回 升级前等级
	 * @return
	 */
	public String getJa09() 
	{
		return this.ja09;
	}
	public void setJb09(String jb09) 
	{
		this.jb09 = jb09;
	}
	/**
	 * 返回 升级后等级
	 * @return
	 */
	public String getJb09() 
	{
		return this.jb09;
	}
	public void setJa10(String ja10) 
	{
		this.ja10 = ja10;
	}
	/**
	 * 返回 升级前月工资标准
	 * @return
	 */
	public String getJa10() 
	{
		return this.ja10;
	}
	public void setJb10(String jb10) 
	{
		this.jb10 = jb10;
	}
	/**
	 * 返回 升级后月工资标准
	 * @return
	 */
	public String getJb10() 
	{
		return this.jb10;
	}
	public void setCreaterId(Long createrId) 
	{
		this.createrId = createrId;
	}
	/**
	 * 返回 经办人id
	 * @return
	 */
	public Long getCreaterId() 
	{
		return this.createrId;
	}
	public void setCreaterName(String createrName) 
	{
		this.createrName = createrName;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public String getCreaterName() 
	{
		return this.createrName;
	}
	public void setCreaterOrgId(Long createrOrgId) 
	{
		this.createrOrgId = createrOrgId;
	}
	/**
	 * 返回 经办机构id
	 * @return
	 */
	public Long getCreaterOrgId() 
	{
		return this.createrOrgId;
	}
	public void setCreaterOrgName(String createrOrgName) 
	{
		this.createrOrgName = createrOrgName;
	}
	/**
	 * 返回 经办机构
	 * @return
	 */
	public String getCreaterOrgName() 
	{
		return this.createrOrgName;
	}
	public void setCreaterDate(java.util.Date createrDate) 
	{
		this.createrDate = createrDate;
	}
	/**
	 * 返回 经办日期
	 * @return
	 */
	public java.util.Date getCreaterDate() 
	{
		return this.createrDate;
	}
	public void setAac011(String aac011) 
	{
		this.aac011 = aac011;
	}
	/**
	 * 返回 文化程度
	 * @return
	 */
	public String getAac011() 
	{
		return this.aac011;
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
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof WageStandardForm)) 
		{
			return false;
		}
		WageStandardForm rhs = (WageStandardForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.archivesId, rhs.archivesId)
		.append(this.personId, rhs.personId)
		.append(this.aac003, rhs.aac003)
		.append(this.aac004, rhs.aac004)
		.append(this.aac005, rhs.aac005)
		.append(this.aac006, rhs.aac006)
		.append(this.expStartJobDate, rhs.expStartJobDate)
		.append(this.adjustDate, rhs.adjustDate)
		.append(this.positionType, rhs.positionType)
		.append(this.ja01, rhs.ja01)
		.append(this.jb01, rhs.jb01)
		.append(this.ja02, rhs.ja02)
		.append(this.jb02, rhs.jb02)
		.append(this.ja03, rhs.ja03)
		.append(this.jb03, rhs.jb03)
		.append(this.ja04, rhs.ja04)
		.append(this.jb04, rhs.jb04)
		.append(this.ja05, rhs.ja05)
		.append(this.jb05, rhs.jb05)
		.append(this.ja06, rhs.ja06)
		.append(this.jb06, rhs.jb06)
		.append(this.ja07, rhs.ja07)
		.append(this.jb07, rhs.jb07)
		.append(this.ja08, rhs.ja08)
		.append(this.jb08, rhs.jb08)
		.append(this.ja09, rhs.ja09)
		.append(this.jb09, rhs.jb09)
		.append(this.ja10, rhs.ja10)
		.append(this.jb10, rhs.jb10)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.createrOrgId, rhs.createrOrgId)
		.append(this.createrOrgName, rhs.createrOrgName)
		.append(this.createrDate, rhs.createrDate)
		.append(this.aac011, rhs.aac011)
		.append(this.ccpr08, rhs.ccpr08)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.archivesId) 
		.append(this.personId) 
		.append(this.aac003) 
		.append(this.aac004) 
		.append(this.aac005) 
		.append(this.aac006) 
		.append(this.expStartJobDate) 
		.append(this.adjustDate) 
		.append(this.positionType) 
		.append(this.ja01) 
		.append(this.jb01) 
		.append(this.ja02) 
		.append(this.jb02) 
		.append(this.ja03) 
		.append(this.jb03) 
		.append(this.ja04) 
		.append(this.jb04) 
		.append(this.ja05) 
		.append(this.jb05) 
		.append(this.ja06) 
		.append(this.jb06) 
		.append(this.ja07) 
		.append(this.jb07) 
		.append(this.ja08) 
		.append(this.jb08) 
		.append(this.ja09) 
		.append(this.jb09) 
		.append(this.ja10) 
		.append(this.jb10) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.createrOrgId) 
		.append(this.createrOrgName) 
		.append(this.createrDate) 
		.append(this.aac011) 
		.append(this.ccpr08) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("archivesId", this.archivesId) 
		.append("personId", this.personId) 
		.append("aac003", this.aac003) 
		.append("aac004", this.aac004) 
		.append("aac005", this.aac005) 
		.append("aac006", this.aac006) 
		.append("expStartJobDate", this.expStartJobDate) 
		.append("adjustDate", this.adjustDate) 
		.append("positionType", this.positionType) 
		.append("ja01", this.ja01) 
		.append("jb01", this.jb01) 
		.append("ja02", this.ja02) 
		.append("jb02", this.jb02) 
		.append("ja03", this.ja03) 
		.append("jb03", this.jb03) 
		.append("ja04", this.ja04) 
		.append("jb04", this.jb04) 
		.append("ja05", this.ja05) 
		.append("jb05", this.jb05) 
		.append("ja06", this.ja06) 
		.append("jb06", this.jb06) 
		.append("ja07", this.ja07) 
		.append("jb07", this.jb07) 
		.append("ja08", this.ja08) 
		.append("jb08", this.jb08) 
		.append("ja09", this.ja09) 
		.append("jb09", this.jb09) 
		.append("ja10", this.ja10) 
		.append("jb10", this.jb10) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("createrOrgId", this.createrOrgId) 
		.append("createrOrgName", this.createrOrgName) 
		.append("createrDate", this.createrDate) 
		.append("aac011", this.aac011) 
		.append("ccpr08", this.ccpr08) 
		.toString();
	}
   
  

}