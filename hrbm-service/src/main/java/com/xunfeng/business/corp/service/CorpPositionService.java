package com.xunfeng.business.corp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.dao.CorpPositionDao;
import com.xunfeng.business.corp.dto.CorpPositionDto;
import com.xunfeng.business.corp.dto.CorpSavePositionDto;
import com.xunfeng.business.corp.interf.CorpPositionServiceInter;
import com.xunfeng.business.corp.model.CorpPosition;
import com.xunfeng.business.corp.model.CorpPositionPublish;
import com.xunfeng.business.person.service.JobApplyService;
import com.xunfeng.business.person.service.JobCollectService;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.accounts.service.AccountsService;
import com.xunfeng.sys.component.service.ReleaseRangeService;
import com.xunfeng.sys.config.model.BaseConfig;
import com.xunfeng.sys.config.service.BaseConfigService;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.setMeal.exception.SetMealException;
import com.xunfeng.sys.setMeal.service.FeeOrderDetailService;
import com.xunfeng.sys.setMeal.util.MealResultConst;
import com.xunfeng.sys.setMeal.util.MealTypeEmun;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.service.SysOrgService;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 招聘空位信息表 Service类
* @author:wxl
* @createDate 2015-07-24 11:31:13 
* @version V1.0   
*/
@Service
public class CorpPositionService extends BaseService<CorpPosition> implements CorpPositionServiceInter
{
	@Resource
	private CorpPositionDao dao;
	@Resource
	private AccountsService accountsService;
	@Resource
	private CorpService corpService;
	
	@Resource
	private JobApplyService jobApplyService;
	@Resource
	private JobCollectService jobCollectService;

	@Resource
	private CorpPositionPublishService corpPositionPublishService;
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private CorpPositionService corpPositionService;
	@Resource
	private ReleaseRangeService releaseRangeService;
	@Resource
	private BaseConfigService baseConfigService;
	@Resource
	private FeeOrderDetailService feeOrderDetailService;
	@Resource
	UniqueIdUtilService  UniqueIdUtil;
	
	@Resource
	private SysOrgService sysOrgService;
	public CorpPositionService()
	{
	}
	
	@Override
	protected IEntityDao<CorpPosition, Long> getEntityDao()
	{
		return dao;
	}
	/**
	 * 暂停职位（就是冻结职位）
	 * 	冻结标记 String acb208   (1为冻结 ) 冻结人员 String  acb20d freezeName
	 *	冻结日期 Date  acb20e   冻结原因 String  acb20l  (对应tab_UFREASONS 中的code) 202 单位主动
	 */
	public void freezeCorpPosition(Long[] corpPositionIds,Accounts accounts){
		for(Long corpPositionId:corpPositionIds){
			dao.freezeCorpPosition(corpPositionId,accounts.getCcmu02(),new Date(),"202");
		}

	}
	
	/**
	 * 暂停职位(冻结职位)
	 * 冻结标记 String acb208   (1为冻结 ) 冻结人员 String  acb20d freezeName  冻结日期 Date  acb20e   
	 * 冻结原因 String  acb20l  (对应tab_UFREASONS 中的code) 
	 * @param corpPositionIds 职位ID
	 * @param accounts 登录人员信息
	 */
	public void freezeCorpPositionCode(Long[] corpPositionIds,String userName,String code){
		for(Long corpPositionId:corpPositionIds){
			dao.freezeCorpPosition(corpPositionId,userName,new Date(),code);
		}

	}
	
	/**
	 * 刷新职位
	 */
	public void refreshCorpPosition(Long[] corpPositionIds){
		//单位招聘信息有效日期，以天为单位 sys_zp_date
		BaseConfig baseConfigEndDate = baseConfigService.getConfigByName("sys_zp_date");
		Date endDate = DateUtil.getDelayDayDateBy(Integer.valueOf(baseConfigEndDate.getCaos04()));
		Set set = new HashSet();
		for(Long corpPositionId:corpPositionIds){
			CorpPosition cp = dao.getById(corpPositionId);
			cp.setCczy09(new Date());
			/**
			 *   职位的结束时间制成 （当前时间+配置时间） cb21
			 * 	   招聘信息中结束时间制成 （当前时间+配置时间）cb20
			 *   2016-06-28 wyy修改
			 */
			cp.setAae031(endDate);
			dao.update(cp);
			set.add(cp.getAcb200());
		}
	   Iterator it=set.iterator();
       while(it.hasNext()){
    	  long acb200 = (Long)it.next();
    	  CorpPositionPublish positionPubList = corpPositionPublishService.getById(acb200);
    	  positionPubList.setAae031(endDate);
    	  corpPositionPublishService.update(positionPubList);
	   }
	}
	
	/**
	 * 删除职位   ccpr08   是否删除状态（0-否1-是） 最后修改人、最后修改时间、修改来源
	 * @param corpPositionIds
	 */
	public void deleteCorpPosition(Long[] corpPositionIds,Accounts loginUser){
		for(Long corpPositionId:corpPositionIds){
			dao.deleteCorpPosition(corpPositionId,loginUser.getCcmu02(),new Date(),"1");
		}
	}
	
	
	/**
	 * 解冻职位
	 */
	public void unfreezeCorpPosition(Long[] corpPositionIds) {
		for(Long corpPositionId:corpPositionIds){
			dao.unfreezeCorpPosition(corpPositionId);
		}
	}

	/**
	 * 查询发布的职位，查询根据冻结标识进行筛选
	 * ccb208: 0发布中 1 暂停中 -1 已过期
	 */
	public ResultData<CorpPositionDto> getAllCorpPosition(QueryFilter filter){
		return dao.getAllCorpPositionDto(filter);
	}
	
	//企业根据id查询当前发布中并且是未暂停的职位
	public ResultData<CorpPositionDto> getAllCorpPositionFaBu(Long aab001,PageBean pageBean){
		QueryFilter fiter=new QueryFilter();
		fiter.addFilter("aab001", aab001);
		fiter.addFilter("ccb208", 0);
		fiter.addFilter("abb773", 1);
		fiter.setPageBean(pageBean);
		return dao.getAllCorpPositionDto(fiter);
	}
	
	//根据职位acb210 和aab001 
	public ResultData<CorpPositionDto> getAllCorpPositionFaBuByCorpIdAndPositionId(Long aab001,Long acb210,PageBean pageBean){
		QueryFilter fiter=new QueryFilter();
		fiter.addFilter("aab001", aab001);
		fiter.addFilter("acb210", acb210);
		fiter.addFilter("ccb208", 0);
		fiter.addFilter("abb773", 1);
		fiter.setPageBean(pageBean);
		return dao.getAllCorpPositionDto(fiter);
	}
	
	//职位管理 新增职位  （委托）验证是不是已经发布了职位
	public Long checkPosition(Long aab001,String bca112){
		Map params = new HashMap();
		params.put("aab001",aab001);
		params.put("bca112",bca112);
		return (Long)dao.getOne("checkPosition",params);
	}
	//职位管理 修改职位（委托）验证是不是已经发布了职位
	public Long checkMofifyPosition(Long aab001,Long acb210,String bca112){
		Map params = new HashMap();
		params.put("aab001",aab001);
		params.put("acb210",acb210);
		params.put("bca112",bca112);
		return (Long)dao.getOne("checkMofifyPosition",params);
	}
	
	//企业预订招聘会以后验证是不是已经发布了职位
	public Long getBoothBookPositionCount(Long acb200,String bca112){
		Map params = new HashMap();
		params.put("acb200",acb200);
		params.put("bca112",bca112);
		return (Long)dao.getOne("getBoothBookPositionCount", params);
	}
	//企业预订招聘会下  修改职位（现场）验证是不是已经发布了职位
	public Long checkXCMofifyPosition(Long acb200,Long acb210,String bca112){
		Map params = new HashMap();
		params.put("acb200",acb200);
		params.put("acb210",acb210);
		params.put("bca112",bca112);
		return (Long)dao.getOne("checkXCMofifyPosition",params);
	}
	
	//企业获取最新职位信息
	public List<CorpPositionDto> getAllNewCorpPosition(QueryFilter filter){
		Map<String,Object> params = filter.getFilters();
		return dao.getAllNewCorpPositionDto(filter);
	}
	/**
	 * 查询发布的职位，查询根据冻结标识进行筛选
	 * ccb208: 0发布中 1 暂停中 -1 已过期
	 */
	public CorpPositionDto getAllCorpPositionDtoById(Long acb210){
		Map params = new HashMap();
		params.put("acb210",acb210);
		return (CorpPositionDto)dao.getOne("getAllCorpPositionDto",params);
	}
	
	//学生应聘记录查看职位详情
	public CorpPositionDto getStudentCorpPositionDto(Long acb210){
		Map params = new HashMap();
		params.put("acb210",acb210);
		return (CorpPositionDto)dao.getOne("getStudentCorpPositionDto",params);
	}
	
	/**
	 * 查询发布的职位，查询根据公司id和ccb208
	 * ccb208: 0发布中 1 暂停中 -1 已过期
	 */
	public Long getGuoCorpPositionDtoCount(Long aab001,String ccb208){
		Map params = new HashMap();
		params.put("aab001",aab001);
		params.put("ccb208",ccb208);
		return (Long)dao.getOne("getGuoCorpPositionDtoCount",params);
	}
	//根据公司id查询总数
	public Long getTotalCount(Long aab001){
		Map params = new HashMap();
		params.put("aab001",aab001);
		return (Long)dao.getOne("getTotalCount",params);
	}
    
	public void savePosition( CorpPosition corpPosition){
		corpPosition.setAcb210(UniqueIdUtil.genId(CorpPosition.class.getName()));
		corpPosition.setCcpr08("0");
		//corpPosition.setAbb773("0");
		corpPosition.setAcb208("0");
		corpPosition.setCcpr11(corpPosition.getCcpr09()==0L?1L:2L);
		corpPosition.setCcpr05(new Date());
		corpPosition.setCczy06(SystemConst.DATA_SOURCE);
		corpPosition.setCca116(corpPosition.getCca114());
		CorpPositionPublish corpPositionPub = corpPositionPublishService.getById(corpPosition.getAcb200());
		/**
		 * 2016-06-28 wyyEdit 增加了招聘职位的结束时间
		 */
		//单位招聘信息有效日期，以天为单位 sys_zp_date
		//BaseConfig baseConfigEndDate = baseConfigService.getConfigByName("sys_zp_date");
		//Date endDate = DateUtil.getDelayDayDateBy(Integer.valueOf(baseConfigEndDate.getCaos04()));
		Date startDate = corpPositionPub.getAae030();
		Date endDate = corpPositionPub.getAae031();
		corpPosition.setAae030(startDate);
		corpPosition.setAae031(endDate);
		/**
		 * 2016-08-10 wyyEdit 增加了招聘职位的经办时间 经办人 经办机构
		 */
		Properties configproperties=(Properties)AppUtil.getBean("configproperties");
		String orgIdStr  = configproperties.getProperty("operator.org");
		Long orgId  = Long.valueOf(orgIdStr);
		SysOrg sysorg = sysOrgService.getById(orgId);
		String sysName = sysorg.getAcd202();//经办机构
		String aab301 = sysorg.getAab301();//经办机构区划
		String aab004 = corpPosition.getAab004();//经办人
		Long aab001 = corpPosition.getAab001();//经办人代码
		
		corpPosition.setAae011(String.valueOf(aab001));// 经办人代码
		corpPosition.setAae036(new Date());// 经办日期
		corpPosition.setAae017(orgIdStr);//经办机构代码
		corpPosition.setAae019(aab004);//经办人
		corpPosition.setAae020(sysName);//经办机构
		if(StringUtil.isNotEmpty(aab301)){
			corpPosition.setAae022(aab301);//经办机构区划
		}
		this.add(corpPosition);
		//插入CTZ03（职位与信息方式对应关系表）
		String acb20q = corpPosition.getAcb20q();
		String [] scope = acb20q.split(",");
		if(StringUtil.isNotEmpty(acb20q)){
			releaseRangeService.add(corpPosition.getAcb210(), scope, 1);
		}
	}
	
	//更新职位信息
	public void updateWHPosition(CorpPosition corpPosition){
		corpPosition.setCcpr05(new Date());
		corpPosition.setCczy09(new Date());
		this.update(corpPosition);
		//插入CTZ03（职位与信息方式对应关系表）
		String acb20q = corpPosition.getAcb20q();
		String [] scope = acb20q.split(",");
		if(StringUtil.isNotEmpty(acb20q)){
			releaseRangeService.add(corpPosition.getAcb210(), scope, 1);
		}
	}
	
	public void editPosition(CorpPosition corpPosition){
		corpPosition.setCcpr11(corpPosition.getCcpr09()==0L?1L:2L);
		this.update(corpPosition);
	}

	//职位管理下保存职位 
	public Long savePositionAndPublish( CorpSavePositionDto cspd,boolean flag) throws SetMealException{
		Long acb210=0l;
		CorpPositionPublish  corpPositionPublish=new CorpPositionPublish();
		corpPositionPublish=BeanToBean.copyProperties(cspd, corpPositionPublish, false);
		corpPositionPublish.setAcb200(UniqueIdUtil.genId(CorpPositionPublish.class.getName()));
		corpPositionPublish.setAcb208("0");
		corpPositionPublish.setCcpr05(new Date());
		/**
		 * 2016-06-28 wyyEdit 增加了招聘信息的开始时间和结束时间
		 */
		corpPositionPublish.setAae030(new Date());//开始时间
		//单位招聘信息有效日期，以天为单位 sys_zp_date
		BaseConfig baseConfigEndDate = baseConfigService.getConfigByName("sys_zp_date");
		Date endDate = DateUtil.getDelayDayDateBy(Integer.valueOf(baseConfigEndDate.getCaos04()));
		corpPositionPublish.setAae031(endDate);//结束时间
		corpPositionPublish.setCcpr08("0");
		corpPositionPublish.setCcpr11(1l);
		corpPositionPublish.setAcb204(cspd.getAab040());
		if(flag){
			corpPositionPublish.setAbb773("1");
		}else{
			corpPositionPublish.setAbb773("0");
		}
		corpPositionPublish.setBcb209(SystemConst.DATA_SOURCE);
		corpPositionPublish.setAcb201("2");
		corpPositionPublish.setBcb201("委托招聘");
		corpPositionPublish.setAae006(cspd.getAae006());
		corpPositionPublish.setAcb206(cspd.getAcb206());
		CorpPosition corpPosition= new CorpPosition();
		corpPosition=BeanToBean.copyProperties(cspd, corpPosition, false);
		corpPosition.setAcb210(UniqueIdUtil.genId(CorpPosition.class.getName()));
		corpPosition.setAcb200(corpPositionPublish.getAcb200());
		corpPosition.setCcpr11(1L);
		corpPosition.setAae030(new Date());
		/**
		 * 2016-06-28 wyyEdit 增加了招聘职位的结束时间
		 */
		corpPosition.setAae031(endDate);
		if(flag){//自动审核
			corpPosition.setAbb773("1");
		}else{//手动审核
			corpPosition.setAbb773("0");
		}
		corpPosition.setAcb208("0");
		corpPosition.setCczy06(SystemConst.DATA_SOURCE);
		/**
		 * 2016-08-10 wyyEdit 增加了招聘职位的经办时间 经办人 经办机构
		 */
		Properties configproperties=(Properties)AppUtil.getBean("configproperties");
		String orgIdStr  = configproperties.getProperty("operator.org");
		Long orgId  = Long.valueOf(orgIdStr);
		SysOrg sysorg = sysOrgService.getById(orgId);
		String sysName = sysorg.getAcd202();//经办机构
		String aab301 = sysorg.getAab301();//经办机构区划
		String aab004 = corpPosition.getAab004();//经办人
		Long aab001 = corpPosition.getAab001();//经办人代码
		
		corpPosition.setAae011(String.valueOf(aab001));// 经办人代码
		corpPosition.setAae036(new Date());// 经办日期
		corpPosition.setAae017(orgIdStr);//经办机构代码
		corpPosition.setAae019(aab004);//经办人
		corpPosition.setAae020(sysName);//经办机构
		if(StringUtil.isNotEmpty(aab301)){
			corpPosition.setAae022(aab301);//经办机构区划
		}
		corpPositionPublish.setAae011(String.valueOf(aab001));// 经办人代码
		corpPositionPublish.setAae036(new Date());// 经办日期
		corpPositionPublish.setAae017(orgIdStr);//经办机构代码
		corpPositionPublish.setAae019(aab004);//经办人
		corpPositionPublish.setAae020(sysName);//经办机构
		if(StringUtil.isNotEmpty(aab301)){
			corpPositionPublish.setAae022(aab301);//经办机构区划
		}
		corpPositionPublishService.add(corpPositionPublish);
		if(flag){
			//增加收费功能
			Map <String,Object> map = new HashMap<String, Object>();
			map.put("position", corpPosition);
			this.addCorpPositionPayOper(map);
		}else{
			this.add(corpPosition);
		}
		//插入CTZ03（职位与信息方式对应关系表）
		String acb20q = cspd.getAcb20q();
		String [] scope = acb20q.split(",");
		if(StringUtil.isNotEmpty(acb20q)){
			releaseRangeService.add(corpPosition.getAcb210(), scope, 1);
		}
		acb210 = corpPosition.getAcb210();
		return acb210;
	}
	
	public void updatePositionAndPublish( CorpPosition corpPosition,CorpPositionPublish  corpPositionPublish,boolean flag){
		corpPositionPublish.setCcpr05(new Date());
		corpPositionPublish.setAcb201("2");
		corpPositionPublish.setBcb201("委托招聘");
		if(flag){
			corpPositionPublish.setAbb773("1");
		}else{
			corpPositionPublish.setAbb773("0");
		}
		corpPositionPublishService.update(corpPositionPublish);
		if(flag){
			corpPosition.setAbb773("1");
		}else{
			corpPosition.setAbb773("0");
		}
		corpPosition.setCcpr05(new Date());
		corpPosition.setCczy09(new Date());
		this.update(corpPosition);
		//插入CTZ03（职位与信息方式对应关系表）
		String acb20q = corpPosition.getAcb20q();
		String [] scope = acb20q.split(",");
		if(StringUtil.isNotEmpty(acb20q)){
			releaseRangeService.add(corpPosition.getAcb210(), scope, 1);
		}
	}
	//根据公司ID获取公司发布的职位
	public List<CorpPositionDto> getCorpPositionByCorpId(Long aab001){
		return dao.getCorpPositionByCorpId(aab001);
	}
	//根据公司ID获取公司发布的有效委托职位（）
	public List<CorpPositionDto> getEffectivePositionByCorpId(Long aab001){
		return dao.getEffectivePositionByCorpId(aab001);
	}
	//根据公司ID获取公司发布的职位总数
	public Long getCorpPositionCount(Long aab001){

		return (Long)dao.getOne("getCorpPositionCount",aab001);
//		return dao.getCorpPositionByCorpId(aab001);
	}
	public List<Map> getBookPosition(QueryFilter queryFilter){

		return dao.getListForm("getBookPosition",queryFilter);
	}

	public List<Map> getPositionList(QueryFilter queryFilter){
		return (List<Map>)dao.getListForm("getPositionList",queryFilter);
	}
	 
	/**
	 * 现场招聘会发布职位列表
	 */
	public ResultData<Map> getCorpBookPositionList(QueryFilter filter){
		/*Map  param=new HashMap();
		param.put("aab001", aab001);
		if(acb330!=null){
			param.put("acb330", acb330);	
		}
		if(ace201!=null){
			param.put("ace201", ace201);	
		}
		return (List<Map>)dao.getListBySqlKey("getCorpBookPosition",param);*/
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(filter.getPageBean());
		resultData.setDataList(dao.getListForm("getCorpBookPosition",filter));
		return resultData;
	}
	/**
	 * 获得公司预定摊位下发布的职位
	 * @param aab001
	 * @param cczy01 摊位id
	 * @return
	 */
	public List<Map> getBoothSiteCorpBookPositionList(Long aab001,Long cczy01){
		Map  param=new HashMap();
		param.put("aab001", aab001);
		param.put("abb773", 1);
		if(cczy01!=null){
			param.put("cczy01", cczy01);	
		}
		return (List<Map>)dao.getListBySqlKey("getCorpBookPosition",param);
	}
	public ResultData<Map> getPositionResultDataList(PageBean pageBean,Map param ) {
		String order = (String)param.get("order");
		String keyword = (String)param.get("keyword");
		String workCity = (String)param.get("workCity");
		String salar = (String)param.get("salar");
		String workExp = (String)param.get("workExp");
		String education = (String)param.get("education");
		String workType = (String)param.get("workType");
		String welfare = (String)param.get("welfare");
		String jobType = (String)param.get("jobType");
		String corpNature =(String) param.get("corpNature");
		String corpSize = (String)param.get("corpSize");
		String updateDate = (String)param.get("updateDate");
		QueryFilter fiter=new QueryFilter();
		fiter.setPageBean(pageBean);
		if ("2".equals(order)) {
			fiter.addFilter("orderField", "acc034");
			fiter.addFilter("orderSeq", "asc");	
		}
		
		if (!"0".equals(keyword)) {
			fiter.addFilter("ulltext", "%" + keyword + "%");
		}
		// 工作地点
		if (!"0".equals(workCity)) {
			fiter.addFilter("acb202", workCity);
		}
		// 职位月薪
		if (!"0".equals(salar) && !"-2".equals(salar)) {
			fiter.addFilter("acc034", salar);
		}
		// 福利
		if (!"0".equals(welfare) && !"-2".equals(welfare)) {
			String[]  welfareArray=welfare.split(",");
			StringBuffer sb=new StringBuffer();
			int i=0;
			for(String welfares :welfareArray){
				if(i==0){
					sb.append("instr(t.acc214,'"+welfares+"')>0");
				}else{
					sb.append("or instr(t.acc214,'"+welfares+"')>0");
				}			
				i++;
			}
			fiter.addFilter("acc214", sb.toString());
			
		}
		// 工作经验
		if (!"0".equals(workExp) && !"-2".equals(workExp)) {
			String[]  workExpArray=workExp.split(",");
			StringBuffer sb=new StringBuffer();
			int i=0;
			for(String workExps :workExpArray){
				if(i==0){
					sb.append("t.acc217='"+workExps+"'");
				}else{
					sb.append("or t.acc217='"+workExps+"'");
				}			
				i++;
			}
			fiter.addFilter("acc217s", sb.toString());
		}
		// 学历
		if (!"0".equals(education) && !"-2".equals(education)) {
			fiter.addFilter("aac011", education);
		}
		// 工作类型
		if (!"0".equals(workType) && !"-2".equals(workType)) {
			fiter.addFilter("acb21i", workType);
		}		
		if (!"0".equals(jobType)) {
			String[]  jobTypeArray=jobType.split(",");
			StringBuffer sb=new StringBuffer();
			int i=0;
			for(String jobTypes :jobTypeArray){
				if(i==0){
					sb.append("t.bca111='"+jobTypes+"'");
				}else{
					sb.append("or t.bca111='"+jobTypes+"'");
				}			
				i++;
			}
			fiter.addFilter("bca111s", sb.toString());
		}
		//未处理
		 Calendar calendar = Calendar.getInstance();  
		 Date date = new Date(); //获取当前时间
	     calendar.setTime(date);  
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
			fiter.addFilter("begincczy09", date);
		}
		if (!"0".equals(corpNature) && !"-2".equals(corpNature)) {
			fiter.addFilter("aab019", corpNature);
		}
		if (!"0".equals(corpSize) && !"-2".equals(corpSize)) {
			fiter.addFilter("aab056", corpSize);
		}
		// 发布中条件
		fiter.addFilter("ccb208", "0");
		// 通过审核
		fiter.addFilter("abb773", "1");
		if(param.get("isMapShow")!=null){
			fiter.addFilter("cabq01", "1");
		}
		List<Map> dataList=(List<Map>)dao.getListForm("getPositionListForSearch",fiter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(fiter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;

	}
	public Map getPositionMap(Long acb210) {
		Map  param=new HashMap();
		param.put("acb210", acb210);
		Map dataMap=(Map)dao.getOne("getPositionListForDetail",param);
		return dataMap;

	}
	/**
	 * 获得职位详情
	 */
	public Map<String,Object> getJobDetail(Long acb210){
		return  dao.getJobDetail(acb210);
	}
	
   /**
    * 通过企业id获得在招职位并获得职位下的工作福利
    * @param ccmu01 
    * @param acc001 
    * @param isFairJob 0:网上招聘 1:招聘会职位 
    * 2016-04-15
    */
	public ResultData<Map> getCurrentJob(QueryFilter queryFilter,Long ccmu01,Long acc001,String isFairJob){
		List<Map> jobList = new ArrayList<Map>();
		if("1".equals(isFairJob)){
			jobList = dao.getCurrentFairJob(queryFilter);
		}else{
			jobList = dao.getCurrentJob(queryFilter);
		}
		for(Map map :jobList){
			String acc214 = String.valueOf(map.get("ACC214"));//福利
			map.remove("ACC214");
			if(acc214 !=null && !acc214.equals("")&& !acc214.equals("null")){
				map.put("welfareList", dao.getWelfareByCode(acc214));
			}
			String isJobApply = "N";
			String isJobCollect = "N";
			if(ccmu01 != 0l){
				Long acb210 = Long.valueOf(map.get("ACB210").toString());
				if(jobApplyService.isApply(acb210, acc001)){//是否发送了简历
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
		resultData.setDataList(jobList);
		return resultData;
	}
	
	/**
	 * 获得职位下的工作福利
	 *  2016-04-15
	 * @return
	 */
	public List<Map<String,Object>> getWelfareByCode(String acc214){
		List<Map<String,Object>> list = dao.getWelfareByCode(acc214);
		return list;
	}
	//获取发送信息cb20职位信息
	public Map<String,Object> getCorpBase(Long acb210){
		Map  param=new HashMap();
		param.put("acb210", acb210);
		return (Map<String, Object>)dao.getOne("getCorpBase",param);
	}
	//提取公司历史职位信息
	public ResultData<Map> getExtractHistoryPosition(QueryFilter queryFilter){
		List<Map> dataList=(List<Map>)dao.getListForm("getExtractHistoryPosition",queryFilter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResultData<Map<String, Object>> getCorpPositionViewList(
			QueryFilter queryFilter) {
		List<Map<String, Object>> dataList=(List<Map<String, Object>>)dao.getListForm("getCorpPositionViewList",queryFilter);
		ResultData<Map<String, Object>> resultData = new ResultData<Map<String, Object>>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ResultData<Map<String, Object>> getCorpPositionComponentViewList(
			QueryFilter queryFilter) {
		List<Map<String, Object>> dataList=(List<Map<String, Object>>)dao.getListForm("getCorpPositionComponentViewList",queryFilter);
		ResultData<Map<String, Object>> resultData = new ResultData<Map<String, Object>>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	
	/**
	 * 保存职位收费
	 * @throws SetMealException 
	 */
	public void addCorpPositionPayOper(Map<String,Object> map) throws SetMealException{
		CorpPosition position = (CorpPosition) map.get("position");
		String flag = MealResultConst.SUC;
		if(isNeedFee()){
			Long aab001 = position.getAab001();
			String aab004 = position.getAab004();
			flag =  feeOrderDetailService.updateFeeOrderCount(aab001,aab004,MealTypeEmun.POSITION.getCode(),1);
			if(flag.equals(MealResultConst.SUC)){
				this.add(position);
			}else{
				throw new SetMealException("套餐不足");
			}
		}else{
			this.add(position);
		}
	}
	/**
	 * 刷新职位
	 * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
	 * @param aab001 企业编号
	 * @param aab004 企业名称
	 * 
	 *@param  Long[] corpResumeIds,
	 *@throws SetMealException 套餐不足整个事物回滚 
	 */
	public void refreshCorpPositionPayOper(Map<String,Object> map) throws SetMealException {
		
		Long[] corpPositionIds = (Long[])map.get("corpPositionIds");
		String flag = MealResultConst.SUC;
		if(isNeedFee()){
			Long aab001 = Long.valueOf(map.get("aab001").toString());
			String aab004 = String.valueOf(map.get("aab004"));
			flag =  feeOrderDetailService.updateFeeOrderCount(aab001,aab004,MealTypeEmun.REFRESHJOB.getCode(),corpPositionIds.length);
			if(flag.equals(MealResultConst.SUC)){
				refreshCorpPosition(corpPositionIds);
			}else{
				throw new SetMealException("套餐不足");
			}
		}else{
			refreshCorpPosition(corpPositionIds);
		}
	}
	public int getPostionCount(Long acb200, Long acb210, Long aab001,
			String code) {
		return dao.getPostionCount(acb200,acb210,aab001,code);
	}
	/**
	 * 节点是否收费
	 * @param categoryIndent 广告的分类Id
	 * @return boolean true:扣费 false:免费
	 */
	private boolean isNeedFee(){
		BaseConfig baseConfig = baseConfigService.getConfigByName("member_IsPay");
		String caos04 = baseConfig.getCaos04();
		if(caos04.equals("1")){//收费
			baseConfig = baseConfigService.getConfigByName("member_IsPay_refreshJob");
			caos04 = baseConfig.getCaos04();
		}
		return caos04.equals("1")?true:false;
	}
	/**
	 * 保存职位是否收费
	 * @return boolean true:扣费 false:免费
	 */
	private boolean isNeedFeeOnAddJob(){
		BaseConfig baseConfig = baseConfigService.getConfigByName("member_IsPay");
		String caos04 = baseConfig.getCaos04();
		if(caos04.equals("1")){//收费
			baseConfig = baseConfigService.getConfigByName("member_IsPay_addJob");
			caos04 = baseConfig.getCaos04();
		}
		return caos04.equals("1")?true:false;
	}

}
