package com.xunfeng.business.person.dto;

/**
 * Created by wxl on 2015/8/13.
 * 查看个人收到的面试邀请视图
 * v_ccp03
 */
public class PersonInvitedDto {
    //面试邀请自动编号
    private Long ccps01;
    //企业编号
    private Long ccmc01;
    //个人编号
    private Long ccmp01;
   // 姓名
    private String aac003;
    // 性别
    private String aac004;
    // 性别name
    private String eac004;
    // 文化程度
    private String aac011;
    // 文化程度name
    private String eac011;
    // 所在地区
    private String aab301;
    // 多个意向工种连接显示
    private String aca112;
    // 多个工种别名连接显示
    private String acaa12;
    // 第三意向工种名称
    private String acab12;
    // 职位编号
    private Long acb210;
    // 职位名称
    private String eca112;
    // 工种别名
    private String  cca113;
    // 邀请日期
    private String CCPS02;
    //面试日期及内容
    private String ccps03;
    //用户是否查看
    private String ccps04;
    //用户是否查看(0-未查看1-已查看)
    private String ECCPS04;
    //冻结标记
    private String acb208;
    //冻结标记0,'发布中',1,'已过期')
    private String ecb208;
    //审核标记
    private String abb773;
    //审核标记0,'未审核',1,'已审核'
    private String ebb773;
    //企业备注
    private String ccps06;
    //形式岗位名称
    private String bca112;
    //招聘开始日期
    private String aae030;
    //招聘终止日期
    private String aae031;
    //月工资
    private String acc034;
    //月工资name
    private String ecc034;
    //工作地区
    private String bcb202;

    //单位名称
    private String aab004;
    //联系人
    private String aae004;
    //联系电话
    private String aae005;
    //是否删除状态（0-否1-是）
    private String ccpr08;
    //地址
    private String aae007;
    //是否开通地图
    private String CABQ01n;
    //是否开通地图
    private String cabq01;
    // X坐标
    protected Float  cabq02;
    // Y坐标
    protected Float  cabq03;
    // 缩放比例
    protected Long  cabq04;
    //年龄
    private Integer personAge;

    public Integer getPersonAge() {
        return personAge;
    }

    public void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }

    public String getAab004() {
        return aab004;
    }

    public void setAab004(String aab004) {
        this.aab004 = aab004;
    }

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

    public String getAae007() {
        return aae007;
    }

    public void setAae007(String aae007) {
        this.aae007 = aae007;
    }

    public String getAae030() {
        return aae030;
    }

    public void setAae030(String aae030) {
        this.aae030 = aae030;
    }

    public String getAae031() {
        return aae031;
    }

    public void setAae031(String aae031) {
        this.aae031 = aae031;
    }

    public String getAbb773() {
        return abb773;
    }

    public void setAbb773(String abb773) {
        this.abb773 = abb773;
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

    public String getAcb208() {
        return acb208;
    }

    public void setAcb208(String acb208) {
        this.acb208 = acb208;
    }

    public Long getAcb210() {
        return acb210;
    }

    public void setAcb210(Long acb210) {
        this.acb210 = acb210;
    }

    public String getAcc034() {
        return acc034;
    }

    public void setAcc034(String acc034) {
        this.acc034 = acc034;
    }

    public String getBca112() {
        return bca112;
    }

    public void setBca112(String bca112) {
        this.bca112 = bca112;
    }

    public String getBcb202() {
        return bcb202;
    }

    public void setBcb202(String bcb202) {
        this.bcb202 = bcb202;
    }

    public String getCabq01() {
        return cabq01;
    }

    public void setCabq01(String cabq01) {
        this.cabq01 = cabq01;
    }

    public String getCABQ01n() {
        return CABQ01n;
    }

    public void setCABQ01n(String CABQ01n) {
        this.CABQ01n = CABQ01n;
    }

    public Float getCabq02() {
        return cabq02;
    }

    public void setCabq02(Float cabq02) {
        this.cabq02 = cabq02;
    }

    public Float getCabq03() {
        return cabq03;
    }

    public void setCabq03(Float cabq03) {
        this.cabq03 = cabq03;
    }

    public Long getCabq04() {
        return cabq04;
    }

    public void setCabq04(Long cabq04) {
        this.cabq04 = cabq04;
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

    public String getCcpr08() {
        return ccpr08;
    }

    public void setCcpr08(String ccpr08) {
        this.ccpr08 = ccpr08;
    }

    public Long getCcps01() {
        return ccps01;
    }

    public void setCcps01(Long ccps01) {
        this.ccps01 = ccps01;
    }

    public String getCCPS02() {
        return CCPS02;
    }

    public void setCCPS02(String CCPS02) {
        this.CCPS02 = CCPS02;
    }

    public String getCcps03() {
        return ccps03;
    }

    public void setCcps03(String ccps03) {
        this.ccps03 = ccps03;
    }

    public String getCcps04() {
        return ccps04;
    }

    public void setCcps04(String ccps04) {
        this.ccps04 = ccps04;
    }

    public String getCcps06() {
        return ccps06;
    }

    public void setCcps06(String ccps06) {
        this.ccps06 = ccps06;
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

    public String getEbb773() {
        return ebb773;
    }

    public void setEbb773(String ebb773) {
        this.ebb773 = ebb773;
    }

    public String getCca113() {
        return cca113;
    }

    public void setCca113(String cca113) {
        this.cca113 = cca113;
    }

    public String getEca112() {
        return eca112;
    }

    public void setEca112(String eca112) {
        this.eca112 = eca112;
    }

    public String getEcb208() {
        return ecb208;
    }

    public void setEcb208(String ecb208) {
        this.ecb208 = ecb208;
    }

    public String getEcc034() {
        return ecc034;
    }

    public void setEcc034(String ecc034) {
        this.ecc034 = ecc034;
    }

    public String getECCPS04() {
        return ECCPS04;
    }

    public void setECCPS04(String ECCPS04) {
        this.ECCPS04 = ECCPS04;
    }
}
