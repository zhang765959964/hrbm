package com.xunfeng.business.personagency.retired.repository;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.print.service.BindDataService;
import com.xunfeng.business.personagency.retired.enumeration.GzStataus;
import com.xunfeng.business.personagency.retired.interf.RetiredDeclareServiceInterf;
import com.xunfeng.business.personagency.retired.interf.WorkExperienceServiceInterf;
import com.xunfeng.business.personagency.retired.interf.WorkKjServiceInterf;
import com.xunfeng.business.personagency.retired.model.RetiredDeclare;
import com.xunfeng.business.personagency.retired.model.WorkExperience;
import com.xunfeng.business.personagency.retired.model.WorkKj;
import com.xunfeng.core.util.ZJ_DateUtils;

/**
 * 退休模块打印
 * @date 2016-12-29
 * @author zf
 *
 */
@Service
public class RetiredPrintServiceImpl implements BindDataService {

	@Resource
	@Qualifier("retiredDeclare")
	private RetiredDeclareServiceInterf retiredDeclareService;
	
	@Resource
	@Qualifier("workKj")
	private WorkKjServiceInterf workKjService;
	
	@Resource
	@Qualifier("workExperience")
	private WorkExperienceServiceInterf workExperienceService;
	
	
	/**
	 * 退休申诉 打印
	 * 
	 */
	@Override
	public Map getBindData(Map paramMap) {
		Map<String,Object> map;
		 String personId = (String)paramMap.get("personId");
		 if(personId!=null){
			 Long personIds = Long.valueOf(personId);
			 String retiredYjId;	//退休依据id
			 String retiredTypeId;	//退休类别id
			 
			 map = retiredDeclareService.getPrintByPersonId(personIds);	//获得退休人员打印列表数据
			 
			 RetiredDeclare retiredDeclare = retiredDeclareService.getByPersonId(personIds);	//获得退休申报数据
			 
			 if(retiredDeclare!=null){
				 retiredYjId = retiredDeclare.getRetiredYjId();
				 retiredTypeId = retiredDeclare.getRetiredTypeId();
				 String retiredYjName  = this.getRetiredYjName(retiredYjId);
				 map.put("retiredYjName",retiredYjName);
				 if(retiredTypeId.equals("2")){	//等于特殊工种
					 map.put("craft1",retiredDeclare.getCraft());
				 }
			 }
			 
			 
			if(map!=null){
				//工作经历
				List<WorkExperience> workList =  workExperienceService.getByPersonId(personIds);
				if(workList.size()>0&&workList!=null){
					for (int i = 0; i < workList.size(); i++) {
						WorkExperience ex =  (WorkExperience)workList.get(i);
						if(i==0){
							map.put("exCreaterTime",ZJ_DateUtils.date2dateFormat(ex.getCreateTime()));
							map.put("exEndTime",ZJ_DateUtils.date2dateFormat(ex.getEndTime()));
							if(ex.getGzId()!=null){
								map.put("gzValue",GzStataus.getName(ex.getGzId()));
							}
							
							map.put("workUnit", ex.getWorkUnit());
							
						}else if(i==1){
							map.put("exCreaterTime1", ZJ_DateUtils.date2dateFormat(ex.getCreateTime()));
							map.put("exEndTime1",ZJ_DateUtils.date2dateFormat(ex.getEndTime()));
							if(ex.getGzId()!=null){
								map.put("gzValue1", GzStataus.getName(ex.getGzId()));
							}
							map.put("workUnit1", ex.getWorkUnit());
						}else if(i==2){
							map.put("exCreaterTime2", ZJ_DateUtils.date2dateFormat(ex.getCreateTime()));
							map.put("exEndTime2",ZJ_DateUtils.date2dateFormat(ex.getEndTime()));
							if(ex.getGzId()!=null){
								map.put("gzValue2",GzStataus.getName(ex.getGzId()));
							}
						
							map.put("workUnit2", ex.getWorkUnit());
						}else if(i==3){
							map.put("exCreaterTime3", ZJ_DateUtils.date2dateFormat(ex.getCreateTime()));
							map.put("exEndTime3",ZJ_DateUtils.date2dateFormat(ex.getEndTime()));
							if(ex.getGzId()!=null){
								map.put("gzValue3",GzStataus.getName(ex.getGzId()));
							}
							map.put("workUnit3", ex.getWorkUnit());
						}else{
							map.put("exCreaterTime4", ZJ_DateUtils.date2dateFormat(ex.getCreateTime()));
							map.put("exEndTime4",ZJ_DateUtils.date2dateFormat(ex.getEndTime()));
							if(ex.getGzId()!=null){
								map.put("gzValue4",GzStataus.getName(ex.getGzId()));
							}
							
							
							map.put("workUnit4", ex.getWorkUnit());
						}
					}
				}
				 
				 
				 //获得工作扣减信息
				 List list = workKjService.getByPersonId(personIds);
				 if(list.size()>0&&list!=null){
					 for (int i = 0; i < list.size(); i++) {
						WorkKj workKj  = (WorkKj)list.get(i);
						if(i==0){
							map.put("createrTime",ZJ_DateUtils.dateYmFormat(workKj.getCreateTime()));
							map.put("endTime", ZJ_DateUtils.dateYmFormat(workKj.getEndTime()));
							map.put("reason", workKj.getReason());
							map.put("kjNum", workKj.getKjNum());
						}else if(i==1){
							map.put("createrTime1",ZJ_DateUtils.dateYmFormat(workKj.getCreateTime()));
							map.put("endTime1", ZJ_DateUtils.dateYmFormat(workKj.getEndTime()));
							map.put("reason1", workKj.getReason());
							map.put("kjNum1", workKj.getKjNum());
						}else{
							map.put("createrTime2",ZJ_DateUtils.dateYmFormat(workKj.getCreateTime()));
							map.put("endTime2", ZJ_DateUtils.dateYmFormat(workKj.getEndTime()));
							map.put("reason2", workKj.getReason());
							map.put("kjNum2", workKj.getKjNum());
						}
					}
				 }
			}
			 
		
			 return map;
		 }
		
		 return null;
	}

	/**
	 * 根据 退休依据id获取 依据名称
	 * @param retiredYjId 退休依据id
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getRetiredYjName(String retiredYjId){
		String name = "";
		switch (retiredYjId) {
		case "01":
			name =  "(  1  )第一条第一项规定";
			break;
		case "02":
			name =  "(  1  )第一条第二项规定";
			break;
		case "03":
			name =  "(  2  )第四条第一项规定";
			break;
		case "04":
			name =  "(  1  )第一条第三项规定";
			break;
		case "05":
			name =  "(  1  )第五条规定";
			break;
		case "06":
			name =  "符合豫政[2006]29号文规定";
			break;
		default:
			name = "(     )第     条第    项规定";
			break;
		}
		return name;
		
	}
}
