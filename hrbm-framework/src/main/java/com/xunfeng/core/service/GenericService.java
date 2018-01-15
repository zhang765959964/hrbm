package com.xunfeng.core.service;

import java.io.Serializable;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 服务基类 
* @author wanghan 
* @createDate 2015年4月23日-上午11:58:13 
* @version V1.0   
*/
public abstract class GenericService <E, PK extends Serializable>{
	protected Logger logger = LoggerFactory.getLogger(GenericService.class);
	/**
	 * 需要被子类覆盖
	 * @return
	 */
	protected abstract IEntityDao<E,PK> getEntityDao();

	/**
	 * 添加对象
	 * @param entity
	 */
	public void add(E entity)
	{
		getEntityDao().add(entity);
	}

	/**
	 * 根据主键删除对象
	 * @param id
	 */
	public void delById(PK id)
	{
		getEntityDao().delById(id);
	}

	/**
	 * 根据主键批量删除对象
	 * @param ids
	 */
	public void delByIds(PK[] ids){
		if(BeanUtils.isEmpty(ids)) return;
		for (PK p : ids){
			delById(p);
		}
	}

	/**
	 * 修改对象
	 * @param entity
	 */
	public void update(E entity)
	{
		getEntityDao().update(entity);
	}

	/**
	 * 根据主键Id获取对象
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E getById(PK id)
	{
		return (E) getEntityDao().getById(id);
	}

	/**
	 * 取得分页。
	 * @param statatementName
	 * @param pb
	 * @return
	 */
	public List<E> getList(String statatementName,PageBean pb)
	{
		List<E>  list = getEntityDao().getList(statatementName, pb);
		return list;
	}
	/**
	 * 返回所有记录
	 * @return
	 */
	public List<E> getAll()
	{
		return getEntityDao().getAll();
	}
	
	/**
	 * 按过滤器查询记录列表
	 * @param queryFilter
	 * @return
	 */
	public List<E> getAll(QueryFilter queryFilter){
		return getEntityDao().getAll(queryFilter);
	}
	
	
}
