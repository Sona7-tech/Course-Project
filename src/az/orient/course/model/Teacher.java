package az.orient.course.model;

import java.util.Date;

public class Teacher extends CourseModel {
	
	private String name;
	private String surname;
	private String address;
	private String phone;
	private Date dob;
	private Integer workExperience;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Integer getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(Integer workExperience) {
		this.workExperience = workExperience;
	}
	@Override
	public String toString() {
		return name + " " + surname;
	}
	
	

}
