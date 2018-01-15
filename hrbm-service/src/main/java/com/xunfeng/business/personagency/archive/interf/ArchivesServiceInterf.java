package com.xunfeng.business.personagency.archive.interf;


import java.util.List;
import java.util.Map;

import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 接口类
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
public interface ArchivesServiceInterf extends GenericServiceInterface<Archives,Long>
{
	/**
	 * @param fiter 档案查询
	 * @return
	 */
	public ResultData  getAllArchives(QueryFilter fiter);
	//根据personId 获取个人详细信息
	public Map getPersonBaseinfoByPersonId(Long personId);
	//查询个人信息和档案信息，以人员表为主表
	public ResultData  getAllPersonArchives(QueryFilter fiter);
	/**
	 * @param personId  根据个人id查询档案信息
	 * @return 
	 */
	public Map getArchivesByPersonId(Long personId);
	/**
	 * @param personId
	 * @return 根据个人id查询接收档案信息
	 */
	public Map getReceiveArchivesByPersonId(Long personId);
	

	/**根据查询条件获取已存档人员的人员信息
	 * @param searchValue
	 * @return ResultData ，list对象只包括姓名、性别、身份证号信息
	 * @param pageBean
	 */
	public ResultData<Map>  getArchivesPersonList(String searchValue,PageBean pageBean,boolean hasArch);
	/**
	 * @param personId
	 * @return 根据个人id查询档案入库信息
	 */
	public Map getStorageArchivesByPersonId(Long personId);
	//根据id获取单条档案信息
	public Archives getArchivesByPId(Long personId);
	//社保关系管理模块下  根据id查询档案和个人数据映射
	public Map getArchivesPersonByArchivesId(Long archivesId);
	// 查询所有企业下的档案信息
	public ResultData<Map>  getCorpAllArchive(QueryFilter fiter);
	// 查询所有企业下的档案信息
	public ResultData<Map>  getCorpAllArchive(PageBean pageBean,Long aab001);
	//入库确认
	public void addStoreConfirm(Long[] lAryId,Archives archives);
	//取得单位下所有可以办理档案调出的数据
	public ResultData<Map>  getBatchCorpArchive(PageBean pageBean,Long aab001);
	//查找所有可以批量借阅归还的数据(不带条件)
	public ResultData  getArchivesCheckoutNot(QueryFilter fiter);
	//查找所有可以批量借阅归还的数据
	public ResultData  getAllArchivesCheckoutR(QueryFilter fiter);
	
	/**获取档案包括社保补贴补录档案
	 * @param searchValue
	 * @param pageBean
	 * @return
	 */
	public ResultData<Map>  getAllArchivesPersonList(String searchValue,PageBean pageBean);
	//获取打印的数据
	public Map getArchivesByArchivesId(Long archivesId);
	//获取打印企业下人员名单
	public List<Map> getPersonArchives(String aab001);
}
