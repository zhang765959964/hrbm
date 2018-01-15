package com.xunfeng.business.dissupport.train.web;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.cms.util.ServiceUtil;
import com.xunfeng.business.dissupport.train.web.form.TrainCourseForm;
import com.xunfeng.business.train.interf.TrainCourseServiceInterf;
import com.xunfeng.business.train.interf.TrainCourseTypeServiceInterf;
import com.xunfeng.business.train.interf.TrainOrgServiceInterf;
import com.xunfeng.business.train.interf.TrainSignUpServiceInterf;
import com.xunfeng.business.train.interf.TrainSysSetServiceInterf;
import com.xunfeng.business.train.model.TrainCourse;
import com.xunfeng.business.train.model.TrainCourseType;
import com.xunfeng.business.train.model.TrainOrg;
import com.xunfeng.business.train.model.TrainSysSet;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.FileUtil;
import com.xunfeng.core.util.FileWebDavUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;

import edu.emory.mathcs.backport.java.util.Arrays;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 开班信息表 控制器类
* @author:Wang.CS
* @createDate 2016-05-22 09:25:59 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/dissupport/train/trainCourse/")
public class TrainCourseController extends BaseController
{
	@Resource
	@Qualifier("trainCourse")
	private TrainCourseServiceInterf trainCourseService;
	
	@Resource
	@Qualifier("trainCourseType")
	private TrainCourseTypeServiceInterf trainCourseTypeService;
	
	@Resource
	@Qualifier("trainOrg")
	private TrainOrgServiceInterf trainOrgService;
	
	@Resource
	@Qualifier("trainSysSet")
	private TrainSysSetServiceInterf trainSysSetService;
	
	@Resource
	@Qualifier("trainSignUp")
	private TrainSignUpServiceInterf trainSignUpService;
	
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新开班信息表。
	 * @param request
	 * @param response
	 * @param trainCourseForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新开班信息")
	public void save(HttpServletRequest request, HttpServletResponse response,TrainCourseForm trainCourseForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long pxCourseId=RequestUtil.getLong(request,"pxCourseId");
		    TrainCourse trainCourse = trainCourseService.getById(pxCourseId);
			trainCourse=trainCourseForm.getModel(trainCourse);
			if(trainCourseForm.isMvcAdd()){
				resultMsg="添加开班信息";
				String sysSetName=SystemConst.KEY_PX_COURSE_IS_AUDIT;//系统表中设置的新增的开班信息是否需要审核
				QueryFilter fiter=new QueryFilter();
				fiter.addFilter("caos02", sysSetName);
				TrainSysSet tss= trainSysSetService.getAll(fiter).get(0);
				String flag=(tss==null) ? "1": tss.getCaos04(); //是否需要审核标识，"0":不需要，"1":需要
				trainCourse.setPxCourseId(uniqueIdUtil.genSeqId(SqeIdName.TrainCourse.getSeqName()));
				String aae019=ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAac003();// 经办人
				String aae020=ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd202();// 经办机构
				String aae011=ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAcd230()+"";// 经办人代码
				String aae017=ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd200()+"";// 经办机构代码
				Date date=new Date();//时间
				trainCourse.setAae019(aae019);// 经办人
				trainCourse.setAae020(aae020);// 经办机构
				trainCourse.setAae011(aae011);// 经办人代码
				trainCourse.setAae017(aae017);// 经办机构代码
				trainCourse.setIsDel("0");//默认未被删除
				trainCourse.setAae036(date); //经办时间
				if("0".equals(flag)){
				trainCourse.setIsAudit("1");//审核通过
				trainCourse.setAbb767(aae011);// 审核人代码
				trainCourse.setAbb768(aae017);// 审核机构代码
				trainCourse.setAbb769(aae019);// 审核人
				trainCourse.setAbb770(aae020);// 审核机构
				trainCourse.setAbb771(date);// 审核时间
				}else{
					trainCourse.setIsAudit("0");//默认为0:未审核
				}
				trainCourse.setIsDisable("0");//默认未禁用
				trainCourse.setAcb208("0");//默认未冻结
				trainCourse.setCczy06(SystemConst.DATA_SOURCE_BS);//数据来源,18:BS大平台
				trainCourse.setClickTimes(0l); //新创建的点击次数为0
				trainCourseService.add(trainCourse);
			}else{
				resultMsg="更新开班信息";
			    trainCourseService.update(trainCourse);
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得开班信息表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/dissupport/train/trainCourseList.jsp");
		QueryFilter fiter=new QueryFilter();
		fiter.addFilter("isDel", "0"); //未被删除的
		List<TrainCourseType> courseTypeList=trainCourseTypeService.getAll(fiter);
		mv.addObject("courseTypeList", courseTypeList);
		//获取培训机构
		List<TrainOrg> orgList=getAllOrgList2();
		mv.addObject("orgList", orgList);
		return mv;
	}
	/**
	 * 取得开班信息表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
	    fiter.addFilter("isDel", "0");//未被删除的
	    //查询当前登录用户下的机构以及子机构下的开班信息
	    fiter.addFilter("pxOrgIds", getAllOrgIds());
	    ResultData<TrainCourse> resultData=trainCourseService.getAllTrainCourse(fiter);
	    List<TrainCourse> list=resultData.getDataList();	
	    //为开班信息设置类别名称和所属机构
	    setCourseInfo(list);
	    setLengthList(list);
	    return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 删除开班信息表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除开班信息表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pxCourseId");
			trainCourseService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除开班信息表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	/**
	 * 	新增开班信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增开班信息表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		TrainCourseForm  trainCourseForm=new TrainCourseForm();
		trainCourseForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/train/trainCourseAdd.jsp");
		
		QueryFilter fiter=new QueryFilter();
		fiter.addFilter("isDel", "0"); //未被删除的
		List<TrainCourseType> courseTypeList=trainCourseTypeService.getAll(fiter);
		//获取培训机构
		List<TrainOrg> orgList=getAllOrgList2();
		return modelAndView.addObject("trainCourseForm",trainCourseForm).addObject("courseTypeList", courseTypeList).addObject("orgList", orgList);					
	}
	/**
	 * 	编辑开班信息表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑开班信息表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/train/trainCourseEdit.jsp");
		Long pxCourseId=RequestUtil.getLong(request,"pxCourseId",0L);
		TrainCourse trainCourse=trainCourseService.getById(pxCourseId);
		TrainCourseForm  trainCourseForm=new TrainCourseForm();
		trainCourseForm.putModel(trainCourse);
		
		QueryFilter fiter=new QueryFilter();
		fiter.addFilter("isDel", "0"); //未被删除的
		List<TrainCourseType> courseTypeList=trainCourseTypeService.getAll(fiter);
		//获取培训机构
		List<TrainOrg> orgList=getAllOrgList2();
		return modelAndView.addObject("trainCourseForm",trainCourseForm).addObject("courseTypeList", courseTypeList)
				.addObject("orgList", orgList).addObject("isFlag", "edit").addObject("editCourseName", trainCourseForm.getCourseName());					
	}

	/**
	 * 取得开班信息表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看开班信息表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long pxCourseId=RequestUtil.getLong(request,"pxCourseId");
		TrainCourse trainCourse = trainCourseService.getById(pxCourseId);	
		return getAutoView().addObject("trainCourse", trainCourse);
	}
	
	/**
	 * 更新开班信息表(审核或删除或禁用或冻结状态)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("update")
	@Action(description="更新开班信息表")
	@ResponseBody
	public ResultMessage update(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		String info=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pxCourseId");
			String flag=RequestUtil.getString(request, "flag");//更新业务标识
			Map<String, Object> paramMap=new HashMap<String, Object>();
			String auditInfo="";
			if(flag.equals("del")){
				paramMap.put("isDel", "1");//表示删除
				info="删除";
				//判断该开班下是否有报名信息,如果有则禁止删除
				int count=Integer.valueOf(trainSignUpService.getCountByCourseId(lAryId[0]).get("COUNT").toString());
				if(count>0){
					return new ResultMessage(2, "该开班下有报名信息，不能直接删除!");
				}
				
			}else if(flag.equals("audit")){
				String isAudit=RequestUtil.getString(request, "isAudit");//审核状态标识
				paramMap.put("isAudit", isAudit);
				if(isAudit.equals("1")){
					auditInfo="开班信息审核通过!";
				}else{
					auditInfo="开班信息审核未通过!";
				}
				
			}else if(flag.equals("disable")){
				paramMap.put("isDisable", "1");//表示禁用
				info="禁用";
				//1.判断该开班是否禁用过，如果已禁用则不在操作
				TrainCourse tc=trainCourseService.getById(lAryId[0]);
				if("1".equals(tc.getIsDisable())){
					return new ResultMessage(2, "该开班已被禁用，请勿重复操作!");
				}
			}else{
				paramMap.put("acb208", "1");//表示冻结
				info="冻结";
			}
			//只有审核操作时才更新审核人相关信息
			if(flag.equals("audit")){
				String abb772= URLDecoder.decode(RequestUtil.getString(request, "abb772"),"UTF-8");
				paramMap.put("abb769",ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAac003());//审核人
				paramMap.put("abb767",ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAcd230()+"");//审核人代码
				paramMap.put("abb770",ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd202());//审核机构
				paramMap.put("abb768",ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd200()+"");//审核机构代码
				paramMap.put("abb772",StringUtil.isEmpty(abb772)?"\"\"":abb772);//审核意见
				paramMap.put("abb771",new Date());//审核时间
			}else{
				paramMap.put("aae019",ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAac003());//经办人
				paramMap.put("aae011",ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAcd230()+"");//经办人代码
				paramMap.put("aae020",ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd202());//经办机构
				paramMap.put("aae017",ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd200()+"");//经办机构代码
				paramMap.put("aae036",new Date());//经办时间
			}
			paramMap.put("courseIdList", Arrays.asList(lAryId));
			trainCourseService.updateBatchStatus(paramMap);
			if(StringUtil.isNotEmpty(auditInfo)){
				message=new ResultMessage(ResultMessage.Success, auditInfo);
			}else{
				message=new ResultMessage(ResultMessage.Success, info+"开班信息成功!");
			}
			
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, info+"失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 更新开班信息表(审核或删除或禁用或冻结状态)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("enable")
	@Action(description="解禁开班信息")
	@ResponseBody
	public ResultMessage enable(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pxCourseId");
			Map<String, Object> paramMap=new HashMap<String, Object>();
			TrainCourse tc=trainCourseService.getById(lAryId[0]);
			if("0".equals(tc.getIsDisable())){
				return new ResultMessage(2, "该开班信息未被禁用,不需解禁!");
			}else{
				paramMap.put("isDisable",SystemConst.STATIC_VALUE_ZERO);//解禁
			}
			paramMap.put("aae019",ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAac003());//经办人
			paramMap.put("aae011",ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAcd230()+"");//经办人代码
			paramMap.put("aae020",ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd202());//经办机构
			paramMap.put("aae017",ContextUtil.getCurrentUserOrg()==null ? ""  : ContextUtil.getCurrentUserOrg().getAcd200()+"");//经办机构代码
			paramMap.put("aae036",new Date());//经办时间
		    paramMap.put("courseIdList", Arrays.asList(lAryId));
			trainCourseService.updateBatchStatus(paramMap);
		
			message=new ResultMessage(ResultMessage.Success, "开班信息解禁成功!");
		
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "开班信息解禁失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	/**
	 * 验证开班名称是否重复
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("checkName")
	@Action(description="验证开班名称是否重复")
	@ResponseBody
	public ResultMessage checkName(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			
			String courseName=URLDecoder.decode(RequestUtil.getString(request, "courseName"),"UTF-8");
			TrainCourse tc=trainCourseService.getCourseByName(courseName);
			if(tc!=null){
				message=new ResultMessage(ResultMessage.Success, "保存失败,开班名称已存在!");
			}else{
				message=new ResultMessage(ResultMessage.Fail,"开班名称不重复");
			}
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Success, "验证开班名称是否重复失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 取得开班信息所有未审核过的分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("disAuditList")
	public ModelAndView disAuditList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=new ModelAndView("/business/dissupport/train/disAuditTrainCourseList.jsp");
		QueryFilter fiter=new QueryFilter();
		fiter.addFilter("isDel", "0"); //未被删除的
		List<TrainCourseType> courseTypeList=trainCourseTypeService.getAll(fiter);
		mv.addObject("courseTypeList", courseTypeList);
		//获取培训机构
		List<TrainOrg> orgList=getAllOrgList();
		mv.addObject("orgList", orgList);
		return mv;
	}
	
	/**
	 * 取得开班信息所有未审核过的分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("disAuditListJson")
	@Action(description="取得开班信息所有未审核过的分页列表")
	@ResponseBody
	public Map<Object,Object> disAuditListJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
		//先判断一下fiter中是否有审核字段值，如果有不重新赋值以免被覆盖
		boolean flag=fiter.getFilters().containsKey("isAudit");
		if(!flag){
			fiter.addFilter("isAudit", "0");//默认查询未审核且未被删除的开班
		}
		fiter.addFilter("isDel", "0");// 未删除的
		fiter.addFilter("orderField","COURSE_START_TIME");//按开班成立的先后时间排序
		fiter.addFilter("orderSeq", "asc");
		//查询当前登录用户下的机构以及子机构下的开班信息
	    fiter.addFilter("pxOrgIds", getAllOrgIds());
	    
		ResultData<TrainCourse> resultData=trainCourseService.getAllTrainCourse(fiter);
		List<TrainCourse> list=resultData.getDataList();
		//为开班信息设置类别名称和所属机构
	    setCourseInfo(list);
	    setLengthList(list);
	    //为开班信息设置数据来源
	    setDataSourse(list);
	    
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
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
		Long[] lAryId =RequestUtil.getLongAryByStr(request, "pxCourseId");
		List<TrainCourse> courseOrgList=new ArrayList<TrainCourse>();
		if(lAryId==null){
			//获取全部数据
			QueryFilter fiter=new QueryFilter();
			fiter.addFilter("isDel", "0");
			//查询当前登录用户下的机构以及子机构下的开班信息
		    fiter.addFilter("pxOrgIds", getAllOrgIds());
			courseOrgList=trainCourseService.getAll(fiter);
		}else{
			for(int i=0; i<lAryId.length;i++){
				TrainCourse trainCourse = trainCourseService.getById(lAryId[i]);
				courseOrgList.add(trainCourse);
			}
		}
		//为开班信息设置类别名称和所属机构
	    setCourseInfo(courseOrgList);
	    
		String fileName="开班数据.xls";
		String[] heads={"所属机构","开班名称","名称简码","开班类型","联系人","联系电话","培训费用","开班时间","学习周期","培训地点","培训特色","培训内容","禁用状态","冻结状态","经办人","经办机构","经办日期"};
		HSSFWorkbook wb=createWb(heads, courseOrgList);
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
	public HSSFWorkbook createWb(String[] heads,List<TrainCourse> list){
		
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
			TrainCourse tc=list.get(i);
			row = sheet.createRow(i+1); 
			row.createCell(0).setCellValue(tc.getPxOrgName());  
			row.createCell(1).setCellValue(tc.getCourseName());  
			row.createCell(2).setCellValue(tc.getAac022());
			row.createCell(3).setCellValue(tc.getCourseType());  
			row.createCell(4).setCellValue(tc.getContactsName());  
			row.createCell(5).setCellValue(tc.getContactsTel());
	        row.createCell(6).setCellValue(tc.getCost()==null ? 0.0 : tc.getCost());  
	        row.createCell(7).setCellValue(tc.getCourseStartTime());  
	        row.createCell(8).setCellValue(tc.getCoursePeriod()); 
	        row.createCell(9).setCellValue(tc.getCourseAddr());  
	        row.createCell(10).setCellValue(tc.getCourseFeature()); 
	        row.createCell(11).setCellValue(tc.getCourseContent()); 
			row.createCell(12).setCellValue(tc.getIsDisable().equals("0")? "否" : "是");
			row.createCell(13).setCellValue(tc.getAcb208().equals("0")? "否" : "是");
			row.createCell(14).setCellValue(tc.getAae019());  
			row.createCell(15).setCellValue(tc.getAae020());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			row.createCell(16).setCellValue((tc.getAae036()==null)? "" : sdf.format(tc.getAae036())); 
		}
		return wb;
	}
	
	/**
	 * 为开班信息设置类别名称和所属机构
	 */
	public void setCourseInfo(List<TrainCourse> list){
		  if(list!=null && list.size()>0){
		    	for(TrainCourse tc : list){
		    	  TrainCourseType tct=trainCourseTypeService.getById(Long.valueOf(tc.getCourseType()));	//根据开班类型获取对应类型信息
		    	  TrainOrg to=trainOrgService.getById(tc.getPxOrgId());//根据开班所属培训机构编号获取对应培训机构信息
		    	  tc.setCourseType(tct==null ? "" : tct.getName());
		    	  tc.setPxOrgName(to==null? "" : to.getOrgName());
		    	}
		    }
	}
	
	/**
	 * 限制相关字段长度
	 */
	public void  setLengthList(List<TrainCourse> list){
		  if(list!=null && list.size()>0){
		    	for(TrainCourse tc : list){
		    	  //重新设置相关字段
		    	  String addr=tc.getCourseAddr()==null ? "" : tc.getCourseAddr().length()>20 ? tc.getCourseAddr().substring(0, 20)+"..." : tc.getCourseAddr();
		    	  String feature=tc.getCourseFeature()==null ? "" : tc.getCourseFeature().length()>20 ? tc.getCourseFeature().substring(0, 20)+"..." : tc.getCourseFeature();
		    	  String content=tc.getCourseContent()==null ? "" : tc.getCourseContent().length()>20 ? tc.getCourseContent().substring(0, 20)+"..." : tc.getCourseContent();
		    	  tc.setCourseAddr(addr);
		    	  tc.setCourseFeature(feature);
		    	  tc.setCourseContent(content);
		    	}
		    }
	}
	
	/**
	 * 获取未被删除的且审核通过未被禁用的所有培训机构
	 */
	public List<TrainOrg> getAllOrgList(){
		QueryFilter fiter=new QueryFilter();
		fiter.addFilter("isAudit", "1");//审核通过
        fiter.addFilter("isDel", "0");//未被删除
        fiter.addFilter("isDisable", "0");//未被禁用的
        fiter.addFilter("aae017s", getSubCon());
		return trainOrgService.getAll(fiter);
	}
	
	/**
	 * 获取未被删除的且审核通过的所有培训机构
	 */
	public List<TrainOrg> getAllOrgList2(){
		QueryFilter fiter=new QueryFilter();
		fiter.addFilter("isAudit", "1");//审核通过
        fiter.addFilter("isDel", "0");//未被删除
        fiter.addFilter("aae017s", getSubCon());
		return trainOrgService.getAll(fiter);
	}
	
	/**
	 *  获取所需培训机构的所有机构Id
	 */
	public String  getAllOrgIds(){
		QueryFilter fiter=new QueryFilter();
        fiter.addFilter("isDel", "0");//未被删除
        fiter.addFilter("aae017s", getSubCon());//关联当前登录用户所在的职介机构编号以及子编号
        List<TrainOrg> toList=trainOrgService.getAll(fiter);
        StringBuffer sb=new StringBuffer();
        sb.append("(");
        if(toList==null || toList.size()<1){
        	sb.append("'')");
        }else{
        	for(int i=0;i<toList.size();i++){
            	TrainOrg to=toList.get(i);
            	if(i==toList.size()-1){
            		sb.append(to.getPxOrgId()+")");
            	}else{
            		sb.append(to.getPxOrgId()+",");
            	}
            }
        }
        return sb.toString();
	}
	
	@RequestMapping("fileUpload")
	@ResponseBody
	public void fileUpload(MultipartHttpServletRequest request,
			HttpServletResponse response) throws Exception {

		PrintWriter writer = response.getWriter();
		try {
			String fileFormates = RequestUtil
					.getString(request, "fileFormates"); // 格式要求

			boolean mark = true;
			Map<String, MultipartFile> files = request.getFileMap();
			Iterator<MultipartFile> it = files.values().iterator();

			while (it.hasNext()) {
				Long fileId = uniqueIdUtil.genId("");
				MultipartFile f = it.next();
				String oriFileName = f.getOriginalFilename();
				String extName = FileUtil.getFileExt(oriFileName);

				if (StringUtil.isNotEmpty(fileFormates)) { // 文件格式要求
					if (!(fileFormates.contains("*." + extName))) { // 不符合文件格式要求的就标志为false
						mark = false;
					}
				}
				if (mark) {
					String fileName = fileId + "." + extName;
					// 开始写入物理文件
					String filePath=FileWebDavUtil.uploadFile(7L, fileName, f.getInputStream());
					writer.println(filePath);
				} else {
					logger.error("文件格式不符合要求！");
					writer.println("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			writer.println("");
		}
	}
	/**
	 * 根据文件id取得附件数据。
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("getImageById")
	@Action(description = "根据文件id取得附件数据", exectype = "管理图片", detail = "根据文件id取得图片")
	public void getFileById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String filePath = RequestUtil.getString(request, "filePath");

		String attachPath = ServiceUtil.getBasePath();

		// 附件保存路径
		String fullPath = StringUtil.trimSufffix(attachPath, File.separator)
				+ File.separator + filePath.replace("/", File.separator);

		byte[] bytes = FileUtil.readByte(fullPath);
		response.getOutputStream().write(bytes);
	}
	
	 /**
		 * 为开班信息设置数据来源
		 */
	  public void setDataSourse(List<TrainCourse> courseList){
		 //获取所有的数据来源
		 List<Map<String,Object>> dsList=trainSignUpService.getAllDataSourses();
			if(dsList!=null && dsList.size()>0){
				for(TrainCourse tc : courseList){
					for(Map<String,Object> map : dsList){
						if(StringUtil.isEmpty(tc.getCczy06())){
							break;
						}else{
							if(tc.getCczy06().equals(map.get("CODE"))){
								tc.setCczy06((String)map.get("NAME"));
								break;
							}
						}
					}
				}
			}
		}
}
