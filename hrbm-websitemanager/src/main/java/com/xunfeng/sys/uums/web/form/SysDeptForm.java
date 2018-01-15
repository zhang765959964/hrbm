package com.xunfeng.sys.uums.web.form;

import com.xunfeng.core.model.BaseForm;
import com.xunfeng.sys.uums.model.SysDept;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 科室表 Form对象
 * @author:liwenhao
 * @createDate 2016-06-20 17:27:14
 * @version V1.0
 */
public class SysDeptForm extends BaseForm<SysDept> {
	/**
*
*/
	private static final long serialVersionUID = 8401880515279996729L;
	// 编号
	protected Long dep001;
	// 科室名称
	protected String dep002;
	// 科室描述
	protected String dep003;
	// 科室排序序号
	protected Long dep004;
	// 科室所属机构
	protected Long acd200;

	// 经办人代码
	// 经办机构代码
	// 经办日期
	// 经办人
	// 经办机构
	public void setDep001(Long dep001) {
		this.dep001 = dep001;
	}

	/**
	 * 返回 编号
	 * 
	 * @return
	 */
	public Long getDep001() {
		return this.dep001;
	}

	public void setDep002(String dep002) {
		this.dep002 = dep002;
	}

	/**
	 * 返回 科室名称
	 * 
	 * @return
	 */
	public String getDep002() {
		return this.dep002;
	}

	public void setDep003(String dep003) {
		this.dep003 = dep003;
	}

	/**
	 * 返回 科室描述
	 * 
	 * @return
	 */
	public String getDep003() {
		return this.dep003;
	}

	public void setDep004(Long dep004) {
		this.dep004 = dep004;
	}

	/**
	 * 返回 科室排序序号
	 * 
	 * @return
	 */
	public Long getDep004() {
		return this.dep004;
	}

	public void setAcd200(Long acd200) {
		this.acd200 = acd200;
	}

	/**
	 * 返回 科室所属机构
	 * 
	 * @return
	 */
	public Long getAcd200() {
		return this.acd200;
	}
	
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof SysDeptForm)) {
			return false;
		}
		SysDeptForm rhs = (SysDeptForm) object;
		return new EqualsBuilder().append(this.dep001, rhs.dep001)
				.append(this.dep002, rhs.dep002)
				.append(this.dep003, rhs.dep003)
				.append(this.dep004, rhs.dep004)
				.append(this.acd200, rhs.acd200).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973).append(this.dep001)
				.append(this.dep002).append(this.dep003).append(this.dep004)
				.append(this.acd200).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("dep001", this.dep001)
				.append("dep002", this.dep002).append("dep003", this.dep003)
				.append("dep004", this.dep004).append("acd200", this.acd200)
				.toString();
	}

}