package com.xunfeng.core.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.core.util.LocaleUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 通用控制器
* @author wanghan
* @createDate 2015年4月23日-上午11:13:17 
* @version V1.0   
*/
public class GenericController {
	protected Logger logger = LoggerFactory.getLogger(BaseController.class);
	/**
	 * 返回成功的JSON字符串
	 */
	public final String SUCCESS = "{success:true}";
	/**
	 * 返回失败字符串
	 */
	public final String FAILURE = "{success:false}";

	/**
	 * 保存操作的信息
	 */
	private MessageSourceAccessor messages;

	/**
	 * 执行添加或更新操作时视图步骤1（显示）
	 */
	public static final String STEP1 = "1";
	/**
	 * 执行添加或更新操作完成视图步骤2（更新）
	 */
	public static final String STEP2 = "2";

	public static final String MESSAGES_KEY = "successMessages";

	public static final String ERRORS = "errors";

	/**
	 * 通过Request的URL对应转成对应的JSP文件展示
	 * 
	 * @return
	 * @throws Exception
	 */
	public ModelAndView getAutoView() throws Exception {
		return getAutoView("");
	}
	public ModelAndView getAutoView(String basePath) throws Exception {
		HttpServletRequest request = RequestUtil.getHttpServletRequest();
		String requestURI = request.getRequestURI();
		// 处理RequestURI
		logger.debug("requestURI:" + requestURI);
		String contextPath = request.getContextPath();

		requestURI = requestURI.replace(".xf", "");
		int cxtIndex = requestURI.indexOf(contextPath);
		if (cxtIndex != -1) {
			requestURI = requestURI.substring(cxtIndex + contextPath.length());
		}

		String[] paths = requestURI.split("[/]");
		if (paths != null && paths.length == 5) {
			String jspPath =basePath+ "/" + paths[1] + "/" + paths[2] + "/" + paths[3]
					+ StringUtil.makeFirstLetterUpperCase(paths[4]) + ".jsp";
			return new ModelAndView(jspPath);
		} else if (paths != null && paths.length == 4) {
			String jspPath =basePath+ "/" + paths[1] + "/" + paths[2]
					+ StringUtil.makeFirstLetterUpperCase(paths[3]) + ".jsp";
			return new ModelAndView(jspPath);
		}else if (paths != null && paths.length == 3) {
			String jspPath = basePath+ "/" + paths[1]
					+ StringUtil.makeFirstLetterUpperCase(paths[2]) + ".jsp";
			return new ModelAndView(jspPath);
		} 
		else {
			logger.error("your request url is not the right pattern, it is not allowed use this getAutoView method");
			throw new Exception("url:[" + requestURI
					+ "] is not in this pattern:[/子系统/包名/表对应实体名/实体操作方法名.xf]");
		}

	}
	/**
	 * 通过Request的URL对应转成对应的JSP文件展示
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAutoPath() throws Exception {
		HttpServletRequest request = RequestUtil.getHttpServletRequest();
		String requestURI = request.getRequestURI();
		// 处理RequestURI
		logger.debug("requestURI:" + requestURI);
		String contextPath = request.getContextPath();

		requestURI = requestURI.replace(".xf", "");
		int cxtIndex = requestURI.indexOf(contextPath);
		if (cxtIndex != -1) {
			requestURI = requestURI.substring(cxtIndex + contextPath.length());
		}

		String[] paths = requestURI.split("[/]");
		if (paths != null && paths.length == 5) {
			String jspPath = "/" + paths[1] + "/" + paths[2] + "/" + paths[3]
					+ StringUtil.makeFirstLetterUpperCase(paths[4]) + ".jsp";
			return jspPath;
		} else if (paths != null && paths.length == 4) {
			String jspPath = "/" + paths[1] + "/" + paths[2]
					+ StringUtil.makeFirstLetterUpperCase(paths[3]) + ".jsp";
			return jspPath;
		} else {
			logger.error("your request url is not the right pattern, it is not allowed use this getAutoView method");
			throw new Exception("url:[" + requestURI
					+ "] is not in this pattern:[/子系统/包名/表对应实体名/实体操作方法名.xf]");
		}

	}
	@Autowired
	public void setMessages(MessageSource messageSource) {
		messages = new MessageSourceAccessor(messageSource);
	}

	/**
	 * 保存错误消息（errors）
	 * 
	 * @param request
	 * @param error
	 */
	public void saveError(HttpServletRequest request, String msg) {
		saveMessage(request, ERRORS, msg);
	}

	/**
	 * 保存消息（successMessages）
	 * 
	 * @param request
	 * @param msg
	 */
	public void saveMessage(HttpServletRequest request, String msg) {
		saveMessage(request, MESSAGES_KEY, msg);
	}

	/**
	 * 
	 * @param request
	 * @param key
	 * @param msg
	 */
	@SuppressWarnings("unchecked")
	public void saveMessage(HttpServletRequest request, String key, String msg) {
		List<Object> messages = (List<Object>) request.getSession()
				.getAttribute(key);
		if (messages == null) {
			messages = new ArrayList<Object>();
		}
		messages.add(msg);
		request.getSession().setAttribute(key, messages);
	}

	/**
	 * 根据key和local取得键值。
	 * 
	 * @param msgKey
	 * @param locale
	 * @return
	 */
	public String getText(String msgKey, Locale locale) {
		return messages.getMessage(msgKey, locale);
	}

	/**
	 * 根据键值，参数，local取得键值。
	 * 
	 * @param msgKey
	 * @param arg
	 * @param locale
	 * @return
	 */
	public String getText(String msgKey, String arg, Locale locale) {
		return getText(msgKey, new Object[] { arg }, locale);
	}

	/**
	 * 根据键值，参数数组，local取得键值。
	 * 
	 * @param msgKey
	 * @param args
	 * @param locale
	 * @return
	 */
	public String getText(String msgKey, Object[] args, Locale locale) {
		return messages.getMessage(msgKey, args, locale);
	}

	/**
	 * 根据键值参数取得键值。
	 * 
	 * @param msgKey
	 * @param args
	 * @return
	 */
	public String getText(String msgKey, Object... args) {
		return messages.getMessage(msgKey, args, LocaleUtil.getLocale());
	}

	/**
	 * 根据键值取得键值。
	 * 
	 * @param msgKey
	 * @return
	 */
	public String getText(String msgKey) {
		return messages.getMessage(msgKey, LocaleUtil.getLocale());
	}

	/**
	 * 取得资源键值
	 * 
	 * @param msgKey
	 * @param arg
	 * @param request
	 * @return
	 */
	protected String getText(String msgKey, String arg,
			HttpServletRequest request) {
		Locale locale = LocaleUtil.getLocale();
		return getText(msgKey, arg, locale);
	}

	/**
	 * 取得资源键值
	 * 
	 * @param msgKey
	 * @param args
	 * @param request
	 * @return
	 */
	protected String getText(String msgKey, Object[] args,
			HttpServletRequest request) {
		Locale locale = LocaleUtil.getLocale();
		return getText(msgKey, args, locale);
	}

	/**
	 * 返回出错或成功的信息。
	 * 
	 * @param writer
	 * @param resultMsg
	 * @param cause
	 * @param successFail
	 */
	protected void writeResultMessage(PrintWriter writer, String resultMsg,
			String cause, int successFail) {
		ResultMessage resultMessage = new ResultMessage(successFail, resultMsg,
				cause);
		writeResultMessage(writer, resultMessage);
	}

	/**
	 * 返回出错或成功的信息。
	 * 
	 * @param writer
	 * @param resultMsg
	 * @param successFail
	 */
	protected void writeResultMessage(PrintWriter writer, String resultMsg,
			int successFail) {
		ResultMessage resultMessage = new ResultMessage(successFail, resultMsg);
		writeResultMessage(writer, resultMessage);
	}

	/**
	 * 返回出错或成功的信息。
	 * 
	 * @param writer
	 * @param resultMessage
	 */
	protected void writeResultMessage(PrintWriter writer,
			ResultMessage resultMessage) {
		writer.print(resultMessage);
	}

	protected void writeResultMessage(PrintWriter writer,
			 String resultMsg,int successFail,Object data){
		ResultMessage resultMessage = new ResultMessage(successFail, resultMsg,data); 
		writeResultMessage(writer, resultMessage);
	}
	/**
	 * 保存结果操作消息
	 * 
	 * @param session
	 * @param msg
	 * @param successFail
	 */
	protected void saveResultMessage(HttpSession session, String msg,
			int successFail) {
		ResultMessage resultMsg = new ResultMessage(successFail, msg);
		session.setAttribute(BaseController.Message, resultMsg);
	}

	/**
	 * 保存成功的操作消息
	 * 
	 * @param session
	 * @param msg
	 */
	protected void saveSuccessResultMessage(HttpSession session, String msg) {
		saveResultMessage(session, msg, ResultMessage.Success);
	}

	/**
	 * 保存失败的操作消息
	 * 
	 * @param session
	 * @param msg
	 */
	protected void saveFailResultMessage(HttpSession session, String msg) {
		saveResultMessage(session, msg, ResultMessage.Fail);
	}
	/**
	 * 
	 * @param list
	 * @param response
	 * @param queryFilter
	 * @return
	 * @throws IOException 
	 */
	public void sendJsonToWeb(Object  obj,HttpServletResponse response,QueryFilter queryFilter) throws IOException
	{ 
		JSONArray json=new JSONArray();
		json.add(obj); 
		json.add(queryFilter.getPageBean());
		PrintWriter out = response.getWriter();
		out.print(json.toString());
	}
	@Resource
	protected Properties configproperties;
}
