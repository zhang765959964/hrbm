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
import com.xunfeng.business.dissupport.train.web.form.TrainOrgForm;
import com.xunfeng.business.train.interf.TrainCourseServiceInterf;
import com.xunfeng.business.train.interf.TrainOrgServiceInterf;
import com.xunfeng.business.train.interf.TrainOrgTypeServiceInterf;
import com.xunfeng.business.train.interf.TrainSignUpServiceInterf;
import com.xunfeng.business.train.interf.TrainSysSetServiceInterf;
import com.xunfeng.business.train.model.TrainOrg;
import com.xunfeng.business.train.model.TrainOrgType;
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
import com.xunfeng.sys.config.interf.BaseConfigServiceInterf;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.interf.SysOrgServiceInterf;

import edu.emory.mathcs.backport.java.util.Arrays;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训机构表 控制器类
* @author:Wang.CS
* @createDate 2016-05-23 09:30:42 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/dissupport/train/trainOrg/")
public class TrainOrgController extends BaseController
{
	@Resource
	@Qualifier("trainOrg")
	private TrainOrgServiceInterf trainOrgService;
	
	@Resource
	@Qualifier("trainOrgType")
	private TrainOrgTypeServiceInterf trainOrgTypeService;
	
	@Resource
	@Qualifier("trainSysSet")
	private TrainSysSetServiceInterf trainSysSetService;
	
	@Resource
	@Qualifier("trainSignUp")
	private TrainSignUpServiceInterf trainSignUpService;
	
	@Resource
	@Qualifier("trainCourse")
	private TrainCourseServiceInterf trainCourseService;
	
	@Resource
	@Qualifier("sysorg")
	protected SysOrgServiceInterf sysOrgService;
	
 	@Resource
   	@Qualifier("baseConfig")
    BaseConfigServiceInterf baseConfig;
	
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	/**
	 * 添加或更新培训机构表。
	 * @param request
	 * @param response
	 * @param trainOrgForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新培训机构")
	public void save(HttpServletRequest request, HttpServletResponse response,TrainOrgForm trainOrgForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long pxOrgId=RequestUtil.getLong(request,"pxOrgId");
		    TrainOrg trainOrg = trainOrgService.getById(pxOrgId);
			trainOrg=trainOrgForm.getModel(trainOrg);
			if(trainOrgForm.isMvcAdd()){
				String sysSetName=SystemConst.KEY_PX_ORG_IS_AUDIT;//系统表中设置的新增的培训机构是否需要审核
				QueryFilter fiter=new QueryFilter();
				fiter.addFilter("caos02", sysSetName);
				TrainSysSet tss= trainSysSetService.getAll(fiter).get(0);
				String flag=(tss==null)? "1" : tss.getCaos04(); //是否需要审核标识，"0":不需要，"1":需要
				resultMsg="添加培训机构";
				trainOrg.setPxOrgId(uniqueIdUtil.genSeqId(SqeIdName.TrainOrg.getSeqName()));
				String aae019=ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAac003();// 经办人
				String aae020=ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd202();// 经办机构
				String aae011=ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAcd230()+"";// 经办人代码
				String aae017=ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd200()+"";// 经办机构代码
				Date date=new Date();//时间
				trainOrg.setAae019(aae019);// 经办人
				trainOrg.setAae020(aae020);// 经办机构
				trainOrg.setAae011(aae011);// 经办人代码
				trainOrg.setAae017(aae017);// 经办机构代码
				if(SystemConst.STATIC_VALUE_ZERO.equals(flag)){
				trainOrg.setIsAudit(SystemConst.STATIC_VALUE_ONE);//审核通过
				trainOrg.setAbb767(aae011);// 审核人代码
				trainOrg.setAbb768(aae017);// 审核机构代码
				trainOrg.setAbb769(aae019);// 审核人
				trainOrg.setAbb770(aae020);// 审核机构
				trainOrg.setAbb771(date);// 审核时间
				}else{
					trainOrg.setIsAudit(SystemConst.STATIC_VALUE_ZERO);//默认为0:未审核
				}
				trainOrg.setIsDel(SystemConst.STATIC_VALUE_ZERO);//默认为0:未删除
				trainOrg.setIsDisable(SystemConst.STATIC_VALUE_ZERO);//默认为0:未禁用
				trainOrg.setCczy06(SystemConst.DATA_SOURCE_BS); //数据来源 18: BS大平台
				trainOrg.setAae036(date);// 经办时间
				trainOrgService.add(trainOrg);
			}else{
				resultMsg="更新培训机构";
			    trainOrgService.update(trainOrg);
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
	 * 取得培训机构表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=new ModelAndView("/business/dissupport/train/trainOrgList.jsp");
		QueryFilter typeFiter=new QueryFilter();
		typeFiter.addFilter("isDel", SystemConst.STATIC_VALUE_ZERO);//未被删除的培训机构类别
		//获取所有培训机构类型
		List<TrainOrgType> orgTypeList=trainOrgTypeService.getAll(typeFiter);
		mv.addObject("orgTypeList", orgTypeList);
		return mv;
	}
	/**
	 * 取得培训机构表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="取得培训机构表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
		fiter.addFilter("isDel", SystemConst.STATIC_VALUE_ZERO);//未被删除
		fiter.addFilter("aae017s", getSubCon());//关联当前登录用户所在的职介机构编号以及子编号
		ResultData<TrainOrg> resultData=trainOrgService.getTrainOrgData(fiter);
		List<TrainOrg> list=resultData.getDataList();
		//为培训机构设置类别名称
		setOrgTypeName(list);
		//截取相关字段长度
		setChangeList(list);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 删除培训机构表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除培训机构表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pxOrgId");
			//如果培训机构下有开班信息，则该培训机构不能直接删除
		    int count=trainCourseService.getCourseCountByOrgId(lAryId[0]);
			if(count>0){
				return new ResultMessage(2, "该培训机构下有开班信息，不能直接删除!");
			}
			Map<String,Object> paramMap=new HashMap<String, Object>();
			paramMap.put("isDel", SystemConst.STATIC_VALUE_ONE);//删除
			paramMap.put("orgIdList", Arrays.asList(lAryId));
			paramMap.put("aae019",ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAac003());//经办人
			paramMap.put("aae011",ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAcd230()+"");//经办人代码
			paramMap.put("aae020",ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd202());//经办机构
			paramMap.put("aae017",ContextUtil.getCurrentUserOrg()==null ? ""  : ContextUtil.getCurrentUserOrg().getAcd200()+"");//经办机构代码
			paramMap.put("aae036",new Date());//经办时间
			trainOrgService.updateDelStatus(paramMap);
			message=new ResultMessage(ResultMessage.Success, "删除培训机构成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 禁用培训机构表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("dis")
	@Action(description="禁用培训机构表")
	@ResponseBody
	public ResultMessage dis(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		String info="";//提示信息
		try{
			Map<String,Object> paramMap=new HashMap<String, Object>();
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pxOrgId");
			//培训机构禁用和解禁的标志 "1" :表示禁用，"2" :表示 解禁
			String flag=RequestUtil.getString(request, "flag");
			//先判断该培训机构是否禁用，如已禁用就不能重复操作
			TrainOrg to=trainOrgService.getById(lAryId[0]);
			
			if(flag.equals("1")){
				if(("1").equals(to.getIsDisable())){
					return new ResultMessage(2, "该培训机构已禁用,请勿重复操作!");
				}else{
					paramMap.put("isDisable", SystemConst.STATIC_VALUE_ONE);//禁用
					info="禁用培训机构!";
				}
			}else{
				if(("0").equals(to.getIsDisable())){
					return new ResultMessage(2, "该培训机构未被禁用,不需解禁!");
				}else{
					paramMap.put("isDisable", SystemConst.STATIC_VALUE_ZERO);//解禁
					info="解禁培训机构!";
				}
			}
			
			paramMap.put("orgIdList", Arrays.asList(lAryId));
			paramMap.put("aae019",ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAac003());//经办人
			paramMap.put("aae011",ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAcd230()+"");//经办人代码
			paramMap.put("aae020",ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd202());//经办机构
			paramMap.put("aae017",ContextUtil.getCurrentUserOrg()==null ? ""  : ContextUtil.getCurrentUserOrg().getAcd200()+"");//经办机构代码
			paramMap.put("aae036",new Date());//经办时间
			trainOrgService.updateDisableStatus(paramMap);
			message=new ResultMessage(ResultMessage.Success, info+"成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, info+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 审核培训机构
	 * @param request
	 * @param response
	 * @param trainOrgForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("audit")
	@Action(description="审核培训机构")
	public void audit(HttpServletRequest request, HttpServletResponse response,TrainOrgForm trainOrgForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
			
			String abb772=RequestUtil.getString(request, "abb772");//审核意见
			abb772= URLDecoder.decode(abb772,"UTF-8");
			String flag=RequestUtil.getString(request, "flag");//审核标识, "1": 通过,"2":未通过
			
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "pxOrgIds");
			Map<String,Object> paramMap=new HashMap<String, Object>();
			paramMap.put("isAudit", flag);
			paramMap.put("abb767", ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAcd230()+"");// 审核人代码
			paramMap.put("abb768", ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd200()+"");// 审核机构代码
			paramMap.put("abb769", ContextUtil.getCurrentUser()==null ? "" : ContextUtil.getCurrentUser().getAac003());// 审核人
			paramMap.put("abb770", ContextUtil.getCurrentUserOrg()==null ? "" : ContextUtil.getCurrentUserOrg().getAcd202());// 审核机构
			paramMap.put("abb772", abb772);//审核意见
			paramMap.put("abb771", new Date());//审核时间
			paramMap.put("orgIdList", Arrays.asList(lAryId));
			
			trainOrgService.updateAuditStatus(paramMap);
			if(flag.equals("1")){
				resultMsg="培训机构审核通过";
			}else{
				resultMsg="培训机构审核未通过";
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg);
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg);
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	/**
	 * 	新增培训机构表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增培训机构表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		TrainOrgForm  trainOrgForm=new TrainOrgForm();
		trainOrgForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/train/trainOrgAdd.jsp");
		
		QueryFilter typeFiter=new QueryFilter();
		typeFiter.addFilter("isDel", SystemConst.STATIC_VALUE_ZERO);//未被删除的培训机构类别
		//获取所有培训机构类型
		List<TrainOrgType> orgTypeList=trainOrgTypeService.getAll(typeFiter);
		
		return modelAndView.addObject("trainOrgForm",trainOrgForm).addObject("orgTypeList", orgTypeList);					
	}
	/**
	 * 	编辑培训机构表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑培训机构表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{   
		ModelAndView modelAndView= new ModelAndView("/business/dissupport/train/trainOrgEdit.jsp");
		Long pxOrgId=RequestUtil.getLong(request,"pxOrgId",0L);
		TrainOrg trainOrg=trainOrgService.getById(pxOrgId);
		TrainOrgForm  trainOrgForm=new TrainOrgForm();
		trainOrgForm.putModel(trainOrg);
		
		QueryFilter typeFiter=new QueryFilter();
		typeFiter.addFilter("isDel", SystemConst.STATIC_VALUE_ZERO);//未被删除的培训机构类别
		//获取所有培训机构类型
		List<TrainOrgType> orgTypeList=trainOrgTypeService.getAll(typeFiter);
		
		return modelAndView.addObject("trainOrgForm",trainOrgForm).addObject("orgTypeList", orgTypeList)
				.addObject("isFlag", "edit").addObject("editAccount",trainOrgForm.getOrgAccount())
				.addObject("editOrgName",trainOrgForm.getOrgName()).addObject("editOrgPublishName", trainOrgForm.getOrgPublishName());					
	}

	/**
	 * 取得培训机构表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看培训机构表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long pxOrgId=RequestUtil.getLong(request,"pxOrgId");
		TrainOrg trainOrg = trainOrgService.getById(pxOrgId);	
		return getAutoView().addObject("trainOrg", trainOrg);
	}
	
	/**
	 * 取得培训机构所有未审核过的分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("disAuditList")
	public ModelAndView disAuditList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=new ModelAndView("/business/dissupport/train/disAuditTrainOrgList.jsp");
		QueryFilter typeFiter=new QueryFilter();
		typeFiter.addFilter("isDel", SystemConst.STATIC_VALUE_ZERO);//未被删除的
		typeFiter.addFilter("isDisable", SystemConst.STATIC_VALUE_ZERO);//未被禁用的
		//获取所有培训机构类型
		List<TrainOrgType> orgTypeList=trainOrgTypeService.getAll(typeFiter);
		mv.addObject("orgTypeList", orgTypeList);
		return mv;
	}
	
	/**
	 * 取得培训机构所有未审核过的分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("disAuditListJson")
	@Action(description="取得培训机构所有未审核过的分页列表")
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
			fiter.addFilter("isAudit", SystemConst.STATIC_VALUE_ZERO);//默认查询未审核且未被删除的培训机构
		}
		fiter.addFilter("isDel", SystemConst.STATIC_VALUE_ZERO);// 未删除
		fiter.addFilter("aae017s", getSubCon());//关联当前登录用户所在的职介机构编号以及子编号
		fiter.addFilter("orderField","ORG_ESTABLISH_DATE");//按培训机构成立的先后时间排序
		fiter.addFilter("orderSeq", "asc");
		ResultData<TrainOrg> resultData=trainOrgService.getTrainOrgData(fiter);
		List<TrainOrg> list=resultData.getDataList();
		//为培训机构设置类别名称
		setOrgTypeName(list);
		//为培训机构设置数据来源
		setOrgDataSourse(list);
		
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
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
	 * 验证机构账号是否重复
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("check")
	@Action(description="验证机构账号是否重复")
	@ResponseBody
	public ResultMessage check(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			String orgAccount=RequestUtil.getString(request, "orgAccount");
			QueryFilter fiter=new QueryFilter();
			fiter.addFilter("orgAccount", orgAccount);
			List<TrainOrg> list=trainOrgService.getAll(fiter);
			if(list!=null && list.size()>0){
				message=new ResultMessage(ResultMessage.Success, "保存失败,机构账号已存在!");
			}else{
				message=new ResultMessage(ResultMessage.Fail,"账号不重复");
			}
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Success, "验证账号失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 验证机构名称是否重复
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("checkName")
	@Action(description="验证机构名称是否重复")
	@ResponseBody
	public ResultMessage checkName(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			String orgName=URLDecoder.decode(RequestUtil.getString(request, "orgName"),"UTF-8");
			TrainOrg to=trainOrgService.getOrgByName(orgName);
			if(to!=null){
				message=new ResultMessage(ResultMessage.Success, "保存失败,机构名称已存在!");
			}else{
				message=new ResultMessage(ResultMessage.Fail,"机构名称不重复");
			}
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Success, "验证机构名称重复失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 验证机构发布名称是否重复
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("checkPublishName")
	@Action(description="验证机构发布名称是否重复")
	@ResponseBody
	public ResultMessage checkPublishName(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			String orgPublishName=URLDecoder.decode(RequestUtil.getString(request, "orgPublishName"),"UTF-8");
			TrainOrg to=trainOrgService.getOrgByPubName(orgPublishName);
			if(to!=null){
				message=new ResultMessage(ResultMessage.Success, "保存失败,机构发布名称已存在!");
			}else{
				message=new ResultMessage(ResultMessage.Fail,"机构发布名称不重复");
			}
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Success, "验证机构发布名称重复失败");
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
		Long[] lAryId =RequestUtil.getLongAryByStr(request, "pxOrgId");
		List<TrainOrg> trainOrgList=new ArrayList<TrainOrg>();
		if(lAryId==null){
			//获取全部数据
			QueryFilter fiter=new QueryFilter();
			fiter.addFilter("isDel", SystemConst.STATIC_VALUE_ZERO);
			fiter.addFilter("aae017s", getSubCon());//关联当前登录用户所在的职介机构编号以及子编号
			trainOrgList=trainOrgService.getAll(fiter);
		}else{
			for(int i=0; i<lAryId.length;i++){
				TrainOrg trainOrg = trainOrgService.getById(lAryId[i]);
				trainOrgList.add(trainOrg);
			}
		}
		//设置机构类别名称
		setOrgTypeName(trainOrgList);
		
		String fileName="培训机构数据.xls";
		String[] heads={"机构名称","发布名称","名称简码","机构账号","机构密码","联系人","手机号","机构证件","注册日期","机构类别","法人身份证","机构邮箱","机构地址","经营范围","禁用状态","经办人","经办机构","经办日期"};
		HSSFWorkbook wb=createWb(heads, trainOrgList);
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
	public HSSFWorkbook createWb(String[] heads,List<TrainOrg> list){
		
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
			TrainOrg to=list.get(i);
			row = sheet.createRow(i+1);  
			row.createCell(0).setCellValue(to.getOrgName()); 
			row.createCell(1).setCellValue(to.getOrgPublishName()); 
			row.createCell(2).setCellValue(to.getAac022());  
			row.createCell(3).setCellValue(to.getOrgAccount());
			row.createCell(4).setCellValue(to.getOrgPwd());  
			row.createCell(5).setCellValue(to.getContactsName());  
			row.createCell(6).setCellValue(to.getContactsTel());
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        row.createCell(7).setCellValue(to.getOrgCertificate());  
	        row.createCell(8).setCellValue((to.getOrgEstablishDate()==null)? "" : sdf.format(to.getOrgEstablishDate()));  
	        row.createCell(9).setCellValue(to.getOrgType()); 
	        row.createCell(10).setCellValue(to.getOrgLegalPersonId()); 
	        row.createCell(11).setCellValue(to.getOrgEmail()); 
	        row.createCell(12).setCellValue(to.getOrgAddr()); 
	        row.createCell(13).setCellValue(to.getOrgManageRange());  
			row.createCell(14).setCellValue(to.getIsDisable().equals(SystemConst.STATIC_VALUE_ZERO)? "否" : "是");
			row.createCell(15).setCellValue(to.getAae019());  
			row.createCell(16).setCellValue(to.getAae020());
			row.createCell(17).setCellValue((to.getAae036()==null)? "" : sdf.format(to.getAae036())); 
		}
		return wb;
	}
	/**
	 *  为培训机构设置类别名称
	 */
   public void setOrgTypeName(List<TrainOrg> list){
		if(list.size()>0){
			QueryFilter typeFiter=new QueryFilter();
			typeFiter.addFilter("isDel", SystemConst.STATIC_VALUE_ZERO);//未被删除的培训机构类别
			//获取所有培训机构类型
			List<TrainOrgType> orgTypeList=trainOrgTypeService.getAll(typeFiter);
			//为培训机构设置类型名称
			for(TrainOrg to : list){
			   if(StringUtil.isNotEmpty(to.getOrgType())){
					for(TrainOrgType tot : orgTypeList){
						if(to.getOrgType().equals(tot.getTypeId()+"")){
							to.setOrgType(tot.getName());
							break;
						}
					}
				}
			}
		}
	}
   
   /**
    * 相关字段设置显示长度
    */
   public void setChangeList(List<TrainOrg> list){
	   if(list!=null && list.size()>0){
		   for(TrainOrg to : list){
			   //截取相关字段的长度
			    String addr =to.getOrgAddr()==null ? "" : to.getOrgAddr().length()>20 ? to.getOrgAddr().substring(0, 20)+"..." : to.getOrgAddr();
			    String range =to.getOrgManageRange()==null ? "" : to.getOrgManageRange().length()>20 ? to.getOrgManageRange().substring(0, 20)+"..." : to.getOrgManageRange();
				to.setOrgAddr(addr);
				to.setOrgManageRange(range);
		   }
	   }
   }
   
   /**
	 * 为机构设置数据来源
	 */
  public void setOrgDataSourse(List<TrainOrg> orgList){
	 //获取所有的数据来源
	 List<Map<String,Object>> dsList=trainSignUpService.getAllDataSourses();
		if(dsList!=null && dsList.size()>0){
			for(TrainOrg to : orgList){
				for(Map<String,Object> map : dsList){
					if(StringUtil.isEmpty(to.getCczy06())){
						break;
					}else{
						if(to.getCczy06().equals(map.get("CODE"))){
							to.setCczy06((String)map.get("NAME"));
							break;
						}
					}
				}
			}
		}
	}
}
