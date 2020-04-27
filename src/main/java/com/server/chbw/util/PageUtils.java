package com.server.chbw.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.server.chbw.entity.Part;

public class PageUtils {
	 /**
     * 将分页信息封装到统一的接口
     * @param pageRequest 
     * @param page
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
    
    public static Layui getLayui(PageRequest pageRequest, PageInfo<?> pageInfo) {
    	return Layui.data(pageInfo.getTotal(), pageInfo.getList());
    }
    
    /**
     * 
     * @param obj
     * @param pageRequest
     * @param mapper
     * @param clazz
     * @param method
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws RuntimeException
     */
    public static Layui getPartInfo(Object obj,PageRequest pageRequest,Object mapper,String method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, RuntimeException {
        int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        List<Object> objList = (List<Object>) mapper.getClass().getMethod(method,obj.getClass()).invoke(mapper,obj);
        PageInfo<Object> pageInfo = new PageInfo<Object>(objList);
        return Layui.data(pageInfo.getTotal(), pageInfo.getList());
    }

}
