package com.manage.model;

import com.manage.constant.Constant;

public class Student {
	private int id;
	private String name;
	private int age;
	private String address;
	private float gpa;
	private int idClass;

	public Student() {
	}

	public Student(int id, String name, int age, String address, float gpa, int idClass) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gpa = gpa;
		this.idClass = idClass;
	}

	public int getIdClass() {
		return idClass;
	}

	public void setIdClass(int idClass) {
		this.idClass = idClass;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getGpa() {
		return gpa;
	}

	@Override
	public String toString() {
		return id + Constant.REGEX_SPLIT_STRING + idClass + Constant.REGEX_SPLIT_STRING + name
				+ Constant.REGEX_SPLIT_STRING + age + Constant.REGEX_SPLIT_STRING + address
				+ Constant.REGEX_SPLIT_STRING + gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

}
