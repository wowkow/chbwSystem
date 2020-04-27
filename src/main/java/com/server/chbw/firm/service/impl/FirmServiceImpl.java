package com.server.chbw.firm.service.impl;


import org.springframework.stereotype.Service;

import com.server.chbw.base.service.impl.BaseServiceImpl;
import com.server.chbw.entity.Firm;
import com.server.chbw.firm.mapper.FirmMapper;
import com.server.chbw.firm.service.IFirmService;
import com.server.chbw.util.Layui;
import com.server.chbw.util.PageRequest;
@Service
public class FirmServiceImpl extends BaseServiceImpl<FirmMapper> implements IFirmService{

	@Override
	public Layui firmList(Firm firm, PageRequest pageRequest) throws Exception {
		return this.list(firm, pageRequest);
	}

	@Override
	public int addFirm(Firm firm) throws Exception {
		int status = 0;
		Object obj = this.add(firm);
		if (obj!=null) {
			status = 1;
		}
		return status;
	}

	@Override
	public int editOrdeleteFirm(Firm firm, boolean flag) throws Exception {
		int status = 0;
		Object obj = this.editOrDelete(firm, flag);
		if (obj!=null) {
			status = 1;
		}
		return status;
	}

}
