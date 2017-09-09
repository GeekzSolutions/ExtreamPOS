package com.geekz.orm;

import org.json.JSONObject;

public interface GeekzORM {
		
	public Object read(Class<?> clz, Integer id);
	
	public Object edit(Class<?> clz, Object saveObj);
	
	public Object add(Class<?> clz, Object saveObj);
	
	public Object[] delete();
	
	
}
