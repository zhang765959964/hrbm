package com.xunfeng.business.personagency.retired.web;


import java.util.HashMap;
import java.util.Iterator;
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

import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.retired.dto.RetiredAllDto;
import com.xunfeng.business.personagency.retired.dto.RetiredDeclareDto;
import com.xunfeng.business.personagency.retired.dto.RetiredDto;
import com.xunfeng.business.personagency.retired.interf.RetiredDeclareServiceInterf;
import com.xunfeng.business.personagency.retired.interf.YangLaoServiceInterf;
import com.xunfeng.business.personagency.retired.model.RetiredDeclare;
import com.xunfeng.business.personagency.retired.model.YangLao;
import com.xunfeng.business.personagency.retired.web.form.RetiredAllForm;
import com.xunfeng.business.personagency.retired.web.form.RetiredDeclareForm;
import com.xunfeng.business.personagency.retired.web.form.RetiredYangLaoForm;
import com.xunfeng.business.personagency.retired.web.form.YangLaoForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.ZJ_DateUtils;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.dictionary.interf.DictionaryServiceInterf;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员申报表 控制器类
* @author:zhangfan
* @createDate 2016-07-16 11:24:12 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/retired/declare/")
public class RetiredDeclareController extends BaseController
{
	@Resource
	@Qualifier("retiredDeclare")
	private RetiredDeclareServiceInterf retiredDeclareService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	@Resource
	@Qualifier("yangLao")
	private YangLaoServiceInterf yangLaoService;
	
	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	
	
	/**
	 * 添加或更新退休人员申报表
	 * @param request
	 * @param response
	 * @param retiredDeclareForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="退休人员申报表")
	public void save(HttpServletRequest request, HttpServletResponse response,RetiredDeclareForm retiredDeclareForm) throws Exception
	{	String resultMsg=null;	
		ResultMessage message=null;	
		try{
			
			RetiredDeclareDto retiredDeclareDto  = BeanToBean.copyProperties(retiredDeclareForm, new RetiredDeclareDto(), false);
			boolean flag = retiredDeclareService.saveOrUpdateRetired(retiredDeclareDto);
			if(flag==true){
				resultMsg = "退休人员申报";
				message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
				writeResultMessage(response.getWriter(),message);
				return;
			}else{
				resultMsg = "退休人员修改";
				message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
				writeResultMessage(response.getWriter(),message);
				return;
			}
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
		
	}
	
	
	@RequestMapping("updateRetiredAll")
	@Action(description="退休人员申报表")
	public void updateReiterdAll(HttpServletRequest request, HttpServletResponse response,RetiredAllForm retiredAllForm) throws Exception
	{	String resultMsg=null;	
		ResultMessage message=null;	
		initCreater(retiredAllForm);
		try {
			 Long id=RequestUtil.getLong(request,"id");
			 retiredAllForm.setId(id);
			 RetiredAllDto retiredAllDto = BeanToBean.copyProperties(retiredAllForm, new RetiredAllDto(), false);
			 retiredDeclareService.updateReitedAll(retiredAllDto);
			 message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			 writeResultMessage(response.getWriter(),message);
		} catch (Exception ex) {
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
		
	}
	

	
	/**
	 * 初始化进入退休申诉页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("search")
	public ModelAndView load(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		ModelAndView mv = new ModelAndView("/business/personagency/retired/searchRetired.jsp");
		return mv;
	}
	
	/**
	 * 条件查询页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchList")
	@Action(description="查询退休申报")
	public ModelAndView searchList(HttpServletRequest request,HttpServletResponse response) throws Exception{
 		Long personId = RequestUtil.getLong(request, "personId",0L);
 	
 		
 		DictionaryServiceInterf dictionaryService=(DictionaryServiceInterf)AppUtil.getBean("dictionary");
		List<Map<String ,Object>> dictionarys1 =dictionaryService.getTabList("RSDA_TAB_CRAFT", null);
		String gzValue = "";
		for (Iterator iterator = dictionarys1.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			gzValue += map.get("CODE").toString()+":"+map.get("NAME")+";";
		}
		gzValue = gzValue.substring(0, gzValue.length()-1);
 		RetiredDeclareForm  retiredDeclareForm=new RetiredDeclareForm();
 		YangLaoForm ylForm = new YangLaoForm();
 		initCreater(ylForm);
 		RetiredDeclare retired =null;
 		if(personId!=0L){
 			retired = retiredDeclareService.getPeopleId(personId);
 	 		if(retired!=null){
 	 			request.setAttribute("id", retired.getId());
 	 			RetiredDeclare declare = retiredDeclareService.getById(retired.getId());
 	 			request.setAttribute("gsCreateDate",ZJ_DateUtils.date2dateStr(declare.getGsCreateDate()) );
 	 			request.setAttribute("gsStopDate",ZJ_DateUtils.date2dateStr(declare.getGsStopDate()));
 	 			BeanToBean.copyProperties(declare,retiredDeclareForm, false);
 	 		}else{
 	 			initCreater(retiredDeclareForm);
 	 		}
 		}else{
 			initCreater(retiredDeclareForm);		//获得当前机构
 		}
		
		RetiredDto retireDto = new RetiredDto();
 		Map retiredMap = new HashMap<String,Object>();	//退休map
 		if(personId!=0){
 			retiredMap =  retiredDeclareService.getRetiredByPersonId(personId);
 			retireDto = (RetiredDto) BeanUtils.populateEntity(retiredMap, retireDto);
 	 		retiredDeclareForm.setRetiredDto(retireDto);
 		}
 		retiredDeclareForm.setYangLaoForm(ylForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/searchRetiredList.jsp");
		return modelAndView.addObject("retiredDeclareForm",retiredDeclareForm).addObject("personId", personId).addObject("gzValue", gzValue);					
	} 
	
	
	
	/**
	 * 根据退休申诉id获得养老待遇申请信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getRetiredByYlId")
	@Action(description="查询养老待遇申请信息")
	public ModelAndView getRetiredById(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		Long retiredId =RequestUtil.getLong(request,"id",0L);	//获得personId
		Map retiredMap = new HashMap<String, String>();
		YangLaoForm yangLaoForm = new YangLaoForm();
		
		RetiredYangLaoForm ylForm = new RetiredYangLaoForm();
		if(retiredId!=0){
			retiredMap = retiredDeclareService.getRetiredById(retiredId);	//获得personId
			ylForm = (RetiredYangLaoForm) BeanUtils.populateEntity(retiredMap, ylForm);
			YangLao yl = yangLaoService.getByPersonId(retiredId);
			if(yl!=null){
				yangLaoForm.setId(yl.getId());
				yangLaoForm = BeanToBean.copyProperties(yl, yangLaoForm, false);
				yangLaoForm.setRetiredId(retiredId);
				yangLaoForm.setPersonId(retiredId);
				yangLaoForm.setYlForm(ylForm);
			}else{
				yangLaoForm.setRetiredId(retiredId);
				yangLaoForm.setPersonId(retiredId);
				yangLaoForm.setYlForm(ylForm);
				initCreater(yangLaoForm);
			}
		}else{
			initCreater(yangLaoForm);
		}
		ModelAndView mv = new ModelAndView("/business/personagency/retired/searchYlList.jsp");
		return mv.addObject("yangLaoForm", yangLaoForm).addObject("retiredId",retiredId);
		
	}
	
	
	
	/**
	 * 根据退休申诉id获得养老待遇申请信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getRetiredYlPlList")
	@Action(description="查询养老待遇申请信息")
	public ModelAndView getRetiredYlPlList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		YangLaoForm yangLaoForm = new YangLaoForm();
		initCreater(yangLaoForm);
		ModelAndView mv = new ModelAndView("/business/personagency/retired/searchYlPlList.jsp");
		return mv.addObject("yangLaoForm1", yangLaoForm);
	}
	
	
	
	
	/**
	 * 取得退休人员申报表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/retired/retiredDeclareList.jsp");
		
		return mv;
	}

	
	
	/**
	 * 取得退休人员养老待遇页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("retiredListJson")
	@Action(description="养老待遇申诉json数据")
	@ResponseBody
	public Map<Object,Object> retiredListJson(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		QueryFilter fiter=new QueryFilter(request);
		ResultData<RetiredDeclare> resultData = retiredDeclareService.getRetiredList(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	
	/**
	 * 根据人员id删除
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("delByPersonId")
	@Action(description="删除退休人员申报表")
	@ResponseBody
	public ResultMessage delByPersonId(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long personId = RequestUtil.getLong(request, "personId");
			retiredDeclareService.delByPersonId(personId);
			message=new ResultMessage(ResultMessage.Success, "删除退休人员申报表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	
	
	/**
	 * 删除退休人员申报表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除退休人员申报表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			retiredDeclareService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除退休人员申报表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增退休人员申报表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增退休人员申报表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		RetiredDeclareForm  retiredDeclareForm=new RetiredDeclareForm();
		retiredDeclareForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/retiredDeclareEdit.jsp");
		
		return modelAndView.addObject("retiredDeclareForm",retiredDeclareForm);					
	}
	/**
	 * 	编辑退休人员申报表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑退休人员申报表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		String archiveCode= "";
		Long id=RequestUtil.getLong(request,"id",0L);
		RetiredDeclare retiredDeclare=retiredDeclareService.getById(id);
		RetiredDto retireDto = new RetiredDto();
 		Map retiredMap = new HashMap<String,Object>();	//退休map
 		RetiredDeclareForm  retiredDeclareForm=new RetiredDeclareForm();
		retiredMap =  retiredDeclareService.getRetiredByPersonId(retiredDeclare.getPeopleId());
		retireDto = (RetiredDto) BeanUtils.populateEntity(retiredMap, retireDto);
 	 	retiredDeclareForm.setRetiredDto(retireDto);
 	 	Archives archives = archivesService.getArchivesByPId(retiredDeclare.getPeopleId());
 	 	archiveCode =  archives.getArchiveCode(); 
 	 		
		retiredDeclareForm.putModel(retiredDeclare);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/retired/retiredBhEdit.jsp");
		return modelAndView.addObject("retiredDeclareForm",retiredDeclareForm).addObject("archiveCode", archiveCode);					
	}

	/**
	 * 取得退休人员申报表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看退休人员申报表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		RetiredDeclare retiredDeclare = retiredDeclareService.getById(id);	
		return getAutoView().addObject("retiredDeclare", retiredDeclare);
	}
	
	/**
	 * 退休人员确定退休
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("review")
	@Action(description="确定退休 ")
	public void review(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String resultMsg="确定退休";	
		ResultMessage message=null;	
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			String retiredStatus=RequestUtil.getString(request,"retiredStatus");
			String retiredDeclareStatus = RequestUtil.getString(request,"retiredDeclareStatus");
			for (Long id : lAryId) {
				RetiredDeclare retiredDeclare = retiredDeclareService.getById(id);
					if(retiredStatus.equals("1")){
						resultMsg ="确定退休";
						retiredDeclareService.review(lAryId, retiredStatus,retiredDeclareStatus);
						message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
						writeResultMessage(response.getWriter(),message);
						return;
					}else{
						if(!retiredDeclare.getRetiredDeclareStatus().equals("3")){
							message=new ResultMessage(ResultMessage.Success,"非申报完毕中不能进行取消退休操作");
							writeResultMessage(response.getWriter(),message);
							return;
						}else{
							resultMsg = "取消退休";
							retiredDeclareService.review(lAryId, retiredStatus,retiredDeclareStatus);
							message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
							writeResultMessage(response.getWriter(),message);
							return;
					}	
				}
			}
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
		
	}
	
	
	
	

	/**
	 * 退休编号页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("retiredBhList")
	public ModelAndView retiredBhList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/retired/retiredBhList.jsp");
		return mv;
	}
	
	
	/**
	 * 退休编号JOSN数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("retiredBhListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> retiredBhListJson(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		QueryFilter fiter=new QueryFilter(request);
		ResultData resultData = retiredDeclareService.getRetiredBhList(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
	
	
	/**
	 * 退休编号手动修改
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateRetiredBh")
	@ResponseBody
	public ResultMessage updateRetiredBh(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	

		ResultMessage message=null;
		try{
			Long id =RequestUtil.getLong(request, "id",0);
			String xh = RequestUtil.getString(request, "xh");
			String retiredPeopleBm = RequestUtil.getString(request, "retiredPeopleBm");
			xh = retiredPeopleBm.substring(4, 8);
			String declareNote = RequestUtil.getString(request, "declareNote");
			retiredDeclareService.updateRetiredBh(id, xh, retiredPeopleBm, declareNote);
			message=new ResultMessage(ResultMessage.Success, "退休编码修改成功");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "退休编码修改失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
		
	}
	
	/**
	 * 查询退休个人编码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getByRetiredBm")
	@Action(description = "查询退休编号")
	@ResponseBody
	public Map getByRetiredBm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map map =new HashMap();
		try{
			//查询退休个人编码
			String  retiredBm =  RequestUtil.getString(request, "retiredPeopleBm");
			Long num = retiredDeclareService.getByRetiredBm(retiredBm);
			Long id = RequestUtil.getLong(request, "id", 0L);
			RetiredDeclare retiredDeclare = retiredDeclareService.getById(id);
			if(id!=0L){
				if(retiredBm.equals(retiredDeclare.getRetiredPeopleBm())){
					if(num>0){
						map.put("valid",true);
					}else{
						map.put("valid",false);
					}
				}else{
					if(num>0){
						map.put("valid",false);
					}else{
						map.put("valid",true);
					}
				}
			}else{
				if(num>0){
					map.put("valid",false);
				}else{
					map.put("valid",true);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("valid",false);
		}
		return map;
	}

	/**
	 * 查询退休个人编码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("isExitBm")
	@Action(description = "查询退休编号")
	@ResponseBody
	public Map getByExitBm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map map =new HashMap<String,String>();
		try {
			QueryFilter fiter=new QueryFilter(request);
			List<RetiredDeclare> retiredList =  retiredDeclareService.getByExitBm(fiter);
			if (retiredList != null&&retiredList.size() >0) {
				map.put("valid",false);
			} else {
				map.put("valid",true);
			}
		} catch (Exception e) {
			map.put("valid",false);
		}
		
		return map;
		
	}
	
	
}
