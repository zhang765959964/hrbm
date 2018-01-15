package com.xunfeng.business.personagency.archive.interf;


import com.xunfeng.business.personagency.archive.model.ArchiveLend;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案调出表 接口类
* @author:jx
* @createDate 2016-07-12 10:08:55 
* @version V1.0   
*/
public interface ArchiveLendServiceInterf extends GenericServiceInterface<ArchiveLend,Long>
{
	//根据档案id和调出流转状态查询调出信息
	public ArchiveLend getArchiveLendByArchiveId(Long archivesId,Long lendFlowStatus);
	
	public ResultData<ArchiveLend> getAllByFilter(QueryFilter fiter);
	
	/**
	 * @param 调出确认查询列表
	 * @return
	 */
	public ResultData  getAllArchiveLend(QueryFilter fiter);
	//调出确认
	public void addLendComfirm(ArchiveLend archiveLend,Long[] lAryId);
	//调出登记
	public void addLendRegister(ArchiveLend archiveLend);
	//调出取消
	public void delArchiveLend(Long lendId); 
	//单位档案批量调出登记
	public void addBatchLendRegister(ArchiveLend archiveLend,String archiveIds);
	//档案调出综合查询
	public ResultData  getAllArchiveLendSearch(QueryFilter fiter);
}
