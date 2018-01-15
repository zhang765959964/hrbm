package com.xunfeng.util;

import java.util.List;

import javax.annotation.Resource;

import com.xunfeng.core.util.AppUtil;
import com.xunfeng.sys.uums.interf.SysOrgServiceInterf;
import com.xunfeng.sys.uums.interf.SysUserServiceInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.sys.uums.service.SysOrgService;
import com.xunfeng.sys.uums.service.SysUserService;

public class UserConversionOrg {
	
	public static String getOrgByUser(String userid){
		SysOrgServiceInterf sysOrgService = (SysOrgServiceInterf)AppUtil.getBean("sysorg");
		SysUserServiceInterf sysUserService = (SysUserServiceInterf)AppUtil.getBean("sysuser");
		String orgIds = "";
		SysUser sysUser = sysUserService.getById(Long.parseLong(userid));
		List<SysOrg> orgList = sysOrgService.getSubOrgans(sysUser.getAcd200());
		if(orgList!=null && !orgList.isEmpty()){
			if(orgList.size()==1){
				orgIds = orgList.get(0).getAcd200().toString();
			}else{
				for (int i = 0; i < orgList.size(); i++) {
					if(i==0){
						orgIds+= orgList.get(i).getAcd200();
					}else{
						orgIds+=","+orgList.get(i).getAcd200();
					}
				}
			}
		}else{
			orgIds = sysUser.getAcd200().toString();
		}
		return orgIds;
	}
}
