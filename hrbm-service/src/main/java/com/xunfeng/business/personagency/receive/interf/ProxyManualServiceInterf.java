package com.xunfeng.business.personagency.receive.interf;


import com.xunfeng.business.personagency.receive.model.ProxyManual;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 代理手册表 接口类
* @author:jx
* @createDate 2016-07-07 09:37:15 
* @version V1.0   
*/
public interface ProxyManualServiceInterf extends GenericServiceInterface<ProxyManual,Long>
{
	/**
	 * @param fiter 查询代理手册
	 * @return
	 */
	public ResultData  getAllProxyManual(QueryFilter fiter);
	/**
	 * @param lAryId  删除代理手册合同
	 */
	public void deleteProxyManualByIds(Long[] lAryId);
}
