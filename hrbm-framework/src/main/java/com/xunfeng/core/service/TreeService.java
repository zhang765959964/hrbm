//package com.xunfeng.core.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//
//import com.xunfeng.core.db.IEntityDao;
//import com.xunfeng.core.db.TreeDao;
//import com.xunfeng.core.model.BaseTree;
//import com.xunfeng.core.model.Tree;
//
//@Service
//public class TreeService extends BaseService<Tree> {
//
//	@Resource
//	private TreeDao dao;
//
//	@Override
//	protected IEntityDao<Tree, Long> getEntityDao() {
//		return dao;
//	}
//	
//	public List<Tree> getCityTree(){
//		return dao.getCityTree();
//	}
//	public List<BaseTree> getCityTree1() {
//		List<Tree> allCitys = dao.getCityTree();
//		List<BaseTree> treeDataDtos = new ArrayList<BaseTree>();
//		if (!allCitys.isEmpty()) {
//			for (Tree city : allCitys) {
//				if (city.getpId().longValue()==0) {
//					BaseTree  root =new BaseTree();
//					root.setId(city.getId());
//					root.setText(city.getName()); 
//					root.setCode(city.getCode());
//					root.setChildren(new ArrayList());
//					generateTreeData(allCitys,root);
//					treeDataDtos.add(root);
//				}
//			}
//			
//		}
//		
//		return treeDataDtos;
//	}
//	//递归生成树的结构
//	public void generateTreeData(List<Tree> allCitys, BaseTree root) {
//		
//		for (Tree city : allCitys) {
//			if (city.getpId() != null  && city.getpId().equals(root.getId())) {
//				BaseTree  child =new BaseTree();
//				child.setId(city.getId());
//				child.setText(city.getName());
//				child.setCode(city.getCode());
//				if(null==root.getChildren()){
//					List children = new ArrayList();
//					children.add(child);
//					root.setChildren(children);
//				}else{
//					root.getChildren().add(child);
//				}
//				
//				generateTreeData(allCitys, child);
//			}
//		}
//		
//	}
//}
