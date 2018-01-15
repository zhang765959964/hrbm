package com.xunfeng.core.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

import com.xunfeng.core.util.BeanToBean;

/**
 * @company: 河南讯丰信息技术有限公司
 * @Description: 实体类基类
 * @author wanghan
 * @createDate 2015年4月23日-下午2:08:31
 * @version V1.0
 */
public class BaseForm<T> extends BaseModel {

	private final String MVC_METHOD_ADD = "add";

	private final String MVC_METHOD_EDIT = "edit";

	/**
	 * 当前MVC操作方法 MVC_METHOD_ADD | MVC_METHOD_EDIT
	 */
	protected String mvcMethod = MVC_METHOD_ADD;

	/**
	 * 压入model数据
	 *
	 * @param model
	 * @return
	 */
	public BaseForm putModel(T model) {
		if (model == null) {
			// this.id = UUID.random();
			this.mvcMethod = MVC_METHOD_ADD;
		} else {
			BeanToBean.copyProperties(model, this, false);
			this.mvcMethod = MVC_METHOD_EDIT;
		}
		return this;
	}

	/**
	 * 返回Model数据
	 *
	 * @param model
	 * @return
	 */
	public T getModel(T model) throws RuntimeException {
		if (model == null) {
			Class<T> clazz = this.getModeClass();
			try {

				model = clazz.newInstance();
				this.mvcMethod = MVC_METHOD_ADD;
			} catch (Exception e) {
				throw new RuntimeException("创建类型实例失败" + clazz, e);
			}
		} else {
			this.mvcMethod = MVC_METHOD_EDIT;
		}

		return (T) BeanToBean.copyProperties(this, model, false);
	}

	/**
	 * 压入model数据
	 *
	 * @param model
	 * @return
	 */
	public BaseForm putDto(Object model) {
		if (model == null) {
			// this.id = UUID.random();
			this.mvcMethod = MVC_METHOD_ADD;
		} else {
			BeanToBean.copyProperties(model, this, false);
			this.mvcMethod = MVC_METHOD_EDIT;
		}
		return this;
	}

	/**
	 * 当前表单是否为新增操作
	 * 
	 * @see #isMVCAdd
	 * @return 是否为add操作
	 */
	@Deprecated
	public boolean getIsMvcAdd() {
		return MVC_METHOD_ADD.equals(this.mvcMethod);
	}

	/**
	 * 当前表单是否为新增操作
	 * 
	 * @return
	 */
	public boolean isMvcAdd() {
		return MVC_METHOD_ADD.equals(this.mvcMethod);
	}

	/**
	 * 当前表单是否为编辑操作
	 * 
	 * @see #isMvcEdit
	 * @return 是否为add操作
	 */
	@Deprecated
	public boolean getIsMvcEdit() {
		return MVC_METHOD_EDIT.equals(this.mvcMethod);
	}

	/**
	 * 当前表单是否为编辑操作
	 * 
	 * @return 是否为add操作
	 */
	public boolean isMvcEdit() {
		return MVC_METHOD_EDIT.equals(this.mvcMethod);
	}

	public String getMvcMethod() {
		return mvcMethod;
	}

	public void setMvcMethod(String mvcMethod) {
		this.mvcMethod = mvcMethod;
	}

	private Class getGenericType(int index, Object o) {
		Type genType = o.getClass().getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			throw new RuntimeException("Index outof bounds");
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}

	public Class<T> getModeClass() {
		return this.getGenericType(0, this);
	}

	public void setCreaterId(Long createrId) {

	}

	public void setCreaterName(String createrName) {

	}

	public void setCreaterDate(java.util.Date createrDate) {

	}

	public void setCreaterOrgName(String createrOrgName) {

	}

	public void setCreaterOrgId(Long createrOrgId) {

	}
	
	public void setFkCreaterId(Long createrId) {

	}

	public void setFdCreaterName(String createrName) {

	}

	public void setFdCreaterDate(java.util.Date createrDate) {

	}

	public void setFdCreaterOrgName(String createrOrgName) {

	}

	public void setFkCreaterOrgId(Long createrOrgId) {

	}

}
