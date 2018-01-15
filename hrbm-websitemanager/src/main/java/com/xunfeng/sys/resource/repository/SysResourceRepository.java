package com.xunfeng.sys.resource.repository;

import java.util.ArrayList;
import java.util.List;

import com.xunfeng.core.util.AppUtil;
import com.xunfeng.sys.resource.interf.SysResourceServiceInterf;
import com.xunfeng.sys.resource.model.SysResource;
import com.xunfeng.sys.uums.model.SysUser;


public class SysResourceRepository { 
	
	private static SysResourceServiceInterf sysResourceService=(SysResourceServiceInterf) AppUtil.getBean("sysResource");

	public static List<SysResource> getSysResourceList(SysUser curUser) {
		
//		SysResource sysResource=sysResourceService.getResByAlias("ROOTRES");
	    List<SysResource> allSysResourceList=sysResourceService.getAllUserResourceByUserId(curUser.getAcd230());//.getEhCacheUserResource( curUser,sysResource.getResId(),true);
	    List<SysResource> jobList  = getJobList(allSysResourceList);
		return jobList;
	}
	
	private static List<SysResource> getJobList(List<SysResource> allJobList){
		   
		   List<SysResource> joblist=new ArrayList();
		   
		   for(SysResource sysResource:allJobList){
			   if(0==sysResource.getFunpid()){
				   addSubJobList(sysResource,allJobList);
				   joblist.add(sysResource); 
			   }
		   }
		  return  	joblist  ; 	   
	   }

		private static void addSubJobList(SysResource targetJob, List<SysResource> allJobList) {

			for (SysResource sysResource : allJobList) {
				if (targetJob.getFunid().compareTo(sysResource.getFunpid())==0) {
					addSubJobList(sysResource, allJobList);
					targetJob.getSubSysResourceList().add(sysResource);
				}
			}
	}
	
}
