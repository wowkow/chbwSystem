package com.server.chbw.firm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.server.chbw.entity.Firm;

@Mapper
public interface FirmMapper {
    //获取厂商列表
	List<Firm> list(Firm firm);
	/**
	 * 根据id获取原材料
	 * @param id
	 * @return
	 */
	Firm findById(int id);
	//厂商新增
	int add(Firm firm);
	//厂商修改
	int edit(Firm firm);

}
