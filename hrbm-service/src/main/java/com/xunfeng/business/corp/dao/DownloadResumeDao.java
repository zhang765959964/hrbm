package com.xunfeng.business.corp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.corp.dto.CorpResumeDownDto;
import com.xunfeng.business.corp.model.DownloadResume;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 企业下载简历日志表 Dao类
* @author:wangyanyan
* @createDate 2016-04-07 10:59:12 
* @version V1.0   
*/
@Repository
public class DownloadResumeDao extends BaseDao<DownloadResume>
{
	@Override
	public Class<?> getEntityClass()
	{
		return DownloadResume.class;
	}
	public ResultData<Map> getAllComDownloadResume(QueryFilter filter){
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setDataList(this.getListForm("getAllComDownloadResume",filter));
		resultData.setPageBean(filter.getPageBean());
		return resultData;
	}
	
	/**
	 * 获得当前登录账户简历被下载的次数
	 */
	public Long getTotalInvit(Long aac001){
		return (Long) this.getOne("getTotalInvit", aac001);
	}
	
	/**
	 * 获得企业查看简历的简历数量
	 * @return
	 */
	public Long getCorpReadResume(Long aab001){
		return (Long) this.getOne("getCorpReadResume", aab001);
	}
	
	/**
	 * 根据企业id和个人id查询出下载简历
	 * @return
	 */
	public DownloadResume getReadResume(Long aab001,Long aac001){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("aab001", aab001);
		map.put("aac001", aac001);
		return (DownloadResume) this.getOne("getReadResume", map);
	}
	//企业中心 简历列表   获取企业下载简历列表
	public ResultData<CorpResumeDownDto> getCorpResumeDownDto(QueryFilter filter){
		ResultData<CorpResumeDownDto> resultData = new ResultData<CorpResumeDownDto>();
		resultData.setDataList(this.getListForm("getCorpResumeDownDto",filter));
		resultData.setPageBean(filter.getPageBean());
		return resultData;
	}

}