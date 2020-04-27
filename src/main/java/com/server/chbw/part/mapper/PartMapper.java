package com.server.chbw.part.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.server.chbw.entity.Part;

@Mapper
public interface PartMapper {
	//获取原材料列表
	List<Part> list(Part part);
	/**
	 * 根据id获取原材料
	 * @param id
	 * @return
	 */
	Part findById(int id);
	//原材料新增
	int add(Part part);
	//原材料修改
	int edit(Part part);
    
}
