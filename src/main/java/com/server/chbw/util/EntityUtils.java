package com.server.chbw.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class EntityUtils {
	
	public static Object p2d(Object param,Object dao,boolean flag) throws Exception {
		Field[] fields=param.getClass().getDeclaredFields();
		for (Field field: fields) {
			String name = field.getName();
		    field.setAccessible(true); // 私有属性必须设置访问权限
		    Object resultValue = field.get(param);
		    //直接设置修改时间
		    if (name.equals("updatetime")) {
				resultValue = new Date();
			}
            //删除时，设置无效
			if (flag&&name.equals("isvalidate")) {
				resultValue = "0";
			}
			if (resultValue!=null) {
				Field f = dao.getClass().getDeclaredField(name);
				f.setAccessible(true);
				f.set(dao, resultValue);
			}
		}
		return dao;
	}
	
	public static Object setCommonValue(Object obj) throws Exception {
		Field[] fields=obj.getClass().getDeclaredFields();
		for (Field field: fields) {
			String name = field.getName();
			Object value = null;
			if (name.equals("isvalidate")||name.equals("updatetime")||name.equals("createtime")) {
				switch (name) {
				case "isvalidate":
					value = "1";
					break;
				default:
					value = new Date();
					break;
				}
				field.setAccessible(true); // 私有属性必须设置访问权限
				field.set(obj, value);
			}
		}
		return obj;
	}
	/**  
     * 获取属性名数组  
     * */  
	public static String[] getFiledName(Object o){  
        Field[] fields=o.getClass().getDeclaredFields();  
        String[] fieldNames=new String[fields.length];  
        for(int i=0;i<fields.length;i++){  
//            System.out.println(fields[i].getType());  
            fieldNames[i]=fields[i].getName();
        }  
        return fieldNames;  
    }
	/* 根据属性名获取属性值 */  
    public static Object getFieldValueByName(String fieldName, Object o) {  
        try {    
            String firstLetter = fieldName.substring(0, 1).toUpperCase();    
            String getter = "get" + firstLetter + fieldName.substring(1);    
            Method method = o.getClass().getMethod(getter, new Class[] {});    
            Object value = method.invoke(o, new Object[] {});    
            return value;    
        } catch (Exception e) {    
         
            return null;    
        }    
     }
}
