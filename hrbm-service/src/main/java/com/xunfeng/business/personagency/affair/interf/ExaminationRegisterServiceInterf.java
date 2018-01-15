package com.xunfeng.business.personagency.affair.interf;


import com.xunfeng.business.personagency.affair.model.ExaminationRegister;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 考试报名登记表 接口类
* @author:jiangxin
* @createDate 2016-09-20 10:13:34 
* @version V1.0   
*/
public interface ExaminationRegisterServiceInterf extends GenericServiceInterface<ExaminationRegister,Long>
{
   public ResultData<ExaminationRegister> getAllByFilter(QueryFilter fiter);	
   //查询所有的考试报名登记信息
   public ResultData  getAllExaminationRegister(QueryFilter fiter);
   //删除考试报名登记信息
   public void deleteExaminationRegisterByIds(Long[] lAryId);
}
