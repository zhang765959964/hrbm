package com.xunfeng.business.corp.dto;

/**
 * Created by wxl on 2015/8/12.
 * v_ccp08 企业人才收藏夹表视图
 */
public class CorpTalentFavoritesDto {
    //企业人才收藏夹自动编号
    private Long ccpg01;
    //企业编号
    private Long ccmc01;
    //个人编号
    private Long ccmp01;
    //收藏日期
    private String CCPG02;
    //姓名
    private String aac003;
    //性别
    private String aac004;
    //年龄
    private Integer  bac006;
    //性别名称
    private  String eac004;
    //文化程度
    private String aac011;
    //文化程度名称
    private String eac011;
    //所在地区
    private String aab301;
    //是否删除状态 0-否1-是）
    private String ccpr08;
    //查看状态
    private String ecpr10;
    //多个意向工种连接显示
    private String aca112;
    //多个工种别名连接显示
    private String acaa12;
    //第三意向工种名称
    private String acab12;

    public String getAab301() {
        return aab301;
    }

    public void setAab301(String aab301) {
        this.aab301 = aab301;
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

    public Integer getBac006() {
        return bac006;
    }

    public void setBac006(Integer bac006) {
        this.bac006 = bac006;
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

    public Long getCcpg01() {
        return ccpg01;
    }

    public void setCcpg01(Long ccpg01) {
        this.ccpg01 = ccpg01;
    }

    public String getCCPG02() {
        return CCPG02;
    }

    public void setCCPG02(String CCPG02) {
        this.CCPG02 = CCPG02;
    }

    public String getCcpr08() {
        return ccpr08;
    }

    public void setCcpr08(String ccpr08) {
        this.ccpr08 = ccpr08;
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
}
