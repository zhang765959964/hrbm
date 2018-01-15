package com.xunfeng.sys.component.interf;

import java.util.List;

import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.sys.component.model.City;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 举办城市代码表 Service类
* @author:wxl
* @createDate 2015-07-31 14:48:55 
* @version V1.0   
*/
public interface CityComponentServiceInterf extends  GenericServiceInterface<City,Long>
{

	public List<City> getByPid(Long pId);

	//根据区域码获取完成的区域
	public List<City> getMyCity(String code);
	/**
	 * 根据区域code获得城市
	 */
	public City getCityByCode(String code);
	/**
	 * 根据父id获得子孙级别的数据 一般用于地区的三级选择 
	 * eg:河南省 濮阳市 市辖区 包括华龙区.. 传入 濮阳市id则会得到所有的孙级节点
	 * @param pId
	 * @return List<City>
	 */
	public List<City> getCityByPid(Long pId);
}
