package com.server.chbw.util;

import java.util.HashMap;
import java.util.List;

public class ResData extends HashMap<String, Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static ResData data(int status,String msg){
		ResData r = new ResData();
		  r.put("status", status);
		  r.put("msg", msg);
		  return r;
	}

}
