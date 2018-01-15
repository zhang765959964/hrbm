package com.xunfeng.business.corp.dto;

import java.io.Serializable;

/**
 * Created by wxl on 2015/8/11.
 * 企业下载简历情况视图  v_ccp09
 */
public class CorpResumeDownDto implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//企业下载简历编号
    private Long ccpd01;
    //企业编号
    private Long ccmc01;
    //个人编号
    private Long ccmp01;
    //个人身份证号
    private String aac002;
    //姓名
    private String aac003;
    //性别
    private String aac004;
    //eac004姓名名称
    private String eac004;
    //文化程度
    private String aac011;
    //文化程度名称
    private String eac011;
    //所在地区
    private String aab301;
    //单位行政区划名称
    private String aaa021;
    //多个意向工种连接显示
    private String aca112;
    //多个工种别名连接显示
    private String acaa12;
    //第三意向工种名称
    private String acab12;
    //下载时间
    private String CCPD02;
    //单位名称
    private String aab004;
    //单位性质
    private String aab019;
    //行业代码
    private String ccpr10;
    //行业名称
    private String eab019;
    //联系人
    private String aae004;
    //联系电话
    private String aae005;
    //年龄
    private Integer bac006;
    //查看状态
    private String ecpr10;
    //查看状态代码
    private String ecpr10_code;

    //是否发送面试邀请
    private String ccps01;
    //是否删除状态（0-否1-是）m
    private String ccpr08;
    //地址
    private String aae006;
    //图片地址
    private String ccmu15;
    

    public String getCcmu15() {
		return ccmu15;
	}

	public void setCcmu15(String ccmu15) {
		this.ccmu15 = ccmu15;
	}

	public Integer getBac006() {
        return bac006;
    }

    public void setBac006(Integer bac006) {
        this.bac006 = bac006;
    }

    public String getAaa021() {
        return aaa021;
    }

    public void setAaa021(String aaa021) {
        this.aaa021 = aaa021;
    }

    public String getAab004() {
        return aab004;
    }

    public void setAab004(String aab004) {
        this.aab004 = aab004;
    }

    public String getAab019() {
        return aab019;
    }

    public void setAab019(String aab019) {
        this.aab019 = aab019;
    }

    public String getAab301() {
        return aab301;
    }

    public void setAab301(String aab301) {
        this.aab301 = aab301;
    }

    public String getAac002() {
        return aac002;
    }

    public void setAac002(String aac002) {
        this.aac002 = aac002;
    }

    public String getAac003() {
        return aac003;
    }

    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }

    public String getAac004() {
        return aac004;
    }

    public void setAac004(String aac004) {
        this.aac004 = aac004;
    }

    public String getAac011() {
        return aac011;
    }

    public void setAac011(String aac011) {
        this.aac011 = aac011;
    }

    public String getAae004() {
        return aae004;
    }

    public void setAae004(String aae004) {
        this.aae004 = aae004;
    }

    public String getAae005() {
        return aae005;
    }

    public void setAae005(String aae005) {
        this.aae005 = aae005;
    }

    public String getAae006() {
        return aae006;
    }

    public void setAae006(String aae006) {
        this.aae006 = aae006;
    }

    public String getAca112() {
        return aca112;
    }

    public void setAca112(String aca112) {
        this.aca112 = aca112;
    }

    public String getAcaa12() {
        return acaa12;
    }

    public void setAcaa12(String acaa12) {
        this.acaa12 = acaa12;
    }

    public String getAcab12() {
        return acab12;
    }

    public void setAcab12(String acab12) {
        this.acab12 = acab12;
    }

    public Long getCcmc01() {
        return ccmc01;
    }

    public void setCcmc01(Long ccmc01) {
        this.ccmc01 = ccmc01;
    }

    public Long getCcmp01() {
        return ccmp01;
    }

    public void setCcmp01(Long ccmp01) {
        this.ccmp01 = ccmp01;
    }

    public Long getCcpd01() {
        return ccpd01;
    }

    public void setCcpd01(Long ccpd01) {
        this.ccpd01 = ccpd01;
    }

    public String getCCPD02() {
        return CCPD02;
    }

    public void setCCPD02(String CCPD02) {
        this.CCPD02 = CCPD02;
    }

    public String getCcpr08() {
        return ccpr08;
    }

    public void setCcpr08(String ccpr08) {
        this.ccpr08 = ccpr08;
    }

    public String getCcpr10() {
        return ccpr10;
    }

    public void setCcpr10(String ccpr10) {
        this.ccpr10 = ccpr10;
    }

    public String getCcps01() {
        return ccps01;
    }

    public void setCcps01(String ccps01) {
        this.ccps01 = ccps01;
    }

    public String getEab019() {
        return eab019;
    }

    public void setEab019(String eab019) {
        this.eab019 = eab019;
    }

    public String getEac004() {
        return eac004;
    }

    public void setEac004(String eac004) {
        this.eac004 = eac004;
    }

    public String getEac011() {
        return eac011;
    }

    public void setEac011(String eac011) {
        this.eac011 = eac011;
    }

    public String getEcpr10() {
        return ecpr10;
    }

    public void setEcpr10(String ecpr10) {
        this.ecpr10 = ecpr10;
    }

    public String getEcpr10_code() {
        return ecpr10_code;
    }

    public void setEcpr10_code(String ecpr10_code) {
        this.ecpr10_code = ecpr10_code;
    }
}
