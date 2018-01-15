package com.xunfeng.business.ovemp.corp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.ovemp.corp.dao.OvempCorpCourseDao;
import com.xunfeng.business.ovemp.corp.interf.OvempCorpCourseServiceInterf;
import com.xunfeng.business.ovemp.corp.model.OvempCorpCourse;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 开班信息表 Service类
* @author:Wang.CS
* @createDate 2016-05-22 09:25:59 
* @version V1.0   
*/
@Service
public class OvempCorpCourseService extends BaseService<OvempCorpCourse> implements OvempCorpCourseServiceInterf
{
	@Resource
	private OvempCorpCourseDao dao;
	
	
	
	public OvempCorpCourseService()
	{
	}
	
	@Override
	protected IEntityDao<OvempCorpCourse, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public ResultData<Map> getResultDataTrainCourseResume(PageBean pageBean, Map param) {
		QueryFilter fiter=new QueryFilter();
		fiter.setPageBean(pageBean);
		String courseType = (String)param.get("courseType");
		String orgType = (String)param.get("orgType");
		String courseName = (String)param.get("courseName");
		if (courseType != null && !courseType.equals("")){
            fiter.addFilter("courseType",courseType);
        }
		if (orgType != null && !orgType.equals("")){
            fiter.addFilter("orgType",orgType);
        }
		if(courseName != null && !courseName.equals("")){
            fiter.addFilter("courseName","%"+courseName+"%");
        }
		List<Map> dataList = (List<Map>)dao.getListForm("getCourseByCondition",fiter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(fiter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	@Override
	public ResultData<Map> getResultDataFavouriteCourseResume(PageBean pageBean) {
		QueryFilter fiter=new QueryFilter();
		/*Map<String,Object> map = new HashMap<String, Object>();
		map.put("isDel", "0");
		map.put("isAudit", "1");
		map.put("acb208", "0");
		map.put("isDisable", "0");
		fiter.setFilters(map);*/
		fiter.setPageBean(pageBean);
		List<Map> dataList = (List<Map>)dao.getListForm("getFavouriteCourse",fiter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(fiter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}

	@Override
	public ResultData<Map> getCourseByOrgId(Long orgId, PageBean pageBean) {
		QueryFilter fiter=new QueryFilter();
		if (orgId != null && !orgId.equals("")){
            fiter.addFilter("orgId",orgId);
        }
		fiter.setPageBean(pageBean);
		List<Map> dataList = (List<Map>)dao.getListForm("getCourseByOrgId",fiter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(fiter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	/**
	 * 获得职位列表 (机构id,课程名称)
	 * @param pageBean
	 * @param mapParam
	 * @return
	 */
	public ResultData<Map> getCourseByExcept(PageBean pageBean,Map<String,String> mapParam) {
		QueryFilter fiter=new QueryFilter();
		String orgId = mapParam.get("orgId");
		String coursekey = mapParam.get("coursekey");
		if (StringUtil.isNotEmpty(orgId)&& !orgId.equals("0")){
			fiter.addFilter("orgId",orgId);
		}
		if (StringUtil.isNotEmpty(coursekey)&& !coursekey.equals("0")){
			fiter.addFilter("coursekey","%"+coursekey+"%");
		}
		fiter.setPageBean(pageBean);
		List<Map> dataList = (List<Map>)dao.getListForm("getCourseByExcept",fiter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(fiter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}

	@Override
	public OvempCorpCourse getCourseById(Long courseId) {
		return dao.getById(courseId);
	}

	@Override
	public void updateCourse(OvempCorpCourse ovempCorpCourse) {
		dao.update(ovempCorpCourse);
	}
	/**
	 * 个人中心获得培训课程
	 * @param pageBean 分页显示
	 * @param personId 个人id
	 * @param flag 1:全部课程 2:未开课 3：已开课
	 * @return
	 */
	public ResultData<Map<String,Object>> getMyCourse(PageBean pageBean,Long personId,int flag){
		QueryFilter filter=new QueryFilter();
		filter.addFilter("personId",personId);
		filter.addFilter("flag",flag);
		filter.setPageBean(pageBean);
		List<Map<String,Object>> dataList = (List<Map<String,Object>>)dao.getListForm("getMyCourse",filter);
		ResultData<Map<String,Object>> resultData = new ResultData<Map<String,Object>>();
		resultData.setPageBean(filter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}

	@Override
	public ResultData<OvempCorpCourse> getAllTrainCourse(QueryFilter fiter) {
		
		ResultData<OvempCorpCourse> resultData=new ResultData<OvempCorpCourse>();
		List<OvempCorpCourse> dataList =dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public int updateBatchStatus(Map<String, Object> paramMap) {
		
		return dao.update("updateBatchStatus", paramMap);
	}

	@Override
	public Integer getCourseCountByOrgId(Long pxOrgId) {
		
		return (Integer) dao.getOne("getCourseCountByOrgId", pxOrgId);
	}

	@Override
	public OvempCorpCourse getCourseByName(String courseName) {
		
		return dao.getUnique("getCourseByName", courseName);
	}
	
}
