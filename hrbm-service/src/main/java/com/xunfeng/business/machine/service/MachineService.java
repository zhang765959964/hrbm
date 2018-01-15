package com.xunfeng.business.machine.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.machine.dao.MachineDao;
import com.xunfeng.business.machine.interf.MachineServiceInterf;
import com.xunfeng.business.machine.model.Machine;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 查询机管理表 Service类
* @author:wanghan
* @createDate 2015-11-23 10:15:36 
* @version V1.0   
*/
@Service
public class MachineService extends BaseService<Machine>  implements MachineServiceInterf
{
	@Resource
	private MachineDao dao;
	
	
	
	public MachineService()
	{
	}
	
	@Override
	protected IEntityDao<Machine, Long> getEntityDao() 
	{
		return dao;
	}

	public void  openMap(Float x,Float y,Long zoomScale,Long machineId){
		Machine machine=this.getById(machineId);
		machine.setGprsX(x);
		machine.setGprsY(y);
		machine.setZoom(zoomScale);
		dao.update(machine);
	}
}
