package com.manage.model;

import java.util.LinkedList;

import com.manage.constant.Constant;

public class Lop {
	private int id;
	private String name;
	private LinkedList<Student> studentList;
	private int quantity = 0;

	public Lop() {
	}

	public Lop(int id, String name, int quantity, LinkedList<Student> studentList) {
		super();
		this.id = id;
		this.name = name;
		this.studentList = studentList;
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

	public void setQuantily(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public LinkedList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(LinkedList<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + Constant.REGEX_SPLIT_STRING + name + Constant.REGEX_SPLIT_STRING + quantity;
	}

	public void addStudent(Student student) {
		studentList.add(student);
		quantity++;
	}

}
