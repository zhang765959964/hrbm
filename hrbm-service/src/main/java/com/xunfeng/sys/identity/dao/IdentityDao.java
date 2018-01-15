
package com.xunfeng.sys.identity.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.identity.model.Identity;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 生产流水号Dao
* @author wanghan 
* @createDate 2015年4月23日-上午10:07:15 
* @version V1.0   
*/
@Repository
public class IdentityDao extends BaseDao<Identity>
{
	@SuppressWarnings("rawtypes")
	@Override
	public Class getEntityClass()
	{
		return Identity.class;
	}
	
	
	/**
	 * 根据别名获取键值。
	 * @param alias
	 * @return
	 */
	public Identity getByAlias(String alias)
	{
		String statment=this.getIbatisMapperNamespace() + ".getByAlias_"+this.getDbType();
		Identity obj=(Identity)this.getSqlSessionTemplate().selectOne(statment , alias);
		return obj;
	}
	
	/**
	 * 查看别名是否存在。
	 * @param alias
	 * @return
	 */
	public boolean isAliasExisted(String alias){
		return (Integer) this.getOne("isAliasExisted", alias)>0;
	}
	
	/**
	 * 查看别名是否存在。
	 * @param identity
	 * @return
	 */
	public boolean isAliasExistedByUpdate(Identity identity){
		return (Integer) this.getOne("isAliasExistedByUpdate", identity)>0;
	}
	
	
	public List<Identity> getList(){
		return this.getBySqlKey("getList");
	}
	

}