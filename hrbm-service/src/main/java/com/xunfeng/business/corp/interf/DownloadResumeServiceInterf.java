package com.xunfeng.business.corp.interf;


import java.util.Map;

import com.xunfeng.business.corp.dto.CorpResumeDownDto;
import com.xunfeng.business.corp.model.DownloadResume;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 企业下载简历日志表 接口类
* @author:wangyanyan
* @createDate 2016-04-07 10:59:12 
* @version V1.0   
*/
public interface DownloadResumeServiceInterf extends GenericServiceInterface<DownloadResume,Long>
{
	public ResultData<Map> getAllComDownloadResume(QueryFilter filter);
	
	/**
	 * 获得用户简历下载次数
	 * @param ccmu01 账户id
	 * @return
	 */
	public Long getTotalInvit(Long aac001);
	
	/**
	 * 获得企业查看简历的简历数量
	 * @return
	 */
	public Long getCorpReadResume(Long aab001);
	/**
	 * 根据企业id和个人id查询出下载简历
	 * @return
	 */
	public DownloadResume getReadResume(Long aab001,Long aac001);
	// 企业中心 简历列表   获取企业下载简历列表
	public ResultData<CorpResumeDownDto> getCorpResumeDownDto(QueryFilter filter);
	/**
     * 增加下载简历
     * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
     * @param aab001 企业编号
	 * @param aab004 企业名称
	 * 
     * @param downloadResume 要保存的实体类 一般在map中的key为实体类的名称第一个字母小写
     */
    public String addPayOper(Map<String,Object> map);
}
