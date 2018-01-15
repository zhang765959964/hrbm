package com.xunfeng.business.corp.dto;

/**
 * Created by wxl on 2015/8/13.
 * 企业发起的面试邀请
 * V_CC22
 */
public class CorpInviteDto {
    //,--姓名
    private String aac003;
    // t.cca113,--工种备注  应聘职位
    private String cca113;
    //t_se.name "AAC004",--性别
    private String AAC004;
    //bac006,--年龄
    private Integer bac006;
    // t_ed.name "AAC011",--文化程度  学历
    private String AAC011;
    // to_char(t.aae036,'yyyy-mm-dd') AAE036,--经办日期   邀请时间
    private String AAE036;
    //数据来源
    private String bcc229n;
    // 个人是否查看
    private String ecpr10;
    //发起方式
    private String ecpr09;
    // .acc223,--推荐状态 反馈状态
    private String acc223;
    // .acc223,--推荐状态含义 反馈状态
    private String ECC223;
    //公民身份证号码
    private String aac002;

    //公司ID
    private Long aab001;

    public String getAac002() {
        return aac002;
    }

    public void setAac002(String aac002) {
        this.aac002 = aac002;
    }

    public Long getAab001() {
        return aab001;
    }

    public void setAab001(Long aab001) {
        this.aab001 = aab001;
    }

    public String getAac003() {
        return aac003;
    }

    public void setAac003(String aac003) {
        this.aac003 = aac003;
    }

    public String getAAC004() {
        return AAC004;
    }

    public void setAAC004(String AAC004) {
        this.AAC004 = AAC004;
    }

    public String getAAC011() {
        return AAC011;
    }

    public void setAAC011(String AAC011) {
        this.AAC011 = AAC011;
    }

    public String getAAE036() {
        return AAE036;
    }

    public void setAAE036(String AAE036) {
        this.AAE036 = AAE036;
    }

    public String getAcc223() {
        return acc223;
    }

    public void setAcc223(String acc223) {
        this.acc223 = acc223;
    }

    public Integer getBac006() {
        return bac006;
    }

    public void setBac006(Integer bac006) {
        this.bac006 = bac006;
    }

    public String getBcc229n() {
        return bcc229n;
    }

    public void setBcc229n(String bcc229n) {
        this.bcc229n = bcc229n;
    }

    public String getCca113() {
        return cca113;
    }

    public void setCca113(String cca113) {
        this.cca113 = cca113;
    }

    public String getECC223() {
        return ECC223;
    }

    public void setECC223(String ECC223) {
        this.ECC223 = ECC223;
    }

    public String getEcpr09() {
        return ecpr09;
    }

    public void setEcpr09(String ecpr09) {
        this.ecpr09 = ecpr09;
    }

    public String getEcpr10() {
        return ecpr10;
    }

    public void setEcpr10(String ecpr10) {
        this.ecpr10 = ecpr10;
    }
}
