package com.server.chbw.firm.service;

import com.server.chbw.entity.Firm;
import com.server.chbw.entity.Part;
import com.server.chbw.util.Layui;
import com.server.chbw.util.PageRequest;
import com.server.chbw.util.ServiceException;

public interface IFirmService {
	
	//获取厂商列表
	Layui firmList(Firm firm,PageRequest pageRequest) throws Exception;
	//厂商新增
	int addFirm(Firm firm) throws Exception;
	/**
	 * 修改删除
	 * @param part
	 * @param flag true表示删除
	 * @return
	 * @throws Exception 
	 */
	int editOrdeleteFirm(Firm firm,boolean flag) throws Exception;

}
