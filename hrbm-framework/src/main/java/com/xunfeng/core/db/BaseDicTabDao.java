//package com.xunfeng.core.db;
//
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.xunfeng.core.model.BaseDicTab;
//
///**
// * 查询所有的 字典表内的数据只有： id name code 
// * @author Administrator
// *
// */
//@Repository
//public class BaseDicTabDao extends BaseDao<BaseDicTab>{
//
//	@Override
//	public Class getEntityClass() {
//		 
//		return BaseDicTab.class;
//	}
//	/**
//	 * 获取所有的参保类型
//	 * @return
//	 */
//	public List<BaseDicTab> getAllSocialSecType(){
//		return this.getBySqlKey("getAllSocialSecType");
//	}
//
//}
