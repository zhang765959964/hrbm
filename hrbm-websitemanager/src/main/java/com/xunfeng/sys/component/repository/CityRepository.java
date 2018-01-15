package com.xunfeng.sys.component.repository;
import java.util.List;

import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.EhcacheUtil;
import com.xunfeng.sys.component.interf.CityComponentServiceInterf;
import com.xunfeng.sys.component.model.City;

public class CityRepository {
	private static CityComponentServiceInterf cityService=(CityComponentServiceInterf) AppUtil.getBean("city");

	public static List<City> getProvincesList(){
		List<City> provincesList=(List<City>)EhcacheUtil.getInstance().get("city", "provincesList");
		if(provincesList!=null){
			return provincesList;
		}
//		CityComponentServiceInterf cityService=(CityComponentServiceInterf) AppUtil.getBean("city");
		 provincesList = cityService.getByPid(0L);
		EhcacheUtil.getInstance().put("city",  "provincesList", provincesList);
		return provincesList;
		
	} 
	
	public static List<City> getCityList(Long pId){
		List<City> provincesList=(List<City>)EhcacheUtil.getInstance().get("city", pId);
		if(provincesList!=null){
			return provincesList;
		}
//		CityComponentServiceInterf cityService=(CityComponentServiceInterf) AppUtil.getBean("city");
		 provincesList = cityService.getByPid(pId);
		EhcacheUtil.getInstance().put("city",  pId, provincesList);

		return provincesList;
		
	}
	
	public static List<City> getMyCityList(String code){
		
		List<City> provincesList=(List<City>)EhcacheUtil.getInstance().get("city", code);
		if(provincesList!=null){
			return provincesList;
		}
//		CityComponentServiceInterf cityService=(CityComponentServiceInterf) AppUtil.getBean("city");
		 provincesList = cityService.getMyCity(code);
		EhcacheUtil.getInstance().put("city",  code, provincesList);

		return provincesList;
		
	}
	public static City getCityByCode(String code){
		return cityService.getCityByCode(code);
	}
	
	
}
