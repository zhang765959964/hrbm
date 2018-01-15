package com.xunfeng.core.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.xunfeng.core.web.ResultMessage;

/**
 * Created by Administrator on 2015/10/22.
 */

public class MyExceptionResolver implements HandlerExceptionResolver {

	// private ExceptionLogDao exceptionLogDao;
	protected Logger logger = LoggerFactory.getLogger(MyExceptionResolver.class);

//	@Override
//	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
//			Exception ex) {
//
//		ex.printStackTrace();
//		logger.error("系统出错", ex);
//		ModelAndView view = new ModelAndView("/sys/common/404.jsp");
//		return view;
//	}

	// public ModelAndView resolveException(HttpServletRequest request,
	// HttpServletResponse response, Object handler,
	// Exception ex) {
	// ModelAndView mv = new ModelAndView();
	// // /* 使用response返回 */
	// // response.setStatus(HttpStatus.OK.value()); // 设置状态码
	// // response.setContentType(MediaType.APPLICATION_JSON_VALUE); //
	// // 设置ContentType
	// // response.setCharacterEncoding("UTF-8"); // 避免乱码
	// // response.setHeader("Cache-Control", "no-cache, must-revalidate");
	// try {
	// ResultMessage message = new ResultMessage(ResultMessage.Fail, "系统异常");
	//
	// writeResultMessage(response.getWriter(), message);
	// } catch (IOException e) {
	// logger.error("与客户端通讯异常:" + e.getMessage(), e);
	// }
	//
	// logger.error("异常:" + ex.getMessage(), ex);
	// return mv;
	// }

//	protected void writeResultMessage(PrintWriter writer, ResultMessage resultMessage) {
//		writer.print(resultMessage);
//	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//HandlerMethod handlerMethod = (HandlerMethod) handler;
		//ResponseBody body = handlerMethod.getMethodAnnotation(ResponseBody.class);
		// 判断有没有@ResponseBody的注解没有的话调用父方法
		ModelAndView mv = new ModelAndView(); //
		if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
			// 设置状态码,注意这里不能设置成500，设成500JQuery不会出错误提示 //并且不会有任何反应
			response.setStatus(HttpStatus.OK.value()); // 设置ContentType
			response.setContentType(MediaType.APPLICATION_JSON_VALUE); // 避免乱码
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Cache-Control", "no-cache, must-revalidate");
			try {
				ex.printStackTrace();
				PrintWriter writer = response.getWriter();
				writer.write("{\"result\":\"0\",\"message\":\"系统异常，请联系系统管理员\"}");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			ModelAndView view = new ModelAndView("/sys/common/404.jsp");
			return view;
		}
		
		return mv;
	}

}