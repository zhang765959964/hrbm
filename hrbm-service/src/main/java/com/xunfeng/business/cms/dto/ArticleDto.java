package com.xunfeng.business.cms.dto;


import java.util.Calendar;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;

/**
 * 对象功能:新闻内容表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-08 10:08:39
 */
public class ArticleDto extends BaseModel
{
	// 新闻内容自动编号
	protected Long  cand01;
	// 类别编号
	protected Long  canc01;
	// 标题
	protected String  cand03;
	//新闻模式
	protected String eand05;
	//发布人
	protected String ccmu01n;
	// 标题
	protected Long  cand13;
	// 是否推荐新闻0-否1-是
	protected Long  cand16;
	// 是否置顶新闻0-否1-是
	protected Long  cand17;
	// 信息发布方式0-通用1-中部就业网2-民营职介
	protected Long  cand18;
	//新闻状态
	protected String eand09;
	protected String cand11;
	protected String cand19;
	protected String cand20;
	protected String  month;
	protected String  day;

	protected String  year;
	// 标题
	protected String  cand04;

	//发布时间
	protected java.util.Date  cand07;
	public Long getCand01() {
		return cand01;
	}
	public void setCand01(Long cand01) {
		this.cand01 = cand01;
	}
	public Long getCanc01() {
		return canc01;
	}
	public void setCanc01(Long canc01) {
		this.canc01 = canc01;
	}
	public String getCand03() {
		return cand03;
	}
	public void setCand03(String cand03) {
		this.cand03 = cand03;
	}
	public String getEand05() {
		return eand05;
	}
	public void setEand05(String eand05) {
		this.eand05 = eand05;
	}
	public String getCcmu01n() {
		return ccmu01n;
	}
	public void setCcmu01n(String ccmu01n) {
		this.ccmu01n = ccmu01n;
	}
	public Long getCand16() {
		return cand16;
	}
	public void setCand16(Long cand16) {
		this.cand16 = cand16;
	}
	public Long getCand17() {
		return cand17;
	}
	public void setCand17(Long cand17) {
		this.cand17 = cand17;
	}
	public Long getCand18() {
		return cand18;
	}
	public void setCand18(Long cand18) {
		this.cand18 = cand18;
	}
	public String getEand09() {
		return eand09;
	}
	public void setEand09(String eand09) {
		this.eand09 = eand09;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonSerialize(using=JsonDateSerializer.class)
	public java.util.Date getCand07() {
		return cand07;
	}
	public void setCand07(java.util.Date cand07) {
		this.cand07 = cand07;
	}

	public String getCand11() {
		return cand11;
	}

	public void setCand11(String cand11) {
		this.cand11 = cand11;
	}

	public String getCand19() {
//        if(StringUtil.isEmpty(cand19)){
//			this.cand19=removeHtmlTag(this.cand04);
//		}
		return cand19;
	}

	public void setCand19(String cand19) {
		this.cand19 = cand19;
	}

	public String getCand20() {
		return cand20;
	}

	public void setCand20(String cand20) {
		this.cand20 = cand20;
	}

	public String getDay() {
		Calendar c = Calendar.getInstance();//获得一个日历的实例
		c.setTime(cand07);
		int day = c.get(Calendar.DATE);
		int month = c.get(Calendar.MONTH) + 1;
		return String.valueOf(day);
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
//		cand07
		Calendar c = Calendar.getInstance();//获得一个日历的实例
		c.setTime(cand07);
		int day = c.get(Calendar.DATE);
		int month = c.get(Calendar.MONTH) + 1;
		String returnMonth="";
		switch (month){
			case 1:returnMonth="一"; break;
			case 2:returnMonth="二"; break;
			case 3:returnMonth="三"; break;
			case 4:returnMonth="四"; break;
			case 5:returnMonth="五"; break;
			case 6:returnMonth="六"; break;
			case 7:returnMonth="七"; break;
			case 8:returnMonth="八"; break;
			case 9:returnMonth="九"; break;
			case 10:returnMonth="十"; break;
			case 11:returnMonth="十一"; break;
			case 12:returnMonth="十二"; break;
		}
		return returnMonth;
	}
//	public static String removeHtmlTag(String content) {
//
//		StringBuffer sb=new StringBuffer();
//		try{
//
//			Parser parser = new Parser(content);
//
//			for (NodeIterator i = parser.elements (); i.hasMoreNodes(); ) {
//				if(sb.length()>150){
//					break;
//				}
//				Node node = i.nextNode();
//				String plainText=node.toPlainTextString();
//				sb.append(plainText);
//			}
//		}
//		catch( Exception e ) {
//			System.out.println( "Exception:"+e );
//		}
//		return sb.toString();
//
//}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		Calendar c = Calendar.getInstance();//获得一个日历的实例
		c.setTime(cand07);
		int year = c.get(Calendar.YEAR);
		return String.valueOf(year);
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCand04() {
		return cand04;
	}

	public void setCand04(String cand04) {
		this.cand04 = cand04;
	}
	public Long getCand13() {
		return cand13;
	}
	public void setCand13(Long cand13) {
		this.cand13 = cand13;
	}
	
}