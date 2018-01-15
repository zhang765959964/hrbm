package com.xunfeng.business.personagency.affair.interf;


import java.util.Map;

import com.xunfeng.business.personagency.affair.model.PersonLetter;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人事档案联系函表 接口类
* @author:jiangxin
* @createDate 2016-09-14 09:32:03 
* @version V1.0   
*/
public interface PersonLetterServiceInterf extends GenericServiceInterface<PersonLetter,Long>
{
   public ResultData<PersonLetter> getAllByFilter(QueryFilter fiter);	
   //删除人事档案联系函
   public void deletePersonLetterByIds(Long[] lAryId);
   //取得打印数据
   public Map getPersonLetterById(Long id);
}
