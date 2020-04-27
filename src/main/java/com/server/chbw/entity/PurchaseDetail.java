package com.server.chbw.entity;
/**
 * 采购明细
 * @author wangz
 *
 */

import java.math.BigDecimal;
import java.util.Date;

public class PurchaseDetail {
	private int id;               
	private int orderid;            //采购单id
	private int partid;             //材料id
	private String code;            //批次号
	private int number;              //数量
	private BigDecimal price;        //单价
	private BigDecimal summoney;     //金额
	private Date production;         //生产日期
	private Date createtime;        //创建时间
	private Date updatetime;        //修改时间
	private String isvalidate;   //是否有效 1有效  0无效
	private String note;         //备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getPartid() {
		return partid;
	}
	public void setPartid(int partid) {
		this.partid = partid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getSummoney() {
		return summoney;
	}
	public void setSummoney(BigDecimal summoney) {
		this.summoney = summoney;
	}
	public Date getProduction() {
		return production;
	}
	public void setProduction(Date production) {
		this.production = production;
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
	

}
