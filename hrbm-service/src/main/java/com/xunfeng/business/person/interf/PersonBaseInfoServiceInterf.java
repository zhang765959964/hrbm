package com.xunfeng.business.person.interf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.dto.PersonBaseInfoDto;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.model.PersonFamily;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.accounts.model.Accounts;

/**
 *<pre>
 * 对象功能:个人基本信息表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:58:15
 *</pre>
 */
@Service
public interface PersonBaseInfoServiceInterf  extends GenericServiceInterface<PersonBaseInfo,Long>
{
	
	
	/**
	 * 根据会员编号获取对象
	 * @return
	 */
	public PersonBaseInfo getByCcmu01(Long ccmu01);
	/**
	 * 根据个人编号获取对象
	 * @return
	 */
	public PersonBaseInfoDto getPersonDtoById(Long aac001);
	/**
	 * 根据个人编号获取对象
	 * @return
	 */
	public Map<String,Object> getPresonInfoMapByPersonId(Long aac001);
	public PersonBaseInfo getByIdcardAndRealName(String idCard);
	
	public void addPersonBaseInfo(PersonBaseInfo personBaseInfo);
	
	public ResultData<PersonBaseInfo> getAllPerson(QueryFilter fiter);
	
	//公办系统(劳动力采集系统)中查询个人基本信息
	public ResultData<PersonBaseInfo> getPersonList(QueryFilter fiter);
	 
	/**
	 * 获取求职检索选择列表
	 * @param fiter 检索条件  
	 * @return 返回分页数据
	 */
	public ResultData<Map<String, Object>> getCommPersonList(QueryFilter fiter);
	/**
	 * 取得个人基本信息列表
	 * @param fiter 检索条件  
	 * @return 返回分页数据
	 */
	public ResultData<Map<String, Object>> getCommBasePersonList(QueryFilter fiter);
	//通过视图V_AC01查询数据
	public PersonBaseInfo getByIds(Long  aac001);
	/**
	 * 个人信息统计
	 * @param queryFilter
	 * @return
	 */
	public ResultData<Map<String, Object>> getPersonStatistics(QueryFilter queryFilter);
	
	/**
	 * 报表统计数据获取
	 * @param queryFilter 检索条件
	 * @return 返回结果
	 */
	public List<Map<String,Object>> getPersonStatisticsEcharts(QueryFilter queryFilter);
	/**
	 * @param personId
	 * @return 根据personId获取个人基本信息
	 */
	public Map getReceivePersonByPersonId(Long personId);
	/**
	 * @param aac002
	 * @return 根据身份证号(aac002)获取个人基本信息
	 */
	public PersonBaseInfo getByAac002(String aac002);
	/**
	 * @param aac002和编码查询身份证号是否已存在
	 * @return 
	 */
	public List<PersonBaseInfo> getPersonExist(QueryFilter fiter);
	/**
	 * @param 2006/08/01
	 * @return 添加个人基本信息
	 */
	public void addAll(String faName,String faSpouseCard,String expPersonStatus,PersonBaseInfo personBaseInfo,PersonExpand personexpand,PersonExpand personExpand,PersonFamily personFamily,Accounts accounts,String nodelogs);
	/**
	 * @param 2006/08/01
	 * @return 修改个人基本信息
	 */
	public void updateAll(String faName,String faSpouseCard,Long sign,PersonBaseInfo personBaseInfo,PersonExpand personExpand,PersonExpand expand,PersonExpand personexpand,PersonFamily familyperson,Accounts account,String nodelogs);
	/**获取用户基本信息
	 * @param searchValue 查询条件（姓名 身份证号）
	 * @param pageBean 分页信息
	 * @return Map格式的返回数据
	 */
	public ResultData<Map>  getMapPersonList(String searchValue,PageBean pageBean);
	
	public Long getNoPermissionCount(String aac001s,Long opOrgId);
}
