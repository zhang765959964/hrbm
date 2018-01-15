package com.xunfeng.business.ovemp.corp.interf;


import java.util.Map;

import com.xunfeng.business.ovemp.corp.model.OvempCorpCourse;
import com.xunfeng.business.ovemp.corp.model.OvempCorp;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 开班信息表 接口类
* @author:Wang.CS
* @createDate 2016-05-22 09:25:59 
* @version V1.0   
*/
public interface OvempCorpCourseServiceInterf extends GenericServiceInterface<OvempCorpCourse,Long>
{
	public ResultData<Map> getResultDataTrainCourseResume(PageBean pageBean,Map param);
	public ResultData<Map> getResultDataFavouriteCourseResume(PageBean pageBean);
	public ResultData<Map> getCourseByOrgId(Long orgId, PageBean pageBean);
	public OvempCorpCourse getCourseById(Long courseId);
	public void updateCourse(OvempCorpCourse ovempCorpCourse);
	/**
	 * 个人中心获得培训课程
	 * @param pageBean 分页显示
	 * @param personId 个人id
	 * @param flag 1:全部课程 2:未开课 3：已开课
	 * @return
	 */
	public ResultData<Map<String,Object>> getMyCourse(PageBean pageBean,Long personId,int flag);
	/**
	 * 获得职位列表 
	 * @param pageBean
	 * @param mapParam(机构id,课程名称)
	 * @return
	 */
	public ResultData<Map> getCourseByExcept(PageBean pageBean,Map<String,String> mapParam);
	
	/**
	 * 实现分页显示数据
	 * @author QINKUI
	 */
	public ResultData<OvempCorpCourse> getAllTrainCourse(QueryFilter fiter);
	
	/**
	 * 批量更新开班审核或冻结或禁用或删除状态
	 * @param paramMap
	 * @retun 
	 * @author QINKUI
	 */
	public int updateBatchStatus(Map<String,Object> paramMap);
	
	/**
	 * 根据培训机构Id获取开班数
	 * @author QINKUI
	 */
	public Integer getCourseCountByOrgId(Long pxOrgId);
	
	/**
	 *  根据开班名称获取开班信息
	 */
	public OvempCorpCourse getCourseByName(String courseName);
	
}
