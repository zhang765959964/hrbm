package com.xunfeng.business.personagency.subsidy.dto;
import java.io.Serializable;

import com.xunfeng.business.personagency.subsidy.model.SocialSubsidy;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 
* @author:wanghan
* @createDate 2016-07-07 16:58:57 
* @version V1.0   
*/
public class BatchSocialSubsidyDto extends SocialSubsidy implements Serializable
{
		// 公民身份证号码
		protected String  aac002;
		// 姓名
		protected String  aac003;
		// 批次名称
		protected String  batchName;
		protected String archiveCode;
		
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
		public String getBatchName() {
			return batchName;
		}
		public void setBatchName(String batchName) {
			this.batchName = batchName;
		}
		public String getArchiveCode() {
			return archiveCode;
		}
		public void setArchiveCode(String archiveCode) {
			this.archiveCode = archiveCode;
		}

}