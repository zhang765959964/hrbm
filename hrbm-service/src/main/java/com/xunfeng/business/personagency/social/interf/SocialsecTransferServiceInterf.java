package com.xunfeng.business.personagency.social.interf;


import com.xunfeng.business.personagency.social.model.SocialsecTransfer;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人社保统筹范围内转移表 接口类
* @author:jiangxin
* @createDate 2016-08-12 15:39:20 
* @version V1.0   
*/
public interface SocialsecTransferServiceInterf extends GenericServiceInterface<SocialsecTransfer,Long>
{
   public ResultData<SocialsecTransfer> getAllByFilter(QueryFilter fiter);	
   //添加统筹范围内转移信息，并且处理之前数据为无效状态
   public void addSocialsecTransfer(SocialsecTransfer socialsecTransfer);
   //修改统筹范围内转移信息，并且处理之前数据为无效状态
   public void updateSocialsecTransfer(SocialsecTransfer socialsecTransfer);
}
