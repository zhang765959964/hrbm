package com.xunfeng.business.hrtool.interf;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xunfeng.business.hrtool.model.HRToolModel;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: hr工具箱模板表 接口类
* @author:wanghan
* @createDate 2016-03-08 17:26:01 
* @version V1.0   
*/
public interface HRToolModelServiceInterf extends GenericServiceInterface<HRToolModel,Long>
{
	public  List<HRToolModel> getHRToolModelListByColId(Long colId);
	public void updateDownNum(Long id);
	public  List<HRToolModel> getHrModelHotList(int page,int pageSize);
	
	public ResultData<HRToolModel> getAllHRToolModel(QueryFilter fiter);
}
