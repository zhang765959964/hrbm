package com.xunfeng.sys.message.interf;

import java.util.Map;

import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.message.model.AccountMessage;

/**
 *<pre>
 * 对象功能:站内信表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:03:04
 *</pre>
 */
public interface AccountMessageServiceInterf  extends GenericServiceInterface<AccountMessage,Long>
{
	/**
	 * 获得站内信列表
	 * 2016-04-08
	 */
	public ResultData<Map>  getAllMessage(QueryFilter filter);
	
	/**
	 * 通过账户id获得站内信总条数
	 * @return
	 */
	public Long getTotalCountMessageByCcmu01(Long ccmu01);
	
	//参数 1.发件人编号2.标题3.内容4.收件人编号（编号是：ccmu01）
	public void addAccountMessage(Long ccms01,String ccmc02,String ccmc03,Long ccmr01);
}
