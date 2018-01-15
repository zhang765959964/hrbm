package com.xunfeng.business.personagency.affair.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.affair.model.ExaminationRegister;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 考试报名登记表 Dao类
* @author:jiangxin
* @createDate 2016-09-20 10:13:34 
* @version V1.0   
*/
@Repository
public class ExaminationRegisterDao extends BaseDao<ExaminationRegister>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ExaminationRegister.class;
	}
	public List<Map>  getAllExaminationRegister(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getAllExaminationRegister",fiter);		
		return dataList;
	}
}