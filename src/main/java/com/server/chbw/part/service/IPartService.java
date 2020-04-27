package com.server.chbw.part.service;


import com.server.chbw.entity.Part;
import com.server.chbw.util.Layui;
import com.server.chbw.util.PageRequest;
import com.server.chbw.util.ResData;
import com.server.chbw.util.ServiceException;

public interface IPartService {
	//获取原材料列表
	Layui partList(Part part,PageRequest pageRequest) throws Exception;
	//原材料新增
	int addPart(Part part) throws Exception;
	//原材料修改或删除
	/**
	 * 修改删除
	 * @param part
	 * @param flag true表示删除
	 * @return
	 * @throws ServiceException
	 * @throws Exception 
	 */
	int partEditOrDelete(Part part,boolean flag) throws ServiceException, Exception;
	//物料数据插入
	void addtest() throws Exception;
}
