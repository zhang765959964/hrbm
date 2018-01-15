package com.xunfeng.business.corp.interf;


import java.util.Map;

import com.xunfeng.business.corp.model.CorpCollection;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.setMeal.exception.SetMealException;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 企业人才收藏夹 接口类
* @author:wanghan
* @createDate 2016-04-23 15:23:57 
* @version V1.0   
*/
public interface CorpCollectionServiceInterf extends GenericServiceInterface<CorpCollection,Long>
{
	//批量添加企业收藏简历
	public void batchAddCollection(Long[] corpResumeIds,Long aab001);
	//验证是不是已经收藏了当前简历
	public CorpCollection getCorpCollection(Long ccmc01,Long ccmp01);
	//获取企业收藏人员名单
	public ResultData<Map>  getCorpCollectionList(QueryFilter queryFilter);
	//批量收藏简历
	public void batchCollectionResume(Long[] corpResumeIds,Long aab001);
	//单个收藏简历
	public void sigleCollectionResume(Long aab001,Long aac001);
	//验证当前人是不是已经加入人才库
	public boolean checkPersonIsOfNotCollection(Long aab001,Long aac001);
	/**
	 * 批量添加企业收藏简历
	 * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
	 * @param aab001 企业编号
	 * @param aab004 企业名称
	 * @param Long[] corpResumeIds
	 * @throws SetMealException 套餐不足整个事物回滚 
	 */
	public void batchAddCollectionPayOper(Map<String,Object> map) throws SetMealException;
	/**
	 * 批量收藏简历
	 * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
	 * @param aab001 企业编号
	 * @param aab004 企业名称
	 * 
	 *@param  Long[] corpResumeIds,
	 *@throws SetMealException 套餐不足整个事务回滚 
	 */
	
	public void batchCollectionResumePayOper(Map<String,Object> map) throws SetMealException;
	/**
	 * 加入人才库
	 * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
	 * @param aab001 企业编号
	 * @param aab004 企业名称
	 * 
	 * @param aac001 个人编号
	 */
	public String sigleCollectionResumePayOper(Map<String,Object> map);
	/**
	 * 加入人才库
	 * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
	 * @param aab001 企业编号
	 * @param aab004 企业名称
	 * @param CorpCollection corpCollection 
	 */
	public String addPayOper(Map<String,Object> map);
}
