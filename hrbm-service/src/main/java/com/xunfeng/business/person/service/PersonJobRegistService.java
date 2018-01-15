package com.xunfeng.business.person.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.service.CorpPositionService;
import com.xunfeng.business.person.dao.PersonJobRegistDao;
import com.xunfeng.business.person.interf.PersonJobRegistServiceInter;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonJobRegist;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.component.service.ReleaseRangeService;
import com.xunfeng.sys.config.interf.BaseConfigServiceInterf;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;

/**
 * <pre>
 * 对象功能:个人求职登记表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:59:03
 * </pre>
 */
@Service
public class PersonJobRegistService extends BaseService<PersonJobRegist> implements PersonJobRegistServiceInter {
    @Resource
    private PersonJobRegistDao dao;

    @Resource
    private CorpPositionService corpPositionService;
    @Resource
    private JobApplyService jobApplyService;
    @Resource
    private JobCollectService jobCollectService;
    @Resource
    private PersonBaseInfoService personBaseInfoService;
    @Resource
    private ReleaseRangeService eleaseRangeService;
    @Resource
	private UniqueIdUtilInterf uniqueIdUtil;
    @Resource
    BaseConfigServiceInterf baseConfigService;
    public PersonJobRegistService() {
    }
    
    @Override
    protected IEntityDao<PersonJobRegist, Long> getEntityDao() {
        return dao;
    }
    
    /**
     * 获得求职意向
     * 2016-04-29 修改
     */
    public PersonJobRegist getPersonJobRegist(Long aac001) {
        //TODO
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("aac001", aac001);
        //return dao.getUnique("", params);
        //  return dao.getUnique("getAll", );
        List<PersonJobRegist> personJobRegistList = dao.getList("getJobRegist", params);
        if(personJobRegistList!=null && personJobRegistList.size()>0){
        	return personJobRegistList.get(0);
        }else{
        	return null;
        }
    }

    public List<Map>  getLikeJob(QueryFilter queryFilter) {

        List<Map> likeJobList= dao.getListForm("getRecommendJob",queryFilter);
        if(likeJobList==null||likeJobList.size()<=0)
          likeJobList=dao.getListForm("getNewPositionList",queryFilter);;

        return likeJobList;
    }
    /**
     * 个人中心中的推荐职位列表数据
     */
    public ResultData<Map> getResultDataLikeJob(QueryFilter queryFilter,Long ccmu01,Long aac001){
    	 List<Map> likeJobList= dao.getListForm("getRecJob",queryFilter);
    	 if(likeJobList==null||likeJobList.size()<=0){
        	 likeJobList=dao.getListForm("getNewPosition",queryFilter);	
         }
    	 for(Map<String,Object> map : likeJobList){
    		 if(map.get("ACC214")!=null&&!map.get("ACC214").equals("")&&!map.get("ACC214").equals("null")){
    			 String acc214 = (String) map.get("ACC214");
    			 map.put("welfareList", corpPositionService.getWelfareByCode(acc214));
    		 }
    		String isJobApply = "N";
 			String isJobCollect = "N";
 			if(ccmu01 != 0l){
 				Long acb210 = Long.valueOf(map.get("ACB210").toString());
 				if(jobApplyService.isApply(acb210, aac001)){//是否发送了简历
 					isJobApply="Y";
 				}
 				if(jobCollectService.isCollect(acb210, ccmu01)){//是否收藏
 					isJobCollect="Y";
 				}
 			}
 			map.put("isJobApply", isJobApply);
 			map.put("isJobCollect", isJobCollect);
    	 }
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(likeJobList);
		return resultData;
	}
    
    public List<Map> getPersonResume(QueryFilter queryFilter){
		return (List<Map>)dao.getListForm("getPersonResumeForSearch",queryFilter);
	}      

    public ResultData<Map> getResultDataPersonResume(PageBean pageBean,Map param ){
		String keyword = (String)param.get("keyword");
		String workCity = (String)param.get("workCity");
		String age = (String)param.get("age");
		String workExp = (String)param.get("workExp");
		String education = (String)param.get("education");
		String workType = (String)param.get("workType");
		String labels = (String)param.get("labels");
		String jobType = (String)param.get("jobType");
		String political = (String)param.get("political");
		String updateDate = (String)param.get("updateDate");
    	QueryFilter fiter=new QueryFilter();
    	fiter.setPageBean(pageBean);

        //按职位名称、个人姓名查找
		 if(!"0".equals(keyword)){
             fiter.addFilter("ulltext","%"+keyword+"%");
         }
      //工作区域
        if (!"0".equals(workCity)){
            fiter.addFilter("acb202",workCity);
        }
      //工作经验
        if (!"0".equals(workExp)&& !"-2".equals(workExp)){
            fiter.addFilter("aac038",workExp);
        }
      //学历
        if (!"0".equals(education)&& !"-2".equals(education)){
            fiter.addFilter("aac011",education);
        }
      //年龄 未处理 
        if (!"0".equals(age) && !"-2".equals(age)){
        
        	if("1".equals(age)){
        		fiter.addFilter("startAge",16);
                fiter.addFilter("endAge",24);
        	}else if("2".equals(age)){
        		fiter.addFilter("startAge",25);
                fiter.addFilter("endAge",34);
        	}if("3".equals(age)){
        		fiter.addFilter("startAge",35);
                fiter.addFilter("endAge",44);
        	}if("4".equals(age)){
        		fiter.addFilter("startAge",45);
        	}if("9".equals(age)){
        		
        	}
            
        }
        if (!"0".equals(workType) && !"-2".equals(workType)){
            fiter.addFilter("acc201",workType);
        }
        if (!"0".equals(labels)){
        	String[] labelsArray=labels.split(",");
        	StringBuffer sb=new StringBuffer();
        	int i=0;
        	for(String label :labelsArray ){
        		
        		if(i==0){
        			sb.append(" instr(','||label_code||',' , ',' || '"+label+"' || ',')>0 ");
        		}else{
        			sb.append(" or instr(','||label_code||',' , ',' || '"+label+"' || ',')>0 ");
        			
        		}
        		i++;
        	}
            fiter.addFilter("labels",sb.toString());
        }
        if (!"0".equals(jobType)){
            
            String[]  jobTypeArray=jobType.split(",");
			StringBuffer sb=new StringBuffer();
			int i=0;
			for(String jobTypes :jobTypeArray){
				if(i==0){
					sb.append("t.bca111='"+jobTypes+"'" ).append("or t.bcaa11='"+jobTypes+"'" ).append(" or t.BCAB11='"+jobTypes+"'" );
				}else{
					sb.append("or t.bca111='"+jobTypes+"'" ).append("or t.bcaa11='"+jobTypes+"'" ).append(" or t.BCAB11='"+jobTypes+"'" );
				}			
				i++;
			}
			fiter.addFilter("jobType",sb.toString());
        }
        if (!"0".equals(political) && !"-2".equals(political)){
            fiter.addFilter("aac024",political);
        } 
        Calendar calendar = Calendar.getInstance();  
        Date date = new Date(); //获取当前时间
        calendar.setTime(date); 
        if (!"0".equals(updateDate) && !"-2".equals(updateDate) ){
        	if (!"0".equals(updateDate) && !"-2".equals(updateDate)) {
    			if("1".equals(updateDate)){//最近3天
    				calendar.add(Calendar.DAY_OF_MONTH, -3);  
    			}else if("2".equals(updateDate)){//最近7天
    				calendar.add(Calendar.DAY_OF_MONTH, -7);  
    			}else if("3".equals(updateDate)){//最近一个月
    				calendar.add(Calendar.DAY_OF_MONTH, -10);  
    			}else if("4".equals(updateDate)){//最近一个月
    				calendar.add(Calendar.MONTH, -1);  
    			}else{//最近三个月
    				calendar.add(Calendar.MONTH, -3);  
    			}
    			 date = calendar.getTime();  
    			 fiter.addFilter("ccpr03",date);
    		}
        }
    	List<Map> dataList =(List<Map>)dao.getListForm("getPersonResumeForSearch",fiter);		
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(fiter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
   
    public Map getPersonMap(Long aac001,Long ccmc01){
        Map params = new HashMap();
        params.put("aac001", aac001);
        params.put("ccmc01", ccmc01);
    	Map map =(Map)dao.getOne("getPersonResumeForDetail",params);		
		return map;
	}
    //获得个人求职详情并判断是不是已经加入人才库和发送了面试邀请
    public Map getPersonCollectionAndMianShiMap(Long aac001,Long ccmc01,Long acb210){
        Map params = new HashMap();
        params.put("aac001", aac001);
        params.put("ccmc01", ccmc01);
        params.put("acb210", acb210);
    	Map map =(Map)dao.getOne("getPersonCollectionAndMianShiMap",params);		
		return map;
	}
    
    
    /**
     * 
     * 通过个人编号获得求职登记信息 
     */
    public Map<String,Object> getJobRegistByPersonId (Long aac001){
    	Map<String,Object> map = new HashMap<String, Object>();
    	map.put("aac001", aac001);
    	map.put("valid", 0);
    	List<Map<String,Object>> jobRegistList = dao.getListBySqlKey("getJobRegistByPersonId", map);
    	if(jobRegistList != null && jobRegistList.size()>0){
    		return jobRegistList.get(0);
    	}else {
    		return null;
    	}
    	//return (Map<String, Object>) dao.getOne("getJobRegistByPersonId", map);
    }
    
    /**
     * 
     * 通过个人编号获得有效的求职登记信息 
     */
    public Map<String,Object> getValidJobRegistByPersonId(Long aac001){
    	Map<String,Object> map = new HashMap<String, Object>();
    	map.put("aac001", aac001);
    	map.put("valid", 1);
    	return (Map<String, Object>) dao.getOne("getJobRegistByPersonId", map);
    }
    
    /**
     * 刷新简历
     */
    public void refreshJobRegist (Long acc200,Timestamp date){
    	Map<String,Object> params = new HashMap<String,Object>();
        params.put("acc200", acc200);
        params.put("ccpr03", date);
    	dao.update("refreshJobRegist", params);
    }
    
    /**
     * 更新个人信息时更新简历信息
     */
    public void updateJobRegist (Long eduCode,Long jobRegistId){
    	 Map<String,Object> params = new HashMap<String,Object>();
         params.put("eduCode", eduCode);
         params.put("jobRegistId", jobRegistId);
         dao.update("updateJobRegist", params);
    }
    
	@Override
	public void add(PersonJobRegist personJobRegist){
		//修改个人信息表
		Long aac001 = personJobRegist.getAac001();
		PersonBaseInfo personBaseInfo = personBaseInfoService.getById(aac001);
		if(personBaseInfo.getCcmu51() == null || personBaseInfo.getCcmu51().equals("0")){
			personBaseInfo.setCcmu50((personBaseInfo.getCcmu50()==null?0:personBaseInfo.getCcmu50())+40);
			personBaseInfo.setCcmu51("1");//求职意向完整度
			personBaseInfo.setCcpr05(new Date());//最后修改时间
			personBaseInfo.setCcpr07("1");//修改来源网站
			personBaseInfoService.update(personBaseInfo);
		}
		dao.add(personJobRegist);
		//信息发布范围
		if(personJobRegist.getAcc20q() != null && !"".equals(personJobRegist.getAcc20q())){
			long personJobRegistId = personJobRegist.getAcc200();
			String jobRegistScope = personJobRegist.getAcc20q();
			eleaseRangeService.add(personJobRegistId, jobRegistScope.split(","), 2);
		}
	}
	@Override
	public void update(PersonJobRegist personJobRegist){
		dao.update(personJobRegist);
		long personJobRegistId = personJobRegist.getAcc200();
		String jobRegistScope = personJobRegist.getAcc20q();
		eleaseRangeService.add(personJobRegistId, jobRegistScope.split(","), 2);
	}
	/**
	 * 修改个人求职意向的状态保密或者公开
	 * personJobRegist 个人求职意向
	 * personId 个人编号
	 */
	public void updateJobRegistState(PersonJobRegist personJobRegist , long personId,int resumeState){
		PersonBaseInfo personBaseInfo = personBaseInfoService.getById(personId);
		if(resumeState ==0){//保密简历
			personBaseInfo.setCcmu50(personBaseInfo.getCcmu50()+40);
			personBaseInfo.setCcmu51("1");
		}else{//公开简历
			personBaseInfo.setCcmu50(personBaseInfo.getCcmu50()-40);
			personBaseInfo.setCcmu51("0");
		}
		personBaseInfoService.update(personBaseInfo);
		dao.update(personJobRegist);
		
	}

	/**
	 * 查询求职信息视图
	 * @param fiter 检索条件
	 * @return 
	 */
	@Override
    public ResultData<Map<String,Object>> getPersonRegistViewList(QueryFilter fiter){
    	@SuppressWarnings("unchecked")
		List<Map<String,Object>> dataList =(List<Map<String,Object>>)dao.getListForm("getJobRegistView",fiter);		
		ResultData<Map<String,Object>> resultData = new ResultData<Map<String,Object>>();
		resultData.setPageBean(fiter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
    }

	/**
	 * 个人求职统计查询
	 * @param fiter 检索条件
	 * @return 分页数据
	 */
	public ResultData<Map<String,Object>> getJobregStatistics(QueryFilter fiter){
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> dataList =(List<Map<String,Object>>)dao.getListForm("getJobregStatistics",fiter);
		ResultData<Map<String,Object>> resultData = new ResultData<Map<String,Object>>();
		resultData.setPageBean(fiter.getPageBean());
		resultData.setDataList(dataList);
		if(resultData!=null&&resultData.getDataList()!=null){
			Integer total = getJobregStatisticsCount(fiter);
    		for (Map<String, Object> dataMap : resultData.getDataList()) {
				//设置总数 计算数据
    			dataMap.put("TOTAL_NUM", total);
    			//百分比
    			dataMap.put("PERCENT", new BigDecimal(Integer.valueOf(dataMap.get("PERNUM").toString())).divide(new BigDecimal(total),2,BigDecimal.ROUND_HALF_UP));
			}
    	}
		return resultData;
	}
	
	/**
	 * 个人求职统计查询
	 * @param fiter 检索条件
	 * @return 分页数据
	 */
	public Integer getJobregStatisticsCount(QueryFilter fiter){
		@SuppressWarnings("unchecked")
		Map<String, Object> results = (Map<String, Object>) dao.getOne("getJobregStatisticsCount", fiter.getFilters());
	    return  Integer.valueOf(results.get("TOTALNUM").toString());
	}
	
	/**
	 * 根据个人Id获取所有的求职登记信息
	 * @param fiter 检索条件
	 * @return 分页数据
	 */
	public ResultData<PersonJobRegist> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<PersonJobRegist> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}

	@Override
	public PersonJobRegist getByPersonId(Long aac001) {
		// TODO Auto-generated method stub
		return (PersonJobRegist) dao.getOne("getByPersonId", aac001);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getJobRegistMapByPersonId(Long aac001) {
		return (Map<String, Object>) dao.getOne("getJobRegistMapByPersonId", aac001);
	};
	
	/**
	 * 查询有效的求职登记信息中意向职位是否重复
	 * @time2016-08-10 
	 * wanlupeng
	 * @return 
	 */
	public PersonJobRegist getIsExist(Long aac001,Long bca111){
		Map params = new HashMap();
        params.put("aac001", aac001);
        params.put("bca111", bca111);
		return (PersonJobRegist) dao.getOne("getIsExist", params);
	}
	
}
