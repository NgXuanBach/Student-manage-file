package com.manage.handle;

import java.util.LinkedList;

import com.manage.model.Student;

public interface IStudentHandler {
	public void add(Student student, LinkedList<Student> studentList);

	public void show(LinkedList<Student> studentList);

	public void editStudent(int findId, LinkedList<Student> studentList);

	public void sortStudentByGpa(LinkedList<Student> studentList);

	public void sortStudentByName(LinkedList<Student> studentList);

	public void deleteStudent(int idDelete, LinkedList<Student> studentList);
}
