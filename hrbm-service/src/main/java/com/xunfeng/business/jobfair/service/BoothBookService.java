package com.xunfeng.business.jobfair.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.model.BookPay;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.corp.model.CorpEnter;
import com.xunfeng.business.corp.model.CorpPosition;
import com.xunfeng.business.corp.model.CorpPositionPublish;
import com.xunfeng.business.corp.service.BookPayService;
import com.xunfeng.business.corp.service.CorpEnterService;
import com.xunfeng.business.corp.service.CorpPositionPublishService;
import com.xunfeng.business.corp.service.CorpPositionService;
import com.xunfeng.business.corp.service.CorpService;
import com.xunfeng.business.jobfair.dao.BoothBookDao;
import com.xunfeng.business.jobfair.dao.BoothUnsubscribeDao;
import com.xunfeng.business.jobfair.dao.JobFairInfoDao;
import com.xunfeng.business.jobfair.dto.BookCorp;
import com.xunfeng.business.jobfair.dto.JobFairBoothBookDto;
import com.xunfeng.business.jobfair.exception.BoothOccupiedException;
import com.xunfeng.business.jobfair.interf.BoothBookServiceInterf;
import com.xunfeng.business.jobfair.model.BoothBook;
import com.xunfeng.business.jobfair.model.BoothUnsubscribe;
import com.xunfeng.business.jobfair.model.JobFairBooth;
import com.xunfeng.business.jobfair.model.JobFairInfo;
import com.xunfeng.business.jobfair.model.JobFairSite;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.config.model.BaseConfig;
import com.xunfeng.sys.config.service.BaseConfigService;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.sendmessage.model.MessageTemplates;
import com.xunfeng.sys.sendmessage.service.MessageTemplatesService;
import com.xunfeng.sys.sendmessage.service.SenderService;
import com.xunfeng.sys.sendmessage.util.ContentConversion;
import com.xunfeng.sys.sendmessage.util.ContentModel;
import com.xunfeng.sys.setMeal.service.FeeOrderDetailService;
import com.xunfeng.sys.setMeal.util.MealTypeEmun;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.service.SysOrgService;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 摊位预定表 Service类
 * @author:wanghan
 * @createDate 2015-09-12 15:43:12
 * @version V1.0
 */
@Service
public class BoothBookService extends BaseService<BoothBook> implements BoothBookServiceInterf {
	@Resource
	private BoothBookDao dao;
	@Resource
	private JobFairInfoDao jobFairInfodao;
	@Resource
	private CorpPositionService corpPositionService;
	@Resource
	private CorpPositionPublishService corpPositionPublishService;
	@Resource
	BookPayService bookPayService;
	@Resource
	JobFairInfoService jobFairInfoService;
	@Resource
	CorpEnterService corpEnterService;
	@Resource
	UniqueIdUtilService UniqueIdUtil;
	@Resource
	BoothUnsubscribeDao boothUnsubscribeDao;
	
	@Resource
	private CorpService corpService;
	@Resource
	private JobFairSiteService jobFairSiteService;
	@Resource
	private JobFairInfoSiteService  jobFairInfoSiteService;
	
	@Resource
	private JobFairBoothService jobFairBoothService;
	@Resource
	private BaseConfigService baseConfigService;
	@Resource
	private MessageTemplatesService messageTemplatesService;
	@Resource
	private SenderService senderService;
	@Resource
	private FeeOrderDetailService feeOrderDetailService;
	@Resource
	private SysOrgService sysOrgService;
	
	public BoothBookService() {
	}

	@Override
	protected IEntityDao<BoothBook, Long> getEntityDao() {
		return dao;
	}

	// 场地招聘会中岗位信息审核
	public void approve(Long cczy01, Long acb210, Long approveFlag) {
		CorpPosition corpPosition = corpPositionService.getById(acb210);
		if (approveFlag == 0) {
			corpPosition.setAbb773("1");
		} else if (approveFlag == 1) {
			corpPosition.setAbb773("2");
		}
		corpPositionService.update(corpPosition);
	}

	// 场地招聘会中招聘信息审核
	public void approvecb20(Long cczy01, Long acb200, Long approveFlag) {
		BoothBook boothBook = dao.getById(cczy01);
		JobFairInfo jobFairInfo = jobFairInfodao.getById(boothBook.getAcb330());
		CorpPositionPublish corpPositionPublish = corpPositionPublishService.getById(acb200);
		if (approveFlag == 0) {
			corpPositionPublish.setAbb773("1");
			if (boothBook.getAce200() == null || boothBook.getAce200() == 0L) {
				getBoothBookForUpdate(boothBook);
				boothBook.setCczy05("4");
				Long maxUnmber = getNewNumber(boothBook);
				boothBook.setAce200(maxUnmber);
				// 单位数统统计
				Long acb330 = boothBook.getAcb330();
				Map<String, Long> param = new HashMap<String, Long>();
				param.put("acb330", acb330);
				Long maxUnmber1 = (Long) dao.getOne("getMaxId", acb330);
				if (maxUnmber1 == null) {
					maxUnmber1 = 1L;
				} else {
					maxUnmber1 = maxUnmber1 + 1;
				}
				jobFairInfo.setAcb33a(maxUnmber1);
			}

		} else if (approveFlag == 1) {
			boothBook.setCczy05("1");
			corpPositionPublish.setAbb773("2");
		}
		corpPositionPublishService.update(corpPositionPublish);
		dao.update(boothBook);
		jobFairInfodao.update(jobFairInfo);
	}

	// 会后委托招聘信息(职位信息)审核
	public void approveweituo(Long cczy01, Long acb210, Long approveFlag) {
		CorpPosition corpPosition = corpPositionService.getById(acb210);
		if (approveFlag == 0) {
			corpPosition.setAbb773("1");
		} else if (approveFlag == 1) {
			corpPosition.setAbb773("2");
		}
		corpPositionService.update(corpPosition);
	}

	// 会后委托招聘信息审核（且有招聘信息）
	public void approveweituo2(Long cczy01, Long acb210, Long acb200, Long approveFlag) {
		BoothBook boothBook = dao.getById(cczy01);
		CorpPosition corpPosition = corpPositionService.getById(acb210);
		CorpPositionPublish corpPositionPublish = corpPositionPublishService.getById(acb200);
		if (approveFlag == 0) {
			corpPosition.setAbb773("1");
			corpPositionPublish.setAbb773("1");
			if (boothBook.getAce200() == null || boothBook.getAce200() == 0L) {
				getBoothBookForUpdate(boothBook);
				boothBook.setCczy05("4");
			}
		} else if (approveFlag == 1) {
			boothBook.setCczy05("1");
			corpPosition.setAbb773("2");
			corpPositionPublish.setAbb773("2");
		}
		corpPositionService.update(corpPosition);
		dao.update(boothBook);

	}

	// 直接委托招聘信息审核
	public void approveweituo1(Long acb210, Long acb200, Long approveFlag) {
		CorpPosition corpPosition = corpPositionService.getById(acb210);
		CorpPositionPublish corpPositionPublish = corpPositionPublishService.getById(acb200);
		if (approveFlag == 0) {
			corpPosition.setAbb773("1");
			corpPositionPublish.setAbb773("1");
		} else if (approveFlag == 1) {
			corpPosition.setAbb773("2");
			corpPositionPublish.setAbb773("2");
		}
		corpPositionService.update(corpPosition);
		corpPositionPublishService.update(corpPositionPublish);
	}

	public void approve1(Long acb210, Long approveFlag) {

		CorpPosition corpPosition = corpPositionService.getById(acb210);
		if (approveFlag == 0) {
			corpPosition.setAbb773("1");
		} else if (approveFlag == 1) {
			corpPosition.setAbb773("2");
		}
		corpPositionService.update(corpPosition);
	}

	public void approveacb200(Long acb200, Long approveFlag) {

		CorpPositionPublish corpPositionPublish = corpPositionPublishService.getById(acb200);
		if (approveFlag == 0) {
			corpPositionPublish.setAbb773("1");
		} else if (approveFlag == 1) {
			corpPositionPublish.setAbb773("2");
		}
		corpPositionPublishService.update(corpPositionPublish);
	}

	private Long getNewNumber(BoothBook boothBook) {
		Long acb330 = boothBook.getAcb330();
		Map<String, Long> param = new HashMap<String, Long>();
		param.put("acb330", acb330);
		Long maxUnmber = (Long) dao.getOne("getMaxId", acb330);
		if (maxUnmber == null) {
			maxUnmber = 1L;
		} else {
			maxUnmber = maxUnmber + 1;
		}
		return maxUnmber;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private void getBoothBookForUpdate(BoothBook boothBook) {
		Long acb330 = boothBook.getAcb330();
		Map<String, Long> param = new HashMap<String, Long>();
		param.put("acb330", acb330);
		List<Long> IdList = dao.getListBySqlKey("getBoothBookForUpdate", acb330);
	}

	public BoothBook getBoothBookByRecruitCode(Long acb200) {
		Map<String, Long> param = new HashMap<String, Long>();
		param.put("acb200", acb200);
		BoothBook boothBook = dao.getUnique("getAll", param);
		return boothBook;
	}

	public List<BoothBook> getByAcb(Long acb2) {
		// TODO Auto-generated method stub
		return dao.getBySqlKey("getByAcb200", acb2);
	}

	/*
	 * 预定摊位接口 (non-Javadoc)
	 * 
	 * @see
	 * com.xunfeng.business.jobfair.interf.BoothBookServiceInterf#addBoothBook
	 * (com.xunfeng.business.jobfair.dto.JobFairBoothBookDto)
	 */
	public Long addBoothBook(JobFairBoothBookDto jobFairBoothBookDto) throws BoothOccupiedException {
		//扣费
		String isCharg = jobFairBoothBookDto.getIsCharg();
		//预定招聘会是否需要审核
		BaseConfig checkboothBookConfig = baseConfigService.getConfigByName("sys_sh");
		String isCheck = checkboothBookConfig.getCaos04();
		//0是自动审核 1:手动审核
		boolean isCheckboolean = (StringUtil.isNotEmpty(isCheck)&& isCheck.equals("1"))? true:false;
		if(!isCheckboolean){//不需要审核 进行扣费
			//招聘会 
			if("1".equals(isCharg)){
				if(isNeedFee("member_IsPay_jobFair")){//收费
					//扣招聘会
					String jobSiteFlag = feeOrderDetailService.updateFeeOrderCount(jobFairBoothBookDto.getAab001(), jobFairBoothBookDto.getAab004(), MealTypeEmun.FAIRSITE.getCode(), 1);
					if(!"0".equals(jobSiteFlag)){
						throw new BoothOccupiedException("预定招聘会套餐余额不足,请购买套餐");
					}
				}
			}
		}
		//摊位预定表
		BoothBook boothBook = dao.getByIdForUpdate(jobFairBoothBookDto.getCczy01());
		//招聘会
		JobFairInfo jobFairInfo = jobFairInfoService.getById(boothBook.getAcb330());
		//场地
		JobFairSite jobFairSite = jobFairSiteService.getById(boothBook.getAcd250());
		//摊位
		JobFairBooth jobFairBooth = jobFairBoothService.getById(boothBook.getAce200());
		//摊位预定表中条件判断
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
		String bookUserTime = sdfDate.format(boothBook.getCczy07());
		//不等于1说明已经被占用，不能预订了！
		if(!"1".equals(boothBook.getCczy05())){
			throw new BoothOccupiedException("摊位已被其他企业预订");
		}else if("1".equals(boothBook.getCcpr08())){ //摊位已删除
			throw new BoothOccupiedException("摊位已删除");
		}else if("1".equals(boothBook.getCczy08())){//是否为预留摊位
			throw new BoothOccupiedException("此摊位为预留摊位,暂不能预定");
		}else if(boothBook.getCczy07().before(new Date())){//摊位使用时间是否已过期
			throw new BoothOccupiedException("不能预定此时间摊位");
		}else if(!canBookFair(bookUserTime)){//超过预定时间不能预定摊位
			throw new BoothOccupiedException("超过了网上预定摊位时间,不接受预定");
		}
		//招聘会表条件判断(审核，没有注销，开放网站预定，没有过期)
		else if(jobFairInfo.getCcbs05()==0l){//没有审核通过
			throw new BoothOccupiedException("招聘会没有审核通过,暂不接受预定");
		}else if("1".equals(jobFairInfo.getAce750())){//已注销
			throw new BoothOccupiedException("招聘会已注销,不接受预定");
		}else if(jobFairInfo.getAcb339() == 0l){//没有开放网站预定
			throw new BoothOccupiedException("招聘会没有开放网站预定,暂不接受预定");
		}else if(jobFairInfo.getAcb334().before(new Date())){//过期不能预定的招聘会
			throw new BoothOccupiedException("招聘会预定时间已过,不接受预定");
		}
		//场地条件判断
		else if("1".equals(jobFairSite.getCczc007())){//使用状态(0-正常使用1-已注销)
			throw new BoothOccupiedException("此场地已注销,不接受预定");
		}else if("1".equals(jobFairSite.getCcpr08())){//已删除
			throw new BoothOccupiedException("此场地已删除,不接受预定");
		}
		//摊位条件判断
		else if("1".equals(jobFairBooth.getCcpr08())){//已删除
			throw new BoothOccupiedException("此摊位已删除,不接受预定");
		}
		//同一场招聘会同一个场地，一个单位最多可以预定摊位个数(预定+预占)
		//统计出用户已经预定和预占的摊位数
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("acb330", boothBook.getAcb330());//招聘会编号
		params.put("acd250", boothBook.getAcd250());//场地编号
		params.put("aab001", jobFairBoothBookDto.getAab001());//单位编号
		params.put("cczy07", DateUtil.getformatterDate(boothBook.getCczy07(), "yyyy-MM-dd"));//摊位使用时间
		Map<String,Object> map = (Map<String,Object>)dao.getOne("getTotalCountBooth", params);
		Long totalCountBoothBook = Long.valueOf(String.valueOf(map.get("TOTALCOUNT")));
		BaseConfig maxBoothBook = baseConfigService.getConfigByName("max_dytws");
		int limitCount = Integer.valueOf(maxBoothBook.getCaos04());
		if(totalCountBoothBook>=limitCount){
			throw new BoothOccupiedException("本次招聘会此场地最多预定"+limitCount+"个摊位");
		}
		Corp corp=corpService.getById(jobFairBoothBookDto.getAab001());
		CorpPositionPublish corpPositionPublish = new CorpPositionPublish();
		corpPositionPublish.setAab001(jobFairBoothBookDto.getAab001());
		corpPositionPublish.setAab004(jobFairBoothBookDto.getAab004());
		corpPositionPublish.setAcb204(jobFairBoothBookDto.getAcb204());
		corpPositionPublish.setAae006(corp.getAae006());
		corpPositionPublish.setAcb206(corp.getAcb206());
		corpPositionPublish.setBab004(jobFairBoothBookDto.getBab004());
		corpPositionPublish.setAae004(jobFairBoothBookDto.getAae004());
		corpPositionPublish.setAae005(jobFairBoothBookDto.getAae005());
		corpPositionPublish.setAae139(jobFairBoothBookDto.getAae139());
		corpPositionPublish.setAcb205(jobFairBoothBookDto.getAcb205());
		BaseConfig  auditxcConfig = baseConfigService.getConfigByName("job_is_audit_xc");
		String xc = auditxcConfig.getCaos04();
		if(xc!=null && xc.equals("0")){//自动审核
			corpPositionPublish.setAbb773("1");
		}else{//手动审核
			corpPositionPublish.setAbb773("0");//未审核
		}
		corpPositionPublish.setCcpr11(2L);
		corpPositionPublish.setAcb201("1");
		corpPositionPublish.setBcb201("现场招聘");
		corpPositionPublish.setCcpr05(new Date());
		corpPositionPublish.setAcb200(UniqueIdUtil.genId(CorpPositionPublish.class.getName()));
		corpPositionPublish.setAae030(boothBook.getCczy07());//招聘开始时间
		//单位招聘信息有效日期，以天为单位 sys_zp_date
		//BaseConfig baseConfigEndDate = baseConfigService.getConfigByName("sys_zp_date");
		//现场招聘会有效期为一天 2016-08-18 wyyEdit
		Date endDate = getNextDay(boothBook.getCczy07(),1);
		corpPositionPublish.setAae031(endDate);
		/**
		 * 2016-08-10 wyyEdit 增加了招聘职位的经办时间 经办人 经办机构
		 */
		Properties configproperties=(Properties)AppUtil.getBean("configproperties");
		String orgIdStr  = configproperties.getProperty("operator.org");
		Long orgId  = Long.valueOf(orgIdStr);
		SysOrg sysorg = sysOrgService.getById(orgId);
		String sysName = sysorg.getAcd202();//经办机构
		String aab301 = sysorg.getAab301();//经办机构区划
		String aab004 = corpPositionPublish.getAab004();//经办人
		Long aab001 = corpPositionPublish.getAab001();//经办人代码
		
		corpPositionPublish.setAae011(String.valueOf(aab001));// 经办人代码
		corpPositionPublish.setAae036(new Date());// 经办日期
		corpPositionPublish.setAae017(orgIdStr);//经办机构代码
		corpPositionPublish.setAae019(aab004);//经办人
		corpPositionPublish.setAae020(sysName);//经办机构
		if(StringUtil.isNotEmpty(aab301)){
			corpPositionPublish.setAae022(aab301);//经办机构区划
		}
		
		corpPositionPublishService.add(corpPositionPublish);
		// 保存摊位预定信息
		boothBook.setAcb200(corpPositionPublish.getAcb200());

		boothBook.setAab001(jobFairBoothBookDto.getAab001());// 单位编号
		boothBook.setCcpr05(new Date());

		// 摊位收费
		if (boothBook.getCczy02() != 0) {//需要缴费
			if(isCheckboolean){//需要审核
				boothBook.setCczy05(BoothBook.BOOK_STATUS_3);// 预定审核中
			}else{
				boothBook.setCczy05(BoothBook.BOOK_STATUS_2);// 预占，缴费后变为预定状态
			}
			dao.update(boothBook);
			addBoothBookPay(jobFairBoothBookDto, boothBook,jobFairInfo,endDate,"1");
		} else {// 如果摊位免费，生成进场记录表
			if(isCheckboolean){//需要审核
				boothBook.setCczy05(BoothBook.BOOK_STATUS_3);//预定审核中
			}else{
				boothBook.setCczy05(BoothBook.BOOK_STATUS_4);// 预定状态
			}
			dao.update(boothBook);
			addBoothBookPay(jobFairBoothBookDto, boothBook,jobFairInfo,endDate,"2");
			addCorpEnter(jobFairBoothBookDto, boothBook);
		}
		//向企业发送成功预订摊位信息短信
		BaseConfig baseConfig = baseConfigService.getConfigByName("sms_yd");
		//企业成功预订招聘会发送短息开关（0关闭；1打开）
		if(baseConfig!=null && "1".equals(baseConfig.getCaos04())){
			MessageTemplates  messageTemplates = messageTemplatesService.getById(11l);
			ContentModel cm = new ContentModel();
			cm.setFairSiteBookTime(bookUserTime);//摊位使用时间
			cm.setFairSiteNum(boothBook.getAce201());//摊位名称
			cm.setFairBooth(jobFairSite.getAcd253());//场地
			String content = ContentConversion.modelConversionContent(cm, messageTemplates.getComm04());
			senderService.sendVerificationCode(jobFairBoothBookDto.getAae139(), content);
		}
		return corpPositionPublish.getAcb200();
	}

	/**
	 * 生成支付表记录
	 * @param jobFairBoothBookDto
	 * @param boothBook
	 */
	private void addBoothBookPay(JobFairBoothBookDto jobFairBoothBookDto, BoothBook boothBook,JobFairInfo jobFairInfo,Date endTime,String cczz04) {

		BookPay bookPay = new BookPay();
		BeanToBean.copyProperties(jobFairBoothBookDto, bookPay, false);
		BeanToBean.copyProperties(boothBook, bookPay, false);
		bookPay.setCczz01(UniqueIdUtil.genId(BookPay.class.getName()));
		bookPay.setAae036(new Date());
		bookPay.setCczz04(cczz04);
		bookPay.setAae031(endTime);//默认为招聘会结束时间
		bookPay.setCczz05("0");//是否续费0-否1-是
		bookPay.setCatc01(1l);//招聘套餐编号
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
		String bookUserTime = sdfDate.format(boothBook.getCczy07());
		bookPay.setAae013(bookUserTime+"【"+boothBook.getAce201()+"】");//备注 摊位使用日期+摊位号
		bookPay.setAae011(String.valueOf(jobFairBoothBookDto.getAab001()));//经办人代码
		bookPay.setAae019(jobFairBoothBookDto.getAab004());//经办人
		bookPay.setAae017(jobFairInfo.getAae017());//经办机构代码
		bookPay.setAae020(jobFairInfo.getAae020());//经办机构
		bookPay.setCczz03(0f);//实收费用默认为0
		bookPayService.add(bookPay);
	}

	/**
	 * 生成进场表记录
	 * 
	 * @param jobFairBoothBookDto
	 * @param boothBook
	 */
	private void addCorpEnter(JobFairBoothBookDto jobFairBoothBookDto, BoothBook boothBook) {

		CorpEnter corpEnter = new CorpEnter();
		BeanToBean.copyProperties(jobFairBoothBookDto, corpEnter, false);
		BeanToBean.copyProperties(boothBook, corpEnter, false);
		corpEnter.setAcb350(UniqueIdUtil.genId(CorpEnter.class.getName()));
		corpEnterService.add(corpEnter);
	}

	/*
	 * 退订预定摊位接口 (non-Javadoc)
	 * 
	 * @see
	 * com.xunfeng.business.jobfair.interf.BoothBookServiceInterf#addBoothBook
	 * (com.xunfeng.business.jobfair.dto.JobFairBoothBookDto)
	 */
	public void boothUnsubscribe(Long cczy01) {
		BoothBook boothBook = dao.getById(cczy01);
		BoothUnsubscribe boothUnsubscribe = new BoothUnsubscribe();
		BeanToBean.copyProperties(boothBook, boothUnsubscribe, false);
		boothUnsubscribe.setCatc01(BoothUnsubscribe.BOOK_PACKAGE_1);
		boothUnsubscribe.setCczt01(UniqueIdUtil.genId(BoothUnsubscribe.class.getName()));
		boothUnsubscribeDao.add(boothUnsubscribe);
		// 摊位收费
		if (boothBook.getCczy03() == null || boothBook.getCczy03() == 0) {
			// 删除面试邀请表
			boothUnsubscribeDao.delBySqlKey("delCcp03ByBookId", cczy01);
			// 删除职位申请表
			boothUnsubscribeDao.delBySqlKey("delCcp04ByBookId", cczy01);
			// 删除职位登记表
			boothUnsubscribeDao.delBySqlKey("delCb20ByBookId", cczy01);
			// 删除职位表
			boothUnsubscribeDao.delBySqlKey("delCb21ByBookId", cczy01);
			// 删除单位进场招聘表
			boothUnsubscribeDao.delBySqlKey("delCb35ByBookId", cczy01);
			// 更新预定摊位
			boothBook.setAab001(0L);
			boothBook.setCczy05("1");
			boothBook.setCczy06("2");
			boothBook.setAcb200(0L);
			boothBook.setCczy13(null);
			dao.update(boothBook);
			// 更新支付记录
			boothUnsubscribeDao.update("updateCcz05", cczy01);
		}
	}

	public void editBoothBook(JobFairBoothBookDto jobFairBoothBookDto) {
		// 保存职位发布信息
		CorpPositionPublish corpPositionPublish = corpPositionPublishService.getById(jobFairBoothBookDto.getAcb200());
		corpPositionPublish.setAab001(jobFairBoothBookDto.getAab001());
		corpPositionPublish.setAab004(jobFairBoothBookDto.getAab004());
		corpPositionPublish.setAcb204(jobFairBoothBookDto.getAcb204());
		corpPositionPublish.setAae006(jobFairBoothBookDto.getAcb204());
		corpPositionPublish.setBab004(jobFairBoothBookDto.getBab004());
		corpPositionPublish.setAae004(jobFairBoothBookDto.getAae004());
		corpPositionPublish.setAae005(jobFairBoothBookDto.getAae005());
		corpPositionPublish.setAae139(jobFairBoothBookDto.getAae139());
		corpPositionPublish.setAcb205(jobFairBoothBookDto.getAcb205());
		corpPositionPublishService.update(corpPositionPublish);
	}

	public List<BookCorp> getBookCorp(QueryFilter queryFilter) {
		return (List<BookCorp>) dao.getListForm("getAllBookCorp", queryFilter);
	}

	// 获取参会单位数
	public Long getTotalCorp(Long acb330) {
		Map params = new HashMap();
		params.put("acb330", acb330);
		return (Long) dao.getOne("getTotalCorp", params);
	}

	public BoothBook getBoothBook(Long acb330, Long acb200) {
		Map params = new HashMap();
		params.put("acb330", acb330);
		params.put("acb200", acb200);
		return (BoothBook) dao.getOne("getBoothBook", params);
	}

	/**
	 * 获取我的招聘会登记信息列表
	 * 
	 * @param aab001
	 * @return
	 */
	public ResultData<Map> getMyBoothBookList(QueryFilter filter) {
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(filter.getPageBean());
		resultData.setDataList(dao.getListForm("getMyBoothBookList",filter));
		return resultData;
	}

	/**
	 * 获取我预定的招聘会列表
	 * 
	 * @param aab001
	 * @return
	 */
	public List<Map> getMyJobFairBookList(Long aab001) {
		Map params = new HashMap();
		params.put("aab001", aab001);
		return (List<Map>) dao.getListBySqlKey("getMyJobFairBookList", params);
	}

	/**
	 * 获取招聘会下参会企业
	 * 
	 * @param queryFilter
	 * @return
	 */
	public ResultData<BookCorp> getBookCorpList(QueryFilter queryFilter) {

		List<BookCorp> dataList = getBookCorp(queryFilter);
		ResultData<BookCorp> resultData = new ResultData<BookCorp>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}

	public List<BoothBook> getJobFairBoothList(String holdDate, Long siteId) {
		Map params = new HashMap();
		params.put("acd250", siteId);
		params.put("cczy07", holdDate);
		return dao.getBySqlKey("getBoothBySiteId", params);
	}
    //判断现在时间还能不能预定招聘会
	public boolean canBookFair(String holdDateStr){
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
	/**
	 * 节点是否收费
	 * @param configName 配置项名称
	 * @return boolean true :扣费 false:免费
	 */
	private boolean isNeedFee(String configName){
		BaseConfig baseConfig = baseConfigService.getConfigByName("member_IsPay");
		String caos04 = baseConfig.getCaos04();
		if(caos04.equals("1")){//收费
			baseConfig = baseConfigService.getConfigByName(configName);
			caos04 = baseConfig.getCaos04();
		}
		return caos04.equals("1")?true:false;
	}
	public  Date getNextDay(Date date,int delayDate ) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, delayDate);//+1今天的时间加一天
		date = calendar.getTime();
		return date;
	}
}
