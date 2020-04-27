package com.server.chbw.entity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * 原材料类
 * @author wangz
 *
 */
public class Part {
	private int id;                 //id
	private String part_name;       //物料名称
	private String source;          //来源
	private String type;            //类型
	private Firm firm;              //厂家
	private int firmid;             //厂家ID
	private String unit;            //计量单位
	private Date createtime;        //创建时间
	private Date updatetime;        //修改时间
	private String isvalidate;      //是否有效
	private String safetime;        //保质期
	private String note;            //备注
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Firm getFirm() {
		return firm;
	}
	public void setFirm(Firm firm) {
		this.firm = firm;
	}
	public int getFirmid() {
		return firmid;
	}
	public void setFirmid(int firmid) {
		this.firmid = firmid;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getIsvalidate() {
		return isvalidate;
	}
	public void setIsvalidate(String isvalidate) {
		this.isvalidate = isvalidate;
	}
	public String getSafetime() {
		return safetime;
	}
	public void setSafetime(String safetime) {
		this.safetime = safetime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Part [id=" + id + ", part_name=" + part_name + ", source=" + source + ", type=" + type + ", firm="
				+ firm + ", unit=" + unit + ", createtime=" + createtime + ", updatetime=" + updatetime
				+ ", isvalidate=" + isvalidate + ", safetime=" + safetime + ", note=" + note + "]";
	}
    
}
