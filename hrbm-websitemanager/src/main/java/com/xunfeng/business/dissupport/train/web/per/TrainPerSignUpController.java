package com.xunfeng.business.dissupport.train.web.per;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.train.interf.TrainCourseTypeServiceInterf;
import com.xunfeng.business.train.interf.TrainOrgServiceInterf;
import com.xunfeng.business.train.interf.TrainOrgTypeServiceInterf;
import com.xunfeng.business.train.interf.TrainSignUpServiceInterf;
import com.xunfeng.business.train.model.TrainCourseType;
import com.xunfeng.business.train.model.TrainOrgType;
import com.xunfeng.business.train.model.TrainSignUp;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;

import edu.emory.mathcs.backport.java.util.Arrays;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训报名表 控制器类
* @author:Wang.CS
* @createDate 2016-05-23 09:31:31 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/dissupport/train/trainSignUp/per")
public class TrainPerSignUpController extends BaseController
{
	@Resource
	@Qualifier("trainSignUp")
	private TrainSignUpServiceInterf trainSignUpService;
	
	@Resource
	@Qualifier("trainCourseType")
	private TrainCourseTypeServiceInterf trainCourseTypeService;
	
	@Resource
	@Qualifier("trainOrgType")
	private TrainOrgTypeServiceInterf trainOrgTypeService;
	
	@Resource
	@Qualifier("trainOrg")
	private TrainOrgServiceInterf trainOrgService;
		
	/**
	 * 取得培训报名表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=new ModelAndView("/business/dissupport/train/per/trainSignUpPerList.jsp");
		String orgId=RequestUtil.getString(request, "orgId");
		String pxCourseId=RequestUtil.getString(request, "pxCourseId");
		mv.addObject("orgId", orgId);
		mv.addObject("pxCourseId", pxCourseId);
		QueryFilter typeFiter=new QueryFilter();
		typeFiter.addFilter("isDel", "0");//未被删除的培训机构类别
		//获取所有培训机构类型
		List<TrainOrgType> orgTypeList=trainOrgTypeService.getAll(typeFiter);
		//获取所有开班类别
		List<TrainCourseType> courseTypeList=trainCourseTypeService.getAll(typeFiter);
		mv.addObject("courseTypeList", courseTypeList);
		mv.addObject("orgTypeList", orgTypeList);
		//初始化查看和联系状态
		trainSignUpService.updateIsCheck();
		trainSignUpService.updateIsContact();
		return mv;
	}
	
	/**
	 * 取得培训报名表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="取得培训报名表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		String orgId=RequestUtil.getString(request, "orgId");
		String pxCourseId=RequestUtil.getString(request, "pxCourseId");
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("pxOrgIds", orgId);
		//单个开班下的报名信息
		if(StringUtil.isNotEmpty(pxCourseId)){
			paramMap.put("courseId", Long.valueOf(pxCourseId));
		}
		Map<String,Object> fiterMap=fiter.getFilters();
		//封装查询条件
		if(fiterMap.containsKey("orgType")){
			paramMap.put("orgType", fiterMap.get("orgType"));//机构类型
		}
		if(fiterMap.containsKey("orgName")){
			paramMap.put("orgName", fiterMap.get("orgName"));//机构名称
		}
		if(fiterMap.containsKey("courseType")){
			paramMap.put("courseType", fiterMap.get("courseType"));//开班类型
		}
		if(fiterMap.containsKey("courseName")){
			paramMap.put("courseName", fiterMap.get("courseName"));//开班名称
		}
		if(fiterMap.containsKey("name")){
			paramMap.put("aac003", fiterMap.get("name"));//报名姓名
		}
		if(fiterMap.containsKey("aac004")){
			paramMap.put("aac004", fiterMap.get("aac004"));//报名性别
		}
		if(fiterMap.containsKey("isCheck")){
			paramMap.put("isCheck", fiterMap.get("isCheck"));//查看标识
		}
		if(fiterMap.containsKey("isContact")){
			paramMap.put("isContact", fiterMap.get("isContact"));//联系标识
		}
		if(fiterMap.containsKey("phone")){
			paramMap.put("aae005", fiterMap.get("phone"));//联系电话
		}
		//获取对应的实际数据
		List<Object> objList=trainSignUpService.getTrainSignUpList(paramMap);
		
		List<TrainSignUp> list=getTrainSignUpList(objList);
		
		List<TrainSignUp> pageList=new ArrayList<TrainSignUp>();//当前页数据
		int currentPage=offset/limit+1;//当前页数
		int start=(currentPage-1)*limit;
		int end=(currentPage*limit>list.size())? list.size() : currentPage*limit;
		for(int i=start;i<end;i++){
			pageList.add(list.get(i));
		}
		//为个人报名数据设置数据来源
		setSignUpDataSourse(pageList);
		
	  return getTableData(list.size(), pageList);
	}
	
	/**
	 * 批量更新个人报名信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("updateBatch")
	@Action(description="批量更新个人报名信息")
	@ResponseBody
	public ResultMessage updateBatch(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		String info="";
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pxSignUpId");
			String flag=RequestUtil.getString(request,"flag"); //1:表示更新查看标记，2:表示更新联系标记
			Map<String,Object> paramMap=new HashMap<String, Object>();
			paramMap.put("IdList", Arrays.asList(lAryId));
			if("1".equals(flag)){
				paramMap.put("isCheck", "1");
				info="标记为已查看";
			}
			if("2".equals(flag)){
				paramMap.put("isContact", "1");
				info="标记为已联系";
			}
			trainSignUpService.updateBatchTrainSignUp(paramMap);
			message=new ResultMessage(ResultMessage.Success, info+"成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "网络延迟，请稍后重试!");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	
	/**
	 * 导出数据
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("export")
	@Action(description="导出数据到表格")
	@ResponseBody
	public void export(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long[] lAryId =RequestUtil.getLongAryByStr(request, "pxSignUpId");
		String orgId=RequestUtil.getString(request, "orgId");
		String courseId=RequestUtil.getString(request, "pxCourseId");
		List<TrainSignUp> trainSignUpList=new ArrayList<TrainSignUp>();
		Map<String, Object> paramMap=new HashMap<String, Object>();
		//单个开班下的报名信息
		if(StringUtil.isNotEmpty(courseId)){
			paramMap.put("courseId", Long.valueOf(courseId));
		}
		//查询当前登录用户下的机构以及子机构下的开班信息
		paramMap.put("pxOrgIds", orgId);
		List<Object> objList=trainSignUpService.getTrainSignUpList(paramMap);
		List<TrainSignUp> list=getTrainSignUpList(objList);
		if(lAryId==null){
			//获取全部数据
			trainSignUpList=list;
		}else{
			for(int i=0; i<lAryId.length;i++){
				TrainSignUp trainSignUp = list.get(i);
				trainSignUpList.add(trainSignUp);
			}
		}
		//设置数据源
		setSignUpDataSourse(trainSignUpList);
		String fileName="个人报名数据.xls";
		String[] heads={"机构类别","机构名称","开班类型","开班名称","个人姓名","联系电话","身份证号","个人性别","所属民族","数据来源","报名状态","查看状态","联系状态","经办时间"};
		HSSFWorkbook wb=createWb(heads, trainSignUpList);
		response.reset();// 清空输出流 
		response.setContentType("application/vnd.ms-excel");    
		response.setHeader("Content-disposition", "attachment;filename="+ new String(fileName.getBytes("GB2312"),"ISO8859-1"));  
        OutputStream ouputStream = response.getOutputStream();    
        wb.write(ouputStream);    
        ouputStream.flush();    
        ouputStream.close();    
	}
	
	/**
	 * @param heads  表头字段
	 * @param  list  需要导出的数据
	 * @author  QINKUI
	 * @return
	 */
	public HSSFWorkbook createWb(String[] heads,List<TrainSignUp> list){
		
		// 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook(); 
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("Sheet");  
        // 第三步，在sheet中添加表头第0行  
        HSSFRow row = sheet.createRow(0); 
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
  
        //设置表头
        for(int i=0; i<heads.length;i++){
        	 HSSFCell cell = row.createCell(i);  
        	 cell.setCellValue(heads[i]); 
        	 cell.setCellStyle(style);
        }
        // 第五步，写入实体数据 
		for(int i=0; i<list.size();i++){
			TrainSignUp tsp=list.get(i);
			row = sheet.createRow(i+1);  
			row.createCell(0).setCellValue(tsp.getPxOrgTypeName());  
			row.createCell(1).setCellValue(tsp.getPxOrgName());  
			row.createCell(2).setCellValue(tsp.getCourseTypeName());
			row.createCell(3).setCellValue(tsp.getCourseName());  
			row.createCell(4).setCellValue(tsp.getUserName());  
			row.createCell(5).setCellValue(tsp.getPhone()); 
			row.createCell(6).setCellValue(tsp.getUserCard());
	        row.createCell(7).setCellValue(tsp.getUserSex()); 
	        row.createCell(8).setCellValue(tsp.getUserNation());  
	        row.createCell(9).setCellValue(tsp.getCczy06());  
	        String signUpStatus=tsp.getSignUpStatus();
	        if(StringUtil.isNotEmpty(signUpStatus)){
	        	if(signUpStatus.equals("4")){
	        		signUpStatus="已报名";
	        	}else{
	        		signUpStatus="未报名";
	        	}
	        }
	        row.createCell(10).setCellValue(signUpStatus);
	        String isCheck=tsp.getIsCheck();
	        if(StringUtil.isNotEmpty(isCheck)){
	        	isCheck= "1".equals(isCheck)? "已查看" : "未查看";
	        }
	        row.createCell(11).setCellValue(isCheck);
	        String isContact=tsp.getIsContact();
	        if(StringUtil.isNotEmpty(isContact)){
	        	isContact= "1".equals(isContact)? "已联系" : "未联系";
	        }
	        row.createCell(12).setCellValue(isContact);
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			row.createCell(13).setCellValue((tsp.getAae036()==null)? "" : sdf.format(tsp.getAae036())); 
		}
		return wb;
	}
	
	/**
	 * Map对应的记录转为 TrainSignUp
	 * @throws ParseException 
	 */
	public List<TrainSignUp> getTrainSignUpList(List<Object> mapList) throws ParseException{
		
		List<TrainSignUp> list=new ArrayList<TrainSignUp>();
		if(mapList!=null && mapList.size()>0){
			for(Object obj : mapList){
	 	    	Map<String,Object> dataMap=(Map<String, Object>) obj;
	 	    	TrainSignUp tsu=new TrainSignUp();
 	    	    tsu.setPxSignUpId(((BigDecimal)dataMap.get("PXSIGNUPID")).longValue());
 	    		tsu.setPxOrgTypeName((String)dataMap.get("ORGTYPENAME"));
 	    		tsu.setPxOrgName((String)dataMap.get("ORGNAME"));
 	    		tsu.setCourseTypeName((String)dataMap.get("COURSETYPENAME"));
 	    		tsu.setCourseName((String)dataMap.get("COURSENAME"));
 	    		tsu.setUserName((String)dataMap.get("USERNAME"));
 	    		tsu.setUserCard((String)dataMap.get("USERCARD"));
 	    		tsu.setUserSex((String)dataMap.get("SEX"));
 	    		tsu.setUserNation((String)dataMap.get("NATIONNAME"));
 	    		tsu.setSignUpStatus((String)dataMap.get("SIGN_UP_STATUS"));
 	    		tsu.setCczy06((String)dataMap.get("CCZY06"));
 	    		tsu.setPhone((String)dataMap.get("PHONE"));
 	    		tsu.setIsCheck((String)dataMap.get("IS_CHECK"));
 	    		tsu.setIsContact((String)dataMap.get("IS_CONTACT"));
 	    		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
 	    		tsu.setAae036((dataMap.get("AAE036")==null)? null:sdf.parse(dataMap.get("AAE036").toString()));
 	    		list.add(tsu);
	 	    }
		}
		return list;
	}
	
	/**
	 * 为个人报名数据设置数据来源
	 */
   public void setSignUpDataSourse(List<TrainSignUp> tspList){
	 //获取所有的数据来源
	 List<Map<String,Object>> dsList=trainSignUpService.getAllDataSourses();
		if(dsList!=null && dsList.size()>0){
			for(TrainSignUp tsu : tspList){
				for(Map<String,Object> map : dsList){
					if(StringUtil.isEmpty(tsu.getCczy06())){
						break;
					}else{
						if(tsu.getCczy06().equals(map.get("CODE"))){
							tsu.setCczy06((String)map.get("NAME"));
							break;
						}
					}
				}
			}
		}
	}
   
}
