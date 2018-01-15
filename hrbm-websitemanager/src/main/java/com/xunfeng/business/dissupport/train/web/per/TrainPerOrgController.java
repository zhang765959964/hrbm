package com.xunfeng.business.dissupport.train.web.per;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训机构表 控制器类
* @author:Wang.CS
* @createDate 2016-05-23 09:30:42 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/dissupport/train/trainOrg/per")
public class TrainPerOrgController extends BaseController
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
				/*trainOrg.setAae019(ContextUtil.getCurrentUser().getAac003());// 经办人
				trainOrg.setAae020(ContextUtil.getCurrentUserOrg().getAcd202());// 经办机构
				trainOrg.setAae011(ContextUtil.getCurrentUser().getAcd230()+"");// 经办人代码
				trainOrg.setAae017(ContextUtil.getCurrentUserOrg().getAcd200()+"");// 经办机构代码			
*/				if(SystemConst.STATIC_VALUE_ZERO.equals(flag)){
					trainOrg.setIsAudit(SystemConst.STATIC_VALUE_ONE);//审核通过
				}else{
					trainOrg.setIsAudit(SystemConst.STATIC_VALUE_ZERO);//默认为0:未审核
				}
				trainOrg.setIsDel(SystemConst.STATIC_VALUE_ZERO);//默认为0:未删除
				trainOrg.setIsDisable(SystemConst.STATIC_VALUE_ZERO);//默认为0:未禁用
				trainOrg.setCczy06(SystemConst.DATA_SOURCE_BS); //数据来源 18: BS大平台
				trainOrg.setAae036(new Date());// 经办时间
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
		ModelAndView mv=new ModelAndView("/business/dissupport/train/per/trainOrgPerList.jsp");
		String orgId= RequestUtil.getString(request, "orgId");
		mv.addObject("orgId", orgId);
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
		String orgId= RequestUtil.getString(request, "orgId");
		QueryFilter fiter=new QueryFilter(request);
		int limit =RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
		fiter.addFilter("isDel", SystemConst.STATIC_VALUE_ZERO);//未被删除
		fiter.addFilter("pxOrgId", orgId);
		ResultData<TrainOrg> resultData=trainOrgService.getTrainOrgData(fiter);
		List<TrainOrg> list=resultData.getDataList();
		//为培训机构设置类别名称
		setOrgTypeName(list);
		//截取相关字段长度
		setChangeList(list);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
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
		ModelAndView mv=new ModelAndView("/business/dissupport/train/per/trainOrgPerEdit.jsp");
		String orgId= RequestUtil.getString(request, "orgId");
		mv.addObject("orgId", orgId);
		/*Long pxOrgId=RequestUtil.getLong(request,"pxOrgId",0L);*/
		TrainOrg trainOrg=trainOrgService.getById(Long.valueOf(orgId));
		TrainOrgForm  trainOrgForm=new TrainOrgForm();
		trainOrgForm.putModel(trainOrg);
		
		QueryFilter typeFiter=new QueryFilter();
		typeFiter.addFilter("isDel", SystemConst.STATIC_VALUE_ZERO);//未被删除的培训机构类别
		//获取所有培训机构类型
		List<TrainOrgType> orgTypeList=trainOrgTypeService.getAll(typeFiter);
		return mv.addObject("trainOrgForm",trainOrgForm).addObject("orgTypeList", orgTypeList)
				.addObject("isFlag", "edit").addObject("editAccount",trainOrgForm.getOrgAccount()).addObject("editOrgName",trainOrgForm.getOrgName());					
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
	 * 验证培训机构账号是否通过
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("checkAccount")
	@Action(description="验证账号是否通过")
	@ResponseBody
	public ResultMessage checkName(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=new ResultMessage(ResultMessage.Success, "验证账号成功!");
		try{
			String orgAccount=RequestUtil.getString(request, "orgAccount");
			String orgPwd=RequestUtil.getString(request, "orgPwd");
			TrainOrg to=trainOrgService.getOrgByAccount(orgAccount);
			if(to==null){
				message=new ResultMessage(ResultMessage.Fail, "登录账号不存在!");
			}else{
				if("1".equals(to.getIsDisable())){
					message=new ResultMessage(ResultMessage.Fail,"登录账号已被禁用!");
				}
				if(!("1".equals(to.getIsAudit()))){
					message=new ResultMessage(ResultMessage.Fail,"登录账号审核未通过!");
				}
				if(!orgPwd.equals(to.getOrgPwd())){
					message=new ResultMessage(ResultMessage.Fail,"登录账号和密码不一致!");
				}
			}
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "网络异常，请稍后重试!");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
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
