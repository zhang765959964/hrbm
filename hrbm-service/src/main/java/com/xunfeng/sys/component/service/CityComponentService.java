package com.xunfeng.sys.component.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.component.dao.CityComponentDao;
import com.xunfeng.sys.component.interf.CityComponentServiceInterf;
import com.xunfeng.sys.component.model.City;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 举办城市代码表 Service类
* @author:wxl
* @createDate 2015-07-31 14:48:55 
* @version V1.0   
*/
@Service
public class CityComponentService extends BaseService<City> implements CityComponentServiceInterf
{
	@Resource
	private CityComponentDao dao;
	
	
	
	public CityComponentService()
	{
	}
	
	@Override
	protected IEntityDao<City, Long> getEntityDao()
	{
		return dao;
	}

	public List<City> getByPid(Long pId){
		return dao.getByPid(pId);
	}

	//根据区域码获取完成的区域
	public List<City> getMyCity(String code){
		//List<City> myCities = new ArrayList<City>();
		Stack<City> myCitys = new Stack<City>();
		City one = dao.getByCode(code);
		while (one!=null){
			myCitys.add(one);
			one = dao.getById(one.getPid());
		}
		/*City two = dao.getById(one.getPid());
		myCities.add(dao.getById(two.getPid()));
		myCities.add(two);
		myCities.add(one);*/
		return myCitys;
	}
	/**
	 * 根据区域code获得城市
	 */
	public City getCityByCode(String code){
		return dao.getByCode(code);
	}
	/**
	 * 根据父id获得子孙级别的数据 一般用于地区的三级选择 
	 * eg:河南省 濮阳市 市辖区 包括华龙区.. 传入 濮阳市id则会得到所有的孙级节点
	 * @param pId
	 * @return List<City>
	 */
	public List<City> getCityByPid(Long pId){
		List<City> list = dao.getByPid(pId);
		List<City> cityList = new ArrayList<City>();
		for(City city : list){
			List<City> listChildren =  dao.getByPid(city.getId());
			if(listChildren != null && listChildren.size()>0){
				cityList.addAll(listChildren);
			}else{
				cityList.add(city);
			}
		}
		return cityList;
	}
	
}
