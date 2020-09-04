package com.member;

public class MemberVO {
	
	private String name;
	private String userid;
	private String pwd;
	private String phone;
	private String email;
	private int admin;
	
	private String admin_id;
	private String admin_pwd;
	
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name == null ? "" : name.trim();
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid == null ? "" : userid.trim();
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd == null ? "" : pwd.trim();
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone == null ? "" : phone.trim();
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email == null ? "" : email.trim();
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the admin
	 */
	public int getAdmin() {
		return admin;
	}
	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	/**
	 * @return the admin_id
	 */
	public String getAdmin_id() {
		return admin_id == null ? "" : admin_id.trim();
	}
	/**
	 * @param admin_id the admin_id to set
	 */
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	/**
	 * @return the admin_pwd
	 */
	public String getAdmin_pwd() {
		return admin_pwd == null ? "" : admin_pwd.trim();
	}
	/**
	 * @param admin_pwd the admin_pwd to set
	 */
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	
	
	
}


		