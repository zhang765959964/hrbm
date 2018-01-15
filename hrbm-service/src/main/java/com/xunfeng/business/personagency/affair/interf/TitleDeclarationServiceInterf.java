package com.xunfeng.business.personagency.affair.interf;


import com.xunfeng.business.personagency.affair.model.TitleDeclaration;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 职称申报评定表 接口类
* @author:jiangxin
* @createDate 2016-09-18 15:38:07 
* @version V1.0   
*/
public interface TitleDeclarationServiceInterf extends GenericServiceInterface<TitleDeclaration,Long>
{
   public ResultData<TitleDeclaration> getAllByFilter(QueryFilter fiter);	
   //查询所有的职称申报信息
   public ResultData  getAllTitleDeclaration(QueryFilter fiter);
   //删除职称申报信息
   public void deleteTitleDeclarationByIds(Long[] lAryId);
}
