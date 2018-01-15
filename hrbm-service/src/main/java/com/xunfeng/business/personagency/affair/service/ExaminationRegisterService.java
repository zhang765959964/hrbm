package com.xunfeng.business.personagency.affair.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.affair.model.ExaminationRegister;
import com.xunfeng.business.personagency.affair.model.TitleDeclaration;
import com.xunfeng.business.personagency.affair.dao.ExaminationRegisterDao;
import com.xunfeng.business.personagency.affair.interf.ExaminationRegisterServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 考试报名登记表 Service类
* @author:jiangxin
* @createDate 2016-09-20 10:13:34 
* @version V1.0   
*/
@Service
public class ExaminationRegisterService extends BaseService<ExaminationRegister> implements ExaminationRegisterServiceInterf
{
	@Resource
	private ExaminationRegisterDao dao;
	
	
	
	public ExaminationRegisterService()
	{
	}
	
	@Override
	protected IEntityDao<ExaminationRegister, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<ExaminationRegister> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ExaminationRegister> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
	//查询所有的考试报名登记信息
	public ResultData  getAllExaminationRegister(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Map> dataList= dao.getAllExaminationRegister( fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//删除考试报名登记信息
	public void deleteExaminationRegisterByIds(Long[] lAryId){
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long id : lAryId){
			ExaminationRegister examinationRegister = dao.getById(id);
			examinationRegister.setCcpr08("1");
			dao.update(examinationRegister);
		}
	}
}
