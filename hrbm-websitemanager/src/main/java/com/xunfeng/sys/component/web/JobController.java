package com.xunfeng.sys.component.web;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.component.model.Job;
import com.xunfeng.sys.component.repository.JobTypeRepository;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 工种自定义标准 控制器类
* @author:wanghan
* @createDate 2015-09-23 15:34:24 
* @version V1.0   
*/
@Controller
@RequestMapping("/sys/component/job/")
public class JobController extends BaseController
{
	/**
	 * 1.获取热门城市
	 * 2.获取省份 PID=0
	 */
	@RequestMapping("index/{totalSelect}")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response,@PathVariable int totalSelect) throws Exception{
		ModelAndView mv  = new ModelAndView("/sys/component/job/index.jsp");
		List<Job> jobList= JobTypeRepository.getJobList();
		mv.addObject("jobList",jobList).addObject("totalSelect",totalSelect);
		return mv;
	}
	@RequestMapping("job-json")
	@ResponseBody
	public Object cityJson(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String pId = RequestUtil.getString(request, "pId");
		List<Job> jobList = JobTypeRepository.getChildJobList(pId);
		return jobList;
	}
}
