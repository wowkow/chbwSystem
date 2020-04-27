package com.server.chbw.part.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.server.chbw.base.service.impl.BaseServiceImpl;
import com.server.chbw.entity.Firm;
import com.server.chbw.entity.Part;
import com.server.chbw.part.mapper.PartMapper;
import com.server.chbw.part.service.IPartService;
import com.server.chbw.util.Layui;
import com.server.chbw.util.PageRequest;
import com.server.chbw.util.ServiceException;
import com.server.chbw.util.StringUtil;

@Service
@Transactional
public class PartServiceImpl extends BaseServiceImpl<PartMapper> implements IPartService {
	@Autowired
	private PartMapper partMapper;
	@Override
	public Layui partList(Part part,PageRequest pageRequest) throws Exception {
		return this.list(part, pageRequest);
	}

//	@Override
//	public int add(Part part) {
//		Date date = new Date(); 
//		int status = 0;
//		part.setCreatetime(date);
//		part.setUpdatetime(date);
//		part.setIsvalidate("1");
//		if (partMapper.add(part)==1) {
//			status = 1;
//		}
//		return status;
//	}
	@Override
	public int addPart(Part part) throws Exception {
		int status = 0;
		Object obj = this.add(part);
		if (obj!=null) {
			status = 1;
		}
		return status;
	}
	
	@Override
	public void addtest() throws Exception{
		System.out.println("开始测试");
		for (int i = 0; i < 500; i++) {
			System.out.println(i);
			Part part = new Part();
			Date date = new Date(); 
			Firm firm = new Firm();
			firm.setId(1);
			firm.setFirmName("测试厂商"+i);
//			int status = 0;
			part.setCreatetime(date);
			part.setUpdatetime(date);
			part.setIsvalidate("1");
			part.setPart_name("测试物料"+i);
			
			part.setSafetime(""+i);
			part.setSource("外购");
			if (i<100) {
				part.setType("辅料");
				part.setUnit("个");
				part.setNote("测试数据");
			}else if (i>=100&&i<=200) {
				part.setType("原料");
				part.setUnit("斤");
			}else if (i>200&&i<=350) {
				part.setType("包材");
				part.setUnit("斤");
			}else {
				part.setType("添加剂");
				part.setUnit("个");
				part.setNote("测试数据");
			}
			part.setFirm(firm);
			partMapper.add(part);
		}
	}
	
	/**
     * 调用分页插件完成分页
     * @param pageQuery
     * @return
     */
    private PageInfo<Part> getPartInfo(Part part,PageRequest pageRequest) {
        int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        List<Part> partList = partMapper.list(part);
        return new PageInfo<Part>(partList);
    }
    @Override
	public int partEditOrDelete(Part part,boolean flag) throws Exception {
		int status = 0;
		Object obj = this.editOrDelete(part, flag);
		if (obj!=null) {
			status = 1;
		}
		return status;
	}

//	@Override
//	public int editOrdelete(Part part,boolean flag) throws ServiceException {
//		int status = 0;
//		Part dbPart = partMapper.getPartById(part.getId());
//		setValue(part, dbPart);
//		Date date = new Date(); 
//		part.setUpdatetime(date);
//		if (flag) {
//			dbPart.setIsvalidate("0");
//		}
//		if (partMapper.edit(dbPart)==1) {
//			status = 1;
//		}
//		return status;
//	}
	private static void setValue(Part part,Part dbPart) throws ServiceException {
		if (part==null||part.getId()==0) {
			throw new ServiceException("系统错误，请刷新重试！");
		}
		if (dbPart==null) {
			throw new ServiceException("当前数据不存在，请刷新重试！");
		}
		if (!StringUtil.isEmpty(part.getPart_name())) {
			dbPart.setPart_name(part.getPart_name());
		}
		if (!StringUtil.isEmpty(part.getSource())) {
			dbPart.setSource(part.getSource());
		}
		if (!StringUtil.isEmpty(part.getType())) {
			dbPart.setType(part.getType());
		}
		if (!StringUtil.isEmpty(part.getUnit())) {
			dbPart.setUnit(part.getUnit());
		}
		if (!StringUtil.isEmpty(part.getSafetime())) {
			dbPart.setSafetime(part.getSafetime());
		}
		if (!StringUtil.isEmpty(part.getNote())) {
			dbPart.setNote(part.getNote());
		}
	}

}
