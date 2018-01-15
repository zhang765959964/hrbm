package com.xunfeng.business.jobfair.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.dao.CorpDao;
import com.xunfeng.business.corp.dao.CorpPositionDao;
import com.xunfeng.business.corp.service.CorpPositionPublishService;
import com.xunfeng.business.jobfair.dao.JobFairInfoDao;
import com.xunfeng.business.jobfair.dto.JobFairInfoBoook;
import com.xunfeng.business.jobfair.dto.JobFairInfoSiteDto;
import com.xunfeng.business.jobfair.interf.JobFairInfoServiceInter;
import com.xunfeng.business.jobfair.model.JobFairInfo;
import com.xunfeng.business.jobfair.model.JobFairInfoSite;
import com.xunfeng.business.jobfair.model.JobFairSite;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.config.model.BaseConfig;
import com.xunfeng.sys.config.service.BaseConfigService;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 招聘会信息表 Service类
 * @author:wanghan
 * @createDate 2015-09-12 11:02:45
 * @version V1.0
 */
@Service
public class JobFairInfoService extends BaseService<JobFairInfo> implements
		JobFairInfoServiceInter {
	@Resource
	private JobFairInfoDao dao;

	@Resource
	private JobFairInfoSiteService infoSiteService;

	@Resource
	JobFairSiteService jobFairSiteService;
	
	@Resource
	JobFairInfoSiteService jobFairInfoSiteService;
	@Resource
	BoothBookService boothBookService;
	@Resource
	private CorpDao corpdao;
	@Resource
	private BaseConfigService baseConfigService;

	@Resource
	private CorpPositionDao corpPositionDao;

	@Resource
	CorpPositionPublishService corpPositionPublishService;
	
	@Resource
	UniqueIdUtilService  UniqueIdUtil;

	public JobFairInfoService() {
	}

	@Override
	protected IEntityDao<JobFairInfo, Long> getEntityDao() {
		return dao;
	}

	@Override
	public void add(JobFairInfo jobFairInfo) {

		String siteIds = jobFairInfo.getAcd200();
		if (StringUtils.isNotBlank(siteIds)) {
			String[] siteIdsArray = siteIds.split(",");
			for (String siteId : siteIdsArray) {
				JobFairInfoSite jobFairInfoSite = new JobFairInfoSite();
				jobFairInfoSite.setCccd01(UniqueIdUtil.genId(JobFairInfoSite.class.getName()));
				jobFairInfoSite.setAcb330(jobFairInfo.getAcb330());
				jobFairInfoSite.setAcd250(Long.valueOf(siteId));
				infoSiteService.add(jobFairInfoSite);
			}
		}
		dao.add(jobFairInfo);
	}

	@Override
	public void update(JobFairInfo jobFairInfo) {
		infoSiteService.dateleByJobFairInfoId(jobFairInfo.getAcb330());
		String siteIds = jobFairInfo.getAcd200();
		if (StringUtils.isNotBlank(siteIds)) {
			String[] siteIdsArray = siteIds.split(",");
			for (String siteId : siteIdsArray) {
				JobFairInfoSite jobFairInfoSite = new JobFairInfoSite();
				jobFairInfoSite.setCccd01(UniqueIdUtil.genId(JobFairInfoSite.class.getName()));
				jobFairInfoSite.setAcb330(jobFairInfo.getAcb330());
				jobFairInfoSite.setAcd250(Long.valueOf(siteId));
				infoSiteService.add(jobFairInfoSite);
			}
		}
		dao.update(jobFairInfo);
	}
	   public List<JobFairInfo> getAcd200(Long acd200) {
		// TODO Auto-generated method stub
		return dao.getBySqlKey("getByAcd200",acd200);
	}


	public List<JobFairInfoBoook> getAllJobFairInfoList(QueryFilter queryFilter) {
		return dao.getListForm("getAllJobFairInfoList", queryFilter);
	}

	// 获取当前企业预订招聘会审核未通过条数
	public Long getTotalZPH(Long aab001, String dateString, Long CCZY05) {
		Map params = new HashMap();
		params.put("aab001", aab001);
		params.put("beginacb334", dateString);
		params.put("cczy05", CCZY05);
		return (Long) dao.getOne("getJobCount", params);
	}

	// 获取招聘会数据
	public List<JobFairInfoBoook> getAllJobList(QueryFilter queryFilter) {
		return dao.getListForm("getAllJobList", queryFilter);
	}

	// 获取当前公司下没有过期的招聘会总数
	public Long getJobCount(Long aab001, String dateString) {
		Map params = new HashMap();
		params.put("aab001", aab001);
		params.put("beginacb334", dateString);
		params.put("cczy05", 4);
		return (Long) dao.getOne("getJobCount", params);
	}
    /**
     * 获取当前招聘会（个人中心首页 企业中心 首页 ）
     */
	public List<JobFairInfoSiteDto> getcurrentJobFair(String dateString) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("dateString", dateString);
		List<JobFairInfoSiteDto> list = (List<JobFairInfoSiteDto>) dao.getListBySqlKey("getJobFairList", params);
		for(JobFairInfoSiteDto dto : list){
			if(dto.getFairCorp()!=0){
				Long acb330 = dto.getAcb330();
				Long totalJob = (Long)dao.getOne("getTotalJobInFair", acb330);
				dto.setFairJob(totalJob);
			}
			//获得招聘会下的场地地点和公交路线
			List<JobFairSite> siteJobList = jobFairSiteService.getJobFairSite(dto.getAcb330());
			String siteName = "";//场地名称
			String siteAddress= "";//场地地点
			String siteBusWay = "";//乘车路线
			for(JobFairSite fairSite : siteJobList){
				//场地地点
				siteName += fairSite.getAcd253()+" ";
				siteAddress += fairSite.getCczc004()+" ";
				siteBusWay  += fairSite.getCczc005()+" ";
			}
			dto.setAcd253(siteName);
			dto.setCczc004(siteAddress);
			dto.setCczc005(siteBusWay);
			//判断还能不能预定招聘会 
			Date endTime = dto.getAcb334();
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
			String holdDateStr = sdfDate.format(endTime);
			if(canBookTomorrowFair(holdDateStr)){
				dto.setIsCanBookFair(0);//能预定
			}else{
				dto.setIsCanBookFair(1);//不能预定招聘会
			}
		}
		return list;
	}
	//传分页取招聘会数据
	public ResultData<JobFairInfoSiteDto> getPagecurrentJobFair(QueryFilter queryFilter) {
		ResultData<JobFairInfoSiteDto> resultData = new ResultData<JobFairInfoSiteDto>();
		List<JobFairInfoSiteDto> list = (List<JobFairInfoSiteDto>) dao.getListForm("getJobFairList", queryFilter);
		for(JobFairInfoSiteDto dto : list){
			if(dto.getFairCorp()!=0){
				Long acb330 = dto.getAcb330();
				Long totalJob = (Long)dao.getOne("getTotalJobInFair", acb330);
				dto.setFairJob(totalJob);
			}
			//获得招聘会下的场地地点和公交路线
			List<JobFairSite> siteJobList = jobFairSiteService.getJobFairSite(dto.getAcb330());
			String siteName = "";//场地名称
			String siteAddress= " ";//场地地点
			String siteBusWay = " ";//乘车路线
			for(JobFairSite fairSite : siteJobList){
				//场地地点
				siteName += fairSite.getAcd253()+" ";
				siteAddress += fairSite.getCczc004()+" ";
				siteBusWay  += fairSite.getCczc005()+" ";
			}
			dto.setAcd253(siteName);
			dto.setCczc004(siteAddress);
			dto.setCczc005(siteBusWay);
			//判断还能不能预定招聘会 
			Date endTime = dto.getAcb334();
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
			String holdDateStr = sdfDate.format(endTime);
			if(canBookTomorrowFair(holdDateStr)){
				dto.setIsCanBookFair(0);//能预定
			}else{
				dto.setIsCanBookFair(1);//不能预定招聘会
			}
		}
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(list);
		return resultData;
	}
	/**
	 * 招聘会详情
	 */
	public JobFairInfoSiteDto getJobFairById(String dateString,Long acb330) {
		Map params = new HashMap();
		params.put("dateString", dateString);
		params.put("acb330", acb330);
		JobFairInfoSiteDto dto= (JobFairInfoSiteDto)dao.getOne("getJobFairList", params);
		Long totalJob = (Long)dao.getOne("getTotalJobInFair", acb330);
		List<JobFairSite> siteJobList = jobFairSiteService.getJobFairSite(dto.getAcb330());
		String siteName = "";//场地名称
		String siteAddress= " ";//场地地点
		String siteBusWay = " ";//乘车路线
		for(JobFairSite fairSite : siteJobList){
			//场地地点
			siteName += fairSite.getAcd253()+" ";
			siteAddress += fairSite.getCczc004()+" ";
			siteBusWay  += fairSite.getCczc005()+" ";
		}
		dto.setAcd253(siteName);
		dto.setCczc004(siteAddress);
		dto.setCczc005(siteBusWay);
		dto.setFairJob(totalJob);
		return dto;
	}
	
	/**获取
	 * @param queryFilter
	 * @return
	 */
	public ResultData<JobFairInfo> getJobFairList(QueryFilter queryFilter) {

		List<JobFairInfo>  dataList=dao.getAll(queryFilter);
		ResultData<JobFairInfo> resultData = new ResultData<JobFairInfo>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	
	/**
	 * 获取招聘会信息视图
	 * @param queryFilter 检索条件
	 * @return 结果数据返回
	 */
	public ResultData<JobFairInfo> getJobInfoViewsPageList(QueryFilter queryFilter) {
		@SuppressWarnings("unchecked")
		List<JobFairInfo>  dataList= dao.getListForm("getJonInfoViews", queryFilter);
		ResultData<JobFairInfo> resultData = new ResultData<JobFairInfo>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	
	//判断现在时间还能不能预定明日招聘会
	public boolean canBookTomorrowFair(String holdDateStr){
			boolean isCanBook = false;
			//企业预定时间 配置
			BaseConfig baseConfig= baseConfigService.getConfigByName("yd_endtime");
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			try {
				Date endTime = sdf.parse(baseConfig.getCaos04());
				Date currentDate = sdf.parse(sdf.format(new Date()));
				Date nowDate = new Date();//当前时间
				if(currentDate.after(endTime)){
					nowDate = DateUtil.getDelayDayDateBy(1);
				}
				SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
				Date holdDate = sdfDate.parse(holdDateStr.replaceAll(" ", ""));
				if(nowDate.after(holdDate)){ //当nowDate大于holdDate时，返回TRUE，当小于等于时，返回false 
					isCanBook = false;
				}else{
					isCanBook = true;
				}
			} catch (ParseException e) {
				isCanBook = false;
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				return isCanBook;
			}
		}

	@Override
	public ResultData<Map<String, Object>> getJobListPage(QueryFilter queryFilter) {
		List<Map<String, Object>>  dataList=dao.getJobListPage(queryFilter);
		ResultData<Map<String, Object>> resultData = new ResultData<Map<String, Object>>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	
	@Override
	public ResultData<Map<String, Object>> getJobMatchListPage(
			QueryFilter queryFilter) {
		List<Map<String, Object>>  dataList=dao.getJobMatchListPage(queryFilter);
		ResultData<Map<String, Object>> resultData = new ResultData<Map<String, Object>>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	

	@Override
	public ResultData<Map<String, Object>> getCorpMatchPersonListPage(
			QueryFilter queryFilter) {
		List<Map<String, Object>>  dataList=dao.getCorpMatchPersonListPage(queryFilter);
		ResultData<Map<String, Object>> resultData = new ResultData<Map<String, Object>>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	
	/**
	 * 招聘供求情况统计
	 * @param queryFilter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>>  getjobSuplyDemandList(QueryFilter queryFilter){
		dao.getjobSuplyDemandList(queryFilter);
		return (List<Map<String, Object>>) queryFilter.getFilters().get("V_CURSOR");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getJobSalariesStatistics(
			QueryFilter queryFilter) {
		dao.getJobSalariesStatistics(queryFilter);
		return (List<Map<String, Object>>) queryFilter.getFilters().get("V_CURSOR");
	}
}
