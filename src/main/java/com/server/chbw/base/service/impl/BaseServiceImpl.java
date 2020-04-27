package com.server.chbw.base.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.server.chbw.base.service.IBaseService;
import com.server.chbw.util.EntityUtils;
import com.server.chbw.util.Layui;
import com.server.chbw.util.PageRequest;
import com.server.chbw.util.ServiceException;

public abstract class BaseServiceImpl<T> implements IBaseService{
	
	private final String METHOD_NAME_SEARCH = "list";
	private final String METHOD_NAME_ADD = "add";
	private final String METHOD_NAME_EDIT = "edit";
	private final String METHOD_NAME_FINDBYID = "findById";
	@Autowired
	private T mapper;

	public void setMapper(T mapper) {
		this.mapper = mapper;
	}

	/**
     * 
     * @param obj    使用要查询的对象的Entity传参
     * @param pageRequest    分页请求对象
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws RuntimeException
     */
	@Override
    public Layui list(Object obj,PageRequest pageRequest) throws Exception {
    	int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        @SuppressWarnings("unchecked")
		List<Object> objList = (List<Object>) mapper.getClass()
        		.getMethod(METHOD_NAME_SEARCH,obj.getClass())
        		.invoke(mapper,obj);
        PageInfo<Object> pageInfo = new PageInfo<Object>(objList);
        return Layui.data(pageInfo.getTotal(), pageInfo.getList());
    }
    @Override
    public Object add(Object obj) throws Exception {
    	obj = EntityUtils.setCommonValue(obj);
    	mapper.getClass()
    	.getMethod(METHOD_NAME_ADD,obj.getClass())
    	.invoke(mapper,obj);
		return obj;
    }
    @Override
    public Object editOrDelete(Object obj,boolean flag) throws Exception {
    	Object dao = findById(obj);
    	if (dao==null) {
			throw new ServiceException("当前数据不存在，请刷新重试！");
		}
    	dao = EntityUtils.p2d(obj, dao, flag);
    	mapper.getClass()
    	.getMethod(METHOD_NAME_EDIT,obj.getClass())
    	.invoke(mapper,dao);
		return dao;
    }
    @Override
    public Object findById(Object obj) throws Exception{
    	Field field = obj.getClass().getDeclaredField("id");
    	field.setAccessible(true);
    	int id = (int) field.get(obj);
    	Object result = (Object) mapper.getClass()
    			              .getMethod(METHOD_NAME_FINDBYID,int.class)
    			              .invoke(mapper,id);
		return result;
    }

}

