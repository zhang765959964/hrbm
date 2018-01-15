//package com.xunfeng.core.web.controller;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.xunfeng.core.service.TreeService;
//
//@Controller
//@RequestMapping("/sys/tree/")
//public class TreeController extends BaseController {
//	
//	@Resource
//	private TreeService treeService;
// 
//	@RequestMapping("cityTree")
//	@ResponseBody
//	public Object cityTree(){
//		return treeService.getCityTree();
//	}
//	
//	@RequestMapping("/cityTree/list")
//	public ModelAndView cityTreeList() throws Exception{
//		return this.getAutoView();
//	}
//		
//}
