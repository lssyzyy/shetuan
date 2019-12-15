package com.shetuan.bean;

import java.util.Date;

public class Community {
	//社团ID
	private String clubId;
	//社团名
	private String clubName;
	//社团创建时间
	private String creatername;
	private Date createtime;
	//社团人数
	private int clubNum;
	private String clubInform;
	private float clubFinance;
	private String clubPlace;
	private String createrid;
	private int iscreate;
	private int clubClassid;
	private String clubClassname;
	
	
	public String getClubId() {
		return clubId;
	}
	public void setClubId(String clubId) {
		this.clubId = clubId;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getClubNum() {
		return clubNum;
	}
	public void setClubNum(int clubNum) {
		this.clubNum = clubNum;
	}
	public String getClubInform() {
		return clubInform;
	}
	public void setClubInform(String clubInform) {
		this.clubInform = clubInform;
	}
	public float getClubFinance() {
		return clubFinance;
	}
	public void setClubFinance(float clubFinance) {
		this.clubFinance = clubFinance;
	}
	public String getClubPlace() {
		return clubPlace;
	}
	public void setClubPlace(String clubPlace) {
		this.clubPlace = clubPlace;
	}
	public String getCreaterid() {
		return createrid;
	}
	public void setCreaterid(String createrid) {
		this.createrid = createrid;
	}
	public int getIscreate() {
		return iscreate;
	}
	public void setIscreate(int iscreate) {
		this.iscreate = iscreate;
	}
	public int getClubClassid() {
		return clubClassid;
	}
	public void setClubClassid(int clubClassid) {
		this.clubClassid = clubClassid;
	}
	public String getCreatername() {
		return creatername;
	}
	public void setCreatername(String creatername) {
		this.creatername = creatername;
	}
	public String getClubClassname() {
		return clubClassname;
	}
	public void setClubClassname(String clubClassname) {
		this.clubClassname = clubClassname;
	}
	
}
