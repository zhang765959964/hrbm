package com.xunfeng.business.corp.interf;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.dto.CorpDto;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.person.model.PersonLabel;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.attachment.model.Attachment;

/**
 *<pre>
 * 对象功能:单位基本信息表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-01 09:51:36
 *</pre>
 */
@Service
public interface CorpServiceInter extends GenericServiceInterface<Corp,Long>
{
	
	/**
	 * 添加对象
	 */
	public void add(Corp corp,String Ip);
	/**
	 * 通过 用户编号 ccmu01 获取企业的基本信息 
	 */
	public Corp getCorpByAccountId(Long accountId);
	
	/**
	 * 根据单位编号 开通电子地图
	 * status:开通状态 1
	 * x:横坐标
	 * y：竖坐标
	 * zoomScale：缩放比例
	 */
	public void  openMap(Float x,Float y,Long zoomScale,Corp corp);



	public CorpDto getCorpInfoById(Long aab001);
	/**
	 * 单位注册
	 */
	public void addCorpRegister(Corp corp,Accounts account);
	/**
	 * 后台添加单位信息
	 */
	public void addRegister(Corp corp,Accounts account,Attachment attachment);
	/**
	 * 后台修改单位信息
	 */
	public void updateRegister(Corp corp,Accounts accounts,String nodeLogs,Attachment attachment);
	/**
	 * 根据会员编号获取对象
	 * @return
	 */
	public Corp getByCcmu01(Long ccmu01);

	/**
	 * 获得企业推荐人才
	 * 2016-03-31
	 */
	public ResultData  getRecommendPerson(QueryFilter queryFilter);
	
	public List<Map> getRecommendBlackPerson(QueryFilter queryFilter);
	
	public ResultData<Map> getResultDataRecommendBlackPerson(QueryFilter queryFilter);
	
	public void approve(Long caoa01,Long aab001, Long approveFlag) ;
	//修改保存企业基本信息和标签
	public void updateCorpAndLabel(Corp corp,List<PersonLabel> personLabelList);
	
	/**
	 * 通过职位id获得公司详情
	 * 2016-04-13
	 */
	public ResultData getCorpInfoByJobId(QueryFilter queryFilter);
	
	/**
	 * 通过CorpId获得公司详情
	 * 2016-04-18
	 */
	public Map<String,Object> getCorpInfoByCorpId(Long aab001);
	
	/**
	 * 通过CorpId获得公司简介
	 * 2016-04-13 
	 */
	public String getCorpDescByCorpId(Long aab001);
	
	/**
	 * 根据企业名称公司信息
	 * 2016-05-05
	 */
	public Corp getCorpByCorpName(String corpName);
	/**
	 * 根据企业营业执照获得公司信息
	 * 2016-05-05
	 */
	public Corp getCorpByBusCardNum(String cardNum);
	
	/**
	 * 获得审核通过的企业
	 */
	public List<Corp> getAllValidCorp(QueryFilter queryFilter);
	/**
	 * 通过单位名称或者工商营业执照号码确定所新增的企业是否已存在
	 */
	public List<Corp> getByNameNumber(QueryFilter fiter);
	/**
	 * 通过公办平台获得单位信息
	 */
	public ResultData<Corp> getAllCorp(QueryFilter fiter);
	/**
	 * 查看单位信息详情
	 */
	public Corp getCorpDetails(Long aab001);
	/**
	 * 企业信息统计
	 * @param queryFilter
	 * @return
	 */
	public ResultData<Map<String, Object>> getCorpStatistics(QueryFilter queryFilter);
	
	/**
	 * 企业报表统计数据获取
	 * @param queryFilter 检索条件
	 * @return 返回结果
	 */
	public List<Map<String,Object>> getCorpStatisticsEcharts(QueryFilter queryFilter);
	/**
	 * 人事档案根据aab001 查询企业信息和签订信息
	 * @param aab001
	 * @serialData 2016/08/06
	 * @author jx
	 * @return
	 */
	public Map getCorpUnitAgreement(Long aab001);
	
	/**
	 * 公办系统通过视图 查询企业信息
	 * @param aab001
	 * @serialData 2016/08/27
	 * @author wlp
	 * @return
	 */
	public Map getByCorpView(Long aab001);
	
	/**
	 * @param aab001s 单位Ids，多个“，”隔开
	 * @param opOrgId 当前操作人员的单位Id
	 * @return
	 */
	public Long getNoPermissionCount(String aab001s,Long opOrgId);
	
}
