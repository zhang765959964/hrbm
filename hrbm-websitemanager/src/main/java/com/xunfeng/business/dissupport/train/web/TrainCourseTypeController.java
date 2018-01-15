package com.xunfeng.business.dissupport.train.web;

import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.dissupport.train.web.form.TrainCourseTypeForm;
import com.xunfeng.business.train.interf.TrainCourseServiceInterf;
import com.xunfeng.business.train.interf.TrainCourseTypeServiceInterf;
import com.xunfeng.business.train.model.TrainCourse;
import com.xunfeng.business.train.model.TrainCourseType;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;

import edu.emory.mathcs.backport.java.util.Arrays;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 开班类型表 控制器类
* @author:Wang.CS
* @createDate 2016-05-23 09:29:51 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/dissupport/train/trainCourseType/")
public class TrainCourseTypeController extends BaseController
{
	@Resource
	@Qualifier("trainCourseType")
	private TrainCourseTypeServiceInterf trainCourseTypeService;
	
	@Resource
	@Qualifier("trainCourse")
	private TrainCourseServiceInterf trainCourseService;
	
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新开班类型表。
	 * @param request
	 * @param response
	 * @param trainCourseTypeForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新开班类型")
	public void save(HttpServletRequest request, HttpServletResponse response,TrainCourseTypeForm trainCourseTypeForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long typeId=RequestUtil.getLong(request,"typeId");
		    TrainCourseType trainCourseType = trainCourseTypeService.getById(typeId);
			trainCourseType=trainCourseTypeForm.getModel(trainCourseType);
			if(trainCourseType.getPid()==null){
				trainCourseType.setPid(0l);
			}
			if(trainCourseTypeForm.isMvcAdd()){
				resultMsg="添加开班类型";
				trainCourseType.setTypeId(uniqueIdUtil.genSeqId(SqeIdName.TrainCourseType.getSeqName()));
				trainCourseType.setAae019(ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAac003());// 经办人
				trainCourseType.setAae020(ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd202());// 经办机构
				trainCourseType.setAae011(ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAcd230()+"");// 经办人代码
				trainCourseType.setAae017(ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd200()+"");// 经办机构代码
				trainCourseType.setIsDel("0");//默认未被删除
				trainCourseType.setCczy06(SystemConst.DATA_SOURCE_BS);//数据来源,18:BS大平台
				trainCourseType.setAae036(new Date());// 经办时间
				trainCourseTypeService.add(trainCourseType);
				
			}else{
				resultMsg="更新开班类型";
			    trainCourseTypeService.update(trainCourseType);
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
	 * 取得开班类型表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/dissupport/train/trainCourseTypeList.jsp");
		
		return mv;
	}
	/**
	 * 取得开班类型表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="取得开班类型表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
	    fiter.addFilter("isDel", "0");//未被删除的
	    
	    ResultData<TrainCourseType> resultData=trainCourseTypeService.getAllTrainCourseType(fiter);
	    List<TrainCourseType> list=resultData.getDataList();	
		if(list!=null && list.size()>0){
			//为开班类别设置上级类别名称
			for(TrainCourseType tct : list){
				if(tct.getPid()!=0){
					TrainCourseType ptct=trainCourseTypeService.getById(tct.getPid());
					tct.setpName(ptct.getName());
				   }else{
					   tct.setpName(tct.getName());
				   }
				}
		}
	    return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 删除开班类型表(实际是设置删除标志位)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除开班类型表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "typeId");
			
			//如果该开班类别下有子类别，则该类别不能被删除
			int count=trainCourseTypeService.getCountByPId(lAryId[0]);
			if(count>0){
				return message=new ResultMessage(2, "该开班类别下有子类别，不能直接删除!");
			}
			//如果该开班类别下有开班信息，则该类别也不能被删除
			QueryFilter fiter=new QueryFilter(request);
			fiter.addFilter("isDel", "0");//未被删除的
			fiter.addFilter("courseType", lAryId[0]);
			List<TrainCourse> tcList=trainCourseService.getAll(fiter);
			if(tcList.size()>0){
				return message=new ResultMessage(2, "该开班类别下有开班信息，不能直接删除!");
			}
			
			Map<String, Object> paramMap=new HashMap<String, Object>();
			paramMap.put("isDel", "1");//表示删除
			paramMap.put("aae019",ContextUtil.getCurrentUser().getAac003());//经办人
			paramMap.put("aae011",ContextUtil.getCurrentUser().getAcd230()+"");//经办人代码
			paramMap.put("aae020",ContextUtil.getCurrentUserOrg().getAcd202());//经办机构
			paramMap.put("aae017",ContextUtil.getCurrentUserOrg().getAcd200()+"");//经办机构代码
			paramMap.put("aae036",new Date());//经办时间
			paramMap.put("courseTypeIdList", Arrays.asList(lAryId));
			
			trainCourseTypeService.updateBatchDel(paramMap);
			message=new ResultMessage(ResultMessage.Success, "删除开班类型表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	/**
	 * 	新增开班类型表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增开班类型表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		TrainCourseTypeForm  trainCourseTypeForm=new TrainCourseTypeForm();
		trainCourseTypeForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/train/trainCourseTypeEdit.jsp");
		
		//取出未被删除的全部开班类别
		QueryFilter fiter=new QueryFilter(request);
		fiter.addFilter("isDel", "0");//未被删除的
		List<TrainCourseType> tctList=trainCourseTypeService.getAll(fiter);
		
		return modelAndView.addObject("trainCourseTypeForm",trainCourseTypeForm).addObject("courseTypeList", tctList);					
	}
	/**
	 * 	编辑开班类型表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑开班类型表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		ModelAndView mv= new ModelAndView("/business/dissupport/train/trainCourseTypeEdit.jsp");
		Long typeId=RequestUtil.getLong(request,"typeId",0L);
		TrainCourseType trainCourseType=trainCourseTypeService.getById(typeId);
		TrainCourseTypeForm  trainCourseTypeForm=new TrainCourseTypeForm();
		trainCourseTypeForm.putModel(trainCourseType);
		//取出未被删除的全部开班类别
		QueryFilter fiter=new QueryFilter(request);
		fiter.addFilter("isDel", "0");//未被删除的
		List<TrainCourseType> tctList=trainCourseTypeService.getAll(fiter);
		
		return mv.addObject("trainCourseTypeForm",trainCourseTypeForm).addObject("courseTypeList", tctList)
				.addObject("isFlag", "edit").addObject("editCourseTypeName", trainCourseTypeForm.getName());					
	}

	/**
	 * 取得开班类型表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看开班类型表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long typeId=RequestUtil.getLong(request,"typeId");
		TrainCourseType trainCourseType = trainCourseTypeService.getById(typeId);	
		return getAutoView().addObject("trainCourseType", trainCourseType);
	}
	
	/**
	 * 验证开班类别名称是否重复
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("checkTypeName")
	@Action(description="验证开班类别名称是否重复")
	@ResponseBody
	public ResultMessage checkTypeName(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			
			String courseTypeName=URLDecoder.decode(RequestUtil.getString(request, "courseTypeName"),"UTF-8");
			TrainCourseType tct=trainCourseTypeService.getCourseTypeByName(courseTypeName);
			if(tct!=null){
				message=new ResultMessage(ResultMessage.Success, "保存失败,开班类别名称已存在!");
			}else{
				message=new ResultMessage(ResultMessage.Fail,"开班类别名称不重复");
			}
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Success, "验证开班类别名称是否重复失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
}
