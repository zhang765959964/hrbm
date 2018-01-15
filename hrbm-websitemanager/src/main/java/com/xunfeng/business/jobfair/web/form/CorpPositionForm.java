package com.xunfeng.business.jobfair.web.form;


import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.xunfeng.business.corp.model.CorpPosition;
import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseForm;

public class CorpPositionForm extends BaseForm<CorpPosition> {
	// 招聘空位编号
	protected Long acb210;
	// 招聘编号
	protected Long acb200;
	// 单位编号
	protected Long aab001;
	// 单位名称
	protected String aab004;
	// 职位说明
	protected String cca113;
	// 招聘人数
	protected Integer acb21r;
	// 月工资
	protected String acc034;
	// 信息发布方式
	protected String acb20q;
	// 工资待遇说明(工作性质)
	protected String acb21i;
	// 福利待遇
	protected String acc214 = "9";
	// 开始日期
	protected java.util.Date aae030;
	// 终止日期
	// 工种名称
	protected String aca112;
	// 形式工种代码
	protected String bca111;
	// 形式工种名称
	protected String bca112;
	// 文化程度
	protected String aac011;
	// 工作年限
	protected String acc217;
	//性别
	protected String aad004;
	// 工作地点代码
	// 工作地点2代码
	// 工作地点3代码
	// 冻结标记
	protected String acb208;
	// 经办人代码
	// 经办机构代码
	// 经办日期
	// 经办人
	// 经办机构
	// 机构行政区划代码
	// 面试地点

	// 工作地点名称
	protected String bcb202;
	// 工作地点2名称
	// 工作地点3名称
	// 审核标记
	// 审核时间
	protected java.util.Date abb771;
	// 审核人
	protected String abb769;
	// 审核机构
	protected String abb770;
	// 审核意见
	// 审核标记
	protected String abb773;

	// 岗位描述
	protected String cca114;
	// 用工形式
	// 劳动报酬
	// 是否招收优惠人员
	// 是否招收外来人员（工作环境）
	// 是否招收大龄人员

	// 数据来源0未知1网站2窗口
	// 最后修改时间
	// 刷新时间
	// 工种代码
	protected String aca111;

	public void setAcb210(Long acb210) {
		this.acb210 = acb210;
	}

	/**
	 * 返回 招聘空位编号
	 * 
	 * @return
	 */
	public Long getAcb210() {
		return this.acb210;
	}

	public void setAcb200(Long acb200) {
		this.acb200 = acb200;
	}
	
	public String getAad004() {
		return aad004;
	}

	public void setAad004(String aad004) {
		this.aad004 = aad004;
	}

	/**
	 * 返回 招聘编号
	 * 
	 * @return
	 */
	public Long getAcb200() {
		return this.acb200;
	}

	public void setAab001(Long aab001) {
		this.aab001 = aab001;
	}

	/**
	 * 返回 单位编号
	 * 
	 * @return
	 */
	public Long getAab001() {
		return this.aab001;
	}

	public void setAab004(String aab004) {
		this.aab004 = aab004;
	}

	/**
	 * 返回 单位名称
	 * 
	 * @return
	 */
	public String getAab004() {
		return this.aab004;
	}

	public void setAae030(java.util.Date aae030) {
		this.aae030 = aae030;
	}

	/**
	 * 返回 开始日期
	 * 
	 * @return
	 */
	@JsonSerialize(using = JsonDateSerializer.class)
	public java.util.Date getAae030() {
		return this.aae030;
	}

	public String getCca113() {
		return cca113;
	}

	public void setCca113(String cca113) {
		this.cca113 = cca113;
	}

	public Integer getAcb21r() {
		return acb21r;
	}

	public void setAcb21r(Integer acb21r) {
		this.acb21r = acb21r;
	}

	public String getAcc034() {
		return acc034;
	}

	public void setAcc034(String acc034) {
		this.acc034 = acc034;
	}

	public String getAcb20q() {
		return acb20q;
	}

	public void setAcb20q(String acb20q) {
		this.acb20q = acb20q;
	}

	public String getAcb21i() {
		return acb21i;
	}

	public void setAcb21i(String acb21i) {
		this.acb21i = acb21i;
	}

	public String getAcc214() {
		return acc214;
	}

	public void setAcc214(String acc214) {
		this.acc214 = acc214;
	}

	public String getAca112() {
		return aca112;
	}

	public void setAca112(String aca112) {
		this.aca112 = aca112;
	}

	public String getBca111() {
		return bca111;
	}

	public void setBca111(String bca111) {
		this.bca111 = bca111;
	}

	public String getBca112() {
		return bca112;
	}

	public void setBca112(String bca112) {
		this.bca112 = bca112;
	}

	public String getAac011() {
		return aac011;
	}

	public void setAac011(String aac011) {
		this.aac011 = aac011;
	}

	public String getAcc217() {
		return acc217;
	}

	public void setAcc217(String acc217) {
		this.acc217 = acc217;
	}

	public String getAcb208() {
		return acb208;
	}

	public void setAcb208(String acb208) {
		this.acb208 = acb208;
	}

	public String getBcb202() {
		return bcb202;
	}

	public void setBcb202(String bcb202) {
		this.bcb202 = bcb202;
	}

	public java.util.Date getAbb771() {
		return abb771;
	}

	public void setAbb771(java.util.Date abb771) {
		this.abb771 = abb771;
	}

	public String getAbb769() {
		return abb769;
	}

	public void setAbb769(String abb769) {
		this.abb769 = abb769;
	}

	public String getAbb770() {
		return abb770;
	}

	public void setAbb770(String abb770) {
		this.abb770 = abb770;
	}

	public String getAbb773() {
		return abb773;
	}

	public void setAbb773(String abb773) {
		this.abb773 = abb773;
	}

	public String getCca114() {
		return cca114;
	}

	public void setCca114(String cca114) {
		this.cca114 = cca114;
	}

	public String getAca111() {
		return aca111;
	}

	public void setAca111(String aca111) {
		this.aca111 = aca111;
	}
    
}