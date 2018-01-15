package com.xunfeng.business.corp.dto;

import java.io.Serializable;

/**
 * Created by wxl on 2015/8/11.
 * 企业收到的简历
 * v_ccp04  视图
 * 显示的职位的时候用形式工种名称
 */
public class CorpReceivedResumeDto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//职位申请自动编号
    private Long ccpj01;
    //nvl(cc.acc220,0) as acc220,--匹配编号 Table cc22
    private Long acc220;
    //身份证号
    private String aac002;
    //--用户信息表自动编号
    private Long ccmu01;
    //形式工种代码
    private String bca111;
    //形式工种名称
    private String bca112;
    //姓名
    private String aac003;
    //性别
    private String aac004;
    //性别名称
    private String eac004;
    //年龄
    private Integer bac006;
    //文化程度
    private String aac011;
    //文化程度名称
    private String eac011;
    //-所在地区
    private String aab301;
    //职位编号
    private Long acb210;
    //职位名称
    private String eca112;
    //职位别名
    private String cca113;
    //招聘人数
    private Integer acb21r;
    //单位编号
    private Long aab001;
    //单位名称
    private String aab004;
    //招聘开始日期
    private String aae030;
    //招聘终止日期
    private String aae031;
    //月工资
    private String acc034;
    //月工资 名称
    private String ecc034;
    //工作地区
    private String bcb202;
    //冻结标记
    private String acb208;
    //冻结名称
    private String ecb208;
    //职位删除标记
    private String ecpr08;
    //审核标记
    private String abb773;
    //招聘套餐
    private String acb201;
    //审核名称
    private String ebb773;
    //申请日期
    private String CCPJ02;
    // 是否已查看0-未查看1-已查看
    private Long  ccpj03;
    //是否已查看 名称
    private String eccpj03;
    //是否删除状态（0-否1-是）
    private String ccpr08;
    //数据来源
    private String cczy06;
    //数据来源名称
    private String cczy06n;
   //推荐方式
    private String ccpr09;
    //个人备注
    private String ccpj04;
    //是否发送面试邀请 名称
    private String ccps01;
    //否发送面试邀请
    private String ccps01n;
    //反馈状态
    private String acc223;
    //反馈状态 名称
    private String acc223n;
    //是否开通地图  名称
    private String cabq01n;
    // 是否开通地图
    protected Long  cabq01;
    // X坐标
    protected Float  cabq02;
    // Y坐标
    protected Float  cabq03;
    // 缩放比例
    protected Long  cabq04;
    //图像地址
    protected String ccmu15;
    //企业是否查看了简历
    protected String ccpj03Name;
    
    protected String sexName;
    
    protected String collectionStatus;
    //个人编号
    protected Long aac001;
    
    
    
    
    public Long getAac001() {
		return aac001;
	}

	public void setAac001(Long aac001) {
		this.aac001 = aac001;
	}

	public String getCollectionStatus() {
		return collectionStatus;
	}

	public void setCollectionStatus(String collectionStatus) {
		this.collectionStatus = collectionStatus;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getCcpj03Name() {
		return ccpj03Name;
	}

	public void setCcpj03Name(String ccpj03Name) {
		this.ccpj03Name = ccpj03Name;
	}
	
	
	public String getCcmu15() {
		return ccmu15;
	}

	public void setCcmu15(String ccmu15) {
		this.ccmu15 = ccmu15;
	}

	public Long getAab001() {
        return aab001;
    }

    public void setAab001(Long aab001) {
        this.aab001 = aab001;
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

    public String getAcb201() {
        return acb201;
    }

    public void setAcb201(String acb201) {
        this.acb201 = acb201;
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

    public Long getAcc220() {
        return acc220;
    }

    public void setAcc220(Long acc220) {
        this.acc220 = acc220;
    }

    public String getAcc223() {
        return acc223;
    }

    public void setAcc223(String acc223) {
        this.acc223 = acc223;
    }

    public String getAcc223n() {
        return acc223n;
    }

    public void setAcc223n(String acc223n) {
        this.acc223n = acc223n;
    }

    public Integer getBac006() {
        return bac006;
    }

    public void setBac006(Integer bac006) {
        this.bac006 = bac006;
    }

    public String getBcb202() {
        return bcb202;
    }

    public void setBcb202(String bcb202) {
        this.bcb202 = bcb202;
    }

    public Long getCabq01() {
        return cabq01;
    }

    public void setCabq01(Long cabq01) {
        this.cabq01 = cabq01;
    }

    public String getCabq01n() {
        return cabq01n;
    }

    public void setCabq01n(String cabq01n) {
        this.cabq01n = cabq01n;
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

    public String getCca113() {
        return cca113;
    }

    public void setCca113(String cca113) {
        this.cca113 = cca113;
    }

    public Long getCcmu01() {
        return ccmu01;
    }

    public void setCcmu01(Long ccmu01) {
        this.ccmu01 = ccmu01;
    }

    public Long getCcpj01() {
        return ccpj01;
    }

    public void setCcpj01(Long ccpj01) {
        this.ccpj01 = ccpj01;
    }

    public String getCCPJ02() {
        return CCPJ02;
    }

    public void setCCPJ02(String CCPJ02) {
        this.CCPJ02 = CCPJ02;
    }

    public Long getCcpj03() {
        return ccpj03;
    }

    public void setCcpj03(Long ccpj03) {
        this.ccpj03 = ccpj03;
    }

    public String getCcpj04() {
        return ccpj04;
    }

    public void setCcpj04(String ccpj04) {
        this.ccpj04 = ccpj04;
    }

    public String getCcpr08() {
        return ccpr08;
    }

    public void setCcpr08(String ccpr08) {
        this.ccpr08 = ccpr08;
    }

    public String getCcpr09() {
        return ccpr09;
    }

    public void setCcpr09(String ccpr09) {
        this.ccpr09 = ccpr09;
    }

    public String getCcps01() {
        return ccps01;
    }

    public void setCcps01(String ccps01) {
        this.ccps01 = ccps01;
    }

    public String getCcps01n() {
        return ccps01n;
    }

    public void setCcps01n(String ccps01n) {
        this.ccps01n = ccps01n;
    }

    public String getCczy06() {
        return cczy06;
    }

    public void setCczy06(String cczy06) {
        this.cczy06 = cczy06;
    }

    public String getCczy06n() {
        return cczy06n;
    }

    public void setCczy06n(String cczy06n) {
        this.cczy06n = cczy06n;
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

    public String getEca112() {
        return eca112;
    }

    public void setEca112(String eca112) {
        this.eca112 = eca112;
    }

    public String getAac002() {
        return aac002;
    }

    public void setAac002(String aac002) {
        this.aac002 = aac002;
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

    public String getEccpj03() {
        return eccpj03;
    }

    public void setEccpj03(String eccpj03) {
        this.eccpj03 = eccpj03;
    }

    public String getEcpr08() {
        return ecpr08;
    }

    public void setEcpr08(String ecpr08) {
        this.ecpr08 = ecpr08;
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
}
