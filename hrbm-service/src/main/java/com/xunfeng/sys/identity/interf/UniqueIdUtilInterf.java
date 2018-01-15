package com.xunfeng.sys.identity.interf;

import com.xunfeng.sys.identity.enumeration.SeqType;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: ID生成器 
* @author wanghan 
* @createDate 2015年4月23日-上午11:22:38 
* @version V1.0   
*/
public interface UniqueIdUtilInterf {




	/**
	 * 产生一个唯一ID。 使用同步，防止重复，测试方法见main方法
	 * 
	 */
	public   long genId(String modelName);
	
	/**
	 * 产生一个唯一ID。 使用同步，防止重复，测试方法见main方法
	 * 
	 */
	@Deprecated
	public  long genSeqId(String seqName) ;

	/**
	 * 产生guid
	 * 
	 * @return
	 */
	public   String getGuid() ;
	
	/**生成业务编号
	 * @param SeqType
	 * @param point
	 * @return
	 */
	public   String getBusniessSeqCode(SeqType SeqType,int point ) ;
	

	

}