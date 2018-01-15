package com.xunfeng.business.personagency.archive.interf;


import java.util.List;
import java.util.Map;

import com.xunfeng.business.personagency.archive.model.ArchiveCheckout;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案借阅记录表 接口类
* @author:wanghan
* @createDate 2016-07-22 14:56:36 
* @version V1.0   
*/
public interface ArchiveCheckoutServiceInterf extends GenericServiceInterface<ArchiveCheckout,Long>
{
	/**
	 * @param fiter
	 * @return  查询档案借阅
	 */
	public ResultData  getAllArchiveCheckout(QueryFilter fiter);
	/**
	 * @param archiveCheckout
	 * 		保存档案借阅登记记录
	 */
	public void saveArchiveCheckout(ArchiveCheckout archiveCheckout);
	/**
	 * @param lAryId
	 * 删除档案借阅记录
	 */
	public void delRegisterCheckoutByIds(Long[] lAryId);
	/**
	 *  @param archiveId
	 *  借阅确认
	 */ 		
	public void addRegisterComfirmCheckout(ArchiveCheckout archiveCheckout);
	
	//通用【借阅确认】
	public String addCurrencyRegisterCheckout(Long id,SysUser sysUser,SysOrg sysOrg);
	/**
	 *  @param archiveId
	 *  返回登记
	 */ 
	public void addReturnRegisterCheckout(ArchiveCheckout archiveCheckout);
	/**
	 *  @param archiveId
	 *  返回确认
	 */ 
	public void addReturnConfirmCheckout(ArchiveCheckout archiveCheckout);
	//通用【返还确认】
	public String addCurrencyReturnCheckout(Long id,SysUser sysUser,SysOrg sysOrg);
	
	//根据档案id和档案状态查询借阅单条数据
	public ArchiveCheckout getArchiveCheckoutByArchiveId(Long archiveId,Long checkoutStatus);
	//批量借阅登记
	public void addBatchCheckOutRegister(ArchiveCheckout archiveCheckout,String archiveIds);
	//批量借阅确认
	public void addBatchComfirmCheckout(ArchiveCheckout archiveCheckout,String ids);
	//批量归还登记
	public void addBatchReturnResgister(ArchiveCheckout archiveCheckout,String ids);
	//批量归还确认
	public void addBatchReturnComfirm(ArchiveCheckout archiveCheckout,String ids);
	//查询所有的批次
	public List<Map>  getBatchName(Long checkoutStatus);
	//查询批次是不是已经存在
	public Long getCheckedByBatchName(String batchName);
}
