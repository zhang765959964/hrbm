package com.xunfeng.business.cation.interf;

import java.util.List;

import com.xunfeng.business.cation.model.Authentication;
import com.xunfeng.core.service.GenericServiceInterface;

public interface AuthenticationServiceInterf  extends GenericServiceInterface<Authentication,Long>
{


	public List<Authentication> getByAab001(Long aab001);
	

}
