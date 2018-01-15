package com.xunfeng.sys.setMeal.interf;


import com.xunfeng.sys.setMeal.model.FeeOrderDetail;
import com.xunfeng.core.service.GenericServiceInterface;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 套餐订购详表 接口类
* @author:
* @createDate 2016-07-19 09:19:03 
* @version V1.0   
*/
public interface FeeOrderDetailServiceInterf extends GenericServiceInterface<FeeOrderDetail,Long>
{
	/**
	 * 扣除套餐数量
	 * @param aab001 企业编号
	 * @param servCode 服务细项代码
	 * @param totalCount 扣除的总数
	 * @return String
	 */
	public String updateFeeOrderCount(Long aab001,String aab004,String servCode,int count);
}
