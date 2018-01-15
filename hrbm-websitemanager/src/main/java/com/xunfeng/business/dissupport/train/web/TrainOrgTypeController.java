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

import com.xunfeng.business.dissupport.train.web.form.TrainOrgTypeForm;
import com.xunfeng.business.train.interf.TrainOrgServiceInterf;
import com.xunfeng.business.train.interf.TrainOrgTypeServiceInterf;
import com.xunfeng.business.train.model.TrainOrg;
import com.xunfeng.business.train.model.TrainOrgType;
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
* @Description: 培训机构类型表 控制器类
* @author:Wang.CS
* @createDate 2016-05-23 09:31:02 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/dissupport/train/trainOrgType/")
public class TrainOrgTypeController extends BaseController
{
	@Resource
	@Qualifier("trainOrgType")
	private TrainOrgTypeServiceInterf trainOrgTypeService;
	
	@Resource
	@Qualifier("trainOrg")
	private TrainOrgServiceInterf trainOrgService;
	
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新培训机构类型表。
	 * @param request
	 * @param response
	 * @param trainOrgTypeForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新培训机构类型表")
	public void save(HttpServletRequest request, HttpServletResponse response,TrainOrgTypeForm trainOrgTypeForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long typeId=RequestUtil.getLong(request,"typeId");
		    TrainOrgType trainOrgType = trainOrgTypeService.getById(typeId);
			trainOrgType=trainOrgTypeForm.getModel(trainOrgType);
			
			if(trainOrgType.getPid()==null){
				trainOrgType.setPid(0l);
			}
			if(trainOrgTypeForm.isMvcAdd()){
				resultMsg="添加培训机构类型";
				trainOrgType.setTypeId(uniqueIdUtil.genSeqId(SqeIdName.TrainOrgType.getSeqName()));
				trainOrgType.setAae019(ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAac003());// 经办人
				trainOrgType.setAae020(ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd202());// 经办机构
				trainOrgType.setAae011(ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAcd230()+"");// 经办人代码
				trainOrgType.setAae017(ContextUtil.getCurrentUserOrg()==null ? ""  : ContextUtil.getCurrentUserOrg().getAcd200()+"");// 经办机构代码
				trainOrgType.setIsDel("0");//默认未被删除
				trainOrgType.setCczy06(SystemConst.DATA_SOURCE_BS);//数据来源,18:BS大平台
				trainOrgType.setAae036(new Date());// 经办时间
				trainOrgTypeService.add(trainOrgType);
				
			}else{
				resultMsg="更新培训机构类型";
				if(trainOrgType.getPid()==trainOrgType.getTypeId()){
					trainOrgType.setPid(0L);
				}
			    trainOrgTypeService.update(trainOrgType);
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
	 * 取得培训机构类型表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/dissupport/train/trainOrgTypeList.jsp");
		
		return mv;
	}
	/**
	 * 取得培训机构类型表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="取得培训机构类型表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
	    
		fiter.addFilter("isDel", "0");//未被删除的
		ResultData<TrainOrgType> resultData=trainOrgTypeService.getTrainOrgTypeData(fiter);
		List<TrainOrgType> list=resultData.getDataList();	
		if(list!=null && list.size()>0){
			//为机构类型设置上级类型名称
			for(TrainOrgType tot : list){
				if(tot.getPid()!=0){
					TrainOrgType ptot=trainOrgTypeService.getById(tot.getPid());
					tot.setpName(ptot.getName());
				   }else{
					   tot.setpName(tot.getName());
				   }
				}
		}
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 删除培训机构类型表(设置删除标志位)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除培训机构类型表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "typeId");
			//如果该机构类别下有子类别，则该类别不能被删除
			int count=trainOrgTypeService.getCountByPId(lAryId[0]);
			if(count>0){
				return message=new ResultMessage(2, "该机构类别下有子类别，不能直接删除!");
			}
			//如果该类别下有机构也不能删除
			QueryFilter fiter=new QueryFilter(request);
			fiter.addFilter("isDel", "0");//未被删除的
			fiter.addFilter("orgType", lAryId[0]);
			List<TrainOrg> toList=trainOrgService.getAll(fiter);
			if(toList.size()>0){
				return message=new ResultMessage(2, "该机构类别下有培训机构，不能直接删除!");
			}
			Map<String, Object> paramMap=new HashMap<String, Object>();
			paramMap.put("isDel", "1");//表示删除
			paramMap.put("aae019",ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAac003());//经办人
			paramMap.put("aae011",ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAcd230()+"");//经办人代码
			paramMap.put("aae020",ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd202());//经办机构
			paramMap.put("aae017",ContextUtil.getCurrentUserOrg()==null ? ""  : ContextUtil.getCurrentUserOrg().getAcd200()+"");//经办机构代码
			paramMap.put("aae036",new Date());//经办时间
			paramMap.put("orgTypeIdList", Arrays.asList(lAryId));
			
			trainOrgTypeService.updateBatchDel(paramMap);
			message=new ResultMessage(ResultMessage.Success, "删除培训机构类型表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增培训机构类型表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增培训机构类型表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		TrainOrgTypeForm  trainOrgTypeForm=new TrainOrgTypeForm();
		
		trainOrgTypeForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/train/trainOrgTypeEdit.jsp");
		
		QueryFilter typeFiter=new QueryFilter();
		typeFiter.addFilter("isDel", "0");//未被删除的培训机构类别
		//获取所有培训机构类型
		List<TrainOrgType> orgTypeList=trainOrgTypeService.getAll(typeFiter);
		
		return modelAndView.addObject("trainOrgTypeForm",trainOrgTypeForm).addObject("orgTypeList",orgTypeList);					
	}
	/**
	 * 	编辑培训机构类型表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑培训机构类型表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		ModelAndView mv= new ModelAndView("/business/dissupport/train/trainOrgTypeEdit.jsp");
		Long typeId=RequestUtil.getLong(request,"typeId",0L);
		TrainOrgType trainOrgType=trainOrgTypeService.getById(typeId);
		TrainOrgTypeForm  trainOrgTypeForm=new TrainOrgTypeForm();
		trainOrgTypeForm.putModel(trainOrgType);
		
		QueryFilter typeFiter=new QueryFilter();
		typeFiter.addFilter("isDel", "0");//未被删除的培训机构类别
		//获取所有培训机构类型
		List<TrainOrgType> orgTypeList=trainOrgTypeService.getAll(typeFiter);
		
		return mv.addObject("trainOrgTypeForm",trainOrgTypeForm).addObject("orgTypeList", orgTypeList)
				.addObject("isFlag", "edit").addObject("editOrgTypeName", trainOrgTypeForm.getName());					
	}

	/**
	 * 取得培训机构类型表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看培训机构类型表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long typeId=RequestUtil.getLong(request,"typeId");
		TrainOrgType trainOrgType = trainOrgTypeService.getById(typeId);	
		return getAutoView().addObject("trainOrgType", trainOrgType);
	}
	
	/**
	 * 验证机构类别名称是否重复
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("checkTypeName")
	@Action(description="验证机构类别名称是否重复")
	@ResponseBody
	public ResultMessage checkTypeName(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			String orgTypeName=URLDecoder.decode(RequestUtil.getString(request, "orgTypeName"),"UTF-8");
			TrainOrgType tot=trainOrgTypeService.getOrgTypeByName(orgTypeName);
			if(tot!=null){
				message=new ResultMessage(ResultMessage.Success, "保存失败,机构类别名称已存在!");
			}else{
				message=new ResultMessage(ResultMessage.Fail,"机构类别名称不重复");
			}
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Success, "验证机构类别名称是否重复失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
}
