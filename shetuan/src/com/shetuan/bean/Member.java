package com.shetuan.bean;

import java.util.Date;

public class Member {
	//登录名
	private String loginName;
	//登录权限
	private int managerId;
	private String password;
	//成员姓名
	private String memberName;
	//成员头像存储路径
	private String memberHeader;
	//成员性别
	private String sex;
	//成员年级
	private Date birthday;
	private String grade;
	//成员学院
	private String memberInstitute;
	//成员地址
	private String address;
	//成员邮箱
	private String email;
	//成员电话
	private String phonenumber;

	private String interest;
	private String joinclub;
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberHeader() {
		return memberHeader;
	}

	public void setMemberHeader(String memberHeader) {
		this.memberHeader = memberHeader;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMemberInstitute() {
		return memberInstitute;
	}

	public void setMemberInstitute(String memberInstitute) {
		this.memberInstitute = memberInstitute;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getJoinclub() {
		return joinclub;
	}

	public void setJoinclub(String joinclub) {
		this.joinclub = joinclub;
	}
	
	
}
