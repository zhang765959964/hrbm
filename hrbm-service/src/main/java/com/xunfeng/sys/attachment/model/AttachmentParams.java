package com.xunfeng.sys.attachment.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: PIC_UPLOAD Model对象
* @author:wanghan
* @createDate 2016-04-18 16:53:33 
* @version V1.0   
*/
public class AttachmentParams extends BaseModel
{
	// ID
	protected Long  id;
	// P001
	protected String  p001;
	// P002
	protected String  p002;
	// P003
	protected String  p003;
	// P004
	protected String  p004;
	// P005
	protected String  p005;
	// P006
	protected Long  p006;
	// P007
	protected Long  p007;
	// P008
	protected Long  p008;
	// P009
	protected Long  p009;
	// P010
	protected String  p010;
	// P011
	protected Long  p011;
	// P012
	protected String  p012;
	// P013
	protected String  p013;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 ID
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setP001(String p001) 
	{
		this.p001 = p001;
	}
	/**
	 * 返回 P001
	 * @return
	 */
	public String getP001() 
	{
		return this.p001;
	}
	public void setP002(String p002) 
	{
		this.p002 = p002;
	}
	/**
	 * 返回 P002
	 * @return
	 */
	public String getP002() 
	{
		return this.p002;
	}
	public void setP003(String p003) 
	{
		this.p003 = p003;
	}
	/**
	 * 返回 P003
	 * @return
	 */
	public String getP003() 
	{
		return this.p003;
	}
	public void setP004(String p004) 
	{
		this.p004 = p004;
	}
	/**
	 * 返回 P004
	 * @return
	 */
	public String getP004() 
	{
		return this.p004;
	}
	public void setP005(String p005) 
	{
		this.p005 = p005;
	}
	/**
	 * 返回 P005
	 * @return
	 */
	public String getP005() 
	{
		return this.p005;
	}
	public void setP006(Long p006) 
	{
		this.p006 = p006;
	}
	/**
	 * 返回 P006
	 * @return
	 */
	public Long getP006() 
	{
		return this.p006;
	}
	public void setP007(Long p007) 
	{
		this.p007 = p007;
	}
	/**
	 * 返回 P007
	 * @return
	 */
	public Long getP007() 
	{
		return this.p007;
	}
	public void setP008(Long p008) 
	{
		this.p008 = p008;
	}
	/**
	 * 返回 P008
	 * @return
	 */
	public Long getP008() 
	{
		return this.p008;
	}
	public void setP009(Long p009) 
	{
		this.p009 = p009;
	}
	/**
	 * 返回 P009
	 * @return
	 */
	public Long getP009() 
	{
		return this.p009;
	}
	public void setP010(String p010) 
	{
		this.p010 = p010;
	}
	/**
	 * 返回 P010
	 * @return
	 */
	public String getP010() 
	{
		return this.p010;
	}
	public void setP011(Long p011) 
	{
		this.p011 = p011;
	}
	/**
	 * 返回 P011
	 * @return
	 */
	public Long getP011() 
	{
		return this.p011;
	}
	public void setP012(String p012) 
	{
		this.p012 = p012;
	}
	/**
	 * 返回 P012
	 * @return
	 */
	public String getP012() 
	{
		return this.p012;
	}
	public void setP013(String p013) 
	{
		this.p013 = p013;
	}
	/**
	 * 返回 P013
	 * @return
	 */
	public String getP013() 
	{
		return this.p013;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof AttachmentParams)) 
		{
			return false;
		}
		AttachmentParams rhs = (AttachmentParams) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.p001, rhs.p001)
		.append(this.p002, rhs.p002)
		.append(this.p003, rhs.p003)
		.append(this.p004, rhs.p004)
		.append(this.p005, rhs.p005)
		.append(this.p006, rhs.p006)
		.append(this.p007, rhs.p007)
		.append(this.p008, rhs.p008)
		.append(this.p009, rhs.p009)
		.append(this.p010, rhs.p010)
		.append(this.p011, rhs.p011)
		.append(this.p012, rhs.p012)
		.append(this.p013, rhs.p013)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.p001) 
		.append(this.p002) 
		.append(this.p003) 
		.append(this.p004) 
		.append(this.p005) 
		.append(this.p006) 
		.append(this.p007) 
		.append(this.p008) 
		.append(this.p009) 
		.append(this.p010) 
		.append(this.p011) 
		.append(this.p012) 
		.append(this.p013) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("p001", this.p001) 
		.append("p002", this.p002) 
		.append("p003", this.p003) 
		.append("p004", this.p004) 
		.append("p005", this.p005) 
		.append("p006", this.p006) 
		.append("p007", this.p007) 
		.append("p008", this.p008) 
		.append("p009", this.p009) 
		.append("p010", this.p010) 
		.append("p011", this.p011) 
		.append("p012", this.p012) 
		.append("p013", this.p013) 
		.toString();
	}
   
  

}