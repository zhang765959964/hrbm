package com.xunfeng.business.corp.dto;

import com.xunfeng.business.corp.model.Corp;

/**
 * Created by wxl on 2015/7/29.
 */
public class CorpDto extends Corp {
   
    private String certificateTypeName;
    private String corpTypeName;
    private String  economicTypeName;
    private String  scaleName;
    private Long positionSum;
    private Long imgCount;
    private Long videoCount;
    private Long seniorJobCount;
    public String getCertificateTypeName() {
        return certificateTypeName;
    }
    public void setCertificateTypeName(String certificateTypeName) {
        this.certificateTypeName = certificateTypeName;
    }

    public String getCorpTypeName() {
        return corpTypeName;
    }

    public void setCorpTypeName(String corpTypeName) {
        this.corpTypeName = corpTypeName;
    }

    public String getScaleName() {
        return scaleName;
    }

    public void setScaleName(String scaleName) {
        this.scaleName = scaleName;
    }

    public String getEconomicTypeName() {
        return economicTypeName;
    }

    public void setEconomicTypeName(String economicTypeName) {
        this.economicTypeName = economicTypeName;
    }

    public Long getPositionSum() {
        return positionSum;
    }

    public void setPositionSum(Long positionSum) {
        this.positionSum = positionSum;
    }
	public Long getImgCount() {
		return imgCount;
	}
	public void setImgCount(Long imgCount) {
		this.imgCount = imgCount;
	}
	public Long getVideoCount() {
		return videoCount;
	}
	public void setVideoCount(Long videoCount) {
		this.videoCount = videoCount;
	}
	public Long getSeniorJobCount() {
		return seniorJobCount;
	}
	public void setSeniorJobCount(Long seniorJobCount) {
		this.seniorJobCount = seniorJobCount;
	}
    
}
