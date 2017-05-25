package com.mademeng.bean;

public class Message {

	private int id;
	private String accountid;
	private int bz;
	private int money;
	private String accountidto;
	private String transfertime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public int getBz() {
		return bz;
	}
	public void setBz(int bz) {
		this.bz = bz;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	public String getAccountidto() {
		return accountidto;
	}
	public void setAccountidto(String accountidto) {
		this.accountidto = accountidto;
	}
	public String getTransfertime() {
		return transfertime;
	}
	public void setTransfertime(String transfertime) {
		this.transfertime = transfertime;
	}
	

}
