package com.xunfeng.business.advert.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import oracle.sql.DATE;

import org.springframework.stereotype.Service;

import com.xunfeng.business.advert.dao.AdCompanyDao;
import com.xunfeng.business.advert.interf.AdCompanyServiceInterf;
import com.xunfeng.business.advert.model.AdCategory;
import com.xunfeng.business.advert.model.AdCompany;
import com.xunfeng.business.advert.util.AdIndentConst;
import com.xunfeng.business.corp.model.Corp;
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
* @Description: 广告位放置表 Service类
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
@Service
public class AdCompanyService extends BaseService<AdCompany> implements AdCompanyServiceInterf
{
	@Resource
	private AdCompanyDao dao;
	@Resource
	private AdCategoryService adCategoryService;
	@Resource
	private BaseConfigService baseConfigService;
	@Resource
	private FeeOrderDetailService feeOrderDetailService;
	@Resource
	private AdDelRecordService adDelRecordService;
	@Resource
	UniqueIdUtilService  uniqueIdUtil;
	
	
	public AdCompanyService()
	{
	}
	
	@Override
	protected IEntityDao<AdCompany, Long> getEntityDao() 
	{
		return dao;
	}
	
	
	/**
	 * 根据标示获得不做广告的企业信息(分页)
	 */
	public ResultData<Corp> getNoAdCompanyByExcept(QueryFilter queryFilter,String aab004){
    	queryFilter.addFilter("aab004", aab004);
		List<Corp> dataList = dao.getListForm("getCompanyByExcept",queryFilter);
		ResultData<Corp> resultData = new ResultData<Corp>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	/**
     * 做广告的企业
     */
	public List<Map<String,Object>> getadCompanyByIndent(String indent){
		return dao.getListBySqlKey("getadCompanyByIndent", indent);
	}
	/**
     * 做广告的企业（分页）并发布职位的企业
     */
    public ResultData<Map> getadCompanyPageByIndent(QueryFilter queryFilter,String indent){
    	queryFilter.addFilter("indent", indent);
    	List<Map> dataList = dao.getListForm("getadCompanyByIndentPage",queryFilter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
    }
	/**
	 * 栏目版块中列表的排序
	 */
    public void sortOrderNum(Long id,Long orderNum){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("id", id);
    	map.put("ordernum", orderNum);
    	dao.update("updateOrderNum", map);
    }
    /**
     * 批量保存栏目中列表的排序
     */
    public void sortOrderNumBatch(Long[] lAryId){
    	for(int i=0;i<lAryId.length;i++){
			sortOrderNum(lAryId[i], (long)i);
		}
    }
    /**
	 * 通过企业id和分类标识获得所有数据
	 */
	public List<Map<String,Object>> getAdByCorpidAndIndent(Long aab001,String indent){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("aab001", aab001);
		map.put("indent", indent);
		return dao.getListBySqlKey("getAdByCorpidAndIndent",map);
		
	}
	/**
	 * 通过记录id修改图片路径
	 * @param id
	 * @param imgPath
	 */
	public void updateImgPathById(Long id,String imgPath){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("caae01", id);
		map.put("caae03", imgPath);
		map.put("caae08", new DATE());
		dao.update("updateImgPathById", map);
	}
	
    /******************************************job*********************************************/
    /**
     * 做广告的职位
     */
    public List<Map<String,Object>> getadJobByExcept(QueryFilter queryFilter){
		List<Map<String,Object>> dataList = dao.getListForm("getadJobByExcept",queryFilter);
		return dataList;
    }
    
    /**
     * 没有做广告的职位
     */
    public ResultData getJobByExcept(QueryFilter queryFilter){
		List<Object> dataList = dao.getListForm("getJobByExcept",queryFilter);
		ResultData<Object> resultData = new ResultData<Object>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
    }
    
    /**
	 * 做广告的职位列表 (分页)
	 * 包括有工资 学历 经验 公司详情
	 */
    public ResultData getadJobPageByIndent(QueryFilter queryFilter,String indent){
    	queryFilter.addFilter("indent", indent);
    	List<Object> dataList = dao.getListForm("getadJob",queryFilter);
		ResultData<Object> resultData = new ResultData<Object>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
    }
    /**
	 * 做广告的职位列表 (分页)
	 * 包括有工资 学历 经验 公司详情 
	 * 2016-04-13
	 */
	public ResultData getadJobList(QueryFilter queryFilter){
		List<Map> jobList = dao.getListForm("getadJob", queryFilter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(jobList);
		return resultData;
	}
    
    /**
     * 把职位设为广告
     * @param jobid 职位id
     * @param indent 分类标示
     */
    public void addJobAdvert(Long jobid,String indent){
    	AdCategory category = adCategoryService.getByIndent(indent);
    	Long categoryId = category.getCaac01();
    	AdCompany adjob = new AdCompany();
		adjob.setCaae01(uniqueIdUtil.genId(AdCompany.class.getName()));
		adjob.setCaac01(categoryId);//	广告类编号
		adjob.setCaae02("职位广告");//广告描述
    	adjob.setCaae10(1l);//"状态1正常显示2隐藏 4结束5审核中 6审核不通过"
    	adjob.setAae036(new Date());//	经办日期
    	adjob.setJobid(jobid);//职位编号
    	adjob.setCczy06("1");//数据来源0未知1网站后台2网站
    	dao.add(adjob);
    }
    
    /**
     * 把职位设为广告批量  jobIdStr 以逗号分开的字符 但是要保证 分开后的数据必须可以转化成Long类型
     * @param jobIdStr
     * @param indent 分类标示
     */
    public void addJobAdvertBatch(Long[] corpPositionIds,String indent){
    	AdCategory category = adCategoryService.getByIndent(indent);
    	Long categoryId = category.getCaac01();
		for(Long corpPositionId:corpPositionIds){
			Long jobId = Long.valueOf(corpPositionId);
			Long aa = this.checkedAdCompany(categoryId, jobId);
			if(aa==0){
				AdCompany adjob = new AdCompany();
				adjob.setCaae01(uniqueIdUtil.genId(AdCompany.class.getName()));
				adjob.setCaac01(categoryId);//	广告类编号
				adjob.setCaae02("职位广告");//广告描述
				adjob.setCaae10(1l);//"状态1正常显示2隐藏 4结束5审核中 6审核不通过"
				adjob.setCaae11(1l);//"类型1文字2图片3flash
				adjob.setAae036(new Date());//	经办日期
				adjob.setJobid(jobId);//职位编号
				adjob.setCczy06("2");//数据来源0未知1网站后台2网站
				dao.add(adjob);
			}
		}
    }
    public Long checkedAdCompany(Long caac01,Long jobId){
    	Map<String,Object> map = new HashMap<String, Object>();
		map.put("caac01", caac01);
		map.put("jobid", jobId);
		map.put("cczy06", 2);
		return (Long)dao.getOne("checkedAdCompany", map);
    }
    /**
     * 增加广告点击次数
     * @param caae01 广告主键
     */
    public void updateHitNum(Long caae01){
    	Map<String,Object> map = new HashMap<String, Object>();
    	map.put("CAAE01", caae01);
    	dao.update("updateHitNum", map);
    }
   /**
    * 删除广告增加删除广告记录表
    * @param lAryId 广告id
    * 2016-08-03
    */
   
   public void delBathAdByIds(Long[] lAryId,String currentUserName){
	  for(Long id : lAryId){
		  delAdById(id,currentUserName);
	  }
   }
   /**
    * 删除广告增加删除广告记录表
    * @param id 广告id
    * 2016-08-03
    */
   public void delAdById(Long id,String currentUserName){
	   adDelRecordService.addRecordCompanyAdById(id,currentUserName);
	   this.delById(id);
   }
    /***************************************广告收费****************************************************/
    /**
     * 把职位设为广告
	 * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
	 * @param aab001 企业编号
	 * @param aab004 企业名称
	 * 
	 * @param jobid 职位id
	 * @param indent 设置的标示
	 * @return String
	 */
    public String addJobPayOper(Map<String,Object> map){
    	String indent = String.valueOf(map.get("indent"));
    	Long jobid = Long.valueOf(map.get("jobid").toString());
    	AdCategory category = adCategoryService.getByIndent(indent);
    	Long categoryId = category.getCaac01();
    	String needFeeServCode = isNeedFee(categoryId);
    	String flag = "0";
    	if(!"none".equals(needFeeServCode)){//需要收费
    		Long aab001 = Long.valueOf(map.get("aab001").toString());
    		String aab004 = String.valueOf(map.get("aab004"));
    		flag =  feeOrderDetailService.updateFeeOrderCount(aab001,aab004,needFeeServCode,1);
    		if(MealResultConst.SUC.equals(flag)){//成功
    			addJobAdvert(jobid,indent);
    		}
    	}else{
    		addJobAdvert(jobid,indent);
    	}
		return flag;
		
    }
    /**
     * 把职位设为广告批量 
     * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
     * @param aab001 企业编号
	 * @param aab004 企业名称
	 * @param indent 设置的标示
     *   corpPositionIds 以逗号分开的字符 但是要保证 分开后的数据必须可以转化成Long类型
     * @throws SetMealException 套餐不足整个事物回滚 
     */
    public void addJobAdvertBatchPayOper(Map<String,Object> map) throws SetMealException{
    	//判断扣费的节点
    	String indent = String.valueOf(map.get("indent"));
    	Long[] corpPositionIds = (Long[])map.get("corpPositionIds");
    	
    	AdCategory category = adCategoryService.getByIndent(indent);
    	Long categoryId = category.getCaac01();
    	String needFeeServCode = isNeedFee(categoryId);
    	if(!"none".equals(needFeeServCode)){//需要收费
    		Long aab001 = Long.valueOf(map.get("aab001").toString());
    		String aab004 = String.valueOf(map.get("aab004"));
    		for(Long corpPositionId:corpPositionIds){
    			Long jobId = Long.valueOf(corpPositionId);
    			Long aa = this.checkedAdCompany(categoryId, jobId);
    			if(aa==0){
    				String flag  =  feeOrderDetailService.updateFeeOrderCount(aab001,aab004,needFeeServCode,1);
    				if(MealResultConst.SUC.equals(flag)){//成功
    					AdCompany adjob = new AdCompany();
    					adjob.setCaae01(uniqueIdUtil.genId(AdCompany.class.getName()));
    					adjob.setCaac01(categoryId);//	广告类编号
    					adjob.setCaae02("职位广告");//广告描述
    					adjob.setCaae10(1l);//"状态1正常显示2隐藏 4结束5审核中 6审核不通过"
    					adjob.setCaae11(1l);//"类型1文字2图片3flash
    					adjob.setAae036(new Date());//	经办日期
    					adjob.setJobid(jobId);//职位编号
    					adjob.setCczy06("2");//数据来源0未知1网站后台2网站
    					dao.add(adjob);
    				}else{
    					throw new SetMealException("套餐不足");
    				}
    			}
    		}
    	}else{//不需要扣费
    		 addJobAdvertBatch(corpPositionIds,indent);
    	}
    }
    /**
     * 增加广告
     * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
     * @param aab001 企业编号
	 * @param aab004 企业名称
     * @param adCompany 要保存的实体类 一般在map中的key为实体类的名称第一个字母小写
     */
    public String addPayOper(Map<String,Object> map){
    	AdCompany adcom = (AdCompany)map.get("adCompany");
    	//判断扣费的节点
    	Long adCategoryId = adcom.getCaac01();
    	String needFeeServCode = isNeedFee(adCategoryId);
    	String flag = "0";
    	if(!"none".equals(needFeeServCode)){//需要收费
    		Long aab001 = Long.valueOf(map.get("aab001").toString());
    		String aab004 = String.valueOf(map.get("aab004"));
    		flag =  feeOrderDetailService.updateFeeOrderCount(aab001,aab004,needFeeServCode,1);
    		if(MealResultConst.SUC.equals(flag)){//成功
    			dao.add(adcom);
    		}
    	}else{//不需要收费
    		dao.add(adcom);
    	}
    	return flag;
    }
    /**
     * 节点是否收费
     * @param categoryIndent 广告的分类Id
     * @return String if ('none')不需要收费;  else(return servcode) 
     */
    private String isNeedFee(Long categoryId){
    	BaseConfig baseConfig = baseConfigService.getConfigByName("member_IsPay");
    	String caos04 = baseConfig.getCaos04();
    	String servCode = "none";
    	if(caos04.equals("1")){//收费
    		AdCategory category = adCategoryService.getById(categoryId);
    		String categoryIndent = category.getIndent();
    		if((AdIndentConst.BRANDCORP).equals(categoryIndent)){//品牌企业
    			baseConfig = baseConfigService.getConfigByName("member_IsPay_brankCorp");
    			servCode = MealTypeEmun.BRANDCORP.getCode();
    		}else if((AdIndentConst.RECCORP).equals(categoryIndent)){//推荐企业
    			baseConfig = baseConfigService.getConfigByName("member_IsPay_recCorp");
    			servCode = MealTypeEmun.RECCORP.getCode();
    		}else if((AdIndentConst.CENTREWEBAD).equals(categoryIndent)){//中部企业广告
    			baseConfig = baseConfigService.getConfigByName("member_IsPay_centeradJob");
    			servCode = MealTypeEmun.CENTERAD.getCode();
    		}else{//急聘职位
    			baseConfig = baseConfigService.getConfigByName("member_IsPay_seniorJob");
    			servCode = MealTypeEmun.SENIORJOB.getCode();
    		}
    		//如果总开关为收费 ，判断最终细项开关
    		caos04 = baseConfig.getCaos04();
    		if(caos04.equals("1")){
    			return servCode;
    		}else{
    			return "none";
    		}
    	}else{
    		return "none";
    	}
    }
    
}
