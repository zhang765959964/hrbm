package com.xunfeng.sys.message.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.message.dao.AccountMessageDao;
import com.xunfeng.sys.message.interf.AccountMessageServiceInterf;
import com.xunfeng.sys.message.model.AccountMessage;

/**
 *<pre>
 * 对象功能:站内信表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:03:04
 *</pre>
 */
@Service
public class AccountMessageService extends BaseService<AccountMessage> implements AccountMessageServiceInterf
{
	@Resource
	private AccountMessageDao dao;
	@Resource
	UniqueIdUtilService  UniqueIdUtil;
	
	
	public AccountMessageService()
	{
	}
	
	@Override
	protected IEntityDao<AccountMessage, Long> getEntityDao()
	{
		return dao;
	}

//	/**
//	 * 根据账号ID 获取站内信的统计信息
//	 */
//	public AccountMessageStatisticsDto getStatisticsInfo(Long ccmr01){
//		return dao.getStatisticsInfo(ccmr01);
//	}
//
//	/**
//	 * 设置站内信为查看状态
//	 *s 根据ID设置 ccmc05 为1   查看
//	 * @param ids
//	 * ccmc01
//	 */
//	public void viewAccountMessage(Long[] ids){
//		for(Long id:ids){
//			dao.updateMessageStatus(id,"1");
//		}
//	}
	/**
	 * 获得站内信列表
	 * 2016-04-08
	 */
	public ResultData<Map>  getAllMessage(QueryFilter filter){
		ResultData<Map> result = new ResultData<Map>();
		result.setDataList(dao.getAllMessageMap(filter));
		result.setPageBean(filter.getPageBean());
		return result;
	}
	/**
	 * 通过账户id获得站内信总条数
	 * @return
	 */
	public Long getTotalCountMessageByCcmu01(Long ccmu01){
		return dao.getTotalCountMessageByCcmu01(ccmu01);
	}
	//参数 1.发件人编号2.标题3.内容4.收件人编号（编号是：ccmu01）
	public void addAccountMessage(Long ccms01,String ccmc02,String ccmc03,Long ccmr01){
		AccountMessage accountMessage = new AccountMessage();
		accountMessage.setCcmc01(UniqueIdUtil.genId(AccountMessage.class.getName()));
		accountMessage.setCcms01(ccms01);
		accountMessage.setCcmc02(ccmc02);
		accountMessage.setCcmc03(ccmc03);
		accountMessage.setCcmc04(new Date());
		accountMessage.setCcmr01(ccmr01);
		accountMessage.setCcmc05("0");
		dao.add(accountMessage);
	}
}
