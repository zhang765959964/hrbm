package com.xunfeng.business.corp.dto;

/**
 * Created by wxl on 2015/8/12.
 * v_cc22
 * 推荐匹配信息表视图
 */
public class CorpRecommendResumeDto {
     //姓名
    private String aac003;
    // cc.bcc20c,--意愿工种描述 求职意向
    private String bcc20c;
    //  t.cca113,--工种备注  匹配职位
    private String cca113;
    //性别名称
    private String AAC004;
    //性别代码
    private String aac004n;
    //年龄
    private Integer bac006;
    //t_ed.name "AAC011",--文化程度  学历
    private String AAC011;
    //学历代码
    private String aac011n;
    // to_char(t.aae036,'yyyy-mm-dd') AAE036,--经办日期 匹配时间
    private String AAE036;
    //数据来源
    private String bcc229;
    //数据来源名称
    private String bcc229n;
    //decode(t.ccpr09,'2',decode(p3.ccps04,0,'未查看','已查看'),'5',decode(p3.ccps04,0,'未查看','已查看'),'12',decode(p3.ccps04,0,'未查看','已查看'),'3',decode(t.ccpr10,0,'未查看','已查看'),'6',decode(t.ccpr10,0,'未查看','已查看'),'13',decode(t.ccpr10,0,'未查看','已查看'),'
    // 14',decode(t.ccpr10,0,'未查看','已查看')) as ecpr10, --因发起方不同，不同的查看方   查看
    private String ecpr10;
    private String ccpr10;
    //t.,--推荐状态 acc223  反馈状态 0未反馈
    private String acc223;
    //ECC223
    private String ECC223;

    //公民身份证号码
    private String aac002;

    //公司编号
    private Long aab001;

    public String getECC223() {
        return ECC223;
    }

    public void setECC223(String ECC223) {
        this.ECC223 = ECC223;
    }

    public Long getAab001() {
        return aab001;
    }

    public void setAab001(Long aab001) {
        this.aab001 = aab001;
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

    public String getAAC004() {
        return AAC004;
    }

    public void setAAC004(String AAC004) {
        this.AAC004 = AAC004;
    }

    public String getAac004n() {
        return aac004n;
    }

    public void setAac004n(String aac004n) {
        this.aac004n = aac004n;
    }

    public String getAAC011() {
        return AAC011;
    }

    public void setAAC011(String AAC011) {
        this.AAC011 = AAC011;
    }

    public String getAac011n() {
        return aac011n;
    }

    public void setAac011n(String aac011n) {
        this.aac011n = aac011n;
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

    public String getBcc20c() {
        return bcc20c;
    }

    public void setBcc20c(String bcc20c) {
        this.bcc20c = bcc20c;
    }

    public String getBcc229() {
        return bcc229;
    }

    public void setBcc229(String bcc229) {
        this.bcc229 = bcc229;
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

    public String getEcpr10() {
        return ecpr10;
    }

    public void setEcpr10(String ecpr10) {
        this.ecpr10 = ecpr10;
    }
}
