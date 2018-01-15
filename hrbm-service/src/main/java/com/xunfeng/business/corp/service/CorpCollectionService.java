package com.xunfeng.business.corp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.dao.CorpCollectionDao;
import com.xunfeng.business.corp.dao.DownloadResumeDao;
import com.xunfeng.business.corp.interf.CorpCollectionServiceInterf;
import com.xunfeng.business.corp.model.CorpCollection;
import com.xunfeng.business.person.dao.JobApplyDao;
import com.xunfeng.business.person.model.JobApply;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.config.model.BaseConfig;
import com.xunfeng.sys.config.service.BaseConfigService;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.setMeal.exception.SetMealException;
import com.xunfeng.sys.setMeal.service.FeeOrderDetailService;
import com.xunfeng.sys.setMeal.util.MealResultConst;
import com.xunfeng.sys.setMeal.util.MealTypeEmun;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 企业人才收藏夹 Service类
* @author:jiangxin
* @createDate 2015-12-10 14:45:18 
* @version V1.0   
*/
@Service
public class CorpCollectionService extends BaseService<CorpCollection> implements CorpCollectionServiceInterf
{
	@Resource
	private CorpCollectionDao dao;
	@Resource
	private JobApplyDao jobApplyDao;
	@Resource
	UniqueIdUtilService  UniqueIdUtil;
	@Resource
	private DownloadResumeDao downloadResumeDao;
	@Resource
	private FeeOrderDetailService feeOrderDetailService;
	@Resource
	private BaseConfigService baseConfigService;
	
	public CorpCollectionService()
	{
	}
	
	@Override
	protected IEntityDao<CorpCollection, Long> getEntityDao() 
	{
		return dao;
	}
	//获取企业收藏人员名单
	public ResultData<Map>  getCorpCollectionList(QueryFilter queryFilter){
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dao.getListForm("getCorpCollectionList",queryFilter));
		return resultData;

	}
	
	public Long getTotalCount(Long ccmu01){
		Map params = new HashMap();
		params.put("ccmu01",ccmu01);
		return (Long)dao.getOne("getTotalCount",params);
	}
	public Long getNotLookCount(Long ccmu01,Long ccpr10){
		Map params = new HashMap();
		params.put("ccmu01",ccmu01);
		params.put("ccpr10",ccpr10);
		return (Long)dao.getOne("getNotLookCount",params);
	}
	
	public CorpCollection getCorpCollection(Long ccmc01,Long ccmp01){
		Map params = new HashMap();
		params.put("ccmc01",ccmc01);
		params.put("ccmp01",ccmp01);
		return (CorpCollection)this.dao.getOne("getCorpCollection", params);
	}
	//批量添加企业收藏简历
	public void batchAddCollection(Long[] corpResumeIds,Long aab001){
		for(Long CCPJ01:corpResumeIds){
			JobApply jobApply = jobApplyDao.getById(CCPJ01);
			CorpCollection cc = this.getCorpCollection(aab001, jobApply.getCcmu01());
			if(cc==null){
				CorpCollection corpCollection = new CorpCollection();
				corpCollection.setCcpg01(UniqueIdUtil.genId(CorpCollection.class.getName()));
				corpCollection.setCcmc01(aab001);
				corpCollection.setCcmp01(jobApply.getCcmu01());
				corpCollection.setCcpg02(new Date());
				corpCollection.setCcpr08("0");
				corpCollection.setCcpr10(0l);
				corpCollection.setAcb210(jobApply.getAcb210());
				dao.add(corpCollection);
			}
		}
	}
	//批量收藏简历
	public void batchCollectionResume(Long[] corpResumeIds,Long aab001){
		for(Long aac001:corpResumeIds){
			CorpCollection cc = this.getCorpCollection(aab001, aac001);
			if(cc==null){
				CorpCollection corpCollection = new CorpCollection();
				corpCollection.setCcpg01(UniqueIdUtil.genId(CorpCollection.class.getName()));
				corpCollection.setCcmc01(aab001);
				corpCollection.setCcmp01(aac001);
				corpCollection.setCcpg02(new Date());
				corpCollection.setCcpr08("0");
				corpCollection.setCcpr10(0l);
				dao.add(corpCollection);
			}
		}
	}
	//单个收藏简历
	public void sigleCollectionResume(Long aab001,Long aac001){
		CorpCollection cc = this.getCorpCollection(aab001, aac001);
		if(cc==null){
			CorpCollection corpCollection = new CorpCollection();
			corpCollection.setCcpg01(UniqueIdUtil.genId(CorpCollection.class.getName()));
			corpCollection.setCcmc01(aab001);
			corpCollection.setCcmp01(aac001);
			corpCollection.setCcpg02(new Date());
			corpCollection.setCcpr08("0");
			corpCollection.setCcpr10(0l);
			dao.add(corpCollection);
		}
	}
	//验证当前人是不是已经加入人才库
	public boolean checkPersonIsOfNotCollection(Long aab001,Long aac001){
		boolean flag=true;
		Map params = new HashMap();
		params.put("ccmc01",aab001);
		params.put("ccmp01",aac001);
		Long aa = (Long)this.dao.getOne("checkPersonIsOfNotCollection", params);
		if(aa!=1){
			flag=false;
		}
		return flag;
	}
	/**
	 * 增加人才库
	 * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
	 * @param aab001 企业编号
	 * @param aab004 企业名称
	 * @param Long[] corpResumeIds
	 * @throws SetMealException 套餐不足整个事物回滚 
	 */
	//批量添加企业收藏简历
	public void batchAddCollectionPayOper(Map<String,Object> map) throws SetMealException{
		Long[] corpResumeIds = (Long[])map.get("corpResumeIds"); 
		Long aab001 = Long.valueOf(map.get("aab001").toString());
		if(isNeedFee()){//扣费
			String aab004 = String.valueOf(map.get("aab004"));
			for(Long CCPJ01:corpResumeIds){
				JobApply jobApply = jobApplyDao.getById(CCPJ01);
				CorpCollection cc = this.getCorpCollection(aab001, jobApply.getCcmu01());
				if(cc==null){
					String flag =  feeOrderDetailService.updateFeeOrderCount(aab001,aab004,MealTypeEmun.TALENTPEOPLE.getCode(),1);
					if(MealResultConst.SUC.equals(flag)){
						CorpCollection corpCollection = new CorpCollection();
						corpCollection.setCcpg01(UniqueIdUtil.genId(CorpCollection.class.getName()));
						corpCollection.setCcmc01(aab001);
						corpCollection.setCcmp01(jobApply.getCcmu01());
						corpCollection.setCcpg02(new Date());
						corpCollection.setCcpr08("0");
						corpCollection.setCcpr10(0l);
						corpCollection.setAcb210(jobApply.getAcb210());
						dao.add(corpCollection);
					}else{
						throw new SetMealException("套餐不足");
					}
				}
			}
		}else{
			for(Long CCPJ01:corpResumeIds){
				JobApply jobApply = jobApplyDao.getById(CCPJ01);
				CorpCollection cc = this.getCorpCollection(aab001, jobApply.getCcmu01());
				if(cc==null){
					CorpCollection corpCollection = new CorpCollection();
					corpCollection.setCcpg01(UniqueIdUtil.genId(CorpCollection.class.getName()));
					corpCollection.setCcmc01(aab001);
					corpCollection.setCcmp01(jobApply.getCcmu01());
					corpCollection.setCcpg02(new Date());
					corpCollection.setCcpr08("0");
					corpCollection.setCcpr10(0l);
					corpCollection.setAcb210(jobApply.getAcb210());
					dao.add(corpCollection);
				}
			}
		}
	}
	/**
	 * 加入人才库
	 * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
	 * @param aab001 企业编号
	 * @param aab004 企业名称
	 * 
	 *@param  Long[] corpResumeIds,
	 *@throws SetMealException 套餐不足整个事务回滚 
	 */
	//批量收藏简历
	public void batchCollectionResumePayOper(Map<String,Object> map) throws SetMealException{
		Long[] corpResumeIds = (Long[])map.get("corpResumeIds");
		Long aab001 = Long.valueOf(map.get("aab001").toString());
		if(isNeedFee()){//扣费
			String aab004 = String.valueOf(map.get("aab004"));
			for(Long aac001:corpResumeIds){
				CorpCollection cc = this.getCorpCollection(aab001, aac001);
				if(cc==null){
					String flag =  feeOrderDetailService.updateFeeOrderCount(aab001,aab004,MealTypeEmun.TALENTPEOPLE.getCode(),1);
					if(MealResultConst.SUC.equals(flag)){
						CorpCollection corpCollection = new CorpCollection();
						corpCollection.setCcpg01(UniqueIdUtil.genId(CorpCollection.class.getName()));
						corpCollection.setCcmc01(aab001);
						corpCollection.setCcmp01(aac001);
						corpCollection.setCcpg02(new Date());
						corpCollection.setCcpr08("0");
						corpCollection.setCcpr10(0l);
						dao.add(corpCollection);
					}else{
						throw new SetMealException("套餐不足");
					}
				}
			}
		}else{//免费
			for(Long aac001:corpResumeIds){
				CorpCollection cc = this.getCorpCollection(aab001, aac001);
				if(cc==null){
					CorpCollection corpCollection = new CorpCollection();
					corpCollection.setCcpg01(UniqueIdUtil.genId(CorpCollection.class.getName()));
					corpCollection.setCcmc01(aab001);
					corpCollection.setCcmp01(aac001);
					corpCollection.setCcpg02(new Date());
					corpCollection.setCcpr08("0");
					corpCollection.setCcpr10(0l);
					dao.add(corpCollection);
				}
			}
		}
	}
	/**
	 * 增加广告
	 * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
	 * @param aab001 企业编号
	 * @param aab004 企业名称
	 * 
	 * @param aac001 个人编号
	 */
	public String sigleCollectionResumePayOper(Map<String,Object> map){
		String flag = MealResultConst.SUC;
		Long aac001 = Long.valueOf(map.get("aac001").toString());
		Long aab001 = Long.valueOf(map.get("aab001").toString());
		if(isNeedFee()){//扣费
			String aab004 = String.valueOf(map.get("aab004"));
			flag =  feeOrderDetailService.updateFeeOrderCount(aab001,aab004,MealTypeEmun.TALENTPEOPLE.getCode(),1);
			if(MealResultConst.SUC.equals(flag)){//成功
				sigleCollectionResume( aab001,aac001);
			}
		}else{//免费
			sigleCollectionResume( aab001,aac001);
		}
		return flag;
    }
	/**
	 * 加入人才库
	 * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
	 * @param aab001 企业编号
	 * @param aab004 企业名称
	 * @param CorpCollection corpCollection 
	 */
	public String addPayOper(Map<String,Object> map){
		String flag = MealResultConst.SUC;
		CorpCollection corpCollection = (CorpCollection)map.get("corpCollection");
		if(isNeedFee()){//
			Long aab001 = Long.valueOf(map.get("aab001").toString());
			String aab004 = String.valueOf(map.get("aab004"));
			flag =  feeOrderDetailService.updateFeeOrderCount(aab001,aab004,MealTypeEmun.TALENTPEOPLE.getCode(),1);
			if(MealResultConst.SUC.equals(flag)){//成功
				dao.add(corpCollection);
			}
		}else{
			dao.add(corpCollection);
		}
		return flag;
	}
	/**
     * 节点是否收费
     * @param categoryIndent 广告的分类Id
     * @return boolean true :扣费 false:免费
     */
    private boolean isNeedFee(){
    	BaseConfig baseConfig = baseConfigService.getConfigByName("member_IsPay");
    	String caos04 = baseConfig.getCaos04();
    	if(caos04.equals("1")){//收费
    		baseConfig = baseConfigService.getConfigByName("member_IsPay_addTalentedPerson");
    		caos04 = baseConfig.getCaos04();
    	}
    	return caos04.equals("1")?true:false;
    }
}
