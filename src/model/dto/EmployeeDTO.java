package model.dto;

import java.sql.Date;

public class EmployeeDTO {
	private int employee_id;
	private String first_name;
	private String last_name;
	private int sex;
	private Date DOB;
	private String address;
	private String POB;
	private String phone;
	private String email;
	private String social_network;
	private String nationality;
	private int marital_status;
	private int user_id;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPOB() {
		return POB;
	}
	public void setPOB(String pOB) {
		POB = pOB;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSocial_network() {
		return social_network;
	}
	public void setSocial_network(String social_network) {
		this.social_network = social_network;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public int getMarital_status() {
		return marital_status;
	}
	public void setMarital_status(int marital_status) {
		this.marital_status = marital_status;
	}
	
}
