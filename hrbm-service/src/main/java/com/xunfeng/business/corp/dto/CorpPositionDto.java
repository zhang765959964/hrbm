package com.xunfeng.business.corp.dto;

import com.xunfeng.core.json.JsonDateMMSerializer;
import com.xunfeng.core.json.JsonDateSerializer;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wxl on 2015/8/8.
 * 视图：v_job_list_bs
 */
public class CorpPositionDto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//职位ID
    private Long acb210;
    //招聘信息编号
    private Long acb200;
    //职位编号
    private String  bca111;
    //职位名称
    private String bca112;
    //职位描述
    private String cca113;
    //职位描述
    private String cca114;
    //单位编号
    private Long aab001;
    //单位名称
    private String aab004;
    //发布日期
    private Date aae036;
    //-发布开始日期
    private Date aae030;
    //发布结束日期
    private Date aae031;
    //审核状态(null-未审核1-已审核）
    private String abb773;
    //工作地点
    private String bcb202;
    //浏览次数
    private Long cczy08;
    //冻结标记  1冻结
    private String  acb208;
    //刷新时间
    private Date cczy09;
    //招聘形式ID
    private String acb201;
    //招聘套餐名称
    private String ecb201;
     //收到的职位申请数量
    private Long sl;
    //经办人
    private String  aae019;
    //招聘人数
    private Long acb21r;
    //数据来源
    private String bcb209;
    //工资待遇
    private String acc034;
    //数据来源名称
    private String bcb209n;
    //职位状态 -1已过期 0 发布中 1 已经暂停
    private String ccb208;
    //职位状态名称
    private String ecb208;
    //工作经验要求
    private String acc218;
    //性别
    private String  aad005;
    //学历
    private String aac012;

    private String acc214;
    private String acb21i;
    private String acb21iName;
    
    private Long ccmu01;
    
    //应聘职位id
    private Long caae01;
    //收到的简历数量
    private Long jl;
    
    
    
    private List<String> benefitsList =new ArrayList<String>();
    
    
    
    public Long getJl() {
		return jl;
	}

	public void setJl(Long jl) {
		this.jl = jl;
	}

	public Long getCaae01() {
		return caae01;
	}

	public void setCaae01(Long caae01) {
		this.caae01 = caae01;
	}

	public String getAcb21iName() {
		return acb21iName;
	}

	public void setAcb21iName(String acb21iName) {
		this.acb21iName = acb21iName;
	}

	public Long getCcmu01() {
		return ccmu01;
	}

	public void setCcmu01(Long ccmu01) {
		this.ccmu01 = ccmu01;
	}

	public String getAcc218() {
        return acc218;
    }

    public void setAcc218(String acc218) {
        this.acc218 = acc218;
    }

    public String getAac012() {
        return aac012;
    }

    public void setAac012(String aac012) {
        this.aac012 = aac012;
    }

    public String getAad005() {
        return aad005;
    }

    public void setAad005(String aad005) {
        this.aad005 = aad005;
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

    public String getAae019() {
        return aae019;
    }

    public void setAae019(String aae019) {
        this.aae019 = aae019;
    }
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getAae030() {
        return aae030;
    }

    public void setAae030(Date aae030) {
        this.aae030 = aae030;
    }
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getAae031() {
        return aae031;
    }

    public void setAae031(Date aae031) {
        this.aae031 = aae031;
    }
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getAae036() {
        return aae036;
    }

    public void setAae036(Date aae036) {
        this.aae036 = aae036;
    }

    public String getAbb773() {
        return abb773;
    }

    public void setAbb773(String abb773) {
        this.abb773 = abb773;
    }

    public Long getAcb200() {
        return acb200;
    }

    public void setAcb200(Long acb200) {
        this.acb200 = acb200;
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

    public Long getAcb21r() {
        return acb21r;
    }

    public void setAcb21r(Long acb21r) {
        this.acb21r = acb21r;
    }

    public String getAcc034() {
        return acc034;
    }

    public void setAcc034(String acc034) {
        this.acc034 = acc034;
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

    public String getBcb202() {
        return bcb202;
    }

    public void setBcb202(String bcb202) {
        this.bcb202 = bcb202;
    }

    public String getBcb209() {
        return bcb209;
    }

    public void setBcb209(String bcb209) {
        this.bcb209 = bcb209;
    }

    public String getBcb209n() {
        return bcb209n;
    }

    public void setBcb209n(String bcb209n) {
        this.bcb209n = bcb209n;
    }

    public String getCca113() {
        return cca113;
    }

    public void setCca113(String cca113) {
        this.cca113 = cca113;
    }

    public String getCcb208() {
        return ccb208;
    }

    public void setCcb208(String ccb208) {
        this.ccb208 = ccb208;
    }

    public Long getCczy08() {
        return cczy08;
    }

    public void setCczy08(Long cczy08) {
        this.cczy08 = cczy08;
    }
    @JsonSerialize(using = JsonDateMMSerializer.class)
    public Date getCczy09() {
        return cczy09;
    }

    public void setCczy09(Date cczy09) {
        this.cczy09 = cczy09;
    }

    public String getEcb201() {
        return ecb201;
    }

    public void setEcb201(String ecb201) {
        this.ecb201 = ecb201;
    }

    public String getEcb208() {
        return ecb208;
    }

    public void setEcb208(String ecb208) {
        this.ecb208 = ecb208;
    }

    public Long getSl() {
        return sl;
    }

    public void setSl(Long sl) {
        this.sl = sl;
    }

    public String getCca114() {
        return cca114;
    }

    public void setCca114(String cca114) {
        this.cca114 = cca114;
    }

    public String getAcc214() {
        return acc214;
    }

    public void setAcc214(String acc214) {
        this.acc214 = acc214;
    }

    public String getAcb21i() {
        return acb21i;
    }

    public void setAcb21i(String acb21i) {
        this.acb21i = acb21i;
    }

    public List<String> getBenefitsList() {
        return benefitsList;
    }

    public void setBenefitsList(List<String> benefitsList) {
        this.benefitsList = benefitsList;
    }

    public void initBenefitsList() {
        if(StringUtils.isBlank(acc214))return;
        String[] benefits_array=acc214.split(",");
        for(String benefits :benefits_array){

            benefitsList.add(getBenefits(benefits));
        }
    }
    private String getBenefits (String acc214){
        if("1".equals(acc214)){
          return "养老保险";
        }else if("2".equals(acc214)){
            return "失业保险";
        }else if("3".equals(acc214)){
            return "医疗保险";
        }else if("4".equals(acc214)){
            return "工伤保险";
        }else if("5".equals(acc214)){
            return "生育保险";
        }else if("6".equals(acc214)){
            return "公积金";
        }else if("9".equals(acc214)){
            return "其他福利";
        }else{
            return "其他福利";
        }
    }

}
