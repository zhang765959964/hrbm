package com.xunfeng.business.careertalk.service;

import com.xunfeng.business.careertalk.dao.CareerRoomDao;
import com.xunfeng.business.careertalk.dao.CareerTimeBucketDao;
import com.xunfeng.business.careertalk.model.CareerRoom;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 宣讲会教室 Service类
* @author:zhouhang
* @createDate 2015-09-21 09:49:15 
* @version V1.0   
*/
@Service
public class CareerRoomService extends BaseService<CareerRoom>
{
	@Resource
	private CareerRoomDao dao;
	@Resource
	private CareerTimeBucketDao timeBucketDao;
	
	
	
	public CareerRoomService()
	{
	}
	
	@Override
	protected IEntityDao<CareerRoom, Long> getEntityDao() 
	{
		return dao;
	}


	public  List<CareerRoom>  getRoomList(){

		return dao.getAll();
	}
	public List<CareerRoom>  getAllCareerRoomList(Long aab001){

		Map param=new HashMap();
		param.put("aab001",aab001);
		return dao.getListBySqlKey("",param);

	}
}
