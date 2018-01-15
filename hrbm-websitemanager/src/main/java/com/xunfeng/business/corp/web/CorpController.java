package com.xunfeng.business.corp.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.cation.interf.AuthenticationServiceInterf;
import com.xunfeng.business.cation.model.Authentication;
import com.xunfeng.business.cms.util.ServiceUtil;
import com.xunfeng.business.corp.interf.CorpServiceInter;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.corp.web.form.CorpForm;
import com.xunfeng.business.corp.web.form.MemberForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.FileUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.dictionary.interf.DictionaryServiceInterf;
import com.xunfeng.sys.dictionary.model.Dictionary;
import com.xunfeng.sys.accounts.interf.AccountsServiceInter;
import com.xunfeng.sys.attachment.interf.AttachmentServiceInterf;
import com.xunfeng.sys.attachment.model.Attachment;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位基本信息表 控制器类
* @author:wanghan
* @createDate 2015-11-03 14:28:56 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/corp/corp/")
public class CorpController extends BaseController
{
	private static final String Corp = null;
	@Resource
	@Qualifier("corp")
	private CorpServiceInter corpService;
	@Resource
	@Qualifier("dictionary")
	private DictionaryServiceInterf dictionaryService;
	@Resource
	@Qualifier("accounts")
	private AccountsServiceInter accountsService;
	@Resource
	@Qualifier("attachment")
	private AttachmentServiceInterf attachmentService;
	@Resource
	@Qualifier("authentication")
	private AuthenticationServiceInterf authenticationService;
 
//	/**
//	 * 添加或更新单位基本信息表。
//	 * @param request
//	 * @param response
//	 * @param corp 添加或更新的实体
//	 * @param bindResult
//	 * @param viewName
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("save")
//	@Action(description="添加或更新单位基本信息表")
//	public void save(HttpServletRequest request, HttpServletResponse response,CorpForm corpForm) throws Exception
//	{
//		String resultMsg=null;	
//		ResultMessage message=null;	
//		
//		try{
//		    Long aab001=RequestUtil.getLong(request,"aab001");
//		    String nodeLogs=RequestUtil.getString(request,"nodeLogs");
//		    Corp corp = corpService.getById(aab001);
//			corp=corpForm.getModel(corp);
//			if(corpForm.isMvcAdd()){
//				resultMsg="添加单位基本信息表";
//				Long ccmu01 = uniqueIdUtil.genSeqId(SqeIdName.Accounts.getSeqName());
//				corp.setAab001(uniqueIdUtil.genSeqId(SqeIdName.Corp.getSeqName()));
//				corp.setCabq05(0L);
//				corp.setCabq08(0L);//窗口验证是否通过(0-未通过1-手工认证2-设备认证3-公办认证)
//				corp.setAab01d("0");
//				corp.setCcmu01(ccmu01);
//				corp.setCabq13("F");
//				corp.setCabq14("0");
//				corp.setCabq16(new Date());
//				corp.setCcpr08("0");
//				corp.setCcpr09("0");
//				corp.setCcpr14("0");
//				corp.setCcpr15("1");
//				corp.setCcpr16("0");
//				corp.setCcpr18("0");
//				corp.setCcpr19("0");
//				corp.setCcpr20("0");
//				corp.setCcpr21("0");
//				corp.setCcpr22("0");
//				corp.setCcpr23("0");
//				corp.setCcpr24("0");
//				corp.setAae119("1");
//				corp.setCabq14("0");
//				corp.setCabq17(0L);
//				String ccmu02 = getRandomId();
//				Accounts accountsByNameAndType =  accountsService.getAccountsByNameAndType(ccmu02,"2");
//				//判断随机生成的账号是否在数据库中存在 如果存在重新生成，暂时判断一次 因为重复概率比较小
//				if(accountsByNameAndType!=null){
//					ccmu02 = getRandomId();
//				}
//				Accounts accounts =new Accounts();
//				accounts.setCcmu01(ccmu01);
//				accounts.setCcmu02(ccmu02);//用户名
//				accounts.setCcmu03(corp.getAae139());//	密码
//				accounts.setCcmu06(getIpAddr(request));//注册IP
//				accounts.setCcmu09(corp.getAae139());//手机
//				accounts.setCcmu10(1l);//账号状态(1-有效账号2-无效账号3-已审验未完善4-禁止登陆5-仅职介中心市场可用) 个人:仅1,2 单位:1,2,4,5
//			    /*BaseConfig config = BaseConfigRepository.getComVerifyProcess();
//				if(config.getCaos04().equals("2")){//自动审核
//					accounts.setCcmu10(1l);//账号状态(1-有效账号2-无效账号3-已审验未完善4-禁止登陆5-仅职介中心市场可用) 个人:仅1,2 单位:1,2,4,5
//				}else{
//					accounts.setCcmu10(2l);//账号状态(1-有效账号2-无效账号3-已审验未完善4-禁止登陆5-仅职介中心市场可用) 个人:仅1,2 单位:1,2,4,5
//				}  */
//				accounts.setCcmu12(0l);//邮箱激活状态(0-未激活1-已激活)
//				accounts.setCcmu13(0l);//手机激活状态(0-未激活1-已激活)
//				accounts.setCcmu16(new Date());//注册日期
//				accounts.setCcmu17(2l);//账号类型(1-个人用户2-企业用户3-民营职介机构4-公办职介机构5-财政局查询)
//				accounts.setCcmu19(0l);//用户人才币余额
//				accounts.setCcmu20(0l);//企业今天已经的下载简历数
//				accounts.setCcmu21(0l);//用户名修改次数,大于1则不能再次修改用户名
//				accounts.setCcmu22(corpForm.getCczy06());//数据来源0未知1网站2窗口3-民营机构
//				accounts.setCcpr08("0");//是否删除状态（0-否1-是）
//				//图片保存
//				Attachment attachment=new Attachment();
//				attachment.setCaoa01(uniqueIdUtil.genSeqId(SqeIdName.Attachment.getSeqName()));
//				attachment.setAab001(corp.getAab001());
//				attachment.setCaoa02(corpForm.getCaoa02());
//				attachment.setCaoa04(4L);
//				attachment.setCaoa05(new Date());
//				attachment.setCaoa07(1L);
//				attachment.setCaoa08("0");
//				attachment.setCcpr08("0");
//				attachment.setCaoa09(1L);
//				attachment.setCczy06("18");
//				attachment.setCaoa10(corpForm.getCaoa10());
//				attachment.setCcmu01(accounts.getCcmu01());
//				corpService.addRegister(corp,accounts,attachment);
//			}else{
//				resultMsg="更新单位基本信息表";
//				Attachment attachment=null;
//				Accounts accounts=null;
//				if(corp.getCcmu01()!=null){
//					attachment=attachmentService.getBusLicense(corp.getCcmu01());
//					accounts = accountsService.getById(corp.getCcmu01());
//				}
//				
//				if(attachment==null){
//					 attachment=new Attachment();
//					attachment.setCaoa01(uniqueIdUtil.genSeqId(SqeIdName.Attachment.getSeqName()));
//					attachment.setAab001(corp.getAab001());
//					attachment.setCaoa02(corpForm.getCaoa02());
//					attachment.setCaoa04(4L);
//					attachment.setCaoa05(new Date());
//					attachment.setCaoa07(1L);
//					attachment.setCaoa08("0");
//					attachment.setCaoa09(1L);
//					attachment.setCczy06("18");
//					attachment.setCcpr08("0");
//					attachment.setCaoa10(corpForm.getCaoa10());
////					attachment.setCcmu01(accounts.getCcmu01());
//					corpService.updateRegister(corp,accounts,nodeLogs,attachment);
//				}else{
//					attachment.setCaoa02(corpForm.getCaoa02());
//					attachment.setCaoa10(corpForm.getCaoa10());
//					corpService.updateRegister(corp,accounts,nodeLogs,attachment);
//				}
//				
//			}
//			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功"+corp.getAab001());
//
//			writeResultMessage(response.getWriter(),message);
//		}catch(Exception ex){
//			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//			writeResultMessage(response.getWriter(),message);
//		}
//	}
	
	/**
	 * 添加或更新单位基本信息表。
	 * @param request
	 * @param response
	 * @param corp 添加或更新的实体
	 * @param bindResult
	 * @param viewName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新单位基本信息表")
	public void save(HttpServletRequest request, HttpServletResponse response,CorpForm corpForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long aab001=RequestUtil.getLong(request,"aab001");
		    Corp corp = corpService.getById(aab001);
			corp=corpForm.getModel(corp);
			if(corpForm.isMvcAdd()){
				resultMsg="添加单位基本信息表";
				corpService.add(corp,getIpAddr(request));
			}else{
				resultMsg="更新单位基本信息表";
				corpService.update(corp);
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
	 * 取得单位基本信息表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		Long cczy=RequestUtil.getLong(request,"cczy06");
		ModelAndView mv=this.getAutoView();
		
		return mv.addObject("cczy",cczy);
	}
	/**
	 * 取得单位基本信息表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="取得单位基本信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
//		int limit =RequestUtil.getInt(request, "limit");
//	    int offset = RequestUtil.getInt(request, "offset");
//	    PageBean pageBean =WrapPageBean(limit, offset);
//	    fiter.setPageBean(pageBean);
		ResultData<Corp> resultData=corpService.getAllCorp(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	/**
	 * 通过单位名称或者工商登记营业执照号查询
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listSelect")
	@Action(description="取得单位基本信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listSelect(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		String nameNumber = URLDecoder.decode(RequestUtil.getStringAry(request, "nameNumber") , "utf-8"); 
		QueryFilter fiter=new QueryFilter(request);
		if(nameNumber.isEmpty()){
			fiter.addFilter("nameNumber", "没有数据！");
		}else{
			fiter.addFilter("nameNumber", nameNumber);
		}
		List<Corp> list=corpService.getAll(fiter);		
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}
	/**
	 * 删除单位基本信息表(假删除，更改企业状态)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除单位基本信息表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "aab001");
			for(int i = 0; i < lAryId.length; i++){
				Long aab = Long.parseLong(lAryId[i].toString());
				Corp corp = corpService.getById(aab);
				corp.setCcpr08("1"); 
				corpService.update(corp);			
			}
			message=new ResultMessage(ResultMessage.Success, "删除单位基本信息表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增单位基本信息表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增单位基本信息表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		CorpForm  corpForm=new CorpForm();
		String cczy06=RequestUtil.getString(request,"cczy06");
		List<Dictionary>  listForm=new ArrayList<Dictionary>();
		corpForm.putModel(null);
		//corpForm.setAab001(uniqueIdUtil.genSeqId(SqeIdName.Corp.getSeqName()));
		corpForm.setAab001(uniqueIdUtil.genId(Corp.class.getName()));
		corpForm.setAae011(String.valueOf(ContextUtil.getCurrentUser().getAcd230()));
		corpForm.setAae019(ContextUtil.getCurrentUser().getAac003());
		corpForm.setAae020(ContextUtil.getCurrentUserOrg()==null?"":ContextUtil.getCurrentUserOrg().getAcd202());
		corpForm.setAae017(ContextUtil.getCurrentUserOrg()==null?"":String.valueOf(ContextUtil.getCurrentUserOrg().getAcd200()));
		corpForm.setCczy06(cczy06);
		corpForm.setAae036(new Date());
		List<Dictionary> list=dictionaryService.getIndustry();//查询出所有行业信息（TAB_INDUSTRY）
		for(Dictionary cp:list){
			Dictionary  dictionary=new Dictionary();
			dictionary.setCode(cp.getCode());
			dictionary.setName(cp.getName());
			listForm.add(dictionary);
		}
		ModelAndView modelAndView= new ModelAndView("/business/corp/corpEdit.jsp");
		
		return modelAndView.addObject("corpForm",corpForm).addObject("industry",listForm).addObject("cczy06n",cczy06);					
	}
	/**
	 * 	编辑单位基本信息表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑单位基本信息表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		
		Map corpMap=new HashMap();
		Long aab001=RequestUtil.getLong(request,"aab001",0L);
		String cczy06=RequestUtil.getString(request,"cczy06");
		Corp corp=corpService.getById(aab001);
		List<Dictionary>  listForm=new ArrayList<Dictionary>();
		List<Authentication> authentication=authenticationService.getByAab001(aab001);
		CorpForm  corpForm=new CorpForm();
		CorpForm  corpf=new CorpForm();
		MemberForm form=new MemberForm();
		corpMap=corpService.getByCorpView(aab001);//视图查询信息
		form=(MemberForm)BeanUtils.populateEntity(corpMap, form);
		for(Authentication authenti:authentication){
			long caoa04=authenti.getCaoa04();
			if(caoa04==4||caoa04==5){
//				corpf.setCaoa02(authenti.getCaoa02());
//				corpf.setCaoa10(authenti.getCaoa10());
//				corpf.setCaoa08(authenti.getCaoa08());
			}
		}
		List<Dictionary> list=dictionaryService.getIndustry();//查询出所有行业信息（TAB_INDUSTRY）
		for(Dictionary cp:list){
			Dictionary  dictionary=new Dictionary();
			dictionary.setCode(cp.getCode());
			dictionary.setName(cp.getName());
			listForm.add(dictionary);
		}
		if("F".equals(corp.getCabq13())){
			corp.setCabq13("否");
		}else{
			corp.setCabq13("是");
		}
		corpForm.putModel(corp);
		return getAutoView().addObject("corpForm",corpForm).addObject("corpf",corpf).addObject("cczy06n",cczy06)
				.addObject("industry",listForm).addObject("form",form);					
	}
	/**
	 * 	查看单位信息详情
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("corpDetails")
	@Action(description="查看单位信息详情")
	public ModelAndView corpDetails(HttpServletRequest request) throws Exception
	{
		Long aab001=RequestUtil.getLong(request,"aab001",0L);
		String cczy=RequestUtil.getString(request,"cczy");
		Corp corp=corpService.getCorpDetails(aab001);
		List<Authentication> authentication=authenticationService.getByAab001(aab001);
		CorpForm  corpf=new CorpForm();
		for(Authentication authenti:authentication){
			long caoa04=authenti.getCaoa04();
			if(caoa04==4||caoa04==5){
//				corpf.setCaoa02(authenti.getCaoa02());
//				corpf.setCaoa10(authenti.getCaoa10());
//				corpf.setCaoa08(authenti.getCaoa08());
			}
		}
		ModelAndView modelAndView= new ModelAndView("/business/corp/corpDetails.jsp");
		
		return modelAndView.addObject("corpForm",corp).addObject("cczy",cczy).addObject("corpf",corpf);					
	}
	 @RequestMapping("fileUpload")
	 @ResponseBody
	 public void fileUpload(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
	        
//	        response.setCharacterEncoding("UTF-8");  
//	        response.setContentType("application/json; charset=utf-8");  
	        PrintWriter writer = response.getWriter();
	        try {
	            long userId = ContextUtil.getCurrentUserId(); // 获取当前用户的id
	            String uploadType = RequestUtil.getString(request, "uploadType");               //控件的类型
	            String fileFormates = RequestUtil.getString(request, "fileFormates");         //格式要求

	            boolean mark = true;
	            // 附件保存路径
	            //String attachPath = configproperties.getProperty("file.upload");
	            String attachPath = ServiceUtil.getBasePath();
	            Map<String, MultipartFile> files = request.getFileMap();
	            Iterator<MultipartFile> it = files.values().iterator();

	            while (it.hasNext()) {
	                //Long fileId = uniqueIdUtil.genSeqId(SqeIdName.Attachment.getSeqName());
	                Long fileId = uniqueIdUtil.genId(Attachment.class.getName());
	                MultipartFile f = it.next();
	                String oriFileName = f.getOriginalFilename();
	                String extName = FileUtil.getFileExt(oriFileName);

	                if (StringUtil.isNotEmpty(fileFormates)) {            //文件格式要求
	                    if (!(fileFormates.contains("*." + extName))) {       //不符合文件格式要求的就标志为false
	                        mark = false;
	                    }
	                }

	                if (mark) {
	                    String fileName = fileId + "." + extName;
	                    // 开始写入物理文件
	                    String filePath = "";
	                    if ("pictureShow".equals(uploadType)) {            //pictureShow控件要的文件路径要有一点不同
	                        filePath = createFilePath(attachPath + File.separator + userId + File.separator + "pictureShow", fileName);
	                    } else {
	                        filePath = createFilePath(attachPath + File.separator + userId, fileName);
	                    }

	                    FileUtil.writeByte(filePath, f.getBytes());
	                    
	                    writer.println(filePath.replace(attachPath + File.separator, ""));

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
	    @Action(description = "根据文件id取得附件数据", exectype = "管理日志", detail = "根据文件id取得附件数据")
	    public void getFileById(HttpServletRequest request, HttpServletResponse response) throws IOException {


	        String filePath = RequestUtil.getString(request, "filePath");

	        String attachPath = ServiceUtil.getBasePath();

	        // 附件保存路径
	        String fullPath = StringUtil.trimSufffix(attachPath, File.separator) + File.separator + filePath.replace("/", File.separator);

	        byte[] bytes = FileUtil.readByte(fullPath);
	        response.getOutputStream().write(bytes);

	    }
	    private String createFilePath(String tempPath, String fileName) {
	        File one = new File(tempPath);
	        Calendar cal = Calendar.getInstance();
	        Integer year = cal.get(Calendar.YEAR); // 当前年份
	        Integer month = cal.get(Calendar.MONTH) + 1; // 当前月份
	        one = new File(tempPath + File.separator + year + File.separator + month);
	        if (!one.exists()) {
	            one.mkdirs();
	        }
	        return one.getPath() + File.separator + fileName;
	    }
	
    //  查看单位基本信息表明细
	@RequestMapping("details")
	@Action(description="查看单位基本信息表明细")
	public String details(HttpServletRequest request,Model model) throws Exception
	{
		Long aab001=RequestUtil.getLong(request,"aab001",0L);
		Corp  corp= corpService.getById(aab001);
		if(corp!=null){
			model.addAttribute("daytime",new Date());
			model.addAttribute("cp",corp);
		}else{
			new RuntimeException("无法从id获取数据");
		}
		
		return "/business/corp/corpapproveEdit.jsp";					
	}
	
	/**
	 * 取得单位基本信息表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看单位基本信息表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long aab001=RequestUtil.getLong(request,"aab001");
		Corp corp = corpService.getById(aab001);	
		return getAutoView().addObject("corp", corp);
	}

	@RequestMapping("isExist")
	@Action(description = "判断单位名称或者工商营业执照号是否存在")
	@ResponseBody
	public ResultMessage isExist(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ResultMessage resultMessage = null;
		try {
			QueryFilter fiter = new QueryFilter(request);
			List<Corp> list = corpService.getByNameNumber(fiter);
			if (list != null && list.size() > 0) {
				resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			} else {
				resultMessage = new ResultMessage(ResultMessage.Fail, "不存在");
			}
		} catch (Exception ex) {
			resultMessage = new ResultMessage(ResultMessage.Success, "已经存在");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return resultMessage;
	}

	public String getIpAddr(HttpServletRequest request) { 
	       String ip = request.getHeader("x-forwarded-for"); 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("WL-Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getRemoteAddr(); 
	       } 
	       return ip; 
	   }

}
