package com.xunfeng.core.db.helper;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年4月25日-上午11:18:13 
* @version V1.0   
*/
public class DbCmd<T> implements JdbcCommand {

	public enum OperatorType {
		Add, Del, Upd, Get
	}

	private ObjectHelper<T> helper;
	private T obj;
	private OperatorType type;

	public void setModel(T obj) {
		helper = new ObjectHelper<T>();
		helper.setModel(obj);
		this.obj = obj;
	}

	public void setOperatorType(OperatorType type) {
		this.type = type;
	}

	@Override
	public void execute(DataSource source) throws Exception {
		String sql = "";
		if (type == OperatorType.Add) {
			sql = helper.getAddSql();
		} else if (type == OperatorType.Upd) {
			sql = helper.getUpdSql();
		} else if (type == OperatorType.Del) {
			sql = helper.getDelSql();
		}
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(this.obj);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(source);
		template.update(sql, namedParameters);
	}

}
