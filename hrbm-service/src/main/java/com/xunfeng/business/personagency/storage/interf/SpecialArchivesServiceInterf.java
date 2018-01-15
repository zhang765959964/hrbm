package com.xunfeng.business.personagency.storage.interf;


import java.util.List;

import com.xunfeng.business.personagency.storage.model.SpecialArchives;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 特殊档案表 接口类
* @author:jiangxin
* @createDate 2016-08-15 14:27:06 
* @version V1.0   
*/
public interface SpecialArchivesServiceInterf extends GenericServiceInterface<SpecialArchives,Long>
{
   public ResultData<SpecialArchives> getAllByFilter(QueryFilter fiter);	
   public void addSpecialArchives(SpecialArchives specialArchives);
   //删除特殊类档案
   public void deleteSpecialArchives(Long[] lAryId);
   public SpecialArchives getSpecialArchivesByUnidAndId(Long id,String aac002);
   //特殊类档案数据导入
   public void addBatchSpecialArchives(List list);
}
