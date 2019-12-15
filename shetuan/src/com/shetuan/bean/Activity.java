package com.shetuan.bean;

import java.util.Date;

public class Activity {
	//社团活动Id
	private String activityId;
	//社团名称
	private String mainclub;
	private String adminId;
	//活动名称
	private String activityName;
	private float finance;
	private String introduction;
	//活动照片存储路径
	private String activityPhoto;
	private Date starttime;
	private Date endtime;
	private String place;
	private String place1;
	private String place2;
	private int hold;
	private String status;
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public float getFinance() {
		return finance;
	}
	public void setFinance(float finance) {
		this.finance = finance;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getActivityPhoto() {
		return activityPhoto;
	}
	public void setActivityPhoto(String activityPhoto) {
		this.activityPhoto = activityPhoto;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getMainclub() {
		return mainclub;
	}
	public void setMainclub(String mainclub) {
		this.mainclub = mainclub;
	}
	public int getHold() {
		return hold;
	}
	public void setHold(int hold) {
		this.hold = hold;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPlace1() {
		return place1;
	}
	public void setPlace1(String place1) {
		this.place1 = place1;
	}
	public String getPlace2() {
		return place2;
	}
	public void setPlace2(String place2) {
		this.place2 = place2;
	}

}
