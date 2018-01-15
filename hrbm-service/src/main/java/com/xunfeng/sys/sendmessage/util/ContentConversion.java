package com.xunfeng.sys.sendmessage.util;

public class ContentConversion {
	
	public static String modelConversionContent(ContentModel contentModel,String content){
		String str = content;
		if(!"".equals(str)&&contentModel!=null){
			if(contentModel.getCorpName()!=null){
				str = str.replace("{#企业名称#}", contentModel.getCorpName().toString());
			}
			if(contentModel.getCorpPosition()!=null){
				str = str.replace("{#企业岗位#}", contentModel.getCorpPosition().toString());
			}
			if(contentModel.getCorpPerson()!=null){
				str = str.replace("{#企业联系人#}", contentModel.getCorpPerson().toString());
			}
			if(contentModel.getCorpPhone()!=null){
				str = str.replace("{#企业手机号#}", contentModel.getCorpPhone().toString());
			}
			if(contentModel.getCorpPhoneNumber()!=null){
				str = str.replace("{#联系人手机号#}", contentModel.getCorpPhoneNumber().toString());
			}
			if(contentModel.getCorpAddress()!=null){
				str = str.replace("{#联系地址#}", contentModel.getCorpAddress().toString());
			}
			if(contentModel.getCorpAccount()!=null){
				str = str.replace("{#企业账号#}", contentModel.getCorpAccount().toString());
			}
			if(contentModel.getPersonName()!=null){
				str = str.replace("{#个人姓名#}", contentModel.getPersonName().toString());
			}
			if(contentModel.getCorpPwd()!=null){
				str = str.replace("{#企业密码#}", contentModel.getCorpPwd().toString());
			}
			if(contentModel.getPerAccount()!=null){
				str = str.replace("{#个人账号#}", contentModel.getPerAccount().toString());
			}
			if(contentModel.getPerPwd()!=null){
				str = str.replace("{#个人密码#}", contentModel.getPerPwd().toString());
			}
			if(contentModel.getFairSiteBookTime()!=null){
				str = str.replace("{#摊位使用日期#}", contentModel.getFairSiteBookTime().toString());
			}
			if(contentModel.getFairSiteNum()!=null){
				str = str.replace("{#摊位号#}", contentModel.getFairSiteNum().toString());
			}
			if(contentModel.getFairBooth()!=null){
				str = str.replace("{#场地#}", contentModel.getFairBooth().toString());
			}
			if(contentModel.getTrainAccount()!=null){
				str = str.replace("{#机构账号#}", contentModel.getTrainAccount().toString());
			}
			if(contentModel.getTrainPwd()!=null){
				str = str.replace("{#机构密码#}", contentModel.getTrainPwd().toString());
			}
			
			
		}
		return str;
	}
	
	
	
}
