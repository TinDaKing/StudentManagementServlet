package model;

import java.sql.Date;

public class Student {
	private int id;
	private String name;
	private double grade;
	private Date birthday;
	private String address;
	private String note;
	
	
	
	public Student(int id, String name, double grade, Date birthday, String address, String note) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.birthday = birthday;
		this.address = address;
		this.note = note;
	}
	
	public Student(int id, String name, double grade, Date birthday, String address) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.birthday = birthday;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", birthday=" + birthday + ", address="
				+ address + ", note=" + note + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
