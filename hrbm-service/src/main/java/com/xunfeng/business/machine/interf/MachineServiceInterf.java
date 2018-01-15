package com.xunfeng.business.machine.interf;

import org.springframework.stereotype.Service;

import com.xunfeng.business.machine.model.Machine;
import com.xunfeng.core.service.GenericServiceInterface;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 查询机管理表 Service类
* @author:wanghan
* @createDate 2015-11-23 10:15:36 
* @version V1.0   
*/
@Service
public interface MachineServiceInterf extends  GenericServiceInterface<Machine,Long>
{
	

	public void  openMap(Float x,Float y,Long zoomScale,Long machineId);
}
