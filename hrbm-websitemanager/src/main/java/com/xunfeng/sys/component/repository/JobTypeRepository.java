package com.xunfeng.sys.component.repository;
import java.util.ArrayList;
import java.util.List;

import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.EhcacheUtil;
import com.xunfeng.sys.component.interf.JobServiceInter;
import com.xunfeng.sys.component.model.Job;

public class JobTypeRepository {
	private static JobServiceInter jobService = (JobServiceInter) AppUtil
			.getBean("job");

	public static List<Job> getJobList() {
		List<Job> jobList = (List<Job>) EhcacheUtil.getInstance().get("job",
				"jobList");
		if (jobList != null) {
			return jobList;
		}
		List<Job> allJobList = jobService.getAll();
		jobList = getJobList(allJobList);
		EhcacheUtil.getInstance().put("job", "jobList", jobList);
		return jobList;

	}
	public static List<Job> getChildJobList(String pId) {
		List<Job> jobList = (List<Job>) EhcacheUtil.getInstance().get("job",pId);
		if (jobList != null) {
			return jobList;
		}
		jobList = jobService.getJobList(Long.valueOf(pId));
		EhcacheUtil.getInstance().put("job", pId, jobList);
		return jobList;

	}
	private static List<Job> getJobList(List<Job> allJobList){
	   
	   List<Job> joblist=new ArrayList();
	   
	   for(Job job:allJobList){
		   if("0".equals(job.getPid())){
			   addSubJobList(job,allJobList);
			   joblist.add(job); 
		   }
	   }
	  return  	joblist  ; 	   
   }

	private static void addSubJobList(Job targetJob, List<Job> allJobList) {

		for (Job job : allJobList) {
			if (targetJob.getId().equals(job.getPid())) {
				addSubJobList(job, allJobList);
				targetJob.getSubJobList().add(job);
			}
		}
		EhcacheUtil.getInstance().put("job", targetJob.getId(), targetJob.getSubJobList());
	}
}
