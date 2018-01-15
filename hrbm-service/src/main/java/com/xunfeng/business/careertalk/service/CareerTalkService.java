package com.xunfeng.business.careertalk.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.xunfeng.business.careertalk.dao.CareerTalkDao;
import com.xunfeng.business.careertalk.dto.careerTalkJobfairDto;
import com.xunfeng.business.careertalk.model.CareerRoom;
import com.xunfeng.business.careertalk.model.CareerTalk;
import com.xunfeng.business.careertalk.model.CareerTalkView;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.TimeUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 宣讲会 Service类
* @author:zhouhang
* @createDate 2015-09-22 18:18:47 
* @version V1.0   
*/
@Service
public class CareerTalkService extends BaseService<CareerTalk>
{
	@Resource
	private CareerTalkDao dao;
	@Resource
	CareerRoomService  careerRoomService;
	@Resource
	UniqueIdUtilService  uniqueIdUtil;
	public CareerTalkService()
	{
	}
	
	@Override
	protected IEntityDao<CareerTalk, Long> getEntityDao() 
	{
		return dao;
	}
	public List<CareerTalkView> selectCareertalkview(QueryFilter fiter) {
		return dao.getListForm("selectCareertalkview", fiter);
	}

	public List<CareerTalk> getMyCareerTalk(Long aab001) {
		Map map=new HashMap();
		map.put("ctCreateby",aab001);
		return dao.getBySqlKey("getAll",map);
	}

	public List<CareerTalkView> getCareerTalkByMonth(Date currentDay) {
		Calendar c = Calendar.getInstance();//获得一个日历的实例
		c.setTime(currentDay);
		String currentDay_str=TimeUtil.getDateTimeString(currentDay, "yyyy-MM-dd");
		int lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		String lastDay_str=TimeUtil.getDateTimeString(currentDay, "yyyy-MM");
		Map map=new HashMap();
		map.put("beginctCareerStarttime",currentDay_str+" 00:00");
		map.put("endctCareerStarttime",lastDay_str+"-"+lastday+" 23:59");
		map.put("allctStatus","('0','1')");
		return dao.getListBySqlKey("selectCareertalkview",map);
	}
	
	
	//获取当前公司下没有过期的宣讲会总数
	public Long getCareerTalkCount(Long ctCreateby,String dateString){
		Map params = new HashMap();
		params.put("ctCreateby",ctCreateby);
		params.put("beginctCareerEndtime",dateString);
		params.put("ctStatus",1);
		return (Long)dao.getOne("getCareerTalkCount", params);
	}
	
	//获取就业日历下的宣讲会和招聘会
	public List<careerTalkJobfairDto> getAllCareerTalkJobfair(QueryFilter fiter){
		Map params = new HashMap();
		return dao.getListForm("getAllCareerTalkJobfair", fiter);
	}
	//获取就业日历下的宣讲会和招聘会  传参数2
	public List<careerTalkJobfairDto> getAllCareerTalkJobfairIndex(String startDate,String endDate){
		Map params = new HashMap();
		params.put("beginctCareerStarttime",startDate);
		params.put("endctCareerEndtime",endDate);
		return dao.getListBySqlKey("getAllCareerTalkJobfair", params);
	}
	public void SynchRoom(){
		JdbcTemplate jdbcTemplate=(JdbcTemplate) AppUtil.getBean("jdbcTemplateSouce");
		List<Map<String,Object>> list= jdbcTemplate.queryForList("select * from T_XJH_Location");
		Map colMap=new HashMap();
		for(Map map:list){
			CareerRoom room=new CareerRoom();
			room.setCrId(uniqueIdUtil.genId(CareerRoom.class.getName()));
			colMap.put(map.get("ID"),room);
			room.setCrName((String) map.get("C_Name"));
			room.setCrAddress((String) map.get("C_Addr"));
			room.setCrDesc((String) map.get("C_Discript"));
			room.setCrMaxPeople(ParseLong(map.get("C_PersonNum")));
			room.setCrStatus(map.get("B_IsEnable").toString().equals("true")?1L:0L);
			room.setCrCreatetime((Date) map.get("DT_RegDate"));
			room.setCrUpdatetime((Date) map.get("DT_UpdDate"));
			room.setCrCreateBy(1L);
			room.setCrUpdateBy(1L);
			careerRoomService.add(room);
		}
		SynchTalk(colMap);
		String dsds="";
		String dsdsdsd="";
	}
	private Long ParseLong(Object inte){

		return Long.parseLong(inte.toString());

	}
	private void SynchTalk(Map colMap){
		JdbcTemplate jdbcTemplate=(JdbcTemplate) AppUtil.getBean("jdbcTemplateSouce");
		List<Map<String,Object>> list= jdbcTemplate.queryForList("select * from T_XJH_List");
		for(Map map:list){
			CareerTalk talk=new CareerTalk();
			talk.setCtId(uniqueIdUtil.genId(CareerTalk.class.getName()));
			CareerRoom CareerRoom=(CareerRoom)colMap.get(map.get("N_LocationID"));
			talk.setCrId(CareerRoom==null?ParseLong(map.get("N_LocationID")):CareerRoom.getCrId());
			talk.setCtCreatetime((Date) map.get("DT_RegDate"));
			talk.setCtUpdatetime((Date) map.get("DT_UpdDate"));
			talk.setCtUpdateby(1L);
			talk.setCtCareerStarttime((Date) map.get("DT_StartDate"));
			talk.setCtCareerEndtime((Date) map.get("DT_EndDate"));
			talk.setCtCreateby(ParseLong(map.get("N_CorpID")));
			talk.setCtStatus(ParseLong(map.get("N_Status")));
			talk.setCtApproveOpinion("");
			talk.setCtApproveTime((Date) map.get("DT_UpdDate"));
			talk.setCtApproveUserid(1L);
			talk.setCtbId(null);
			talk.setCtContent((String) map.get("C_XJHDiscription"));
			talk.setCtTitle((String) map.get("C_XJHName"));
			talk.setLinkMan((String) map.get("C_LinkMan"));
			talk.setLinkQq((String) map.get("C_LinkQQ"));
			talk.setLinkTel((String) map.get("C_LinkTel"));
			this.add(talk);
		}
		String dsds="";
		String dsdsdsd="";
	}

	public static void main(String[] arg){

		Calendar c = Calendar.getInstance();//获得一个日历的实例
		c.setTime(new Date());
		c.add(Calendar.MONTH,4);
		String currentDay_str=TimeUtil.getDateTimeString(new Date(), "yyyy-MM-dd");
		String lastDay_str=TimeUtil.getDateTimeString(new Date(), "yyyy-MM");
		int day = c.get(Calendar.DATE);
		int month = c.get(Calendar.MONTH);
		int year = c.get(Calendar.YEAR) ;
		int week = c.get(Calendar.DAY_OF_WEEK);
		int lastday = c.getMaximum(Calendar.DAY_OF_MONTH);
		int sdsd = c.get(Calendar.DAY_OF_MONTH);
//		Date date=new Date();
//		Date startDate= DateUtil.parseDate("2015-10-16");
//		Long dsds=date.getTime();
//		Long dsdsds=startDate.getTime();
//		String sds="";

	}
	
	
}
