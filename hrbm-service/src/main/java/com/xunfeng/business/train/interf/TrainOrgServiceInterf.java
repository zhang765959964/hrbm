package com.xunfeng.business.train.interf;


import java.util.Map;

import com.xunfeng.business.train.dto.TrainOrgDto;
import com.xunfeng.business.train.model.TrainOrg;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训机构表 接口类
* @author:Wang.CS
* @createDate 2016-05-23 09:30:42 
* @version V1.0   
*/
public interface TrainOrgServiceInterf extends GenericServiceInterface<TrainOrg,Long>
{
	public ResultData<Map> getResultDataTrainCorpResume(PageBean pageBean,Map param);
	public ResultData<Map> getResultDataHotTrainCorpResume(PageBean pageBean);
	public TrainOrgDto getTrainOrgById(Long id);
	/**
	 * 不带有培训机构介绍 查询
	 * @param id  培训机构主键
	 * @return TrainOrgDto
	 */
	public TrainOrgDto getTrainOrgNoContentById(Long id);
	public TrainOrg getTrainOrgByOrgId(Long id);
	/**
	 * 首页找培训
	 * @param pageBean
	 * @param param
	 * @return
	 */
	public ResultData<Map> getResultDataTrainCorp(PageBean pageBean,Map<String,String> param);
	
	/**
	 * 批量设置培训机构冻结状态
	 * @param paramMap
	 * @retun 
	 * @author QINKUI
	 */
	public int updateDisableStatus(Map<String,Object> paramMap);
	
	/**
	 * 批量设置培训机构删除状态
	 * @param paramMap
	 * @retun 
	 * @author QINKUI
	 */
	public int updateDelStatus(Map<String,Object> paramMap);
	
	/**
	 * 批量设置培训机构审核状态
	 * @param paramMap
	 * @retun 
	 * @author QINKUI
	 */
	public int updateAuditStatus(Map<String,Object> paramMap);
	
	
	public ResultData<TrainOrg> getTrainOrgData(QueryFilter fiter);
	
	/**
	 *  根据机构账号获取机构
	 */
	public TrainOrg getOrgByAccount(String orgAccount);
	
	/**
	 *  根据机构名称获取机构
	 */
	public TrainOrg getOrgByName(String orgName);
	
	/**
	 *  根据机构发布名称获取机构
	 */
	public TrainOrg getOrgByPubName(String orgPublishName);
	/**
	 *  根据机构证件号码获取机构
	 */
	public TrainOrg getOrgByCertificate(String certificateId);
	public TrainOrg getOrgByCertificate(String certificateId,Long orgId);
	public void saveRegistTrainOrg(TrainOrg trainOrg);
}
