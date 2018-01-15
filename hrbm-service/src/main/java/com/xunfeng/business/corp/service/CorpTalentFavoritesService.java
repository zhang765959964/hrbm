package com.xunfeng.business.corp.service;

import com.xunfeng.business.corp.dao.CorpTalentFavoritesDao;
import com.xunfeng.business.corp.dto.CorpInterestTalentDto;
import com.xunfeng.business.corp.dto.CorpTalentFavoritesDto;
import com.xunfeng.business.corp.model.CorpTalentFavorites;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.accounts.model.Accounts;

import oracle.jdbc.OracleTypes;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 企业人才收藏夹 Service类
* @author:wxl
* @createDate 2015-07-25 09:38:50 
* @version V1.0   
*/
@Service
public class CorpTalentFavoritesService extends BaseService<CorpTalentFavorites>
{
	@Resource
	private CorpTalentFavoritesDao dao;
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	
	
	public CorpTalentFavoritesService()
	{
	}
	
	@Override
	protected IEntityDao<CorpTalentFavorites, Long> getEntityDao()
	{
		return dao;
	}

	/**
	 * 获取企业感兴趣的人才
	 * 1.调用存储过程生成匹配临时表
	 * 2.查询
	 */
	public List<CorpInterestTalentDto> getAllCorpInterestTalent(QueryFilter filter,final Accounts loginUser){
		//final Long loginUserId = ContextUtil.getCurrentUserId();
		String tableName = (String) jdbcTemplate.execute(
				new CallableStatementCreator() {
					public CallableStatement createCallableStatement(Connection con) throws SQLException {
						String storedProc = "{call  pkg_wz_int.p_interested_worker(?,?)}";// 调用的sql
						CallableStatement cs = con.prepareCall(storedProc);
						cs.setLong(1,loginUser.getCcmu01());
						cs.registerOutParameter(2, OracleTypes.VARCHAR);//注册输出参数的类型
						return cs;
					}
				}, new CallableStatementCallback() {
					public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
						try {
							cs.execute();
						}catch (Exception e){

							logger.error(ExceptionUtil.getExceptionMessage(e));
							throw new RuntimeException("企业感兴趣人才，存储过程调用出错");
						}
						return cs.getString(2);// 获取输出参数的值
					}
				});

		return dao.getAllCorpInterestTalent(filter);
	}


	/**
	 * 企业人才库
	 */
	public List<CorpTalentFavoritesDto> getAllCorpTalentFavorites(QueryFilter filter){
		return dao.getAllCorpTalentFavorites(filter);
	}

	/**
	 * 删除企业人才库中的人才
	 */
	public void delCorpTalentFavorites(Long[] ids){
		for(Long id:ids){
			dao.delCorpTalentFavorites(id);
		}
	}
}
