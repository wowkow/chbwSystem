package com.server.chbw.entity;

import java.util.Date;

/**
 * 厂商类
 * @author wangz
 *
 */
public class Firm {
	private int id;
	private String firmName;     //厂商名称
	private Date createtime;        //创建时间
	private Date updatetime;        //修改时间
	private String isvalidate;   //是否有效 1有效  0无效
	private String note;         //备注
	private String type;         //类型
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Firm [id=" + id + ", firmName=" + firmName + ", createtime=" + createtime + ", updatetime=" + updatetime
				+ ", isvalidate=" + isvalidate + ", note=" + note + ", type=" + type + "]";
	}

}
