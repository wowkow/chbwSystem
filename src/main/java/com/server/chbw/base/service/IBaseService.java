package com.server.chbw.base.service;

import com.server.chbw.util.Layui;
import com.server.chbw.util.PageRequest;

public interface IBaseService {

	/**
	 * 查找对象列表
	 * @param obj   参数对象
	 * @param pageRequest   分页请求对象
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws RuntimeException
	 */
	Layui list(Object obj, PageRequest pageRequest) throws Exception;
    /**
     * 删除或者修改对象
     * @param obj   参数对象
     * @param flag   是否删除  true-删除
     * @return
     * @throws Exception
     */
	Object editOrDelete(Object obj, boolean flag) throws Exception;
	/**
	 * 
	 * @param obj 要保存的对象
	 * @return
	 * @throws Exception
	 */
	Object add(Object obj) throws Exception;
	/**
	 * 根据id获取对象
	 * @param obj 通过对象将id传入
	 * @return
	 * @throws Exception
	 */
	Object findById(Object obj) throws Exception;

}
