package com.xunfeng.sys.setMeal.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import oracle.sql.DATE;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.setMeal.model.FeeOrderDetail;
import com.xunfeng.sys.setMeal.model.FeeServCfg;
import com.xunfeng.sys.setMeal.model.FeeUseDetail;
import com.xunfeng.sys.setMeal.dao.FeeOrderDetailDao;
import com.xunfeng.sys.setMeal.interf.FeeOrderDetailServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 套餐订购详表 Service类
* @author:
* @createDate 2016-07-19 09:19:03 
* @version V1.0   
*/
@Service
public class FeeOrderDetailService extends BaseService<FeeOrderDetail> implements FeeOrderDetailServiceInterf
{
	@Resource
	private FeeOrderDetailDao dao;
	@Resource
	private FeeServCfgService feeServCfgService;
	@Resource
	private FeeUseDetailService feeUseDetailService;
	 @Resource
	private UniqueIdUtilInterf uniqueIdUtil;
	
	public FeeOrderDetailService()
	{
	}
	
	private final String SUC="0"; //成功
	private final String LACKMEALT="1";//套餐不足
	private final String INVALIDSERVCFG="2";//条目不可用
	@Override
	protected IEntityDao<FeeOrderDetail, Long> getEntityDao() 
	{
		return dao;
	}
	/**
	 * 统计企业套餐的细项数量
	 * @param aab001 企业编号
	 * @param servCode 服务细项代码
	 * @return 可用的套餐数量
	 */
	public Long getTotalCount(Long aab001,String servCode){
		Map <String,Object> map = new HashMap<String,Object>();
		map.put("aab001",aab001);
		map.put("servCode",servCode);
		Long totalCount = (Long) dao.getOne("getTotalCount", map);
		return totalCount;
	}
	
	/**
	 * 扣除套餐数量
	 * @param aab001 企业编号
	 * @param servCode 服务细项代码
	 * @param count 扣除的总数
	 * @return String
	 */
	public String updateFeeOrderCount(Long aab001,String aab004,String servCode,int count){
		Long totalCount = getTotalCount(aab001,servCode);
		if(totalCount <=0 || totalCount<count){//套餐不足请购买
			return LACKMEALT; 
		}else{
			FeeServCfg sercCfg = feeServCfgService.getByservCode(servCode);
			if(sercCfg==null){//不存在此项放行
				return  LACKMEALT;
			}else{
				//Long sumMoney = sercCfg.getServFee();
				//扣除套餐
				Map <String,Object> map = new HashMap<String,Object>();
				map.put("aab001",aab001);
				map.put("servCode",servCode);
				//制定细项的总数
				List<FeeOrderDetail> listOrderDetail = dao.getBySqlKey("getListOrderDetail",map);
				//TODO
				if(listOrderDetail!=null && listOrderDetail.size()>0){
					int resetCount = count;//循环扣除套餐数量
					for(FeeOrderDetail orderDetail: listOrderDetail){
						Long orderDetailCount = orderDetail.getRestCount();
						if(orderDetailCount>=resetCount){//套餐数量大于扣除数量
							//resetCount = (int) (orderDetailCount-resetCount);
							//剩余数量
							orderDetail.setRestCount(orderDetailCount-resetCount);
							//使用数量
							updateOrderDetail(orderDetail,aab001,aab004,servCode,resetCount,sercCfg.getServName());
							break;
						}else{//套餐数量小于扣除数量 
							resetCount = (int) (resetCount-orderDetailCount);
							orderDetail.setRestCount(0l);
							updateOrderDetail(orderDetail,aab001,aab004,servCode,Long.valueOf(orderDetailCount).intValue(),sercCfg.getServName());
						}
						
					}
				}
				return SUC;
			}
		}
	}
	/**
	 * 修改订单详情表中数据 并做记录
	 * @param orderDetail 订单详情
	 * @param aab001 企业编号
	 * @param aab004 企业名称
	 * @param servCode服务项代码
	 * @param resetCount剩余数量
	 * @param servName服务项名称
	 */
	public void updateOrderDetail(FeeOrderDetail orderDetail,Long aab001,String aab004,String servCode,int resetCount,String servName){
		dao.update(orderDetail);
		FeeUseDetail feeUseDetail = new FeeUseDetail();
		// 使用流水
		feeUseDetail.setUseSn(uniqueIdUtil.genId(FeeUseDetail.class.getName()));
		// 订购流水
		feeUseDetail.setOrderSn(orderDetail.getOrderSn());
		// 订购详单流水
		feeUseDetail.setDetailSn(orderDetail.getDetailSn());
		// 单位编号
		feeUseDetail.setAab001(aab001);
		// 单位名称
		feeUseDetail.setAab004(aab004);
		// 细项编号
		feeUseDetail.setServCode(servCode);
		// 使用数量
		feeUseDetail.setUseCount((long)resetCount);
		// 消费业务  可以自定义业务编码存入该字段，方便统计
		//protected String  consumeCode;
		// 消费说明
		feeUseDetail.setConsumeRemark(servName);
		// 来源
		feeUseDetail.setCczy06("1");
		// 有效标识 1 有效,0 无效
		feeUseDetail.setIsValid("1");
		// 经办人
		feeUseDetail.setAae011(String.valueOf(aab001));
		// 经办人名称
		feeUseDetail.setAae019(aab004);
		// 经办时间
		feeUseDetail.setAae036(new Date());
		// 备注
		//protected String  remark;
		feeUseDetailService.add(feeUseDetail);
	}
	
}
