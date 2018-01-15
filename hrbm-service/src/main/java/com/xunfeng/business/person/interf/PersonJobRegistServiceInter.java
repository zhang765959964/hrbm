package com.xunfeng.business.person.interf;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.xunfeng.business.person.model.PersonJobRegist;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;

/**
 * <pre>
 * 对象功能:个人求职登记表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:59:03
 * </pre>
 */
public interface PersonJobRegistServiceInter extends GenericServiceInterface<PersonJobRegist,Long> {


    public PersonJobRegist getPersonJobRegist(Long aac001);

    public List<Map>  getLikeJob(QueryFilter queryFilter) ;
    
    public ResultData<Map> getResultDataLikeJob(QueryFilter queryFilter,Long ccmu01,Long aac001);
    
    public List<Map> getPersonResume(QueryFilter queryFilter);
    
    /**获取个人求职意向详情，并封装为Map返回
     * @param aac001 个人id
     * @param ccmc01 当前登录人Id 
     * @return
     */
    public Map getPersonMap(Long aac001,Long ccmc01);
    //获得个人求职详情并判断是不是已经加入人才库和发送了面试邀请
    public Map getPersonCollectionAndMianShiMap(Long aac001,Long ccmc01,Long acb210);
    
    public ResultData<Map> getResultDataPersonResume(PageBean pageBean,Map param);
    
    /**
     * 
     * 通过个人编号获得求职登记信息 
     */
    public Map<String,Object> getJobRegistByPersonId (Long aac001);
    /**
     * 
     * 通过个人编号获得有效的求职登记信息 
     */
    public Map<String,Object> getValidJobRegistByPersonId(Long aac001);
    
    /**
     * 刷新简历
     */
    public void refreshJobRegist (Long acc200, Timestamp date);
    
    /**
     * 更新个人信息时更新简历信息
     */
    public void updateJobRegist (Long aac001,Long  aac0d0);
    /**
     * 更新简历状态和个人基本信息
     * @param personJobRegist
     * @param personId
     * @param resumeState
     */
    public void updateJobRegistState(PersonJobRegist personJobRegist , long personId,int resumeState);
    /**
     * 求职信息视图查询
     * @param fiter
     * @return
     */
    public ResultData<Map<String,Object>> getPersonRegistViewList(QueryFilter fiter);
	/**
	 * 个人求职统计查询
	 * @param fiter 检索条件
	 * @return 分页数据
	 */
	public ResultData<Map<String,Object>> getJobregStatistics(QueryFilter fiter);
	 /**
	 * 根据个人Id获取所有的求职登记信息
	 * @param fiter 检索条件
	 * @return 分页数据
	 */
	public ResultData<PersonJobRegist> getAllByFilter(QueryFilter fiter);	
	
	/**
	 * 根据个人Id获取有效的求职登记信息（去实体类数据）
	 * @time2016-08-10 
	 * wanlupeng
	 * @return 
	 */
	public PersonJobRegist getByPersonId(Long aac001);
	
	/**
	 * 根据个人ID查询求职登记详情
	 * @param aac001 个人登记编号
	 * @return 求职登记详
	 */
	public Map<String,Object> getJobRegistMapByPersonId(Long aac001);
	/**
	 * 查询有效的求职登记信息中意向职位是否重复
	 * @time2016-08-10 
	 * wanlupeng
	 * @return 
	 */
	public PersonJobRegist getIsExist(Long aac001,Long bca111);
}
