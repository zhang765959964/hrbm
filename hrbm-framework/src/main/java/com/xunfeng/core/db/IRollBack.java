package com.xunfeng.core.db;

import java.util.Map;

public interface IRollBack {
	public Object execute(String script,Map<String,Object> map);
}
