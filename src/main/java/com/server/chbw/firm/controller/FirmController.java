package com.server.chbw.firm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.chbw.entity.Firm;

import com.server.chbw.firm.service.IFirmService;

import com.server.chbw.util.PageRequest;
import com.server.chbw.util.ResData;
@RestController
@RequestMapping("firm")
public class FirmController {
	@Autowired
	private IFirmService firmService;
	
	@RequestMapping("firmList")
	public Object partList(Firm firm,PageRequest pageRequest) {
		try {
			System.out.println(firm);
			System.out.println(firmService.firmList(firm,pageRequest).get("count"));
			return firmService.firmList(firm,pageRequest);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	@RequestMapping("add")
	public Object add(@RequestBody Firm firm) {
		int status = 0;
		String msg = "添加失败";
		try {
			status = firmService.addFirm(firm);
		} catch (Exception e) {
			msg = e.getMessage();
			System.out.println(e.getMessage());
		}
		
		return ResData.data(status, msg);
	}
	
	@RequestMapping("edit")
	public Object edit(@RequestBody Firm firm) {
		int status = 0;
		String msg = "";
		try {
			status = firmService.editOrdeleteFirm(firm,false);///false表示修改
		} catch (Exception e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		
		return ResData.data(status, msg);
	}
	
	@RequestMapping("delete")
	public Object delete(@RequestBody Firm firm) {
		int status = 0;
		String msg = "";
		try {
			status = firmService.editOrdeleteFirm(firm,true);//true表示删除
		} catch (Exception e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		
		return ResData.data(status, msg);
	}

}
