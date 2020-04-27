package com.server.chbw.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购单
 * @author wangz
 *
 */
public class PurchaseOrder {
	private int id;
	private String code;
	private Firm firm;
	private int firmid;
	private String consignee;
	private String transporter;
	private Date purchasedate;
	private BigDecimal purchaseamount;
	private String note;
	private String isvalidate;
	private Date createtime;
	private Date updatetime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getTransporter() {
		return transporter;
	}
	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}
	public Date getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}
	public BigDecimal getPurchaseamount() {
		return purchaseamount;
	}
	public void setPurchaseamount(BigDecimal purchaseamount) {
		this.purchaseamount = purchaseamount;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getIsvalidate() {
		return isvalidate;
	}
	public void setIsvalidate(String isvalidate) {
		this.isvalidate = isvalidate;
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
	

}
