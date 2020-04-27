package com.server.chbw.part.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.chbw.entity.Firm;
import com.server.chbw.entity.Part;
import com.server.chbw.part.service.IPartService;
import com.server.chbw.util.Layui;
import com.server.chbw.util.PageRequest;
import com.server.chbw.util.ResData;

@RestController
@RequestMapping("part")
public class PartController {
	
	@Autowired
	private IPartService partService;
	
	@RequestMapping("partList")
	public Object partList(Part part,PageRequest pageRequest) {
		try {
//			if (firmid!=null&&firmid.intValue()!=0) {
//				Firm firm = new Firm();
//				firm.setId(firmid);
//				part.setFirm(firm);
//			}
			System.out.println(part);
			System.out.println(partService.partList(part,pageRequest).get("count"));
			return partService.partList(part,pageRequest);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	
	@RequestMapping("add")
	public Object add(@RequestBody Part part) {
		int status = 0;
		String msg = "添加失败";
		try {
			status = partService.addPart(part);
		} catch (Exception e) {
			msg = e.getMessage();
			System.out.println(e.getMessage());
		}
		
		return ResData.data(status, msg);
	}
	
	@RequestMapping("edit")
	public Object edit(@RequestBody Part part) {
		int status = 0;
		String msg = "";
		try {
			status = partService.partEditOrDelete(part,false);///false表示修改
		} catch (Exception e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		
		return ResData.data(status, msg);
	}
	
	@RequestMapping("delete")
	public Object delete(@RequestBody Part part) {
		int status = 0;
		String msg = "";
		try {
			status = partService.partEditOrDelete(part,true);//true表示删除
		} catch (Exception e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		
		return ResData.data(status, msg);
	}

}
