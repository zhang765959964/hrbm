package com.xunfeng.business.cms.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
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

import com.xunfeng.business.cms.dto.ArticleDto;
import com.xunfeng.business.cms.interf.ArticleColumnInter;
import com.xunfeng.business.cms.interf.ArticleInter;
import com.xunfeng.business.cms.model.Article;
import com.xunfeng.business.cms.model.ArticleColumn;
import com.xunfeng.business.cms.util.ServiceUtil;
import com.xunfeng.business.cms.web.form.ArticleForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
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
import com.xunfeng.sys.uums.interf.SysUserServiceInterf;
import com.xunfeng.sys.uums.model.SysUser;
/**
 *<pre>
 * 对象功能:新闻内容表 控制器类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-08 10:08:39
 *</pre>
 */
@Controller
@RequestMapping("/business/cms/article/")
public class ArticleController extends BaseController
{
	@Resource
    @Qualifier("article")
	private ArticleInter  articleService;
	@Resource
	@Qualifier("articlecol")
	private ArticleColumnInter articleColumnService;
	@Resource
    @Qualifier("sysuser")
	private SysUserServiceInterf  sysUserService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf UniqueIdUtil;	
	/**
	 * 添加或更新新闻内容表。
	 * @param request
	 * @param response

	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新新闻内容表")
	public void save(HttpServletRequest request, HttpServletResponse response,ArticleForm articleForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;
		try{
			Long cand01=RequestUtil.getLong(request,"cand01",0L);
			Article article=articleService.getById(cand01);
			article=articleForm.getModel(article);
			if(articleForm.isMvcAdd()){
				article.setCand01(UniqueIdUtil.genId(Article.class.getName()));
				article.setCand07(new Date());
				article.setCand09(1L);
				article.setCand17(0L);
				article.setCcmu01(ContextUtil.getCurrentUserId());
				article.setCand04(article.getCand04().replaceAll((String)request.getSession().getServletContext().getAttribute(SystemConst.fileDirectory), SystemConst.fileDirectory));
				articleService.add(article);
				resultMsg=getText("添加","新闻内容");
			}else{
				article.setCand07(new Date());
				article.setCand04(article.getCand04().replaceAll((String)request.getSession().getServletContext().getAttribute(SystemConst.fileDirectory), SystemConst.fileDirectory));
			    articleService.update(article);
				resultMsg=getText("更新","新闻内容");
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
	 * 取得新闻内容表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	@Action(description="查看新闻内容表分页列表")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		List<Article> list=articleService.getAll(new QueryFilter(request,"articleItem"));
		ModelAndView mv=this.getAutoView().addObject("articleList",list);
		
		return mv;
	}
	/**
	 * 取得从业人员信息表分页列表
	 * @param request
	 * @param response
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
		ResultData<ArticleDto> resultData=articleService.getResultDataArticleList(fiter);	
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 删除新闻内容表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除新闻内容表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "cand01");
			for(int i=0;i<lAryId.length;i++){
				Long cand01 = Long.parseLong(lAryId[i].toString());
				Article article=articleService.getById(cand01);
				article.setCand09(4L);
				articleService.update(article);
			}
			//articleService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除新闻内容成功!");
		}catch(Exception ex){
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
		}
		return message;
	}

	@RequestMapping("stickTop")
	@ResponseBody
	public ResultMessage stickTop(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		ResultMessage message=null;
		try{
			Long cand01=RequestUtil.getLong(request,"cand01",0L);
			articleService.stickTop(cand01);
			message=new ResultMessage(ResultMessage.Success, "置顶成功!");
		}catch(Exception ex){
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			message=new ResultMessage(ResultMessage.Fail, "置顶失败" + ex.getMessage());
		}
		return message;
	}

	@RequestMapping("cancelStickTop")
	@ResponseBody
	public ResultMessage cancelStickTop(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long cand01=RequestUtil.getLong(request,"cand01",0L);
			articleService.cancelStickTop(cand01);
			message=new ResultMessage(ResultMessage.Success, "取消置顶成功!");
		}catch(Exception ex){
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			message=new ResultMessage(ResultMessage.Fail, "取消置顶失败" + ex.getMessage());
		}
		return message;
	}
	
	/**
	 * 	编辑新闻内容表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑新闻内容表")
	public ModelAndView edit(HttpServletRequest request,ArticleForm articleForm) throws Exception
	{
		Long cand01=RequestUtil.getLong(request,"cand01",0L);
		SysUser sysUser=ContextUtil.getCurrentUser();
		Article article=articleService.getById(cand01);
		articleForm.putModel(article);
		ArticleColumn articleColumn = articleColumnService.getById(articleForm.getCanc01());
		articleForm.setColName(articleColumn.getCanc03());
		articleForm.setCcmu01(sysUser.getAac001());
		articleForm.setPublishUserName(sysUser.getAac003());
		articleForm.setCand04(StringUtil.isEmpty(articleForm.getCand04())?"":articleForm.getCand04().replaceAll(SystemConst.fileDirectory,(String)request.getSession().getServletContext().getAttribute(SystemConst.fileDirectory)));

		return getAutoView().addObject("articleForm",articleForm);
	}
	
	@RequestMapping("preview")
	@Action(description="编辑新闻内容表")
	public ModelAndView preview(HttpServletRequest request,ArticleForm articleForm) throws Exception
	{
		Long cand01=RequestUtil.getLong(request,"cand01",0L);
		Article article=articleService.getById(cand01);
		articleForm.putModel(article);
		articleForm.setCand04(StringUtil.isEmpty(articleForm.getCand04())?"":articleForm.getCand04().replaceAll( SystemConst.fileDirectory,(String)request.getSession().getServletContext().getAttribute(SystemConst.fileDirectory)));
		SysUser sysUser=sysUserService.getById(article.getCcmu01()==null?0L:article.getCcmu01());
		articleForm.setPublishUserName(sysUser==null?"系统发布员":sysUser.getAac003());
		return getAutoView().addObject("articleForm",articleForm);
	}

	/**
	 * 取得新闻内容表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看新闻内容表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long cand01=RequestUtil.getLong(request,"cand01");
		Article article = articleService.getById(cand01);	
		return getAutoView().addObject("article", article);
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
	                Long fileId =UniqueIdUtil.genId("");
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


	                    String filePath=FileWebDavUtil.uploadFile(6L, fileName, f.getInputStream());
	                    
	                    writer.println(filePath);

	                } else {
	                    logger.error("文件格式不符合要求！");
	                    writer.println("");
	                }

	            }

	        } catch (Exception e) {
	            logger.error("上传出错", e);
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
	
}
